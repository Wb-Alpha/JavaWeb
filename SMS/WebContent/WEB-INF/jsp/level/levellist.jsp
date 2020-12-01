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
	<!-- Bootstrap -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main_frame.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main_detail.css" />
</head>
<body>
	<div class="main">

		<div class="sideBar">
			<br><br><br><br>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/toAdmin">概况</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/userInfo">个人薪资概况</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/userlist">管理用户信息</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/employeelist">管理员工信息</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/positionlist">管理职位信息</a></li>
				<li role="presentation" class="active">
					<a href="#">管理行政等级信息</a></li>
				<br><br><br><br><br><br><br><br>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/logout">退出</a></li>
			</ul>
		</div>
		<div class="mainContainer" style="color:#b8b6b4">
			<div class="head">
				<p style="font-size: 32px; font-family: Microsoft YaHei; float: left; color: #ffffff">&nbsp;&nbsp;薪资管理系统</p>
				<div class="btn-group" style="margin-top: -50px; margin-left: 1400px;">
				 	<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				  	  当前用户: ${USER_SESSION.username }<span class="caret"></span>
				 	</button>
				 	<ul class="dropdown-menu">
				    	<li><a href="${pageContext.request.contextPath }/user_selfupdate">更改用户信息</a></li>
				   		<li><a href="${pageContext.request.contextPath }/logout">退出登录</a></li>
				 	</ul>
				</div>
			</div>
			<h1 style="margin-left: 10%; color:#ffffff;">行政等级信息</h1>
			<hr width="80%" style="text-align: center">
			<form action="leveldelete" id="form1" name="form1" method="post">
				<div style="width:900px; margin-left: 400px ">
				<table class="table">
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
				</div>
				
			</form>
		</div>
	</div>
	
</body>
</html>