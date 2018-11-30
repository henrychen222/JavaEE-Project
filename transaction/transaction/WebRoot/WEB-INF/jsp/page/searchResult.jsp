<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>搜索结果</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/searchResult.css"/>
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
	  	  	function gotopage(currentpage){
 	  		var pagesize = document.getElementById("pagesize").value;
			var String = document.getElementById("String").value;
				if(pagesize>0&&currentpage>0){
	 	  			window.location.href = '${pageContext.request.contextPath}/servlet/SearchServlet?actiontype=searchpaging&search='+String+'&currentpage='+currentpage+'&pagesize='+pagesize; 
	 	  		}else{
	 	  			window.confirm("这填的数字要大于0哦！！");
	 	  		}	  	
 	  		}
  </script>
  </head>
  
  <body class="root">
  	<jsp:include page="head.jsp"></jsp:include> 
  	<!--  body-top  start -->
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
					        <input style="width:300px;height:34px;" class="search-input" name="search" type="text" placeholder="${String }" autofocus=" " x-webkit-speech=" ">
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
    	<div id="shop">
		  <div class="row">
			<c:forEach var="products" items="${requestScope.pagebean.list}" varStatus="status">
			<div id="panel">
				<div class="panel_image">
					<a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ products.id}" target=_blank >
						<img style="height: 150px;" class="img-responsive img-rounded" data-src="holder.js/100%x150/auto" title="${products.name }" src="${products.uploadImage }">
					</a>
			    </div>
				<div class="panel_data">
				   <div class="pd_left">
						<div class="pd_top">
							<div style="padding-left:10px; font-size:14px; float: left;">
								<a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ products.id}" target=_blank ><strong>${products.name }</strong></a>
							</div>
						</div>
						<div class="pd_price">
							<div style="padding-left:10px;">
								 <div style="float:left;">
									<span>
										<b style="font-size: 16px;color: gray;">¥</b>
										<em style="font-size: 20px;color: #ff7100;"><strong>${products.price }</strong></em>
									</span>
								 </div>
				            </div>
						</div>
						<div class="pd_description">
							<p style="padding-left:10px; text-align: left;">${products.description }</p>
						</div>
						<div class="pd_bottom">
							<div style="width: 150px;height:30px;line-height: 30px; padding-left:10px;float: left;">
								<strong>${products.createtime }</strong>
							</div>
							<div style="width: 360px;height:30px;line-height: 30px;text-align:center; float: right;">
								<a href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=collect&id=${products.id }">收藏&nbsp;<em class="number">0</em></a>
							</div>
						</div>
					</div>
					<div class="pd_right">
					  	
					</div>		
				</div>
			   </div>
		  	  </c:forEach>
	    	 </div>	
			<div class="main paging_algin">
				<div class="paging">
				  <span>
				  	共[&nbsp;${pagebean.totalrecord }&nbsp;]条记录,
				   	每页<input type="text" id="pagesize" value="${pagebean.pagesize }" onchange="gotopage(${pagebean.currentpage })" style="width:30px" maxlength="2">条,
				   	共[&nbsp;${pagebean.totalpage }&nbsp;]页,
					当前[<font color="red">&nbsp;${pagebean.currentpage }&nbsp;</font>]页
				  </span>&nbsp;&nbsp;   
				    <a href="javascript:void(o)" onclick="gotopage(${pagebean.previouspage})">上一页</a>
					<c:forEach var="pagenum" items="${pagebean.pagebar}">
						<c:if test="${pagenum==pagebean.currentpage}">
							<span class="a_this">${pagenum}</span>
						</c:if>
						<c:if test="${pagenum!=pagebean.currentpage}">
							<a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum }</a>
						</c:if>
					</c:forEach>
				    <a href="javascript:void(0)" onclick="gotopage(${pagebean.nextpage})">下一页</a>
				    <span>
				    	跳转至      
					    <input type = "text" id = "pagenum" style="width:30px"maxlength="2">&nbsp;页
					    <input type = "button" value = "GO" onclick = "gotopage(document.getElementById('pagenum').value)">
					    <input type="hidden"id="String"value="${String}">
				    </span> 
			    </div>
		    </div>      	
	  	</div>
    	<hr>
    <jsp:include page="foot.jsp"></jsp:include> 
  </body>
</html>
