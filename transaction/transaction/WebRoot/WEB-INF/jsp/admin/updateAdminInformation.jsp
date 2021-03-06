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
				<div class="panel-heading">管理员详细资料页面</div>
				<div class="panel-body">
					<form target="main" action="${pageContext.request.contextPath}/servlet/AdminManager?actiontype=update&action=updateAdminInformation&id=${list.id}" method="post">
						<table class="table table-bordered">
							<tr>
								<td>管&nbsp;&nbsp;理&nbsp;&nbsp;员:</td>
								<td><input class="col-xs-2"type="text" name="name" value="${list.name }"></td>
							</tr>
							<tr>
								<td>权限类型:</td>
								<td><input class="col-xs-2" id="disabledInput" type="text" name="type" value="${list.type }" disabled></td>
							</tr>
							<tr>
								<td>个人描述:</td>
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
