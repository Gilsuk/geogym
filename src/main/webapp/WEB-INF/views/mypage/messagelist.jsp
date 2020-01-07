<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<script type="text/javascript">
$(document).ready(function() {
	
	$(".messageClose").on("click", function(){
		
		$.ajax({
			url: "/message/isread", 
			data: {
				message_no: $(this).prev().text()
			},
			method: "GET"
		}).done(function(data) {
			console.log('읽음');
		})
		
		var eventListener = $(this).closest(".toast");

		eventListener.toast('dispose');
		
		setTimeout(function() {
			console.log(123)
			eventListener.css('display','none')
			
			$.ajax({
				url: "/message/count", 
				data: {
					user_no: ${loggedInUser.user_no}
				},
				method: "GET", 
				dataType: "html"
			}).done(function(data) {
				if(data > 0){
					$("#messageButton").addClass("btn-primary");
					$('#messageCount').text(data);
				} else {
					$("#messageButton").removeClass("btn-primary");
					$("#messageButton").addClass("btn-outline-primary");
					$('#messageCount').text('');
				}
			})
			
		}, 300);
	});
	
})
</script>
<br>
<div class="container">

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

	<div class="row">
		<div class="col-12">
			<br>
		</div>
		<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
			<div class="list-group">
				<a class="list-group-item list-group-item-action"
					aria-disabled="true" href="/mypage/main">내 정보</a> 
				<a class="list-group-item list-group-item-action"
					href="/calendar/PT/schedule">내 PT 일정 보기</a> 
				<a class="list-group-item list-group-item-action"
					href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>

				<c:if test="${isTrainer }">
					<a class="list-group-item list-group-item-action"
						href="/info/bodyinfo">바디 인포</a>
				</c:if>
				<c:if test="${isTrainer ne true}">
					<a class="list-group-item list-group-item-action"
						href="/info/bodyinfo_user">바디 인포</a>
				</c:if>

				<a class="list-group-item list-group-item-action active disabled"
					href="/mypage/messagelist?user_no=${user.user_no }">메세지 확인</a>

			</div>
		</div>

		<br>
		<div class="col-sm-12 col-md-12 col-lg-7 col-xl-7">
			<c:forEach items="${list }" var="list">
				<div class="toast fade show" role="alert" aria-live="assertive" aria-atomic="true">
					<div class="toast-header">
						<strong class="mr-auto">
							<fmt:parseDate value="${list.message_date }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
							<fmt:formatDate pattern="yyyy-MM-dd/HH:mm" value="${parsedDateTime }" />
						</strong>
						<small class="text-muted">${list.message_no }</small>
						<button type="button" class="ml-2 mb-1 close messageClose" data-dismiss="toast"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="toast-body">${list.message_content }</div>
				</div>
			</c:forEach>
		</div>
		<br>
		<br>
		
	</div>
</div>
<br>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>