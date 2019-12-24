package com.geogym.trainer.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.memo.dto.CalendarMemo;
import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.dto.PeriodDateTime;
import com.geogym.schedule.dto.Schedule;
import com.geogym.trainer.dao.TrainerDao;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;
import com.geogym.user.dto.UserEvaluation;


@Service
public class TrainerServiceImpl implements TrainerService {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainerServiceImpl.class);

	
	@Autowired TrainerDao trainerDao;



	@Override
	public List<User> getClients(Trainer trainer) {
		// TODO Auto-generated method stub
		// 해당 트레이너의 PT 회원들을 조회
		
		List<User> list = trainerDao.getPtUserToTrainer(trainer) ;	
				
		
		return list;
	}



//	@Override
//	public List<UserEvaluation> selectEvaluation(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void updateTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		// 트레이너 테이블 수정
		
		Trainer trainer2 = getTrainer(trainer);
		
		if (trainer.getAttachment_no() == 0) {
			trainer.setAttachment_no(trainer2.getAttachment_no());
		}
		if (trainer.getTrainer_address() == null) {
			trainer.setTrainer_address(trainer2.getTrainer_address());
		}
		if (trainer.getTrainer_price() == 0) {
			trainer.setTrainer_price(trainer2.getTrainer_price());
		}
		if (trainer.getTrainer_profile() == null) {
			trainer.setTrainer_profile(trainer2.getTrainer_profile());
		}
		
		trainerDao.updateTrainer(trainer);
		
	}

	@Override
	public List<Trainer> viewTrainerList() {
		// TODO Auto-generated method stub
		// 트레이너 리스트 받아오기
		return trainerDao.viewTrainerList();
	}

	@Override
	public Trainer getTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return trainerDao.getTrainer(trainer);
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

//	@Override
//	public void userEvaluation(User_issue user_issue) {
//		trainerDao.setUser_issue(user_issue);
//
//		
//	}

}
