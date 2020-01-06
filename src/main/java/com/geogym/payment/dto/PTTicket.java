package com.geogym.payment.dto;

import java.time.LocalDate;

import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public class PTTicket {
	
	private User user;
	private Trainer trainer;
	private LocalDate pt_ticket_expire;
	private int pt_ticket_amount;
	private String trainer_name;
	
	@Override
	public String toString() {
		return "PTTicket [user=" + user + ", trainer=" + trainer + ", pt_ticket_expire=" + pt_ticket_expire
				+ ", pt_ticket_amount=" + pt_ticket_amount + ", trainer_name=" + trainer_name + "]";
	}
	
	public String getTrainer_name() {
		return trainer_name;
	}
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
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
	public LocalDate getPt_ticket_expire() {
		return pt_ticket_expire;
	}
	public void setPt_ticket_expire(LocalDate pt_ticket_expire) {
		this.pt_ticket_expire = pt_ticket_expire;
	}
	public int getPt_ticket_amount() {
		return pt_ticket_amount;
	}
	public void setPt_ticket_amount(int pt_ticket_amount) {
		this.pt_ticket_amount = pt_ticket_amount;
	}
}