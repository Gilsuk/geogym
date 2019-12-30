package com.geogym.payment.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.common.dto.Paging;
import com.geogym.common.service.SequenceService;
import com.geogym.payment.dao.TicketDao;
import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.dto.Ticket;
import com.geogym.payment.dto.TicketChangesInfo;
import com.geogym.payment.exception.TicketNotEnoughException;
import com.geogym.payment.service.TicketService;
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

		ticket = ticketDao.selectPTTicket(ticket);

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
	public List<PTTicket> getTicketList(User user) {
		
		return ticketDao.selectPTTicketInList(user);
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

	@Override
	public int getCountUser(Trainer trainer) {
		
		LocalDate today = LocalDate.now();
		
		HashMap<String , Object> map = new HashMap<String, Object>();
		
		map.put("trainer_no", trainer.getTrainer_no());
		map.put("pt_ticket_expire", today);
		
		return ticketDao.selectCountUser(map);
	}

	@Override
	public void issuePTTicket(PTTicket ptTicket) throws InvalidParamException {
		
		if(hasPTTicket(ptTicket.getUser(), ptTicket.getTrainer())) {
			
			List<PTTicket> list = getTicketList(ptTicket.getUser());
			
			PTTicket upDateptTicket = new PTTicket();
			
			for(int i = 0; i < list.size(); i++) {
				
				if(list.get(i).getTrainer().getTrainer_no() == ptTicket.getTrainer().getTrainer_no()) {
					
					upDateptTicket.setUser(list.get(i).getUser());
					upDateptTicket.setTrainer(list.get(i).getTrainer());
					upDateptTicket.setPt_ticket_expire(ptTicket.getPt_ticket_expire());
					upDateptTicket.setPt_ticket_amount(list.get(i).getPt_ticket_amount()+ptTicket.getPt_ticket_amount());
					
					ticketDao.updatePTTicket(upDateptTicket);
				}
			}
			return;
		}
		
		ticketDao.insertPTTicket(ptTicket);
		
		return;
	}
}