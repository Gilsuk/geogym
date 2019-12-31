package com.geogym.calendar.dao;

import java.time.LocalDate;
import java.util.List;

import com.geogym.calendar.dto.Calendar_Memo;
import com.geogym.calendar.dto.Holiday;
import com.geogym.schedule.dto.BusinessDay;

public interface CalendarDao {
	public void insertholiday(Holiday holiday);
	
	public void deleteholiday(Holiday holiday);
	
	public List<Holiday> selectholiday();
	
	public List<BusinessDay> selectbusiness();
	
	public void insertmemo(Calendar_Memo calendar_Memo);
	
	public void deletememo(Calendar_Memo calendar_Memo);
	
	public List<Calendar_Memo> selectmemo();
	
	
	public Calendar_Memo memoview(Calendar_Memo calendar_Memo);
	
	public void updatememo(Calendar_Memo calendar_Memo);
	
	
	
}
