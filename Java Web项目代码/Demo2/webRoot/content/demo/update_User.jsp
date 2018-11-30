<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/common/bootstrap/css/bootstrap.min.css" rel="stylesheet"  type="text/css"></link>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/js/libs/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/bootstrap/js/bootstrap-paginator.min.js"></script>
<title>添加用户</title>


</head>
<body>
	<div>
		<div id="page-top" style="float: left;">
			<div id="pt-1">
				<div class="crumbs">
					<em class="crumbs-title">您的位置：</em> <a href="#" class="crumbs-nav">后台管理</a>
					<span class="pipe-gt">&gt;</span> <a
						href="${pageContext.request.contextPath }/user/demo_User.do"
						class="crumbs-nav">用户管理</a>
				</div>
			</div>
		</div>
		<div id="toolBar" region="north"
			style="padding-top: 10px; text-align: left; padding-left: 20px; padding-bottom: 10px; border: 0px solid;">
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">修改用户</div>
			<div class="panel-body">
				<form class="form"
					action="${pageContext.request.contextPath}/user/update.do?id=${user.id}"
					method="post">
					<table class="table table-bordered">
						<tr>
							<div>
								<td><label for="user_name" class="control-label">用户姓名：</label>
								</td>
								<td>
									<div>
										<input type="text" class="form-control" name="user_name"
											id="user_name" placeholder="用户姓名" value="${user.userName}">
									</div>
								</td>
							</div>
						</tr>
						<tr>
							<div class="form-group">
								<td><label for="password" class="control-label">密码：</label></td>
								<td>
									<div>
										<input type="text" class="form-control" name="password"
											id="password" placeholder="密码" value="${user.password}">
									</div>
								</td>
							</div>
						</tr>
						<tr>
							<div class="form-group">
								<td><label for="age" class="control-label">年龄：</label></td>
								<td>
									<div>
										<input type="text" class="form-control" name="age"
											id="age" placeholder="年龄" value="${user.age}">
									</div>
								</td>
							</div>
						</tr>
						<tr>
							<div>
								<td></td>
								<td>
									<button type="submit" class="btn btn-default">保&nbsp;&nbsp;存</button>
								</td>
							</div>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>