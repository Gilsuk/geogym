package com.geogym.trainer.service;

import java.util.List;

import com.geogym.body.dto.BodyInfo;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;
import com.geogym.user.dto.UserEvaluation;

public interface TrainerService {
	
	void setTrainerPrice(Trainer trainer);
	
	
	/**
	 * 
	 * @param trainer 해당 트레이너 번호에 해당하는 PT 회원들을 조회
	 * @return 회원정보반환
	 */
	List<BodyInfo> selectUser(Trainer trainer);
	
	
	/**
	 * 
	 * @param user 해당 유저번호에 맞는 유저에게 평가 내용 작성
	 * @param trainer 트레이너별로 회원정보 평가 삽입
	 */
	void userEvaluation(User user, Trainer trainer,UserEvaluation userEvaluation);
	
	
	List<UserEvaluation> selectEvaluation(User user);
	
	
}
