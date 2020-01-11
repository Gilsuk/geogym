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


<!-- </head> -->
<!-- <body> -->








<style type="text/css">
	#profileDiv{
		overflow: hidden;
		display: flex;
		align-items: center;
		justify-content: center;
		width: 100%;
		height: 100%;		
	}
	
	.profileimg{
		width: auto; height: auto;
    	max-width: 180px;
    	max-height: 160px;
	}
</style>





<div class="container">
<br>
<br>
<div class="row">
<div class="col-4;">
<div class="row">
<div id="profileDiv" class="col-5" id="profile" style="background-color:white; border:2px solid gray;width:180px;height:160px;padding-right: 0px;padding-left: 0px" >
	<c:forEach items="${profile }" var="i">
	<img class="profileimg" src="/upload/${i.attachment_stored_name }"/>
	</c:forEach>
</div>	
<div class="col-7" >
<table>
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
<!-- 			<button id="uploadProfile">프로필사진수정</button> -->
<%-- 			<form action="/info/fileUpload?bodyinfo_no=${bodyInfo.bodyinfo_no }" method="GET"> --%>
<!-- 				<label for="uploadProfile" style="cursor:pointer">프로필사진수정</label> -->
<!-- 				<input type="file" id="uploadProfile" style="display:none"/> -->
<!-- 			</form> -->
			
<!-- 		<form action="/info/fileUpload" method="POST"><input type="file" id="selectedFile" style="display: none;" /> -->
<!-- 		<input class="btn btn-primary" type="submit" value="프로필사진등록" onclick="document.getElementById('selectedFile').click();" /> -->
<%-- 		<input type="hidden" name="bodyinfo_no" value="${bodyInfo.bodyinfo_no }" /></form> --%>
		</td>
	</tr>
</table>
</div>
</div>
<br>
<br>


	<table style="text-align:center;width:325px">
		<tr>
			<td colspan="2">
				<button id="uploadinbody">인바디첨부하기</button>
				<button id="inbody">인바디 정보 보기</button>
			<td></td>
		</tr>
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

	</table><br>

<fieldset style="width:300px">
<legend>특이사항</legend>
<textarea rows="10" cols="45" readonly="readonly" disabled>${bodycomment.body_comment_msg }</textarea>
<fmt:parseDate value="${bodycomment.body_comment_date }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
<small style="color:grey">마지막입력 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ parsedDateTime }" /></small>
</fieldset><br>
<button id="inputBodyInfo" class="btn btn-primary" style="margin-left: 60px">데이터입력</button>
<button id="deleteInfo" onclick="deleteInfo();location.href='/info/delete?bodyinfo_no=${bodyInfo.bodyinfo_no}'" class="btn btn-primary" >데이터삭제</button>
<br>
</div>
	<br>

<div class="col-8" id="chartDiv">
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
<!-- </body> -->
<!-- </html> -->

<jsp:include page="/WEB-INF/views/layouts/footer.jsp" />