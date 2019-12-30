package com.geogym.www.test;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.schedule.dto.BusinessDay;
import com.geogym.schedule.service.BusinessDayService;

@Controller
public class BusinessDayController {

	private static final Logger logger = LoggerFactory.getLogger(BusinessDayController.class);

	@Autowired
	BusinessDayService businessDayService;

	@RequestMapping(value = "/test/isbusinessday")
	public void isBusinessDay() {

		LocalDate date = LocalDate.of(2020, 01, 15);

		boolean is = false;

		try {
			is = businessDayService.isWorkingDay(date);
		} catch (NullPointerException e) {
			logger.info("잘못된 파라미터");
		}

		logger.info(is + "");
	}

	@RequestMapping(value = "/test/setbusinessday")
	public void setBusinessDay() {

		LocalDate date = LocalDate.of(2020, 02, 15);

		BusinessDay workingTime = new BusinessDay();
		workingTime.setBusiness_day_starttime(LocalTime.of(06, 00));
		workingTime.setBusiness_day_endtime(LocalTime.of(18, 00));

		try {
			businessDayService.setWorkingTime(date, workingTime);
		} catch (NullPointerException e) {
			logger.info("잘못된 파라미터");
		}

	}

	@RequestMapping(value = "/test/getbusinessday")
	public void getBusinessDay() {

		LocalDate date = LocalDate.of(2020, 02, 18);

		try {
			logger.info(businessDayService.getWorkingTimeInfo(date).toString());
		} catch (NullPointerException e) {
			logger.info("잘못된 파라미터");
		}

	}
	
	@RequestMapping(value = "/test/getbusinessdaylist")
	public void getBusinessDayList() {
		LocalDate date = LocalDate.of(2019, 12, 15);
		
		logger.info(businessDayService.getWorkingTimeInfos(date).toString());
	}
}