<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>订单查询</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/findOrderWithUser" methed="post">
		订单编号:<input type="text" name="ordersId"/><br>
		所属用户:<input type="text" name="user.username"/><br>
		<input type="submit" value="查询"/>
	</form>
</body>
</html>