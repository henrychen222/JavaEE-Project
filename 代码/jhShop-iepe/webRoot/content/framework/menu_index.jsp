<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../_head.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/js/framework/menu_index.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单管理</title>
</head>
<body class="easyui-layout">
	<div class="pos" region="north">
		<p class="fl">
			您的位置:<a class="f_666" href="#">后台管理>菜单管理</a>
		</p>
		<p class="fr mr15"></p>
	</div>
	<div region="west" style="width:300px;">
		<a href="javascript:addMenu()" class="easyui-linkbutton"
			iconCls="icon-add" plain="true">添加菜单</a><br />
		<ul id="menuTree" class="easyui-tree"></ul>
	</div>
	<div region="center">
		<form id="myform" method="post" class="easyui-form"
			action="${pageContext.request.contextPath}/menu/addMenu.do"
			target="workSpace">
			<input type="hidden" name="menuId" id="menuId" value="0" />
			<div>
				<table>
					<tr>
						<td align="right" height="30">菜单名称：</td>
						<!-- wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-467 原来这里没有交验条件，所以会造成超长。这里加上。-->
						<td><input name="name" id="name" type="text"
							class="easyui-validatebox" data-options="required:true,validType:'length[1,100]'"/>
						</td>
						<td align="right" height="30">菜单标题：</td>
						<td><input name="title" id="title" type="text"
							class="easyui-validatebox" data-options="required:true,validType:'length[1,100]'"/>
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
						<td align="right" height="30">链接：</td>
						<td><input name="uri" type="text" id="uri"
							class="easyui-validatebox" data-options="validType:'length[0,250]'"/>
						</td>
					</tr>
					<tr>
						<td align="right" height="30">图标样式：</td>
						<td><input name="icon" type="text" id="icon"
							class="easyui-validatebox" data-options="validType:'length[0,100]'"/>
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
					<tr>
						<td align="right" height="100">描述：</td>
						<td colspan=3><textarea id="desc" rows="5" cols="15"
								name="desc"></textarea>
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