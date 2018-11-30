<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="java.util.ArrayList"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
    String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<title>首页</title>
  <head>  

  </head>
  
  <body>
		<a href="${pageContext.request.contextPath}">注册</a>
		<jsp:forward page="/WEB-INF/jsp/userReg.jsp"></jsp:forward>


		
  </body>
</html>
