package com.geogym.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.payment.enumeration.Currency;
import com.geogym.payment.service.TicketService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class TicketIssueController {
	
	@Autowired TicketService ticketService;
	@Autowired UserService userService;
	
	// 이용권 발권
	@RequestMapping(value="/issue/ticket", method=RequestMethod.POST)
	public String issueTicket(int monthLength){
		
		User user;
		try {
			user = userService.getLoggedInUser();
		} catch (UserNotFoundException e) {
			return "redirect:/";
		}
		
		int price=0;
		
		switch (monthLength) {
		case 1:
			price=100000;
			break;
		case 3:
			price=270000;
			break;
		case 6:
			price=480000;
			break;
		case 12:
			price=840000;
			break;

		default:
			return "redirect:/error/pay";
		}
		
		ticketService.issueTicket(user, monthLength, price, Currency.ONLINE);
		
		return "redirect:/mypage/main";
	}
	
	// PT 이용권 발권

}
