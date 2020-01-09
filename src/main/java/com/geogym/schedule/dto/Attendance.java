package com.geogym.schedule.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {
	private LocalDate attendance_date;
	private int trainer_no;
	private LocalTime attendance_start;
	private LocalTime attendance_end;
	@Override
	public String toString() {
		return "Attendance [attendance_date=" + attendance_date + ", trainer_no=" + trainer_no + ", attendance_start="
				+ attendance_start + ", attendance_end=" + attendance_end + "]";
	}
	public LocalDate getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(LocalDate attendance_date) {
		this.attendance_date = attendance_date;
	}
	public int getTrainer_no() {
		return trainer_no;
	}
	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}
	public LocalTime getAttendance_start() {
		return attendance_start;
	}
	public void setAttendance_start(LocalTime attendance_start) {
		this.attendance_start = attendance_start;
	}
	public LocalTime getAttendance_end() {
		return attendance_end;
	}
	public void setAttendance_end(LocalTime attendance_end) {
		this.attendance_end = attendance_end;
	}
	
	
}
