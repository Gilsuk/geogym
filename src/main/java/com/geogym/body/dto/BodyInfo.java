package com.geogym.body.dto;

import java.time.LocalDate;

public class BodyInfo {
	private int bodyinfo_no;
	private int user_no;
	private LocalDate date;
	private double bodyinfo_height;
	private double bodyinfo_weight;
	private double bodyinfo_fat; // 체지방량
	private double bodyinfo_muscle; // 골격근량
	@Override
	public String toString() {
		return "BodyInfo [bodyinfo_no=" + bodyinfo_no + ", user_no=" + user_no + ", date=" + date + ", bodyinfo_height="
				+ bodyinfo_height + ", bodyinfo_weight=" + bodyinfo_weight + ", bodyinfo_fat=" + bodyinfo_fat
				+ ", bodyinfo_muscle=" + bodyinfo_muscle + "]";
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
