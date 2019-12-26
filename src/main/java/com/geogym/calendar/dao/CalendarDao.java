package com.geogym.calendar.dao;

import com.geogym.calendar.dto.Holiday;

public interface CalendarDao {
	public void insertholiday(Holiday holiday);
	
	public void deleteholiday(Holiday holiday);
	
}
