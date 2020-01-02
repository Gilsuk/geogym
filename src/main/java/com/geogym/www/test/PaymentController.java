package com.geogym.www.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.service.TicketService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

@Controller
public class PaymentController {

	@Autowired TicketService ticketService;
	
	@RequestMapping(value="/payment/ticket/get")
	public void getTicket() {
		
		User user = new User();
		user.setUser_no(13);
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(13);
		
		boolean isHasTicket = ticketService.hasPTTicket(user, trainer);

		if (!isHasTicket) {
			// PT이용권이 없을 때
			return;
		}
		
	}
	
	@RequestMapping(value="/payment/ticket/list")
	public void getCount() {
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		int num = ticketService.getCountUser(trainer);
		
	}
	
	@RequestMapping(value="/payment/ticket/issue")
	public void issuePTTicket() {
		
		PTTicket ptTicket = new PTTicket();
		
		User user = new User();
		user.setUser_no(2);
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_no(1);
		
		ptTicket.setUser(user);
		ptTicket.setTrainer(trainer);
		ptTicket.setPt_ticket_expire(LocalDate.of(2020, 12, 30));
		ptTicket.setPt_ticket_amount(5);
		
		ticketService.issuePTTicket(ptTicket);
		
	}
	
}
