package com.geogym.schedule.service;

import java.time.LocalDate;
import java.util.List;

import com.geogym.matching.dto.MatchingSchedule;
import com.geogym.message.dto.Message;
import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.dto.ScheduleMemo;
import com.geogym.schedule.dto.WorkingTimeInfo;
import com.geogym.schedule.exception.MemoAlreadyExistException;
import com.geogym.schedule.exception.MemoNotFoundException;
import com.geogym.trainer.dto.Trainer;
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
	public void addMemo(User user, ScheduleMemo memo) throws MemoAlreadyExistException;
	
	/**
	 * 존재하는 메모에 덮어 씌울 때
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param memo 메모의 내용과 날짜를 포함한다.
	 */
	void forceAddMemo(User user, ScheduleMemo memo);
	
	/**
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param memo calendar_memo_date 필드를 포함하는 객체
	 */
	void deleteMemo(User user, LocalDate date);
	
	/**
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param memo 조회 하려는 날짜
	 * @return ScheduleMemo의 모든 필드를 포함한다.
	 * @throws MemoNotFoundException 조회 결과가 없을 때
	 */
	ScheduleMemo getMemo(User user, LocalDate date) throws MemoNotFoundException;
	
	/**
	 * 
	 * @param user user_no 필드를 포함하는 객체
	 * @param from 조회 시작 날짜
	 * @param to 조회 종료 날짜, 시작 날짜보다 크다.
	 * @return ScheduleMemo의 모든 필드를 포함한다.
	 */
	List<ScheduleMemo> getMemosList(User user, LocalDate from, LocalDate to);
	
	
	/**
	 * 
	 * @param trainer no를 포함하는 객체
	 * @param date 트레이너가 지정한 휴일,근무 ,기타 날짜 저장
	 * 
	 */
	void setholiday(Trainer trainer,LocalDate date);
	
	
	
	/**
	 * 
	 * @param trainer no를 포함하는 객체
	 * @param date 트레이너 저장된 일정을 취소(delete) 
	 * @param message 취소사유를 알림에 저장후 , 해당 회원에게 출력.
	 */
	void cancleSchdule(Trainer trainer,MatchingSchedule date, Message message );
	
	
	
	
	
	/**
	 * 
	 * @param trainer 해당 트레이너 번호를보내서 그 트레이너에 해당하는 휴무 근무 날짜를 반환한다
	 * @return
	 */
	List<LocalDate> getTrainerSchdule(Trainer trainer);
	
	/**
	 * 
	 * @param trainer 해당 트레이너 번호를 보내 그 트레이너에 해당하는 PT매칭 날짜를 반환한다
	 * @return
	 */
	List<LocalDate> getTrainerPTSchedule(Trainer trainer);
	
	/**
	 * 
	 * @param user 해당 유저번호에 해당하는 user PT 스케줄 날짜를 반환한다
	 * @return
	 */
	List<LocalDate> getUserPTSchedule(User user);
	
	
}
