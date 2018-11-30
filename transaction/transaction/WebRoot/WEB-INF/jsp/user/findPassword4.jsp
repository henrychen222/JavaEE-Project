<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>找回密码第四步</title>
    <link rel="stylesheet"
		href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	 
  </head>
  <script type="text/javascript">
  function test()
  {
  	var password=document.form.password.value;
  	var password2=document.form.password2.value;
  	if(password=="")
  	{
  		alert("密码不能为空");
  		return false;
  	}else
  	if(password2!=password)
  	{
  		alert("两次密码不一致");
  		return false;
  	}else
  	if(password.length>16||password.length<6)
		{
			alert("密码长度为6到16位");
			return false;
		}
  	return true;
  }
  
  </script>
  <body style="background-color: 00ced1">
  	<jsp:include page="../page/head.jsp"></jsp:include>
  	<form onsubmit="return test()" name="form"  action="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=updatePassword2&id=${user1.id}" method="post">
		<div class="container">
				<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="margin: 10% auto; width: 30%;">
						<div class="panel-heading">
							找回密码第四步
						</div>
						<div style="padding-left: 15%" class="panel-body">
						
						<div style="margin: 30px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">新&nbsp;&nbsp;密&nbsp;&nbsp;码:</span>
								<div style="width: 68%">
									<input type="password" name="password" class="form-control"
										placeholder="长度6到16位哦">
								</div>
						</div>
						<div style="margin: 30px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">确认密码:</span>
								<div style="width: 68%">
									<input type="password" name="password2" class="form-control"
										placeholder="长度6到16位哦">
								</div>
						</div>
						
						<button style="width: 33%;" type="submit" title="下一步 "
								class="btn btn-primary">
								下&nbsp;&nbsp;一&nbsp;&nbsp;步
							</button>
					</div>
				</div>
			</div>
		</div>		
		

    </form>
  </body>
</html>
