<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
<div class="row">
<div class="col-12">
<br>
<h1>마이 페이지</h1>
<hr>
</div>
<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
<div class="list-group">
	<a class="list-group-item list-group-item-action active disabled" aria-disabled="true">내 정보</a>
	<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
	<a class="list-group-item list-group-item-action" href="/calendar/memolist?user_no=${user_no }">트레이너 메모 보기</a>
	
	<c:if test="${isTrainer }">
		<a class="list-group-item list-group-item-action" href="/info/bodyinfo">바디 인포</a>
	</c:if>
	<c:if test="${isTrainer ne true}">
	<a class="list-group-item list-group-item-action" href="/info/bodyinfo_user">바디 인포</a>
	</c:if>
	
	<a class="list-group-item list-group-item-action" href="/test/message/list?user_no=${user_no }">메세지 확인</a>

	<c:if test="${isTrainer }">
	<a class="list-group-item list-group-item-action" href="#">트레이너 페이지</a>
	</c:if>

<c:if test="${isManager }">
	<a class="list-group-item list-group-item-action" href="#">관리자 페이지</a>
</c:if>

</div>
</div>

<div class="col-sm-12 col-md-12 col-lg-9 col-xl-9">






</div>

</div>
</div>
<br>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>