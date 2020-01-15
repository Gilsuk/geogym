<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
<div class="row">
<div class="col-12">
<br>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" href="/mypage/main">마이 페이지</a>
  </li>
  <c:if test="${isTrainer }">
	  <li class="nav-item">
	    <a class="nav-link" href="/trainer/page">트레이너 페이지</a>
	  </li>
  </c:if>
  <c:if test="${isManager }">
	  <li class="nav-item">
	    <a class="nav-link" href="#">관리자</a>
	  </li>
  </c:if>
</ul>

<br>

</div>
<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
<div class="list-group">

	<a class="list-group-item list-group-item-action" href="/mypage/main">내 정보</a>
	
	<c:choose>
		<c:when test="${pageName eq 'PT'}">
			<a class="list-group-item list-group-item-action active" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action" href="/calendar/memolist?user_no=${user_no }">트레이너 메모 보기</a>
		</c:when>
		<c:when test="${pageName eq 'memo'}">
			<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action active" href="/calendar/memolist?user_no=${user_no }">트레이너 메모 보기</a>
		</c:when>
		<c:otherwise>
			<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action active" href="/calendar/memolist?user_no=${user_no }">트레이너 메모 보기</a>
		</c:otherwise>
	</c:choose>
	
		<a class="list-group-item list-group-item-action" href="/info/bodyinfo_user">바디 인포</a>
	
	<a class="list-group-item list-group-item-action" href="/mypage/messagelist">메세지 확인</a>

</div>
</div>

<div class="col-sm-12 col-md-12 col-lg-9 col-xl-9">

<script src="//cdn.ckeditor.com/4.13.1/standard/ckeditor.js"></script>

<div class="container">

<br>
<div class="alert alert-primary" role="alert">
  <h4 class="alert-heading">${day } 메모</h4>
  <hr>
  
  <c:if test="${memo.calendar_memo_content ne null}">

  <p class="mb-0">${memo.calendar_memo_content }</p>
  
  </c:if>
  <c:if test="${memo.calendar_memo_content eq null}">
  메모가 없습니다
  </c:if>
</div>

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

</div>

</div>
</div>
<br>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>