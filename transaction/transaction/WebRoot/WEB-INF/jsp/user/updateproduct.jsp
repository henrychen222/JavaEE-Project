<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>更新已发布的商品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/userProductUpdate.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>

	 <script type="text/javascript">
  function test()
  {
  	var title=document.form.name.value;
  	var price=document.form.price.value;
  	 
  	if(title=="")
  	{
  		alert("为您的商品取个名吧");
  		return false;
  	}else
  	if(title.length>6)
  	{
  		alert("商品名长度不允许超过6哦");
  		return false;
  	}else
  	if(price=="")
  	{
  		alert("请给出售价");
  		return false;
  	}
  	return true;
  }
  
  </script>
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
   </div>
   <div class="panel panel-success" style="margin-bottom:0px;">
    <div class="panel-heading">
    	 &nbsp;
    </div>
  </div>
  </div>
  <div id="center">
  <form name="form" onsubmit="return test()"  action="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=updateproduct&id=${product.id}" method="post">
	
				<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="width: 60%;">
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
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size=4 color="red">${message }</font>
							</div>
						</div>
					</div>
				</div>
	  </form>
  
  </div>
  </body>
</html>
