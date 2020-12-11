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
	<!-- Bootstrap -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main_frame.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main_detail.css" />
	
	<style type="text/css">
		p{
			color:#b8b6b4;
		}
	</style>
</head>
<body>
	<div class="main">
		<div class="sideBar">
			<br><br><br><br>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/toAdmin">主页</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/userInfo">个人薪资概况</a></li>
				<c:if test="${USER_SESSION.identify eq 'admin'}">
					<li role="presentation" class="active">
						<a href="${pageContext.request.contextPath }/userlist">管理用户信息</a></li>
				</c:if>	
				<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR'}">
					<li role="presentation">
						<a href="${pageContext.request.contextPath }/employeelist">管理员工信息</a></li>
				</c:if>
				<c:if test="${USER_SESSION.identify eq 'FM'}">
					<li role="presentation">
					<a href="${pageContext.request.contextPath }/employeelist">管理员工薪资
					<c:if test="${PREDEAL_SESSION != 0 }"><span class="badge">${PREDEAL_SESSION }</span></c:if>
					</a></li>
				</c:if>
				<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR'}">
					<li role="presentation">
						<a href="${pageContext.request.contextPath }/positionlist">管理职位信息</a></li>
				</c:if>
				<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR'}">
					<li role="presentation">
						<a href="${pageContext.request.contextPath }/levellist">管理行政等级信息</a></li>
				</c:if>
				<br><br><br><br><br><br><br><br>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/logout">退出</a></li>
			</ul>
		</div>
		<div class="mainContainer" style="color:#b8b6b4">
			<div class="head">
				<p style="font-size: 32px; font-family: Microsoft YaHei; float: left; color: #ffffff">&nbsp;&nbsp;薪资管理系统</p>
				<h4 style=" font-family: Microsoft YaHei; float: left; color: #b8b6b4; margin-left: 1000px">当前时间:${TIME_SESSION}</h4>
				<div class="btn-group" style="margin-top: -80px; margin-left: 1400px;">
				  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    当前用户: ${USER_SESSION.username }<span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu">
				    <li><a href="${pageContext.request.contextPath }/user_selfupdate?uno= ${USER_SESSION.username}&password= ${USER_SESSION.password }">
				    	更改用户信息</a></li>
				    <li><a href="${pageContext.request.contextPath }/logout">退出登录</a></li>
				  </ul>
				</div>
			</div>
			<h1 style="margin-left: 10%; color:#ffffff;">用户信息</h1>
			<hr width="80%" style="text-align: center">
			<form action="userdelete" id="form1" name="form1" method="post">
				<div style="width:900px; margin-left: 400px ">
					<table align="center" class="table">
					<tr>
						<td>选择</td>
						<td>员工号</td>
						<td>姓名</td>
						<td>密码</td>
						<td>权限</td>
						<td>操作&nbsp;&nbsp;
						<a class="btn btn-success" href="userpreinsert">添加</a>
						&nbsp;&nbsp;<a class="btn btn-danger" href="#" onclick="javascript:frmSubmit();">删除</a>
						&nbsp;&nbsp;<a class="btn btn-warning" href="userpresearch">查询</a></td>
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
									<a class="btn btn-default"
									href="userpreupdate?uid=${user.id}&username=${user.username}&identify=${user.identify}">
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