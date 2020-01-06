<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<script src="//cdn.ckeditor.com/4.13.1/standard/ckeditor.js"></script>

<div class="container">

<br>

<h3>${day } 메모</h3>
<br>
<c:if test="${memo.calendar_memo_content ne null}">
${memo.calendar_memo_content }
</c:if>
<c:if test="${memo.calendar_memo_content eq null}">
메모가 없습니다
</c:if>

<br>
<br>
<c:if test="${isTrainer}">
	<form action="/calendar/memo" method="post">
		<input type="hidden" name="user_no" value="${user_no }"/>
		<input type="hidden" name="calendar_memo_date" value="${day }"/>
		<textarea rows="10" style="width:100%" id="calendar_memo_content" name="calendar_memo_content"></textarea>
		<script>
	        CKEDITOR.replace( 'calendar_memo_content' );
       	</script>
       	<br>
       	<button class="btn btn-primary" id="btnWrite">작성</button>
	</form>
</c:if>
</div>
<br>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>