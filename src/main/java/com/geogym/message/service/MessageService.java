package com.geogym.message.service;

import java.util.List;

import com.geogym.message.dto.Message;
import com.geogym.message.dto.Notification;
import com.geogym.user.dto.User;

public interface MessageService {
	
	/**
	 * 개인 알림
	 * 새로운 피드백 알림,
	 * 결제 정보,
	 * PT 매칭 취소 상태 등
	 * expire_date - 파기를 원하는 날짜 (기간) - 무한정
	 */
	void sendMessage(Message message);
	/**
	 * 개인 알림
	 * 새로운 피드백 알림,
	 * 결제 정보,
	 * PT 매칭 취소 상태 등
	 * expire_date - 파기를 원하는 날짜 (기간)
	 */
	void sendMessage(Message message, int expire_date);
	
	/**
	 * 전체 알림
	 * 휴관일, 긴급 공지, 등
	 * 
	 * 알림 확인 상태를 처리하는 알고리즘에 대한 고려가 필요함
	 * @param expire_date 
	 */
	void sendSystemMessage(Notification noti);
	
	/**
	 * 전체 알림
	 * 휴관일, 긴급 공지, 등
	 * 
	 * 알림 확인 상태를 처리하는 알고리즘에 대한 고려가 필요함
	 * @param expire_date 
	 */
	void sendSystemMessage(Notification noti, int expire_date);

	/**
	 * 해당 유저의 메세지 리스트 받아오기
	 * 
	 * @param user - user_no를 가지고 있는 User객체
	 * @param count - 보여지길 원하는 갯수
	 * @param offset 
	 * @return
	 */
	List<Message> getMessages(User user, int count, int offset);
	
	/** 
	 * 알림을 확인했을 때, 확인한 알림을 삭제하고 그 다음번 알림을 가져와서 채워넣는 용도.
	 * 예시)
	 * 읽지 않은 알림이 10개가 있고, 화면에 3개만 보여준다고 할때,
	 * 가장 최근 순으로 3개가 우선 표시되고 이 중 하나를 지우면
	 * 그 다음번인 4번째 알림을 이 메소드를 통해 가져와서 3개를 다시 채워넣는 용도
	 * 
	 * @param user
	 * @param order 가장 최근으로부터 order(0부터 시작)번째 메세지를 가져온다.
	 * @return
	 */
	Message getMessage(User user, int order);
	
	/**
	 * 메세지를 읽었다는 표시
	 * 다음에 알림 메세지를 조회할 때 해당 메세지가 더이상 표시되지 않도록 하는 기능
	 * @param message
	 */
	void readMessage(Message message);
	
	int getMessageCount(int user_no);
}