<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
  <head>
    <title>我的闲置</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/userLibrary.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  
  <body>
  <jsp:include page="../page/head.jsp"></jsp:include>
  <div id=left>
  
   
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
   </div>
	    <div class="panel panel-success" style="margin-bottom:0px;">
	    <div class="panel-heading">
	    	 &nbsp;
	    </div>
	  </div>
  </div>
  <div id="center">
  <c:if test="${!empty pagebean.list}">
  	  <div class="container" style="width:100%;">
  		<div class="row">
			<div class="panel panel-primary" >
		  		<div class="panel-heading">所有闲置物品</div>
		 		<div class="panel-body">
					<table class="table table-bordered" >
						<tr>
							<th>图片</th>
							<th>商品名</th>
						    <th>卖价</th>
						    <th>交易方式</th>
							<th>描述</th>
						  	<th>发布人</th>
						  	<th>操作</th>
					   </tr>
					   <c:forEach var="product" items="${requestScope.pagebean.list}" varStatus="status">
					   <tr>
					   	   <td><img width=140px height=160px src="${product.uploadImage}"/></td>
		                   <td>${product.name}</td>
						   <td>${product.price}</td>
						   <td>${product.trading}</td>
						   <td style="width:150px;overflow:hidden;">${product.description}</td>
		                   <td>${product.publisher}</td>
						    <td>
							<a href="javascript:void(0)"title="下架" onclick="deleteProduct(${product.id})">[下架]</a>
					        <a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=updateProduct&publisher=${product.publisher}&id=${product.id}">[更新]</a>
							</td>
					   </tr>
					   </c:forEach>
					  </table>
					  <div style="text-align: center">
			 			共[${pagebean.totalrecord }]条记录,
					   	每页<input type="text" id="pagesize" value="${pagebean.pagesize }" onchange="gotopage(${pagebean.currentpage })" style="width:30px" maxlength="2">条,
					   	共[${pagebean.totalpage }]页,
						当前[${pagebean.currentpage }]页
					    &nbsp;&nbsp;&nbsp;&nbsp;    
					    <a href="javascript:void(o)" onclick="gotopage(${pagebean.previouspage})">上一页</a>
						<c:forEach var="pagenum" items="${pagebean.pagebar}">
							<c:if test="${pagenum==pagebean.currentpage}">
								<font color="red">${pagenum}</font>
							</c:if>
							<c:if test="${pagenum!=pagebean.currentpage}">
								<a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum }</a>
							</c:if>
						</c:forEach>
					    <a href="javascript:void(0)" onclick="gotopage(${pagebean.nextpage})">下一页</a>       
					    <input type = "text" id = "pagenum" style="width:30px"maxlength="2">
					    <input type = "button" value = "GO" onclick = "gotopage(document.getElementById('pagenum').value)">
					    <input type="hidden"id="url"value="${URL}">
				    </div>
				</div>
      		</div>
		</div>
  	 </div>
  	 </c:if>
  	  <c:if test="${empty pagebean.list}">
  	  <div align="center">
	  	  <img src="${pageContext.request.contextPath}/images/null.png"/>
	  	  <br/>
	  	  <span>还没有闲置的商品哦</span>
	  	  </div>
  	  </c:if>
  	 </div>
  	 <script type="text/javascript">
 	  	function deleteProduct(id)
		{
			var b = window.confirm("确定要下架该宝贝 吗？");
			if(b)
				window.location.href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=deleteProduct&id="+id;
		}
		
 	  	function gotopage(currentpage){
 	  		var pagesize = document.getElementById("pagesize").value;
			var url = document.getElementById("url").value;
			if(pagesize>0&&currentpage>0){
 	  			window.location.href = '${pageContext.request.contextPath}/servlet/UserServlet?'+url+'&currentpage='+currentpage+'&pagesize='+pagesize;
 	  		}else{
 	  			window.confirm("这填的数字要大于0哦！！");
 	  		}	  	
 	  	}
 	  	
 	 </script>
  </body>
</html>