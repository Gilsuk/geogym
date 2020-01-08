<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<a class="list-group-item list-group-item-action active"
					href="/trainer/page">내 정보</a> <a
					class="list-group-item list-group-item-action"
					href="/calendar/schedule?trainer_no=${trainer.trainer_no }">PT</a>
				<a class="list-group-item list-group-item-action"
					href="/calendar/memolist?user_no=${user.user_no }">근무</a> <a
					class="list-group-item list-group-item-action"
					href="/info/bodyinfo">바디 인포</a>
			</div>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/calendar/viewcalendar.jsp"%>
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>