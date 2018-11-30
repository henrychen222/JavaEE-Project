<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>自动跳转到修改密码页面</title>
    

  </head>
  
  <body>
 
			<h1 style="color: red;">${message }</h1>
		<script>
<%
response.setHeader("refresh", "1;url=UserUpPasUI");
%>
</script>
<!--跳转到修改密码页面-->
<!--跳转到修改密码页面-->
<!--跳转到修改密码页面-->
<!--跳转到修改密码页面-->
  </body>
</html>
