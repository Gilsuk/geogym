package com.geogym.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.user.dao.UserInfoDao;
import com.geogym.user.dto.LoginInfo;
import com.geogym.user.dto.User;
import com.geogym.user.enumeration.Social;
import com.geogym.user.exception.CookieNotFoundException;
import com.geogym.user.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired private HttpSession session;
	@Autowired private HttpServletRequest req;
	@Autowired private UserInfoDao dao;
	@Autowired private CookieService cookieService;

	@Override
	public User getUserByUserno(User user) throws UserNotFoundException {
		User selectedUser = dao.selectUserByUserno(user.getUser_no());
		
		if (selectedUser == null)
			throw new UserNotFoundException();
		
		return selectedUser;
	}

	@Override
	public User getLoggedInUser() throws UserNotFoundException {
		
		try {
			Object user = req.getSession().getAttribute("loggedInUser");
			if (user == null) throw new NullPointerException();
			return (User) user;
		} catch (NullPointerException e) {

			try {
				loginFromCookie();
				return getLoggedInUser();
			} catch (CookieNotFoundException e1) {
				throw new UserNotFoundException();
			}
			
		} catch (ClassCastException e) {
			// session attribute에 loggedInUser라는 이름으로 다른 객체가 들어있는 경우
			// 발생하면 안되는 심각한 에러
			e.printStackTrace();
			return null;
		}
	}

	private void loginFromCookie() throws CookieNotFoundException {
		cookieService.restoreSessionAccount();
	}

	@Override
	public boolean isTrainer(User user) {
		int cnt = dao.selectCntTrainerByUserno(user.getUser_no());
		if (cnt > 0)
			return true;
		return false;
	}

	@Override
	public boolean isManager(User user) {
		int cnt = dao.selectCntManagerByUserno(user.getUser_no());
		if (cnt > 0)
			return true;
		return false;
	}

	@Override
	public void login(LoginInfo info) throws UserNotFoundException {
		User user = dao.selectUserByIdAndPw(info);
		if (user == null) throw new UserNotFoundException();
		
		if (info.isShouldRemember())
			cookieService.setNewCookie(user);
		
		setUserToSession(user);
	}

	@Override
	public void setUserToSession(User user) {
		session.setAttribute("loggedInUser", user);
	}

	@Override
	public void logout() {
		cookieService.removeLoginCookie();
		session.removeAttribute("loggedInUser");
	}

	@Override
	public void join(User user) throws ParamIncorrectException {
		
		try {
			dao.insertUser(user);
		} catch (Exception e) { throw new ParamIncorrectException(); }

	}

	@Override
	public void setUserToManager(User user) {
		if (!isManager(user))
			dao.insertIntoManager(user.getUser_no());
	}

	@Override
	public void degradeUserFromManager(User user) {
		dao.deleteFromManager(user.getUser_no());
	}

	@Override
	public User getUserByUserid(User user) throws UserNotFoundException {
		User selectedUser = dao.selectUserByUserid(user.getUser_id());
		
		if (selectedUser == null)
			throw new UserNotFoundException();
		
		return selectedUser;
	}

	@Override
	public void login(String id_token, Social google) throws UserNotFoundException {
		
	}

}
