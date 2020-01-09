package com.geogym.www;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geogym.message.dto.Message;
import com.geogym.message.service.MessageService;
import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.dto.Ticket;
import com.geogym.payment.service.CashService;
import com.geogym.payment.service.TicketService;
import com.geogym.qna.dto.Paging;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class MyPageController {

	@Autowired UserService userservice;
	@Autowired TicketService ticketService;
	@Autowired CashService cashService;
	@Autowired MessageService messageService;
	
	@RequestMapping(value = "/mypage/main")
	public void myPage(Model model) {
		
		User user = new User();
		
		try {
			user = userservice.getLoggedInUser();
		} catch (UserNotFoundException e) {
		}
		
		boolean isTrainer = userservice.isTrainer(user);
		boolean isManager = userservice.isManager(user);
		
		Ticket ticket = new Ticket();
		List<PTTicket> list = new ArrayList<PTTicket>();
		int cash = 0;
		
		if(isTrainer == false && isManager == false) {
			ticket = ticketService.getTicket(user);
			list = ticketService.getPTTicketList(user);
			cash = cashService.getCashAmount(user);
		}
		
		model.addAttribute("user", user);
		model.addAttribute("ticket", ticket);
		model.addAttribute("list", list);
		model.addAttribute("cash", cash);
		model.addAttribute("isTrainer", isTrainer);
		model.addAttribute("isManager", isManager);
	}
	
	@RequestMapping(value = "/mypage/messagelist")
	public void messagelist(Model model, User user, 
			@RequestParam(defaultValue = "0") int offset) {
		
		try {
			user = userservice.getLoggedInUser();
		} catch (UserNotFoundException e) {
		}
		
		int totalCount = messageService.getMessageCount(user.getUser_no());
		
		Paging paging = new Paging(totalCount, offset+1);
		
		List<Message> list = messageService.getMessages(user, 30, offset);
		
		boolean isTrainer = userservice.isTrainer(user);
		boolean isManager = userservice.isManager(user);
		
		model.addAttribute("isTrainer", isTrainer);
		model.addAttribute("isManager", isManager);
		
		model.addAttribute("list", list);
	}
}
