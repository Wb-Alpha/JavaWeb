<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>按员工号查找</title>
</head>
<body>
	<p>页面施工中，功能代码请查看源码</p>
	<a href="/employeelist">返回</a>
	<select name="model">
		<option value="byId">按工号查询</option>
		<option value="byName">按名字查询</option>
		<option value="byPos">按岗位查询</option>
	</select>
	<form>
		<input type="text" name="input_zone">
		<input type="submit" value="查询"/>
	</form>
</body>
</html>