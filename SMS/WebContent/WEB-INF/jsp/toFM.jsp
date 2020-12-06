<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页 财务</title>
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
				<c:if test="<boolean>" var="<string>" scope="<string>">
 
				</c:if>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/employeelist">管理员工薪资</a></li>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/levellist">管理行政等级信息</a></li>
				<br><br><br><br><br><br><br><br>
				<li role="presentation">
					<a href="${pageContext.request.contextPath }/logout">退出</a></li>
			</ul>
		</div>
		<div class="mainContainer">
			<div class="head">
				<p style="font-size: 32px; font-family: Microsoft YaHei; float: left; color: #ffffff">&nbsp;&nbsp;薪资管理系统</p>
				<div class="btn-group" style="margin-top: -45px; margin-left: 1400px;">
				  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    当前用户: ${USER_SESSION.username }<span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu">
				    <li><a href="${pageContext.request.contextPath }/user_selfupdate">更改用户信息</a></li>
				    <li><a href="${pageContext.request.contextPath }/logout">退出登录</a></li>
				  </ul>
				</div>
			</div>
			<img alt="new" src="${pageContext.request.contextPath }/images/mainPic.png" style="width: 100%;" />
			<br>
			<div class="funcContainer">
				<button class="funcPaneButton" onclick="window.location.href='${pageContext.request.contextPath}/userInfo'">
				<span class="glyphicon glyphicon-searchglyphicon glyphicon-btc" aria-hidden="true" style="font-size: 48px"></span><br>个人薪资概况</button>
				
				<button class="funcPaneButton" onclick="window.location.href='${pageContext.request.contextPath}/employeelist'">
				<span class="glyphicon glyphicon-knight" aria-hidden="true" style="font-size: 48px"></span><br>管理员工薪资</button>
				
				<button class="funcPaneButton" onclick="window.location.href='${pageContext.request.contextPath}/levellist'">
				<span class="glyphicon glyphicon-briefcase" aria-hidden="true" style="font-size: 48px"></span><br>管理行政等级信息</button>
			</div>
		</div>
	</div>
</body>
</html>