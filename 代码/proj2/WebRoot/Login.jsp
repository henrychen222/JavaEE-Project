<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type='text/javascript'
	src='<%=path%>/dwr/interface/loginService.js'></script>
<script type='text/javascript' src='<%=path%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=path%>/dwr/util.js'></script>

<script type="text/javascript">
           function check (){
if(document.ThisForm.loginname.value==""){
alert("请输入账号！")
return false;
}
if(document.ThisForm.loginpwd.value==""){
alert("请输入密码！")
return false;
}
 
				 loginService.login(document.ThisForm.loginname.value,document.ThisForm.loginpwd.value,callback);
			}
		
			function callback(data)
			{
			   
			    if(data=="no")
			    {
			        alert("账号或密码错误");
			    }
			    if(data=="yes")
			    {   alert("登陆成功");
			        window.location.href="<%=path%>/center.jsp";
			    }
			}
	        
	        
	        
	        


function userReg(){
var url="<%=path%>/userReg.jsp";
window.location.href = url;
	}
</script>
</head>

<body>
	<tr>
		<td>
			<form name="ThisForm" method="post">
				<div align="center">
					<td align="right" width="31%" height="30" style="font-size: 11px;">账号：</td>
					<td align="left" width="69%"><input name="loginname"
						type="text" style="width: 100px;" /></td>
	</tr>
	<br>
	<tr>
		<td align="right" height="30" style="font-size: 11px;">密码：</td>
		<td align="left"><input type="password" style="width: 100px;"
			name="loginpwd" /></td>
	</tr>
	<br>
	<tr>
		<td align="center" colspan="2" height="10"></td>
	</tr>
	<tr>
		<td align="center" colspan="2" height="60"><input type="button"
			value="登  录" onclick="check()"
			style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
			<input type="button" value="注  册" onclick="userReg()"
			style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />

			</from>
		</td>
	</tr>

</body>
</html>
