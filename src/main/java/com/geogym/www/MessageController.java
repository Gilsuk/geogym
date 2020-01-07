package com.geogym.www;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogym.message.dto.Message;
import com.geogym.message.service.MessageService;

@Controller
public class MessageController {

	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired MessageService messageService;
	
	@RequestMapping(value="/message/count", method = RequestMethod.GET)
	public void getCountMessage(int user_no, HttpServletResponse resp) {

		try {
			resp.getWriter().println(messageService.getMessageCount(user_no));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/message/isread", method = RequestMethod.GET)
	public void readMessage(Message message, HttpServletResponse resp) {
		
		messageService.readMessage(message);
	}
	
}
