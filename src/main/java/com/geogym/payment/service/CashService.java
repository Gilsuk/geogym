package com.geogym.payment.service;

import com.geogym.payment.exception.CashNotEnoughException;
import com.geogym.user.dto.User;

public interface CashService {
	
	/**
	 * 유저가 보유한 코인을 반환한다.
	 */
	int getCashAmount(User user);
	
	/**
	 * 근을 소비할때 호출
	 * 유저의 근이 부족할때 예외 처리 해야함
	 * 
	 * @param amount - 소비될 코인의 양
	 * @param user - 코인을 소비할 유저 객체
	 */
	void payByCash(int amount, User user) throws CashNotEnoughException;
	
	// 충전
	// 환불
	
	void refundCash(int amount, User user);
	
}
