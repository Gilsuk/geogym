
package com.geogym.trainer.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.geogym.attachment.service.AttachmentService;
import com.geogym.attachment.service.AttachmentServiceImpl;
import com.geogym.common.service.SequenceService;
import com.geogym.memo.dto.CalendarMemo;
import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.dto.PeriodDateTime;
import com.geogym.schedule.dto.Schedule;
import com.geogym.trainer.dao.TrainerDao;
import com.geogym.trainer.dto.T_reputation;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;


@Service
public class TrainerServiceImpl implements TrainerService {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainerServiceImpl.class);

	@Autowired UserService userService;
	@Autowired TrainerDao trainerDao;
	@Autowired SequenceService seqService;
	@Autowired AttachmentService attachmentService;


	@Override
	public List<User> getClients(Trainer trainer) {
		// TODO Auto-generated method stub
		// 해당 트레이너의 PT 회원들을 조회
		
		List<User> list = trainerDao.getPtUserToTrainer(trainer) ;	
				
		
		return list;
	}

	/**
	 * 트레이너 생성
	 * 
	 * 서비스에서 서비스를 가져다 사용할 수 없는 문제있음.
	 *  
	 * 
	 * @param trainer - 트레이너 정보를 생성한다
	 * @param multipartFile - 트레이너 사진
	 */
	@Override
	public void insertTrainer(Trainer trainer, MultipartFile file) {
		// TODO Auto-generated method stub
		
		
		trainer.setAttachment(attachmentService.upload(file));
		
		trainerDao.insertTrainer(trainer);
		
		
	}


//	@Override
//	public List<UserEvaluation> selectEvaluation(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void updateTrainer(Trainer trainer, MultipartFile file) {
		// TODO Auto-generated method stub
		// 트레이너 테이블 수정
		
		Trainer trainer2 = getTrainer(trainer);
		
		
		if (file == null) {
			trainer.setAttachment(trainer2.getAttachment());
		}else {
			trainer.setAttachment(attachmentService.upload(file));
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
		// 트레이너 정보 받기
		
		return trainerDao.getTrainer(trainer);
	}


	@Override
	public void deleteTrainer(Trainer trainer, MultipartFile file) {
		// TODO Auto-generated method stub
		// 트레이너 제거하기
		
		
		trainer.setTrainer_address("없음");
		trainer.setTrainer_price(-1);
		trainer.setTrainer_profile("없음");
		
		attachmentService.removeAttachment(trainer);
		
		updateTrainer(trainer, file);
		
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
	public double getReputation(Trainer trainer) {
		// TODO Auto-generated method stub
		
		
		return trainerDao.getReputation(trainer);

	}
	
	@Override
	public double getAllReputation() {
		// TODO Auto-generated method stub
		return trainerDao.getAllReputation();
	}



	@Override
	public void reputate(T_reputation reputation) {
		// TODO Auto-generated method stub
		
		if (trainerDao.countReputate(reputation) >= 1) {
			System.out.println(reputation);
			trainerDao.updateReputate(reputation);
		}else {
			trainerDao.insertReputate(reputation);
		}
		
		
	}

//	@Override
//	public boolean checkTrainer(Trainer trainer) {
//		// TODO Auto-generated method stub
//		User user = new User();
//		
//		user.setUser_no(trainer.getUser_no());
//		try {
//			if (userService.getUserByUserno(user) != null) {
//				if (trainerDao.countUserNo(trainer) >= 1) {
//					
//					return true;
//				}
//				
//			}
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			return true;
//		}
//		
//		
//		return false;
//	구버전용
//	}





//	@Override
//	public void userEvaluation(User_issue user_issue) {
//		trainerDao.setUser_issue(user_issue);
//
//		
//	}

}
