<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<br>

<table>
<tr>
	<th>시간</th>
	<th>메세지</th>
</tr>
<c:forEach items="${list }" var="list">
<tr>
	<td>${list.schedule_from} ~ ${list.schedule_to}</td>
	<td>${list.schedule_msg }</td>
</tr>	
</c:forEach>
</table>

</body>
</html>