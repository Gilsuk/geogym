package com.geogym.www;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
import com.geogym.schedule.exception.AllTimeisUnavailable;
import com.geogym.schedule.exception.NotWorkinDayException;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.service.TrainerService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;
import com.google.gson.Gson;

@Controller
public class CalendarController {

	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private UserService userServ;
	@Autowired
	private TrainerService trainerService;

	@RequestMapping(value = "/calendar/set", method = RequestMethod.GET)
	public void getSpecialDate(Model model) {

	}

	@RequestMapping(value = "/calendar/set", method = RequestMethod.POST)
	public String postSpecialDate(CalendarDto calendarDto) {

		for (int i = 0; i < 12; i++) {
			String month = String.valueOf(LocalDate.now().plusMonths(i).getMonthValue());
			if (month.length() == 1)
				month = "0" + month;

			String url = calendarService.geturl(String.valueOf(LocalDate.now().plusMonths(i).getYear()), month);
			System.out.println("주소" + url);
			calendarService.insertholiday(url);

		}
		return "/test/setbusinessday";
	}

	@RequestMapping(value = "/calendar/main", method = RequestMethod.GET)
	public void maincalendar(Model model, @RequestParam(defaultValue = "-999999999-01-01") LocalDate date) {

		if (date.equals(LocalDate.MIN)) {
			date = LocalDate.now();
		}

		List<Day> listDay = calendarService.getDayList(date);

		model.addAttribute("listDay", new Gson().toJson(listDay));
		model.addAttribute("nextMonth", "/calendar/main?date=" + date.plusMonths(1));
		model.addAttribute("prevMonth", "/calendar/main?date=" + date.minusMonths(1));
		model.addAttribute("curMonth", date);

	}

	@RequestMapping(value = "/calendar/view/PTrequest")
	public String viewcalendar(Model model, LocalDate date, User user, Trainer trainer) {

		List<LocalTime> list = new ArrayList<LocalTime>();
		try {
			list = scheduleService.getPTAvilableTime(trainer, date);
		} catch (AllTimeisUnavailable e) {
			return "redirect:/calendar/PT/request";
		} catch (NotWorkinDayException e) {
		}
		
		List<LocalDate> week = scheduleService.getTwoWeek(date);
		
//		List<Integer> dayList = new ArrayList<Integer>();
		
//		for(int i = 0; i < week.size(); i++ ) {
//			dayList.add(week.get(i).getDayOfMonth());
//		}
		
		logger.info(week.toString());
		
		model.addAttribute("day", date);
		model.addAttribute("week", week);
//		model.addAttribute("dayList", dayList);
		model.addAttribute("list", list);
		model.addAttribute("user_no", user.getUser_no());
		model.addAttribute("trainer_no", trainer.getTrainer_no());

		return "/calendar/view";
	}

	@RequestMapping(value = "/calendar/PT/request")
	public String ptcalendar(Model model, @RequestParam(defaultValue = "-999999999-01-01") LocalDate date, User user,
			Trainer trainer) {
		

		try {
			user = userServ.getLoggedInUser();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
		if (date.equals(LocalDate.MIN)) {
			date = LocalDate.now();
		}
		trainer = trainerService.getTrainer(trainer);

		List<Day> listDay = calendarService.getDayList(date);
		
		logger.info(listDay.toString());
		
		List<Schedule> timeList = scheduleService.getAttendance(trainer, date);
		
		listDay = calendarService.setPTToList(listDay, timeList);

		model.addAttribute("listDay", new Gson().toJson(listDay));
		model.addAttribute("nextMonth", "/calendar/PT/request?trainer_no=" + trainer.getTrainer_no() + "&user_no="
				+ user.getUser_no() + "&date=" + date.plusMonths(1));
		model.addAttribute("prevMonth", "/calendar/PT/request?trainer_no=" + trainer.getTrainer_no() + "&user_no="
				+ user.getUser_no() + "&date=" + date.minusMonths(1));
		model.addAttribute("curMonth", date);
		model.addAttribute("trainer", trainer);
		model.addAttribute("trainer_no", trainer.getTrainer_no());
		model.addAttribute("user_no", user.getUser_no());
		model.addAttribute("viewLink",
				"/calendar/view/PTrequest?trainer_no=" + trainer.getTrainer_no() + "&user_no=" + user.getUser_no());
		model.addAttribute("request", true);

		return "/calendar/main";
	}

	@RequestMapping(value = "/calendar/schedule", method = RequestMethod.GET)
	public String schedulecalendar(Model model, @RequestParam(defaultValue = "-999999999-01-01") LocalDate date,
			Trainer trainer) {

		if (date.equals(LocalDate.MIN)) {
			date = LocalDate.now();
		}

		List<Day> listDay = calendarService.getDayList(date);

		List<Schedule> timeList = scheduleService.getAttendance(trainer, date);

		listDay = calendarService.setPTToList(listDay, timeList);

		model.addAttribute("listDay", new Gson().toJson(listDay));
		model.addAttribute("nextMonth",
				"/calendar/PT?user_no=" + trainer.getTrainer_no() + "&date=" + date.plusMonths(1));
		model.addAttribute("prevMonth",
				"/calendar/PT?user_no=" + trainer.getTrainer_no() + "&date=" + date.minusMonths(1));
		model.addAttribute("curMonth", date);
		model.addAttribute("viewLink", "/calendar/view/schedule?trainer_no=" + trainer.getTrainer_no());
		
		User user;
		try {
			user = userServ.getLoggedInUser();
			model.addAttribute("user", user);
			model.addAttribute("isTrainer", userServ.isTrainer(user));
			model.addAttribute("isManager", userServ.isManager(user));
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info(timeList.toString());

		return "/calendar/schedule";
	}
	
	@RequestMapping(value = "/calendar/view/schedule", method = RequestMethod.GET)
	public String viewSchedulecalendar(Model model, LocalDate date, Trainer trainer) {

		List<Schedule> list = scheduleService.getSchedule(trainer, date);
		
		model.addAttribute("day", date);
		model.addAttribute("list", list);
		model.addAttribute("trainer_no", trainer.getTrainer_no());
		

		return "/calendar/shceduleview";
	}

	
	
	@RequestMapping(value = "/calendar/memo", method = RequestMethod.POST)
	public String calendarmemoProc(Calendar_Memo calendar_Memo, int user_no) {
		
		calendar_Memo.setUser_no(user_no);
		
		logger.info(calendar_Memo.getCalendar_memo_content());
		
		calendarService.insertMemo(calendar_Memo);

		return "redirect:/calendar/memolist?user_no="+user_no;

	}

	@RequestMapping(value = "/calendar/memolist", method = RequestMethod.GET)
	public String calendarmemolist(Model model, @RequestParam(defaultValue = "-999999999-01-01") LocalDate date,
			User user) {
		
		if (date.equals(LocalDate.MIN)) {
			date = LocalDate.now();
		}
		
		List<Day> listDay = calendarService.getDayList(date);
		
		List<Calendar_Memo> memolist = calendarService.getmemo(user, date);
		
		listDay = calendarService.simplificationList(calendarService.setPTToList(listDay, memolist));
		
		boolean isTrainer = userServ.isTrainer(user);
		boolean isManager = userServ.isManager(user);
		
		model.addAttribute("isTrainer", isTrainer);
		model.addAttribute("isManager", isManager);
		
		model.addAttribute("listDay", new Gson().toJson(listDay));
		model.addAttribute("nextMonth",
				"/calendar/memolist?user_no=" + user.getUser_no() + "&date=" + date.plusMonths(1));
		model.addAttribute("prevMonth",
				"/calendar/memolist?&user_no=" + user.getUser_no() + "&date=" + date.minusMonths(1));
		model.addAttribute("curMonth", date);
		model.addAttribute("user", user);
		model.addAttribute("viewLink", "/calendar/viewmemo?user_no=" + user.getUser_no());
		model.addAttribute("pageName", "memo");
		
		logger.info(memolist.toString());
		
		return "/calendar/inMypage";
	}

	@RequestMapping(value = "/calendar/update", method = RequestMethod.GET)
	public void calendarmemoupdate(Calendar_Memo calendar_Memo, Model model) {

		calendar_Memo = calendarService.memoview(calendar_Memo);
		model.addAttribute("calendar_Memo", calendar_Memo);

	}

	@RequestMapping(value = "/calendar/update", method = RequestMethod.POST)
	public String calendarmemoupdateProc(Calendar_Memo calendar_Memo) {
		calendarService.updatememo(calendar_Memo);

		return "redirect:/calendar/list";
	}

	@RequestMapping(value = "/calendar/PT/schedule", method = RequestMethod.GET)
	public String ptschedulecalendar(Model model, @RequestParam(defaultValue = "-999999999-01-01") LocalDate date,
			User user) {

		try {
			user = userServ.getLoggedInUser();
		} catch (UserNotFoundException e) {
		}
		
		if (date.equals(LocalDate.MIN)) {
			date = LocalDate.now();
		}

		List<Day> listDay = calendarService.getDayList(date);

		List<PT> timeList = scheduleService.getPTScheduleByMonth(user, date);

		listDay = calendarService.setPTToList(listDay, timeList);

		boolean isTrainer = userServ.isTrainer(user);
		boolean isManager = userServ.isManager(user);
		
		model.addAttribute("isTrainer", isTrainer);
		model.addAttribute("isManager", isManager);
		
		model.addAttribute("listDay", new Gson().toJson(listDay));
		model.addAttribute("nextMonth",
				"/calendar/PT/schedule?user_no=" + user.getUser_no() + "&date=" + date.plusMonths(1));
		model.addAttribute("prevMonth",
				"/calendar/PT/schedule?&user_no=" + user.getUser_no() + "&date=" + date.minusMonths(1));
		model.addAttribute("curMonth", date);
		model.addAttribute("user", user);
		model.addAttribute("viewLink", "/calendar/viewmemo?user_no=" + user.getUser_no());
		model.addAttribute("pageName", "PT");
		
		return "/calendar/inMypage";
	}
	
	@RequestMapping(value = "/calendar/viewmemo", method = RequestMethod.GET)
	public String viewMemocalendar(Model model, LocalDate date, int user_no) {

		User user = new User();
		user.setUser_no(user_no);
		
		User loggedInUser = new User();
		
		try {
			loggedInUser = userServ.getLoggedInUser();
		} catch (UserNotFoundException e) {
		}
		
		Calendar_Memo memo = calendarService.getOneMemo(user, date);
		
		model.addAttribute("day", date);
		model.addAttribute("memo", memo);
		model.addAttribute("user_no", user.getUser_no());
		model.addAttribute("isTrainer", userServ.isTrainer(loggedInUser));

		return null;
	}
}
