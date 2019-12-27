package com.geogym.schedule.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.geogym.schedule.dto.WorkingTimeInfo;

public interface WorkingDayService {
	
	boolean isWorkingDay(LocalDateTime date);
	
	void setWorkingTime(LocalDate date, WorkingTimeInfo workingTime);
	
	WorkingTimeInfo getWorkingTimeInfo(LocalDate date);
	
	List<WorkingTimeInfo> getWorkingTimeInfos(LocalDate date);
	
}