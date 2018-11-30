var isSaving = 0;
var treeId = "#tt";
var hasInd = false;// 是否有指标
var workHeight = $(parent.document.getElementById("workSpace")).height() - 40;
$("#orgTree").height(workHeight);
$("#org_detail").height(workHeight);


/**
 * 初始化
 * */
$(document).ready(function() {
	loadOrgTree();
	// loadDetail();
	loadOrgs("17");
});

/**
 * 加载页面左侧树
 * 
 * */
function loadOrgTree() {
	$(treeId).tree(
			{
				url : window.contextPath + "/org/loadOrg.do?orgId=",
				onClick : function(node) {
					$("#orgId").val(node.id);
					loadDetail(node.id);
					loadOrgs(node.id);
				},
				onBeforeExpand : function(node, param) {
					$(treeId).tree("options").url = window.contextPath
							+ "/org/loadOrg.do?orgId=" + node.id;// change
					// the
					// url
				},
				onContextMenu : function(e, node) {
					e.preventDefault();
					$(this).tree("select", node.target);
					/*
					 * var id = node.id=="0"?"add":"remove";
					 * $("#"+id).menu("show",{ left: e.pageX, top: e.pageY });
					 */

				}
			});
}

/**
 * 查询选中的树节点，赋值到查询条件框内
 * 
 * */
function loadDetail(orgId) {
	$.ajax({
		url : window.contextPath + "/org/selectOrgById.do?orgId=" + orgId,
		data : "",
		async : false,
		dataType : "html",
		success : function(data) {
			var obj = eval(data);
			$("#orgName").val(obj[0].orgName);
			$("#orgCode").val(obj[0].orgCode);
			$("#orgTypeName").val(obj[0].orgTypeName);
		}
	});
}

/**
 * 加载选中的树节点的子集到列表
 * 
 * */
function loadOrgs(orgId) {
	
	var orgIdStr = $("#orgId").val();
	
	var columns = [ [
			{
				field : "userId",
				checkbox : true
			},
			{
				field : "orgName",
				title : "公司名称",
				width : 240,
				align : "center"
			},
			{
				field : "orgCode",
				title : "公司编号",
				width : 120,
				align : "center"
			},
			{
				field : "orgTypeName",
				title : "公司类型",
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
					return "<a href='#' onclick='deleteOrg(" + rowData.orgId
							+ ")'>删除</a> <a href='#' onclick='editOrg("
							+ rowData.orgId + ")'>编辑</a>";
				}
			} ] ];
	$("#list_org").datagrid({
		url : window.contextPath + "/org/selectOrgByParentId.do",
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
			"orgId" : orgId
		},
		singleSelect : true,
		loadMsg : "数据加载中......",
		columns : columns,
		toolbar : "#tb"
	});
}



/**
 * 新增 组织机构
 * 必须要选择上级机构
 */
function addOrg() {
	var orgId =  $("#orgId").val();
	if (orgId == null || orgId.length<=0){
		alert("请选择上级机构！");
		return;
	}
	$("#editOrgWindow").window(
			{
				title : "机构信息",
				href : window.contextPath
						+ "/org/editOrg.do?orgId=&opr=add&parentOrgId="
						+ $("#orgId").val(),
				width : 500,
				top : 10,
				height : 240,
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


/**
 * 删除 组织机构
 * 
 */
function deleteOrg(orgId) {
	//alert(orgId);
	$.ajax({
		url : window.contextPath + "/org/loadOrg.do?orgId=" + orgId,
		data : "",
		async : false,
		dataType : "html",
		success : function(data) {
			var obj = eval(data);
			if (obj != null && obj.length > 0) {
				alert("存在子机构，请先将子机构删除！");
			} else {
				if (confirm("确定删除？")) {
					$.ajax({
						url : window.contextPath + "/org/deleteOrg.do?orgId="
								+ orgId,
						data : "",
						async : false,
						dataType : "html",
						success : function(data) {
							alert(data);
							loadOrgs("17");
							loadOrgTree($("#tt"), $("#orgId").val());
						}
					});
				}
			}
		}
	});
}






/** 删除* */
function remove() {
	if (hasInd) {
		myAlert("请先删除相应指标！");
		return;
	}

	$.messager.confirm("提示", "确认删除？", function(r) {
		if (r) {
			var node = $(treeId).tree("getSelected");
			if (node.id == "0") {
				myAlert("此节点无法删除");
			} else {
				var url = curProjectUrl + "/index/deleteDim.do";
				var r = Tool_Ajax(url, {
					id : node.id
				});
				if (r == "1")
					$("#dimensions").tree("remove", node.target);
				else
					myAlert("删除审计单位失败！");
			}
		}
	});
}

/**
 * 更新
 */
var oldTreeText;// 更新之前的值
function update() {
	var node = $(treeId).tree("getSelected");
	if (node) {
		oldTreeText = node.text;
		$(treeId).tree("beginEdit", node.target);
	}
}
/** 更新 */
function onAfterEdit(node) {
	var newTreeText = node.text.Trim();
	if (isStringNull(newTreeText)) {
		if (newTreeText == oldTreeText) {
			return;
		}
		var url = curProjectUrl + "/index/updateDim.do";
		var dim = {
			dimensionsId : node.id,
			evaluativeDimension : newTreeText
		};
		var ret = Tool_Ajax(url, dim);
		if (ret != "1") {
			myAlert("更新失败！");
		}
	} else {
		node.text = oldTreeText;// 为空保存不变
		$(treeId).tree("update", node);
	}
}




function editO() {
	var orgCode = $("#parentCode").html() + $("#orgCode2").val();
	$("#orgCode").val(orgCode);
	if (confirm("确定要修改数据吗？")) {
		if ("${param.opr}" == "edit" || $("#orgName") != null
				|| $("#orgCode") != null) {
			subProductFormO($("#orgDetailForm").attr("action"));
		}
	}
}
function subProductFormO(url) {
	ajaxSubmit(url, $("#orgDetailForm"), function(r) {
		loadOrgs($("#orgId").val());
		loadOrgTree($("#tt"), $("#orgId").val());
	});
}

function editOrg(orgId) {
	$("#editOrgWindow").window(
			{
				title : "机构信息",
				href : window.contextPath + "/org/editOrg.do?orgId=" + orgId
						+ "&opr=edit",
				width : 500,
				top : 10,
				height : 240,
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

function reloadOrgList() {
	$("#list_org").dategrid("reload", {
		orgId : $("#orgId").val(),
		orgName : $("#orgName").val(),
		orgType : $("#userName").val()
	});
}









/** 增加维度* */
function append() {
	var t = $(treeId);
	var node = t.tree("getSelected");
	$.messager.prompt("维度名称", "请输入维度名称：", function(r) {
		if (r) {
			var dim = Tool_Ajax(curProjectUrl + "/index/saveDim.do", {
				evaluativeDimension : r
			}, "json");
			if (dim) {
				t.tree("append", {
					parent : (node ? node.target : null),
					data : [ {
						id : dim.dimensionsId,
						text : r
					} ]
				});
			} else {
				myAlert("新增失败！");
			}
		}
	});
}