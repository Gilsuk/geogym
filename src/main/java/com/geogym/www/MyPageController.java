package com.geogym.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class MyPageController {

	@Autowired UserService userservice;
	
	@RequestMapping(value = "/mypage/main")
	public void myPage(Model model) {
		
		User user = new User();
		
		try {
			user = userservice.getLoggedInUser();
		} catch (UserNotFoundException e) {
		}
		
		boolean isTrainer = userservice.isTrainer(user);
		boolean isManager = userservice.isManager(user);
		
		model.addAttribute("user_no", user.getUser_no());
		model.addAttribute("isTrainer", isTrainer);
		model.addAttribute("isManager", isManager);
	}
	
}
