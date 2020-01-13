package com.geogym.user.enumeration;

public enum Social {
	
	GOOGLE(3), NAVER(1), KAKAO(2);

	private final int value;
	
	private Social(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
