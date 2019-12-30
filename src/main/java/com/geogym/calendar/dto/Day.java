package com.geogym.calendar.dto;

import java.time.LocalDate;

public class Day {
	private LocalDate date;
	private boolean isHoliday;
	private String name;
	private String day;
	@Override
	public String toString() {
		return "Day [date=" + date + ", isHoliday=" + isHoliday + ", name=" + name + ", day=" + day + "]";
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isHoliday() {
		return isHoliday;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	
	
}
