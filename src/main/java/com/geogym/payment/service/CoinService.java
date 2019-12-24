package com.geogym.payment.service;

import java.util.List;

import com.geogym.common.dto.Paging;
import com.geogym.payment.dto.CoinChangesInfo;
import com.geogym.payment.exception.CoinNotEnoughException;
import com.geogym.user.dto.User;

public interface CoinService {
	
	/**
	 * 유저가 보유한 코인을 반환한다.
	 */
	int getCoinAmount(User user);
	
	/**
	 * 코인 사용 내역을 반환한다.
	 */
	List<CoinChangesInfo> getListCoinChangesInfo(User user, Paging paging);
	
	/**
	 * 근을 소비할때 호출
	 * 유저의 근이 부족할때 예외 처리 해야함
	 * 
	 * @param amount - 소비될 코인의 양
	 * @param user - 코인을 소비할 유저 객체
	 */
	void payByCoin(int amount, User user) throws CoinNotEnoughException;
	
	// 충전
	// 환불
	
	void refundCoin(int amount, User user);
	
}
