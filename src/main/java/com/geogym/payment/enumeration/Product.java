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

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
}
