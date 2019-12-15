package com.geogym.schedule.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.geogym.schedule.dto.WorkingTimeInfo;

public interface WorkingDayService {
	
	void setNotWorkingDay(LocalDateTime date);
	
	/**
	 * 어떤 패턴으로 정기 휴무를 등록할지 고민이 필요함
	 */
	void setRegularNotWorkingDay();
	
	void setNotWorkingDayWithMessage(LocalDateTime date, String msg);
	
	void setNotWorkingDays(LocalDateTime from, LocalDateTime to);

	void setNotWorkingDaysWithMessage(LocalDateTime from, LocalDateTime to, String msg);
	
	boolean isWorkingDay(LocalDateTime date);
	
	void setWorkingTime(LocalDate date, WorkingTimeInfo workingTime);
	
	/**
	 * '정기'에 대한 알고리즘이 애매함
	 * @param workingTime
	 */
	void setRegularWorkingTime(WorkingTimeInfo workingTime);
	
	WorkingTimeInfo getWorkingTimeInfo(LocalDate date);
	
	List<WorkingTimeInfo> getWorkingTimeInfos(LocalDate from, LocalDate to);
	
}
