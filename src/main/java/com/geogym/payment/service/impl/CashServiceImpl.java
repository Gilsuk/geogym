package com.geogym.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.payment.dao.CashDao;
import com.geogym.payment.exception.CashNotEnoughException;
import com.geogym.payment.service.CashService;
import com.geogym.user.dto.User;

@Service
public class CashServiceImpl implements CashService {

	@Autowired CashDao coinDao;
	
	@Override
	public int getCashAmount(User user) {
		
		return coinDao.selectCoinByUserNo(user);
	}

	@Override
	public void payByCash(int amount, User user) throws CashNotEnoughException {
		// TODO Auto-generated method stub

	}

	@Override
	public void refundCash(int amount, User user) {
		// TODO Auto-generated method stub

	}

}
