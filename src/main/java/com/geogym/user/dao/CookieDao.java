package com.geogym.user.dao;

import com.geogym.user.dto.LoginCookie;
import com.geogym.user.dto.User;

public interface CookieDao {

	void update(LoginCookie cookie);

	void delete(LoginCookie cookie);

	User selectUserByCookie(LoginCookie cookie);

}
