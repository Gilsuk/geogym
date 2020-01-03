<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
<br>

<script type="text/javascript">
$(document).ready(function(){
	









})

	$(document).ready(function() {

// 		if (typeof ajaxFunction !== 'undefined') return;

// 		$(".btn-ajax").on("click", ajaxFunction);

// 		$.each($(".btn-ajax").closest("form"), function(index, form) {
// 			ajaxAction = $(form).attr("action");
// 		});

		$("#btn-search-user").on("click", function() {
			$.ajax({
				url: "/ajax/user/searchbyid", 
				data: {
					user_id: $("#user_id").val()
				},
				method: "POST", 
				dataType: "json"
			}).done(function(data) {
				$("#user_name").val(data.user_name);
				$("#user_gender").val(data.user_gender);
				$("#user_birth").val(birth.year + "-" + birth.monthValue + "-" + birth.dayOfMonth);
				$("#user_email").val(data.user_email);
				
			})

			return false;
		})

	});

</script>

<div class="container">
<div class="row">
<div class= "col-3">
<h3>사이드바</h3>
<ul>
 <li><a href="/user/login">운영시간</a></li>
 <li>매출정보</li>
 <li>트레이너등록</li>
</ul>
</div><!-- COL-3 -->
<div class= "col-9">
<div class="container">





  <div class="form-group">
    <label for="formGroupExampleInput">아이디 검색</label>
    <input type="text" class="form-control" id="user_id" name = "user_id">
  </div>
  <button id="btn-search-user" type="submit" class="btn btn-primary">검색</button>


 <form action= "/trainer/insert" method="post">
<!-- 검색시 결과값 도출 -->
<div class="form-group">
    <label for="formGroupExampleInput">이름</label>
    
    <input type="text" class="form-control" id="user_name" name = "user_name" disabled>
    
   
</div>
  
 <div class="form-group">
   <label for="formGroupExampleInput">성별</label>
   <input type="text" class="form-control" id="user_gender" name = "user_gender" disabled>
</div>
  
<div class="form-group">
    <label for="formGroupExampleInput">생년월일</label>
    <input type="text" class="form-control" id="user_birth" name = "user_birth" disabled>
</div>

<div class="form-group">
    <label for="formGroupExampleInput">email</label>
    <input type="text" class="form-control" id="user_email" name = "user_email" disabled>
</div>



<hr>
<hr>

  <div class="form-group">
    <label for="formGroupExampleInput">주소</label>
    <input type="text" class="form-control" id="formGroupExampleInput" name = "trainer_address">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">가격</label>
    <input type="text" class="form-control" id="formGroupExampleInput" name ="trainer_price">
  </div>
  <div class="input-group">
  <div class="input-group-prepend">
    <span class="input-group-text">프로필</span>
  </div>
  <textarea class="form-control" aria-label="With textarea" name ="trainer_profile"></textarea>
</div>
<button type="submit" class="btn btn-primary">등록</button>
</form>

</div>


</div><!-- COL-9 -->
</div>
</div>






<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>