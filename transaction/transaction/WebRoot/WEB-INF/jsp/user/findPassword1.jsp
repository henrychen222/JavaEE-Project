<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>找回密码第一步</title>
		<link rel="stylesheet"
		href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	</head>
	<script type="text/javascript">
	 
	 /**********************************************验证码**********************************************/
    function changeCheckCode(node){
				$(node).attr("src","${pageContext.request.contextPath }/checkcode.jsp?timestamp="+(new Date().getTime()));
  	  		}
  	/**********************************************验证码**********************************************/
  	
  function test()
  {
  	var username=document.form.username.value;
  	var checkcode=document.form.checkcode.value;
  	if(username=="")
  	{
  		alert("用户名不能为空");
  		return false;
  	}else
  	if(checkcode=="")
  	{
  		alert("验证码不能为空");
  		return false;
  	}
  	return true;
  }
  
  </script>
	<body style="background-color: 00ced1">
		<jsp:include page="../page/head.jsp"></jsp:include>
		<form onsubmit="return test()" name="form" action="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=findUsername" method="post">
			<div class="container">
				<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="margin: 10% auto; width: 30%;">
					   <div class="panel-heading">找回密码第一步</div>
						 <div style="padding-left: 15%" class="panel-body">
							<div style="margin: 10px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">&nbsp;&nbsp;用&nbsp;户&nbsp;名:</span>
								<div style="width: 68%">
									<input type="text" name="username" class="form-control"
										placeholder="用户名">
								</div>
								</div>
								
								 <!-------------------------------------------验证码--------------------------------------- -->
								<div  style="margin: 20px 0;">
								    <div style="width: 100%;">
								    <span >
								    	<img style="height:31px;width:20%;" onclick="changeCheckCode(this)" src="${pageContext.request.contextPath}/checkcode.jsp" >
										&nbsp;&nbsp;&nbsp;&nbsp;
										<input style="height:33px;width:50%;" type="text"  placeholder="验证码"	name="checkcode" >
									</span>
	                                </div>
	                             </div>
                              <!-------------------------------------------验证码--------------------------------------- -->
							
							
							<button  style="width: 36%;" type="submit"  title="下一步 " class="btn btn-primary">
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
