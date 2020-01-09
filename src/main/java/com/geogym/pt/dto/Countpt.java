package com.geogym.pt.dto;

public class Countpt {
	private int trainer_no;
	private String user_name;
	private int count_pt;
	@Override
	public String toString() {
		return "Countpt [trainer_no=" + trainer_no + ", user_name=" + user_name + ", count_pt=" + count_pt + "]";
	}
	public int getTrainer_no() {
		return trainer_no;
	}
	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getCount_pt() {
		return count_pt;
	}
	public void setCount_pt(int count_pt) {
		this.count_pt = count_pt;
	}
	
	
	
}
