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
  	  <div class="container" style="width: 95%">
		<div class="row">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">管理员权限更改页面</div>
				<div class="panel-body">
					<form target="main" action="${pageContext.request.contextPath}/servlet/AdminManager?actiontype=update&action=updateAdminManager&id=${list.id}" method="post">
						<table class="table table-bordered">
							<tr>
								<td>管&nbsp;&nbsp;理&nbsp;&nbsp;员:</td>
								<td>
								<input name="name" value="${list.name }"/>
								</td>
							</tr>
							<tr>
								<td>权限类型:</td>
								<td><input type="text" name="type" value="${list.type }"/></td>
							</tr>
							<tr>
								<td>个人描述:</td>
								<td><textarea rows="3" cols="80" name="description">${list.description }</textarea></td>
							</tr>
					   </table>
						<p>
							<input type="submit" class="btn btn-success" value="更&nbsp;&nbsp;改" />
						</p>
					</form>
				</div>
			</div>
		</div>
  	 </div>
  </body>
</html>
