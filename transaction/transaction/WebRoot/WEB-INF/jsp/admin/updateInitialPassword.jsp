<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
  <head>
    <title>updatePassword</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
  <body>
  	  <div class="container" style="width: 33%">
		<div class="row">
			<div class="panel panel-primary"style=" margin:20% auto;">
				<!-- Default panel contents -->
				<div class="panel-heading">管理员密码重置页面</div>
				<div class="panel-body" style="margin:0px 20px 0px 20px;">
					<form target="main" action="${pageContext.request.contextPath}/servlet/AdminManager?actiontype=updateInitialPassword&name=${name}" method="post">
						<div class="input-group">
						  <span>原始密码：</span>
						  <input type="password" name="password" class="form-control" placeholder="请输入原始密码">
						</div>
						<div class="input-group">
						  <span>新&nbsp;&nbsp;密&nbsp;&nbsp;码：</span>
						  <input type="password" name="password1" class="form-control" placeholder="请输入新密码">
						</div>
						<div class="input-group">
						  <span>确认密码：</span>
						  <input type="password" name="password2" class="form-control" placeholder="再次输入新密码">
						</div>
						<p style="color: red;">${message}</p>
						<div style="margin-top: 10px">
							<button style="width:30%" type="submit" class="btn btn-success">保&nbsp;&nbsp;&nbsp;&nbsp;存</button>
							<button style="width:30%" type="reset" class="btn btn-warning">取&nbsp;&nbsp;&nbsp;&nbsp;消</button>
						</div>
					</form>
				</div>
			</div>
		</div>
  	 </div>
  </body>
</html>
