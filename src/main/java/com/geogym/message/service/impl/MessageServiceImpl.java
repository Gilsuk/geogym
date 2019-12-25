package com.geogym.message.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.message.dao.MessageDao;
import com.geogym.message.dto.Message;
import com.geogym.message.dto.Notification;
import com.geogym.message.service.MessageService;
import com.geogym.user.dto.User;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired MessageDao messageDao;
	
	@Override
	public void sendMessage(Message message) {

		if(message.getMessage_content() == null || message.getMessage_content().equals(""))
			return;
		
		message.setMessage_date(LocalDateTime.now());
		message.setMessage_expire_date(LocalDateTime.MAX);

		try {
			messageDao.insertMessage(message);
		} catch (Exception e) {}
	}

	
	@Override
	public void sendMessage(Message message, int expire_date) {
		
		if(message.getMessage_content() == null || message.getMessage_content().equals(""))
			return;
		
		message.setMessage_date(LocalDateTime.now());
		message.setMessage_expire_date(LocalDateTime.now().plusDays(expire_date));

		try {
			messageDao.insertMessage(message);
		} catch (Exception e) {}
	}

	@Override
	public void sendSystemMessage(Notification noti) {
		
		if(noti.getNotification_content() == null || noti.getNotification_content().equals(""))
			return;
		
		noti.setNotification_expire_date(LocalDateTime.MAX);
		
		messageDao.insertNotification(noti);
	}
	
	@Override
	public void sendSystemMessage(Notification noti, int expire_date) {
		
		if(noti.getNotification_content() == null || noti.getNotification_content().equals(""))
			return;
		
		noti.setNotification_expire_date(LocalDateTime.now().plusDays(expire_date));
		
		messageDao.insertNotification(noti);
	}

	@Override
	public List<Message> getMessages(User user, int count) {
		
		if(count <= 0) {
			count = 3;
		}
		
		Map<String, Integer> map = new HashMap<>();
		map.put("user_no", user.getUser_no());
		map.put("count", count);
		
		return messageDao.selectMessage(map);
	}

	@Override
	public Message getMessage(User user, int order) {
		
		if(order < 0) {
			order = 0;
		}
		
		Map<String, Integer> map = new HashMap<>();
		map.put("user_no", user.getUser_no());
		map.put("order", order);
		
		return messageDao.selectOneMessage(map);
	}

	@Override
	public void readMessage(Message message) {
		
		if(message.getMessage_no() <= 0)
			return;
		
		messageDao.updateToTrue(message);
	}

}