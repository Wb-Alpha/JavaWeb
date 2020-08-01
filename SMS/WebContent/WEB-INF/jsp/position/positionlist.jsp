<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职位信息列表</title>
<script type="text/javascript">
	function frmSubmit() {
		document.form1.submit();
	}
</script>
</head>
<body>
	<center>职位信息</center>
	<form action="positiondelete" id="form1" name="form1" method="post">
		<table align="center" width="500" border="1"
		cellspacing="0" cellpadding="0"
		style="border-collapse: collapse;" bordercolor="#0099FF">
			<tr>
				<td>选择</td>
				<td>职位号</td>
				<td>职位名</td>
				<td>行政等级</td>
				<td>操作&nbsp;&nbsp;<a href="positionpreinsert">添加</a>
				&nbsp;&nbsp;<a href="#" onclick="javascript:frmSubmit();">删除</a>
				&nbsp;&nbsp;<a href="positionpresearch">查询</a></td>
				</tr>
				<c:forEach items="${positionList}" var="position">
					<tr>
						<td><input type="checkbox" name="enoArray"
						value="${position.pno}"></td>
						<td>${position.pno }</td>
						<td>${position.pname }</td>
						<td>${position.plevel }</td>
						<td>
							<a
							href="positionpreupdate?pno=${position.pno}&pname=${position.pname}
							&plevel=${position.plevel}">
							修改
							</a>
						</td>
						</tr>
				</c:forEach>
		</table>
	</form>
</body>
</html>