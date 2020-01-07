package com.geogym.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dto.LoginInfo;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired private UserService userServ;
	
	@RequestMapping(value = "/user/login",method = RequestMethod.GET)
	public void loginForm() {
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/user/login", method = RequestMethod.POST)
	public boolean login(LoginInfo info) {
		try {
			userServ.login(info);
			return true;
		} catch (UserNotFoundException e) {
			return false;
		}
	}

	@RequestMapping(value = "/user/logout")
	public String logout() {
		userServ.logout();
		return "/";
	}
	
	@RequestMapping(value = "/user/join", method = RequestMethod.GET)
	public void joinForm() {
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/user/join", method = RequestMethod.POST)
	public boolean join(User user) {
		try {
			userServ.join(user);
			return true;
		} catch (ParamIncorrectException e) {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/user/searchbyid", method = RequestMethod.POST)
	public User searchbyuserid(User user) {
		try {
			return userServ.getUserByUserid(user);
			
		} catch (UserNotFoundException e) {
			User anonymous = new User();
			anonymous.setUser_name("없는 사용자");
			return anonymous;
		}

	}
}
