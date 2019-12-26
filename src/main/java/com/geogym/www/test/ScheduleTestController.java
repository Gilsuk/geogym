package com.geogym.www.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.pt.dto.PT;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.exception.InvalidParamException;
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
		
		LocalDate localDate = LocalDate.of(2020, 01, 01);
		
		List<LocalTime> list;
		
		try {
			list = scheduleService.getAvilableTime(trainer, localDate);
		} catch (InvalidParamException e) {
			return;
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
		}
	}
	
	// -----------------------------------------------------------------------
	
	
	// --- 일반 스케줄 추가 ------------------------------------------------------
	@RequestMapping(value="/test/setshedule")
	public void setSchedule() {
		
		Schedule schedule = new Schedule();
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		
		schedule = scheduleService.getScheduleByParam(
				trainer, LocalDate.of(2020, 01, 01), LocalTime.of(12, 00), LocalTime.of(13, 00), "test2");
		
		scheduleService.setSchedule(schedule);
	}
	
	// -------------------------------------------------------------------------
	
	
	// --- PT 스케줄 추가 ------------------------------------------------------
	@RequestMapping(value="/test/setPTshedule")
	public void setPTSchedule() {
		
		Schedule schedule = new Schedule();
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		
		User user = new User();
		
		user.setUser_no(12);
		
		schedule = scheduleService.getScheduleByParam(
				trainer, LocalDate.of(2019, 12, 31), LocalTime.of(10, 00), LocalTime.of(12, 00), "테스트으");
		
		scheduleService.setPTShcedule(user, schedule);
	}
	
	// -------------------------------------------------------------------------
	
	// --- PT 가능시간만 받아오기 ---------------------------------------------------
	@RequestMapping(value="/test/getPTavilable")
	public void getPTavilable() {
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		
		LocalDate localDate = LocalDate.of(2020, 01, 02);
		
		List<LocalTime> list;
		
		list = scheduleService.getPTAvilableTime(trainer, localDate);
		
		logger.info(list.toString());
	}
	
	
	//--------------------------------------------------------------------------
	
	
	// --- PT 취소 --------------------------------------------------------------
	@RequestMapping(value="/test/calcelPT")
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
		
		logger.info(list.toString());
	}
	// --------------------------------------------------------------------------

}