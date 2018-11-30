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
		  		<div class="panel-heading">查看商品列表</div>
		 		<div class="panel-body">
					<table class="table table-bordered">
						<tr>
							
							<th>商品名</th>
						    <th>卖价</th>
							<th>原价</th>
							<th>描述</th>
							<th>图片</th>							
							<th>交易方式</th>						
						    <th>出产时间</th>
						  	<th>发布人</th>
					   </tr>
					   <c:forEach var="product" items="${product}">
					   <tr>
					       
		                   <td>${product.name}</td>
		                   <td>${product.price}</td>
						   <td>${product.originalprice}</td>
						   <td  style="width:150px;overflow:hidden;">${product.description}</td>
						   <td><img width=140px height=160px src="${product.uploadImage}"/></td>
						   <td>${product.trading}</td>						   
		                   <td>${product.createtime}</td>
		                   <td>${product.publisher}</td>
						    <td>
						    
							<a href="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=delete&id=${product.id}">[删除]</a>
					        <a href="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=update&id=${product.id}">[更新]</a>
							<a href="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=recommend&id=${product.id}">[推荐]</a>
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