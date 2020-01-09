<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {

		$(".form-join").on("submit", function() {
			$(".btn-ajax").click();
			return false;
		});

		$(".btn-ajax").on("click", function() {
			$.ajax({
				url : "/ajax/user/join",
				data : {
					user_id : $("#user_id").val(),
					user_pw : $("#user_pw").val(),
					user_name : $("#user_name").val(),
					user_gender : $("#user_gender").val(),
					user_birth : $("#user_birth").val(),
					user_tel : $("#user_tel").val(),
					user_email : $("#user_email").val(),
				},
				method : "POST",
				dataType : "json"
			}).done(function(data) {
				if (data == true) {
					window.location.replace(window.location.href);
				}
			})

			return false;
		})

	});
</script>
<div class="row">
	<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
		<div class="card card-signin my-5">
			<div class="card-body">
				<h5 class="card-title text-center">회원가입</h5>
				<form class="form-join">
					<div class="form-label-group">
						<input type="text" id="user_id" class="form-control"
							name="user_id" placeholder="ID" required autofocus> <label
							for="user_id">아이디</label>
					</div>

					<div class="form-label-group">
						<input type="password" id="user_pw" class="form-control"
							name="user_pw" placeholder="Password" required> <label
							for="user_pw">비밀번호</label>
					</div>

					<div class="form-label-group">
						<input type="text" id="user_name" class="form-control"
							name="user_name" placeholder="ID" required autofocus> <label
							for="user_name">이름</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input class="custom-control-input" type="radio"
							id="user_gender_m" name="user_gender" value="M" checked="checked">
						<label class="custom-control-label" for="user_gender_m">남자</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input class="custom-control-input" type="radio"
							id="user_gender_f" name="user_gender" value="F"> <label
							class="custom-control-label" for="user_gender_f">여자</label>
					</div>
					<!-- 				user_birth:date, user_tel:tel, user_email:email -->


					<button
						class="btn btn-ajax btn-lg btn-submit btn-block text-uppercase"
						type="button">가입하기</button>
				</form>
			</div>
		</div>
	</div>
</div>
</div>
</html>