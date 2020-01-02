package com.geogym.memo.dto;

import java.time.LocalDate;

public class CalendarMemo {
	
	private int calendar_memo_no;
	private int user_no;
	private LocalDate calendar_memo_date;
	private String calendar_memo_content;
	
	@Override
	public String toString() {
		return "CalendarMemo [calendar_memo_no=" + calendar_memo_no + ", user_no=" + user_no + ", calendar_memo_date="
				+ calendar_memo_date + ", calendar_memo_content=" + calendar_memo_content + "]";
	}
	
	public int getCalendar_memo_no() {
		return calendar_memo_no;
	}
	public void setCalendar_memo_no(int calendar_memo_no) {
		this.calendar_memo_no = calendar_memo_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public LocalDate getCalendar_memo_date() {
		return calendar_memo_date;
	}
	public void setCalendar_memo_date(LocalDate calendar_memo_date) {
		this.calendar_memo_date = calendar_memo_date;
	}
	public String getCalendar_memo_content() {
		return calendar_memo_content;
	}
	public void setCalendar_memo_content(String calendar_memo_content) {
		this.calendar_memo_content = calendar_memo_content;
	}
}