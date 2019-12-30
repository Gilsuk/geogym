package com.geogym.common.service;

public interface AjaxService {

	void sendFail();

	void sendMessage(String msg);

	void sendSuccess();

	boolean isAjaxRequest();

}