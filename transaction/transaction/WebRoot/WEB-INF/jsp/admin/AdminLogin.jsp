<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
  <head>
    <title>Admin_Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
  <body style="background-image:url('${pageContext.request.contextPath }/images/#');background-color:016aa9">
  
	<div class="container">
	  <div class="row" style="opacity: 0.85;">
			<form class="form-horizontal" action="${pageContext.request.contextPath }/servlet/AdminIndexServlet?actiontype=actionLogin" method="post">
				<div class="panel panel-info" style=" margin:10% auto;width:33%;">
				 <div class="panel-heading">管理员入口</div>
				 <div style="padding-left: 15%" class="panel-body">
				   <div style=" margin:5% auto;" class="input-group input-group-sm">
					  <span class="input-group-addon">管理员：</span>
					  <div style="width:68%">
					  	<input type="text" name="name" class="form-control" placeholder="AdminName">
					  </div>
				   </div>
				   <div class="input-group input-group-sm">
					  <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
					  <div style="width:68%">
					  	<input type="password" name="password" class="form-control" placeholder="password">
					  </div>
				   </div>
				   <div class="checkbox">
					   <label>
					      <input type="checkbox">记住我
				        </label>
				   </div>
				   <div>
				   		<h5 style="color: red">${message }</h5>
				   </div>
				   <div>
				      <button style="width:36%" type="submit" class="btn btn-primary">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
				      <a href="">忘记密码？</a>
				   </div>
			  	 </div>
			  	</div>
			  </form>
		   </div>
	   </div>
  </body>
</html>
