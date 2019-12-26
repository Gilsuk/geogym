package com.geogym.schedule.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.geogym.pt.dto.MatchingSchedule;
import com.geogym.schedule.dao.ScheduleDao;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired ScheduleDao scheduleDao;

	@Override
	public List<LocalTime> getAvilableTime(Trainer trainer, LocalDate localDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPTShcedule(Trainer trainer, User user, LocalDateTime locaDatetime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelPTSchedule(Trainer trainer, User user, LocalDateTime locaDatetime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MatchingSchedule> getPTSchedule(Trainer trainer, User user, LocalDateTime locaDatetime) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
