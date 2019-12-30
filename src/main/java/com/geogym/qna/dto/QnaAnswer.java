package com.geogym.qna.dto;

import java.time.LocalDate;

public class QnaAnswer {

	private int qna_answer_no; // 답글 번호
	private int trainer_no; // 트레이너 번호
	private String trainer_name; // 트레이너 이름
	private int qna_no; // qna 번호
	private String qna_answer_content; // 본문내용
	private String qna_answer_date; // 등록일시

	@Override
	public String toString() {
		return "QnaAnswer [qna_answer_no=" + qna_answer_no + ", trainer_no=" + trainer_no + ", trainer_name="
				+ trainer_name + ", qna_no=" + qna_no + ", qna_answer_content=" + qna_answer_content
				+ ", qna_answer_date=" + qna_answer_date + "]";
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

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public String getQna_answer_content() {
		return qna_answer_content;
	}

	public void setQna_answer_content(String qna_answer_content) {
		this.qna_answer_content = qna_answer_content;
	}

	public String getQna_answer_date() {
		return qna_answer_date;
	}

	public void setQna_answer_date(String qna_answer_date) {
		this.qna_answer_date = qna_answer_date;
	}

}
