<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<script type="text/javascript">

	$(document).ready(function() {
		setTimeout(function() {
		    window.location.href = '/';
		}, 1500);
	})

</script>

<div class="container">
	<h2>결제</h2>
	<hr>
	<p>성공적</p>
</div>
    
<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>