<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {

		$(".form-join").on("submit", function() {
			$(".btn-ajax").click();
			return false;
		});

		$(".btn-ajax").on("click", function() {
			$.ajax({
				url : "/user/join/google/proc",
				data : {
					user_id : $("#user_id").val(),
					user_name : $("#user_name").val(),
					user_gender : $("input[name='user_gender']:checked").val(),
					user_birth : $("#user_birth").val(),
					user_tel : $("#user_tel").val(),
					user_email : $("#user_email").val(),
					id_token: $("#id_token").val()
				},
				method : "POST",
				dataType : "json"
			}).done(function(data) {
				if (data == true) {
					window.location.replace('/');
				} else {
					var nameinput = $("#user_id");
					nameinput.val("다른 별명을 사용하세요");
					nameinput.focus();
				}
			}).fail(function(data) {
				
				console.log(data);
			});

			return false;
		})

	});
</script>
<div class="row">
	<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
		<div class="card card-signin my-5">
			<div class="card-body">
				<h5 class="card-title text-center">처음이시군요?</h5>
				<form class="form-join">
					<div class="form-label-group">
						<input type="text" id="user_id" class="form-control"
							name="user_id" placeholder="ID" required autofocus> <label
							for="user_id">아이디</label>
					</div>

					<div class="form-label-group">
						<input type="text" id="user_name" class="form-control"
							name="user_name" value="${user_name }" readonly required > <label
							for="user_name">이름</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input class="custom-control-input" type="radio"
							id="user_gender_m" name="user_gender" value="M" checked="checked" />
						<label class="custom-control-label" for="user_gender_m">남자</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input class="custom-control-input" type="radio"
							id="user_gender_f" name="user_gender" value="F" /> <label
							class="custom-control-label" for="user_gender_f">여자</label>
					</div>

					<div class="form-label-group">
						<input class="form-control" type="date"
							id="user_birth" name="user_birth" required> <label
							for="user_birth">생년월일</label>
					</div>

					<div class="form-label-group">
						<input class="form-control" type="tel"
							id="user_tel" name="user_tel" required> <label
							for="user_tel">전화번호</label>
					</div>

					<input type="text" id="id_token" name="id_token" value="${id_token }" hidden="hidden" required />

					<div class="form-label-group">
						<input class="form-control" type="email"
							id="user_email" name="user_email" readonly required value="${user_email }"> <label
							for="user_email">메일주소</label>
					</div>

					<button
						class="btn btn-ajax btn-lg btn-submit btn-block text-uppercase"
						type="submit">가입하기</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>