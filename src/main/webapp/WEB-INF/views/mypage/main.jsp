<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
<div class="col-sm-12 col-md-2 col-lg-3 col-xl-3">
<br>
<h1>마이 페이지</h1>
</div>
<hr>
<div class="row">
<div class="col-sm-12 col-md-2 col-lg-3 col-xl-3">
<a href="#"><button class="btn btn-primary">내 정보</button></a><br>
<a href="/calendar/PT/schedule"><button class="btn btn-primary">내 PT 일정 보기</button></a><br>
<a href="/calendar/memolist?user_no=${user_no }"><button class="btn btn-primary">트레이너 메모 보기</button></a><br>
<a href="/info/bodyinfo_user"><button class="btn btn-primary">바디 인포</button></a><br>
<a href="/test/message/list?user_no=${user_no }"><button class="btn btn-primary">메세지 확인</button></a><br>

<c:if test="${isTrainer }">
	<a href="/trainer/page"><button class="btn btn-primary">트레이너 페이지</button></a><br>
</c:if>
<c:if test="${isManager }">
	<a href="#"><button class="btn btn-primary">관리자 페이지</button></a><br>
</c:if>

</div>
</div>
<div class="col-sm-10 col-md-8 col-lg-6 col-xl-6">
<br>

<div class="col-sm-1 col-md-2 col-lg-3 col-xl-3"></div>
</div>
</div>
<br>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>