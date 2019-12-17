package com.geogym.payment.dto;

import java.time.LocalDate;

public class TicketChangesInfo {
	
	private LocalDate date; // 변동일
	private int ticket_no; // 이용권 고유 번호(PK)
	private int trainer_no;
	private int trainer_name;
	private int changes; // 변동수
	private int amount; // 변동 후 남은 갯수
	private String msg; // 변동 사유

}
