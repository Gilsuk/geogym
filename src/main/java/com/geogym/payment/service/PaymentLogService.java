package com.geogym.payment.service;


import java.util.List;

import com.geogym.common.dto.Paging;
import com.geogym.payment.dto.Payment;
import com.geogym.user.dto.User;

public interface PaymentLogService {
	
	List<Payment> showPayLog(User user, Paging paging);
	
	void logPayment(Payment payment);
	

}
