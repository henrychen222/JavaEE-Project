<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
  <head>
    <title>top</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
  <style>
	body {
		padding-top: 0px;
		background:#ACE0B8;
	}
  </style>
  <script type="text/javascript">
  	function Exit(){
  		window.location.href="${pageContext.request.contextPath }/servlet/AdminIndexServlet?actiontype=actionLogExit";
  		alert("您确认安全退出吗？");
  	}
  </script>
  <body>
   	<h4 style="text-align:center;">商品互换市场后台管理系统</h4>
   	<a href="${pageContext.request.contextPath }/servlet/IndexServlet" target="_top">返回首页&nbsp;&nbsp;</a>
   	<a href="${pageContext.request.contextPath }/servlet/AdminIndexServlet?actiontype=actionLogExit" target="_top">安全退出</a>
  </body>
</html>
