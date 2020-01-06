<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function() {

// 		if (typeof ajaxFunction !== 'undefined') return;

// 		$(".btn-ajax").on("click", ajaxFunction);

// 		$.each($(".btn-ajax").closest("form"), function(index, form) {
// 			ajaxAction = $(form).attr("action");
// 		});

		$(".btn-ajax").on("click", function() {
			$.ajax({
				url: "/ajax/user/join", 
				data: {
					user_id: $("#user_id").val(),
					user_pw: $("#user_pw").val(),
					user_name: $("#user_name").val(),
					user_gender: $("#user_gender").val(),
					user_birth: $("#user_birth").val(),
					user_tel: $("#user_tel").val(),
					user_email: $("#user_email").val(),
				},
				method: "POST", 
				dataType: "json"
			}).done(function(data) {
				if (data == true) {
					window.location.replace(window.location.href);
				}
			})

			return false;
		})

	});
	
</script>
<form action="/ajax/user/join" method="post">
	<label for="user_id">ID : </label>
	<input type="text" id="user_id" name="user_id" /><br>
	<label for="user_pw">PW : </label>
	<input type="password" id="user_pw" name="user_pw" /><br>
	<label for="user_name">NAME : </label>
	<input type="text" id="user_name" name="user_name" /><br>
	<label for="user_gender_m">남자 : </label>
	<input type="radio" name="user_gender" id="user_gender_m" value="M">
	<label for="user_gender_f">여자 : </label>
	<input type="radio" name="user_gender" id="user_gender_f" value="F"><br>
	<label for="user_birth">BIRTH : </label>
	<input type="date" id="user_birth" name="user_birth" /><br>
	<label for="user_tel">TEL : </label>
	<input type="tel" id="user_tel" name="user_tel" /><br>
	<label for="user_email">EMAIL : </label>
	<input type="email" id="user_email" name="user_email" /><br>
	<input class="btn-ajax" type="submit" />
</form>

</body>
</html>