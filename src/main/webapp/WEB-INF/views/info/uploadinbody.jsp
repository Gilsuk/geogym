<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- GEOGYM CSS -->
<link rel="stylesheet" href="/resources/css/geogym.css">
<!-- JQuery 3.4.1 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<!-- Bootstrap Component -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<!-- Bootstrap 4.4.1 Script -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<!-- GEOGYM Script -->
<script src="/resources/js/geogym.js" type="text/javascript"></script>
<script type="text/javascript">
	function popupClose(form){
		form.target = opener.name;
		
		form.submit();
	}
</script>
</head>
<body>

<h1 style="text-align:center">inbody결과 사진 업로드</h1>
<hr>

<form action="/info/uploadinbodyProc" method="POST" enctype="multipart/form-data" target="uploadinbody.do">
<input type="file" name="file"/>
<input type="hidden" name="bodyinfo_no" value="${bodyinfo_no }"/>
<button onclick="window.close()">등록</button>
</form>

</body>
</html>