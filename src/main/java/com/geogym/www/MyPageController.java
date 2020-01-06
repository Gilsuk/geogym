package com.geogym.www;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.dto.Ticket;
import com.geogym.payment.service.CashService;
import com.geogym.payment.service.TicketService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class MyPageController {

	@Autowired UserService userservice;
	@Autowired TicketService ticketService;
	@Autowired CashService cashService;
	
	@RequestMapping(value = "/mypage/main")
	public void myPage(Model model) {
		
		User user = new User();
		
		try {
			user = userservice.getLoggedInUser();
		} catch (UserNotFoundException e) {
		}
		
		Ticket ticket = ticketService.getTicket(user);
		List<PTTicket> list = ticketService.getPTTicketList(user);
		int cash = cashService.getCashAmount(user);
		
		boolean isTrainer = userservice.isTrainer(user);
		boolean isManager = userservice.isManager(user);
		
		model.addAttribute("user", user);
		model.addAttribute("ticket", ticket);
		model.addAttribute("list", list);
		model.addAttribute("cash", cash);
		model.addAttribute("isTrainer", isTrainer);
		model.addAttribute("isManager", isManager);
	}
	
}
