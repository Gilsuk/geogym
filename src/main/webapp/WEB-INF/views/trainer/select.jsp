<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<style>
/* #mypage_info{ */
/* 	height: 40px; */
/* 	text-align: center; */
/* 	display: flex; */
/* 	justify-content: center; */
/* 	align-items: stretch; */
/* 	min-height : 100px; */
/* 	margin-right: 730px; */
/* 	font-family: 'NIXGONB-Vb'; */
/* } */

/* .container { */
/* 	width : 1400px; */
/*     display: block; */
/*     text-align: center; */
/* 	justify-content: center; */
/* 	align-items: stretch; */
	
/* } */

/* #photo{ */
/* 	width: 20%; */
/*     float : left; */
/* } */
/* #info_name{ */
/* 	width: 80%; */
/*  	float : right; */
/* 	height: 50px; */
/*     color: #1C5B8C; */
/*     font-family: dotum; */
/*     line-height: 150%; */
/*     text-align: left; */
/* } */
/* #info_nick{ */
/* 	width: 80%; */
/* 	float : right;	 */
/* 	height: 50px; */
/*     color: #1C5B8C; */
/*     font-family: dotum; */
/*     line-height: 150%; */
/*     text-align: left;     */
/* } */
/* #info_info{ */
/* 	width: 80%; */
/* 	float : right; */
/* 	height: 50px; */
/*     color: #1C5B8C; */
/*     font-family: dotum; */
/*     line-height: 150%; */
/*     text-align: left; */
/* } */
</style>

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

<a href="/trainer/reputate?trainer_no=${trainer.trainer_no }"><button class="btn btn-primary">이 트레이너 평가하기</button></a>
&nbsp;
<a href="/calendar/PT/request?trainer_no=${trainer.trainer_no }"><button class="btn btn-primary">이 트레이너 시간표 보기</button></a>

</div>

<div class="col-2"></div>

</div>

</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>