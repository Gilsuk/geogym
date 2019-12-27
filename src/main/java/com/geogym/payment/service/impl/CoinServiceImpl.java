package com.geogym.payment.service.impl;

import java.util.List;

import com.geogym.common.dto.Paging;
import com.geogym.payment.dto.CoinChangesInfo;
import com.geogym.payment.exception.CoinNotEnoughException;
import com.geogym.payment.service.CoinService;
import com.geogym.user.dto.User;

public class CoinServiceImpl implements CoinService {

	@Override
	public int getCoinAmount(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CoinChangesInfo> getListCoinChangesInfo(User user, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void payByCoin(int amount, User user) throws CoinNotEnoughException {
		// TODO Auto-generated method stub

	}

	@Override
	public void refundCoin(int amount, User user) {
		// TODO Auto-generated method stub

	}

}
