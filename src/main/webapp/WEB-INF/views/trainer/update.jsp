<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<h1>insert trainer </h1>


<form action="/trainer/update" method="post" enctype="multipart/form-data">
<label>setTrainer_address :</label> <input type="text" name="trainer_address" id="trainer_address" required="required" value="${trainer.trainer_address }"/><br>
<label>setTrainer_price :</label> <input type="number" name="trainer_price" id="trainer_price" required="required" value="${trainer.trainer_price }"/><br>
<label>setTrainer_profile :</label> <textarea rows="" cols="" name="trainer_profile" id="trainer_profile" required="required">${trainer.trainer_profile }</textarea><br>
<label>file :</label> <input type="file" name="file" id="file" required="required" /><br>
<button>확인</button>
</form>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
