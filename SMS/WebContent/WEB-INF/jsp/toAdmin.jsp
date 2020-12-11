<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<br><br><br><br>
			<ul class="nav nav-pills nav-stacked">
				<li role="presentation" class="active">
					<a href="#">主页</a></li>
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
				<c:if test="${USER_SESSION.identify eq 'FM'}">
					<li role="presentation">
						<a href="${pageContext.request.contextPath }/salaryrecord">薪资流水记录</a></li>
				</c:if>
				<br><br><br><br><br><br><br><br>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/logout">退出</a></li>
			</ul>
		</div>
		<div class="mainContainer">
			<div class="head">
				<p style="font-size: 32px; font-family: Microsoft YaHei; float: left; color: #ffffff">&nbsp;&nbsp;薪资管理系统</p>
				<h4 style=" font-family: Microsoft YaHei; float: left; color: #b8b6b4; margin-left: 1000px">当前时间:${TIME_SESSION}</h4>
				<div class="btn-group" style="margin-top: -45px; margin-left: 1400px;">
				  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    当前用户: ${USER_SESSION.username }<span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu">
				    <li><a href="${pageContext.request.contextPath }/userpre_selfupdate">更改用户信息</a></li>
				    <li><a href="${pageContext.request.contextPath }/logout">退出登录</a></li>
				  </ul>
				</div>
			</div>

			<img alt="new" src="${pageContext.request.contextPath }/images/mainPic.png" style="width: 100%;" />
			<br>
			<div class="funcContainer">
				<button class="funcPaneButton" onclick="window.location.href='${pageContext.request.contextPath}/userInfo'">
				<span class="glyphicon glyphicon-searchglyphicon glyphicon-btc" aria-hidden="true" style="font-size: 48px"></span><br>个人薪资概况</button>
				
				<c:if test="${USER_SESSION.identify eq 'admin'}">
					<button class="funcPaneButton" onclick="window.location.href='${pageContext.request.contextPath}/userlist'">
					<span class="glyphicon glyphicon-th-list" aria-hidden="true" style="font-size: 48px"></span><br>管理用户信息</button>
				</c:if>
				
				<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR' || USER_SESSION.identify eq 'FM'}">
					<button class="funcPaneButton" onclick="window.location.href='${pageContext.request.contextPath}/employeelist'">
					<span class="glyphicon glyphicon-knight" aria-hidden="true" style="font-size: 48px"></span><br>管理员工信息</button>				
				</c:if>
				
				<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR'}">
					<button class="funcPaneButton" onclick="window.location.href='${pageContext.request.contextPath}/positionlist'">
					<span class="glyphicon glyphicon-education" aria-hidden="true" style="font-size: 48px"></span><br>管理职位信息</button>
				</c:if>

				<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR'}">
					<button class="funcPaneButton" onclick="window.location.href='${pageContext.request.contextPath}/levellist'">
					<span class="glyphicon glyphicon-briefcase" aria-hidden="true" style="font-size: 48px"></span><br>管理行政等级信息</button>
				</c:if>
				
			</div>
		</div>
	</div>
</body>
</html>
