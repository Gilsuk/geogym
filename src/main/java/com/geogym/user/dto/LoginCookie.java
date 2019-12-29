package com.geogym.user.dto;

import java.time.LocalDate;

public class LoginCookie {
	private String cookie_ip;
	private String cookie_id;
	private int user_no;
	private LocalDate cookie_date;
	@Override
	public String toString() {
		return "LoginCookie [cookie_ip=" + cookie_ip + ", cookie_id=" + cookie_id + ", user_no=" + user_no
				+ ", cookie_date=" + cookie_date + "]";
	}
	public String getCookie_ip() {
		return cookie_ip;
	}
	public void setCookie_ip(String cookie_ip) {
		this.cookie_ip = cookie_ip;
	}
	public String getCookie_id() {
		return cookie_id;
	}
	public void setCookie_id(String cookie_id) {
		this.cookie_id = cookie_id;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public LocalDate getCookie_date() {
		return cookie_date;
	}
	public void setCookie_date(LocalDate cookie_date) {
		this.cookie_date = cookie_date;
	}
}
