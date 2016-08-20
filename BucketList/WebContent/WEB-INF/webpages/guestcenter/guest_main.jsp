<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>guest_main.jsp</h1>
<table>
<tr>
	<td>게시번호</td>
	<td>아이디</td>
	<td>제목</td>
	<td>파일</td>
	<td>게시날짜</td>
	<td>조회수</td>
</tr>
<c:forEach var="guestbrd" items="${guestbrd }">
	<tr>
		<td>${guestbrd.brdno }</td>
		<td>${guestbrd.brduserid }</td>
		<td>${guestbrd.brdsubject }</td>
	<c:choose>
	<c:when test="${empty guestbrd.brdfilepath }">
		<td></td>
	</c:when>
	<c:otherwise>
		<td>yes</td>
		</c:otherwise>
		</c:choose>
		<td>${guestbrd.brdadddate }</td>
		<td>${guestbrd.brdcount }</td>
	</tr>
</c:forEach>
</table>