package com.geogym.message.service;

import java.util.List;

import com.geogym.message.dto.Message;
import com.geogym.user.dto.User;

public interface MessageService {
	
	/**
	 * 개인 알림
	 * 새로운 피드백 알림,
	 * 결제 정보,
	 * PT 매칭 취소 상태 등
	 */
	void sendMessage(Message message);
	
	/**
	 * 전체 알림
	 * 휴관일, 긴급 공지, 등
	 * 
	 * 알림 확인 상태를 처리하는 알고리즘에 대한 고려가 필요함
	 */
	void sendSystemMessage(Message message);

	/**
	 * 보여질 총 개수 제한을 할 필요가 있어보인다.
	 */
	List<Message> getMessages(User user);
	
	/**
	 * 알림을 확인했을 때, 확인한 알림을 삭제하고 그 다음번 알림을 가져와서 채워넣는 용도.
	 * 예시)
	 * 읽지 않은 알림이 10개가 있고, 화면에 3개만 보여준다고 할때,
	 * 가장 최근 순으로 3개가 우선 표시되고 이 중 하나를 지우면
	 * 그 다음번인 4번째 알림을 이 메소드를 통해 가져와서 3개를 다시 채워넣는 용도
	 * 
	 * @param user
	 * @param order 가장 최근으로부터 order 번째 메세지를 가져온다.
	 * @return
	 */
	Message getMessage(User user, int order);
	
	/**
	 * 메세지를 읽었다는 표시
	 * 다음에 알림 메세지를 조회할 때 해당 메세지가 더이상 표시되지 않도록 하는 기능
	 * @param message
	 */
	void readMessage(User user, Message message);
}
