<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>等级信息列表</title>
<script type="text/javascript">
	function frmSubmit() {
		document.form1.submit();
	}
</script>
</head>
<body>
	<center>等级信息</center>
	<form action="leveldelete" id="form1" name="form1" method="post">
		<table align="center" width="500" border="1"
		cellspacing="0" cellpadding="0"
		style="border-collapse: collapse;" bordercolor="#0099FF">
			<tr>
				<td>选择</td>
				<td>级别</td>
				<td>等级名称</td>
				<td>等级工资</td>
				<td>操作&nbsp;&nbsp;<a href="levelpreinsert">添加</a>
				&nbsp;&nbsp;<a href="#" onclick="javascript:frmSubmit();">删除</a>
				&nbsp;&nbsp;<a href="levelpresearch">查询</a></td>
				</tr>
				<c:forEach items="${levelList}" var="level">
					<tr>
						<td><input type="checkbox" name="enoArray"
						value="${level.lno}"></td>
						<td>${level.lno }</td>
						<td>${level.lname }</td>
						<td>${level.base_sal }</td>
						<td>
							<a
							href="levelpreupdate?lno=${level.lno}&lname=${level.lname}&base_sal=${level.base_sal}">
							修改
							</a>
						</td>
						</tr>
				</c:forEach>
		</table>
	</form>
</body>
</html>