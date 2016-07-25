<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>test table results : </p>
<table border="1" cellspacing="0">
<c:forEach items="${testfor}" var="forr" >
	<tr>
		<td>${forr}</td>
	</tr>
</c:forEach>
</table>
<p><img src="/BucketList/resources/img/people_m2.png"></p>
<p><a href="/BucketList">return to Main</a></p>
</body>
</html>