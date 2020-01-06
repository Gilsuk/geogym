<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<a href="/trainer/profile">프로필</a>
<a href="/trainer/reputation?trainer_no=${trainer.trainer_no }">실적</a>
<a href="#">근무</a>
<a href="/trainer/clients">관리회원리스트</a>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>