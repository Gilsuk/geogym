package com.geogym.payment.dao;

import com.geogym.user.dto.User;

public interface CoinDao {

	int selectCoinByUserNo(User user);

}
