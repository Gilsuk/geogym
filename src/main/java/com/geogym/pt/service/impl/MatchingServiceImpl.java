package com.geogym.pt.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.payment.exception.CashNotEnoughException;
import com.geogym.payment.service.CashService;
import com.geogym.payment.service.PaymentLogService;
import com.geogym.payment.service.TicketService;
import com.geogym.pt.dao.MatchingDao;
import com.geogym.pt.dto.PT;
import com.geogym.pt.exception.LessThanOneHourException;
import com.geogym.pt.exception.MatchingNotAvailable;
import com.geogym.pt.service.MatchingService;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.exception.AllTimeisUnavailable;
import com.geogym.schedule.exception.InvalidParamException;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.service.TrainerService;
import com.geogym.user.dto.User;

@Service
public class MatchingServiceImpl implements MatchingService {

	@Autowired MatchingDao matchingDao;
	@Autowired ScheduleService scheduleService;
	@Autowired CashService coinService;
	@Autowired TicketService tickectService;
	@Autowired TrainerService trainerService;
	@Autowired PaymentLogService paymentLogService;
	
	@Override
	public void match(User user, Schedule schedule) throws MatchingNotAvailable, CashNotEnoughException, AllTimeisUnavailable {
		
		try {
			if(tickectService.hasPTTicket(user, schedule.getTrainer())) {
				tickectService.payByTicket(user, schedule.getTrainer());
			} else {
				schedule.setTrainer(trainerService.getTrainer(schedule.getTrainer()));
				
				//로그 입력 필요
				
				coinService.payByCash(schedule.getTrainer().getTrainer_price(), user);
			}
			
			scheduleService.setPTShcedule(user, schedule);
			
		} catch (InvalidParamException e) {
			throw new MatchingNotAvailable();
		}
	}
	
	@Override
	public void cancle(Schedule schedule, String msg) throws LessThanOneHourException {
		
		Schedule scheduleInfo = matchingDao.selectSchedule(schedule);
		
		if(scheduleInfo.getSchedule_from().isAfter(LocalTime.now().minusHours(1))) {
			throw new LessThanOneHourException();
		}
		
		PT pt = matchingDao.selectUserByscheduleNo(scheduleInfo);
		
		scheduleService.cancelPTSchedule(
				scheduleInfo.getTrainer(), 
				pt.getUser(), 
				LocalDateTime.of(scheduleInfo.getSchedule_date(),scheduleInfo.getSchedule_from()));
		
		if(pt.getPt_type_no() == 2) {

			tickectService.refundPTTicket(pt.getUser(), schedule.getTrainer());
		} else if(pt.getPt_type_no() == 3){
			
			//로그 입력 필요
			
			Trainer trainer = trainerService.getTrainer(schedule.getTrainer());
			
			coinService.refundCash(trainer.getTrainer_price(), pt.getUser());
		}
	}

	@Override
	public List<PT> getPTInfos(User user, LocalDate today) {
		
		return scheduleService.getPTScheduleByMonth(user, today);
	}

	
	//-----------------------------------------------------------------
	@Override
	public boolean isSubscribedTrainer(User user, Trainer trainer) {
		
		boolean hasPTTicket = tickectService.hasPTTicket(user, trainer);
		
		return hasPTTicket;
	}

	@Override
	public int ptMemberWithTrainer(Trainer trainer) {
		
		return tickectService.getCountUser(trainer);
	}

	@Override
	public int getPTcount(Trainer trainer, LocalDate month) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("trainer_no", trainer.getTrainer_no());
		map.put("start", LocalDate.of( month.getYear(), month.getDayOfMonth(), 1));
		map.put("end", LocalDate.of( month.getYear(), month.getDayOfMonth(), month.lengthOfMonth()));
		
		return matchingDao.selectCountPT(map);
	}
	@Override
	public int countptpermonse(Trainer trainer, LocalDate month) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("trainer_no",trainer.getTrainer_no());
		map.put("start",LocalDate.of(month.getYear(), month.getMonthValue(), 1));
		map.put("end",LocalDate.of(month.getYear(), month.getMonthValue(), month.lengthOfMonth()));
		return matchingDao.selectCntPTBytrainer(map);
	}
}