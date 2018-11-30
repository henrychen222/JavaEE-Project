<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>我的收藏</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/collect.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
 
  </head>
  
  <body>
<jsp:include page="../page/head.jsp"></jsp:include>
 <div id="left">
  
  
   <div class="panel panel-success" style="margin-bottom:0px;">
    <div class="panel-heading">
    	 &nbsp;
    </div>
  </div>
  <div class="panel panel-success" style="margin-bottom:0px;">
    <div class="panel-heading" align="center">
    	 <h3>我的交易</h3>
    </div>
  </div>
  <div class="panel panel-success" style="margin-bottom:0px;">
    <div class="panel-heading" align="center">
  	  <ul>
		 <li>
			  <a  href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=showSelfInfoUI&id=${user.id}">
	 		 	  个人资料
			 </a>
		 </li>
	  </ul>
	</div>
   </div>
   <div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		 <li>
			<a  href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=updatePasswordUI&id=${user.id}">
				修改密码
	 		</a>
		 </li>
	  </ul>
	</div>
   </div>
   <div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=listmeorder" rel="nofollow">
			         我的订单
			</a>
		</li>
	 </ul>
	</div>
   </div>
<div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=publishGoodsUI&id=${user.id}" >
			         发布商品
			</a>
		</li>
	 </ul>
	</div>
   </div>
    <div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listproduct&username=${user.username}" >
			         我的闲置
			</a>
		</li>
	 </ul>
	</div>
	</div>
	  <div class="panel panel-success" style="margin-bottom:0px;">
	    <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listSoldOutProduct&username=${user.username}" >
			      已经下架
			</a>
		</li>
	 </ul>
	</div>
	</div>
   <div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listCollect&id=${user.id}" >
			         我的收藏
			</a>
		</li>
	 </ul>
	</div>
	<div class="panel panel-success" style="margin-bottom:0px;">
    	<div class="panel-heading">
    	 &nbsp;
   	     </div>
 	 </div>
   </div>
   </div>
   <div id="center">
   		<c:if test="${!empty list2}">
		  	 <c:forEach var="list2" items="${list2}">
		  	 <c:if test="${list2.status=='已下架'}">
		  	 <div class="collect">
			      <a href="javascript:void(0)" onclick="soldOutMsg()">
				     <img style="width:180px;height: 200px" class="img-responsive img-rounded"  src="${list2.uploadImage }" alt="${list2.name }">
				   </a>
			      <div class="caption">
			          <span>
			        	<font color="red">商品已下架</font>&nbsp;&nbsp;&nbsp;&nbsp;
				        <a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=deleteCollect&productId=${list2.id}&userId=${user.id}">
				        	删除
				        </a>
				      </span>
			      </div>
			    </div>
		  	 </c:if>
		  	 <c:if test="${list2.status!='已下架'}">
			    <div class="collect">
			      <a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${list2.id}"target=_blank>
				     <img style="width:180px;height: 200px" class="img-responsive img-rounded"  src="${list2.uploadImage }" alt="${list2.name }">
				   </a>
			      <div class="caption">
			        <h4>${list2.name }</h4>
			        <p>
			          <span>
			        	<font color="red"> ${list2.price }￥</font>&nbsp;&nbsp;&nbsp;&nbsp;
				        <a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=deleteCollect&productId=${list2.id}&userId=${user.id}">
				        	删除
				        </a>
				      </span>
				    </p>
			      </div>
			    </div>
			    </c:if>
		 	</c:forEach>
		 	</c:if>
		 	<c:if test="${empty list2}">
		 	<div align="center">
	  	  <img src="${pageContext.request.contextPath}/images/null.png"/>
	  	  <br/>
	  	  <span>还没收藏哦</span>
	  	  </div>
		 </c:if>
	 </div>
     <script type="text/javascript">
 	  	function soldOutMsg()
		{
			alert("宝贝已下架，不能在购买喽");
		}
		</script>
 </body>
</html>
