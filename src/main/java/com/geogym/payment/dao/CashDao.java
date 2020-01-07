package com.geogym.payment.dao;

import java.util.Map;

import com.geogym.user.dto.User;

public interface CashDao {

	int selectCoinByUserNo(User user);
	
	void insertCoin(Map<String, Integer> map);
	
	void deleteCoin(User user);

}
