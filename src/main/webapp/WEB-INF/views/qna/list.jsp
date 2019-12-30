<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  

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

<table class="table table-hover">
<thead>
	<tr>
		<th style="width: 10%">QnA번호</th>
		<th style="width: 20%">작성자</th>
		<th style="width: 50%; text-align: center;">제목</th>
		<th style="width: 20%">일시</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="b">
	<tr>
	<c:if test="${b.qna_isprivate }">
		<td>${b.qna_no }</td>
		<td>${b.user_name }</td>
		<td><a href="/qna/view?qna_no=${b.qna_no }">${b.qna_title }</a></td>
<%-- 		<fmt:parseDate value="${b.qna_date }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" /> --%>
		<td>${b.qna_date }</td>
<%-- 		<fmt:formatDate pattern="yyyy-MM-dd/HH:mm" value="${ parsedDateTime }" /> --%>
		
	</c:if>
	<c:if test="${!b.qna_isprivate }">
		<td>${b.qna_no }</td>
		<td>${b.user_name }</td>
		<td><span class="glyphicon glyphicon-eye-close" style="margin-right:2px;"></span>비공개</td>
		<td>${b.qna_date }</td>
	</c:if>
	</tr>
	
</c:forEach>
</tbody>
</table>


<button id="btnWrite" class="btn btn-primary pull-right">글쓰기</button>
<div class="clearfix"></div>

<jsp:include page="/WEB-INF/views/qna/paging.jsp" />

<div class="text-center">
	<form action="/qna/list" method="get">
	<div class="form-group">
		<div class="form-inline">
			<select class="form-control" name="categoryNo" >
				<option value="1">제목</option>
				<option value="2">내용</option>
				<option value="3">제목  + 내용</option>
			</select>
   			<input type="text" class="form-control" style="width:300px;" name="search" placeholder="QnA 검색">
	    	<button type="submit" class="btn">검색</button>
		</div>
	</div>
	</form>
</div>

</div><!-- .container -->

