package com.geogym.calendar.service;


import java.time.LocalDate;
import java.util.List;


import com.geogym.calendar.dto.DateContent;

import com.geogym.calendar.dto.Calendar_Memo;

import com.geogym.calendar.dto.Day;
import com.geogym.calendar.dto.Holiday;

public interface CalendarService {

	public void insertholiday(String url);
	
	
	public String geturl(String solYear, String solMonth);
	
	
	public List<Holiday> selectholiday();


	public List<Day> getDayList(LocalDate month);
	

	public List<Day> setContentToList(List<Day> calendar, List<Object> content);
	
	
	public List<Day> setPTToList(List<Day> calendar, List<? extends DateContent> content);
	
	
	public void insertMemo(Calendar_Memo calendar_Memo);
	
	// calendar 메모 리트스
	public List<Calendar_Memo> memoList();
	
	public Calendar_Memo memoview(Calendar_Memo calendar_Memo);
	
	public void updatememo(Calendar_Memo calendar_Memo);
	
}
