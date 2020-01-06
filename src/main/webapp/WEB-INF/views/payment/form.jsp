<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

<!-- iamport pay-module -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- GEOGYM-iamport scrpt -->
<script type="text/javascript" src="/resources/js/iamport.js"></script>

<div class="container">
<form class="text-center border border-light p-5">

    <p class="h4 mb-4" id="pay-name">GEOGYM 캐시 충전</p>
    <input type="text" hidden="hidden" id="user-name" value="${user.user_name }" />
    <input type="email" hidden="hidden" id="user-email" value="${user.user_email }" />
    <input type="tel" hidden="hidden" id="user-tel" value="${user.user_tel }" />
    <input type="text" hidden="hidden" id="site-domain" value="${domain_url }" />

    <div class="form-group">
    	<label for="payamount">결제 금액</label>
    	<input type="number" class="form-control" id="pay-amount" min="100" value="100" step="100"/>
  	</div>
		
    <p class="h6 mt-4">결제 수단</p>
	<div class="custom-control custom-radio custom-control-inline">
		<input class="custom-control-input" type="radio" id="card" name="paymethod" value="html5_inicis" checked="checked">
		<label class="custom-control-label" for="card">신용카드</label>
	</div>
	<div class="custom-control custom-radio custom-control-inline">
		<input class="custom-control-input" type="radio" id="trans" name="paymethod" value="html5_inicis">
		<label class="custom-control-label" for="trans">실시간 계좌이체</label>
	</div>
	<div class="custom-control custom-radio custom-control-inline">
		<input class="custom-control-input" type="radio" id="vbank" name="paymethod" value="html5_inicis">
		<label class="custom-control-label" for="vbank">가상계좌</label>
	</div>
	<div class="custom-control custom-radio custom-control-inline">
		<input class="custom-control-input" type="radio" id="phone" name="paymethod" value="html5_inicis">
		<label class="custom-control-label" for="phone">휴대폰 결제</label>
	</div>
	<div class="custom-control custom-radio custom-control-inline">
		<input class="custom-control-input" type="radio" id="kakaopay" name="paymethod" value="kakaopay">
		<label class="custom-control-label" for="kakaopay">카카오페이</label>
	</div>
	
    <p class="h6 mt-4"></p>
	<div class="custom-control custom-checkbox">
  		<input type="checkbox" class="custom-control-input" id="agree">
  		<label class="custom-control-label" for="agree">결제 내역을 확인하고 이용약관에 동의합니다.</label>
	</div>
	
	<br>
	<button type="button" id="btn-payment" class="btn btn-primary btn-block">결제</button>
</form>
</div>

<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>