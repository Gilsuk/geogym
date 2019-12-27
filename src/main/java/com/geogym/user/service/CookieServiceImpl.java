package com.geogym.user.service;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.user.dao.CookieDao;
import com.geogym.user.dto.LoginCookie;
import com.geogym.user.dto.User;
import com.geogym.user.exception.CookieNotFoundException;

@Service
public class CookieServiceImpl implements CookieService {

	@Autowired private HttpServletRequest req;
	@Autowired private HttpServletResponse resp;
	@Autowired private CookieDao dao;
	
	@Override
	public void restoreSessionAccount() throws CookieNotFoundException {

		// 클라이언트의 쿠키로부터 쿠키값을 얻어온다.
		// 클라이언트의 쿠키가 없으면 CookieNotFoundException을 던진다.
		String cookie_id = getCookieValue("cookie_id");

		// 쿠키(dto)객체에 쿠키값과 클라이언트의 ip를 넣는다.
		// 이 두 정보는 cookie 테이블을 조회하는데 필요한 primary key이다.
		LoginCookie cookie = getCookieWithPrimaryKeys(cookie_id);

		// 클라이언트에서 얻은 정보와 서버의 DB를 매칭하여 유효성을 검증한다.
		// 유효한 쿠키라면 Account 객체가 반환되며, SelectResultException 에러를 던진다.
		User user = dao.selectUserByCookie(cookie);

		// 유효한 객체가 반환되면, DB의 마지막 접속 기록을 갱신한다.
		cookie.setUser_no(user.getUser_no());
		dao.update(cookie);

		// 세션에 로그인 정보(Account)를 전달한다.
		req.getSession().setAttribute("loggedInUser", user);
	}

	private LoginCookie getCookieWithPrimaryKeys(String cookie_id) {
		LoginCookie cookie = new LoginCookie();
		cookie.setCookie_id(cookie_id);
		cookie.setCookie_ip(req.getRemoteAddr());

		return cookie;
	}

	private String getCookieValue(String cookieName) throws CookieNotFoundException {
		Cookie[] cookies = req.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals(cookieName))
					return cookie.getValue();

		throw new CookieNotFoundException();
	}

	@Override
	public void setNewCookie(User user) {
		String cookie_id = getRandomCookieId();
		LoginCookie cookie = getCookieWithPrimaryKeys(cookie_id);

		cookie.setUser_no(user.getUser_no());
		dao.update(cookie);

		sendCookieToClient("cookie_id", cookie.getCookie_id(), 86400);
	}


	private void sendCookieToClient(String cookieName, String cookieValue, int expire) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(expire);
		cookie.setPath("/");
		resp.addCookie(cookie);
	}

	private String getRandomCookieId() {
		UUID randomUUID = UUID.randomUUID();
		String cookie_id = randomUUID.toString().split("-")[0];
		return cookie_id;
	}

	@Override
	public void removeLoginCookie() {
		String cookie_id;
		try {
			cookie_id = getCookieValue("cookie_id");
		} catch (CookieNotFoundException e) { return; }

		LoginCookie cookie = getCookieWithPrimaryKeys(cookie_id);
		dao.delete(cookie);

		sendCookieToClient("cookie_id", "", 0);
	}
}
