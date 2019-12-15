package com.geogym.schedule.service;

import java.util.List;

import com.geogym.schedule.dto.CalendarMemo;
import com.geogym.schedule.exception.MemoAlreadyExistException;
import com.geogym.schedule.exception.MemoNotFoundException;
import com.geogym.user.dto.User;

/**
 * 
 * 날짜별 운동 일지를 기록하는 서비스
 * 시간정보는 포함하지 않으며
 * LocalDate 클래스를 활용한다.
 * 
 * 
 * 
 * 
 * @author 이우철
 * 
 */
public interface ScheduleMemoService {
	
	/**
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param memo 메모의 내용과 날짜를 포함한다.
	 * @throws MemoAlreadyExistException 이미 해당 메모가 존재하는 경우
	 */
	void addMemo(User user, CalendarMemo memo) throws MemoAlreadyExistException;
	
	/**
	 * 존재하는 메모에 덮어 씌울 때
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param memo 메모의 내용과 날짜를 포함한다.
	 */
	void forceAddMemo(User user, CalendarMemo memo);
	
	/**
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param memo calendar_memo_date 필드를 포함하는 객체
	 */
	void deleteMemo(User user, CalendarMemo memo);
	
	/**
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param memo calendar_memo_date 필드를 포함하는 객체
	 * @return CalendarMemo의 모든 필드를 포함한다.
	 * @throws MemoNotFoundException 조회 결과가 없을 때
	 */
	CalendarMemo getMemo(User user, CalendarMemo memo) throws MemoNotFoundException;
	
	/**
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param from calendar_memo_date 필드를 포함하는 객체, 조회 시작 날짜
	 * @param to calendar_memo_date 필드를 포함하는 객체, 조회 종료 날짜, 시작 날짜보다 크다.
	 * @return CalendarMemo의 모든 필드를 포함한다.
	 */
	List<CalendarMemo> getMemosList(User user, CalendarMemo from, CalendarMemo to);
	
}
