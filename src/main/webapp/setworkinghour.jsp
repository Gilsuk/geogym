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
</div>




<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>