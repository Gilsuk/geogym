package com.geogym.qna.dto;

public class QnaAttachment {
	
	private int qna_attachment_no;
	private int qna_no;
	private int attachment_no;
	@Override
	public String toString() {
		return "qnaAttachment [qna_attachment_no=" + qna_attachment_no + ", qna_no=" + qna_no + ", attachment_no="
				+ attachment_no + "]";
	}
	public int getQna_attachment_no() {
		return qna_attachment_no;
	}
	public void setQna_attachment_no(int qna_attachment_no) {
		this.qna_attachment_no = qna_attachment_no;
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
