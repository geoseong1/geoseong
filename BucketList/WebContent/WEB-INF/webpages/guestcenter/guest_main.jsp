<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>guest_main.jsp</h1>

<table cellspacing="0" class="guesttbl_list">
<tr>
	<td colspan="6" id="btn">
		<a href="guestinsert.do">글쓰기</a>
	</td>
</tr>
<tr>
	<th>게시번호</th>
	<th>아이디</th>
	<th>제목</th>
	<th>게시날짜</th>
	<th>파일</th>
	<th>조회수</th>
</tr>
<c:choose>
	<c:when test="${empty guestbrd }">
		<tr>
			<td id="underth" colspan="6">검색 결과가 없습니다.</td>
		</tr>
	</c:when>
	<c:otherwise>
		<c:forEach var="guestbrd" items="${guestbrd }">
			<tr>
				<td>${guestbrd.brdno }</td>
				<td>${guestbrd.brduserid }</td>
				<td><a href="guestcontent.do?brdno=${guestbrd.brdno }">${guestbrd.brdsubject }</a></td>
				<td>${guestbrd.brdadddate }</td>
			<c:choose>
			<c:when test="${empty guestbrd.brdfilepath }">
				<td></td>
			</c:when>
			<c:otherwise>
				<td>yes</td>
			</c:otherwise>
			</c:choose>
				<td>${guestbrd.brdcount }</td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
</table>
