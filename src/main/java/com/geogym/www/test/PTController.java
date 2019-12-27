package com.geogym.www.test;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.pt.exception.LessThanOneHourException;
import com.geogym.pt.exception.MatchingNotAvailable;
import com.geogym.pt.service.MatchingService;
import com.geogym.schedule.dto.Schedule;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

@Controller
public class PTController {

	private static final Logger logger = LoggerFactory.getLogger(PTController.class);

	@Autowired
	MatchingService matchingService;

	@RequestMapping(value = "/test/setpt")
	public void getWorkingTime() {

		User user = new User();
		user.setUser_no(10);

		Trainer trainer = new Trainer();
		trainer.setTrainer_no(2);

		Schedule schedule = new Schedule();
		schedule.setTrainer(trainer);
		schedule.setSchedule_date(LocalDate.of(2019, 12, 30));
		schedule.setSchedule_from(LocalTime.of(12, 00));
		schedule.setSchedule_msg("PT");

		try {
			matchingService.match(user, schedule);
		} catch (MatchingNotAvailable e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/test/pt/cancelPT")
	public void cancelPT() {

		Schedule schedule = new Schedule();
		schedule.setSchedule_no(9);

		try {
			matchingService.cancle(schedule, "PT취소");
		} catch (LessThanOneHourException e) {
			// 취소 신청시간 기점 PT시간 까지 1시간 미만 남았을 경우
		}

	}
	
	@RequestMapping(value = "/test/pt/list")
	public void getPTList() {
		
		User user = new User();
		user.setUser_no(10);
		
		LocalDate today = LocalDate.of(2020,01,30);
		
		logger.info(matchingService.getPTInfos(user, today).toString());
	}

}