<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品互换市场-商品快报查看</title> 
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
  <body>
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
  	  	 		<div id="shop-sort">
					<H4>热门二手分类<b></b></H4>
  	  	 		</div>
  	  	 		<div id="n-right">
					<c:if test="${user.username!=null}">
					<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=publishGoodsUI&id=${user.id}"target="_blank"class="btn btn-success" >发布宝贝</a>
					<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listproduct"target="_blank"class="btn btn-success">我的闲置</a>
					</c:if>
					<c:if test="${user.username==null}">
					<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=loginUI2"target="_blank"class="btn btn-success" >发布宝贝</a>
					<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listproduct"target="_blank"class="btn btn-success">我的闲置</a>
					</c:if>
				</div>
  	  	 		<ul id="navitems">
				</ul>
  	  	 	</div>
  	  	 </div>
	  </div>
	<!--  body-top  end -->
	
	   
    <jsp:include page="foot.jsp"></jsp:include>  
  </body>
</html>
