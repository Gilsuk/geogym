<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-12">
			<br>
			<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" href="/mypage/main">마이 페이지</a>
  </li>
  <c:if test="${isTrainer }">
	  <li class="nav-item">
	    <a class="nav-link active" href="/trainer/page">트레이너 페이지</a>
	  </li>
  </c:if>
  <c:if test="${isManager }">
	  <li class="nav-item">
	    <a class="nav-link" href="/test/setbusinessday">관리자</a>
	  </li>
  </c:if>
</ul>
			<h1>PT 일정</h1>
			<hr>
		</div>
		<c:if test="${isTrainer }">
		<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
			<div class="list-group">
				<a class="list-group-item list-group-item-action"
					href="/trainer/page">내 정보</a> <a
					class="list-group-item list-group-item-action active"
					href="/calendar/schedule?trainer_no=${trainer.trainer_no }">내 스케줄</a>
			</div>
		</div>
		</c:if>
		<c:if test="${request }">
		<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
<!-- 		<div class="card-deck">	 -->
	<div class="card">
		<c:if test="${not empty trainer.attachment.attachment_stored_name }">
			<img class=col-12 src="/upload/${trainer.attachment.attachment_stored_name }" alt="${al.attachment.attachment_origin_name }" />
		</c:if>
		<c:if test="${empty trainer.attachment.attachment_stored_name }">
			<img class="profilePic" src="/upload/489921e0b979_test2.jpg" alt="기본" />
		</c:if>
		
		<div class="card-body">
<%-- 			<h5 class="card-title">${trainer.user.user_name }</h5> --%>
			<p class="card-text">${trainer.trainer_profile }</p>
			<a href="/trainer/select?trainer_no=${trainer.trainer_no }" class="btn btn-primary">프로필 보기</a>
<!-- 		</div> -->
		</div>
	</div>
	
	
	</div>
		</c:if>
		<div class="col-sm-12 col-md-12 col-lg-9 col-xl-9">
	<%@ include file="/WEB-INF/views/calendar/viewcalendar.jsp"%>
	</div>
	</div>
	
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>