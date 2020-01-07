<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <c:forEach var="clist" items="${clist }">
    <tr>
      <th scope="row"></th>
      <td>${clist.user_name }</td>
      <td>${clist.count_pt }</td>
    </tr>
    
   </c:forEach>