package com.geogym.schedule.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class BusinessDay {
	
	private LocalDate business_day_date;
	private LocalTime business_day_starttime;
	private LocalTime business_day_endtime;
	
	@Override
	public String toString() {
		return "BusinessDay [business_day_date=" + business_day_date + ", business_day_starttime="
				+ business_day_starttime + ", business_day_endtime=" + business_day_endtime + "]";
	}
	
	public LocalDate getBusiness_day_date() {
		return business_day_date;
	}
	public void setBusiness_day_date(LocalDate business_day_date) {
		this.business_day_date = business_day_date;
	}
	public LocalTime getBusiness_day_starttime() {
		return business_day_starttime;
	}
	public void setBusiness_day_starttime(LocalTime business_day_starttime) {
		this.business_day_starttime = business_day_starttime;
	}
	public LocalTime getBusiness_day_endtime() {
		return business_day_endtime;
	}
	public void setBusiness_day_endtime(LocalTime business_day_endtime) {
		this.business_day_endtime = business_day_endtime;
	}
	
}