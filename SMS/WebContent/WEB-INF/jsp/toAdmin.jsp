<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统主页</title>
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
			sidebar
			<br><br><br><br>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active">
					<a href="#">概况</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/userlist">管理用户信息</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/employeelist">管理员工信息</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/positionlist">管理职位信息</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/levellist">管理行政等级信息</a></li>
			</ul>
		</div>
		<div class="mainContainer">
			<a href="${pageContext.request.contextPath }/logout">退出</a>
		    &nbsp;&nbsp;&nbsp;
		    <a href="${pageContext.request.contextPath }/positionlist">管理职位信息</a>
		    &nbsp;&nbsp;&nbsp;
		    <a href="${pageContext.request.contextPath }/levellist">管理行政等级信息</a>
		    &nbsp;&nbsp;&nbsp;
		    <a href="${pageContext.request.contextPath }/employeelist">管理员工信息</a>
			&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/userlist">管理用户信息</a> 
		</div>
	</div>
</body>
</html>
