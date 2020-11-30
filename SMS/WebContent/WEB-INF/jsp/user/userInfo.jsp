<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人薪资概况</title>
	<!-- Bootstrap -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main_frame.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main_detail.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/userInfo.css" />
</head>
<body>
	<div class="main">
		<div class="sideBar">
			<br><br><br><br>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/toAdmin">主页</a></li>
				<li role="presentation" class="active">
					<a href="#">个人薪资概况</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/userlist">管理用户信息</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/employeelist">管理员工信息</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/positionlist">管理职位信息</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/levellist">管理行政等级信息</a></li>
				<br><br><br><br><br><br><br><br>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/logout">退出</a></li>
			</ul>
		</div>
		<div class="mainContainer">
			<div class="head">
				<p style="font-size: 32px; font-family: Microsoft YaHei; color:#ffffff; float: left;">&nbsp;&nbsp;薪资管理系统</p>
				<div class="btn-group" style="margin-top: -80px; margin-left: 1400px;">
					<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						当前用户: ${USER_SESSION.username }<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath }/user_selfupdate">更改用户信息</a></li>
						<li><a href="${pageContext.request.contextPath }/logout">退出登录</a></li>
					</ul>
				</div>
			</div>
			<h1 style="margin-left: 10%; color:#ffffff;">个人薪资情况</h1>
			<hr width="80%" style="text-align: center">
			<div class="baseInfo">
				<h3>您的信息:</h3>
				<p style="margin-top: 30px">员工号:${USER_SESSION.id }</p>
				<p style="margin-top: -3px">用户名:${USER_SESSION.username }</p>
				<p style="margin-top: -3px">职位:${EMPLOYEE_SESSION.epos }</p>
				<p style="margin-top: -3px;">权限:${USER_SESSION.identify }</p>
			</div>
			<div class="salaryInfo">
				<div class="singleInfoPane">
					<p class="largeInfoFont">${EMPLOYEE_SESSION.esal }</p>
					<p class="smallInfoFont">总工资</p>
				</div>
				<div class="singleInfoPane">
					<p class="largeInfoFont">${EMPLOYEE_SESSION.ebase_sal }</p>
					<p class="smallInfoFont">基本工资</p>
				</div>
				<div class="singleInfoPane">
					<p class="largeInfoFont">${EMPLOYEE_SESSION.emer_sal }</p>
					<p class="smallInfoFont">绩效</p>
				</div>
				<div class="singleInfoPane">
					<p class="largeInfoFont">${EMPLOYEE_SESSION.esubsidy }</p>
					<p class="smallInfoFont">津贴</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>