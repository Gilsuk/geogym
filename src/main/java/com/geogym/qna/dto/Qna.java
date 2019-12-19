package com.geogym.qna.dto;

public class Qna {
	
	private int qna_no;
	private int user_no;
	private int qna_category_no;
	private String qna_title;
	private String qna_content;
	private String qna_date;
	private boolean qna_private;
	private boolean qna_notice;
	@Override
	public String toString() {
		return "Qna [qna_no=" + qna_no + ", user_no=" + user_no + ", qna_category_no=" + qna_category_no
				+ ", qna_title=" + qna_title + ", qna_content=" + qna_content + ", qna_date=" + qna_date
				+ ", qna_private=" + qna_private + ", qna_notice=" + qna_notice + "]";
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getQna_category_no() {
		return qna_category_no;
	}
	public void setQna_category_no(int qna_category_no) {
		this.qna_category_no = qna_category_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_date() {
		return qna_date;
	}
	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}
	public boolean isQna_private() {
		return qna_private;
	}
	public void setQna_private(boolean qna_private) {
		this.qna_private = qna_private;
	}
	public boolean isQna_notice() {
		return qna_notice;
	}
	public void setQna_notice(boolean qna_notice) {
		this.qna_notice = qna_notice;
	}
	
	
	
	

}
