package com.geogym.attachment.dto;

public class Bodyinfo_attachment {
	private int bodyinfo_no;
	private int attachment_no;

	@Override
	public String toString() {
		return "Bodyinfo_attachment [bodyinfo_no=" + bodyinfo_no + ", attachment_no=" + attachment_no + "]";
	}

	public int getBodyinfo_no() {
		return bodyinfo_no;
	}

	public void setBodyinfo_no(int bodyinfo_no) {
		this.bodyinfo_no = bodyinfo_no;
	}

	public int getAttachment_no() {
		return attachment_no;
	}

	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}

}
