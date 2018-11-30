<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${product.name }</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/productsList.css"/>
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
		<div id="body-top">
  	  	 <div id="top-1">
  	  	 	<div id="logo" class="ld" >
  	  	 		<a href="${pageContext.request.contextPath }/servlet/IndexServlet" class="logo"title="点击返回首页"></a>
  	  	 	</div>
  	  	 	<div id="search">
  	  	 		<div class="search-from">
				  <form class="navbar-form navbar-left pull-left" action="${pageContext.request.contextPath }/servlet/SearchServlet?actiontype=search" method="post" target="_blank" role="search">		  	  	 	
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
  	  	 <div id="top-2">
  	  	 	<div id="navigation">
  	  	 		<div id="shop_sort">
				<a data-toggle="modal" data-target="#myModal"><h4>热门二手分类<b></b></h4></a>
  	  	 		</div>
  	  	 		<div id="n-right">
					<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=publishGoodsUI&id=${user.id}"target="_blank"class="btn btn-success" >发布宝贝</a>
					<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listproduct"target="_blank"class="btn btn-success">我的闲置</a>
				</div>
  	  	 		<ul id="navitem">
				</ul>
  	  	 	</div>
  	  	 </div>
	  </div>
	<!--  body-top  end -->
		<div id="sh-product">
			<div id="sh-top">
				<ul>
					<li class="sh-li">卖&nbsp;家&nbsp;ID<br/><a href="#">${product.publisher}</a></li>					
					<li class="sh-li">总浏览次数<br/>${product.clickcount}</li>					
					<li class="sh-li">最后编辑<br/>${product.updatetime}</li>					
				</ul>
			</div>
			<div id="sh-body">
				<div id="sh-image">
					<img style="height: 360px;margin: 0px auto;"data-src="holder.js/100%x360/auto"class="img-responsive img-rounded" alt="图片" src="${product.uploadImage }">
				</div>
				<div class="sh-right">
					<div style="width: 560px;">
						<div style="width: 560px;margin-top:10px;font-size: 18px;">
							<p style="padding-left:10px; text-align: left;"><strong>${product.name}</strong></p>
						</div>
						<ul style="margin-top:10px; font-size: 16px;">
						    <li style="padding-left:10px;margin-top:10px; text-align: left;">
						        <span>转&nbsp;&nbsp;卖&nbsp;&nbsp;价:</span>
						        <span style="font-size: 20px;"><b>¥</b><em style="color: #ff7100;"><strong>${product.price }</strong></em></span>
						    </li>
							<li style="padding-left:10px;margin-top:10px; text-align: left;">
						        <span>原&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价:</span>
						        <b>¥</b><span>${product.originalprice }</span>
						    </li>
						</ul>
					    <ul style="margin-top:10px; font-size: 16px;">
					        <li style="padding-left:10px;margin-top:10px; text-align: left;">
					            <span class="para">所&nbsp;&nbsp;在&nbsp;&nbsp;地:</span>
					            <em>${product.address}</em>
					        </li>
							<li style="padding-left:10px;margin-top:10px; text-align: left;">
					            <span class="para">联系方式:</span>
					    		<span>${product.realname }</span>    			    				
					    		<span class="contact-phone">
					            	<span class="contact-phone-elli">${product.phone }</span>
					            </span>
					        </li>
					        <li style="padding-left:10px;margin-top:10px; text-align: left;">
					            <span class="para">交易方式:</span>
					    		<a href="#"><span data-term="1" class="J_Term term">见面交易</span><i></i></a>
					    		<a href="#"><span data-term="0" class="J_Term term">在线交易</span><i></i></a>
					    	</li>
						</ul>
					</div>
					<div style="padding-left:10px;margin-top:20px; text-align: left;">
						<font color="red" >${messageC}</font>
						<a class="btn btn-primary btn-sm active" role="button" href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=collect&id=${product.id }">收藏</a>	
						<a class="btn btn-primary btn-sm active" role="button" href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=confirmOrder&id=${product.id }">购买</a>	
						<a class="btn btn-primary btn-sm active" role="button" href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=addShopCar&id=${product.id }">加入购物车</a>	
					</div>
				</div>	
			</div>
		</div>
	<hr>
    <jsp:include page="foot.jsp"></jsp:include> 
     <!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
		      </div>
		      <div class="modal-body">
		        ...
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div>
		  </div>
		</div>
  </body>
</html>
