<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

	$(document).on('click','#inputBodyInfo', function(){
		window.open('http://localhost:8090/info/inputBodyInfo','window','width=400, height=500');
		
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
$(document).ready(function() {

	$("#deleteInfo").click(function() {
		location.href="/info/delete?bodyInfo_no="+${bodyInfo.bodyinfo_no}.val();
	});
	
});
</script>

<script type="text/javascript">

google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawLineColors);

function drawLineColors() {
      var data = new google.visualization.DataTable();
      data.addColumn('date', '측정일');
      data.addColumn('number', '몸무게');
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
        height: 500
        
//         colors: ['#a52714', '#097138', '#8000FF']
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);

    }
    
// google.charts.load('current', {packages: ['corechart', 'line']});
// google.charts.setOnLoadCallback(drawBackgroundColor);
</script>


</head>
<body>

<h1>body info</h1>
>> ${user.user_name } 회원님
<br>

<button id="inputBodyInfo">데이터입력</button>
<button id="deleteInfo" onclick="deleteInfo();location.href='/info/delete?bodyinfo_no=${bodyInfo.bodyinfo_no}'" >데이터삭제</button>


	<table style="text-align:center">
		<tr>
			<th>키</th>
			<td>${bodyInfo.bodyinfo_height }</td>
		</tr>
		<tr>
			<th>몸무게</th>
			<td>${bodyInfo.bodyinfo_weight }</td>
		</tr>
		<tr>
			<th>골격근량</th>
			<td>${bodyInfo.bodyinfo_muscle }</td>
		</tr>
		<tr>
			<th>체지방량</th>
			<td>${bodyInfo.bodyinfo_fat }</td>
		</tr>
	</table><br>

<fieldset style="width:300px">
<legend>특이사항</legend>
<textarea rows="10" cols="40" readonly="readonly">${bodycomment.body_comment_msg }</textarea>
</fieldset><br>

	


<form action="/info/bodyinfo" method="GET">
	<select id="selectCondition" Style="float:left;height:24px;" name="select">
		<option value="week">7일단위</option>
		<option value="month">30일단위</option>
	</select>
	<button id="btnSelect" class="btn">조회</button>
</form>

  <div id="chart_div"></div>

</body>
</html>