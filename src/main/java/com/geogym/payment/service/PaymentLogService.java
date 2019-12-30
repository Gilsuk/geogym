package com.geogym.payment.service;


import java.util.List;

import com.geogym.payment.dto.Payment;
import com.geogym.qna.dto.Paging;
import com.geogym.user.dto.User;

public interface PaymentLogService {
	
	List<Payment> showPayLogs(User user, int curPage);
	
	void logPayment(Payment payment);

	Paging getPaging(User user, int curPage);

}
