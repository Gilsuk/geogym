package com.geogym.schedule.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.common.enumeration.Table;
import com.geogym.common.service.SequenceService;
import com.geogym.pt.dto.PT;
import com.geogym.schedule.dao.ScheduleDao;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.exception.InvalidParamException;
import com.geogym.schedule.service.ScheduleService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

	@Autowired
	ScheduleDao scheduleDao;

	@Autowired
	SequenceService sequenceService;

	@Autowired
	HttpServletRequest req;

	@Override
	public List<LocalTime> getAvilableTime(Trainer trainer, LocalDate workingDate) throws InvalidParamException {

		Schedule schedule = new Schedule();

		schedule.setTrainer(trainer);
		schedule.setSchedule_date(workingDate);

		Schedule workingSchedule = scheduleDao.selectWorkingTimeInaDay(schedule);

		List<LocalTime> list = new ArrayList<LocalTime>();

		List<Schedule> scheduleList = getSchedule(trainer, workingDate);

		try {

			Duration workingTime = Duration.between(workingSchedule.getSchedule_from(),
					workingSchedule.getSchedule_to());

			for (int i = 0; i < (workingTime.getSeconds() / 60) / 60; i++) {
				LocalTime time = workingSchedule.getSchedule_from().plusHours(i);

				boolean isAvailable = true;

				for (int j = 0; j < scheduleList.size(); j++) {

					Duration duration = Duration.between(scheduleList.get(j).getSchedule_from(),
							scheduleList.get(j).getSchedule_to());
					long hour = duration.getSeconds() / 60 / 60;

					if (scheduleList.get(j).getSchedule_from().equals(time)) {

						if (hour > 1) {
							i += hour - 1;
						}

						isAvailable = false;

						break;

					}
				}

				if (isAvailable) {
					list.add(time);
				}
			}

			return list;

		} catch (NullPointerException e) {
			throw new InvalidParamException();
		}
	}

	@Override
	public void setPTShcedule(User user, Schedule schedule) {

		if (schedule.getSchedule_date() == null) {
			return;
		}

		int nextVal = sequenceService.getNextVal(Table.SCHEDULE);

		schedule.setSchedule_no(nextVal);
		scheduleDao.insertSchedule(schedule);

		PT pt = new PT();
		pt.setPt_date(LocalDateTime.of(schedule.getSchedule_date(), schedule.getSchedule_from()));
		pt.setPt_request_date(LocalDateTime.now());
		pt.setUser(user);
		pt.setSchedule_no(nextVal);
		pt.setPt_type_no(2);

		scheduleDao.insertPTSchedule(pt);

	}

	@Override
	public void cancelPTSchedule(Trainer trainer, User user, LocalDateTime localDateTime) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("trainer_no", trainer.getTrainer_no());
		map.put("user_no", user.getUser_no());
		map.put("pt_date", localDateTime);
		
		map.put("schedule_date", LocalDate.of(
				localDateTime.getYear(), 
				localDateTime.getMonth(),
				localDateTime.getDayOfMonth()));
		map.put("schedule_from", LocalTime.of(
				localDateTime.getHour(),
				localDateTime.getMinute()));
		
		scheduleDao.deletePT(map);
		scheduleDao.deleteSchedule(map);
	}

	@Override
	public List<PT> getPTScheduleByMonth(User user, LocalDate localdate) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("user_no", user.getUser_no());
		map.put("start", LocalDate.of(
				localdate.getYear(),
				localdate.getMonth(),
				1));
		map.put("end", LocalDateTime.of(
				localdate.getYear(),
				localdate.getMonth(),
				localdate.lengthOfMonth(),
				23,
				59));
		
		return scheduleDao.selectPTList(map);
	}

	@Override
	public void setSchedule(Schedule schedule) {

		if (schedule.getSchedule_date() != null) {

			schedule.setSchedule_no(sequenceService.getNextVal(Table.SCHEDULE));

			scheduleDao.insertSchedule(schedule);
		}
		return;
	}

	@Override
	public Schedule getScheduleByParam(Trainer trainer, LocalDate date, LocalTime start, LocalTime end, String msg) {

		Schedule schedule = new Schedule();

		List<LocalTime> list = new ArrayList<LocalTime>();

		try {

			list = getAvilableTime(trainer, date);

			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).equals(start)) {

					schedule.setTrainer(trainer);
					schedule.setSchedule_date(date);
					schedule.setSchedule_from(start);
					schedule.setSchedule_to(end);
					schedule.setSchedule_msg(msg);

					break;
				}
			}

			if (schedule.getSchedule_date() == null) {
				logger.info("실패");
			}

		} catch (InvalidParamException e) {

		}

		return schedule;
	}

	@Override
	public List<Schedule> getSchedule(Trainer trainer, LocalDate localDate) {

		List<Schedule> list = new ArrayList<Schedule>();

		Schedule schedule = new Schedule();

		schedule.setSchedule_date(localDate);
		schedule.setTrainer(trainer);

		list = scheduleDao.selectSchedule(schedule);

		logger.info(list.toString());

		return list;
	}

	@Override
	public List<LocalTime> getPTAvilableTime(Trainer trainer, LocalDate localDate) {

		List<LocalTime> list = new ArrayList<LocalTime>();
		List<Schedule> scheduleList = getSchedule(trainer, localDate);

		logger.info(list.toString());

		try {
			list = getAvilableTime(trainer, localDate);
		} catch (InvalidParamException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < scheduleList.size(); i++) {

			list.remove(scheduleList.get(i).getSchedule_from().minusHours(1));

		}
		
		list.remove(list.size()-1);
		
		return list;
	}

}
