<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
<div class="row">
<div class="col-12">
<br>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" href="/mypage/main">마이 페이지</a>
  </li>
  <c:if test="${isTrainer }">
	  <li class="nav-item">
	    <a class="nav-link" href="/trainer/page">트레이너 페이지</a>
	  </li>
  </c:if>
  <c:if test="${isManager }">
	  <li class="nav-item">
	    <a class="nav-link" href="#">관리자</a>
	  </li>
  </c:if>
</ul>

<br>

</div>
<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
<div class="list-group">

	<a class="list-group-item list-group-item-action" href="/mypage/main">내 정보</a>
	
	<c:choose>
		<c:when test="${pageName eq 'PT'}">
			<a class="list-group-item list-group-item-action active" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:when>
		<c:when test="${pageName eq 'memo'}">
			<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action active" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:when>
		<c:otherwise>
			<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action active" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${isTrainer }">
		<a class="list-group-item list-group-item-action" href="/info/bodyinfo">바디 인포</a>
	</c:if>
	<c:if test="${isTrainer ne true}">
		<a class="list-group-item list-group-item-action" href="/info/bodyinfo_user">바디 인포</a>
	</c:if>
	
	<a class="list-group-item list-group-item-action" href="/mypage/messagelist">메세지 확인</a>

</div>
</div>

<div class="col-sm-12 col-md-12 col-lg-9 col-xl-9">

<%@ include file="/WEB-INF/views/info/bodyinfo.jsp"%>

</div>

</div>
</div>
<br>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>