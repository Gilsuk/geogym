package com.geogym.www.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.common.exception.DuplicatedException;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class UserTestController {
	
	@Autowired UserService serv;

	@RequestMapping(value = "/test/user/getuserbyuserno")
	public void getUserByUserno() {
		User user = new User();
		user.setUser_no(12);

		try {
			serv.getUserByUserno(user);
		} catch (UserNotFoundException e) { }
	}
	
	@RequestMapping(value = "/test/user/join", method = RequestMethod.GET)
	public String joinForm() {
		
		User user;
		try {
			user = serv.getLoggedInUser();
			// 이미 로그인 한 사용자가 회원가입을 시도할 때 처리
			return "redirect:/";

		} catch (UserNotFoundException e) { }
		
		return "/user/join";

	}

	@RequestMapping(value = "/user/join", method = RequestMethod.POST)
	public void join(User user) {
		
		System.out.println(user);
		
		try {
			serv.signUp(user);
		} catch (DuplicatedException e) {
			e.printStackTrace();
		} catch (ParamIncorrectException e) {
			e.printStackTrace();
		}
		

	}
}
