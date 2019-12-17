package com.geogym.trainer.service;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.dto.PeriodDateTime;
import com.geogym.schedule.dto.ScheduleMemo;
import com.geogym.trainer.dto.Trainer;

public interface TrainerService {
	
	/**
	 * 트레이너별 몸값(일일PT 신청시 차감되는 근) 책정
	 * 
	 * @param trainer - 트레이너 정보를 받아 그 트레이너의 근 수치를 설정한다
	 * 
	 *  밑의 tranerUpdate 로 통합할 수 있을 가능성 존재함
	 */
	public void setTrainerPrice(Trainer trainer);
	
	/**
	 * 
	 *  트레이너 리스트 받아오기 
	 *  회원이 트레이너전체 정보를 받아오고 싶을 때 사용한다
	 *  
	 * @return List<Trainer> 리스트를 이용해 트레이너 정보를 받아온다
	 */
	public List<Trainer> viewTrainerList();
	
	/**
	 * 트레이너 정보 조회
	 * 트레이너 정보 불러오기
	 * 트레이너의 상세정보 조회 시 사용한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @return	Trainer - 트레이너 DTO 를 불러온다
	 */
	public Trainer selectTrainer(Trainer trainer);
	
	
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
	public Trainer updateTraner(Trainer trainer);
	
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
	public Trainer deleteTraner(Trainer trainer);
	
	
	/**
	 * 트레이너 한달 단위 근무일정 맵 받아오는 서비스
	 * 이 서비스에서 관련 서비스들을 호출한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해당 월 정보를 입력받는다
	 * @return Map<LocalDate, List<ScheduleMemo>> - 날 을 키로 두고 근무, 휴일 등을 벨류값으로 리턴한다
	 */
	public Map<LocalDate, String> getMapScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 조회
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 * @return String - 해당 일에 해당 트레이너의 스케쥴 정보를 근무, 휴일 등으로 불러온다 
	 */
	public String selectScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 스케줄 입력
	 * 입력 후 getMapScheduleDateTraner 를 호출한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 * @return Map<Trainer, PeriodDate> - DB 수정 후 월단위 근무일정 페이지로 갈 수 있도록 Trainer, PeriodDate를 반환한다
	 */
	public Map<LocalDate, String> insertScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 스케줄 수정
	 * 수정 후 getMapScheduleDateTraner 를 호출한다
	 * 
	 * 하루 단위의 스케줄은 무조건 존재해야만 하기 때문에 딜리트 서비스는 없다.
	 *  
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 * @return Map<LocalDate, String> - DB 수정 후 월단위 근무일정 페이지로 갈 수 있도록 Trainer, PeriodDate를 반환한다
	 */
	public Map<LocalDate, String> updateScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 한 주 단위 근무일정 맵 받아오는 서비스
	 * 컨트롤러는 이 서비스를, 이 서비스에서 관련 서비스들을 호출한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 기준점이 될 일 정보를 입력받는다
	 * @return Map<LocalDate, List<ScheduleMemo>> - 날 을 키로 두고 해당일의 List<ScheduleMemo>를 벨류값으로 리턴한다
	 */
	public Map<LocalDate, List<ScheduleMemo>> getMapScheduleTimeTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄 리스트로 받아오기
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 * @return List<ScheduleMemo> - 해당 일 스케쥴들을 리스트를 이용하여 받아온다
	 */
	public List<ScheduleMemo> selectScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄 입력
	 * 입력 후 getMapScheduleTimeTraner 를 호출한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 * @return Map<LocalDate, List<ScheduleMemo>> - DB 수정 후 주단위 근무일정 페이지로 갈 수 있도록 한다
	 */
	public Map<LocalDate, List<ScheduleMemo>> insertScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄 수정하기
	 *  수정 후 getMapScheduleTimeTraner 를 호출한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 * @return Map<Trainer, PeriodDateTime> - DB 수정 후 주단위 근무일정 페이지로 갈 수 있도록 한다
	 */
	public Map<LocalDate, List<ScheduleMemo>> updateScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄 제거하기
	 * 제거 후 getMapScheduleTimeTraner 를 호출한다
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 * @return Map<Trainer, PeriodDateTime> - DB 수정 후 주단위 근무일정 페이지로 갈 수 있도록 한다
	 */
	public Map<LocalDate, List<ScheduleMemo>> deldetScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	
	/**
	 * PT 매칭시 변동된 근 집계
	 * 
	 * @param trainer - 트레이너 PK를 기준으로 한다
	 * @param i - 변동시킬 근 수치
	 * @return int - 변동된 근 수치
	 */
	public int updateCoinTraner(Trainer trainer, int i);
	
	/**
	 * 회원 수 조회
	 * 
	 * 해당 트레이너와 PT 를 진행하고 있는 회원 수 조회 
	 * 
	 * 
	 * @param trainer -트레이너 PK를 기준으로 한다
	 * @return int - 회원수
	 */
	public int ptMemberWithTraner(Trainer trainer);
	
	/**
	 * 담당 회원 등록
	 * 
	 * 해당 트레이너에게 PT 매칭시 등록하기
	 * 
	 * @param trainer-트레이너 PK를 기준으로 한다
	 * @param member-회원 PK 를 기준으로 한다
	 */
	public void ptJoin(Trainer trainer, Member member);
	
	/**
	 * 트레이너 평가(별점) 조회
	 *     
	 *     
	 * @param trainer -  PK를 기준으로 한다
	 * @return int - 별점 수치를 반환한다
	 */
	public int reputationSelectTrainer(Trainer trainer);
	
	
	/**
	 * 트레이너 평가(별점) 등록
	 * 한 사람이 두 번 등록하지 못하도록 한다
	 * 게시판의 추천 기능을 응용
	 * 
	 * @param trainer - PK를 기준으로 한다
	 * @param i - 입력하는 별점 수치
	 */
	public void reputationUpdateTrainer(Trainer trainer, int i);
	
	/**
	 * 이용권 등록한 추천인 수 조회 
	 * 
	 * @param trainer - PK를 기준으로 한다
	 * @return - 추천인 수 반환
	 */
	public int countReferrer(Trainer trainer);
	
	
	/**
	 * 잡힌 일정 취소 사유와 함께 취소 가능(자동으로 알림 발송
	 * 
	 * MessageService 의 sendMessage 를 활용한다
	 * 
	 * @param trainer - PK를 기준으로 한다
	 * @param member - PK를 기준으로 한다
	 * @param string - 발송할 취소사유
	 */
	public void cancelPt(Trainer trainer, Member member, String string);

}






































