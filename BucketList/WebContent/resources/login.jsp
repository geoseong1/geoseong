<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.login{
	width: 20em;
	height: 15em;
    float: right;
    margin-right: 4em;
    margin-top: 3em;
	padding: 1em; 
	color: black; 
	background-color: white; 
	opacity: 1.0;
	display: inline-block;
	position: relative;
}
.closebtn{
	position: absolute;
	right: 0em;
	top: 0em;
}
</style>
<script type="text/javascript">
$(".close").click(function(){
	$('.login_modal').hide();
});
</script>
</head>
<body>

<div class="login">
	<span class="closebtn"><a href="#" class="close">닫기</a></span>
	<h1 style="color: black;">로그인 login.jsp</h1>
	<table>
		<tr>
			<th>아이디</th><td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<th>비밀번호</th><td><input type="text" name="userpwd"></td>
		</tr>
		<tr>
			<td colspan="2"><a href="findaccount.do" style="float: right;">아이디/비밀번호 찾기</a></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="로그인"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="회원가입하기" onclick="location.href='joinmember.do'">
			</td>
		</tr>
	</table>
</div>

</body>
</html>