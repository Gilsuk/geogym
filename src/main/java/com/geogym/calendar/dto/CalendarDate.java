package com.geogym.calendar.dto;

import java.time.LocalDate;

public class CalendarDate {
	private LocalDate localdate;
	private String datename;
	private boolean isholiday;
	@Override
	public String toString() {
		return "CalendarDate [localdate=" + localdate + ", datename=" + datename + ", isholiday=" + isholiday + "]";
	}
	public LocalDate getLocaldate() {
		return localdate;
	}
	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}
	public String getDatename() {
		return datename;
	}
	public void setDatename(String datename) {
		this.datename = datename;
	}
	public boolean isIsholiday() {
		return isholiday;
	}
	public void setIsholiday(boolean isholiday) {
		this.isholiday = isholiday;
	}
	
	
	
	
}
