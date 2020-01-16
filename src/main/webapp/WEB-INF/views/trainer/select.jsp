<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

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
          title : '평점',
          vAxis: {title: 'vAxis'},
          hAxis: {title: 'hAxis'},
          seriesType: 'bars'
                  };


		var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
        chart.draw(data, options);
			
		}
		
</script>

<div class = "container">
<br>

<div class="row">

<div class="col-2"></div>

<div class="col-8">

<h2>트레이너 정보</h2>
<hr>

<form>
  <div class="form-group row">
    <label class="col-3">트레이너 번호</label>
    <div class="col-9">
      <input type="text" readonly class="form-control-plaintext" value="${trainer.trainer_no }">
    </div>
  </div>
  <div class="form-group row">
    <label for="staticEmail" class="col-3 col-form-label">주소</label>
    <div class="col-9">
      <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${trainer.trainer_address }">
    </div>
  </div>
  <div class="form-group row">
    <label for="staticEmail" class="col-3 col-form-label">pt 값</label>
    <div class="col-9">
      <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${trainer.trainer_price }">
    </div>
  </div>
  <div class="form-group row">
    <label for="staticEmail" class="col-3 col-form-label">프로필</label>
    <div class="col-9">
      <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${trainer.trainer_profile }">
    </div>
  </div>
</form>
<div id=chart_div style="width: 900px; height: 500px;"></div>

<a href="/trainer/reputate?trainer_no=${trainer.trainer_no }"><button class="btn btn-primary">이 트레이너 평가하기</button></a>
&nbsp;
<a href="/calendar/PT/request?trainer_no=${trainer.trainer_no }"><button class="btn btn-primary">이 트레이너 시간표 보기</button></a>

<br><br>
<h5>PT 정기권 구매하기</h5>
<hr>
<form action="/issue/ptticket" method="post">
	<input type="hidden" name="trainer_no" value="${trainer.trainer_no }"/>
	<input type="hidden" name="price" value="${trainer.trainer_price }"/>
	<select name="pt_ticket_amount">
		<option value="5">5회 : ${trainer.trainer_price*5*0.9 }</option>
		<option value="10">10회 : ${trainer.trainer_price*10*0.8 }</option>
		<option value="15">15회 : ${trainer.trainer_price*15*0.7 }</option>
	</select>
	<button class="btn btn-primary">구매하기</button>
</form>

</div>

<div class="col-2"></div>

</div>
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>