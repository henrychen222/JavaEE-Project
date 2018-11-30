<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../_head.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/js/framework/help_index.js"></script>
<!-- kindeditor -->
<script
	src="<%=request.getContextPath()%>/common/kindeditor-4.1.10/kindeditor-all-min.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单管理</title>
</head>
<body class="easyui-layout">
	<div class="pos" region="north">
		<p class="fl">
			您的位置:<a class="f_666" href="#">后台管理>帮助管理</a>
		</p>
		<p class="fr mr15"></p>
	</div>
	<div region="west" style="width:300px;">
		<a href="javascript:addMenu()" class="easyui-linkbutton"
			iconCls="icon-add" plain="true">添加菜单</a><br />
		<ul id="menuTree" class="easyui-tree"></ul>
	</div>
	<div region="center">
		<form id="myform" method="post"
			action="${pageContext.request.contextPath}/help/addMenu.do"
			target="workSpace">
			<input type="hidden" name="menuId" id="menuId" value="0" />
			<input type="hidden" name="objLevel" id="objLevel" value="" />
			<div>
				<table>
					<tr>
						<td align="right" height="30">菜单名称：</td>
						<td><input name="name" id="name" type="text"
							class="easyui-validatebox" />
						</td>
						<td align="right" height="30">菜单序号：</td>
						<td><input name="menuSortCd" id="menuSortCd" type="text"
							class="easyui-numberbox" />
						</td>
					</tr>
					<tr>
						<td align="right" height="30">上级菜单/导航：</td>
						<!-- wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-32 高度调整为27px即可。 -->
						<td><input id="parentMenuId" name="parentMenuId"
							data-options="height:27"
							class="easyui-combotree" style="width: 400px"
							style="width:200px;" />
						</td>
						<td align="right" height="30" style="display: none;">链接：</td>
						<td style="display: none;"><input name="uri" type="text" id="uri" 
							class="easyui-validatebox" readonly/>
						</td>
					</tr>
					<tr>
						<td align="right" height="30">菜单级别：</td>
						<td  >
							<select class="easyui-combobox" style="width: 400px;" id="level" name="level" 	data-options="height:27">
								<option value="请选择" >请选择</option>
								<option value="1" >类别</option>
								<option value="2" >一级</option>
								<option value="3" >二级</option>
							</select>
						</td>
						<td align="right" height="30">菜单类型：</td>
						<td><c:forEach items="${menuType}" var="m">
								<input type="radio" name="menuTypeCd" value="${m.MENU_TYPE_CD}"
									id="menuType${m.MENU_TYPE_CD}" checked="checked"
									onclick="javascript:checkType()" />
								<label for="menuType${m.MENU_TYPE_CD}">${m.NAME}</label>
							</c:forEach>
						</td>
					</tr>
					<tr style="display: none;">
						<td align="right" height="100">描述：</td>
						<td colspan=3><textarea id="desc" rows="5" cols="15"
								name="desc"></textarea>
						</td>
					</tr>
					<tr style="display:none;" id="kit">
						<td align="right" width="100">页面设计：</td>
						<td colspan="3" align="left"><textarea style="width: 100%;"
							id="paramterarea" ></textarea>
						<input name="count" id="count" style="display:none;" />
							</td>
					</tr>
					<tr>
						<td align="right" height="30"></td>
						<td></td>
						<td colspan=2 align="center"><a href="javascript:void(0)"
							class="easyui-linkbutton" onclick="javascript:edit()">保存</a> <a
							id="menu_delete" href="javascript:void(0)"
							class="easyui-linkbutton" onclick="javascript:deleteMenu()"
							style="display: none">删除</a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>