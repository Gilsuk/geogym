package com.geogym.www.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;

@Controller
public class ScheduleTestController {
	
	@Autowired ScheduleService scheduleService;
	
	@RequestMapping(value="/test/shedule/workingtime")
	public void getWorkingTime() {
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		
		LocalDate localDate = LocalDate.of(2019, 12, 30);
		
		scheduleService.getAvilableTime(trainer, localDate);
	}
	
}