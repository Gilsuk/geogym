package com.geogym.schedule.dao;

import com.geogym.schedule.dto.Schedule;

public interface ScheduleDao {

	Schedule selectWorkingTimeInaDay(Schedule schedule);

}
