<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统主页</title>
</head>
<body>
    当前用户：${USER_SESSION.username}  
    <a href="${pageContext.request.contextPath }/logout">退出</a>  
    &nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath }/positionlist">管理职位信息</a>
    &nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath }/levellist">管理行政等级信息</a>
    &nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath }/employeelist">管理员工信息</a>
	&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/userlist">管理用户信息</a>
</body>
</html>
