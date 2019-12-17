package com.geogym.payment.dto;

import java.time.LocalDateTime;

public class CoinChangesInfo {
	
	private LocalDateTime date; // 변동이 발생한 일시
	private int changes; // 코인 변동량 (음수 값을 가질 수 있다)
	private int amount; // 변동 후 보유 코인
	private String msg; // 변동 사유
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getChanges() {
		return changes;
	}
	public void setChanges(int changes) {
		this.changes = changes;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "CoinChangesInfo [date=" + date + ", changes=" + changes + ", amount=" + amount + ", msg=" + msg + "]";
	}
}
