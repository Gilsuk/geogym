package com.geogym.memo.dto;

import java.time.LocalDate;

import com.geogym.attachment.dto.Attachment;

public class TrainingMemo {
	private int training_memo_no;
	private int user_no;
	private int trainer_no;
	private LocalDate training_memo_date;
	private Attachment attachment;
	public int getTraining_memo_no() {
		return training_memo_no;
	}
	public void setTraining_memo_no(int training_memo_no) {
		this.training_memo_no = training_memo_no;
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
	public LocalDate getTraining_memo_date() {
		return training_memo_date;
	}
	public void setTraining_memo_date(LocalDate training_memo_date) {
		this.training_memo_date = training_memo_date;
	}
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "TrainingMemo [training_memo_no=" + training_memo_no + ", user_no=" + user_no + ", trainer_no="
				+ trainer_no + ", training_memo_date=" + training_memo_date + ", attachment=" + attachment + "]";
	}
}
