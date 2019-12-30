package com.geogym.payment.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.payment.dao.TicketDao;
import com.geogym.payment.dto.Ticket;
import com.geogym.payment.dto.TicketChangesInfo;
import com.geogym.payment.exception.TicketNotEnoughException;
import com.geogym.payment.service.TicketService;
import com.geogym.qna.dto.Paging;
import com.geogym.schedule.exception.InvalidParamException;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDao ticketDao;

	@Override
	public boolean hasPTTicket(User user, Trainer trainer) throws InvalidParamException {

		Ticket ticket = new Ticket();
		ticket.setUser(user);
		ticket.setTrainer(trainer);

		ticket = ticketDao.selectTicket(ticket);

		try {
			if (ticket.getPt_ticket_expire().isAfter(LocalDateTime.now()) && ticket.getPt_ticket_amount() > 0) {
	
				System.out.println(ticket);
	
				return true;
			}
		} catch (NullPointerException e) {
			throw new InvalidParamException();
		}
		return false;

	}

	@Override
	public Map<Ticket, Integer> getTicketMap(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketChangesInfo> getListTicketChangesInfo(User user, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void payByTicket(User user, Trainer trainer) throws TicketNotEnoughException {
		// TODO Auto-generated method stub

	}

	@Override
	public void refundTicket(User user, Trainer trainer) {
		// TODO Auto-generated method stub

	}

}
