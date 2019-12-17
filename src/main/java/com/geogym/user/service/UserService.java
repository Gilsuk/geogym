package com.geogym.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geogym.common.exception.DuplicatedException;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dto.LoginInfo;
import com.geogym.user.dto.SignupInfo;
import com.geogym.user.dto.User;
import com.geogym.user.exception.NotVerifiedUserException;
import com.geogym.user.exception.UserNotFoundException;

/**
 * 회원 정보를 다루는 클래스
 * @author gilsuk
 *
 */
public interface UserService {

	User getUserByUserno(User user) throws UserNotFoundException;
	
	User getLoggedInUser(HttpServletRequest req)
			throws UserNotFoundException;
	
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
	
	void login(LoginInfo info, HttpServletRequest req, HttpServletResponse resp)
			throws UserNotFoundException, NotVerifiedUserException, ParamIncorrectException;
	
	void logout(HttpServletRequest req, HttpServletResponse resp);
	
	void signUp(SignupInfo info) throws DuplicatedException, ParamIncorrectException;
	

	
}
