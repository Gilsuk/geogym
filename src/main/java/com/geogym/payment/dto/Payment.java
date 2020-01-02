package com.geogym.payment.dto;

import java.time.LocalDateTime;

import com.geogym.payment.enumeration.Currency;
import com.geogym.payment.enumeration.Product;
import com.geogym.user.dto.User;

public class Payment {
	private int pay_no;
	private User user;
	private LocalDateTime pay_date;
	private int pay_amount;
	private Currency currency;
	private Product product;
	public int getPay_no() {
		return pay_no;
	}
	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Payment [pay_no=" + pay_no + ", user=" + user + ", pay_date=" + pay_date + ", pay_amount=" + pay_amount
				+ ", currency=" + currency + ", product=" + product + "]";
	}
}
