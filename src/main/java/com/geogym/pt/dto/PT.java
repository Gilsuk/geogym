package com.geogym.pt.dto;

import java.time.LocalDateTime;

import com.geogym.user.dto.User;

public class PT {
	
	private int schedule_no;
	private int pt_type_no;
	private User user;
	private LocalDateTime pt_request_date;
	private LocalDateTime pt_date;
	
	@Override
	public String toString() {
		return "PT [schedule_no=" + schedule_no + ", pt_type_no=" + pt_type_no + ", user=" + user + ", pt_request_date="
				+ pt_request_date + ", pt_date=" + pt_date + "]";
	}
	
	public int getSchedule_no() {
		return schedule_no;
	}
	public void setSchedule_no(int schedule_no) {
		this.schedule_no = schedule_no;
	}
	public int getPt_type_no() {
		return pt_type_no;
	}
	public void setPt_type_no(int pt_type_no) {
		this.pt_type_no = pt_type_no;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getPt_request_date() {
		return pt_request_date;
	}
	public void setPt_request_date(LocalDateTime pt_request_date) {
		this.pt_request_date = pt_request_date;
	}
	public LocalDateTime getPt_date() {
		return pt_date;
	}
	public void setPt_date(LocalDateTime pt_date) {
		this.pt_date = pt_date;
	}

}