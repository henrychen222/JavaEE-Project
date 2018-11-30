<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>showAdmins</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
  <body>
     <div class="container" style="width: 95%">
     	<div class="row">
			<div class="panel panel-primary">
		  		<div class="panel-heading">管理员权限查看页面</div>
		 		<div class="panel-body">
					<table class="table table-bordered">
						<tr>
							<th>管&nbsp;&nbsp;理&nbsp;&nbsp;员</th>
							<th>权&nbsp;&nbsp;&nbsp;&nbsp;限</th>
						    <th>权限描述</th>
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
						    <a href="${pageContext.request.contextPath }/servlet/AdminManager?actiontype=findAdmin&action=updateAdminManager&id=${list.id}">[更改权限]</a>
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
