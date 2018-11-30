<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="../_head.jsp"%>
<script src="<%=request.getContextPath()%>/common/js/framework/user_index.js"
	type="text/javascript"></script>
<title>用户管理</title>
</head>
<body class="easyui-layout">
	<input id="showId" type="hidden" value="${param.showId}" />
	<input id="orgId" type="hidden" value="${param.showId}" />
	<input id="msg" type="hidden" value="${msg}" />
	<div class="pos" region="north">
		<p class="fl">
			您的位置:<a class="f_666" href="#">后台管理>用户管理</a>
		</p>
		<p class="fr mr15"></p>
	</div>
	<div region="west" style="width:300px;">
		<ul id="tt" class="easyui-tree"></ul>
	</div>
	<div region="center">
		<div class="easyui-layout" fit="true" style="border:0px solid;">
			<div id="toolBar" region="north" style="padding-top:10px;padding-left:20px;padding-bottom:10px;border:0px solid;">
				用户账号：<input id="accountName" name="accountName" type="text" class="easyui-validatebox" /> 
				姓名：<input id="userName" name="userName" type="text" class="easyui-validatebox" /> 
				状态： <select id="userStateCd" name="userStateCd" class="easyui-combobox">
					<option value="" style="font-size:5px;">全部</option>
					<option value="1">有效</option>
					<option value="0">无效</option>
				</select>&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:loadUsers();" iconCls="icon-search">查询</a> 
				<a href="javascript:addUser();" class="easyui-linkbutton" iconCls="icon-add">添加</a> 
				<a href="javascript:userPermission()" class="easyui-linkbutton" iconCls="icon-search">查看角色</a>
			</div>
			<div region="center" style="border:0px solid;">
				<table id="dataGrid">
				</table>
			</div>
		</div>
		<div id="editUserWindow"></div>
		<div id="userRoleWindow" class="easyui-window" title="已有角色"
			data-options="iconCls:'icon-save',minimizable:true,maximizable:true,collapsible:true,closed: true"
			style="width:720px;height:400px;padding:10px;"></div>
		<div id="dataPermissionWindow" class="easyui-window" title="已有维度"
			data-options="iconCls:'icon-save',minimizable:true,maximizable:true,collapsible:true,closed: true"
			style="width:920px;height:500px;padding:10px;"></div>
	</div>
</body>
</html>