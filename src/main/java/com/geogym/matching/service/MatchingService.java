package com.geogym.matching.service;

import java.time.LocalDateTime;
import java.util.List;

import com.geogym.matching.dto.MatchingSchedule;
import com.geogym.matching.exception.LessThanOneHourException;
import com.geogym.matching.exception.MatchingNotAvailable;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public interface MatchingService {
	
	/**
	 * 매칭시 회원 일정, 트레이너 일정에 각각 추가
	 * 쿠폰 또는 캐시 차감
	 * @param schedule
	 * @throws MatchingNotAvailable 시간차로 먼저 예약이 잡힌 경우
	 */
	void match(MatchingSchedule schedule) throws MatchingNotAvailable;
	
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
	void cancle(MatchingSchedule schedule, String msg) throws LessThanOneHourException;
	
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
	List<MatchingSchedule> getPTInfos(User user, LocalDateTime today);
	
}
