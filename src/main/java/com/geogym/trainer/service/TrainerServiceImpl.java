package com.geogym.trainer.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.geogym.memo.dto.CalendarMemo;
import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.dto.PeriodDateTime;
import com.geogym.schedule.dto.Schedule;
import com.geogym.trainer.dto.PtTicket;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.exception.UserNotTrainerException;
import com.geogym.user.dto.User;
import com.geogym.user.dto.UserEvaluation;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Override
	public Trainer getTrainerByUserno(User user) throws UserNotTrainerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getClients(Trainer trainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userEvaluation(PtTicket pt_ticket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserEvaluation> selectEvaluation(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTrainerPrice(Trainer trainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Trainer> viewTrainerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer getTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer updateTraner(Trainer trainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer deleteTraner(Trainer trainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<LocalDate, String> getMapScheduleDateTraner(Trainer trainer, PeriodDate periodDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectScheduleDateTraner(Trainer trainer, PeriodDate periodDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertScheduleDateTraner(Trainer trainer, PeriodDate periodDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateScheduleDateTraner(Trainer trainer, PeriodDate periodDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<LocalDate, List<CalendarMemo>> getMapScheduleTimeTraner(Trainer trainer, PeriodDate periodDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarMemo> selectScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifySchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getReputation(Trainer trainer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reputate(Trainer trainer, int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countReferrer(Trainer trainer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
