package com.geogym.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dto.LoginInfo;
import com.geogym.user.dto.User;
import com.geogym.user.enumeration.Social;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired private UserService userServ;
	
	@RequestMapping(value = "/user/login",method = RequestMethod.GET)
	public void loginForm() {
	}

	@ResponseBody
	@RequestMapping(value = "/user/login/google")
	public boolean loginByGoogle(String id_token) {

		try {
			userServ.login(id_token, Social.GOOGLE);
			return true;
		} catch (UserNotFoundException e) {
			return false;
		}
		
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
		return "redirect:/";
	}
	
	@RequestMapping(value = "/user/join", method = RequestMethod.GET)
	public void joinForm() {
	}

	@RequestMapping(value = "/user/join/google")
	public String googleJoinForm(Model model, String id_token, String user_email, String user_name) {
		
		model.addAttribute("id_token", id_token);
		model.addAttribute("user_email", user_email);
		model.addAttribute("user_name", user_name);

		return "/user/google";
	}

	@ResponseBody
	@RequestMapping(value = "/user/join/google/proc")
	public boolean googleJoinProc(Model model, String id_token, User user) {
		
		user.setUser_pw("randompw");
		try {
			userServ.join(user);
			userServ.linkSocial(userServ.getUserByUserid(user), id_token, Social.GOOGLE);
			return true;
		} catch (Exception e) {
			return false;
		}
		
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
	
	@ResponseBody
	@RequestMapping(value = "/user/check/id", method = RequestMethod.POST)
	public boolean checkIfDuplicatedId(String param_user) {
		return userServ.isIdDuplicated(param_user);
	}

	@ResponseBody
	@RequestMapping(value = "/user/check/email", method = RequestMethod.POST)
	public boolean checkIfDuplicatedEmail(String param_user) {
		return userServ.isEmailDuplicated(param_user);
	}

	@RequestMapping(value="/static/map")
	public void map() {
		
	}

}
