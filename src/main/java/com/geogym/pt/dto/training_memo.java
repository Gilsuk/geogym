package com.geogym.pt.dto;

import java.time.LocalDateTime;

import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public class training_memo {
	
	private int training_memo_no;
	private User user;
	private Trainer trainer;
	private LocalDateTime training_memo_date;
	private int attachment_no;
	
	@Override
	public String toString() {
		return "training_memo [training_memo_no=" + training_memo_no + ", user=" + user + ", trainer=" + trainer
				+ ", training_memo_date=" + training_memo_date + ", attachment_no=" + attachment_no + "]";
	}
	
	public int getTraining_memo_no() {
		return training_memo_no;
	}
	public void setTraining_memo_no(int training_memo_no) {
		this.training_memo_no = training_memo_no;
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
	public LocalDateTime getTraining_memo_date() {
		return training_memo_date;
	}
	public void setTraining_memo_date(LocalDateTime training_memo_date) {
		this.training_memo_date = training_memo_date;
	}
	public int getAttachment_no() {
		return attachment_no;
	}
	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}
	
}