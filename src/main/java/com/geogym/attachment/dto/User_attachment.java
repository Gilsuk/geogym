package com.geogym.attachment.dto;

public class User_attachment {

	private int user_no;
	private int attachment_no;
	
	
	
	
	
	@Override
	public String toString() {
		return "User_attachment [user_no=" + user_no + ", attachment_no=" + attachment_no + "]";
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getAttachment_no() {
		return attachment_no;
	}
	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}
}
