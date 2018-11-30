<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<script type="text/javascript">
		function deleteitem(id)
		{
			var b = window.confirm("亲，您不想要我了吗？");
			
			if(b)
				window.location.href="${pageContext.request.contextPath}/servlet/businessServlet?actiontype=delete&id="+id;
		}

		function clearcart()
		{
			var b = window.confirm("亲，您确认要清空购物车吗？");
			if(b)
				window.location.href="${pageContext.request.contextPath}/servlet/businessServlet?actiontype=clearcart";
		}
		/*	
		function changeQuantity(input,id,oldvalue)
		{
			var quantity = input.value;
			if(quantity<0 || quantity != parseInt(quantity))
			{
				alert("请输入正整数！");
				input.value = oldvalue;
				return;	
			}
			var b = window.confirm("亲，您确认要修改其数量为："+quantity);
			if(b)
				window.location.href="${pageContext.request.contextPath}/servlet/ChangeQuantityServlet?id="+id+"&quantity="+quantity;
		}*/
	</script>
  <head>
    <title>购物车</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/cart.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
    <body style="text-align:center"> 
      <jsp:include page="head.jsp"></jsp:include>
    	<div id="cart">
		    <div class="row">
				<div class="col-md-1" >    
				  <div class="checkbox">
					<label><input type="checkbox">
				    </label>
				  </div>
				     全选
				</div>
				<div class="col-md-6" >商品信息</div>
				<div class="col-md-2" >原价（元）</div>
				<div class="col-md-2" >一口价（元）</div>
				<div class="col-md-1" >操作</div>
			</div>
			<c:if test="${empty(cart.map)}">
    		<h2 style="color: red;">亲，您还没购买任何商品哟！！！</h2>
    		</c:if>
    		<div id="cart_body">
    			<c:if test="${!empty(cart.map)}">
    			<table class="table table-hover">
 					<c:forEach var="entry" items="${cart.map}">
			    		<tr style="height: 128px">
			    			<td style="width: 50px">
			    				<div class="checkbox">
									<label><input type="checkbox">
				    				</label>
				  				</div>
			    			</td> 
				    		<td style="width: 120px;height: 120px"> <a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ entry.value.product.id}"target=_blank"><img style="width: 120px;height: 120px" src="${entry.value.product.uploadImage}" alt="${entry.value.product.uploadImage}"></a></td>
				    		<td style="vertical-align:top;"><a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ entry.value.product.id}"target=_blank">${entry.value.product.name}</a></td>
				    		<td style="text-align:left;" >${entry.value.product.price}</td>
				    		<!--
				    		<td>
				    		<input type = "text" name="quantity" value="${entry.value.quantity}" style="width : 35px"  onchange="changeQuantity(this,${entry.key },${entry.value.quantity})">
				    		</td>
				    		-->
				    		<td style="text-align:center;">${entry.value.price}</td>
				    		<td style="text-align:center; vertical-align:top; width: 100px">
				    			<a href="javascript:void(0)" onclick="deleteitem(${entry.key})">删除</a>   <!-- 去掉超链接默认行为 -->
				    		</td>
			    		</tr>
			    		
			    	</c:forEach>
				</table>
			  	</c:if>
    		</div>
    		<div id="cart_bottom">
    			<div class="row">
					<div class="col-md-1" >    
					  <div class="checkbox">
						<label><input type="checkbox">
					    </label>
					  </div>
					     全选
					</div>
					<div class="col-md-1" ><a href="javascript:void(0)" onclick="clearcart()">   删除</a></div>
					<div class="col-md-2 col-md-offset-7" ><h3 style="color: orange;font-weight: 0; line-height: 2;">合计：￥${cart.price }</h3></div>
					<div class="col-md-1" ><button class="btn btn-success"style="width:83px ;height: 47px;">结算</button></div>
				</div>
    		</div>
    	</div>
    <hr>
    <jsp:include page="foot.jsp"></jsp:include> 
  	
  </body>
</html>
