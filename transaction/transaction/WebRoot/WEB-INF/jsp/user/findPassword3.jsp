<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>找回密码第三步</title>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
 
	</head>
	<script type="text/javascript">
  function test()
  {
  	var emailCode=document.form.emailCode.value;
  	if(emailCode=="")
  	{
  		alert("邮箱验证码不能为空");
  		return false;
  	}
  	return true;
  }
  
  </script>
	<body style="background-color: 00ced1">
		<jsp:include page="../page/head.jsp"></jsp:include>
		<form onsubmit="return test()" name="form"
			action="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=findEmailCode&id=${user1.id}"
			method="post">
			<div class="container">
				<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="margin: 10% auto; width: 33%;">
						<div class="panel-heading">
							找回密码第三步
						</div>
						<div style="padding-left: 15%" class="panel-body">


							<div style="margin: 30px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">验证码:</span>
								<div style="width: 68%">
									<input type="text" name="emailCode" class="form-control"
										placeholder="验证码在邮箱里哦">
								</div>
							</div>

							<button style="width: 33%;" type="submit" title="下一步 "
								class="btn btn-primary">
								下&nbsp;&nbsp;一&nbsp;&nbsp;步
							</button>
							&nbsp;&nbsp;&nbsp;
							<font color="red" size=4>${message }</font>
							<br>
							<br>
							<br>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>
