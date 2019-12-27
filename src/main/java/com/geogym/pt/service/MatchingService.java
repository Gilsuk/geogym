package com.geogym.pt.service;

import java.time.LocalDate;
import java.util.List;

import com.geogym.pt.dto.PT;
import com.geogym.pt.exception.LessThanOneHourException;
import com.geogym.pt.exception.MatchingNotAvailable;
import com.geogym.schedule.dto.Schedule;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public interface MatchingService {
	
	/**
	 * 매칭시 회원 일정, 트레이너 일정에 각각 추가
	 * 쿠폰 또는 캐시 차감
	 * @param schedule
	 * @throws MatchingNotAvailable 시간차로 먼저 예약이 잡힌 경우
	 */
	void match(User user, Schedule schedule) throws MatchingNotAvailable;
	
	/**
	 * 회원과 트레이너 일정에서 각각 삭제
	 * 알림 발송
	 * 환불
	 * 
	 * PT까지 남은 시간이 1시간 미만이면 예외 처리
	 * 
	 * @param schedule 취소할 일정
	 * @param msg 취소 사유
	 */
	void cancle(Schedule schedule, String msg) throws LessThanOneHourException;
	
	/**
	 * PT신청시 정기권이 있는 트레이너인지 체크
	 * 
	 * @param user
	 * @param trainer
	 * @return
	 */
	boolean isSubscribedTrainer(User user, Trainer trainer);
	
	/**
	 * 해당 유저의 PT 일정들 받아오기
	 * 
	 * @param user
	 * @return
	 */
	List<PT> getPTInfos(User user, LocalDate today);
	
	
	/**
	 * 담당 회원 등록
	 * 
	 * 해당 트레이너에게 PT 매칭시 등록하기
	 * 
	 * @param trainer-트레이너 PK를 기준으로 한다
	 * @param member-회원 PK 를 기준으로 한다
	 */
	void ptJoin(Trainer trainer, User user);

	/**
	 * 회원 수 조회
	 * 
	 * 해당 트레이너와 PT 를 진행하고 있는 회원 수 조회 
	 * 
	 * 
	 * @param trainer -트레이너 PK를 기준으로 한다
	 * @return int - 회원수
	 */
	int ptMemberWithTraner(Trainer trainer);
	
	/**
	 * PT 매칭시 변동된 근 집계
	 * 
	 * @param trainer - 트레이너 PK를 기준으로 한다
	 * @param i - 변동시킬 근 수치
	 * @return int - 변동된 근 수치
	 */
	int updateCoinTraner(Trainer trainer, int i);
}
