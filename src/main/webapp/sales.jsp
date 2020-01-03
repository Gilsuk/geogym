<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
<br>

<from>
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
      <th scope="col">누적 PT 회원권 횟수</th>
      <th scope="col">누적 PT 매출액</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>3</td>
      <td>300000</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
</div>


<button type="submit" class="btn btn-primary">Submit</button>
</div><!-- COL-9 -->
</div>
</div>
</from>

<br>

<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>