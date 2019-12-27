package com.geogym.qna.dto;

public class Qna {
	
	private int qna_no; //qan 번호
	private int user_no; //작성자
	private String user_name; //작성자 이름 
	private String qna_title; //제목
	private String qna_content; //본문
	private String qna_date; //일시
	private boolean qna_isprivate; //공개여부
	private boolean qna_notice; //공지
	
	@Override
	public String toString() {
		return "Qna [qna_no=" + qna_no + ", user_no=" + user_no + ", user_name=" + user_name + ", qna_title="
				+ qna_title + ", qna_content=" + qna_content + ", qna_date=" + qna_date + ", qna_isprivate="
				+ qna_isprivate + ", qna_notice=" + qna_notice + "]";
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public boolean isQna_isprivate() {
		return qna_isprivate;
	}
	public void setQna_isprivate(boolean qna_isprivate) {
		this.qna_isprivate = qna_isprivate;
	}
	public boolean isQna_notice() {
		return qna_notice;
	}
	public void setQna_notice(boolean qna_notice) {
		this.qna_notice = qna_notice;
	}
	

}
