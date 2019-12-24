package com.geogym.www.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geogym.message.dto.Message;
import com.geogym.message.dto.Notification;
import com.geogym.message.service.MessageService;
import com.geogym.user.dto.User;

@Controller
public class MessageController {

	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	
	@Autowired MessageService messageService;
	
	//--- 메세지 전송 ---------------------------
	@RequestMapping(value="/test/message/sendinfinity")
	public void sendMessageInfinite(Message message) { 
		
		// 테스트 데이터입니다
		message.setUser_no(1);
		message.setMessage_content("무기한메세지");
		
		//Message 파기 기간 입력 없이 사용
		messageService.sendMessage(message);
	}
	
	@RequestMapping(value="/test/message/send")
	public void sendMessage(Message message) { 
		
		// 테스트 데이터입니다
		message.setUser_no(12);
		message.setMessage_content("오늘 휴무입니다");
		
		//Message 파기 기간 입력 후 사용
		messageService.sendMessage(message, 30);
	}
	
	@RequestMapping(value="/test/message/fail")
	public void sendMessageFail(Message message) { 
		
		// 실패 테스트 데이터입니다 
		// Message_content (내용이 없을때)
		message.setUser_no(1);
		
		messageService.sendMessage(message, 30);
	}
	
	@RequestMapping(value="/test/message/fail1")
	public void sendMessageFail1(Message message) { 
		
		// 실패 테스트 데이터입니다
		// User_no (fk위반) - 
		message.setUser_no(100);
		message.setMessage_content("오늘 휴무입니다");
		
		messageService.sendMessage(message, 30);
	}
	//--------------------------------------------------------------------
	
	
	
	
	
	//--- 공지사항 전송 ----------------------------------------------------
	@RequestMapping(value="/test/systemmessage/sendinfinity")
	public void sendSystemMessageInfinite() { 
		Notification noti = new Notification();
		
		noti.setNotification_content("무기한 전체공지입니다");
		
		//Notification 파기 기간 입력 없이 사용
		messageService.sendSystemMessage(noti);
	}
	
	@RequestMapping(value="/test/systemmessage/send")
	public void sendSystemMessage() { 
		Notification noti = new Notification();
		
		noti.setNotification_content("전체공지입니다");
		
		//Notification 파기 기간 입력 후 사용
		messageService.sendSystemMessage(noti, 30);
	}
	
	@RequestMapping(value="/test/systemmessage/fail")
	public void sendSystemMessageFail() { 
		
		// 실패 테스트 데이터입니다 
		// 공지사항 메시지가 없을 경우
		
		Notification noti = new Notification();
		
		messageService.sendSystemMessage(noti, 30);
	}
	//-------------------------------------------------------
	
	
	
	// --- 메세지 목록 불러오기 --------------------------------------
	@RequestMapping(value="/test/message/list")
	public void viewMessage(User user) { 
		
		user.setUser_no(1);
		
		List<Message> list = messageService.getMessages(user, 2);
		
		logger.info(list.toString());
	}
	
	@RequestMapping(value="/test/message/list/fail")
	public void viewMessageFail(User user) { 
		
		// 실패 테스트 데이터입니다 
		// 불러올 메세지 갯수에 0이하의 수를 입력시
		
		user.setUser_no(12);
		
		// 불러올 메세지 갯수에 0이하의 수를 입력시 기본 3개 출력
		List<Message> list = messageService.getMessages(user, -999);
		
		logger.info(list.toString());
	}
	
	//-------------------------------------------------------------
	
	
	
	// --- 메세지 불러오기(해당유저의 최신 몇번째 메세지) -----------------------
	@RequestMapping(value="/test/message/one")
	public void viewOneMessage(User user) { 
		
		user.setUser_no(12);
		
		Message message = messageService.getMessage(user, 2);
		
		logger.info(message.toString());
	}
	@RequestMapping(value="/test/message/one/fail")
	public void viewOneMessageFail(User user) { 
		
		// 실패 테스트 데이터입니다 
		// getMessage 두번째 파라미터에  0미만의 수를 입력시
		// 가장 최근 메세지 불러옴
		
		user.setUser_no(12);
		
		Message message = messageService.getMessage(user, -999);
		
		logger.info(message.toString());
	}
	//------------------------------------------------------------
	
	
	
	// --- 메세지를 읽었을 경우 읽음 처리 ----------------------------------
	@RequestMapping(value="/test/message/read")
	public void readMessage(Message message) { 
		
		message.setMessage_no(4);
		
		messageService.readMessage(message);
		
	}
	@RequestMapping(value="/test/message/read/fail")
	public void readMessageFail(Message message) { 
		
		// 실패 테스트 데이터입니다 
		// 실제 DB에 없는 message_no를 입력하였을 경우(음수 포함)
		// return
		
		message.setMessage_no(999);
		
		messageService.readMessage(message);
	}
	
	// ----------------------------------------------------------
	
}