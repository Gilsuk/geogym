package com.geogym.www;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.payment.exception.FailPayException;
import com.geogym.payment.service.CashService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class PaymentController {
	
	@Autowired
	private UserService userSrv;
	@Autowired
	private CashService cashSrv;

	@RequestMapping(value = "/payment/form", method = RequestMethod.GET)
	public String paymentForm(Model model, HttpServletRequest req) {
		try {
			User user = userSrv.getLoggedInUser();
			model.addAttribute("user", user);
			model.addAttribute("domain_url", "http://" + req.getHeader("Host"));

			return "/payment/form";
		} catch (UserNotFoundException e) {
			return "/user/login";
		}
	}

	@RequestMapping(value = "/payment/complete/*")
	public String paymentComplete(Model model) {
		
		try {
			cashSrv.chargeCash();
			return "/payment/success";
		} catch (FailPayException e) {
			return "/payment/fail";
		}

	}
	
}
