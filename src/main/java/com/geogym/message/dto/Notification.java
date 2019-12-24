package com.geogym.message.dto;

import java.time.LocalDateTime;

public class Notification {
	
	private int notification_no;
	private String notification_content;
	private LocalDateTime notification_expire_date;
	
	@Override
	public String toString() {
		return "Notification [notification_no=" + notification_no + ", notification_content=" + notification_content
				+ ", notification_expire_date=" + notification_expire_date + "]";
	}
	
	public int getNotification_no() {
		return notification_no;
	}
	public void setNotification_no(int notification_no) {
		this.notification_no = notification_no;
	}
	public String getNotification_content() {
		return notification_content;
	}
	public void setNotification_content(String notification_content) {
		this.notification_content = notification_content;
	}

	public LocalDateTime getNotification_expire_date() {
		return notification_expire_date;
	}

	public void setNotification_expire_date(LocalDateTime notification_expire_date) {
		this.notification_expire_date = notification_expire_date;
	}

}