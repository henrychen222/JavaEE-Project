<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>找回密码第二步</title>
 	<link rel="stylesheet"
		href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	 
  </head>
    <script type="text/javascript">
    
    		
		  function test()
		  {
		  	var email=document.form.email.value;
		  	var realname=document.form.realname.value;
		  	if(email=="")
		  	{
		  		alert("邮箱不能为空");
		  		return false;
		  	}else
		  	if(realname=="")
		  	{
		  		alert("真实姓名不能为空");
		  		return false;
		  	}
		  	return true;
		  }
  
  </script>
  <body  style="background-color: 00ced1">
  	<jsp:include page="../page/head.jsp"></jsp:include>
  	<form onsubmit="return test()" name="form" action="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=findEmail&username=${user1.username }" method="post">
  		<div class="container">
				<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="margin: 10% auto; width: 33%;">
					   <div class="panel-heading">找回密码第二步</div>
						 <div style="padding-left: 15%" class="panel-body">
							 
							 
							 <div style="margin: 10px 0;" class="input-group input-group-sm">
									<span class="input-group-addon">验证邮箱:</span>
									<div style="width: 72%">
										<input type="text" name="email" class="form-control"
											placeholder="请填写你绑定的邮箱号">
									</div>
								</div>
								
							 	<div style="margin: 30px 0;" class="input-group input-group-sm">
									<span class="input-group-addon">真实姓名:</span>
									<div style="width: 72%">
										<input type="text" name="realname" class="form-control"
											placeholder="请填写你的真实姓名">
									</div>
								</div>
								
								<button  style="width: 30%;" type="submit"  title="下一步 " class="btn btn-primary">
									下&nbsp;&nbsp;一&nbsp;&nbsp;步
								</button>
								&nbsp;&nbsp;&nbsp;<font color="red" size=4>${message }</font>
							
							</div>
						</div>
					</div>
				</div>
  	</form>
  </body>
</html>
