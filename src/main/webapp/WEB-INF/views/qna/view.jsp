<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
<td class="info">글번호</td><td colspan="3">${view.boardNo }</td>
</tr>

<tr>
<td class="info">아이디</td><td>${view.writerId }</td>
<td class="info">닉네임</td><td>${view.writerNick }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${view.hit }</td>
<td class="info">작성일</td><td><fmt:formatDate value="${view.writeDate }" pattern="yy-MM-dd hh:mm:ss" /></td></tr>

<tr>
<td class="info">제목</td><td colspan="3">${view.title }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${view.content }</td></tr>

</table>

<!-- 버튼 영역 -->
<div class="text-center">
	<a href="/board/list"><button class="btn btn-default">목록</button></a>
	<c:if test="${id eq view.writerId }">
		<a href="/board/update?boardNo=${view.boardNo }"><button class="btn btn-primary">수정</button></a>
		<a href="/board/delete?boardNo=${view.boardNo }"><button class="btn btn-danger">삭제</button></a>
	</c:if>
</div><!-- 버튼 영역 end -->

</div><!-- .container -->
