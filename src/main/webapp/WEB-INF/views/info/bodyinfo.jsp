<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->

<jsp:include page="/WEB-INF/views/layouts/header.jsp" />

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
//키 정보 슬라이드토글
$(document).ready(function(){
	$('#heightInfo').click(function() {
		$('#chart_div_height').slideToggle("slow");
	});
});
</script>
<script type="text/javascript">

	$(document).on('click','#inputBodyInfo', function(){
			
		var popupX = (window.screen.width / 2) - (400 / 2);
		// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height /2) - (580 / 2);
		// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
		
		
			window.name="inputBodyinfo.do";
			
			window.open('http://localhost:8090/info/inputBodyInfo', 'window', 'status=no, height=580, width=400, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
			
		
	
// 		self.close();
	});
	
</script>

<script type="text/javascript">

	$(document).on('click','#uploadinbody', function(){

		var popupX = (window.screen.width / 2) - (400 / 2);
		// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height /2) - (580 / 2);
		// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
		
		window.name="uploadinbody.do";
		
		window.open('http://localhost:8090/info/uploadinbody?bodyinfo_no=${bodyInfo.bodyinfo_no}', 'window', 'status=no, height=580, width=400, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	
		window.close();
	});
	
</script>

<script type="text/javascript">

	$(document).on('click','#inbody', function(){

		var popupX = (window.screen.width / 2) - (1200 / 2);
		// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

		var popupY= (window.screen.height /2) - (1200 / 2);
		// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

		window.open('http://localhost:8090/info/inbody?bodyinfo_no=${bodyInfo.bodyinfo_no}', 'window', 'status=no, height=1200, width=1200, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	
		self.close();
	});
	
</script>

<script type="text/javascript">
$(document).ready( function(){
    $("#deleteInfo").click( function() {
        if(confirm("정말 삭제하시겠습니까? 가장 최근에 입력한 데이터가 삭제됩니다.")) {
			alert("삭제가 완료되었습니다.")	            
			location.href="/info/delete?bodyinfo_no=${bodyInfo.bodyinfo_no}"
        } else {
        	alert("삭제를 취소하셨습니다.")
            return false;
        }
    });
});

// function deleteInfo(){
	
// 	  /* confirm(문자열, 초기값) */
// 	  var check = confirm("정말 삭제하시겠습니까? 가장 최근에 입력한 데이터가 삭제됩니다.");
// 	  /* if(check == true) else false */
// 	  if(check) alert("삭제가 완료되었습니다.");
// 	  else alert("삭제를 취소하셨습니다.");
// 	}
</script>


<script type="text/javascript">
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawLineColors);

console.log(${weightInfo});
function drawLineColors() {
      var data = new google.visualization.DataTable();
      data.addColumn('date', '측정일');
      data.addColumn('number', '키');

	
      data.addRows(
        ${heightInfo}
      );

      var options = {
        hAxis: {
          title: '측정일'
        },
        vAxis: {
          title: '단위: cm'
        },
        width: $("#chartDiv").width(),
        height: 230
        
      };
      
      var option = {
    	colors: ['#9F81F7']
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div_height'));
      chart.draw(data, options);

    }
</script>

<script type="text/javascript">
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawLineColors);

console.log(${weightInfo});
function drawLineColors() {
      var data = new google.visualization.DataTable();
      data.addColumn('date', '측정일');
      data.addColumn('number', '몸무게');

	
      data.addRows(
        ${weightInfo}
      );

      var options = {
        hAxis: {
          title: '측정일'
        },
        vAxis: {
          title: '단위: kg'
        },
        width: $("#chartDiv").width(),
        height: 230
        
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div_weight'));
      chart.draw(data, options);

    }
</script>
<script type="text/javascript">
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawLineColors);

console.log(${list});
function drawLineColors() {
      var data = new google.visualization.DataTable();
      data.addColumn('date', '측정일');
      data.addColumn('number', '골격근');
      data.addColumn('number', '체지방');
	
      data.addRows(
        ${list}
      );

      var options = {
        hAxis: {
          title: '측정일'
        },
        vAxis: {
          title: '단위: kg'
        },
        width: $("#chartDiv").width(),
        height: 230
        
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div_etc'));
      chart.draw(data, options);

    }
</script>
<style type="text/css">
	#profileDiv{
		overflow: hidden;
		display: flex;
		align-items: center;
		justify-content: center;
 		width: 160px; 
 		height: 160px;		 
	}
	
	.profileimg{
		width: auto; height: auto;
    	max-width: 160px;
    	max-height: 160px;
	}
</style>


<!-- </head> -->
<!-- <body> -->

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
			<a class="list-group-item list-group-item-action" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:when>
		<c:when test="${pageName eq 'memo'}">
			<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action active" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:when>
		<c:otherwise>
			<a class="list-group-item list-group-item-action" href="/calendar/PT/schedule">내 PT 일정 보기</a>
			<a class="list-group-item list-group-item-action active" href="/calendar/memolist?user_no=${user.user_no }">트레이너 메모 보기</a>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${isTrainer }">
		<a class="list-group-item list-group-item-action" href="/info/bodyinfo">바디 인포</a>
	</c:if>
	<c:if test="${isTrainer ne true}">
		<a class="list-group-item list-group-item-action" href="/info/bodyinfo_user">바디 인포</a>
	</c:if>
	
	<a class="list-group-item list-group-item-action" href="/mypage/messagelist">메세지 확인</a>

</div>
</div>

<div class="col-sm-12 col-md-12 col-lg-9 col-xl-9">
<div class="row">
	<div class="col-5">
	<div class="row">
	<div id="profileDiv" id="profile" style="background-color:white; border:2px solid gray;" >
		<c:forEach items="${profile }" var="i">
		<img class="profileimg" src="/upload/${i.attachment_stored_name }"/>
		</c:forEach>
	</div>
	<div>
		<table class="table_userinfo">
			<tr>
				<th style="font-size:15px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원</th>
			</tr>
			<tr>
				<td style="text-align:right"><strong style="font-size:25px">${user.user_name }</strong> 님 (${user.user_gender })<br></td>
			<tr>
			<tr>
				<td style="height:10px"></td>
			</tr>
			<tr>
				<td><strong>&nbsp;생년월일</strong> : ${user.user_birth }</td>
			</tr>
			<tr>
				<td><strong>&nbsp;연락처</strong> : ${user.user_tel }</td>
			</tr>
			<tr>
				<td style="text-align:center">
				</td>
			</tr>
		</table>
	</div>
	</div>
	



<div>
	<table class="table_bodyinfo" style="text-align:center;width:325px">
		<tr>
			<th style="font-size:22px">키</th>
			<th style="font-size:22px">몸무게</th>
		</tr>
		<tr>
			<td>${bodyInfo.bodyinfo_height }cm</td>
			<td>${bodyInfo.bodyinfo_weight }kg</td>
		</tr>

		<tr>
			<th style="font-size:22px">골격근량</th>
			<th style="font-size:22px">체지방량</th>
		</tr>
		<tr>
			<td>${bodyInfo.bodyinfo_muscle }kg</td>
			<td>${bodyInfo.bodyinfo_fat }kg</td>
		</tr>
		<tr>
			<td>
				<button id="uploadinbody">인바디첨부하기</button>
			</td>
			<td>
				<button id="inbody">인바디 정보 보기</button>
			</td>
		</tr>		
	</table>
</div>

</div>


<div class="col-5">
	<fieldset style="width:300px">
		<legend>특이사항</legend>
		<textarea rows="9" cols="39" readonly="readonly" disabled>${bodycomment.body_comment_msg }</textarea>
		<fmt:parseDate value="${bodycomment.body_comment_date }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
		<small style="color:grey">마지막입력 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ parsedDateTime }" /></small>
	</fieldset><br>

	
</div>

</div>
<div class="col">
<br>
<div  id="chartDiv">
<div>
<form action="/info/bodyinfo" method="GET">
	<button id="btnSelect" class="btn btn-primary" style="float:right">조회</button>
	<select id="selectCondition" Style="float:right;height:38px;" name="select">
		<option value="week" selected="${select eq 'week' ? 'selected' : '' }">7일단위</option>
		<option value="month" selected="${select eq 'month' ? 'selected' : '' }">30일단위</option>
	</select>
</form>

	<button id="heightInfo" class="btn btn-primary" style="float:left">키 정보 보기</button>
</div>
  <div id="chart_div_height" style="display:none;float:right"></div>
  <div id="chart_div_weight" style="float:right"></div>
  <div id="chart_div_etc" style="float:right"></div>
  </div>
</div>
</div>

  <button id="inputBodyInfo" class="btn btn-primary">데이터입력</button>
	<button id="deleteInfo" onclick="deleteInfo();location.href='/info/delete?bodyinfo_no=${bodyInfo.bodyinfo_no}'" class="btn btn-primary" >데이터삭제</button>
</div>
</div>
<br>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>











<!-- <div class="container"> -->
<!-- <br> -->
<!-- <br> -->
<!-- <div class="row"> -->
<!-- <div class="col-4;"> -->
<!-- <div class="row"> -->

<!-- <div class="col-7" > -->

<!-- </div> -->
<!-- </div> -->
<!-- <br> -->
<!-- <br> -->






<!-- <br> -->
<!-- </div> -->
<!-- 	<br> -->


<!--  </div> -->
<!--  </div> -->
<!-- </body> -->
<!-- </html> -->

