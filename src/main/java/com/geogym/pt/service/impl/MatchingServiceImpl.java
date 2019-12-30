package com.geogym.pt.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.pt.dao.MatchingDao;
import com.geogym.pt.dto.PT;
import com.geogym.pt.exception.LessThanOneHourException;
import com.geogym.pt.exception.MatchingNotAvailable;
import com.geogym.pt.service.MatchingService;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.exception.InvalidParamException;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

@Service
public class MatchingServiceImpl implements MatchingService {

	@Autowired MatchingDao matchingDao;
	@Autowired ScheduleService scheduleService;
//	@Autowired CoinService coinService;
//	@Autowired TicketService tickectService;
	
	@Override
	public void match(User user, Schedule schedule) throws MatchingNotAvailable {
		
		try {
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
	}

	@Override
	public List<PT> getPTInfos(User user, LocalDate today) {
		
		return scheduleService.getPTScheduleByMonth(user, today);
	}

	
	//-----------------------------------------------------------------
	@Override
	public boolean isSubscribedTrainer(User user, Trainer trainer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ptJoin(Trainer trainer, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ptMemberWithTraner(Trainer trainer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCoinTraner(Trainer trainer, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}