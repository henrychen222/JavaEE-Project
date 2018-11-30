<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>俱合家具网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="_head.jsp"%>
<script src="<%=request.getContextPath()%>/common/js/tabAndMenu.js"
	type="text/javascript"></script>
<style type="text/css">
	.noScroll{
		overflow:hidden;
	}
</style>
</head>
<script type="text/javascript">
jQuery(function(){ 
	$("#menuTreeM").tree({
			url : window.contextPath
					+ '/menu/loadMenu.do?menuId=-1'
					+ '&opr=load',
			onClick : function(node) {
				$.ajax({
							url : window.contextPath
									+ "/menu/selectMenuById.do?menuId="
									+ node.id + "&opr=edit",
							data : "",
							async : false,
							dataType : "html",
							success : function(data) {
								var sear=new RegExp('!DOCTYPE');
								if(sear.test(data)){
									location.href= '${pageContext.request.contextPath}/login/index.do';  
								}
								
								var obj = eval("(" + data + ")");
								if(obj.uri!=null && obj.uri !="")
									jumpPage(contextPath+obj.uri,obj.name);
							}
						});
				var bool=$(this).tree('isLeaf',node.target);
				if(!bool){
					$(this).tree('toggle',node.target);
				}
			},
			onBeforeExpand : function(node, param) {
				$("#menuTreeM").tree("options").url = window.contextPath
						+ "/menu/loadMenu.do?menuId=" + node.id;
			}
		});
});

/*
$(function(){
	var src = '<%=request.getContextPath()%>/main/mainPage.do';
	$("#iframeContent").attr("src",src);
});*/
</script>
<body style='margin:0px;padding:0px;'>
<div id="cc" class="easyui-layout" fit='true'>
		<!--顶部导航-->
	    <div class="top-nav" region='north' style='height:37px;'>
	        <div class="top-nav-wrap">
	            <a href="#" class="logo"></a>
	            <div class="welcome-wrap">
	                <span class="welcome">欢迎您来到俱合网！</span>
	                <a href="#" style="color: red;" class="user-name" >${sessionScope.user.userName}</a>
	               <a href="<%=request.getContextPath()%>/login/logOut.do">退出</a>
	            </div>
	           <%--  <ul class="right-menu">
	                <li><a href="<%=request.getContextPath()%>/login/indexPage.do">我的俱合</a><span class="line"></span></li>
	                <li><a href="#">订单管理</a><span class="line"></span></li>
	                <li><a href="#">购物车</a><span class="cart-num">5</span><span class="line"></span></li>
	                <li><a href="#">我的收藏</a><span class="line"></span></li>
	                <li><a href="#">帮助中心</a><span class="line"></span></li>
	                <li><a href="#">咨询俱合</a><span class="line"></span></li>
	            </ul>  --%>
	        </div>
	    </div>

	    <div data-options="region:'west',title:'便捷操作',split:true" style="width:18%;">
	    <!-- 树型菜单 -->
			<div class="easyui-accordion"  data-options="fit:true">
				<div title="菜单" data-options="iconCls:'icon-search'" style="overflow:auto;padding:10px;">
				<ul id="menuTreeM"></ul>
				</div>
				<!-- <div title="待处理"  style="overflow:auto;padding:10px;">
					<p>待处理事项</p>
				</div>
				<div title="快捷方式" style="overflow:auto;padding:10px;">
					<p>快捷方式链接</p>
				</div>
				<div title="实用工具" style="overflow:auto;padding:10px;">
					<p>实用工具帮助</p>
				</div> -->
			</div>
		</div>
	     <div data-options="region:'center'" >
		    <!-- tab页面 -->
			<div class="easyui-tabs" id="easyuiTabs" fit=true>
			<!-- 主页内容 -->
				<div title="主页" class="WrapMiddle">
					<img src="${ctx}/common/images/building.jpg" height="500px;" width="100%">	
					<!-- 
					<iframe id="iframeContent" src="" scrolling="auto" width="100%"  frameborder="0"  style='height:100%'>
					</iframe> 
					-->
				</div>
			</div>
		</div>
		<div region='south' style='height:25px'>
			<div class='Footer' >
			 <span class="right">版权所有 &copy;2015俱合网</span>
			 </div>
		 </div>
	</div>
</body>
</html>