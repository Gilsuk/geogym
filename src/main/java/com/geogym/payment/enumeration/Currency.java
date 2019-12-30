package com.geogym.payment.enumeration;

public enum Currency {
	
	ONLINE(1, "온라인"), OFFLINE(2, "현장"), CASH(3, "캐시"), TICKET(4, "티켓"); 
	
	private final int currency_no;
	private final String currency_name;
	
	Currency(int currency_no, String currency_name) {
		this.currency_no = currency_no;
		this.currency_name = currency_name;
	}
	
	@Override
	public String toString() {
		return this.currency_name;
	}
	
	public int getCurrency_no() {
		return currency_no;
	}

	public String getCurrency_name() {
		return currency_name;
	}

}
