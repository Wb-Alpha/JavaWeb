<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		var userid = $("#userid").val();
		var password = $("#password").val();
		if (userid=="" || password==""){
			$("#message").text("账号密码不能为空");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div>
	${message}
		<form class="inputZone" action="${pageContext.request.contextPath }/login" 
		        method="POST">
			用户名：<input type="text" name="username"/><br />
			密&nbsp;&nbsp;&nbsp;码：
		    <input type="password" name="password"/><br />
			<input class="btn" type="submit" value="登录" />
		</form>
	</div>
</body>
</html>