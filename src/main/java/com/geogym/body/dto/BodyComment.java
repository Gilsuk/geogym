package com.geogym.body.dto;

import java.time.LocalDateTime;

public class BodyComment {
	
	private int body_comment_no;
	private int bodyinfo_no;
	private int trainer_no;
	private String user_name; // 코멘트를 작성한 트레이너의 이름
	private String body_comment_msg;
	private LocalDateTime body_comment_date;
	@Override
	public String toString() {
		return "BodyCommentary [body_comment_no=" + body_comment_no + ", bodyinfo_no=" + bodyinfo_no + ", trainer_no="
				+ trainer_no + ", user_name=" + user_name + ", body_comment_msg=" + body_comment_msg
				+ ", body_comment_date=" + body_comment_date + "]";
	}
	public int getBody_comment_no() {
		return body_comment_no;
	}
	public void setBody_comment_no(int body_comment_no) {
		this.body_comment_no = body_comment_no;
	}
	public int getBodyinfo_no() {
		return bodyinfo_no;
	}
	public void setBodyinfo_no(int bodyinfo_no) {
		this.bodyinfo_no = bodyinfo_no;
	}
	public int getTrainer_no() {
		return trainer_no;
	}
	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBody_comment_msg() {
		return body_comment_msg;
	}
	public void setBody_comment_msg(String body_comment_msg) {
		this.body_comment_msg = body_comment_msg;
	}
	public LocalDateTime getBody_comment_date() {
		return body_comment_date;
	}
	public void setBody_comment_date(LocalDateTime body_comment_date) {
		this.body_comment_date = body_comment_date;
	}
}
