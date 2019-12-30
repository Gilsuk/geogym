package com.geogym.www;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.calendar.dto.CalendarDto;
import com.geogym.calendar.dto.Day;
import com.geogym.calendar.dto.Holiday;
import com.geogym.calendar.service.CalendarService;
import com.geogym.schedule.dto.BusinessDay;
import com.geogym.schedule.service.BusinessDayService;
import com.google.gson.Gson;

@Controller
public class CalendarController {

	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	@Autowired CalendarService calendarService;
	@Autowired BusinessDayService businessDayService;
	
	@RequestMapping(value = "/calendar/set", method = RequestMethod.GET)
	public void  getSpecialDate(Model model) {
		
	}
	
	
	@RequestMapping(value = "/calendar/set", method = RequestMethod.POST)
	public void postSpecialDate(CalendarDto calendarDto) {
		
		for (int i = 0; i < 12; i++) {
			String month = String.valueOf(LocalDate.now().plusMonths(i).getMonthValue());
			if(month.length()==1)
				month = "0" + month;
			
			String url = calendarService.geturl(String.valueOf(LocalDate.now().plusMonths(i).getYear()),
					month);
			System.out.println("주소"+url);
			calendarService.insertholiday(url);
			
		}

	}
	
	
	@RequestMapping(value = "/calendar/main" , method = RequestMethod.GET)
	public void maincalendar(Holiday holiday,Model model,Day day) {
		
		List<Holiday> selectholiday = calendarService.selectholiday();
		
		
		logger.info(selectholiday.toString());
		
	
		
		
		

		LocalDate month = LocalDate.now();
		List<Day> listDay = calendarService.getDayList(month);
		logger.info("리스트데이"+listDay.toString());
		
		model.addAttribute("listDay", new Gson().toJson(listDay));
		
		//영업시간 
//		List<BusinessDay> listWorking = businessDayService.getWorkingTimeInfos(date);
		
		
		

	}
	
	
	
	
	
}
