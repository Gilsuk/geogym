<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<script>
	var clickedGSignIn = false;
	function clickGSignIn() {
		clickedGSignIn = true;
	}
	
    function onSuccess(googleUser) {
    	if (!clickedGSignIn) return;
    	
    	console.log(googleUser);
    	var profile = googleUser.getBasicProfile();
    	var email = profile.getEmail();
    	var name = profile.getName();
    	var id_token = email;
    	
		var url = '/user/login/google';

		$.ajax({
			url : url,
			data : {
				id_token: id_token,
			},
			method : "POST",
			dataType : "json"
		}).done(function(data) {
			// 달아드렸습니다.
			if (data == true) {
				var href = window.location.href;
				var loginUriRegex = RegExp("/user/login");
				
				if (loginUriRegex.test(href)) {
					window.location.replace("/");
				} else {
					window.location.replace(href);
				}
				
			} else {
				var url = '/user/join/google';
				var form = $('<form action="' + url + '" method="post">'
					+ '<input type="email" name="user_email" value="' + email + '" />'
					+ '<input type="text" name="user_name" value="' + name + '" />'
					+ '<input type="text" name="id_token" value="' + id_token + '" />'
					+ '</form>');
				$('body').append(form);
				form.submit();
			}
		})
	}

	function onFailure(error) {
		console.log(error);
	}

	function renderButton() {
		gapi.signin2.render('my-signin2', {
			'scope' : 'profile email',
			'width' : 240,
			'height' : 50,
			'longtitle' : true,
			'theme' : 'dark',
			'onsuccess' : onSuccess,
			'onfailure' : onFailure
		});
	}
</script>

  <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
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
					var href = windows.location.href;
					var loginUriRegex = RegExp("/user/login");
				
					if (loginUriRegex.test(href)) {
						window.location.replace("/");
					} else {
						window.location.replace(window.location.href);
					}
				} else {
					console.log($(".form-signin"));
					$(".form-signin").eq(0).trigger('reset');
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
						type="submit">로그인</button>
					<hr class="my-4">
					<div id="my-signin2" onclick="clickGSignIn()"></div>
					
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