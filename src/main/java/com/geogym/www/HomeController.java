package com.geogym.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class HomeController {
	
	@SuppressWarnings(value = "unused")
	private static final Logger logger =
	LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/")
	public String home() {
		try {
			userService.getLoggedInUser();
		} catch (UserNotFoundException e) { }
		return "home";
	}
	
}
