package com.geogym.common.service.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.common.service.AjaxService;

@Service
public class AjaxServiceImpl implements AjaxService {
	
	@Autowired private HttpServletRequest req;
	@Autowired private HttpServletResponse resp;
	
	@Override
	public void sendFail() {
		getWriter().println(false);
	}

	@Override
	public void sendMessage(String msg) {
		getWriter().println(msg);
	}
	
	@Override
	public void sendSuccess() {
		getWriter().println(true);
	}

	@Override
	public boolean isAjaxRequest() {
		return req.getHeader("X-Requested-With").equals("XMLHttpRequest");
	}

	private PrintWriter getWriter() {
		try {
			resp.setCharacterEncoding("utf-8");
			return resp.getWriter();
		} catch (IOException e) {
			return new PrintWriter(System.out);
		}
	}

}
