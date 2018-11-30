<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="../_head.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/js/framework/role_index.js"></script>
<title>角色管理</title>
</head>
<body class="easyui-layout">
	<input id="roleUserId" type="hidden" />
	<input id="roleUser" type="hidden" />
	<div class="pos" region="north">
		<p class="fl">
			您的位置:<a class="f_666" href="#">后台管理>角色管理</a>
		</p>
		<p class="fr mr15"></p>
	</div>
	<div region="center">
		<div class="easyui-layout" fit="true" style="border:0px solid;">
			<div id="toolBar" region="north"
				style="padding-top:10px;padding-left:20px;padding-bottom:10px;border:0px solid;">
				角色名称：<input id="accountName" name="roleName" type="text"
					class="easyui-validatebox" /> 角色类型：<select id="roleTypeCd"
					name="roleTypeCd" class="easyui-combobox">
					<option value="">请选择</option>
					<c:forEach items="${roleType}" var="rt">
						<option value="${rt.ROLE_TYPE_CD}"
							<c:if test="${param.roleTypeCd == rt.ROLE_TYPE_CD}">selected</c:if>>${rt.NAME}</option>
					</c:forEach>
				</select>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="javascript:loadRoles();" iconCls="icon-search">查询</a> <a
					href="javascript:showAddRole();" class="easyui-linkbutton"
					iconCls="icon-add">添加</a>
			</div>
			<div region="center" style="border:0px solid;">
				<table id="list_data_role">
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
	<div region="east" style="width:500px;" id="menuPermision"></div>
	<div id="editRoleWindow"></div>
	<div id="addRoleWindow"></div>
	<div id="addUserWindow"></div>
</body>
</html>