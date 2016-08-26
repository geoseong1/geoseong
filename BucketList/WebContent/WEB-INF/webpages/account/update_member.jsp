<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>join_member.jsp</h1>

<form method="post" action="updatemember.do">
<table class="join_tbl" cellspacing="3">
	<tr>
		<th>아이디</th><td><input type="text" name="userid" value="${memInfo.userid }"></td><td></td>
	</tr>
	<tr>
		<th>이름</th><td><input type="text" name="username" value="${memInfo.username }"></td><td></td>
	</tr>
	<tr>
		<th>비밀번호</th><td><input type="text" name="userpwd" value="${memInfo.userpwd }"></td><td></td>
	</tr>
	<tr>
		<th>연락처</th><td><input type="text" name="userphone" value="${memInfo.userphone }"></td><td></td>
	</tr>
	<tr>
		<th>이메일</th><td><input type="text" name="useremail" value="${memInfo.useremail }"></td><td></td>
	</tr>
	<tr>
		<td colspan="3">
			<input type="hidden" name="joindate" value="">
			<input type="hidden" name="writedbrd" value="">
			<input type="hidden" name="writedreply" value="">
			<input type="reset" value="리셋하기">
			<input type="button" value="돌아가기" onclick="areyousure()">
			<input type="submit" value="수정완료">
		</td>
	</tr>
</table>
</form>