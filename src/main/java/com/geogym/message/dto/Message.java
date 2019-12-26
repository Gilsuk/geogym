package com.geogym.message.dto;

import java.time.LocalDateTime;

public class Message {
	
	private int message_no;
	private int user_no;
	private String message_content;
	private LocalDateTime message_date;
	private LocalDateTime message_expire_date;
	private boolean message_isread;
	
	@Override
	public String toString() {
		return "Message [message_no=" + message_no + ", user_no=" + user_no + ", message_content=" + message_content
				+ ", message_date=" + message_date + ", message_expire_date=" + message_expire_date
				+ ", message_isread=" + message_isread + "]";
	}
	
	public int getMessage_no() {
		return message_no;
	}
	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public LocalDateTime getMessage_date() {
		return message_date;
	}
	public void setMessage_date(LocalDateTime message_date) {
		this.message_date = message_date;
	}
	public LocalDateTime getMessage_expire_date() {
		return message_expire_date;
	}
	public void setMessage_expire_date(LocalDateTime message_expire_date) {
		this.message_expire_date = message_expire_date;
	}
	public boolean isMessage_isread() {
		return message_isread;
	}
	public void setMessage_isread(boolean message_isread) {
		this.message_isread = message_isread;
	}
	
}
