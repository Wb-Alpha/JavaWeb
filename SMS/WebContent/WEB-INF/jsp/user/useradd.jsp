<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form1" method="post" action="userinsert">
		<table>
			<tr>
				<td>员工号</td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>职位号</td>
				<td><input type="text" name="epos" /></td>
			</tr>
			<tr>
				<td>绩效工资</td>
				<td><input type="text" name="emer_sal" /></td>
			</tr>
			<tr>
				<td>津贴</td>
				<td><input type="text" name="esubsidy" /></td>
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
			  <td height="30" align="right" valign="middle">&nbsp;</td>
			  <td align="left" valign="middle"><input type="submit" name="button" id="button" value="提交" />
			  <input type="reset" name="button2" id="button2" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>