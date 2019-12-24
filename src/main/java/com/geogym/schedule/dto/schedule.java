package com.geogym.schedule.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class schedule {
	private int schedule_no;
	private int trainer_no;
	private LocalDate schedule_data;
	private LocalTime schedule_from;
	private LocalTime schedule_to;
	private String schedule_msg;
	@Override
	public String toString() {
		return "schedule [schedule_no=" + schedule_no + ", trainer_no=" + trainer_no + ", schedule_data="
				+ schedule_data + ", schedule_from=" + schedule_from + ", schedule_to=" + schedule_to
				+ ", schedule_msg=" + schedule_msg + "]";
	}
	public int getSchedule_no() {
		return schedule_no;
	}
	public void setSchedule_no(int schedule_no) {
		this.schedule_no = schedule_no;
	}
	public int getTrainer_no() {
		return trainer_no;
	}
	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}
	public LocalDate getSchedule_data() {
		return schedule_data;
	}
	public void setSchedule_data(LocalDate schedule_data) {
		this.schedule_data = schedule_data;
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
	
	
	
	
	
	
	
}
