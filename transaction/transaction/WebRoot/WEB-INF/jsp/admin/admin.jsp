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
				<div class="panel-heading">添加管理员页面</div>
				<div class="panel-body">
					<form target="main" action="${pageContext.request.contextPath}/servlet/AdminManager?actiontype=addAdmin" method="post">
						<table class="table table-bordered">
							<tr>
								<td>管&nbsp;&nbsp;理&nbsp;&nbsp;员：</td>
								<td><input type="text" name="name" /></td>
							</tr>
							<tr>
								<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td>权限类型：</td>
								<td><input type="text" name="type" /></td>
							</tr>
							<tr>
								<td>描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</td>
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
		  		<div class="panel-heading">管理员查看页面</div>
		 		<div class="panel-body">
					<table class="table table-bordered">
						<tr>
							<th>管&nbsp;&nbsp;理&nbsp;&nbsp;员</th>
							<th>权限类型</th>
						    <th>个人描述</th>
						    <th>更新时间</th>
						    <th>创建时间</th>
						  	<th>操&nbsp;&nbsp;&nbsp;&nbsp;作</th>
					   </tr>
					   <c:forEach var="list" items="${list}">
					   <tr>
					   	   <td>${list.name }</td>
						   <td>${list.type }</td>
						   <td>${list.description }</td>
						   <td>${list.updatetime }</td>
						   <td>${list.createtime }</td>
						   <td> 
							<a href="${pageContext.request.contextPath }/servlet/AdminManager?actiontype=findAdmin&action=updateAdmin&id=${list.id}">[修&nbsp;&nbsp;改]</a>
							<a href="${pageContext.request.contextPath }/servlet/AdminManager?actiontype=delete&id=${list.id}">[删&nbsp;&nbsp;除]</a>
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
