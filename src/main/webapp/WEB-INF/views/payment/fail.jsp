<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<script type="text/javascript">

	$(document).ready(function() {
		setTimeout(function() {
		    window.location.href = '/payment/form';
		}, 2000);
	})

</script>

<div class="container">
	<h2>결제</h2>
	<hr>
	<c:if test="${not empty msg }">
	<p>${msg }</p>
	</c:if>
	<c:if test="${empty msg }">
	<p>무언가 잘못되어가고 있어요</p>
	</c:if>
</div>
    
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>