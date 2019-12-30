<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>
<h1>
	메인페이지
</h1>
<c:if test="${not empty user }">
<p>${user.user_name } is logged in</p>
</c:if>
<div class="container">
	<ul>
		<li><a href="/user/login">로그인</a></li>
		<li><a href="/user/join">회원가입</a></li>
	</ul>
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>