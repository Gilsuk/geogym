package com.geogym.attachment.dto;

public class Qna_answer_attachment {
	private int qna_answer_no;
	private int attachment_no;

	@Override
	public String toString() {
		return "Qna_answer_attachment [qna_answer_no=" + qna_answer_no + ", attachment_no=" + attachment_no + "]";
	}

	public int getQna_answer_no() {
		return qna_answer_no;
	}

	public void setQna_answer_no(int qna_answer_no) {
		this.qna_answer_no = qna_answer_no;
	}

	public int getAttachment_no() {
		return attachment_no;
	}

	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}

}
