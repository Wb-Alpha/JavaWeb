<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改职位信息</title>
</head>
<body>
	<form action="levelupdate" id="form1" name="form1" method="post">
		<table align="center" width="500" border="1"
		cellspacing="0" cellpadding="0" 
		style="border-collapse: collapse;" bordercolor="#0099FF">
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">级别:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="lno" readonly="readonly" id="lno" 
				value="${level.lno }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">级别名:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="lname" id="lname" 
				value="${level.lname }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">等级工资:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="base_sal" id="base_sal" 
				value="${level.base_sal }"></td>
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