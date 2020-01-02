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

PT신청 가능 시간
<br>
<c:forEach items="${list }" var="list">
	<a href="/test/setPTshedule?schedule_date=${day.date }&schedule_from=${list}&user_no=${user_no}&trainer_no=${trainer_no}"><button>${list }</button></a>&nbsp;
</c:forEach>

</body>
</html>