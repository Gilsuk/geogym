<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {

		$(".form-signin").on("submit", function(){
			$(".btn-ajax").click();
   			return false;
 		});
 		
		$(".btn-ajax").on("click", function() {
			$.ajax({
				url: "/ajax/user/login", 
				data: {
					user_id: $("#user_id").val(),
					user_pw: $("#user_pw").val(),
					shouldRemember: $("#shouldRemember").val()
				},
				method: "POST", 
				dataType: "json"
			}).done(function(data) {
				if (data == true) {
					window.location.replace(window.location.href);
				} else {
					alert("틀림");
				}
			})
		});
	});
	
</script>
<div class="row">
	<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
		<div class="card card-signin my-5">
			<div class="card-body">
				<h5 class="card-title text-center">로그인</h5>
				<form class="form-signin">
					<div class="form-label-group">
						<input type="text" id="user_id" class="form-control"
							name="user_id" placeholder="ID" required autofocus>
						<label for="user_id">아이디</label>
					</div>

					<div class="form-label-group">
						<input type="password" id="user_pw" class="form-control"
							name="user_pw" placeholder="Password" required>
						<label for="user_pw">비밀번호</label>
					</div>

					<div class="custom-control custom-switch">
						<input type="checkbox" class="custom-control-input"
							id="shouldRemember">
						<label class="custom-control-label" 
							for="shouldRemember">기억하기</label>
					</div>

					<hr>


					<button
						class="btn btn-ajax btn-lg btn-submit btn-block text-uppercase"
						type="button">로그인</button>
					<hr class="my-4">
					<button class="btn btn-lg btn-google btn-block text-uppercase"
						type="button">Google</button>
					<button class="btn btn-lg btn-naver btn-block text-uppercase"
						type="button">NAVER</button>
					<button class="btn btn-lg btn-kakao btn-block text-uppercase"
						type="button">KAKAO</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>