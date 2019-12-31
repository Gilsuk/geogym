<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<jsp:include page="/WEB-INF/views/layouts/header.jsp" />


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