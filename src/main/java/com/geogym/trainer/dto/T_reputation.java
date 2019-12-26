package com.geogym.trainer.dto;

public class T_reputation {
	private int trainer_reputation_no;
	private int user_no;
	private int trainer_no;
	private String trainer_reputation_date;
	private double trainer_reputation_score;
	private String trainer_reputation_msg;

	@Override
	public String toString() {
		return "trainer_reputation [trainer_reputation_no=" + trainer_reputation_no + ", user_no=" + user_no
				+ ", trainer_no=" + trainer_no + ", trainer_reputation_date=" + trainer_reputation_date
				+ ", trainer_reputation_score=" + trainer_reputation_score + ", trainer_reputation_msg="
				+ trainer_reputation_msg + "]";
	}

	public int getTrainer_reputation_no() {
		return trainer_reputation_no;
	}

	public void setTrainer_reputation_no(int trainer_reputation_no) {
		this.trainer_reputation_no = trainer_reputation_no;
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

	public String getTrainer_reputation_date() {
		return trainer_reputation_date;
	}

	public void setTrainer_reputation_date(String trainer_reputation_date) {
		this.trainer_reputation_date = trainer_reputation_date;
	}

	public double getTrainer_reputation_score() {
		return trainer_reputation_score;
	}

	public void setTrainer_reputation_score(double trainer_reputation_score) {
		this.trainer_reputation_score = trainer_reputation_score;
	}

	public String getTrainer_reputation_msg() {
		return trainer_reputation_msg;
	}

	public void setTrainer_reputation_msg(String trainer_reputation_msg) {
		this.trainer_reputation_msg = trainer_reputation_msg;
	}

}
