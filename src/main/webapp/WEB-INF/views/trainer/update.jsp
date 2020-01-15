<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<br>
<div class="container">

<h1>트레이너 정보 수정</h1>
<hr>

<form action="/trainer/update" method="post" enctype="multipart/form-data">

<input type="hidden" name="trainer_no" value="${trainer.trainer_no }">

<div class="form-group row">
    <label class="col-3">트레이너 주소</label>
    <div class="col-9">
      <input type="text" class="form-control-plaintext" value="${trainer.trainer_address }">
    </div>
 </div>
<div class="form-group row">
    <label class="col-3">트레이너 PT 가격</label>
    <div class="col-9">
      <input type="text" class="form-control-plaintext" value="${trainer.trainer_price }">
    </div>
 </div>
<div class="form-group row">
    <label class="col-3">프로필</label>
    <div class="col-9">
      <textarea class="form-control" rows="10" >${trainer.trainer_profile }</textarea>
    </div>
</div>

<div class="input-group mb-3">
<div class="input-group-prepend">
    <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
  </div>
  <div class="custom-file">
    <input type="file" class="custom-file-input" name="file" id="file" aria-describedby="inputGroupFileAddon01">
    <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
</div>
</div>
<button class="btn btn-primary">확인</button>
</form>

</div>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
