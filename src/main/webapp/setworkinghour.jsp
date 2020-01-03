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
<div class= "col-3">
<h3>사이드바</h3>
<ul>
 <li><a>운영시간</a></li>
 <li>매출정보</li>
 <li>트레이너등록</li>
</ul>
</div><!-- COL-3 -->
<div class= "col-9">
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">날짜 선택</label>
    <input type="date" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">OPEN</label>
    <input type="time" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="form-group">
  	<label for="exampleInputPassword1">CLOSE</label>
    <input type="time" class="form-control" id="exampleCheck1">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div><!-- COL-9 -->
</div>
</div>



<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>