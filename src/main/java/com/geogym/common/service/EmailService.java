package com.geogym.common.service;

public interface EmailService {

	void sendText(String to, String title, String plainContent);

	void sendHTML(String to, String title, String htmlContent);

}
