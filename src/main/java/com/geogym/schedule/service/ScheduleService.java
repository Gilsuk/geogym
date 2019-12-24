package com.geogym.schedule.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.geogym.schedule.dto.Schedule;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public interface ScheduleService {

	/**
	 * 트레이너의 빈 시간을 30분 단위로 끊어서 리스트로 리턴
	 * 
	 * 마지막 시간은 최소 1시간 텀은 필요하다
	 * ex)트레이너의 2시에 스케줄이 있으면 1:30은 제외
	 * 
	 * @param trainer
	 * @param localDate
	 * @return
	 */
	List<LocalTime> getAvilableTime(Trainer trainer, LocalDate localDate);
	
	/**
	 * 
	 * 
	 * @param trainer
	 * @param user
	 * @param locaDatetime
	 */
	void setPTShcedule(Trainer trainer, User user, LocalDateTime locaDatetime);
	
	/**
	 * 
	 * 
	 * @param trainer
	 * @param user
	 * @param locaDatetime
	 */
	void cancelPTSchedule(Trainer trainer, User user, LocalDateTime locaDatetime);
	
	List<Schedule> getPTSchedule(Trainer trainer, User user, LocalDateTime locaDatetime);
}
