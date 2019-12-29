<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/test/user/login" method="post">
	<label for="user_id">ID : </label>
	<input type="text" id="user_id" name="user_id" /><br>
	<label for="user_pw">PW : </label>
	<input type="password" id="user_pw" name="user_pw" /><br>
	<label for="shouldRemember">로그인 유지 : </label>
	<input type="checkbox" id="shouldRemember" name="shouldRemember" /><br>
	<input type="submit" />
</form>

</body>
</html>