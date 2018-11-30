<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户登录后跳转到发布页面</title>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	</head>
	<script type="text/javascript">
  function test()
  {
  
  	var username=document.form.username.value;
  	var password=document.form.password.value;
  	if(username=="")
  	{
  		alert("用户名不能为空");
  		return false;
  	}else
  	if(password=="")
  	{
  		alert("密码不能为空");
  		return false;
  	}
  	return true;
  }
  
  </script>

	<body style="background-color: 00ced1">
		<jsp:include page="../page/head.jsp"></jsp:include>
		<form name="form"
			action="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=login3" onsubmit="return test()" method="post">
			<div class="container">
				<div class="row" style="opacity: 0.85;">
				
					<div class="panel panel-info" style="margin: 10% auto; width: 33%;">
						<div class="panel-heading">用户登录</div>
						<div style="padding-left: 15%" class="panel-body">
						<font color="red" size=3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${message }</font>
							<div style="margin: 20px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">用户名:</span>
								<div style="width: 68%">
									<input type="text" name="username" class="form-control"
										placeholder="用户名">
								</div>
							</div>


							<div style="margin: 30px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
								<div style="width: 68%">
									<input type="password" class="form-control" placeholder="密码" name="password">
								</div>
							</div>

							<br />
							<button style="width: 36%;" type="submit" title="登录 "
								class="btn btn-primary">
								登&nbsp;&nbsp;&nbsp;&nbsp;录
							</button>
						&nbsp;&nbsp;
							<a
								href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=findPasswordUI"
								title="找回密码"><font color="#5CB85C" size="4">忘记密码?</font>
							</a>
							<div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</form>

	</body>
</html>
