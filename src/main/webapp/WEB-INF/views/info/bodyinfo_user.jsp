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
// 	    var _width = '650';
// 	    var _height = '380';
	 
// 	    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
// 	    var _left = Math.ceil(( window.screen.width - _width )/2);
// 	    var _top = Math.ceil(( window.screen.width - _height )/2); 

		window.open('http://localhost:8090/info/inputBodyInfo','window','width=400, height=500');
		
		self.close();
	});
	
</script>
<script type="text/javascript">

	$(document).on('click','#uploadProfile', function(){
// 	    var _width = '650';
// 	    var _height = '380';
	 
// 	    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
// 	    var _left = Math.ceil(( window.screen.width - _width )/2);
// 	    var _top = Math.ceil(( window.screen.width - _height )/2); 

		window.open('http://localhost:8090/info/uploadProfile','window','width=400, height=500');
		
		self.close();
	});
	
</script>
<script type="text/javascript">

	$(document).on('click','#uploadBMI', function(){
// 	    var _width = '650';
// 	    var _height = '380';
	 
// 	    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
// 	    var _left = Math.ceil(( window.screen.width - _width )/2);
// 	    var _top = Math.ceil(( window.screen.width - _height )/2); 

		window.open('http://localhost:8090/info/uploadBMI?bodyinfo_no=${bodyInfo.bodyinfo_no}','window','width=400, height=500');
		
		self.close();
	});
	
</script>

<script type="text/javascript">
function deleteInfo(){
	
	  /* confirm(문자열, 초기값) */
	  var check = confirm("정말 삭제하시겠습니까? 가장 최근에 입력한 데이터가 삭제됩니다.");
	  /* if(check == true) else false */
	  if(check) alert("삭제가 완료되었습니다.");
	  else alert("삭제를 취소하셨습니다.");
	}
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
        width: 700,
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
        width: 700,
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
        width: 700,
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
</style>





<div class="container">
<br>
<br>
<div class="row">
<div class="col-4;">
<div class="row">
<div id="profileDiv" class="col-5" id="profile" style="background-color:white; border:2px solid gray;width:180px;height:160px;padding-right: 0px;padding-left: 0px" >
	<img src="/upload/주석 2020-01-03 105902.png"/>
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
		<td><strong>&nbsp;담당 tr</strong> : </td>
	</tr>
	<tr>
		<td><strong>&nbsp;연락처</strong> : </td>
	</tr>
	<tr>
		<td style="text-align:center">
			<button id="uploadProfile">프로필사진수정</button>
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
			<td colspan="2"><button id="uploadBMI">BMI사진첨부하기</button></td>
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
<legend>나의 PT 스케쥴</legend>
	<div style="border:2px solid grey;height: 235px">
	</div>
</fieldset><br>
<button id="inputBodyInfo" class="btn btn-primary" style="margin-left: 60px">데이터입력</button>
<button id="deleteInfo" onclick="deleteInfo();location.href='/info/delete?bodyinfo_no=${bodyInfo.bodyinfo_no}'" class="btn btn-primary" >데이터삭제</button>
<br>
</div>
	<br>

<div class="col-8">
<div>
<form action="/info/bodyinfo" method="GET">
	<button id="btnSelect" class="btn btn-primary" style="float:right">조회</button>
	<select id="selectCondition" Style="float:right;height:38px;" name="select">
		<option value="week">7일단위</option>
		<option value="month">30일단위</option>
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