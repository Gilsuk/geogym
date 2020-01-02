package com.geogym.payment.dao;

import com.geogym.user.dto.User;

public interface CashDao {

	int selectCoinByUserNo(User user);

}
