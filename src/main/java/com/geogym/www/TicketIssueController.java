package com.geogym.www;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.enumeration.Currency;
import com.geogym.payment.enumeration.Product;
import com.geogym.payment.exception.CashNotEnoughException;
import com.geogym.payment.service.CashService;
import com.geogym.payment.service.TicketService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Controller
public class TicketIssueController {
	
	@Autowired CashService cashService;
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
		
		ticketService.issueTicket(user, monthLength, price, Currency.CASH);
		
		return "redirect:/mypage/main";
	}
	
	// PT 이용권 발권
	@RequestMapping(value="/issue/ptticket")
	public String issuePTTicket(Trainer trainer, PTTicket ptTicket, int price) {
		
		User user = new User();
		
		try {
			user = userService.getLoggedInUser();
		} catch (UserNotFoundException e) {
			return "redirect:/trainer/list";
		}
		
		ptTicket.setUser(user);
		ptTicket.setTrainer(trainer);
		ptTicket.setPt_ticket_expire(LocalDate.now().plusYears(1));
		
		switch (ptTicket.getPt_ticket_amount()) {
		case 5:
			price = (int) (price*ptTicket.getPt_ticket_amount()*0.9);
			break;
		case 10:
			price = (int) (price*ptTicket.getPt_ticket_amount()*0.8);
			break;
		case 15:
			price = (int) (price*ptTicket.getPt_ticket_amount()*0.7);
			break;

		default:
			return "redirect:/trainer/list";
		}
		
		try {
			cashService.payByCash(price, user, Product.PTTICKET);
		} catch (CashNotEnoughException e) {
			return "redirect:/trainer/list";
		}
		
		ticketService.issuePTTicket(ptTicket, price);
		
		return "redirect:/mypage/main";
	}

}
