package com.geogym.memo.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.memo.dao.CalendarMemoDao;
import com.geogym.memo.dto.CalendarMemo;
import com.geogym.memo.service.CalendarMemoService;
import com.geogym.message.dto.Message;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.exception.MemoAlreadyExistException;
import com.geogym.schedule.exception.MemoNotFoundException;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

@Service
public class CalendarMemoServiceImpl implements CalendarMemoService{

	@Autowired CalendarMemoDao calendarMemoDao;
	
	@Override
	public void addMemo(User user, CalendarMemo memo) throws MemoAlreadyExistException {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		calendarMemoDao.insertMemo(map);
	}

	@Override
	public void forceAddMemo(User user, CalendarMemo memo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMemo(User user, LocalDate date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CalendarMemo getMemo(User user, LocalDate date) throws MemoNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarMemo> getMemosList(User user, LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setholiday(Trainer trainer, LocalDate date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancleSchdule(Trainer trainer, Schedule date, Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LocalDate> getTrainerSchdule(Trainer trainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalDate> getTrainerPTSchedule(Trainer trainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocalDate> getUserPTSchedule(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
