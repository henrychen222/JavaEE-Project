<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript">
	function addFavorite(sURL,sTitle) 
	{ 
		sURL = encodeURI(sURL); 
		
      try {
            window.external.addFavorite(sURL, sTitle);
        }
        catch (e) {
            try {
                window.sidebar.addPanel(sTitle, sURL, "");
            }
            catch (e) {
                alert("加入收藏失败.请使用Ctrl+D进行手动添加");
            }
        }
	} 
    </script>
    <title>head</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  <body>
	<div id="head">
	  <div class="h-body">
		<ul class="h-l hl">
			<li class="fore1 ld">
				<b></b>
				<a href="javascript:void(0);" onclick="addFavorite('http://localhost:8080/transaction/','跳蚤市场交易网站')">收藏网站</a>
			</li>
		</ul>
	  	<ul class="h-l hl">
			<li class="fore1 ld">
				<a href="${pageContext.request.contextPath }/servlet/IndexServlet" >返回首页</a>
			</li>
		</ul>
		<ul class="h-r hl">
			<li id="login-regist" class="right1">
			<c:if test="${user.username!=null}">
				您好,
				<span>
					<a  title="点击进入个人中心" style="font-size:1em;a {star : expression(onfocus=this.blur)}"onfocus="this.blur()" href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=centerUI&id=${user.id}" >${user.username}！</a><a style="font-size:1em;" href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=logOut">[安全退出 ]</a>
				</span>
			</c:if>	
			<c:if test="${user.username==null}">
				欢迎来到商品互换市场！
				<span>
				<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=loginUI&URL=${URL}">[登录]</a> 
				<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=registerUI">[免费注册]</a>
				</span>
			</c:if>
			</li>
			<li class="right1 ld">
				<s></s>
				<c:if test="${user.username!=null}">
				<a href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=listmeorder" rel="nofollow">我的订单</a>
				</c:if>
				<c:if test="${user.username==null}">
				<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=loginUI3&id=${user.id}" rel="nofollow">我的订单</a>
				</c:if>
			</li>
			<li class="right2 ld meun" id="app-tz">
				<s></s><i></i>
				<span class="outline"></span>
				<span class="blank"></span>
				<a href="#" target="_blank">手机商品互换市场</a>
				<b></b>
			</li>
			<li class="right1 ld menu" id="biz-service" >
				<s></s>
				<span class="outline"></span>
				<span class="blank"></span>
				客户服务
				<b></b>
				<div class="dd">
					<div><a href="#" target="_blank">帮助中心</a></div>
					<div><a href="#" target="_blank" rel="nofollow">售后服务</a></div>
					<div><a href="#" target="_blank" rel="nofollow">在线客服</a></div>
					<div><a href="#" target="_blank" rel="nofollow">投诉中心</a></div>
					<div><a href="#" target="_blank">客服邮箱</a></div>
				</div>
			</li>
			<li class="right1 ld menu" id="site-nav">
				<s></s>
				<span class="outline"></span>
				<span class="blank"></span>
				网站导航
				<b></b>
				<div class="dd lh">
					<dl class="item fore1">
						<dt>特色栏目</dt>
						<dd>
							<div><a target="_blank" href="#">为我推荐</a></div>
						</dd>
					</dl>
					<dl class="item fore2">
						<dt>企业服务</dt>
						<dd>
							<div><a target="_blank" href="#">为我推荐</a></div>
							<div><a target="_blank" href="#">为我推荐</a></div>
							<div><a target="_blank" href="#">为我推荐</a></div>
						</dd>
					</dl>
					<dl class="item fore3">
						<dt>旗下网站</dt>
						<dd>
							<div><a target="_blank" href="#">为我推荐</a></div>
							<div><a target="_blank" href="#">为我推荐</a></div>
							<div><a target="_blank" href="#">为我推荐</a></div>
							<div><a target="_blank" href="#">为我推荐</a></div>
						</dd>
					</dl>
				</div>
			</li>
		</ul>
		<span class="clr"></span>
	  </div>
    </div>
  </body>
</html>
