package com.geogym.www.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.common.service.EmailService;

@Controller
public class EmailTestController {
	
	@Autowired EmailService serv;
	
	@RequestMapping(value = "/test/sendEmail")
	public void sendMail() {
		
		String to = "your@email.com";
		String title = "한글 메일 제목";
		String content = "<a href=\"https://naver.co\">네이버로 이동</a>";

		serv.sendHTML(to, title, content);

	}
}
