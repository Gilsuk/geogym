package com.geogym.common.enumeration;

public enum Table {
	
	ATTACHMENT("attachment"),
	BODY_COMMENT("body_comment"),
	BODYINFO("bodyinfo"),
	QNA("qna"),
	QNA_ANSWER("qna_answer"),
	SCHEDULE("schedule");
	
	private final String value;
	
	Table(String tbname) {
		this.value = tbname;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
}
