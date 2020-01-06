package com.geogym.www.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.pt.dto.PT;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.exception.AllTimeisUnavailable;
import com.geogym.schedule.exception.InvalidParamException;
import com.geogym.schedule.exception.NotWorkinDayException;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

@Controller
public class ScheduleTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduleTestController.class);
	
	@Autowired ScheduleService scheduleService;
	
	// --- 트레이너의 비어있는 스케줄 얻어오기 -------------------------------------
	@RequestMapping(value="/test/shedule/workingtime")
	public void getWorkingTime() {
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		
		LocalDate localDate = LocalDate.of(2019, 12, 30);
		
		List<LocalTime> list = new ArrayList<LocalTime>();;
		
		try {
			list = scheduleService.getAvilableTime(trainer, localDate);
		} catch (InvalidParamException e) {
			return;
		} catch (AllTimeisUnavailable e) {
			return;
		} catch (NotWorkinDayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info(list.toString());
	}
	
	@RequestMapping(value="/test/shedule/workingtime/fail")
	public void getWorkingTimeFail() {
		
		// 실패 코드입니다
		// DB에 없는 트레이너 번호를 입력시
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(99);
		
		LocalDate localDate = LocalDate.of(2019, 12, 30);
		
		List<LocalTime> list;
		
		try {
			list = scheduleService.getAvilableTime(trainer, localDate);
		} catch (InvalidParamException e) {
			return;
		} catch (AllTimeisUnavailable e) {
			return;
		} catch (NotWorkinDayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// -----------------------------------------------------------------------
	
	
	// --- 일반 스케줄 추가 ------------------------------------------------------
	@RequestMapping(value="/test/setshedule")
	public void setSchedule() {
		
		Schedule schedule = new Schedule();
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);

		schedule.setTrainer(trainer);
		schedule.setSchedule_date(LocalDate.of(2019, 12, 30));
		schedule.setSchedule_from(LocalTime.of(13, 00));
		schedule.setSchedule_to(LocalTime.of(14, 00));
		schedule.setSchedule_msg("아오 짜증난다");
		
		try {
			scheduleService.setSchedule(schedule);
		} catch (InvalidParamException e) {
			// 올바르지 않은 파라미터
		} catch (AllTimeisUnavailable e) {
			// 이용가능 시간 없음
		} catch (NotWorkinDayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// -------------------------------------------------------------------------
	
	
	// --- PT 스케줄 추가 ------------------------------------------------------
	@RequestMapping(value="/test/setPTshedule")
	public void setPTSchedule(
			Schedule schedule,
			Trainer trainer,
			User user) {
		
		logger.info(schedule.toString());
		logger.info(trainer.toString());
		logger.info(user.toString());

		schedule.setSchedule_msg("테스트테스트");

		schedule.setTrainer(trainer);
		
		try {
			scheduleService.setPTShcedule(user, schedule);
		} catch (InvalidParamException e) {
			// 올바르지 않은 파라미터
		} catch (AllTimeisUnavailable e) {
			// 이용 가능 시간 없음
		} catch (NotWorkinDayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// -------------------------------------------------------------------------
	
	// --- PT 가능시간만 받아오기 ---------------------------------------------------
	@RequestMapping(value="/test/getPTavilable")
	public void getPTavilable() {
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		
		LocalDate localDate = LocalDate.of(2020, 01, 02);
		
		List<LocalTime> list = new ArrayList<LocalTime>();;
		
		try {
			list = scheduleService.getPTAvilableTime(trainer, localDate);
		} catch (AllTimeisUnavailable e) {
			return;
		} catch (NotWorkinDayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info(list.toString());
	}
	
	
	//--------------------------------------------------------------------------
	
	
	// --- PT 취소 --------------------------------------------------------------
	@RequestMapping(value="/test/cancelPT")
	public void cancelPT() {
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		User user = new User();
		user.setUser_no(12);
		
		LocalDateTime localDateTime = LocalDateTime.of(2019, 12, 31, 10, 00);
		
		scheduleService.cancelPTSchedule(trainer, user, localDateTime);
	}
	// --------------------------------------------------------------------------
	
	// --- PT 리스트 --------------------------------------------------------------
	@RequestMapping(value="/test/ptlist")
	public void ptList() {
		
		User user = new User();
		user.setUser_no(12);

		LocalDate localDate = LocalDate.of(2019,12,01);
		
//		logger.info(LocalDate.of(2019,02,01).lengthOfMonth()+"");
		List<PT> list = scheduleService.getPTScheduleByMonth(user, localDate);
	}
	// --------------------------------------------------------------------------

}