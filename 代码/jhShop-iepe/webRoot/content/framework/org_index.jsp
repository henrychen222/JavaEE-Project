<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../_head.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/js/framework/org_index.js"></script>
<title>公司管理</title>
</head>
<body class="easyui-layout">
	<input id="showId" type="hidden" value="${param.showId}" />
	<input type="hidden" id="orgId" name="orgId" />
	<div class="pos" region="north">
		<p class="fl">
			您的位置:<a class="f_666" href="#">后台管理>公司管理</a>
		</p>
		<p class="fr mr15"></p>
	</div>
	<div region="west" style="width:300px;">
		<ul id="tt" class="easyui-tree"></ul>
	</div>
	<div region="center">
		<div class="easyui-layout" fit="true" style="border:0px solid;">
			<div id="toolBar" region="north"
				style="padding-top:10px;padding-left:20px;padding-bottom:10px;border:0px solid;">
				公司名称：<input id="orgName" style="border-left: 0;border-right: 0;border-top: 0;border-bottom: 0px solid #000000;" readonly="readonly"/> 
				公司编号：<input id="orgCode" name="orgCode" readonly="readonly" style="border-left: 0;border-right: 0;border-top: 0;border-bottom: 0px solid #000000;" />
				公司类型：<input id="orgTypeName" name="orgTypeName" readonly="readonly" style="border-left: 0;border-right: 0;border-top: 0;border-bottom: 0px solid #000000;" /> 
				<!-- &nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:loadOrgs($('#orgId').val());" iconCls="icon-search">查询</a> -->
				&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:addOrg();" iconCls="icon-add">新增</a>
			</div>
			<div region="center" style="border:0px solid;">
				<table id="list_org">
				</table>
			</div>
		</div>
		<div id="son_org_detail"></div>
		<div id="editOrgWindow"></div>
	</div>
</body>
</html>