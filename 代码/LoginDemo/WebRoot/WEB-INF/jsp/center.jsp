<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'center.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript">
            function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		    function userQueryMana()
		    {
		      window.location.href="<%=path %>/user?type=userQueryMana";
		    }
        </script>
</head>

<body>
   <form action="<%=path %>/person?type=" name="form1" method="post">
	<table>
		<tr>
			<td height="30" align="right" bgcolor="#F9F9F9">
			&nbsp;
			</td>
			
			<td bgcolor="#FFFFFF">
			&nbsp; 
			<input type="button" value="查询用户"onclick="userQueryMana()" /> 
			<input type="button" value="个人中心"onclick="center()" />
			</td>
		</tr>
	</table>
</body>
</html>
