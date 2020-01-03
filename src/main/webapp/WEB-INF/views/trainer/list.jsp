<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>


<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


	<h1>트레이너리스트</h1>

<div style="white-space:nowrap; overflow:auto; height:40%; border: black;">
	<c:forEach items="${list }" var="al">
		<a href="/trainer/select?trainer_no=${al.trainer_no }">
		<div style="width:300px; height:500px; float: left; margin-right:15px;">
			<div class="thumbnail">
				<c:if test="${not empty al.attachment.attachment_stored_name }">
					<img src="/upload/${al.attachment.attachment_stored_name }"
						alt="${al.attachment.attachment_origin_name }" />
<!-- 					      //로고부분 넣는 실제로 들어가야함 -->
				</c:if>
				<c:if test="${empty al.attachment.attachment_stored_name }">
					<img src="/upload/489921e0b979_test2.jpg"
						alt="기본" />
					<!--       //로고부분 넣는 실제로 들어가야함 -->
				</c:if>
				<div class="caption">


					<h6>주소 : ${al.trainer_address }</h6>
					<h6>값 : ${al.trainer_price }근</h6>
					<h6>프로필 : ${al.trainer_profile }</h6>


				</div>
			</div>
		</div>
	</a>
	</c:forEach>
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>