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
				user_gender : $("input[name='user_gender']:checked").val(),
				user_birth : $("#user_birth").val(),
				user_tel : $("#user_tel").val(),
				user_email : $("#user_email").val()
			},
			method : "POST",
			dataType : "json"
		}).done(function(data) {
			if (data == true) {
				window.location.replace(window.location.href);
			}
		})

		return false;
	});

	$("#user_id").on("blur", function() {
		if (isDuplicated("/user/check/id", "#user_id")) {
			// id 중복시 처리
			$("#user_id").removeClass("is-valid");
			$("#user_id").addClass("is-invalid");
		} else {
			// 안중복 처리
			$("#user_id").removeClass("is-invalid");
			$("#user_id").addClass("is-valid");
		}
	});

	$("#user_email").on("blur", function() {
		if (isDuplicated("/user/check/email", "#user_email")) {
			// email 중복시 처리
			$("#user_email").removeClass("is-valid");
			$("#user_email").addClass("is-invalid");
		} else {
			// 안중복 처리
			$("#user_email").removeClass("is-invalid");
			$("#user_email").addClass("is-valid");
		}
	});
});

function isDuplicated(url, selector) {
	var result = false;
	$.ajax({
		url : url,
		data : {
			param_user : $(selector).val()
		},
		method : "POST",
		dataType : "json",
		async: false
	}).done(function(data) {
		if (data == true)
			result = true;
		else
			result = false;
	});

	return result;
}