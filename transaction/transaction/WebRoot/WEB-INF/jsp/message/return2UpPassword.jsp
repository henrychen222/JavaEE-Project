<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>自动跳转页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
	<script type="text/javascript">
		function countDown(secs) {
		  document.getElementById("jump").innerHTML = secs;
		  	if (--secs > 0){
		   		setTimeout("countDown(" + secs + " )", 1000);
		   }else{
		    	window.location.replace("${pageContext.request.contextPath }/servlet/AdminManager?actiontype=updatePasswordUI&action=firstChange&name=${name}"); 
		   }
		 }
	</script>
	
	<body onload="javascript:countDown(2);">
		<div style="margin:100px auto;" class="container" >
			<h1 style="color: red;">${message }</h1>
			<font color="red" size="5"><span id="jump"></span></font> 
			<font size="5">秒钟后将自动跳转到密码修改页面......</font>
			您还可以点击<a href="${pageContext.request.contextPath }/servlet/AdminManager?actiontype=updatePasswordUI&action=firstChange&name=${name}"><font color="green" size="5">重置密码</font></a>进行跳转。
		</div>
	</body> 
</html>
