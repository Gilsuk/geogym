package com.geogym.common.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.geogym.common.enumeration.Property;
import com.geogym.common.service.EmailService;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class EmailServiceImpl implements EmailService {

	private static final Email from = new Email("no_reply@geogym.com", "지오짐");

	@Override
	public void sendText(String to, String title, String plainContent) {
		send(to, title, plainContent, "text/plain");
	}

	@Override
	public void sendHTML(String to, String title, String htmlContent) {
		send(to, title, htmlContent, "text/html");
	}

	private void send(String to, String title, String plainContent, String contentType) {
		Email toAddr = new Email(to);
	    Content content = new Content(contentType, plainContent);
	    Mail mail = new Mail(from, title, toAddr, content);

	    try {
	    	@SuppressWarnings(value = { "unused" }) Response response = send(mail);
	    	
//	    	테스트용 출력코드
//	    	printResponse(response);
		} catch (IOException e) { e.printStackTrace(); }
	}

	private Response send(Mail mail) throws IOException {
		SendGrid sg = new SendGrid(Property.SENDGRID_API_KEY.toString());
		Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());
		return sg.api(request);
	}

	@SuppressWarnings(value = { "unused" })
	private void printResponse(Response response) {
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
	}

}
