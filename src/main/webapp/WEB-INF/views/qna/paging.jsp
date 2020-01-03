<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">

		<%-- 처음 페이지 버튼 --%>
		<%-- 첫 페이지가 아닐 때 버튼 노출 --%>
		<c:if test="${paging.curPage ne 1 }">
			<li class="page-item"><a class="page-link" 
			href="/qna/list?search=${paging.search }&categoryNo=${paging.categoryNo}" aria-label="Previous"> 
			<span aria-hidden="true">&larr;</span></a></li>
		</c:if>





		<%-- 이전 페이지 버튼 --%>
		<%-- 첫 페이지면 금지 표시 --%>
		<c:if test="${paging.curPage ne 1 }">
			<li class="page-item"><a class="page-link" 
			href="/qna/list?curPage=${paging.curPage-1 }&search=${paging.search }&categoryNo=${paging.categoryNo}" 
			aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
		</c:if>
		<c:if test="${paging.curPage eq 1 }">
			<li class="page-item disabled"><span aria-hidden="true">&laquo;</span></li>
		</c:if>





		<%-- 페이징 번호 표시 --%>
		<%-- 현재 페이지 번호는 active 클래스 부여 -> 파랑 바탕 버튼 --%>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="page">
			<c:if test="${paging.curPage eq page }">
				<li class="active page-item"><a class="page-link" 
				href="/qna/list?curPage=${page }&search=${paging.search }&categoryNo=${paging.categoryNo}" aria-label="Previous">
				${page }</a></li>
			</c:if>
			<c:if test="${paging.curPage ne page }">
				<li class="page-item"><a class="page-link" 
				href="/qna/list?curPage=${page }&search=${paging.search }&categoryNo=${paging.categoryNo}" aria-label="Previous">
				${page }</a></li>
			</c:if>
		</c:forEach>





		<%-- 다음 페이지 버튼 --%>
		<%-- 마지막 페이지면 동작 안함 --%>
		<c:if test="${paging.curPage ne paging.totalPage }">
			<li class="page-item"><a class="page-link" 
			href="/qna/list?curPage=${paging.curPage+1 }&search=${paging.search }&categoryNo=${paging.categoryNo}" 
			aria-label="Previous Next"> <span aria-hidden="true">&raquo;</span></a></li>
		</c:if>
		<c:if test="${paging.curPage eq paging.totalPage }">
			<li class="page-item disabled"><span aria-hidden="true">&raquo;</span></li>
		</c:if>
	</ul>
</nav>