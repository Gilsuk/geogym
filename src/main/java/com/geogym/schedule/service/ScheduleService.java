package com.geogym.schedule.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.geogym.pt.dto.PT;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.exception.AllTimeisUnavailable;
import com.geogym.schedule.exception.InvalidParamException;
import com.geogym.schedule.exception.NotWorkinDayException;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public interface ScheduleService {

	/**
	 * 트레이너의 빈 시간을 30분 단위로 끊어서 리스트로 리턴
	 * 
	 * 마지막 시간은 최소 1시간 텀은 필요하다
	 * ex)트레이너의 2시에 스케줄이 있으면 1:30은 제외
	 * 
	 * @param trainer - 트레이너 번호를 가지는 Trainer 객체
	 * @param localDate - 조회를 원하는 날짜 (년-월-일)
	 * @return
	 * @throws InvalidParamException 
	 * @throws AllTimeisUnavailable 
	 */
	List<LocalTime> getAvilableTime(Trainer trainer, LocalDate localDate) throws InvalidParamException, AllTimeisUnavailable, NotWorkinDayException;
	
	/**
	 * 
	 * 
	 * @param trainer
	 * @param user
	 * @param locaDatetime
	 * @throws InvalidParamException 
	 * @throws AllTimeisUnavailable 
	 * @throws NotWorkinDayException 
	 */
	void setPTShcedule(User user, Schedule schedule) throws InvalidParamException, AllTimeisUnavailable, NotWorkinDayException;
	
	/**
	 * 
	 * 
	 * @param trainer
	 * @param user
	 * @param locaDatetime
	 */
	void cancelPTSchedule(Trainer trainer, User user, LocalDateTime localDateTime);
	
	/**
	 * 특정 달에 잡혀있는 PT일정을 리스트로 받음
	 * 
	 * @param user
	 * @param localdate - 조회를 원하는 달
	 * @return
	 */
	List<PT> getPTScheduleByMonth(User user, LocalDate localdate);
	
	/**
	 * 
	 * @param schedule
	 * @throws InvalidParamException 
	 * @throws AllTimeisUnavailable 
	 * @throws NotWorkinDayException 
	 */
	void setSchedule(Schedule schedule) throws InvalidParamException, AllTimeisUnavailable, NotWorkinDayException;
	
	/**
	 * 
	 * 
	 * @param trainer 
	 * @param date
	 * @param start
	 * @param end
	 * @param msg
	 * @return
	 * @throws InvalidParamException 
	 */
	boolean isAvailableSchedule(Schedule scheduleList, List<LocalTime> list) throws InvalidParamException;
	
	/**
	 * 
	 * 
	 * @param trainer
	 * @param localDate
	 * @return
	 */
	List<Schedule> getSchedule(Trainer trainer, LocalDate localDate);

	/**
	 * 
	 * 
	 * @param trainer
	 * @param localDate
	 * @return
	 * @throws AllTimeisUnavailable 
	 * @throws NotWorkinDayException 
	 */

	List<LocalTime> getPTAvilableTime(Trainer trainer, LocalDate localDate) throws AllTimeisUnavailable, NotWorkinDayException;

	/**
	 * 
	 * 
	 * @param trainer
	 * @param date
	 * @return
	 */
	List<Schedule> getAttendance(Trainer trainer, LocalDate date);
}
