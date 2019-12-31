package com.geogym.www;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.geogym.calendar.dto.CalendarDto;
import com.geogym.calendar.dto.Calendar_Memo;
import com.geogym.calendar.dto.Day;
import com.geogym.calendar.service.CalendarService;
import com.geogym.pt.dto.PT;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.service.BusinessDayService;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;
import com.google.gson.Gson;

@Controller
public class CalendarController {

	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	@Autowired
	CalendarService calendarService;
	@Autowired
	BusinessDayService businessDayService;
	@Autowired
	ScheduleService scheduleService;

	@Autowired private UserService userServ;

	
	@RequestMapping(value = "/calendar/set", method = RequestMethod.GET)
	public void getSpecialDate(Model model) {

	}

	@RequestMapping(value = "/calendar/set", method = RequestMethod.POST)
	public void postSpecialDate(CalendarDto calendarDto) {

		for (int i = 0; i < 12; i++) {
			String month = String.valueOf(LocalDate.now().plusMonths(i).getMonthValue());
			if (month.length() == 1)
				month = "0" + month;

			String url = calendarService.geturl(String.valueOf(LocalDate.now().plusMonths(i).getYear()), month);
			System.out.println("주소" + url);
			calendarService.insertholiday(url);

		}

	}

	@RequestMapping(value = "/calendar/main", method = RequestMethod.GET)
	public void maincalendar(Model model, 
			@RequestParam(defaultValue = "-999999999-01-01") LocalDate date) {

		if(date.equals(LocalDate.MIN)) {
			date = LocalDate.now();
		}

		List<Day> listDay = calendarService.getDayList(date);

		model.addAttribute("listDay", new Gson().toJson(listDay));
		model.addAttribute("nextMonth", "/calendar/main?date="+date.plusMonths(1));
		model.addAttribute("prevMonth", "/calendar/main?date="+date.minusMonths(1));
		model.addAttribute("curMonth", date);
		
	}

	@RequestMapping(value = "/calendar/view", method = RequestMethod.GET)
	public void viewcalendar(Model model, LocalDate date, User user, Trainer trainer) {
		
		user.setUser_no(1);
		
		List<LocalTime> list = scheduleService.getPTAvilableTime(trainer, date);
		
		model.addAttribute("day", date);
		model.addAttribute("list", list);
		model.addAttribute("user_no", user.getUser_no());
		model.addAttribute("trainer_no", trainer.getTrainer_no());
	}
	
	
	@RequestMapping(value = "/calendar/PT", method = RequestMethod.GET)
	public String ptcalendar(Model model, 
			@RequestParam(defaultValue = "-999999999-01-01") LocalDate date
			, User user
			, Trainer trainer) {

		if(date.equals(LocalDate.MIN)) {
			date = LocalDate.now();
		}
		
		List<Day> listDay = calendarService.getDayList(date);
		
		List<PT> timeList = scheduleService.getPTScheduleByMonth(user, date);
		
		listDay = calendarService.setPTToList(listDay, timeList);
		
		model.addAttribute("listDay", new Gson().toJson(listDay));
		model.addAttribute("nextMonth", "/calendar/PT?trainer_no="+trainer.getTrainer_no()+"&user_no="+user.getUser_no()+"&date="+date.plusMonths(1));
		model.addAttribute("prevMonth", "/calendar/PT?trainer_no="+trainer.getTrainer_no()+"&user_no="+user.getUser_no()+"&date="+date.minusMonths(1));
		model.addAttribute("curMonth", date);
		model.addAttribute("trainer_no", trainer.getTrainer_no());
		
		logger.info(timeList.toString());
		
		return "/calendar/main";
	}
	
	@RequestMapping(value = "/calendar/schedule", method = RequestMethod.GET)
	public String schedulecalendar(Model model, 
			@RequestParam(defaultValue = "-999999999-01-01") LocalDate date
			, Trainer trainer) {
		
		if(date.equals(LocalDate.MIN)) {
			date = LocalDate.now();
		}
		
		List<Day> listDay = calendarService.getDayList(date);
		
		List<Schedule> timeList = scheduleService.getSchedule(trainer, date);
		
		listDay = calendarService.setPTToList(listDay, timeList);
		
		model.addAttribute("listDay", new Gson().toJson(listDay));
		model.addAttribute("nextMonth", "/calendar/PT?user_no="+trainer.getTrainer_no()+"&date="+date.plusMonths(1));
		model.addAttribute("prevMonth", "/calendar/PT?user_no="+trainer.getTrainer_no()+"&date="+date.minusMonths(1));
		model.addAttribute("curMonth", date);
		
		logger.info(timeList.toString());
		
		return "/calendar/main";
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
	
	@RequestMapping(value="/calendar/update",method = RequestMethod.POST)
	public String calendarmemoupdateProc(Calendar_Memo calendar_Memo) {
			calendarService.updatememo(calendar_Memo);
			
		
		return "redirect:/calendar/list";
	}
}
