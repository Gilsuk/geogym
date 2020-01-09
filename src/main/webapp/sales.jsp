<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
<br>

<form action = "/admin/pay" method = "get">
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
<div class="container">
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">트레이너</th>
      <th scope="col">PT 진행 횟수</th>
      <th scope="col">일일 PT 진행 횟수</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="list" items="${list }">
    <tr>
      <th scope="row">1</th>
      <td>${list.trainer_no }k</td>
      <td>3</td>
      <td>300000</td>
    </tr>
   </c:forEach>
  </tbody>
</table>
</div>



</div><!-- COL-9 -->
</div>
</div>
</form>

<br>

<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>