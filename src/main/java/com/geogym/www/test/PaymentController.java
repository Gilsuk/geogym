package com.geogym.www.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.payment.service.TicketService;
import com.geogym.schedule.exception.InvalidParamException;
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
		
		try {
			boolean isHasTicket = ticketService.hasPTTicket(user, trainer);

			if (!isHasTicket) {
				// PT이용권이 없을 때
				return;
			}
			
			//PT 이용권이 있을 때
			
		} catch (InvalidParamException e) {
			//잘못된 파라미터
		}
		
	}
	
}
