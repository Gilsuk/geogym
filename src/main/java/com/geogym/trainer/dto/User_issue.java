package com.geogym.trainer.dto;

public class User_issue {
	private int user_no;
	private int trainer_no;
	private String user_issue_date;
	private String user_issue_msg;

	@Override
	public String toString() {
		return "user_issue [user_no=" + user_no + ", trainer_no=" + trainer_no + ", user_issue_date=" + user_issue_date
				+ ", user_issue_msg=" + user_issue_msg + "]";
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

	public String getUser_issue_date() {
		return user_issue_date;
	}

	public void setUser_issue_date(String user_issue_date) {
		this.user_issue_date = user_issue_date;
	}

	public String getUser_issue_msg() {
		return user_issue_msg;
	}

	public void setUser_issue_msg(String user_issue_msg) {
		this.user_issue_msg = user_issue_msg;
	}

}
