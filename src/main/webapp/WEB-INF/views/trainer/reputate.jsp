<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<br>
<div class="container">

<h1>트레이너 평점</h1>
<hr>

<form action="/trainer/reputate" method="post">
<div class="form-group">
<input type="hidden" name="trainer_no" id="trainer_no" required="required" value="${trainer.trainer_no }" /><br>
<label>트레이너에게 줄 점수를 입력하세요</label>&nbsp;
<select class="custom-select" name="trainer_reputation_score" id="trainer_reputation_score" required="required" >
    <option value="1">★</option>
    <option value="2">★★</option>
    <option value="3">★★★</option>
    <option value="4">★★★★</option>
    <option value="5">★★★★★</option>
</select>
<br>
<br>
<label>이유를 작성해주세요</label>
<textarea class="form-control" rows="10" name="trainer_reputation_msg" id="trainer_reputation_msg" required="required" ></textarea><br>
<button class="btn btn-primary">확인</button>
&nbsp;
</div>
</form>

<a href="/trainer/reputation?trainer_no=${trainer.trainer_no }"><button class="btn btn-primary">평점 조회</button></a>

</div>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>