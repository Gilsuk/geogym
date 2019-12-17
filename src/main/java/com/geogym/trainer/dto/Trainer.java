package com.geogym.trainer.dto;

public class Trainer {
	private String name;
	private int no;
	@Override
	public String toString() {
		return "Trainer [name=" + name + ", no=" + no + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	
}
