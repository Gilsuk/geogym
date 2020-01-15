<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<script type="text/javascript">

	$(document).ready(function() {
		setTimeout(function() {
		    window.location.href = '/mypage/main';
		}, 1500);
	})

</script>

<br>
<div class="container">

	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active"
			href="/mypage/main">마이 페이지</a></li>
		<c:if test="${isTrainer }">
			<li class="nav-item"><a class="nav-link" href="/trainer/page">트레이너
					페이지</a></li>
		</c:if>
		<c:if test="${isManager }">
			<li class="nav-item"><a class="nav-link" href="#">관리자</a></li>
		</c:if>
	</ul>

	<div class="row">
		<div class="col-12">
			<br>
		</div>
		<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
			<div class="list-group">
				<a class="list-group-item list-group-item-action"
					aria-disabled="true" href="/mypage/main">내 정보</a> <a
					class="list-group-item list-group-item-action"
					href="/calendar/PT/schedule">내 PT 일정 보기</a> <a
					class="list-group-item list-group-item-action"
					href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>

				<c:if test="${isTrainer }">
					<a class="list-group-item list-group-item-action"
						href="/info/bodyinfo">바디 인포</a>
				</c:if>
				<c:if test="${isTrainer ne true}">
					<a class="list-group-item list-group-item-action"
						href="/info/bodyinfo_user">바디 인포</a>
				</c:if>

				<a class="list-group-item list-group-item-action"
					href="/mypage/messagelist?user_no=${user.user_no }">메세지 확인</a> <a
					class="list-group-item list-group-item-action active disabled"
					href="/payment/form">캐시 충전</a>
			</div>
		</div>

		<br>
		<div class="col-sm-12 col-md-12 col-lg-7 col-xl-7">
			<h2>결제</h2>
			<hr>
			<p>결제 성공했습니다.</p>
		</div>
	</div>
</div>
<br>
    
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>