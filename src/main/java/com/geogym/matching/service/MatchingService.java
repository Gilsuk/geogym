package com.geogym.matching.service;

import com.geogym.matching.dto.MatchingSchedule;
import com.geogym.matching.exception.MatchingNotAvailable;

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
	 * @param schedule 취소할 일정
	 * @param msg 취소 사유
	 */
	void cancle(MatchingSchedule schedule, String msg);

}
