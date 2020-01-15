<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	    <a class="nav-link" href="/test/setbusinessday">관리자</a>
	  </li>
  </c:if>
</ul>

<br>
</div>
<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
<div class="list-group">
	<a class="list-group-item list-group-item-action active disabled" aria-disabled="true">내 정보</a>

	<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
	<a class="list-group-item list-group-item-action" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
	
	
	<a class="list-group-item list-group-item-action" href="/info/bodyinfo_user">바디 인포</a>
	
	<a class="list-group-item list-group-item-action" href="/mypage/messagelist">메세지 확인</a>
	<a class="list-group-item list-group-item-action" href="/payment/form">캐시 충전</a>

</div>
</div>

<div class="col-sm-12 col-md-12 col-lg-9 col-xl-9">

<form>

  <div class="form-group row">
    <label class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${user.user_name }">
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">성별</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${user.user_gender }">
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">생년월일</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${user.user_birth }">
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">연락처</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${user.user_tel }">
    </div>
  </div>
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">ID</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${user.user_id }">
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">email</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${user.user_email }">
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">이용권</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${ticket.ticket_active_date }(${ticket.ticket_duration } 일)">
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">캐시</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${cash }">
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">PT 이용권</label>
      <c:forEach items="${list }" var="list">
    	<div class="col-sm-10">
        	<input type="text" readonly class="form-control-plaintext" value="'${list.trainer_name }' 트레이너 : ${list.pt_ticket_expire } 까지 /${list.pt_ticket_amount }회">
        	<a href="/trainer/select?trainer_no=${list.trainer.trainer_no }">
        		<button class="btn btn-primary">트레이너 프로필</button>
        	</a>
    	</div>
      </c:forEach>
  </div>

	<div class="form-group row">
    <label class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <a href="#"><button class="btn btn-primary">회원 탈퇴</button></a>
    </div>
  </div>

</form>

</div>

</div>
</div>
<br>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>