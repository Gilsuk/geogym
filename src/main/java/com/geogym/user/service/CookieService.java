package com.geogym.user.service;

import com.geogym.user.dto.User;
import com.geogym.user.exception.CookieNotFoundException;

public interface CookieService {

	void restoreSessionAccount() throws CookieNotFoundException;

	void setNewCookie(User user);

	void removeLoginCookie();

}