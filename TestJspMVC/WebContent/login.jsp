<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<center>
<form id="form1" name="form1" method="post" action="userLogin">
  <table width="344" height="95" border="0" cellpadding="0" cellspacing="1" style="background-color: #3A8ECD; color: #000;">
    <tr>
      <td height="30" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF">用户登录</td>
    </tr>
    <tr>
      <td width="114" height="30" align="right" valign="middle" bgcolor="#FFFFFF">登录名：</td>
      <td width="227" height="20" align="left" valign="middle" bgcolor="#FFFFFF">
        <input type="text" name="username" /></td>
    </tr>
    <tr>
      <td height="30" align="right" valign="middle" bgcolor="#FFFFFF">密码：</td>
      <td height="20" align="left" valign="middle" bgcolor="#FFFFFF"><label for="textfield2"></label>
        <input type="password" name="pwd" /></td>
    </tr>
    <tr>
      <td height="30" colspan="2" align="center" valign="middle" bgcolor="#FFFFFF"><input type="submit" name="button" id="button" value="提交" />&nbsp;&nbsp;
        <input type="reset" name="button2" id="button2" value="重置" /></td>
      </tr>
  </table>
</form>
</center>
</body>
</html>