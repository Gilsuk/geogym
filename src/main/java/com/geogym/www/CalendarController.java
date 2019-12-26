package com.geogym.www;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.geogym.calendar.dto.CalendarDto;
import com.geogym.calendar.service.CalendarService;

@Controller
public class CalendarController {

	
	@Autowired CalendarService calendarService;
	
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
}
