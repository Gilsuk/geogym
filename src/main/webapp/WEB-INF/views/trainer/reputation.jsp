<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
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

</head>
<body>
<h1>reputation 55</h1>

 <div id="chart_div" style="width: 900px; height: 500px;"></div>
</body>
</html>