/*
 * 初始化加载方法
 */
$(function() {
	//加载树
	$("#tt").tree(
			{
				url : window.contextPath + "/org/loadOrg.do?orgId=",
				onClick : function(node) {
					$("#orgId").val(node.id);
					$("#accountName").val("");
					$("#userName").val("");
					loadUsers();
				},
				onBeforeExpand : function(node, param) {
					$("#tt").tree("options").url = window.contextPath
							+ "/org/loadOrg.do?orgId=" + node.id;
				}

	});

	//加载列表
	loadUsers();
	
	var msg = $("#msg").val();
	if (msg != "" && msg != "null") {
		alert(msg);
	}
});


/*
 *加载列表
 */
function loadUsers() {
	var columns = [ [
			{
				field : "userId",
				checkbox : true
			},
			{
				field : "userName",
				title : "用户姓名",
				width : 120,
				align : "center"
			},
			{
				field : "accountName",
				title : "账号",
				width : 120,
				align : "center"
			},
			{
				field : "orgName",
				title : "所属公司",
				width : 170,
				align : "center",
				formatter : function(value, rowData, rowIndex) {
					var org = rowData.org;
					return org.orgName;
				}
			},
			{
				field : "userStateCd",
				title : "状态",
				width : 120,
				align : "center",
				formatter : function(value, rowData, rowIndex) {
					if (value == 1) {
						return "有效";
					} else {
						return "无效";
					}
				}
			},
			{
				field : "phoneNumber",
				title : "联系电话",
				width : 120,
				align : "center"
			},
			{
				field : "opr",
				title : "操作",
				align : "center",
				width : 80,
				// 添加超级链
				formatter : function(value, rowData, rowIndex) {
					return "<a href='#' onclick='deleteUser(" + rowData.userId
							+ ")'>删除</a> <a href='#' onclick='editUser("
							+ rowData.userId + ")'>编辑</a>";
				}
			} ] ];
	$("#dataGrid").datagrid({
		url : window.contextPath + "/user/selectUserByCond.do",
		width : "auto",
		height : "100%",
		nowrap : false,
		iconCls : "icon-save",
		striped : true,
		pagination : true,
		rownumbers : true,
		pageNumber : 1,
		pageSize : 10,
		pageList : [ 5, 10, 20, 50 ],
		border : false,
		queryParams : {
			"orgId" : $("#orgId").val(),
			userStateCd : $("#userStateCd").combobox("getValue"),
			userName : $("#userName").val(),
			accountName : $("#accountName").val()
		},
		singleSelect : true,
		loadMsg : "数据加载中……",
		columns : columns
	});
}


function deleteUser(user_id) {
	$.messager.confirm("提示", "确定删除？", function(r) {
		if (r) {
			$.ajax({
				url : "../user/deleteUser.do?userId=" + user_id,
				data : "",
				async : false,
				dataType : "html",
				success : function(data) {
					$.messager.alert("提示", data);
					loadUsers();
				}
			});
		}
	});
}

function addUser() {
	var orgId = $("#orgId").val();
	$("#editUserWindow").window(
			{
				title : "新增用户",
				href : window.contextPath + "/user/editUser.do?orgId=" + orgId
						+ "&opr=add",
				width : 540,
				height : 200,
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


/*
 *修改用户
 */
function editUser(userId) {
	var orgId = $("#orgId").val();
	if (typeof orgId == "undefined") {
		orgId = 71;
	}
	$("#editUserWindow").window(
			{
				title : "修改用户",
				href : window.contextPath + "/user/editUser.do?userId="
						+ userId + "&orgId=" + orgId + "&opr=edit",
				width : 540,
				/*wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-453 高度太小，已调大。*/
				height : 200,
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



function userPermission() {
	var checked = $("#dataGrid").datagrid("getSelected");
	if (checked == null) {
		$.messager.alert("提示", "请选择一个用户");
		return;
	}
	$("#userRoleWindow").load(
			window.contextPath + "/role/userRole.do?userId=" + checked.userId);
	$("#userRoleWindow").window({
		modal : true
	});
	$("#userRoleWindow").window("open");
}