<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#btn-search-user").on("click", function() {
		$.ajax({
			url: "/ajax/trainer/searchbyid", 
			data: {
				user_id: $("#user_id").val()
			},
			method: "POST", 
			dataType: "json"
		}).done(function(data) {
			console.log($("#user_no").val(data.user_no));
			$("#user_no").val(data.user_no);
			$("#user_name").val(data.user_name);
			
		})

		return false;
	})
	
	
	
	
})

</script>





<br>
<div class="container">
<div class="row">
<div class="col-12">
<br>
<h1>관리자페이지</h1>
<hr>
</div>

<div class="col-sm-12 col-md-12 col-lg-3 col-xl-3">
<div class="list-group">
	
	<a class="list-group-item list-group-item-action active disabled" aria-disabled="true" href="/test/setbusinessday">운영시간</a>
	<a class="list-group-item list-group-item-action" href="/admin/pay">PT횟수정보</a>
	<a class="list-group-item list-group-item-action" href="/trainer/insert">트레이너등록</a>

</div>
</div>


<div class= "col-9">

  <div class="form-group">
    <label for="formGroupExampleInput">아이디 검색</label>
    <input type="text" class="form-control" id="user_id" name = "user_id">
  </div>
  <button id="btn-search-user" type="submit" class="btn btn-primary">검색</button>

	<div class="form-group">
    
    	<label for="formGroupExampleInput">이름</label>    
    	<input type="text" class="form-control" id="user_name" name = "user_name" disabled>

	</div>

<form action = "/admin/insertWorkHour" method="post">
	<div class="form-group">
<!-- 	    <label for="formGroupExampleInput">번호</label>     -->
    	<input type="hidden" class="form-control" id="user_no" name = "user_no" >

	</div>
	
	
	

  <div class="form-group">
    <label for="exampleInputEmail1">출석일 선택</label>
    <input type="date" class="form-control" name="attendance_date" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">시작시간</label>
    <input type="time" class="form-control" name="attendance_start">
  </div>
  <div class="form-group">
  	<label for="exampleInputPassword1">종료시간</label>
    <input type="time" class="form-control" name="attendance_end">
  </div>
  <button type="submit" class="btn btn-primary">전송</button>
</form>

</div><!-- COL-9 -->
</div>
</div>



<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>