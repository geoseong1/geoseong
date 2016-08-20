<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>guest_content.jsp</h1>
<form method="post" action="guestdelete.do">
<table cellspacing="0" class="guesttbl_addmod">
<tr>
	<td colspan="3">게시번호 : ${guestbrd.brdno }, 게시날짜 : ${guestbrd.brdadddate }</td>
</tr>
<tr>
	<th>아이디</th>
	<td>${guestbrd.brduserid }</td>
	
	<th>파일</td>
</tr>
<tr>
	<th>제목</th>
	<td>${guestbrd.brdsubject }</td>
	
	<td rowspan="3">
		<div>파일<input type="hidden" name="brdfilepath" value="filepath"></div>
		<div>${guestbrd.brdfilepath }</div>
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
	<td colspan="3" id="btn">
		<input type="hidden" name="brdno" value="${guestbrd.brdno }">
		<input type="submit" value="제거하기">
		<input type="button" value="수정하기" onclick="location.href='guestupdate.do'">
		<input type="button" value="목록으로" onclick="location.href='guestcenter.do'">
	</td>
</tr>
</table>
</form>