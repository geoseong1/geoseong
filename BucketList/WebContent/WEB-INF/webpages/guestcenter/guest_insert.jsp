<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>guest_insert.jsp</h1>
<form method="post" enctype="multipart/form-data">
<table cellspacing="0" class="guesttbl_addmod">
<tr>
	<th>아이디</th>
	<td>geoseong<input type="hidden" name="brduserid" value="geoseong"></td>
	
	<th>파일</td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="brdsubject" placeholder="제목을 입력하세요" required="required"></td>
			<!-- INPUT TYPE의 required 속성은 HTML5 기능인 듯. -->
	<td rowspan="2">
		<div><p>파일올리기</p>
		<input type="file" name="file"></div>
	</td>
</tr>
<tr>	
	<th>내용</th>
	<td>	<textarea name="brdcontext" rows="30" cols="100" placeholder="내용을 입력하세요"></textarea>	</td>
</tr>
<tr>
	<td colspan="3" id="btn">
		<input type="submit" value="글쓰기">
		<input type="button" value="목록으로" onclick="location.href='guestcenter.do'">
	</td>
</tr>
</table>
</form>