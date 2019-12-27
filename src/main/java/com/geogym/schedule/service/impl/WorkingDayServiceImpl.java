package com.geogym.schedule.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.geogym.schedule.dto.WorkingTimeInfo;
import com.geogym.schedule.service.WorkingDayService;

public class WorkingDayServiceImpl implements WorkingDayService {

	@Override
	public boolean isWorkingDay(LocalDateTime date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWorkingTime(LocalDate date, WorkingTimeInfo workingTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public WorkingTimeInfo getWorkingTimeInfo(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkingTimeInfo> getWorkingTimeInfos(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

}
