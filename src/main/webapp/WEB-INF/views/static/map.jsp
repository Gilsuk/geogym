<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>

<script
	src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
	
</script>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCphNLUHRtOMojdg0FPMyj2F0xEkYHeyMo&callback=initMap">
	
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			type : "get",
			url : "/crawling",
			data : {},
			dataType : "html",
			success : function(data) {
				console.log("success")
// 				console.log(data)
				$("#newsTable").html(data)
			},
			error : function() {
				console.log("error")
			}
		});
	});
</script>

<style type="text/css">
#jb-container {
	width: 1200px;
	margin: 5px auto;
	padding: 20px;
	border: 0px solid #bcbcbc;
}

#map {
	width: 650px;
	height : 500px;
	padding: 20px;
    margin: auto auto 30px auto;
	border: 1px solid #bcbcbc;
}

#jb-sidebar {
    width: 1102px;
    height: 245px;
    padding: 20px;
    margin-bottom: 20px;
    margin-left: 28px; 
    /* float: right; */
    border: 0px solid #bcbcbc;
}

#servicecenter {
	clear: both;
	padding: 20px;
	border: 0px solid #bcbcbc;
}

#searchbar{
	width : 20%;
	height : auto;
	float: left;
}

#newsbar{
	border: 1.5px solid black;
	float : right;
	width: 79%;
	height: 200px;
	overflow: auto;
	border: 1px solid #bcbcbc;

}
#board {
	clear: both;
	padding: 20px;
	border: 0px solid #bcbcbc;
}

#miniboard {
	overflow:hidden;
	width:240px;
	white-space:nowrap;
	text-overflow:ellipsis;
}

table {
 	table-layout: fixed;
}

#td1 {
	overflow:hidden;
	white-space:nowrap;
	text-overflow:ellipsis;
	
	width:25px;
}
.articleList{
	margin-left: 5px;
	width: 780px !important;
}
body{
	background-color: #F8F8F8;
}
</style>


	



	   <script>
	   //구글맵
	   

	   
	   function initMap() {
			
		   var uluru = {lat : 36.1609847, lng : -115.1541048 };

		   var map = new google.maps.Map(document.getElementById('map'), {
		     zoom: 15,
		     center: uluru
		   });
			
		   
		   
		   var marker = new google.maps.Marker({
			   position: uluru,
			   map: map
			 });

			}; // map 종료

    </script>

<div class="container">
<div class="row">
<div class="col-12">
<br>
<h1>소개</h1>
<hr>
</div>

	
	
<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
	<div class="list-group">
		<a class="list-group-item list-group-item-action active disabled" aria-disabled="true" href="/static/map">오시는길</a>
		<a class="list-group-item list-group-item-action" href="/admin/pay">시설소개</a>
		
		
	</div>
</div>
	
	
	
<div class= "col-9">
<div class="container">
	
<!-- 	<div id="jb-container"> -->

	<div id="map"  >
	</div>
	<div>
	<h2>※오시는방법※</h2>
	<h6>인천공항 -> 매캐런국제공항 -> EB Bonneville after 1st -> 도보로 이동 -> 353 E Bonneville Ave UNIT 183</h6>
	<br>
	
	</div>
<!-- 	</div> -->
	
</div>
</div>

	
</div>
</div>

	

<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>