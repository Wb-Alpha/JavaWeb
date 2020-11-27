<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息列表</title>
<script type="text/javascript">
	function frmSubmit() {
		document.form1.submit();
	}
</script>
</head>
<body>
	<center>用户信息</center>
	<form action="userdelete" id="form1" name="form1" method="post">
		<table align="center" width="500" border="1"
		cellspacing="0" cellpadding="0" bordercolor="#0099FF">
			<tr>
				<td>选择</td>
				<td>员工号</td>
				<td>姓名</td>
				<td>密码</td>
				<td>权限</td>
				<td>操作&nbsp;&nbsp;<a href="userpreinsert">添加</a>
				&nbsp;&nbsp;<a href="#" onclick="javascript:frmSubmit();">删除</a>
				&nbsp;&nbsp;<a href="userpresearch">查询</a></td>
			</tr>
			<c:forEach items="${userList}" var="user">
					<tr>
						<td><input type="checkbox" name="unoArray"
						value="${user.id}"></td>
						<td>${user.id }</td>
						<td>${user.username }</td>
						<td>${user.password }</td>
						<td>${user.identify }</td>
						<td>
							<a
							href="userpreupdate?uid=${user.id}&username=${user.username}&password=${user.password}
							&identify=${user.identify}">
							修改
							</a>
						</td>
						</tr>
				</c:forEach>
		</table>
	</form>
</body>
</html>