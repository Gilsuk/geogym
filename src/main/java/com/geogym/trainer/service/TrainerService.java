package com.geogym.trainer.service;

import java.util.List;

import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.dto.PeriodDateTime;
import com.geogym.schedule.dto.ScheduleMemo;
import com.geogym.trainer.dto.Trainer;

public interface TrainerService {
	
	/**
	 * 트레이너 pt 근 값어치 설정
	 * @param trainer - 트레이너 정보를 받아 그 트레이너의 근 수치를 설정한다
	 * 
	 *  밑의 tranerUpdate 로 통합할 수 있을 가능성 존재함
	 */
	public void setTrainerPrice(Trainer trainer);
	
	/**
	 *  트레이너 리스트 받아오기 
	 *  
	 * @return List<Trainer> 리스트를 이용해 트레이너 정보를 받아온다
	 */
	public List<Trainer> viewTrainerList();
	
	/**
	 * 트레이너 정보 불러오기
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @return	Trainer - 트레이너 DTO 를 불러온다
	 */
	public Trainer selectTrainer(Trainer trainer);
	
	
	/**
	 * 트레이너 정보 업데이트하기
	 * 
	 * 미리 selectTrainer 구문을 이용해 해당 트레이너의 모든 정보를 불러온 후
	 * 업데이트 하고 싶은 부분만 바꿔서 업데이트한다.
	 * 
	 */
	public void updateTraner(Trainer trainer);
	
	
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 조회
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 * @return List<ScheduleMemo> - 해당 일에 해당 트레이너의 스케쥴 정보를 리스트로 불러온다 
	 */
	public List<ScheduleMemo> selectScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 스케줄 입력
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 * @return ScheduleMemo - 리턴타입을 void 로 바꿔도 무방하다
	 */
	public ScheduleMemo insertScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 날 단위 구분 스케줄 수정
	 * 
	 * 하루 단위의 스케줄은 무조건 존재해야만 한다.
	 *  
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDate - 해달 일 정보를 받아온다
	 * @return ScheduleMemo - 리턴타입을 void 로 바꿔도 무방하다
	 */
	public ScheduleMemo updateScheduleDateTraner(Trainer trainer, PeriodDate periodDate);
	
	/**
	 * 트레이너 근무일정 중 시간단위 스케줄
	 * 
	 * 
	 * @param trainer - 트레이너 ID 혹은 트레이너 번호를 기준으로 한다
	 * @param periodDateTime - 해달 일,시 정보를 받아온다
	 * @return List<ScheduleMemo> - 
	 */
	public List<ScheduleMemo> selectScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	public ScheduleMemo updateScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	public ScheduleMemo deldetScheduleTimeTraner(Trainer trainer, PeriodDateTime periodDateTime);
	
	
	

}