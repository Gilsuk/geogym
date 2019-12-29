package com.geogym.payment.enumeration;

public enum Product {
	
	CASH(1, "캐시"), TICKET(2, "회원권"), PTTICKET(3, "PT 이용권"), DAILY(4, "일일 PT");
	
	private int product_no;
	private String product_name;
	
	private Product(int no, String name) {
		this.product_no = no;
		this.product_name = name;
	}
	
	@Override
	public String toString() {
		return this.product_name;
	}
	
	public int getNo() {
		return this.product_no;
	}
	
	public String getName() {
		return this.product_name;
	}
	
}
