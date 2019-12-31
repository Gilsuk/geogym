package com.geogym.payment.dao;

import java.util.HashMap;
import java.util.List;

import com.geogym.payment.dto.PTTicket;
import com.geogym.payment.dto.Ticket;
import com.geogym.user.dto.User;

public interface TicketDao {

	PTTicket selectPTTicket(PTTicket ticket);

	int selectCountUser(HashMap<String, Object> map);

	List<PTTicket> selectPTTicketInList(User user);

	void updatePTTicket(PTTicket upDateptTicket);

	void insertPTTicket(PTTicket ptTicket);

	void insertTicket(Ticket ticket);

	void setTicketIsActiveToTrue(Ticket ticket);

	void setTicketIsActiveToFalse(Ticket ticket);

	Ticket selectTicketByUser(User user);
	
}
