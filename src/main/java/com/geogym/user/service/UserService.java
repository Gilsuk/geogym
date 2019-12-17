package com.geogym.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.geogym.user.dto.User;
import com.geogym.user.exception.AlreadyLoggedInException;
import com.geogym.user.exception.DuplicatedException;
import com.geogym.user.exception.IncorrectParamException;
import com.geogym.user.exception.NotVerifiedUserException;
import com.geogym.user.exception.UserNotFoundException;

public interface UserService {
	
	/**
	 * 
	 * @param user 로그인 정보를 담고 있는 객체(ID, PW)
	 * @param session 
	 * @param shouldRemember 로그인 상태 기억여부, true라면 상태를 저장한다.
	 * @throws NotVerifiedUserException 가입은 했지만 인증 받지 않은 유저
	 * @throws UserNotFoundException 일치하는 정보가 없을 때(로그인 실패)
	 * @throws AlreadyLoggedInException 이미 로그인 한 유저인 경우
	 */
	void login(User user, HttpSession session, boolean shouldRemember) throws NotVerifiedUserException, UserNotFoundException, AlreadyLoggedInException;
	
	void join(User user) throws DuplicatedException, IncorrectParamException;
	
	User getLoggedInUser(HttpServletRequest req);
	
}
