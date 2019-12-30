package com.geogym.user.dao;

import com.geogym.user.dto.LoginCookie;
import com.geogym.user.dto.User;

public interface CookieDao {

	void insert(LoginCookie cookie);

	void update(LoginCookie cookie);

	void delete(LoginCookie cookie);

	/**
	 * 쿠키의 유효기간은 한 달이다.
	 * @param cookie
	 * @return
	 */
	User selectUserByCookie(LoginCookie cookie);

}
