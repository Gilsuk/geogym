package com.geogym.schedule.dao;

import java.util.HashMap;
import java.util.List;

import com.geogym.pt.dto.PT;
import com.geogym.schedule.dto.Schedule;

public interface ScheduleDao {

	Schedule selectWorkingTimeInaDay(Schedule schedule);

	void insertSchedule(Schedule schedule);

	List<Schedule> selectSchedule(Schedule schedule);

	void insertPTSchedule(PT pt);

	void deletePT(HashMap<String, Object> map);

	void deleteSchedule(HashMap<String, Object> map);

	List<PT> selectPTList(HashMap<String, Object> map);

}
