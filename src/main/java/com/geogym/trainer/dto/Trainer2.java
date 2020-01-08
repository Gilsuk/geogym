package com.geogym.trainer.dto;

import com.geogym.attachment.dto.Attachment;
import com.geogym.user.dto.User;

public class Trainer2 {
	private int trainer_no;
	private User user;
	private String trainer_address;
	private int trainer_price;
	private String trainer_profile;
	private Attachment attachment;

	@Override
	public String toString() {
		return "Trainer2 [trainer_no=" + trainer_no + ", user=" + user + ", trainer_address=" + trainer_address
				+ ", trainer_price=" + trainer_price + ", trainer_profile=" + trainer_profile + ", attachment="
				+ attachment + "]";
	}

	public int getTrainer_no() {
		return trainer_no;
	}

	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

}
