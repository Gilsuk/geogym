package com.geogym.attachment.dto;

public class Qna_attachment {
	private int qna_no;
	private int attachment_no;

	@Override
	public String toString() {
		return "Qna_attachment [qna_no=" + qna_no + ", attachment_no=" + attachment_no + "]";
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public int getAttachment_no() {
		return attachment_no;
	}

	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}

}
