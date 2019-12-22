package com.geogym.trainer.dto;

import com.geogym.attachment.dto.Attachment;

public class Trainer {
	private int trainer_no;
	private int user_no;
	private String trainer_address;
	private int trainer_price;
	private String trainer_profile;
	private String trainer_name;	
	private Attachment attchment;
	public int getTrainer_no() {
		return trainer_no;
	}
	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getTrainer_address() {
		return trainer_address;
	}
	public void setTrainer_address(String trainer_address) {
		this.trainer_address = trainer_address;
	}
	public int getTrainer_price() {
		return trainer_price;
	}
	public void setTrainer_price(int trainer_price) {
		this.trainer_price = trainer_price;
	}
	public String getTrainer_profile() {
		return trainer_profile;
	}
	public void setTrainer_profile(String trainer_profile) {
		this.trainer_profile = trainer_profile;
	}
	public String getTrainer_name() {
		return trainer_name;
	}
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}
	public Attachment getAttchment() {
		return attchment;
	}
	public void setAttchment(Attachment attchment) {
		this.attchment = attchment;
	}
	@Override
	public String toString() {
		return "Trainer [trainer_no=" + trainer_no + ", user_no=" + user_no + ", trainer_address=" + trainer_address
				+ ", trainer_price=" + trainer_price + ", trainer_profile=" + trainer_profile + ", trainer_name="
				+ trainer_name + ", attchment=" + attchment + "]";
	}
}
