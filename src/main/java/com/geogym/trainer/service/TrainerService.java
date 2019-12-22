package com.geogym.trainer.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.geogym.body.dto.BodyInfo;
import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.dto.PeriodDateTime;
import com.geogym.schedule.dto.Schedule;
import com.geogym.schedule.dto.ScheduleMemo;
import com.geogym.trainer.dto.PtTicket;
import com.geogym.trainer.dto.Trainer;
import com.geogym.trainer.exception.UserNotTrainerException;
import com.geogym.user.dto.User;
import com.geogym.user.dto.UserEvaluation;

public interface TrainerService {
	
	
	/**
	 *  유저와 연결된 트레이너 정보를 불러온다
	 * 
	 * @param user - 유저정보를 받아온다
	 * @return Trainer - 유저와 pt 하는 트레이너 리턴
	 * @throws UserNotTrainerException - 유저가 pt 하는 트레이너가 없을 때
	 */
	Trainer getTrainerByUserno(User user) throws UserNotTrainerException;
	
	/**
	 * 해당 트레이너의 PT 회원들을 조회
	 * 
	 * 
	 * @param trainer - 해당 트레이너 번호를 사용한다
	 * @return List<BodyInfo> - 회원들의 몸 상태 정보를 리스트로 반환 
	 */
	List<BodyInfo> selectUser(Trainer trainer);
	
	
	/**
	 * 
	 * 
	 * @param user 해당 유저번호에 맞는 유저에게 평가 내용 작성
	 * @param trainer 트레이너별로 회원정보 평가 삽입
	 */
	void userEvaluation(PtTicket pt_ticket);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	List<UserEvaluation> selectEvaluation(User user);
	
	/**
	 * 트레이너별 몸값(일일PT 신청시 차감되는 근) 책정
	 * 
	 * @param trainer - 트레이너 정보를 받아 그 트레이너의 근 수치를 설정한다
	 */
	void setTrainerPrice(Trainer trainer);
	
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
	 * 트레이너 프로필 수정
	 * 
	 * 트레이너 정보 업데이트하기
	 * 
	 * 미리 selectTrainer 구문을 이용해 해당 트레이너의 모든 정보를 불러온 후
	 * 업데이트 하고 싶은 부분만 바꿔서 업데이트한다.
	 * 
	 * 
	 * 업데이트 후 selectTrainer 를 수행하여 수정된 정보를 반환한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @return	Trainer - 트레이너 DTO 를 불러온다
	 */
	Trainer updateTraner(Trainer trainer);
	
	/**
	 * 트레이너 정보 삭제
	 * 미리 selectTrainer 구문을 이용해 해당 트레이너의 모든 정보를 불러온 후
	 * PK 를 제외한 모든 값을 null 로 넣어 updateTraner 를 이용해 업데이트한다
	 * 
	 * 업데이트 후 selectTrainer 를 수행하여 수정된 정보를 반환한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @return Trainer - 트레이너 DTO 를 불러온다
	 */
	Trainer deleteTraner(Trainer trainer);
	
	
	/**
	 * 트레이너 한달 단위 근무일정 맵 받아오는 서비스
	 * 이 서비스에서 관련 서비스들을 호출한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해당 월 정보를 입력받는다
	 * @return Map<LocalDate, List<ScheduleMemo>> - 날 을 키로 두고 근무, 휴일 등을 벨류값으로 리턴한다
	 */
	Map<LocalDate, String> getMapScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 조회
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 * @return String - 해당 일에 해당 트레이너의 스케쥴 정보를 근무, 휴일 등으로 불러온다 
	 */
	String selectScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 스케줄 입력
	 * 
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 * 
	 */
	void insertScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 스케줄 수정
	 * 
	 * 하루 단위의 스케줄은 무조건 존재해야만 하기 때문에 딜리트 서비스는 없다.
	 *  
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 */
	void updateScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 한 주 단위 근무일정 맵 받아오는 서비스
	 * 컨트롤러는 이 서비스를, 이 서비스에서 관련 서비스들을 호출한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 기준점이 될 일 정보를 입력받는다
	 * @return Map<LocalDate, List<ScheduleMemo>> - 날 을 키로 두고 해당일의 List<ScheduleMemo>를 벨류값으로 리턴한다
	 */
	Map<LocalDate, List<ScheduleMemo>> getMapScheduleTimeTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄 리스트로 받아오기
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 * @return List<ScheduleMemo> - 해당 일 스케쥴들을 리스트를 이용하여 받아온다
	 */
	List<ScheduleMemo> selectScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄 입력
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 * @return Map<LocalDate, List<ScheduleMemo>> - DB 수정 후 주단위 근무일정 페이지로 갈 수 있도록 한다
	 */
	void insertScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄 수정하기
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 */
	void modifySchedule(Schedule schedule);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄 제거하기
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 */
	void removeSchedule(Schedule schedule);
	
	
	
	
	/**
	 * 트레이너 평가(별점) 조회
	 *     
	 *     
	 * @param trainer -  PK를 기준으로 한다
	 * @return int - 별점 수치를 반환한다
	 */
	int getReputation(Trainer trainer);
	
	/**
	 * 트레이너 평가(별점) 등록
	 * 한 사람이 두 번 등록하지 못하도록 한다
	 * 게시판의 추천 기능을 응용
	 * 
	 * @param trainer - PK를 기준으로 한다
	 * @param i - 입력하는 별점 수치
	 */
	void reputate(Trainer trainer, int i);
	
	/**
	 * 이용권 등록한 추천인 수 조회 
	 * 
	 * @param trainer - PK를 기준으로 한다
	 * @return - 추천인 수 반환
	 */
	int countReferrer(Trainer trainer);
}

