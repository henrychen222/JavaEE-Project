<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <base target="_self"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<script language="javascript">
            function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		    function check1()
		    {
		        if(document.form1.username.value=="")
		        {
		            alert("请输入账号");
		            return false;
		        }
		        if(document.form1.password.value=="")
		        {
		            alert("请输入密码");
		            return false;
		        }
		        document.form1.submit();
		    }
        </script>
	</head>
	<body>
			<form action="<%=path %>/user?type=register" name="form1" method="post">
			
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
				  
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							用户名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="username" style="width: 150px;"/>
						</td>
					</tr>
					
				
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							密码：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="password" name="password" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							确认密码：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="password" name="password" style="width: 150px;"/>
						</td>
					</tr>
					
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="submit" value="注册"/>
							<input type="reset" value="取消" onclick="closeOpen()"/>
						</td>
					</tr>
				
				</table>
				
			</form>
	</body>
</html>
