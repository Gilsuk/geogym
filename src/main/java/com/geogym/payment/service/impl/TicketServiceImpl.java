package com.geogym.payment.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.payment.dao.TicketDao;
import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.dto.Payment;
import com.geogym.payment.dto.Ticket;
import com.geogym.payment.dto.TicketChangesInfo;
import com.geogym.payment.enumeration.Currency;
import com.geogym.payment.enumeration.Product;
import com.geogym.payment.service.PaymentLogService;
import com.geogym.payment.service.TicketService;
import com.geogym.qna.dto.Paging;
import com.geogym.schedule.exception.InvalidParamException;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired private TicketDao dao;
	@Autowired private PaymentLogService payLogServ;

	
	@Override
	public boolean hasPTTicket(User user, Trainer trainer) throws InvalidParamException {

		PTTicket ticket = new PTTicket();
		ticket.setUser(user);
		ticket.setTrainer(trainer);

		ticket = dao.selectPTTicket(ticket);

		try {
			if (ticket.getPt_ticket_expire().isAfter(LocalDateTime.now()) && ticket.getPt_ticket_amount() > 0) {
	
				return true;
			}
		} catch (NullPointerException e) {
			return false;
		}
		return false;

	}

	@Override
	public List<PTTicket> getPTTicketList(User user) {
		
		return dao.selectPTTicketInList(user);
	}

	@Override
	public int getCountUser(Trainer trainer) {
		
		LocalDate today = LocalDate.now();
		
		HashMap<String , Object> map = new HashMap<String, Object>();
		
		map.put("trainer_no", trainer.getTrainer_no());
		map.put("pt_ticket_expire", today);
		
		return dao.selectCountUser(map);
	}

	@Override
	public void issuePTTicket(PTTicket ptTicket) throws InvalidParamException {
		
		if(hasPTTicket(ptTicket.getUser(), ptTicket.getTrainer())) {
			
			List<PTTicket> list = getPTTicketList(ptTicket.getUser());
			
			PTTicket upDateptTicket = new PTTicket();
			
			for(int i = 0; i < list.size(); i++) {
				
				if(list.get(i).getTrainer().getTrainer_no() == ptTicket.getTrainer().getTrainer_no()) {
					
					upDateptTicket.setUser(list.get(i).getUser());
					upDateptTicket.setTrainer(list.get(i).getTrainer());
					upDateptTicket.setPt_ticket_expire(ptTicket.getPt_ticket_expire());
					upDateptTicket.setPt_ticket_amount(list.get(i).getPt_ticket_amount()+ptTicket.getPt_ticket_amount());
					
					dao.updatePTTicket(upDateptTicket);
				}
			}
			return;
		}
		
		dao.insertPTTicket(ptTicket);
		
		return;
	}
	
	@Override
	public List<TicketChangesInfo> getListTicketChangesInfo(User user, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void payByTicket(User user, Trainer trainer){
		// TODO Auto-generated method stub
	}

	@Override
	public void refundPTTicket(User user, Trainer trainer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void issueTicket(User user, int monthLength, int price, Currency currency) {
		LocalDate now = LocalDate.now();
		Payment payment = new Payment();
		payment.setCurrency(currency);
		payment.setPay_amount(price);
		payment.setPay_date(LocalDateTime.now());
		payment.setProduct(Product.TICKET);
		payment.setUser(user);
		payLogServ.logPayment(payment);
		
		Ticket ticket = new Ticket();
		ticket.setTicket_active_date(now);
		ticket.setTicket_duration(betweenDays(now, now.plusMonths(monthLength)));
		ticket.setTicket_isactive(true);
		ticket.setUser(user);

		dao.insertTicket(ticket);
	}
	
	@Override
	public Ticket getTicket(User user) {
		return dao.selectTicketByUser(user);
	}

	private int betweenDays(LocalDate from, LocalDate to) {
		return (int)ChronoUnit.DAYS.between(from, to);
	}

	@Override
	public void pauseTicket(User user) {
		Ticket ticket = getTicket(user);
		LocalDate date = ticket.getTicket_active_date();
		int duration = ticket.getTicket_duration();
		int days = betweenDays(date, LocalDate.now());

		ticket.setTicket_duration(duration - days);
		ticket.setTicket_active_date(LocalDate.now());
		ticket.setTicket_isactive(false);
		dao.setTicketIsActiveToFalse(ticket);
	}

	@Override
	public void continueTicket(User user) {
		Ticket ticket = getTicket(user);
		LocalDate date = ticket.getTicket_active_date();
		int duration = ticket.getTicket_duration();
		int days = betweenDays(date, LocalDate.now());

		ticket.setTicket_duration(duration - days);
		ticket.setTicket_active_date(LocalDate.now());
		ticket.setTicket_isactive(true);
		dao.setTicketIsActiveToTrue(ticket);
	}

	@Override
	public void renewTicket(User user, int monthLength, int price, Currency currency) {
	}
}