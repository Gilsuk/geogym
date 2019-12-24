package com.geogym.payment.service;

import java.util.List;
import java.util.Map;

import com.geogym.common.dto.Paging;
import com.geogym.payment.dto.Ticket;
import com.geogym.payment.dto.TicketChangesInfo;
import com.geogym.payment.exception.TicketNotEnoughException;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public interface TicketService {

	/**
	 * 유저가 보유한 티켓을 반환한다.
	 */
	Map<Ticket, Integer> getTicketMap(User user);
	
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
	void payByTicket(User user, Trainer trainer) throws TicketNotEnoughException;

	/**
	 * 
	 * 
	 * @param user
	 * @param trainer
	 */
	void refundTicket(User user, Trainer trainer);

}
