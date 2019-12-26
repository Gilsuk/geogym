package com.geogym.calendar.dto;

public class CalendarDto {
	
	private String solYear;
	private String solMonth;
	
	@Override
	public String toString() {
		return "CalendarDto [solYear=" + solYear + ", solMonth=" + solMonth + "]";
	}
	public String getSolYear() {
		return solYear;
	}
	public void setSolYear(String solYear) {
		this.solYear = solYear;
	}
	public String getSolMonth() {
		return solMonth;
	}
	public void setSolMonth(String solMonth) {
		this.solMonth = solMonth;
	}
	
	
	
	
}
