<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<script type="text/javascript">
	google.charts.load('current', {'packages' : [ 'corechart' ]});
	google.charts.setOnLoadCallback(drawVisualization);
	
	function drawVisualization() {
	var data = google.visualization.arrayToDataTable([
          ['today',   'you', 'Average'],
          ['today',   ${reputation},      ${average}]
        ]);

        var options = {
          title : '타이틀',
          vAxis: {title: 'vAxis'},
          hAxis: {title: 'hAxis'},
          seriesType: 'bars'
                  };


		var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
			
		}
		
</script>

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
<div class="card col-4">
	<img class="profilePic" src="/upload/${trainer.attachment.attachment_stored_name }"
			alt="${trainer.attachment.attachment_origin_name }" />
<div class="card-body row">	

<div class="card-body">
	<h5 class="card-title">주소 : ${trainer.trainer_address }</h5>
	<p class="card-text">값 : ${trainer.trainer_price }</p>
</div>
<a href="/trainer/update"><button class="btn btn-primary">내 트레이너 정보 수정하기</button></a>
</div>

</div>
 <div id="chart_div" style="width: 900px; height: 500px;"></div>
</div>
<br>

</div>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>