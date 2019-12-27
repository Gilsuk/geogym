package com.geogym.payment.dao;

import com.geogym.payment.dto.Ticket;

public interface TicketDao {

	Ticket selectTicket(Ticket ticket);
	
}
