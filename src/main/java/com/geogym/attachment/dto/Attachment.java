package com.geogym.attachment.dto;

public class Attachment {
	
	private int attachment_no;
	private String attachment_origin_name;
	private String attachment_stored_name;
	@Override
	public String toString() {
		return "Attachment [attachment_no=" + attachment_no + ", attachment_origin_name=" + attachment_origin_name
				+ ", attachment_stored_name=" + attachment_stored_name + "]";
	}
	public int getAttachment_no() {
		return attachment_no;
	}
	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}
	public String getAttachment_origin_name() {
		return attachment_origin_name;
	}
	public void setAttachment_origin_name(String attachment_origin_name) {
		this.attachment_origin_name = attachment_origin_name;
	}
	public String getAttachment_stored_name() {
		return attachment_stored_name;
	}
	public void setAttachment_stored_name(String attachment_stored_name) {
		this.attachment_stored_name = attachment_stored_name;
	}
	
	

}
