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

${day }<br>
<c:if test="${memo.calendar_memo_content ne null}">
${memo.calendar_memo_content }
</c:if>
<c:if test="${memo.calendar_memo_content eq null}">
메모가 없습니다
</c:if>

<c:if test="${isTrainer}">
	<form action="/calendar/memo" method="get">
		<input type="hidden" name="calendar_memo_date" value="${day }"/>
		<input type="text" name="calendar_memo_content"/>
		<button>작성</button>
	</form>
</c:if>

</body>
</html>