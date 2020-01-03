<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% List<Board> bList = (List)request.getAttribute("list"); %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>

<div class = "container">

<div class="row">
<form action="/board/write" method="post" enctype = "multipart/form-data">
   <table class="table table-bordered">
            <thead>
               <tr>
                  <th colspan="2"
                     style="background-color: #eeeeee; text-align: center;">글쓰기</th>
               </tr>
            </thead>
            <tr>
<td class="info">제목</td><td colspan="3">
<input type="text" placeholder="title" id="title"
                  name="title" /></td>

<tr>
<td class="info">작성자 </td><td colspan="3">${writer}</td>
</tr>


<tr><td class="info"  colspan="4">내용</td></tr>

<tr><td colspan="4"><textarea name="content" id="content" rows="10" cols="80">
            </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'content' );
            </script></td></tr>

<tr>
<td class="info">첨부파일</td><td colspan="3"><input type = "file" name = "upfile"/></td>
</tr>

</table>
<div class="text-center">   
   <button id="btnWrite" class="btn btn-primary">글쓰기</button>
   <button id="btnCancel" class="btn btn-danger">취소</button>
</div>
</form>
</div>





</div>





<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>