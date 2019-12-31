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
import com.geogym.calendar.dto.Calendar_Memo;
import com.geogym.calendar.dto.Day;
import com.geogym.calendar.dto.Holiday;
import com.geogym.calendar.service.CalendarService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;
import com.google.gson.Gson;

@Controller
public class CalendarController {

	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	@Autowired CalendarService calendarService;
	@Autowired private UserService userServ;

	
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
		
		

	}
	
	
	@RequestMapping(value="/calendar/memo",method = RequestMethod.GET)
	public void calendarmemo() {
		
	}
	
	
	@RequestMapping(value="/calendar/memo",method = RequestMethod.POST)
	public String calendarmemoProc(Calendar_Memo calendar_Memo) {
		User loggedInUser=null;
		try {
			loggedInUser = userServ.getLoggedInUser();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return "redirect:/test/user/login";
		}
		int user_no =loggedInUser.getUser_no();
		calendar_Memo.setUser_no(user_no);
		calendarService.insertMemo(calendar_Memo);
		
		return "redirect:/calendar/memo";
		
	}
	
	@RequestMapping(value="/calendar/list",method = RequestMethod.GET)
	public void calendarmemolist(Model model) {
		List<Calendar_Memo> memolist = calendarService.memoList();
		logger.info(memolist.toString());
	}
	
	
	@RequestMapping(value="/calendar/update",method = RequestMethod.GET)
	public void calendarmemoupdate(Calendar_Memo calendar_Memo,Model model) {
		
		calendar_Memo = calendarService.memoview(calendar_Memo);
		model.addAttribute("calendar_Memo", calendar_Memo);
		
		
	}
	
	
	public String calendarmemoupdateProc(Calendar_Memo calendar_Memo) {
			calendarService.updatememo(calendar_Memo);
			
		
		return "";
	}
}
