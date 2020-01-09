<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>GEOGYM</title>
<!-- JQuery 3.4.1 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
   rel="stylesheet">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap 4.4.1 CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- GEOGYM CSS -->
<link rel="stylesheet" href="/resources/css/geogym.css">

<!-- Bootstrap Component -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<!-- Bootstrap 4.4.1 Script -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<!-- GEOGYM Script -->
<script src="/resources/js/geogym.js" type="text/javascript"></script>


<c:if test="${not empty loggedInUser}">
	<script type="text/javascript">
	$(document).ready(function() {
		
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
				$("#messageButton").addClass("btn-outline-primary");
			}
		})
		
		$("#messageButton").on("click", function(){
			
			window.location.replace("/mypage/messagelist");
			
// 			$.ajax({
// 				url: "/message/list", 
// 				data: {
// 					user_no: ${loggedInUser.user_no}
// 				},
// 				method: "GET", 
// 				dataType: "html"
// 			}).done(function(data) {
// 				$("#message").html(data);
// 			})
 		});
	})
	</script>
</c:if>


</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark">
			<a class="navbar-brand" href="/">GEOGYM</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/">메인
							<span class="sr-only">(current)</span>
					</a></li>
					<c:if test="${empty loggedInUser }">
					<li class="nav-item"><a class="nav-link" href="/user/login">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/join">회원가입</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="/trainer/list">트레이너</a></li>
					<li class="nav-item"><a class="nav-link" href="/qna/list">QnA</a></li>
					<c:if test="${not empty loggedInUser }">
<!-- 					<li class="nav-item"><a class="nav-link" href="/admin/main">관리자</a></li> -->
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">${loggedInUser.user_name } is logged in</a></li>
					<li class="nav-item"><a class="nav-link" href="/mypage/main">마이 페이지</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/logout">나가기</a></li>
					</c:if>
				</ul>
				
				<form class="form-inline mt-2 mt-md-0">
					<input class="form-control mr-sm-2" type="text"
						placeholder="종합검색" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
					<c:if test="${not empty loggedInUser }">
						<button id="messageButton" type="button" class="btn my-2 my-sm-0">
							알림 <span id="messageCount" class="badge badge-light"></span>
						</button>
					</c:if>
				</form>
			</div>
		</nav>
	</header>
	<main role="main">
	