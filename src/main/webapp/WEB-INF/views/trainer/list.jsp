<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

	<h1>트레이너리스트</h1>

<div class="container">
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
			<h5 class="card-title">트레이너 이름!</h5>
			<p class="card-text">${al.trainer_profile }</p>
			<a href="/trainer/select?trainer_no=${al.trainer_no }" class="btn btn-primary">프로필 보기</a>
		</div>
	</div>
	</c:forEach>
	
	</div>
	
<!-- 		<a href=""> -->
<!-- 		<div style="width:300px; height:500px; float: left; margin-right:15px;"> -->
<!-- 			<div class="thumbnail"> -->
<%-- 				<c:if test="${not empty al.attachment.attachment_stored_name }"> --%>
<%-- 					<img src="/upload/${al.attachment.attachment_stored_name }" --%>
<%-- 						alt="${al.attachment.attachment_origin_name }" /> --%>
<!-- <!-- 					      //로고부분 넣는 실제로 들어가야함 --> -->
<%-- 				</c:if> --%>
<%-- 				<c:if test="${empty al.attachment.attachment_stored_name }"> --%>
<!-- 					<img src="/upload/489921e0b979_test2.jpg" -->
<!-- 						alt="기본" /> -->
<!-- 					      //로고부분 넣는 실제로 들어가야함 -->
<%-- 				</c:if> --%>
<!-- 				<div class="caption"> -->


<%-- 					<h6>주소 : ${al.trainer_address }</h6> --%>
<!-- 					<h6>근</h6> -->
<!-- 					<h6>프로필 : </h6> -->


<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</a> -->
	
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>