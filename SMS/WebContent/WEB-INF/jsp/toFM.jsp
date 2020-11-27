<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>财务部账号</p>
	<p>当前用户：${USER_SESSION.username}</p>
	<a href="${pageContext.request.contextPath }/logout">退出</a> 
	&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/employeelist">管理员工信息</a>
	&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/levellist">管理行政等级信息</a>
</body>
</html>