package com.geogym.www;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.common.service.AjaxService;
import com.geogym.user.dto.LoginInfo;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired private UserService userServ;
	@Autowired private AjaxService ajaxServ;
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public void loginForm() {
	}

	@RequestMapping(value = "/ajax/login", method = RequestMethod.POST)
	public void login(LoginInfo info) {
		try {
			userServ.login(info);
			ajaxServ.sendSuccess();
		} catch (UserNotFoundException e) {
			ajaxServ.sendFail();
		}
		return;
	}

	@RequestMapping(value = "/user/logout")
	public String logout() {
		userServ.logout();
		return "/test/user/login";
	}
}
