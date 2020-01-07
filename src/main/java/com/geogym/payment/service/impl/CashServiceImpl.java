package com.geogym.payment.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.common.enumeration.Property;
import com.geogym.payment.dao.CashDao;
import com.geogym.payment.dto.Payment;
import com.geogym.payment.enumeration.Currency;
import com.geogym.payment.enumeration.Product;
import com.geogym.payment.exception.CashNotEnoughException;
import com.geogym.payment.exception.FailPayException;
import com.geogym.payment.service.CashService;
import com.geogym.payment.service.PaymentLogService;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;
import com.geogym.user.service.UserService;

@Service
public class CashServiceImpl implements CashService {

	@Autowired CashDao coinDao;
	@Autowired
	private PaymentLogService payLogSrv;
	@Autowired
	private HttpServletRequest req;
	@Autowired
	private UserService userSrv;
	
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

	@Override
	public void chargeCash() throws FailPayException {
		String uri = req.getRequestURI();
		String imp_uid = uri.split("/")[3];
		String completeResponse = getCompleteResponse(imp_uid);
		
		int amountPay = getAmountPay(completeResponse);
		
		if (amountPay > 0) {
			logPayment(amountPay);
			
		} else {
			throw new FailPayException();
		}
		
	}

	private void logPayment(int amountPay) {
		User user = null;
		try {
			user = userSrv.getLoggedInUser();
		} catch (UserNotFoundException e) { return; }

		Payment payment = new Payment();
		payment.setCurrency(Currency.ONLINE);
		payment.setPay_amount(amountPay);
		payment.setPay_date(LocalDateTime.now());
		payment.setProduct(Product.CASH);
		payment.setUser(user);
		payLogSrv.logPayment(payment);
	}

	private int getAmountPay(String json) {
		JSONObject obj = new JSONObject(json);
		JSONObject response = obj.getJSONObject("response");
		String status = response.getString("status");
		
		if (status.equals("paid")) {
			return response.getInt("amount");
		}
		return 0;
	}

	private String getAccessKey() {
		JSONObject obj = new JSONObject(getAccessResponseJson());
		return obj.getJSONObject("response").getString("access_token");
	}

	private String getAccessResponseJson() {
		String url = "https://api.iamport.kr/users/getToken"; 
		String parameters = "imp_key=" + Property.IAMPORT_API_KEY.toString()
				+ "&imp_secret=" + Property.IAMPORT_API_SECRET.toString();
		
		return sendPost(url, parameters, null);
	}
	
	private String getCompleteResponse(String uid) {
		String url = "https://api.iamport.kr/payments/" + uid; 

		return sendPost(url, null, uid);
	}

	private String sendPost(String url, String parameters, String uid) {
		URL link = null;
		try {
			link = new URL(url);
		} catch (MalformedURLException e) { }

		try {
			HttpsURLConnection con = (HttpsURLConnection) link.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if (uid != null) {
				System.out.println("accesskey");
				con.setRequestProperty("Authorization", getAccessKey());
			}
			con.setDoOutput(true);

			// Send post request 
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			if (parameters != null)
				wr.writeBytes(parameters);
			wr.flush();
			wr.close();

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpsURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
			} else {
				System.out.println(con.getResponseMessage());
			}
			
			return sb.toString();

		} catch (IOException e) { return ""; }
	}
	
}
