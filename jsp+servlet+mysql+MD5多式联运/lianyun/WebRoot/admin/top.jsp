<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<LINK href="<%=path %>/css/admin.css" type="text/css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #4771dd;
	font-size: 12px;
}
-->
</style>
	</head>

	<body>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" 
background="<%=path %>/images/header_bg.jpg" border=0>
  <TR height=56>
    <TD width=260><IMG height=56 src="<%=path %>/images/header_left.jpg" 
    width=260></TD>
    <TD style="FONT-WEIGHT: bold; COLOR: #fff; PADDING-TOP: 20px" 
      align=middle>当前用户：${admin.userName} &nbsp;&nbsp;  <A style="COLOR: #fff" 
      onclick="if (confirm('确定要退出吗？')) return true; else return false;" 
      href="<%=path %>/login.jsp" target=_top>退出系统</A> 
      
      &nbsp;&nbsp; 日期：<script>document.write(Date())</script>
    </TD>
    <TD align=right width=268><IMG height=56 
      src="<%=path %>/images/header_right.jpg" width=268></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TR bgColor=#1c5db6 height=4>
    <TD></TD></TR></TABLE>
	</body>
</html>
