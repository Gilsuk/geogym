package com.geogym.payment.service;

import com.geogym.payment.exception.CoinNotEnoughException;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;

public interface PaymentService {
	
	/**
	 * 근을 소비할때 호출
	 * 유저의 근이 부족할때 예외 처리 해야함
	 * 
	 * @param amount - 소비될 코인의 양
	 * @param user - 코인을 소비할 유저 객체
	 */
	void payByCoin(int amount, User user) throws CoinNotEnoughException;

	/**
	 * 정기권을 이용한 PT 신청시 횟수 차감
	 * 
	 * @param user
	 * @param trainer
	 */
	void payBySeasonTicket(User user, Trainer trainer);
}
