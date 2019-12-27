package com.geogym.pt.dao;

import com.geogym.pt.dto.PT;
import com.geogym.schedule.dto.Schedule;

public interface MatchingDao {

	Schedule selectSchedule(Schedule schedule);

	PT selectUserByscheduleNo(Schedule scheduleInfo);

}
