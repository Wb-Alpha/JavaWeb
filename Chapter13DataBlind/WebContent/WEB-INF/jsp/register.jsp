<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/registerUser" method="post">
		用户名：<input type="text" name="username"/><br>
		密&nbsp;&nbsp;码<input type="text" name="password"/></br><!-- type="password" -->
		<input type="submit" value="注册"/>
	</form>
</body>
</html>