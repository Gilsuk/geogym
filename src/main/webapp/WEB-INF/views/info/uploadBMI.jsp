<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>BMI사진 업로드</h1>
<hr>

<form action="/info/uploadBMIProc" method="POST" enctype="multipart/form-data">
<input type="file" name="file"/>
<input type="hidden" name="bodyinfo_no" value="${bodyinfo_no }"/>
<button>등록</button>
</form>

</body>
</html>