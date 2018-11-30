$(function() {
	loadRoles();
});

function loadRoles() {
	/* wangyan modified @ 151117 ZBITI_2015_RJ(2)_KF002-N-40 原来这里的id写错了。 */
	var roleName = $("#accountName").val();
	var roleTypeCd = $("#roleTypeCd").combobox("getValue");

	var columns = [ [
			{
				field : "roleName",
				title : "角色名称",
				width : 220,
				align : "center"
			},
			{
				field : "roleTypeCdName",
				title : "角色类型",
				width : 120,
				align : "center"
			},
			{
				field : "opr",
				title : "操作",
				align : "center",
				width : 210,
				// 添加超级链
				formatter : function(value, rowData, rowIndex) {
					return "<a href='#' onclick='deleteRole(" + rowData.roleId
							+ ")'>删除</a>"
							+ " <a href='#' onclick='showEditRole("
							+ rowData.roleId + ")'>编辑</a>"
							+ " <a href='#' onclick='permission("
							+ rowData.roleId + ")'>权限</a>"
							//+ " <a href='#' onclick='showAddUserWindow("
							//+ rowData.roleId + ")'>分配用户</a>";
				}
			} ] ];
	$("#list_data_role").datagrid({
		url : window.contextPath + "/role/selectRolesByCond.do",
		width : "auto",
		fit : true,
		nowrap : false,
		iconCls : "icon-save",
		striped : true,
		pagination : true,
		rownumbers : true,
		pageNumber : 1,
		pageSize : 10,
		pageList : [ 5, 10, 20, 50 ],
		queryParams : {
			roleName : roleName,
			roleTypeCd : roleTypeCd,
			opr : "edit"
		},
		singleSelect : true,
		loadMsg : "数据加载中......",
		columns : columns
	});
}
function showAddRole() {
	$("#addRoleWindow").window({
		title : "添加角色",
		href : window.contextPath + "/role/addNew.do",
		width : 720,
		height : 250,
		zIndex : 3,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		draggable : true,
		resizable : true,
		shadow : false,
		cache : false,
		modal : true,
		onLoad : function() {
			$(".window").css("position", "fixed");
		}
	});
}

function commitEdit() {
	/*wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-461 原来这里没有表单验证。这里加上。*/
	if (!$("#addform").form("validate")) {
		return;
	}
	if ($("#roleDesc").text().length > 250) {
		alert("描述超长！");
		return;
	}
	if (confirm("确定要修改数据吗？")) {
		ajaxSubmit($("#addform").attr("action"), $("#addform"), function(r) {
			alert(r);
			/*
			 * wangyan modified @ 151117 ZBITI_2015_RJ(2)_KF002-N-42
			 * 原来这里会报错，遂把刷新角色列表提前，让刷新始终正常即可。
			 */
			loadRoles();
			try{
				$("#addRoleWindow").window("close");	
			}catch(e){}
			try{
				$("#editRoleWindow").window("close");	
			}catch(e){}			
		});
	}
}
function deleteRole(roleId) {
	$.messager.confirm("提示", "确定要删除角色吗？", function(r) {
		if (r) {
			$.ajax({
				url : window.contextPath + "/role/deleteRole.do?roleId="
				//wangyan modified @ 151124 ZBITI_2015_RJ(2)_KF002-N-349 有缓存，这里加上随机数避免缓存。
						+ roleId+"&r="+Math.random(),
				data : "",
				async : false,
				dataType : "html",
				success : function(data) {
					$.messager.alert("提示", data);
					loadRoles();
				}
			});
		}
	});
}
function showEditRole(roleId) {
	$("#editRoleWindow").window({
		title : "编辑角色",
		href : window.contextPath + "/role/editNew.do?roleId=" + roleId,
		width : 720,
		height : 250,
		zIndex : 3,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		draggable : true,
		resizable : true,
		shadow : false,
		cache : false,
		modal : true,
		onLoad : function() {
			$(".window").css("position", "fixed");
		}
	});
}

function permission(roleId) {
	/*
	 * wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-464
	 * 有可能是有缓存，这里加上随机码，取消缓存。
	 */
	$("#menuPermision").load(
			window.contextPath + "/role/rolePermission.do?roleId=" + roleId
					+ "&r=" + Math.random());
}

function showAddUserWindow(roleId) {
	$("#addUserWindow").window({
		title : "分配用户",
		href : window.contextPath + "/role/roleUser.do?roleId=" + roleId,
		width : 720,
		height : 450,
		zIndex : 3,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		draggable : true,
		resizable : true,
		shadow : false,
		cache : false,
		modal : true,
		onLoad : function() {
			$(".window").css("position", "fixed");
		}
	});
}

function showAddPositionWindow(roleId) {
	$("#addUserWindow").window({
		title : "分配岗位",
		href : window.contextPath + "/role/rolePosition.do?roleId=" + roleId,
		width : 720,
		height : 450,
		zIndex : 3,
		collapsible : false,
		minimizable : false,
		maximizable : false,
		draggable : true,
		resizable : true,
		shadow : false,
		cache : false,
		modal : true,
		onLoad : function() {
			$(".window").css("position", "fixed");
		}
	});
}
function loadMenu(needCheckMenuIdArr) {
	$("#menuTree").tree({
		url : window.contextPath + "/menu/loadMenuTreeAll.do",
		checkbox : true,
		cascadeCheck : true,
		onLoadSuccess : function(node, param) {
			for ( var i in needCheckMenuIdArr) {
				var n = $("#menuTree").tree("find", needCheckMenuIdArr[i]);
				// if(n.state!="open"){
				if (!n.isParent) {
					$("#menuTree").tree("check", n.target);
				}
			}
		}
	});
}
function saveMenuPermission() {
	var nodes = $("#menuTree").tree("getChecked",
			[ "checked", "indeterminate" ]);
	var nodeStr = "";
	for (var i = 0; i < nodes.length; i++) {
		nodeStr += nodes[i].id + ",";
	}
	;
	var roleId = $("#roleId").val();
	$.ajax({
		url : window.contextPath + "/role/saveRoleMenu.do?roleId=" + roleId
				+ "&menus=" + nodeStr,
		data : "",
		async : false,
		dataType : "html",
		success : function(data) {
			$.messager.alert('提示', data);
		}
	});
}