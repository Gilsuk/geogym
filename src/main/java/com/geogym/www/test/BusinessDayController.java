package com.geogym.www.test;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	@RequestMapping(value = "/test/setbusinessday" ,method = RequestMethod.GET)
	public void setBusiness() {
		
	}
	
	
	@RequestMapping(value = "/test/setbusinessday" ,method = RequestMethod.POST)
	public void setBusinessDay(BusinessDay businessDay) {

		LocalDate date = businessDay.getBusiness_day_date();

		BusinessDay workingTime = new BusinessDay();
		workingTime.setBusiness_day_starttime(businessDay.getBusiness_day_starttime());
		workingTime.setBusiness_day_endtime(businessDay.getBusiness_day_endtime());

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