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


function drawBackgroundColor() {
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
        height: 200
        
        colors: ['red', 'blue', 'green', 'black']
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);

    }
    
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawBackgroundColor);
</script>

</head>
<body>

<h1>body info</h1>

<button id="inputBodyInfo">데이터입력</button>

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
</table>

  <div id="chart_div"></div>

</body>
</html>