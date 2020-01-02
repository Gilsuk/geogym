<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 테스트용임 서비스를 불러서 사용할것 -->

<form action="/attachment/upload" method="post" enctype="multipart/form-data">
	<label for="file">file</label> <input type="file" name="file" id="file"/><br>
	<label for="file">file2</label> <input type="file" name="file2" id="file2"/><br>
	<button>확인</button>
</form>
</body>
</html>