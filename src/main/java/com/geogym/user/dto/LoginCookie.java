package com.geogym.user.dto;

import java.time.LocalDate;

public class LoginCookie {
	private String cookie_id;
	private String cookie_ip;
	private int user_no;
	private LocalDate cookie_last_login;
	public String getCookie_id() {
		return cookie_id;
	}
	public void setCookie_id(String cookie_id) {
		this.cookie_id = cookie_id;
	}
	public String getCookie_ip() {
		return cookie_ip;
	}
	public void setCookie_ip(String cookie_ip) {
		this.cookie_ip = cookie_ip;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public LocalDate getCookie_last_login() {
		return cookie_last_login;
	}
	public void setCookie_last_login(LocalDate cookie_last_login) {
		this.cookie_last_login = cookie_last_login;
	}
	@Override
	public String toString() {
		return "LoginCookie [cookie_id=" + cookie_id + ", cookie_ip=" + cookie_ip + ", user_no=" + user_no
				+ ", cookie_last_login=" + cookie_last_login + "]";
	}
}
