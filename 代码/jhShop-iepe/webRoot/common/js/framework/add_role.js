$(function() {
	$.parser.parse($("#parse_add_role").parent());
	var arr = $("#hasRoles").val().split(",");
	$("#parse_add_role").find("input[type='checkbox']").prop("checked", false);
	for ( var i in arr) {
		var roleId = arr[i];
		$("#parse_add_role").find(
				"input[type='checkbox'][value='" + roleId + "']").prop(
				"checked", true);
	}
	/*wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-456 格式化字符串中去除时分秒。*/
	$("#parse_add_role").find("#startDate").val(
			new Date().format("yyyy-MM-dd"));
	var d = new Date();
	d.setFullYear(d.getFullYear() + 1, d.getMonth(), d.getDate());
	$("#parse_add_role").find("#endDate").val(d.format("yyyy-MM-dd"));
});

function saveUserRole() {
	var roleIds = [];
	$("#parse_add_role").find("input[type='checkbox']:checked").each(
			function() {
				var o = $(this);
				roleIds.push(o.val());
			});
	
	$.ajax({
		url : window.contextPath + "/role/saveUserRole.do",
		data : {userId : $("#userId").val(),roleIds : roleIds.join(),startDate : $("#startDate").val(),endDate : $("#endDate").val()},
		async : false,
		dataType : "html",
		success : function(data) {
			$.messager.alert('提示', data);
			loadRoles();
			$("#addRoleWindow").window("close");
		}
	});
	
	
	
}
