package com.geogym.qna.dto;

public class QnaCategory {
	private int qna_category_no;
	private String qna_category_name;
	@Override
	public String toString() {
		return "qnaCategory [qna_category_no=" + qna_category_no + ", qna_category_name=" + qna_category_name + "]";
	}
	public int getQna_category_no() {
		return qna_category_no;
	}
	public void setQna_category_no(int qna_category_no) {
		this.qna_category_no = qna_category_no;
	}
	public String getQna_category_name() {
		return qna_category_name;
	}
	public void setQna_category_name(String qna_category_name) {
		this.qna_category_name = qna_category_name;
	}
	
	

}
