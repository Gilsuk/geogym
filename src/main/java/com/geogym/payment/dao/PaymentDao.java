package com.geogym.payment.dao;

import java.util.List;
import java.util.Map;

import com.geogym.payment.dto.Payment;
import com.geogym.user.dto.User;

public interface PaymentDao {

	int selectCnt(User user);

	List<Payment> selectPayLogByUserno(Map<String, String> map);

	void insert(Payment payment);

}
