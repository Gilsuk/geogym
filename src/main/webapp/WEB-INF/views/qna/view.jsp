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
});
</script>

<style type="text/css">
td.info {
	width: 10%;
}
td:not(.info) {
	width: 40%;
}
</style>

<div class="container">

<h1 class="pull-left">질문글 상세보기</h1>
<div class="clearfix"></div>
<hr>

<table class="table table-bordered">
<tr>
<td class="info">글번호</td><td colspan="3">${view.qna_no }</td>
</tr>

<tr>
<td class="info">아이디</td><td colspan="2">${view.user_name }</td>
</tr>

<tr>
<td class="info">작성일</td><td colspan="2">${view.qna_date }</td></tr>

<tr>
<td class="info">제목</td><td colspan="3">${view.qna_title }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${view.qna_content }</td></tr>

</table>

<!-- 버튼 영역 -->
<div class="text-center">
	<a href="/qna/list"><button class="btn btn-default">목록</button></a>
<%-- 	<c:if test="${id eq view.writerId }"> --%>
		<a href="/qna/update?qna_no=${view.qna_no }"><button class="btn btn-primary">수정</button></a>
		<a href="/qna/delete?qna_no=${view.qna_no }"><button class="btn btn-danger">삭제</button></a>
<%-- 	</c:if> --%>
</div><!-- 버튼 영역 end -->

<h3>답변</h3>
<!-- 댓글 처리 -->
<div>

<hr>

<!-- 비로그인상태 -->
<%-- <c:if test="${not login }"> --%>
<!-- <strong>로그인이 필요합니다</strong><br> -->
<!-- <button onclick='location.href="/member/login";'>로그인</button> -->
<!-- <button onclick='location.href="/member/join";'>회원가입</button> -->
<%-- </c:if> --%>

<!-- 로그인상태 -->
<%-- <c:if test="${login }"> --%>
<!-- 댓글 입력 -->
<div class="form-inline text-center">
	<form action="/answer/write" method="post">
<%-- 	<input type="text" size="10" class="form-control" id="commentWriter" value="${usernick }" readonly="readonly"/> --%>
	<input type="text" name="qna_no" value="${view.qna_no }" hidden="hidden" >
	<textarea rows="2" cols="60" class="form-control" id="answer" name="qna_answer_content"></textarea>
	<button class="btn btn-defualt">입력</button>
	</form>
</div>	<!-- 댓글 입력 end -->
<%-- </c:if> --%>

<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed">
<thead>
<tr>
	<th style="width: 10%;">작성자</th>
	<th style="width: 80%;">답변</th>
	<th style="width: 10%;">작성일</th>
</tr>
</thead>
<tbody id="answerBody">
<tr>
	<td>${answer.trainer_name }</td>
	<td>${answer.qna_answer_content }</td>
	<td>${answer.qna_answer_date }</td>
</tr>
</tbody>
</table>	<!-- 댓글 리스트 end -->

</div>	<!-- 댓글 처리 end -->

</div><!-- .container -->
