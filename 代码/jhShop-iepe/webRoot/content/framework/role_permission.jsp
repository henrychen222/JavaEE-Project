<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="menuDiv" style="border:solid 0px #CCC; line-height:21px; background:#FFF;">
	<input type="hidden" id="roleId" value="${param.roleId}"></input> 
	<input type="hidden" id="roleMenus" value="${roleMenus}"></input>
	<div id="tab">
		<span>角色：${role.roleName}</span><br/>
	</div>
	<div>
		<ul id="menuTree" class="easyui-tree" ></ul>
	</div>
    <div>
    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveMenuPermission()">保存</a>
    </div>
</div>

        	
<script>
	var needCheckMenuIdArr=[];
	<c:forEach items="${roleMenus}" var="var">
		needCheckMenuIdArr.push("${var.menuId}");	
	</c:forEach>
	loadMenu(needCheckMenuIdArr);
	$("#menuTree").tree("expandAll",$("#menuTree").tree("getRoot"));
	$.parser.parse($("#menuDiv").parent());

</script>