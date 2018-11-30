<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新跳转</title>
    
	
  </head>
  
  <body>
   			<h1 style="color: red;">${message }</h1>
		<script>
<%
response.setHeader("refresh", "1;url=UpdateUI");
%>
</script>
  </body>
</html>
