package com.geogym.body.service;

import java.util.List;

import com.geogym.body.dto.BodyCommentary;
import com.geogym.body.dto.BodyInfo;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.exception.TooLongPeriodException;
import com.geogym.user.dto.User;

public interface BodyInfoService {
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	BodyInfo getRecentBodyInfo(User user);
	
	/**
	 * 신체 정보를 새로 삽입하거나 중복이면 덮어씌운다.
	 * @param bodyinfo
	 * @throws ParamIncorrectException bodyinfo 내의 필드가 다 채워지지 않은 경우
	 */
	void setBodyInfo(BodyInfo bodyinfo) throws ParamIncorrectException;
	
	/**
	 * 신체정보를 삭제한다. 삭제 할 때 연결된 코멘터리 정보도 삭제한다.
	 */
	void deleteBodyInfo(BodyInfo bodyinfo);
	
	/**
	 * Period 대신 paging으로 처리하는 것도 고려해봄직
	 */
	List<BodyInfo> getBodyInfosByPeriod(User user, PeriodDate period)
			throws TooLongPeriodException;

	/**
	 * 주마다 한 건씩 조회한다.
	 */
	List<BodyInfo> getBodyInfosByWeek(User user, PeriodDate period)
			throws TooLongPeriodException;

	/**
	 * 월말 기준으로 한 건씩 조회 한다.
	 */
	List<BodyInfo> getBodyInfosByMonth(User user, PeriodDate period)
			throws TooLongPeriodException;

	/**
	 * 신체정보에 달린 트레이너의 코멘터리를 조회
	 * @param bodyinfo
	 * @return
	 */
	BodyCommentary getCommentary(BodyInfo bodyinfo);
	
	/**
	 * 개인 코멘트는 굳이 필요 없는듯 하여
	 * 트레이너만 작성 가능하도록 메소드를 정의함
	 * @throws ParamIncorrectException 필드가 비어있는 경우
	 */
	void setBodyCommentary(BodyCommentary commentary)
			throws ParamIncorrectException;
	
	void deleteBodyCommentary(BodyCommentary commentary);
	
}
