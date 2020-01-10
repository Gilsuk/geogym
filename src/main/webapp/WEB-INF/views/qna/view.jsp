<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>



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

<br>
<br>

<h1 class="pull-left">질문글 상세보기</h1>
<div class="clearfix"></div>
<hr>

<table class="table table-bordered">
<tr>
<td class="info">글번호</td><td colspan="3">${view.qna_no }</td>
</tr>

<tr>
<td class="info">아이디</td><td colspan="2">${view.user.user_name }</td>
</tr>

<tr>
<td class="info">작성일</td><td colspan="2">${view.qna_date }</td></tr>

<tr>
<td class="info">제목</td><td colspan="3">${view.qna_title }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${view.qna_content }</td></tr>

</table>
<c:if test="${fileList.size() != 0 }">
	<c:forEach items="${fileList }" var="file">
		<span><a href="/qna/file/download?qna_no=${view.qna_no }">${file.attachment_origin_name }</a></span>
	</c:forEach>
</c:if>
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
<c:if test="${empty answer }">
<div class="form-inline text-center">
	<form action="/answer/write" method="post" enctype="multipart/form-data">
<%-- 	<input type="text" size="10" class="form-control" id="commentWriter" value="${usernick }" readonly="readonly"/> --%>
	<input type="text" name="qna_no" value="${view.qna_no }" hidden="hidden" >
	<textarea rows="2" cols="60" class="form-control" id="answer" name="qna_answer_content"></textarea>
	<input type="file" name="file">
	<button class="btn btn-defualt">입력</button>
	</form>
</div>	<!-- 댓글 입력 end -->
</c:if>
<%-- </c:if> --%>

<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed">
<thead>
<tr>
	<th style="width: 10%;">작성자</th>
	<th style="width: 70%;">답변</th>
	<th style="width: 20%;">작성일</th>
</tr>
</thead>
<tbody id="answerBody">
<tr>
	<td style="width: 10%;">${answer.trainer_name }</td>
	<td style="width: 70%;">${answer.qna_answer_content }</td>
	<td style="width: 20%;">${answer.qna_answer_date }</td>
</tr>
</tbody>
</table>	<!-- 댓글 리스트 end -->
<c:if test="${answerFileList.size() != 0 }">
	<c:forEach var="file" items="${answerFileList }">
		<c:forEach items="${answerFileList }" var="answerFile">
			<span><a href="/answer/file/download?qna_answer_no=${answer.qna_answer_no }">${answerFile.attachment_origin_name }</a></span>
		</c:forEach>
	</c:forEach>
</c:if>

</div>	<!-- 댓글 처리 end -->

</div><!-- .container -->


<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>