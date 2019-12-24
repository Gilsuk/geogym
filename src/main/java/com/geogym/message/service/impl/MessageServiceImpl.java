package com.geogym.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.message.dao.MessageDao;
import com.geogym.message.dto.Message;
import com.geogym.message.service.MessageService;
import com.geogym.user.dto.User;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired MessageDao messageDao;
	
	@Override
	public void sendMessage(Message message) {
		
	}

	@Override
	public void sendSystemMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> getMessages(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getMessage(User user, int order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readMessage(User user, Message message) {
		// TODO Auto-generated method stub

	}

}
