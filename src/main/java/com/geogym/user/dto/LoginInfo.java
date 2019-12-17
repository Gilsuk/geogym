package com.geogym.user.dto;

public class LoginInfo {
	
	private String id;
	private String pw;
	private boolean shouldRemember;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean isShouldRemember() {
		return shouldRemember;
	}
	public void setShouldRemember(boolean shouldRemember) {
		this.shouldRemember = shouldRemember;
	}
	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", pw=" + pw + ", shouldRemember=" + shouldRemember + "]";
	}
}
