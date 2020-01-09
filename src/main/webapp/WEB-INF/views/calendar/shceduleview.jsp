<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
<div class="row">
<div class="col-sm-12 col-md-2 col-lg-3 col-xl-3"></div>
<div class="col-sm-10 col-md-8 col-lg-6 col-xl-6">
<br>
<h1>스케줄 리스트</h1>
<hr>
<table class="table">
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
</div>
<div class="col-sm-1 col-md-2 col-lg-3 col-xl-3"></div>
</div>
</div>
<br>

<br>	

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>