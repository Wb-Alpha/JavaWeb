<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
</head>
<body>
	<form action="studentupdate" id="form1" name="form1" method="post">
		<table align="center" width="500" border="1"
		cellspacing="0" cellpadding="0" 
		style="border-collapse: collapse;" bordercolor="#0099FF">
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">学号:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="sno" readonly="readonly" id="sno" 
				value="${student.sno }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">姓名:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="sname" id="sname" 
				value="${student.sname }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">性别:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="ssex" id="ssex" 
				value="${student.ssex }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">籍贯:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="snative" id="snative" 
				value="${student.snative }"></td>
			</tr>
			<tr>
				<td width="116" height="30" align="right"
				valign="middle">专业:</td>
				<td width="378" align="left" valign="middle">
				<input type="text" name="mno" id="mno" 
				value="${student.mno }"></td>
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