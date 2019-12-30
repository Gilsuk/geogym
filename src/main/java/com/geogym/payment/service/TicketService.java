package com.geogym.payment.service;

import java.util.List;

import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.dto.TicketChangesInfo;
import com.geogym.payment.exception.TicketNotEnoughException;
import com.geogym.qna.dto.Paging;
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
	List<PTTicket> getTicketList(User user);
	
	/**
	 * 티켓 사용 내역을 반환한다.
	 */
	List<TicketChangesInfo> getListTicketChangesInfo(User user, Paging paging);

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
	void refundTicket(User user, Trainer trainer);

	/**
	 * 
	 * @param trainer
	 * @return
	 */
	int getCountUser(Trainer trainer);

}
