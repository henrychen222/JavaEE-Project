var isAdd = $("#isAdd").val() == "1";
$(function() {
	$("#org_orgId")
			.combotree(
					{
						url : window.contextPath + "/org/loadOrg.do?orgId=",
						onBeforeExpand : function(node, param) {
							$("#org_orgId").combotree("tree").tree("options").url = window.contextPath
									+ "/org/loadOrg.do?orgId=" + node.id;
						},
						onLoadSuccess : onLoadSuccess
					});
	var url = (isAdd ? "/user/addUserInfo.do" : "/user/editUserInfo.do");
	$("#ff").form({
		url : window.contextPath + url,
		onSubmit : onSubmit,
		success : function(data) {
			$("#editUserWindow").window("close");
			$.messager.alert("提示", decodeURIComponent(data));
			$("#dataGrid").datagrid("reload");
		}
	});
});
function onLoadSuccess(node, param) {
	// add user not need expend org tree.
	if (isAdd) {
		return;
	}
	$.ajax({
		url : window.contextPath + "/org/getPatentsByOrgId.do?orgId="
				+ $("#val_orgId").val(),
		data : "",
		async : false,
		dataType : "html",
		success : function(data) {
			var pOrgObj = new Array();
			pOrgObj = data.split(",");
			if (pOrgObj != null) {
				for ( var i = 0; i < pOrgObj.length; i++) {
					if (pOrgObj[i] != "") {
						var n = $("#org_orgId").combotree("tree").tree("find",
								pOrgObj[i]);
						if (n != null && n.state == "closed") {
							if (i < pOrgObj.length - 1) {
								$("#org_orgId").combotree("tree").tree(
										"expand", n.target);
							} else {
								$("#org_orgId").combotree("tree").tree(
										"select", n.target);
							}
						}
					}
				}
			}
			$("#org_orgId").combotree("setValue", $("#val_orgId").val());
		}
	});
}
function onSubmit() {
	if ($("#org_orgId").combobox("getValue") == null
			|| $("#org_orgId").combobox("getValue") == "") {
		$.messager.alert("提示", "请选择所属机构！");
		return false;
	}
	return $("#ff").form("validate");
}
function saveUser() {
	$("#ff").form("submit");
}
