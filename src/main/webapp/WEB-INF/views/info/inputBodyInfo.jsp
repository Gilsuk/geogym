<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%--     pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- Bootstrap 4.4.1 CSS -->
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
	document.getElementById('today').valueAsDate = new Date();
</script>
<h1>신체정보입력</h1>
>>${user.user_name } 회원님
<hr>
<form action="/info/inputBodyInfo" method="POST">

<!-- <h2>입력일자 : </h2><input type="date" id="today" name="bodyinfo_date" size="10"/> -->

	<table>
		<tr>
			<th><h3>키</h3></th>
			<td><input type="text" name="bodyinfo_height">cm</td>
		</tr>
		<tr>
			<th><h3>몸무게</h3></th>
			<td><input type="text" name="bodyinfo_weight">kg</td>
		</tr>
		<tr>
			<th><h3>골격근량</h3></th>
			<td><input type="text" name="bodyinfo_fat">kg</td>
		</tr>
		<tr>
			<th><h3>체지방량</h3></th>
			<td><input type="text" name="bodyinfo_muscle">kg</td>
		</tr>
	</table>
	
	
	<textarea rows="10" cols="50" name="body_comment_msg">${bodyComment.body_comment_msg }</textarea>

	<button>입력하기</button>

</form>





</html>