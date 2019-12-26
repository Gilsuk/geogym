package com.geogym.user.dto;

import com.geogym.common.encrypt.HashConverter;

public class LoginInfo {
	
	private String user_id;
	private String user_pw;
	private boolean shouldRemember;
	@Override
	public String toString() {
		return "LoginInfo [user_id=" + user_id + ", user_pw=" + user_pw + ", shouldRemember=" + shouldRemember + "]";
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = HashConverter.toHash(user_pw);
	}
	public boolean isShouldRemember() {
		return shouldRemember;
	}
	public void setShouldRemember(boolean shouldRemember) {
		this.shouldRemember = shouldRemember;
	}
}
