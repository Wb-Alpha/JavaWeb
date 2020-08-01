<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
<script type="text/javascript">
	function frmSubmit() {
		document.form1.submit();
	}
	
	/* function go() {
		var a=document.getElementById("mySelect");
		var b=a.options[a.selectedIndex].value;
		var c=document.getElementById("key").value;
		if(b==2){
			window.document.location = "courselist?selectType="+b+"&cname="+c;
		}
		else if(b==3){
			window.document.location = "courselist?selectType="+b+"&cno="+c;
		}
		else{
			window.document.location = "courselist";
		}
		
	} */
</script>
</head>
<body>
	<center>学生信息</center>
	<form action="coursedelete" id="form1" name="form1" method="post">
		<table align="center" width="500" border="1"
		cellspacing="0" cellpadding="0"
		style="border-collapse: collapse;" bordercolor="#0099FF">
			<!-- <tr>
				<td colspan="4">
					<input type="text" id="key">
					<select id="mySelect" name="mySelect">
						<option value="" id="selectType" name="selectType" >全部查询</option>
						<option value="2" id="selectType" name="selectType" >模糊查询</option>
						<option value="3" id="selectType" name="selectType" >按课程号查询</option>
					</select>
				</td>
				<td>
					<a href="javascript:go()">查询</a>
				</td>
			</tr> -->
				
			<tr>
				<td>选择</td>
				<td>课程号</td>
				<td>课程名</td>
				<td>课时</td>
				<td>操作&nbsp;&nbsp;<a href="coursepreinsert">添加
				</a>&nbsp;&nbsp;<a href="#" onclick="javascript:frmSubmit();">删除</a> </td>
				</tr>
				<c:forEach items="${courseList}" var="course">
					<tr>
						<td><input type="checkbox" name="cnoArray"
						value="${course.cno }"></td>
						<td>${course.cno }</td>
						<td>${course.cname }</td>
						<td>${course.period }</td>
						<td>
							<a
							href="coursepreupdate?cno=${course.cno }&cname=${course.cname }
							&period=${course.period }">
							修改
							</a>
						</td>
						</tr>
				</c:forEach>
		</table>
	</form>
</body>
</html>