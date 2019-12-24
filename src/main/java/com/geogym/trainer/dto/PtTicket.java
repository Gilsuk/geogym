package com.geogym.trainer.dto;

public class PtTicket {
	private int user_no;
	private int trainer_no;
	private String pt_ticket_expire;
	private int pt_ticket_amount;

	@Override
	public String toString() {
		return "PtTicket [user_no=" + user_no + ", trainer_no=" + trainer_no + ", pt_ticket_expire=" + pt_ticket_expire
				+ ", pt_ticket_amount=" + pt_ticket_amount + "]";
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getTrainer_no() {
		return trainer_no;
	}

	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}

	public String getPt_ticket_expire() {
		return pt_ticket_expire;
	}

	public void setPt_ticket_expire(String pt_ticket_expire) {
		this.pt_ticket_expire = pt_ticket_expire;
	}

	public int getPt_ticket_amount() {
		return pt_ticket_amount;
	}

	public void setPt_ticket_amount(int pt_ticket_amount) {
		this.pt_ticket_amount = pt_ticket_amount;
	}

}
