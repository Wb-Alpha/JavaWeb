<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户登录</title>

	<!-- Bootstrap -->
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login_frame.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login_detail.css" />
</head>

<body>

	<div class="head">
		<p style="font-size: 32; color: whitesmoke;">叉烧工作室</p>
	</div>
	<div class="main">
		<img src="${pageContext.request.contextPath }/images/github_256_black.png" alt="github_logo" />
		<div class="login_pane">
			<p style="font-size: 28; font-family: Microsoft YaHei;" >薪资管理系统</p>
			<p>${pageContext.request.contextPath }</p>
			<%-- ${msg} --%>
			<form action="${pageContext.request.contextPath }/login" 
			        method="POST">
				<p style="margin-left: -170px ;margin-top: 10px; margin-bottom: -2px;">
					用户账号
				</p>
				<input id="input" type="text" name="id"/><br />
				<p style="margin-left: -190px ;margin-top: 10px; margin-bottom: -2px;">
					密&nbsp;&nbsp;&nbsp;码
				</p>
			    <input id="input" type="password" name="password"/><br />
				<input id="submit_button" type="submit" value="登录" />
			</form>
		</div>
	</div>
</body>
</html>
