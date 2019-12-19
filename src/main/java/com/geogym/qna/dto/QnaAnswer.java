package com.geogym.qna.dto;

import java.time.LocalDate;

public class QnaAnswer {
	
	private int qna_answer_no;
	private int trainer_no;
	private int qna_no;
	private String qna_title;
	private String qna_contentl;
	private LocalDate qna_date;
	private int attachment_no;
	@Override
	public String toString() {
		return "qnaAnswer [qna_answer_no=" + qna_answer_no + ", trainer_no=" + trainer_no + ", qna_no=" + qna_no
				+ ", qna_title=" + qna_title + ", qna_contentl=" + qna_contentl + ", qna_date=" + qna_date
				+ ", attachment_no=" + attachment_no + "]";
	}
	public int getQna_answer_no() {
		return qna_answer_no;
	}
	public void setQna_answer_no(int qna_answer_no) {
		this.qna_answer_no = qna_answer_no;
	}
	public int getTrainer_no() {
		return trainer_no;
	}
	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_contentl() {
		return qna_contentl;
	}
	public void setQna_contentl(String qna_contentl) {
		this.qna_contentl = qna_contentl;
	}
	public LocalDate getQna_date() {
		return qna_date;
	}
	public void setQna_date(LocalDate qna_date) {
		this.qna_date = qna_date;
	}
	public int getAttachment_no() {
		return attachment_no;
	}
	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	} 
	
	

}
