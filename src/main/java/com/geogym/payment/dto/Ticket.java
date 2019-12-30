package com.geogym.payment.dto;

import java.time.LocalDateTime;

import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public class Ticket {
	
	private User user;
	private Trainer trainer;
	private LocalDateTime pt_ticket_expire;
	private int pt_ticket_amount;
	
	@Override
	public String toString() {
		return "Ticket [user=" + user + ", trainer=" + trainer + ", pt_ticket_expire=" + pt_ticket_expire
				+ ", pt_ticket_amount=" + pt_ticket_amount + "]";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public LocalDateTime getPt_ticket_expire() {
		return pt_ticket_expire;
	}
	public void setPt_ticket_expire(LocalDateTime pt_ticket_expire) {
		this.pt_ticket_expire = pt_ticket_expire;
	}
	public int getPt_ticket_amount() {
		return pt_ticket_amount;
	}
	public void setPt_ticket_amount(int pt_ticket_amount) {
		this.pt_ticket_amount = pt_ticket_amount;
	}
}