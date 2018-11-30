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
				<div class="panel-heading">管理员权限类型添加页面</div>
				<div class="panel-body">
					<form target="main" action="${pageContext.request.contextPath}/servlet/AdminTypeManager?actiontype=addManagerType" method="post">
						<table class="table table-bordered">
							<tr>
								<td>权限类型：</td>
								<td><input type="text" name="name" /></td>
							</tr>
							<tr>
								<td>权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：</td>
								<td><input type="text" name="power" /></td>
							</tr>
							<tr>
								<td>权限描述：</td>
								<td><textarea rows="3" cols="80" name="description"></textarea></td>
							</tr>
						</table>
						<p>
							<input type="submit" class="btn btn-success" value="保&nbsp;&nbsp;存" />
						</p>
					</form>
				</div>
			</div>
		</div>
  
  		<div class="row">
			<div class="panel panel-primary">
		  		<div class="panel-heading">查看管理员类型页面</div>
		 		<div class="panel-body">
					<table class="table table-bordered">
						<tr>
							<th>权限类型</th>
							<th>权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限</th>
						    <th>权限描述</th>
						    <th>更新时间</th>
						    <th>创建时间</th>
						  	<th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
					   </tr>
					   <c:forEach var="list" items="${list}">
					   <tr>
					   	   <td>${list.name }</td>
						   <td>${list.power }</td>
						   <td>${list.description }</td>
						   <td>${list.updatetime }</td>
						   <td>${list.createtime }</td>
						   <td> 
						    <a href="${pageContext.request.contextPath }/servlet/AdminTypeManager?actiontype=findAdminType&name=${list.name}">[修&nbsp;&nbsp;改]</a>
							<a href="${pageContext.request.contextPath }/servlet/AdminTypeManager?actiontype=delete&name=${list.name}">[删&nbsp;&nbsp;除]</a>
							</td>
					   </tr>
					   </c:forEach>
					  </table>
				</div>
      		</div>
		</div>
  	 </div>
  </body>
</html>
