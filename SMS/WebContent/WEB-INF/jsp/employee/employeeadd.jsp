<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工</title>
</head>
<body>
	<form id="form1" name="form1" method="post" action="employeeinsert">
    <table align="center" width="500" border="1" cellspacing="0" cellpadding="0" style="border-collapse:collapse" bordercolor="#0099FF">
    <tr>
      <td width="116" height="30" align="right" valign="middle">员工号：</td>
      <td width="378" align="left" valign="middle">
      <input type="text" name="eno" id="eno" /></td>
    </tr>
    <tr>
      <td width="116" height="30" align="right" valign="middle">姓名：</td>
      <td width="378" align="left" valign="middle">
      <input type="text" name="ename" id="ename" /></td>
    </tr>
    <tr>
      <td width="116" height="30" align="right" valign="middle">职位：</td>
      <td width="378" align="left" valign="middle">
      <input type="text" name="epos" id="epos" /></td>
    </tr>
    <tr>
      <td width="116" height="30" align="right" valign="middle">绩效工资：</td>
      <td width="378" align="left" valign="middle">
      <input type="text" name="emer_pos" id="emer_pos" /></td>
    </tr>
    <tr>
      <td width="116" height="30" align="right" valign="middle">津贴：</td>
      <td width="378" align="left" valign="middle">
      <input type="text" name="emer_pos" id="emer_pos" /></td>
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