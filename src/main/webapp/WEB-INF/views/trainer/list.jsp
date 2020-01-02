<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

	<h1>트레이너리스트</h1>

	<c:forEach items="${list }" var="al">
		<div class="list-container col-xs-4 col-md-2">
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

	</c:forEach>

</body>
</html>