<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息列表</title>
	<!-- Bootstrap -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main_frame.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main_detail.css" />
<script type="text/javascript">
	function frmSubmit() {
		document.form1.submit();
	}
</script>
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
					<li role="presentation" class="active">
						<a href="${pageContext.request.contextPath }/employeelist">管理员工信息</a></li>
				</c:if>
				<c:if test="${USER_SESSION.identify eq 'FM'}">
					<li role="presentation" class="active">
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
		<div class="mainContainer" style="color:#b8b6b4">
			<div class="head">
				<p style="font-size: 32px; font-family: Microsoft YaHei; float: left; color: #ffffff">&nbsp;&nbsp;薪资管理系统</p>
				<h4 style=" font-family: Microsoft YaHei; float: left; color: #b8b6b4; margin-left: 1000px">当前时间:${TIME_SESSION}</h4>
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
			<h1 style="margin-left: 10%; color:#ffffff;">用户信息</h1>
			<a class="btn btn-success" href="${pageContext.request.contextPath }/exportEmployeeToExcal" style="margin-left: 1200px;margin-top: -40px;">
				<span class="glyphicon glyphicon-save" aria-hidden="true" style="font-size: 12px">导出</span>
			</a>
			<hr width="80%" style="text-align: center">
			<c:if test="${USER_SESSION.identify eq 'FM'}"><center>分发${LAST_TIME_SESSION }的工资</center></c:if>

			<form action="employeedelete" id="form1" name="form1" method="post">
				<div style="width:900px; margin-left: 400px ">
				<table align="center" class="table">
					<tr>
						<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR'}">
							<td>选择</td>
						</c:if>
						<c:if test="${USER_SESSION.identify eq 'FM'}">
							<td>状态</td>
						</c:if>
						<td>员工号</td>
						<td>姓名</td>
						<td>职位</td>
						<td>总工资</td>
						<td>基本工资</td>
						<td>绩效工资</td>
						<td>津贴</td>
						<td>操作&nbsp;&nbsp;
						<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR'}">
						<a href="employeepreinsert">添加</a>
						&nbsp;&nbsp;<a href="#" onclick="javascript:frmSubmit();">删除</a>&nbsp;&nbsp;
						</c:if>
						<a href="employeepresearch">查询</a></td>
						</tr>
						<c:forEach items="${employeeList}" var="employee">
							<tr>
								<td>
								<c:if test="${USER_SESSION.identify eq 'admin' || USER_SESSION.identify eq 'HR'}">
									<input type="checkbox" name="enoArray" value="${employee.eno}">
								</c:if>
								<c:if test="${USER_SESSION.identify eq 'FM'}">
									<c:if test="${employee.emer_sal == 0 }">
										<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true" style="font-size: 12px; color:#a94442;"></span>
									</c:if>
									<c:if test="${employee.emer_sal != 0 }">
										<span class="glyphicon glyphicon-ok" aria-hidden="true" style="font-size: 12px; color:#3c763d;"></span>
									</c:if>
								</c:if></td>
								<td>${employee.eno }</td>
								<td>${employee.ename }</td>
 								<td>${employee.epos }</td>
								<td>${employee.esal }</td>
								<td>${employee.ebase_sal }</td>
								<td>${employee.emer_sal }</td>
								<td>${employee.esubsidy }</td>
								<td>
									<a
									href="employeepreupdate?eno=${employee.eno}&ename=${employee.ename}&epos=${employee.epos}
									&esal=${employee.esal}&ebase_sal=${employee.ebase_sal}&emer_sal=${employee.emer_sal }
									&esubsidy=${employee.esubsidy}">
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