<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<br>

<div class="container">
<div class="row">
<div class="col-sm-12 col-md-2 col-lg-3 col-xl-3"></div>
<div class="col-sm-10 col-md-8 col-lg-6 col-xl-6">
<br>
<h1>PT신청 가능 시간</h1>
<hr>
<c:forEach items="${list }" var="list">
	<a href="/test/setPTshedule?schedule_date=${day }&schedule_from=${list}&user_no=${user_no}&trainer_no=${trainer_no}"><button>${list }</button></a>&nbsp;
</c:forEach>
</div>
<div class="col-sm-1 col-md-2 col-lg-3 col-xl-3"></div>
</div>
</div>
<br>

<br>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>