<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算示例</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="arithmetic.action">
  <table width="500" border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse; color: #000;" bordercolor="#0099FF">
    <tr>
      <td height="30" colspan="2" align="center" valign="middle" bgcolor="#0099FF">加法运算</td>
    </tr>
    <tr>
      <td width="168" height="30" align="right" valign="middle">第1个数：</td>
      <td width="326" align="left" valign="middle"><label for="num1"></label>
      <input type="text" name="num1" id="num1" /></td>
    </tr>
    <tr>
      <td height="30" align="right" valign="middle">第2个数：</td>
      <td align="left" valign="middle"><label for="num2"></label>
      <input type="text" name="num2" id="num2" /></td>
    </tr>
    <tr>
      <td height="30" colspan="2" align="center" valign="middle"><input type="submit" name="button" id="button" value="计算" /></td>
    </tr>
  </table>
</form>

</body>
</html>