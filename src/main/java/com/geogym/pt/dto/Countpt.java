package com.geogym.pt.dto;

public class Countpt {
	private int trainer_no;
	private int count_pt;
	@Override
	public String toString() {
		return "Countpt [trainer_no=" + trainer_no + ", count_pt=" + count_pt + "]";
	}
	public int getTrainer_no() {
		return trainer_no;
	}
	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}
	public int getCount_pt() {
		return count_pt;
	}
	public void setCount_pt(int count_pt) {
		this.count_pt = count_pt;
	}
	
	
}
