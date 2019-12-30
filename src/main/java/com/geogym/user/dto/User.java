package com.geogym.user.dto;

import java.time.LocalDate;

import com.geogym.common.encrypt.HashConverter;

public class User {
	
	private int user_no;
	private String user_name;
	private char user_gender;
	private LocalDate user_birth;
	private String user_tel;
	private String user_id;
	private String user_pw;
	private String user_email;
	private boolean user_email_verified;
	private boolean user_tel_verified;
	
	@Override
	public String toString() {
		return "User [user_no=" + user_no + ", user_name=" + user_name + ", user_gender=" + user_gender
				+ ", user_birth=" + user_birth + ", user_tel=" + user_tel + ", user_id=" + user_id + ", user_pw="
				+ user_pw + ", user_email=" + user_email + ", user_email_verified=" + user_email_verified
				+ ", user_tel_verified=" + user_tel_verified + "]";
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public char getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(char user_gender) {
		this.user_gender = user_gender;
	}
	public LocalDate getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(LocalDate user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
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
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public boolean isUser_email_verified() {
		return user_email_verified;
	}
	public void setUser_email_verified(boolean user_email_verified) {
		this.user_email_verified = user_email_verified;
	}
	public boolean isUser_tel_verified() {
		return user_tel_verified;
	}
	public void setUser_tel_verified(boolean user_tel_verified) {
		this.user_tel_verified = user_tel_verified;
	}
}
