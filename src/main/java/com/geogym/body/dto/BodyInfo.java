package com.geogym.body.dto;

import java.time.LocalDate;

public class BodyInfo {
	private int bodyinfo_no;
	private int user_no;
	private String user_name;
	private char user_gender;
	private LocalDate user_birth;
	private LocalDate bodyinfo_date;
	private double bodyinfo_height;
	private double bodyinfo_weight;
	private double bodyinfo_fat; // 체지방량
	private double bodyinfo_muscle; // 골격근량
	
	
	@Override
	public String toString() {
		return "BodyInfo [bodyinfo_no=" + bodyinfo_no + ", user_no=" + user_no + ", user_name=" + user_name
				+ ", user_gender=" + user_gender + ", user_birth=" + user_birth + ", bodyinfo_date=" + bodyinfo_date
				+ ", bodyinfo_height=" + bodyinfo_height + ", bodyinfo_weight=" + bodyinfo_weight + ", bodyinfo_fat="
				+ bodyinfo_fat + ", bodyinfo_muscle=" + bodyinfo_muscle + "]";
	}
	
	
	public int getBodyinfo_no() {
		return bodyinfo_no;
	}
	public void setBodyinfo_no(int bodyinfo_no) {
		this.bodyinfo_no = bodyinfo_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public char getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(char user_gender) {
		this.user_gender = user_gender;
	}
	public LocalDate getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(LocalDate user_birth) {
		this.user_birth = user_birth;
	}
	public LocalDate getBodyinfo_date() {
		return bodyinfo_date;
	}
	public void setBodyinfo_date(LocalDate bodyinfo_date) {
		this.bodyinfo_date = bodyinfo_date;
	}
	public double getBodyinfo_height() {
		return bodyinfo_height;
	}
	public void setBodyinfo_height(double bodyinfo_height) {
		this.bodyinfo_height = bodyinfo_height;
	}
	public double getBodyinfo_weight() {
		return bodyinfo_weight;
	}
	public void setBodyinfo_weight(double bodyinfo_weight) {
		this.bodyinfo_weight = bodyinfo_weight;
	}
	public double getBodyinfo_fat() {
		return bodyinfo_fat;
	}
	public void setBodyinfo_fat(double bodyinfo_fat) {
		this.bodyinfo_fat = bodyinfo_fat;
	}
	public double getBodyinfo_muscle() {
		return bodyinfo_muscle;
	}
	public void setBodyinfo_muscle(double bodyinfo_muscle) {
		this.bodyinfo_muscle = bodyinfo_muscle;
	}
}
