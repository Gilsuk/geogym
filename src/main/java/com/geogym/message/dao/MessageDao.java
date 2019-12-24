package com.geogym.message.dao;

import java.util.List;
import java.util.Map;

import com.geogym.message.dto.Message;
import com.geogym.message.dto.Notification;

public interface MessageDao {
	
	void insertMessage(Message message);

	void insertNotification(Notification noti);

	List<Message> selectMessage(Map<String, Integer> map);

	Message selectOneMessage(Map<String, Integer> map);

	void updateToTrue(Message message);

}
