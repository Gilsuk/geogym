package com.geogym.schedule.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.geogym.calendar.dto.DateContent;
import com.geogym.trainer.dto.Trainer;

public class Schedule implements DateContent{
	
	private int schedule_no;
	private Trainer trainer;
	private LocalDate schedule_date;
	private LocalTime schedule_from;
	private LocalTime schedule_to;
	private String schedule_msg;
	
	@Override
	public String toString() {
		return "MatchingSchedule [schedule_no=" + schedule_no + ", trainer=" + trainer + ", schedule_date="
				+ schedule_date + ", schedule_from=" + schedule_from + ", schedule_to=" + schedule_to
				+ ", schedule_msg=" + schedule_msg + "]";
	}
	
	public int getSchedule_no() {
		return schedule_no;
	}
	public void setSchedule_no(int schedule_no) {
		this.schedule_no = schedule_no;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public LocalDate getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(LocalDate schedule_date) {
		this.schedule_date = schedule_date;
	}
	public LocalTime getSchedule_from() {
		return schedule_from;
	}
	public void setSchedule_from(LocalTime schedule_from) {
		this.schedule_from = schedule_from;
	}
	public LocalTime getSchedule_to() {
		return schedule_to;
	}
	public void setSchedule_to(LocalTime schedule_to) {
		this.schedule_to = schedule_to;
	}
	public String getSchedule_msg() {
		return schedule_msg;
	}
	public void setSchedule_msg(String schedule_msg) {
		this.schedule_msg = schedule_msg;
	}

	@Override
	public LocalDate getDate() {
		
		return schedule_date;
	}

	@Override
	public String getContent() {
		
		return schedule_from+"~"+schedule_to;
	}

}
