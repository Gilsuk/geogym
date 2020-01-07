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

	$("#btn-search-month").on("click",function(){
		$.ajax({
			url:"/admin/pay",
			data:{
				year : $("#year").val(),
				mon : $("#mon").val()
			},
			method:"POST",
			dataType : "html"
		}).done(function(data){
			console.log(data);
			$("#listbody").html(data);
					
		})
		
		return false;
	})
	
	
	
	
});





</script>


<form >
<div class="container">
<div class="row">
<div class= "col-3">
<h3>사이드바</h3>
<ul>
<li><a href="/test/setbusinessday">운영시간</a></li>
<li><a href="/admin/pay">PT횟수정보</a></li>
<li><a href="/trainer/insert">트레이너등록</a></li>
</ul>
</div><!-- COL-3 -->
<div class= "col-9">
<div class="container">

        <div class="form-group">
    	<label for="exampleInputEmail1">년검색</label>
    	<select name="year" id ="year">
    		<option value = "2017-">2017</option>
    		<option value = "2018-">2018</option>
    		<option value = "2019-">2019</option>
    		<option value = "2020-" selected="selected">2020</option>
    		
    	</select>
    	
    	<label for="exampleInputEmail1">월검색</label>
    	<select name="mon" id = "mon">
    		<option value = "01">1</option>
    		<option value = "02">2</option>
    		<option value = "03">3</option>
    		<option value = "04">4</option>
    		<option value = "05">5</option>
    		<option value = "06">6</option>
    		<option value = "07">7</option>
    		<option value = "08">8</option>
    		<option value = "09">9</option>
    		<option value = "10">10</option>
    		<option value = "11">11</option>
    		<option value = "12">12</option>
    	</select>
    	<button type = "button" id = "btn-search-month" >검색</button>
  		</div>



<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">트레이너</th>
      <th scope="col">월단위PT 진행 횟수</th>
     
    </tr>
  </thead>
  <tbody id="listbody">

  </tbody>
</table>
</div>



</div><!-- COL-9 -->
</div>
</div>

</form>
<br>

<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>