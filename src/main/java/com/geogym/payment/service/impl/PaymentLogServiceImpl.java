package com.geogym.payment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.payment.dao.PaymentDao;
import com.geogym.payment.dto.Payment;
import com.geogym.payment.service.PaymentLogService;
import com.geogym.qna.dto.Paging;
import com.geogym.user.dto.User;

@Service
public class PaymentLogServiceImpl implements PaymentLogService {

	@Autowired private PaymentDao dao;
	
	@Override
	public List<Payment> showPayLogs(User user, int curPage) {
		Paging paging = getPaging(user, curPage);
		Map<String, String> map = new HashMap<>();
		map.put("user_no", String.valueOf(user.getUser_no()));
		map.put("startno", String.valueOf(paging.getStartNo()));
		return dao.selectPayLogByUserno(map);
	}

	@Override
	public void logPayment(Payment payment) {
		dao.insert(payment);
	}

	@Override
	public Paging getPaging(User user, int curPage) {
		int cnt = dao.selectCnt(user);
		return new Paging(cnt, curPage);
	}
}
