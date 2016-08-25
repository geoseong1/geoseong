<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 스타일시트 적용 -->
<link rel="stylesheet" href="resources/css/guestboard.css">

<h1>guest_insert.jsp</h1>
<form method="post" enctype="multipart/form-data">
<table cellspacing="5" cellpadding="5" class="guesttbl_addmod">
<tr>
	<th>아이디</th>
	<td>geoseong<input type="hidden" name="brduserid" value="geoseong"></td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="brdsubject" placeholder="제목을 입력하세요" required="required" size="98"></td>
			<!-- INPUT TYPE의 required 속성은 HTML5 기능인 듯. -->
</tr>
<tr>
	<th>파일</th>
	<td><input type="file" name="file">	</td>
</tr>
<tr>	
	<th>내용</th>
	<td>	<textarea name="brdcontext" cols="100" rows="15" placeholder="내용을 입력하세요"></textarea>	</td>
</tr>
<tr>
	<td colspan="2" align="right">
		<input type="button" value="목록으로" onclick="location.href='guestcenter.do'">
		<input type="submit" value="글쓰기">
	</td>
</tr>
</table>
</form>