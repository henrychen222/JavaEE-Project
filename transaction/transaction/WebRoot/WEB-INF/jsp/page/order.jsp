<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
  <head>
    <title>确认订单</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/order.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/js/holder.js"></script>
    <script type="text/javascript">
    	  $(document).ready(function(){ 
			$('.son_ul').hide(); //初始ul隐藏
			$('.select_box span').hover(function(){ //鼠标移动函数
			$(this).parent().find('ul.son_ul').slideDown();  //找到ul.son_ul显示
			$(this).parent().find('li').hover(function(){$(this).addClass('hover')},function(){$(this).removeClass('hover')}); //li的hover效果
			$(this).parent().hover(function(){},
		function(){
			$(this).parent().find("ul.son_ul").slideUp(); 
		});
	},function(){
	});
			$('ul.son_ul li').click(function(){
			$(this).parents('li').find('span').html($(this).html());
			$(this).parents('li').find('ul').slideUp();
			});
	});
    </script>
  </head>
    <body> 
      <jsp:include page="head.jsp"></jsp:include>
      <!--  body-top  start -->
  	  <div id="by-top">
  	  	 <div id="top-1">
  	  	 	<div id="logo" class="ld" >
  	  	 		<a href="${pageContext.request.contextPath }/servlet/IndexServlet" class="logo"title="点击返回首页"></a>
  	  	 	</div>
  	  	 	<div id="search">
  	  	 		<div class="search-from">
				  <form class="navbar-form navbar-left pull-left" action="${pageContext.request.contextPath }/servlet/SearchServlet" method="post" target="_blank" role="search">		  	  	 	
		             <div class="search-group">
					      <div class="form-group">
					        <input style="width:300px;height:34px;" class="search-input" name="search" type="text" placeholder="输入关键字搜索" autofocus=" " x-webkit-speech=" ">
					      </div>
					      <button type="submit" class="btn btn-success">搜&nbsp;&nbsp;索</button>
					</div>
				  </form>
			   </div>
  	  	 	</div>
			<c:if test="${user.username!=null}">
  	  	 	<div id="my-home">
  	  	 		<dl class="m-h">
					<dt class="m-h-center">
						
						<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=centerUI" target="_blank">我的商品</a>
					</dt>
				</dl>
  	  	 	</div>
  	  	 	<div id="shop-cat">
  	  	 		<dl class="s-c">
					<dt class="s-c-center">
						<s></s>
						<a href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=gotoCartUI" target="_blank"id="settleup-url">购物车</a> 
					</dt>
				</dl>
  	  	 	</div>
			</c:if>
  	  	 </div>
	  </div>
	  <!--  body-top  end -->
	  <form action="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=settleAccounts&productid=${order.productid}" method="post">
      <div id="order-1">
      	  <div id="order-top">
 				<h4 style="float:left;color: black">确认订单信息：</h4>     	  
      	  </div>
      	  <div id="order-left">
      	  	  <div class="ol-title">
	      	  	<strong style="float: left">宝贝信息：</strong>
      	  	  </div>
      	  	  <div class="ol-image">
      	  	  	<a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${order.productid}"target=_blank>
      	  	  		<img style="height: 180px;margin: 0px auto;"data-src="holder.js/100%x360/auto"class="img-responsive img-rounded" alt="图片" src="${order.imagepath }">
				</a>
      	  	  </div>
      	  	  <div id="ol-message">
      	  	  	<ul>
		            <li class="ol-li">
		                <label class="ol-lable">宝贝名称：</label>
		                <span class="ol-name">
		                    <a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${order.productid}"target=_blank>${order.productname}</a>
		                </span>
		            </li>
		            <li class="ol-li">
		                <label>宝贝单价：</label>
		                <span class="priceText">${order.amount }</span> 元
		                <input type="hidden" id="J_Price" name="amount" value="${order.amount }">
					</li>
                    <li class="ol-li">
		                <label>付款方式：</label>
		                <span style="color:#FF5500">支付宝</span>
		              <a href="http://www.alipay.com/" target="_blank">
		                    <img src="http://img.taobao.com/tps/i6/T1RUVmXmNrXXXXXXXX-16-16.gif" width="16" height="16" align="absmiddle" alt="该商品支持支付宝" border="0">
					  </a>
		           </li>
		            <li class="ol-li">
		                <label>所在地：</label>${order.address}
		            </li>
		            <li class="ol-li">
		                <label>卖家：</label>
		                <a href="#" target="_blank">${order.seller }</a>
		            </li>
    			</ul>
      	  	  </div>
      	  </div>
      	  <div id="order-right">
      	  	  <div class="or-top">
      	  	  	<h4 style="float:left;color: black;margin-top: 5px">收货人信息</h4> 
      	  	  </div>
      	  	  <div class="or-purchaser">
      	  	  	 <ul>
					<li class="ol-li">
						<small>请如实填写以保证您顺利收到货物</small>
					</li>
					<li class="ol-li">
						<label>收货人姓名：</label>
						<span>
							<em style="color: red;">*</em>
							<input type="text" name="purchaser" class="text J_Addressee" value="${ order.purchaser}">
						</span>
					</li>
					<li class="ol-li">
						<label >&nbsp;&nbsp;&nbsp;&nbsp;手机号码：</label>
						<span>&nbsp;&nbsp;
							<input type="text"  name="buyertetlphone"  value="${order.buyertetlphone }">
						</span>
					</li>
				</ul>
      	  	  </div>
      	  	  <div class="or-top">
      	  	  	<h4 style="float:left;color: black;margin-top: 5px">确认购买信息</h4> 
      	  	  </div>
      	  	  <div class="or-buymessage">
      	  	  	  <table id="trade-info">
					<colgroup><col width="85">
					<col width="*">
					</colgroup><tbody>
						<tr>
							<td class="first-col">购买数量：</td>
							<td>
								<span style="color: red;">*</span>
								1 件<span id="allowQuantity" allowquantity="1"></span>
							</td>
						</tr>
	                    <tr>
							<td class="first-col">给卖家留言：</td>
							<td>
								<div style="position:relative;display:inline-block;*display:inline;*zoom:1;"><textarea id="J_msgtosaler" tabindex="10" class="msgtosaler" name="explains" title="选填，可以告诉卖家您对商品的特殊要求，如：颜色、尺码等"></textarea></div>
	                        </td>
						</tr>
					</tbody>
	    	 	</table>
      	  	  </div>
      	  	  <div class="or-top">
      	  	  	<h4 style="float:left;color: black;margin-top: 5px">确认提交订单</h4> 
      	  	  </div>
      	  	  <ul>
      	  	    <li class="ol-li">
					<label >&nbsp;&nbsp;&nbsp;&nbsp;实付款：</label>
					<span style="color: red;">&nbsp;&nbsp;
						${order.amount }元
					</span>
				</li>
			 </ul>
      	  	  <button type="submit">确认订单</button>
      	  </div>
      </div>
      </form>
      <div id="order-2">
      
      
      </div>
      
      
    	<!--<div id="cart">
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
				    		<td style="text-align:center;" >${entry.value.product.price}</td>
				    		
				    		<td>
				    		<input type = "text" name="quantity" value="${entry.value.quantity}" style="width : 35px" onchange="changeQuantity(this,${entry.key },${entry.value.quantity})">
				    		</td>
				    		
				    		<td style="text-align:center;">${entry.value.price}</td>
				    		<td style="text-align:center; vertical-align:top; width: 100px">
				    			<a href="javascript:void(0)" onclick="deleteitem(${entry.key})">删除</a>    去掉超链接默认行为 
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
					<div class="col-md-1" ><a href="javascript:void(0)" onclick=clearcart()>删除</a></div>
					<div class="col-md-2 col-md-offset-7" ><h3 style="color: orange;font-weight: 0; line-height: 2;">合计：￥${cart.price }</h3></div>
					<div class="col-md-1" ><button class="btn btn-success"style="width:83px ;height: 47px;">结算</button></div>
				</div>
    		</div>
    	</div>
    --><hr>
    <jsp:include page="foot.jsp"></jsp:include> 
  	
  </body>
</html>
