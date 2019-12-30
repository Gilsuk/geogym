package com.geogym.payment.dto;

import java.time.LocalDateTime;

public class Payment {
	private int pay_no;
	private int user_no;
	private LocalDateTime pay_date;
	private int pay_amount;
	private String curreny_name;
	private String product_name;
	@Override
	public String toString() {
		return "Payment [pay_no=" + pay_no + ", user_no=" + user_no + ", pay_date=" + pay_date + ", pay_amount="
				+ pay_amount + ", curreny_name=" + curreny_name + ", product_name=" + product_name + "]";
	}
	public int getPay_no() {
		return pay_no;
	}
	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public LocalDateTime getPay_date() {
		return pay_date;
	}
	public void setPay_date(LocalDateTime pay_date) {
		this.pay_date = pay_date;
	}
	public int getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(int pay_amount) {
		this.pay_amount = pay_amount;
	}
	public String getCurreny_name() {
		return curreny_name;
	}
	public void setCurreny_name(String curreny_name) {
		this.curreny_name = curreny_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
}
