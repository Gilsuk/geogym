package com.geogym.calendar.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.geogym.calendar.dto.Holiday;

public interface CalendarDao {
	public void insertholiday(Holiday holiday);
	
	public void deleteholiday(Holiday holiday);
	
	public List<Holiday> selectholiday();
	
}
