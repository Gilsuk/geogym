package com.geogym.schedule.service;

import java.time.LocalDate;
import java.util.List;

import com.geogym.schedule.dto.BusinessDay;

public interface BusinessDayService {
	
	boolean isWorkingDay(LocalDate date) throws NullPointerException;
	
	void setWorkingTime(LocalDate date, BusinessDay workingTime) throws NullPointerException ;
	
	BusinessDay getWorkingTimeInfo(LocalDate date) throws NullPointerException ;
	
	List<BusinessDay> getWorkingTimeInfos(LocalDate date);
	
}