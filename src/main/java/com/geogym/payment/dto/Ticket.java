package com.geogym.payment.dto;

import java.time.LocalDate;

import com.geogym.user.dto.User;

public class Ticket {
	private User user;
	private LocalDate ticket_active_date;
	private int ticket_duration;
	private boolean ticket_isactive;
	private String expired_date;
	@Override
	public String toString() {
		return "Ticket [user=" + user + ", ticket_active_date=" + ticket_active_date + ", ticket_duration="
				+ ticket_duration + ", ticket_isactive=" + ticket_isactive + ", expired_date=" + expired_date + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getTicket_active_date() {
		return ticket_active_date;
	}
	public void setTicket_active_date(LocalDate ticket_active_date) {
		this.ticket_active_date = ticket_active_date;
	}
	public int getTicket_duration() {
		return ticket_duration;
	}
	public void setTicket_duration(int ticket_duration) {
		this.ticket_duration = ticket_duration;
	}
	public boolean isTicket_isactive() {
		return ticket_isactive;
	}
	public void setTicket_isactive(boolean ticket_isactive) {
		this.ticket_isactive = ticket_isactive;
	}
	public String getExpired_date() {
		return expired_date;
	}
	public void setExpired_date(String expired_date) {
		this.expired_date = expired_date;
	}
}