<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户信息</title>
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
					<a href="${pageContext.request.contextPath }/toAdmin">主页</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/userInfo">个人薪资概况</a></li>
				<c:if test="${USER_SESSION.identify eq 'admin'}">
					<li role="presentation">
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
			<h1 style="margin-left: 10%; color:#ffffff;">修改用户</h1>
			<hr width="80%" style="text-align: center">
			<div  style="width:300px; margin-left: 600px;">
				<form action="user_selfupdate" id="form1" name="form1" method="post">
				<div class="form-group">
					<table>员工号</table>
					<input type="text" name="id" id="id" readonly="readonly" value="${user.id}" class="input_zone">
				</div>
				<div class="form-group">
					<table>用户名</table>
					<input type="text" name="username" id="username" value="${user.username}" class="input_zone">
				</div>
				<div>
					<table>新密码</table>
					<input type="text" name="password" id="password" class="input_zone">
				</div>
				<div>
					<table>确认密码</table>
					<input type="text" name="password1" id="password1" class="input_zone">
				</div>
				<br>
				<div>
					<label>用户身份</label>
					<select name="identify" class="form-control" style="width: 250px">
						<option value="admin">管理员</option>
						<option value="HR">人力资源部</option>
						<option value="FM">财务部</option>
						<option value="normal">普通用户</option>
					</select>
				</div>
				<br>
				<div class="form-group">
					<input type="submit" name="button" id="button" value="提交" class="btn btn-success" style="width: 120px; margin-left: 5px;"/>
			      	<input type="reset" name="button2" id="button2" value="重置" class="btn btn-default" style="width: 120px"/>
				</div>
			</form>
			</div>		
		</div>
	</div>
</body>
</html>