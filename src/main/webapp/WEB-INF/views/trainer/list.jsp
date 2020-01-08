<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<br>

<div class="container">

	<h1>트레이너리스트</h1>
	
	<hr>
	
	<div class="card-deck overflow-auto">
	<c:forEach items="${list }" var="al">
	
	<div class="card" style="width: 18rem;">
		<c:if test="${not empty al.attachment.attachment_stored_name }">
			<img src="/upload/${al.attachment.attachment_stored_name }" alt="${al.attachment.attachment_origin_name }" />
		</c:if>
		<c:if test="${empty al.attachment.attachment_stored_name }">
			<img src="/upload/489921e0b979_test2.jpg" alt="기본" />
		</c:if>
		
		<div class="card-body">
			<h5 class="card-title">${al.user.user_name }</h5>
			<p class="card-text">${al.trainer_profile }</p>
			<a href="/trainer/select?trainer_no=${al.trainer_no }" class="btn btn-primary">프로필 보기</a>
		</div>
	</div>
	
	</c:forEach>
	
	</div>
	
</div>

<br>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>