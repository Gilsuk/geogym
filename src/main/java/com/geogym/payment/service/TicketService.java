package com.geogym.payment.service;

import java.util.List;

import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.dto.Ticket;
import com.geogym.payment.enumeration.Currency;
import com.geogym.schedule.exception.InvalidParamException;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public interface TicketService {
	
	
	/**
	 * 
	 * 
	 * @param ptTicket
	 * @throws InvalidParamException
	 */
	void issuePTTicket(PTTicket ptTicket) throws InvalidParamException;
	
	
	/**
	 * 
	 * @param user
	 * @param trainer
	 * @return
	 * @throws InvalidParamException 
	 */
	boolean hasPTTicket(User user, Trainer trainer) throws InvalidParamException;
	
	/**
	 * 유저가 보유한 티켓을 반환한다.
	 */
	List<PTTicket> getPTTicketList(User user);
	
	/**
	 * 정기권을 이용한 PT 신청시 횟수 차감
	 * 
	 * @param user
	 * @param trainer
	 */
	void payByTicket(User user, Trainer trainer);

	/**
	 * 
	 * 
	 * @param user
	 * @param trainer
	 */
	void refundPTTicket(User user, Trainer trainer);

	/**
	 * 
	 * @param trainer
	 * @return
	 */
	int getCountUser(Trainer trainer);

	Ticket getTicket(User user);

	/**
	 * 최초 발급시
	 */
	void issueTicket(User user, int monthLength, int price, Currency currency);
	
	void pauseTicket(User user);
	
	void continueTicket(User user);
	
	void renewTicket(User user, int monthLength, int price, Currency currency);

	Ticket setExpiredDateByDuration(Ticket ticket);

}
