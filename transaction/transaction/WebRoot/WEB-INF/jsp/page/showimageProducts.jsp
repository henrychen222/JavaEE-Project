<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品互换市场-${title}</title>
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
	  	  	function gotopage(currentpage){
 	  		var pagesize = document.getElementById("pagesize").value;
			var url = document.getElementById("url").value;
			var  st = document.getElementById("st").value;
				if(pagesize>0&&currentpage>0){
	 	  			window.location.href = '${pageContext.request.contextPath}/servlet/PageAction?'+url+'&style='+st+'&currentpage='+currentpage+'&pagesize='+pagesize; 
	 	  		}else{
	 	  			window.confirm("这填的数字要大于0哦！！");
	 	  		}	  	
 	  		}
    </script>
  </head>
  
  <body>
	<jsp:include page="head.jsp"></jsp:include>
		<div id="body-top">
  	  	 <div id="top-1">
  	  	 	<div id="logo" class="ld" >
  	  	 		<a href="${pageContext.request.contextPath }/servlet/IndexServlet" class="logo" title="点击返回首页"></a>
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
					<H4>热门二手分类<b></b></H4>
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
	<div id="page">
		<div id="page-top">
			<div id="pt-1">
				<div class="crumbs">
        			<em class="crumbs-title">个人闲置：</em>
					<a href="${pageContext.request.contextPath }/servlet/PageAction?${OneLevelUrl}&style=${style}" class="crumbs-nav">${title}</a>
					<c:if test="${title2!=''}">
						<span class="pipe-gt">&gt;</span>
						<a href="${pageContext.request.contextPath }/servlet/PageAction?${SecondLevelUrl}&style=${style}" class="crumbs-nav">${title2 }</a>
					</c:if>
					<c:if test="${title3!=''}">
						<span class="pipe-gt">&gt;</span>
						<span class="cur-category">${title3 }<em class="cur-num"></em></span>
					</c:if>
					
		    	</div>
			</div>
			<c:if test="${not empty type}">
			<div id="pt-2">
				<div style="float: left;width: 1000px;margin: 2px 0px 0px 10px;">
					<div class="category-list">
                        <ul class="category-show">
                        	<c:forEach var="type" items="${type}" varStatus="status">
        					<li style="margin-right:30px;float:left;">
                               <a href="${pageContext.request.contextPath }/servlet/PageAction?${URL2 }&id=${type.id }&style=${style}" title="${type.name }">${type.name }</a>
                               <span>(${type.amount})</span>
                            </li>
                            </c:forEach>
        				</ul>
    				</div>
    			</div>
			</div>
			</c:if>
			<div style="width: 1000px;height: 25px;margin: 0px auto;">
    			<div style="width: 100px;height: 20px;padding-top:3px;float: right;">
    			 	<div style="margin: 0px auto;">
    			 		<c:if test="${style=='imagetext'}"><strong><em style="color: #ff7100">图文版</em></strong></c:if>
    			 		<c:if test="${style!='imagetext'}">
			      			<a style="color: 3DAC28;" title="点击切换到列表模式"href="${pageContext.request.contextPath }/servlet/PageAction?${URL }&style=imagetext">图文版</a>
			      		</c:if> |
			      		<c:if test="${style=='imagetext'}">
			      			<a style="color: 3DAC28;" title="点击切换到大图模式"href="${pageContext.request.contextPath }/servlet/PageAction?${URL }&style=image">图片版</a>
			      		</c:if>
			      		<c:if test="${style!='imagetext'}"><strong><em style="color: #ff7100">图片版</em></strong></c:if>
		      		</div>
				</div>
			</div>
		</div>
		<!-- 商品展示区域 -->
		<div id="solp">
			<div class="row">
			  	 <c:forEach var="products" items="${requestScope.pagebean.list}" varStatus="status">
				    <div class="thumbnail">
				      <a title=" ${products.name }" href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ products.id}"target=_blank>
					     <img style="height: 200px;" class="img-responsive img-rounded" data-src="holder.js/100%x180" src="${products.uploadImage }" alt="${products.name }">
					   </a>
				      <div class="caption">
					      <div style="width:210px;height: 20px;">
					      	<div style="float:left;">
							<span>
								<b style="font-size: 14px;color: gray;">¥</b>
								<em style="font-size: 14px;color: #ff7100;"><strong>${products.price }</strong></em>
							</span>
							</div>
	                      </div>
				      </div>
				      <div style="width: 210px;height: 26px;">
			        	<p style="text-align:center;font-size: 14px;">
			        		<a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ products.id}" target=_blank>
			        			<c:out value="${fn:substring(products.name,0,13)}"></c:out>
			        			<c:if test="${fn:length(products.name)>13}">···</c:if>
			        		</a>
			        	</p>
			      	 </div>
				    </div>
			 	</c:forEach>
			</div>
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
				    <input type="hidden"id="url"value="${URL}">
				    <input type="hidden"id="st"value="${style}">
			    </span> 
		    </div>
		 </div>
		</div>
  	<hr/>
    <jsp:include page="foot.jsp"></jsp:include> 
  </body>
</html>
