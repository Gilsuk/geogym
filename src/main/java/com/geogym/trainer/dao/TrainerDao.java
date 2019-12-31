package com.geogym.trainer.dao;

import java.util.List;

import com.geogym.payment.dto.PTTicket;
import com.geogym.trainer.dto.T_reputation;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public interface TrainerDao {


	
	/**
	 * 피티 티켓 정보로 트레이너 정보를 불러온다
	 * 
	 * @param ptTicket - 트레이너 번호를 추출한다
	 * @return Trainer - 트레이너 정보를 받아온다
	 */
	Trainer getTrainerToPtTicket(PTTicket ptTicket);
	
	/**
	 * 해당 트레이너의 PT 회원들을 조회
	 * 
	 * @param trainer - 해당 트레이너 번호를 사용한다
	 * @return List<User> - 회원 리스트
	 */
	List<User> getPtUserToTrainer(Trainer trainer);

//	/**
//	 * 
//	 * 
//	 * @param user_issue - 해당 user_issue 에 작성
//	 */
//	void setUser_issue(User_issue user_issue);

	/**
	 * 트레이너 테이블 수정
	 * 
	 * @param trainer - 이 테이블로 수정
	 */
	void updateTrainer(Trainer trainer);

	/**
	 * 
	 *  트레이너 리스트 받아오기 
	 *  회원이 트레이너전체 정보를 받아오고 싶을 때 사용한다
	 *  
	 * @return List<Trainer> - 리스트를 이용해 트레이너 정보를 받아온다
	 */
	List<Trainer> viewTrainerList();

	/**
	 * 트레이너 정보 조회
	 * 트레이너 정보 불러오기
	 * 트레이너의 상세정보 조회 시 사용한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @return	Trainer - 트레이너 DTO 를 불러온다
	 */
	Trainer getTrainer(Trainer trainer);

	/**
	 * 트레이너 평가(별점) 조회
	 *     
	 *     
	 * @param trainer -  PK를 기준으로 한다
	 * @return int - 별점 수치를 반환한다
	 */
	double getReputation(Trainer trainer);

	/**
	 * 트레이너 별점이 이미 등록되었는지 확인한다
	 * count 가 1 이상일 경우 작동한다
	 * 
	 * @param reputation - 유저번호, 트레이너번호를 사용한다
	 * @return - 일치하는 테이블의 숫자를 반환한다
	 */
	int countReputate(T_reputation reputation);

	/**
	 * 트레이너 별점이 이미 등록되었을 경우 이전의 별점을 업데이트한다
	 * 
	 * @param reputation - 유저번호, 트레이너번호로 식별, 별점을 업데이트한다
	 */
	void updateReputate(T_reputation reputation);

	/**
	 * 등록된 기록이 없을 경우 새 별점을 등록한다
	 * 
	 * @param reputation - 유저번호, 트레이너번호로 식별, 별점을 업데이트한다
	 */
	void insertReputate(T_reputation reputation);

	
	/**
	 * 트레이너 테이블 인서트한다
	 * 
	 * @param trainer - 트레이너 타입을 받아서 그대로 생성한다
	 */
	void insertTrainer(Trainer trainer);

	/**
	 * 트레이너 테이블의 user_no 를 받아서 
	 * 같은 user_no 를 가지는 테이블이 있는지 센다
	 * 
	 * 구버전용
	 * 
	 * @param trainer - user_no 를 받아서 사용한다
	 * @return - int 를 반환한다
	 */
//	int countUserNo(Trainer trainer);

	/**
	 * 전체 인원의 평점 평균을 구한다
	 * 
	 * @return - double
	 */
	double getAllReputation();

}
