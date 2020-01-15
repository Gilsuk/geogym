<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
#mypage_info{
	height: 40px;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: stretch;
	min-height : 100px;
	margin-right: 730px;
	font-family: 'NIXGONB-Vb';
}

.container {
	width : 1400px;
    display: block;
    text-align: center;
	justify-content: center;
	align-items: stretch;
	
}

#photo{
	width: 20%;
    float : left;
}
#info_name{
	width: 80%;
 	float : right;
	height: 50px;
    color: #1C5B8C;
    font-family: dotum;
    line-height: 150%;
    text-align: left;
}
#info_nick{
	width: 80%;
	float : right;	
	height: 50px;
    color: #1C5B8C;
    font-family: dotum;
    line-height: 150%;
    text-align: left;    
}
#info_info{
	width: 80%;
	float : right;
	height: 50px;
    color: #1C5B8C;
    font-family: dotum;
    line-height: 150%;
    text-align: left;
}
</style>

<div class = "container">
<div id = "mypage_info" >
	<h2  style="font-family: 'NIXGONB-Vb';">트레이너 정보</h2>
</div>

<%-- <div id = "photo" style = "height:200px;width:140px:">
	<img src = "" alt = "사진을 등록해 주세요." width="98" height="98">

</div>--%>
<div id = "info_no"> 
	<label style="font-family: 'NIXGONB-Vb';font-size: 20px;color: black">트레이너 번호</label>&nbsp;&nbsp;&nbsp;
	<label style="font-family: 'NIXGONB-Vb';font-size: 20px;color: black"><strong>${trainer.trainer_no }</strong></label>

</div>
<br>
<div id = "info_address">
	<label style="font-family: 'NIXGONB-Vb';font-size: 20px;color: black"> 주소  </label>&nbsp;&nbsp;&nbsp;
	<label style="font-family: 'NIXGONB-Vb';font-size: 20px;color: black"><strong>${trainer.trainer_address }</strong> </label>
</div>
<br>
<div id = "info_price">
	<label style="font-family: 'NIXGONB-Vb';font-size: 20px;color: black"> pt 값  </label>&nbsp;&nbsp;&nbsp;
	<label style="font-family: 'NIXGONB-Vb';font-size: 20px;color: black"><strong>${trainer.trainer_price }</strong> </label>
</div>
<br>
<div id = "info_profile">
	<label style="font-family: 'NIXGONB-Vb';font-size: 20px;color: black"> 프로필  </label>&nbsp;&nbsp;&nbsp;
	<label style="font-family: 'NIXGONB-Vb';font-size: 20px;color: black"><strong>${trainer.trainer_profile }</strong> </label>
</div>
<br>
<br>
<a href="/trainer/reputate?trainer_no=${trainer.trainer_no }"><button>이 트레이너 평가하기</button></a>
<a href="/calendar/PT/request?trainer_no=${trainer.trainer_no }"><button>이 트레이너 시간표 보기</button></a>

<div id = "info_info"><span  style="font-family: 'NIXGONB-Vb';font-size: 15px;color: #bcbcbc"></span></div>
</div>
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>