<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script src="//cdn.ckeditor.com/4.13.1/standard/ckeditor.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#title").focus();

	$("#cancel").click(function() {
		history.back(-1);
	});
});
</script>

<style type="text/css">
</style>

<div class="container">

<h1>글쓰기 페이지</h1>
<hr>

<form action="/qna/write" method="post">
<!-- 	<div class="form-group"> -->
<!-- 		<label for="writer">작성자</label> -->
<%-- 		<input type="text" id="writer" value="${nick }" readonly="readonly" class="form-control"/> --%>
<!-- 	</div> -->
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" id="title" name="qna_title" class="form-control" />
	</div>
	<div class="form-group">
		<label for="content">본문</label>
		<textarea rows="10" style="width:100%" id="qna_content" name="qna_content"></textarea>
		<script>
	        CKEDITOR.replace( 'qna_content' );
       	</script>
	</div>
	
	<div class="form-group">
		<label for="isPrivate">공개여부</label>
		<input type="checkbox" name="qna_isprivate" checked="checked">
	</div>

	<div class="text-center">
		<button class="btn btn-primary" id="btnWrite">작성</button>
		<input type="reset" id="cancel"	class="btn btn-danger" value="취소"/>
	</div>
</form>

</div><!-- .container -->

