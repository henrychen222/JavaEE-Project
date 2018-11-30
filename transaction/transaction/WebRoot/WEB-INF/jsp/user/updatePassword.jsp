<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>修改密码</title>

	<link rel="stylesheet"
			href="${pageContext.request.contextPath }/css/userCenter.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath }/css/bootstrap.css" />
		<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
 
	</head>
  <script type="text/javascript">
  function test()
  {
  	var password=document.form.password.value;
  	var password1=document.form.password1.value;
  	var password2=document.form.password2.value;
  	if(password=="")
  	{
  		alert("原密码不能为空");
  		return false;
  	}else
  	if(password1.length>16||password1.length<6)
  	{
  		alert("新密码由6-16个字母,数字,字符组成");
  		return false;
  	}else
  	if(!(password1==password2))
  	{
  		alert("确认密码与新密码不一致");
  		return false;
  	}
  	
  	return true;
  }
  
  </script>
	<body>
	   <form  name="form" onsubmit="return test()" action="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=updatePassword&id=${id}"  method="post">
	   
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
									href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=showSelfInfoUI&id=${user.id}"
									> 个人资料 </a>
								<br />
							</li>
						</ul>
					</div>
				</div>
				<div class="panel panel-success" style="margin-bottom: 0px;">
					<div class="panel-heading" align="center">
						<ul>
							<li>
								<a
									href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=updatePasswordUI&id=${user.id}"
									> 修改密码 <br /> </a>
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
						<span class="input-group-addon">原始密码</span>
						<input type="password" class="form-control" name="password">
					</div>
					<br />
					<br />
			<div class="input-group">
				<span class="input-group-addon">新的密码</span>
				<input type="password" class="form-control" name="password1">
					</div>
					<br />
					<br />
			<div class="input-group">
						<span class="input-group-addon">确认密码</span>
						<input type="password" class="form-control" name="password2">
					</div>
					<br />
					<br />
			<button type="submit" title="确认修改" class="btn btn-primary">
						确认修改
					</button>
					&nbsp;&nbsp;<font color="red" size=3>${message}</font>
		</div>
		</div>
		<div id="center_right" >
			<font color="red">@密码长度为6到16位</font><br/>
			<div style="margin-top:56px;"><font color="red">@建议使用复杂密码</font></div>
			
			<br/><div style="margin-top:35px;">&nbsp;</div>
			
			</div>
			<div id="right">
			<a title="${recommendProduct.name }" href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ recommendProduct.id}"target=_blank>
				     <img style="height: 300px" class="img-responsive img-rounded" data-src="holder.js/100%x180" src="${recommendProduct.uploadImage }" alt="${recommendProduct.name }">
				   </a>
			
			</div>
	  </form>	
	</body>
</html>
