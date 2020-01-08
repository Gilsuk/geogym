package com.geogym.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geogym.attachment.service.AttachmentService;
import com.geogym.schedule.dto.Attendance;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.service.TrainerService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.TrainerNotFoundException;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class AdminController {

	@Autowired
	TrainerService trainerService;
	@Autowired
	UserService userService;
	@Autowired
	AttachmentService attachmentService;
	@Autowired
	ScheduleService scheduleService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	// 검사해서 트레이너라면 트레이너 메인 페이지로, 관리자면 관리자 페이지로 이동
	@RequestMapping(value = "/admin/main", method = RequestMethod.GET)
	private String TrainerList(Model model) {
		logger.info("/admin/main");
		try {
			User user = userService.getLoggedInUser();

			if (userService.isTrainer(user)) {
				Trainer trainer = trainerService.getTrainertoUser(user);
				model.addAttribute("trainer", trainer);
				model.addAttribute("user", user);
				return "/admin/trainermain";
			} else if (userService.isManager(user)) {				
				model.addAttribute("user", user);
				return "/admin/adminmain";
			}else {
				return "redirect:/";
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			return "redirect:/";
		}

	}
	
	@RequestMapping(value="/admin/insertWorkHour", method = RequestMethod.GET)
	public void insertWorkHour() {
		
	}
	
	@RequestMapping(value="/admin/insertWorkHour", method = RequestMethod.POST)
	public String insertWorkHourProc(int user_no,Attendance attendance) {
		
		
		
		attendance.setTrainer_no(user_no);
		
//		Trainer trainer=trainerService.selectbyuser_no(user_no);
		
		scheduleService.insertWorkHour(attendance);
		
		return "/admin/insertWorkHour";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajax/trainer/searchbyid", method = RequestMethod.POST)
	public User searchbyuserid(User user) {
		User uuser = trainerService.selectbyuser_no(user);
		try {
			System.out.println("uuser 확인:  "+uuser);
			return trainerService.selectbytrain_no(uuser);
			
		} catch (TrainerNotFoundException e) {
			// TODO Auto-generated catch block
			User anonymous = new User();
			anonymous.setUser_name("없는트레이너입니다");;
			return anonymous;
			
		}

	}
	
	
}
