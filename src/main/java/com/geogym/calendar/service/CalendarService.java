package com.geogym.calendar.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

public interface CalendarService {

	public void insertholiday(String url);
	
	
	public String geturl(String solYear, String solMonth);
	
}
