package com.geogym.attachment.dto;

public class Attachment {

	private int attachment_no;
	private String attachment_origin_name;
	private String attachment_stored_name;
	private long attachment_size;
	private int mime_no;

	@Override
	public String toString() {
		return "Attachment [attachment_no=" + attachment_no + ", attachment_origin_name=" + attachment_origin_name
				+ ", attachment_stored_name=" + attachment_stored_name + ", attachment_size=" + attachment_size
				+ ", mime_no=" + mime_no + "]";
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

	public long getAttachment_size() {
		return attachment_size;
	}

	public void setAttachment_size(long attachment_size) {
		this.attachment_size = attachment_size;
	}

	public int getMime_no() {
		return mime_no;
	}

	public void setMime_no(int mime_no) {
		this.mime_no = mime_no;
	}

}
