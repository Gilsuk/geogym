<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% List<Board> bList = (List)request.getAttribute("list"); %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>






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
	<a class="list-group-item list-group-item-action" href="/admin/insertWorkHour">트레이너 근무시간 등록</a>
</div>
</div>


<div class= "col-9">
<form action = "/test/setbusinessday" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">날짜 선택</label>
    <input type="date" class="form-control" name="business_day_date" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">OPEN</label>
    <input type="time" class="form-control" name="business_day_starttime">
  </div>
  <div class="form-group">
  	<label for="exampleInputPassword1">CLOSE</label>
    <input type="time" class="form-control" name="business_day_endtime">
  </div>
  <button type="submit" class="btn btn-primary">전송</button>
</form>
	<br>
	<form action="/calendar/set" method ="post">
		
		<button class="btn btn-primary">공휴일 등록</button>		
	</form>
</div><!-- COL-9 -->
</div>
</div>



<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>