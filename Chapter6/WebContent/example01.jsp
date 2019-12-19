<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8sa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP声明语句</title>
</head>

<%
	int a = 1, b = 2;//定义两个变量a,b
%>

<body>
	<%
		out.println(a+b);
	%>
	<%
		//out.println(print());
	%>
</body>
</html>