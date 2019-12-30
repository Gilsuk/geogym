package com.geogym.user.service;

import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dto.LoginInfo;
import com.geogym.user.dto.User;
import com.geogym.user.exception.UserNotFoundException;

/**
 * 회원 정보를 다루는 클래스
 *
 */
public interface UserService {

	User getUserByUserno(User user) throws UserNotFoundException;
	
	User getLoggedInUser() throws UserNotFoundException;
	
	/**
	 * 유저가 트레이너 인지 확인
	 * @param user
	 * @return
	 */
	boolean isTrainer(User user);
	
	/**
	 * 유저가 매니저 등급인지 확인
	 * @param user
	 * @return
	 */
	boolean isManager(User user);
	
	void setUserToManager(User user);
	
	void degradeUserFromManager(User user);
	
	void login(LoginInfo info) throws UserNotFoundException;
	
	void logout();
	
	void join(User info) throws ParamIncorrectException;

	void setUserToSession(User user);
	
}
