package com.geogym.qna.dto;

import com.geogym.trainer.dto.Trainer2;

public class QnaAnswer {

	private int qna_answer_no; // 답글 번호
	private Trainer2 trainer; // 트레이너 번호
	private Qna qna; // qna 번호
	private String qna_answer_content; // 본문내용
	private String qna_answer_date; // 등록일시

	@Override
	public String toString() {
		return "QnaAnswer [qna_answer_no=" + qna_answer_no + ", trainer=" + trainer + ", qna=" + qna
				+ ", qna_answer_content=" + qna_answer_content + ", qna_answer_date=" + qna_answer_date + "]";
	}

	public int getQna_answer_no() {
		return qna_answer_no;
	}

	public void setQna_answer_no(int qna_answer_no) {
		this.qna_answer_no = qna_answer_no;
	}

	public Trainer2 getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer2 trainer) {
		this.trainer = trainer;
	}

	public Qna getQna() {
		return qna;
	}

	public void setQna(Qna qna) {
		this.qna = qna;
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
