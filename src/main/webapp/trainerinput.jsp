<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container">




<form>
  <div class="form-group">
    <label for="formGroupExampleInput">이름</label>
    <input type="text" class="form-control" id="formGroupExampleInput">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">주소</label>
    <input type="text" class="form-control" id="formGroupExampleInput">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">가격</label>
    <input type="text" class="form-control" id="formGroupExampleInput">
  </div>
  <div class="input-group">
  <div class="input-group-prepend">
    <span class="input-group-text">프로필</span>
  </div>
  <textarea class="form-control" aria-label="With textarea"></textarea>
</div>
<button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>


</div><!-- COL-9 -->
</div>
</div>
</from>






<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>