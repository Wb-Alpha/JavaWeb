<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改员工信息</title>
</head>
<body>
	<form action="employeeupdate" id="form1" name="form1" method="post">
		<table align="center" width="500" border="1"
		cellspacing="0" cellpadding="0" 
		style="border-collapse: collapse;" bordercolor="#0099FF">
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">员工号:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="eno" readonly="readonly" id="eno" 
				value="${employee.eno }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">姓名:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="ename" id="ename" 
				value="${employee.ename }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">职位:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="epos" readonly="readonly" id="epos" 
				value="${employee.epos }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">绩效工资:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="emer_sal" readonly="readonly" id="emer_sal" 
				value="${employee.emer_sal }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">津贴:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="esubsidy" id="esubsidy" 
				value="${employee.esubsidy }"></td>
			</tr>
			<tr>
				<td>用户身份</td>
				<td>
					<select name="identify">
						<option value="admin">管理员</option>
						<option value="HR">人力资源部</option>
						<option value="FM">财务部</option>
						<option value="normal">普通用户</option>
					</select>
				</td>
			</tr>
			<tr>
				<td height="30" align="right"
				valign="middle">&nbsp;</td>
				<td align="left" valign="middle">
				<input type="submit" name="button" value="提交">
				<input type="reset" name="button2" id="button2"
				value="重置"></td>
			</tr>	
		</table>
	</form>
</body>
</html>