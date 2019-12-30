package com.geogym.calendar.service;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.geogym.calendar.dto.Day;
import com.geogym.calendar.dto.Holiday;

public interface CalendarService {

	public void insertholiday(String url);
	
	
	public String geturl(String solYear, String solMonth);
	
	
	public List<Holiday> selectholiday();


	public List<Day> getDayList(LocalDate month);
	
}
