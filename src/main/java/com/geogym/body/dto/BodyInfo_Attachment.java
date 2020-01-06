package com.geogym.body.dto;

public class BodyInfo_Attachment {

	private int attachment_no;
	private int bodyinfo_no;
	
	
	
	
	@Override
	public String toString() {
		return "BodyInfo_Attachment [attachment_no=" + attachment_no + ", bodyinfo_no=" + bodyinfo_no + "]";
	}
	public int getAttachment_no() {
		return attachment_no;
	}
	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}
	public int getBodyinfo_no() {
		return bodyinfo_no;
	}
	public void setBodyinfo_no(int bodyinfo_no) {
		this.bodyinfo_no = bodyinfo_no;
	}
}
