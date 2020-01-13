<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
<br>
<h1>스케줄 리스트</h1>
<hr>
<div class="row">
		<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
			<div class="list-group">
				<a class="list-group-item list-group-item-action"
					href="/trainer/page">내 정보</a> <a
					class="list-group-item list-group-item-action active"
					href="/calendar/schedule?trainer_no=${trainer.trainer_no }">내 스케줄</a>
				<a class="list-group-item list-group-item-action"
					href="/calendar/memolist?user_no=${user.user_no }">근무</a> <a
					class="list-group-item list-group-item-action"
					href="/info/bodyinfo">바디 인포</a>
			</div>
		</div>
<div class="col-sm-10 col-md-8 col-lg-6 col-xl-6">
<table class="table">
<tr>
	<th>시간</th>
	<th>메세지</th>
</tr>
<c:forEach items="${list }" var="list">
<tr>
	<td>${list.schedule_from} ~ ${list.schedule_to}</td>
	
	<td><a href="/calendar/viewmemo?user_no=${list.user_no }&date=${list.schedule_date}"> ${list.schedule_msg } ${list.user_no }번 유저</a></td>
</tr>	
</c:forEach>
</table>
</div>
<div class="col-sm-1 col-md-2 col-lg-3 col-xl-3"></div>
</div>
</div>
<br>

<br>	

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>