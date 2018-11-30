<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE>
<html>
  <head>
    <title>二手跳蚤-宝贝发布</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
  <body style="background-color: 00ced1">
   <jsp:include page="../page/head.jsp"></jsp:include>
    
	  <form  action="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=updateproduct&id=${product.id}" method="post">
	  <div class="container">
				<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="margin: 5% auto; width: 45%;">
						<div class="panel-heading">宝贝发布</div>
						<div style="padding-left: 5%" class="panel-body">
							<div style="margin: 15px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">&nbsp;&nbsp;&nbsp;标题:&nbsp;&nbsp;&nbsp;</span>
								<div style="width: 75%">
									<input type="text" name="name" class="form-control" value="${product.name}"
										placeholder="标题">
								</div>
							</div>
							
							<div style="margin: 15px 0;" class="input-group">
									<span class="input-group-addon">价格：</span>
									<div style="width:33%">
									<input type="text" name="price" class="form-control" value="${product.price}" placeholder="卖价">
									
									</div>
							</div>
							
							
														<div style="margin: 15px 0;">
							<button type="submit" class="btn btn-success">更新</button>
							</div>
						</div>
					</div>
				</div>
			</div>
	  </form>
  </body>
</html>
