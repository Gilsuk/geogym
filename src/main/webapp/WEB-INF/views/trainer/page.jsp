<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<div class="container">
<div class="row">
<div class="col-12">
<br>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" href="/mypage/main">마이 페이지</a>
  </li>
  <c:if test="${isTrainer }">
	  <li class="nav-item">
	    <a class="nav-link active" href="/trainer/page">트레이너 페이지</a>
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
		<a class="list-group-item list-group-item-action active"
			href="/trainer/page">내 정보</a> 
			<a class="list-group-item list-group-item-action"
			href="/calendar/schedule?trainer_no=${trainer.trainer_no }">PT</a>
			<a	class="list-group-item list-group-item-action"
			href="/calendar/memolist?user_no=${user.user_no }">근무</a> 
			<a class="list-group-item list-group-item-action" 
			href="/info/bodyinfo_user">바디 인포</a> 
	</div>
</div>

<div class="col-2">

이름 : <br>
성별 : <br>
생년월일 : <br>
연락처 : <br>
ID : <br>
email : <br>
<br>
이용권 : <br>
<br>

PT 정기권 : <br>

<br>
캐시 : <br>

</div>

<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
${user.user_name }<br>
${user.user_gender }<br>
${user.user_birth }<br>
${user.user_tel }<br>
${user.user_id }<br>
${user.user_email }<br>
<br>
${ticket.ticket_active_date }(${ticket.ticket_duration } 일)<br>
<br>
<c:forEach items="${list }" var="list">
	"${list.trainer_name }" 트레이너 : ${list.pt_ticket_expire } 까지 /${list.pt_ticket_amount }회<br>
</c:forEach>
<br>
${cash }<br>

</div>
<div class="col-4">
<div id="profileDiv" class="col-12" id="profile" style="background-color:white; border:2px solid gray; width:180px;height:160px;padding-right: 0px;padding-left: 0px" >
	<div class="thumbnail">
	<img src="/upload/${trainer.attachment.attachment_stored_name }"
			alt="${trainer.attachment.attachment_origin_name }" />
	</div>
</div>
<div class="row">	
<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
주소 : <br>
값 : <br>
</div>

<div class="col-sm-8 col-md-8 col-lg-8 col-xl-8">
${trainer.trainer_address }<br>
${trainer.trainer_price }<br>
<br>

</div>
</div>
<a href="/trainer/update"><button>내 트레이너 정보 수정하기</button></a>
</div>


</div>
</div>
<br>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>