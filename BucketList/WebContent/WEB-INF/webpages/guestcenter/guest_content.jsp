<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 스타일시트 적용 -->
<link rel="stylesheet" href="resources/css/guestboard.css">

<h1>guest_content.jsp</h1>
<form method="post" action="guestdelete.do">
<table cellspacing="5" cellpadding="5" class="guesttbl_content">
<tr>
	<td colspan="3" align="right">게시번호 : ${guestbrd.brdno }, 게시날짜 : ${guestbrd.brdadddate }</td>
</tr>
<tr>
	<th>아이디</th>
	<td>${guestbrd.brduserid }</td>
	
	<th>파일</th>
</tr>
<tr>
	<th>제목</th>
	<td>${guestbrd.brdsubject }</td>
	
	<td rowspan="3" align="center" id="filecontent">
		<div>
		<c:choose>
		<c:when test="${!empty guestbrd.brdfilepath }">
			<a href="/BucketList/resources/files/guestcenter/${guestbrd.brdfilepath }" download>${guestbrd.brdfilepath }</a>
		</c:when>
		<c:otherwise>
			<p>파일없음</p>
		</c:otherwise>
		</c:choose>
		</div>
	</td>
</tr>
<tr>	
	<th>조회수</th>
	<td>${guestbrd.brdcount }	</td>
</tr>
<tr>	
	<th>내용</th>
	<td>${guestbrd.brdcontext }</td>
</tr>
<tr>
	<td colspan="3" id="btn" align="right">
		<input type="hidden" name="brdno" value="${guestbrd.brdno }">
		<input type="submit" value="제거하기">
		<input type="button" value="수정하기" onclick="location.href='guestupdate.do?brdno=${guestbrd.brdno }'">
		<input type="button" value="목록으로" onclick="location.href='guestcenter.do'">
	</td>
</tr>
</table>
</form>