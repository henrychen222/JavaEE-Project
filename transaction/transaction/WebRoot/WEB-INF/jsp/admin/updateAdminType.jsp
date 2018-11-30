<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
  <head>
    <title>index</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
  <body>
  	  <div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">管理员类型权限更新页面</div>
				<div class="panel-body">
					<form target="main" action="${pageContext.request.contextPath}/servlet/AdminTypeManager?actiontype=update" method="post">
						<table class="table table-bordered">
							<tr>
								<td>管理员类型:</td>
								<td><input name="name" value="${list.name }"/></td>
							</tr>
							<tr>
								<td>权限:</td>
								<td><input type="text" name="power" value="${list.power }"/></td>
							</tr>
							<tr>
								<td>描述:</td>
								<td><textarea rows="3" cols="80" name="description">${list.description }</textarea></td>
							</tr>
					   </table>
						<p>
							<input type="submit" class="btn btn-success" value="保&nbsp;&nbsp;存" />
						</p>
					</form>
				</div>
			</div>
		</div>
  	 </div>
  </body>
</html>
