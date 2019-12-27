package com.geogym.calendar.dto;

import java.time.LocalDate;

public class Holiday {
	private LocalDate holiday_date;
	private String holiday_name;
	@Override
	public String toString() {
		return "holiday [holiday_date=" + holiday_date + ", holiday_name=" + holiday_name + "]";
	}
	public LocalDate getHoliday_date() {
		return holiday_date;
	}
	public void setHoliday_date(LocalDate holiday_date) {
		this.holiday_date = holiday_date;
	}
	public String getHoliday_name() {
		return holiday_name;
	}
	public void setHoliday_name(String holiday_name) {
		this.holiday_name = holiday_name;
	}
	
	
	
	
	
}
