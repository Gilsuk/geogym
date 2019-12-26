package com.geogym.user.service;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.common.exception.DuplicatedException;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dao.UserInfoDao;
import com.geogym.user.dto.LoginInfo;
import com.geogym.user.dto.User;
import com.geogym.user.exception.NotVerifiedUserException;
import com.geogym.user.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired private HttpSession session;
	@Autowired private HttpServletRequest req;
	@Autowired private HttpServletResponse resp;
	@Autowired private UserInfoDao dao;

	@Override
	public User getUserByUserno(User user) throws UserNotFoundException {
		return dao.selectUserByUserno(user.getUser_no());
	}

	@Override
	public User getLoggedInUser() throws UserNotFoundException {
		throw new UserNotFoundException();
	}

	@Override
	public boolean isTrainer(User user) {
		return false;
	}

	@Override
	public boolean isManager(User user) {
		return false;
	}

	@Override
	public void login(LoginInfo info) throws UserNotFoundException, NotVerifiedUserException, ParamIncorrectException {
	}

	@Override
	public void logout() {
	}

	@Override
	public void signUp(User info) throws DuplicatedException, ParamIncorrectException {
		

	}

}
