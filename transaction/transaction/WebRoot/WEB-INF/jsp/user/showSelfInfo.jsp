<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>个人资料</title>

		<link rel="stylesheet"
			href="${pageContext.request.contextPath }/css/userCenter.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
 
	</head>

	<body>
		<form
			action="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=updateSelfInfo&id=${user.id}"
			method="post">

			<jsp:include page="../page/head.jsp"></jsp:include>
			<div id="left">


				<div class="panel panel-success" style="margin-bottom: 0px;">
					<div class="panel-heading">
						&nbsp;
					</div>
				</div>
				<div class="panel panel-success" style="margin-bottom: 0px;">
					<div class="panel-heading" align="center">
						<h3>
							我的交易
						</h3>
					</div>
				</div>
				<div class="panel panel-success" style="margin-bottom: 0px;">
					<div class="panel-heading" align="center">
						<ul>
							<li>
								<a
									href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=showSelfInfoUI&id=${user.id}">
 									个人资料 
 								</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="panel panel-success" style="margin-bottom: 0px;">
					<div class="panel-heading" align="center">
						<ul>
							<li>
								<a
									href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=updatePasswordUI&id=${user.id}"> 
									修改密码
								  </a>
							</li>
						</ul>
					</div>
				</div>
				<div class="panel panel-success" style="margin-bottom: 0px;">
					<div class="panel-heading" align="center">
						<ul>
							<li>
								<a href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=listmeorder" rel="nofollow"> 我的订单 </a>
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

			<div id="center" style="margin-right: 0px;padding: 0px;">
				<div  class="panel-body">
					<div class="input-group">
						<span class="input-group-addon">真实姓名</span>
						<input type="text" class="form-control" name="realname"
							value="${user.realname }">
					</div>
					<br />
					<br />

					<div class="input-group">
						<span class="input-group-addon">手机号码</span>
						<input type="text" class="form-control" name="phone"
							value="${user.phone }">
					</div>
					<br />
					<br />

					<div class="input-group">
						<span class="input-group-addon">电子邮箱</span>
						<input type="text" class="form-control" name="email"
							value="${user.email }">
					</div>
					<br />
					<br />
					
					
					<div class="input-group">
						<span class="input-group-addon">现居地址</span>
						<input type="text" class="form-control" name="address"
							value="${user.address }">
					</div>
					<br />
					<br />

					<button type="submit" title="保存" class="btn btn-primary">
						保&nbsp;&nbsp;&nbsp;&nbsp;存
					</button>
					&nbsp;&nbsp;<font size=4 color="red">${message}</font>

				</div>
			</div>
			<div id="center_right" >
			<font color="red">@找回密码时的重要依据</font><br/>
			<div style="margin-top:56px;"><font color="red">@下订单时必须填写</font></div>
			
			<br/><div style="margin-top:35px;"><font color="red">@找回密码时的重要依据</font></div>
			
			</div>
			<div id="right">
			<a title="${recommendProduct.name }" href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ recommendProduct.id}"target=_blank>
				     <img style="height: 300px" class="img-responsive img-rounded" data-src="holder.js/100%x180" src="${recommendProduct.uploadImage }" alt="${recommendProduct.name }">
				   </a>
			
			</div>
		</form>

	</body>
</html>
