package com.geogym.schedule.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.geogym.trainer.dto.Trainer;

public interface AvilableTime {
	
	/**
	 * 트레이너의 빈 시간을 30분 단위로 끊어서 리스트로 리턴
	 * 
	 * 마지막 시간은 최소 1시간 텀은 필요하다
	 * ex)트레이너의 2시에 스케줄이 있으면 1:30은 제외
	 * 
	 * @param trainer
	 * @param locaDate
	 * @return
	 */
	List<LocalTime> getAvilableTime(Trainer trainer, LocalDate locaDate);

}
