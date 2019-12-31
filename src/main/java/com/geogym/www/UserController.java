package com.geogym.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dto.LoginInfo;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired private UserService userServ;
	
	@RequestMapping(value = "/user/login")
	public void loginForm() {
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/user/login")
	public boolean login(LoginInfo info) {
		try {
			userServ.login(info);
			return true;
		} catch (UserNotFoundException e) {
			return false;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/user/logout")
	public boolean logout() {
		userServ.logout();
		return true;
	}
	
	@RequestMapping(value = "/user/join")
	public void joinForm() {
	}

	@ResponseBody
	@RequestMapping(value = "/ajax/user/join")
	public boolean join(User user) {
		try {
			userServ.join(user);
			return true;
		} catch (ParamIncorrectException e) {
			return false;
		}
	}

}
