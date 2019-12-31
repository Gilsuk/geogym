<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/attachment/upload2" method="post" enctype="multipart/form-data">
	<label for="file">file</label> <input multiple="multiple" type="file" name="file" id="file"/><br>
	<button>확인</button>
</form>
</body>
</html>