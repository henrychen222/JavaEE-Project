<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户注册</title>
		<link rel="stylesheet"
		href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	</head>
    <script >
     
    /**********************************************验证码**********************************************/
    function changeCheckCode(node){
				$(node).attr("src","${pageContext.request.contextPath }/checkcode.jsp?timestamp="+(new Date().getTime()));
  	  		}
  	/**********************************************验证码**********************************************/
  	
  	
  	
function test(){
		var username=document.form.username.value;
		var password=document.form.password.value;
		var password2=document.form.password2.value;

		if(username=="")
		{
			alert("用户名长度为2到12位");
			return false;
		}else
		
		if(username.length>12||username.length<2)
		{
			alert("用户名长度为2到12位");
			return false;
		}
		else
		if(password=="")
		{
			alert("密码由6-16个字母,数字,字符组成");
			return false;
		}else
		
		if(password.length>16||password.length<6)
		{
			alert("密码由6-16个字母,数字,字符组成");
			return false;
		}
		else
			if(!(password2==password))
			{
				alert("两次密码不一致");
				return false;
			}


			return true;
}
</script>
<body style="background-color:00ced1">
	<jsp:include page="../page/head.jsp"></jsp:include>
		<form onsubmit="return test()" name="form"
			action="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=register" method="post">						
				
				<div class="container">
					<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="margin: 10% auto; width: 33%;">
						<div class="panel-heading">用户注册</div>
						<div style="padding-left: 15%" class="panel-body">
						
							<div style="margin: 10px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">&nbsp;&nbsp;用&nbsp;户&nbsp;名:</span>
								<div style="width: 68%">
									<input type="text" name="username" class="form-control"
										placeholder="用户名">
								</div>
							</div>
							
							<div style="margin: 20px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
								<div style="width: 68%">
									<input type="password" class="form-control" placeholder="密码" name="password2" >
								</div>
							</div>
							
                            <div class="input-group input-group-sm">
								<span class="input-group-addon">确认密码:</span>
								<div style="width: 68%;">
									<input type="password" class="form-control" placeholder="确认密码"	name="password" >
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
                             
							<button  style="width: 36%;" type="submit"  title="注册 " class="btn btn-primary">
									注&nbsp;&nbsp;&nbsp;&nbsp;册
								</button>
								<font color="red" size=4>${message }</font>
						</div>
					</div>
				</div>
		</div>
				
				</form>
			
	</body>
</html>