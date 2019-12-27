<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		$(location).attr("href", "/qna/write");
	});
})
</script>

<style type="text/css">
table {
	table-layout: fixed;
}

table, th {
	text-align: center;
}

td:nth-child(2) {
	text-align: left;
	
	white-space:nowrap;	
	text-overflow: ellipsis;
	overflow: hidden;
}
</style>

<div class="container">

<h1 class="pull-left">Questions & Answers</h1>
<div class="clearfix"></div>
<hr>

<table class="table table-striped table-hover">
<thead>
	<tr>
		<th style="width: 10%">QnA번호</th>
		<th style="width: 20%">작성자</th>
		<th style="width: 40%">제목</th>
		<th style="width: 40%">본문</th>
		<th style="width: 15%">일시</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="b">
	<tr>
		<td>${b.qna_no }</td>
		<td>${b.user_name }</td>
		<td>${b.qna_title }</td>
		<td>${b.qna_content }</td>
		<td>${b.qna_date }</td>
	</tr>
	
</c:forEach>
</tbody>
</table>


<button id="btnWrite" class="btn btn-primary pull-right">글쓰기</button>

<jsp:include page="/WEB-INF/views/qna/paging.jsp" />


</div><!-- .container -->

