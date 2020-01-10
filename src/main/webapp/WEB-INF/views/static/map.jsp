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
	width: 1100px;
	height : 600px;
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

<div id="jb-container">

	<div id="map"  ></div>



	   <script>
	   //구글맵
	   

	   
	   function initMap() {
			
		   var uluru = {lat : 40.7768188, lng : -73.9630839 };

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




	

	<div style="clear: both;"></div>
</div>
<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>