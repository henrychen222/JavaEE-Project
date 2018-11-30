$(function() {
	loadMenuTree($("#parentMenuId"), "-1");
	loadMenu();
});

function loadMenu(showId) {
	$("#menuTree")
			.tree(
					{
						url : window.contextPath
								+ '/menu/loadMenuTree.do?menuId=-1'
								+ '&opr=load',
						onClick : function(node) {
							$
									.ajax({
										url : window.contextPath
												+ "/menu/selectMenuById.do?menuId="
												+ node.id + "&opr=edit",
										data : "",
										async : false,
										dataType : "html",
										success : function(data) {
											var obj = eval("(" + data + ")");
											$("#menuId").val(obj.menuId);
											$("#name").val(obj.name);
											$("#title").val(obj.title);
											loadMenuTree($("#parentMenuId"),
													obj.parentMenuId);
											$("#uri").val(obj.uri);
											// wangyan modified @ 20141010 for
											// checked adapt in chrome/firefox
											$(
													"input[type='radio'][id^='menuType']")
													.removeAttr("checked");
											$("#menuType" + obj.menuTypeCd)[0].checked = true;
											if (obj.menuTypeCd == '1') {
												$("#parentMenuId").combotree(
														'disable');
											} else {
												$("#parentMenuId").combotree(
														'enable');
											}
											$("#desc").val(obj.desc);
											$("#icon").val(obj.icon);
											$("#menu_delete").show();
											$("#myform")
													.attr(
															"action",
															window.contextPath
																	+ "/menu/editMenu.do");
										}
									});
						},
						onBeforeExpand : function(node, param) {
							$("#menuTree").tree("options").url = window.contextPath
									+ "/menu/loadMenuTree.do?menuId=" + node.id;
						},
						onLoadSuccess : function(node, param) {
							if (showId != null && showId != "") {
								$
										.ajax({
											url : window.contextPath
													+ "/menu/getParentMenusById.do?menuId="
													+ showId,
											data : "",
											async : false,
											dataType : "html",
											success : function(data) {
												var pOrgObj = new Array();
												pOrgObj = data.split(',');
												if (pOrgObj != null) {
													for (var i = 0; i < pOrgObj.length; i++) {
														if (pOrgObj[i] != "") {
															var n = $(
																	"#menuTree")
																	.tree(
																			"find",
																			pOrgObj[i]);
															if (n != null
																	&& n.state != 'open') {
																if (i < pOrgObj.length - 1) {
																	$(
																			"#menuTree")
																			.tree(
																					'expand',
																					n.target);
																} else {
																	$(
																			"#menuTree")
																			.tree(
																					'select',
																					n.target);
																}
															}
														}
													}
												}
											}
										});
							}
						}
					});
}

function loadMenuTree(combotreeDom, showId) {
	combotreeDom.combotree({
		editable : true
	});
	combotreeDom
			.combotree("tree")
			.tree(
					{
						url : window.contextPath
								+ '/menu/loadMenuTree.do?menuId=-1',
						onBeforeExpand : function(node, param) {
							combotreeDom.combotree("tree").tree('options').url = window.contextPath
									+ '/menu/loadMenuTree.do?menuId=' + node.id;// change
							// the
							// url
						},
						onLoadSuccess : function(node, param) {
							if (showId != null && showId != "") {
								$
										.ajax({
											url : window.contextPath
													+ "/menu/getParentMenusById.do?menuId="
													+ showId,
											data : "",
											async : false,
											dataType : "html",
											success : function(data) {
												var pOrgObj = new Array();
												pOrgObj = data.split(',');
												if (pOrgObj != null) {
													for (var i = 0; i < pOrgObj.length; i++) {
														if (pOrgObj[i] != "") {
															var n = combotreeDom
																	.combotree(
																			"tree")
																	.tree(
																			"find",
																			pOrgObj[i]);
															if (n != null
																	&& n.state == 'closed') {
																if (i < pOrgObj.length - 1) {
																	combotreeDom
																			.combotree(
																					"tree")
																			.tree(
																					'expand',
																					n.target);
																} else {
																	combotreeDom
																			.combotree(
																					"tree")
																			.tree(
																					'select',
																					n.target);
																}
															}
														}
													}
												}
												combotreeDom.combotree(
														"setValue", showId);
											}
										});
							}
						}
					});
}

function loadDetail(menuId) {
	$("#menuDiv").load(
			"../menu/selectMenuById.do?menuId=" + menuId + "&opr=edit");
}
function addMenu() {
	$("#menuId").val(0);
	$("#name").val("");
	$("#title").val("");
	loadMenuTree($("#parentMenuId"), "-1");
	$("#uri").val("");
	// wangyan modified @ 20141010 for checked adapt in chrome/firefox
	$("#menuType2")[0].checked = true;
	$("#parentMenuId").combotree('enable');
	$("#desc").val("");
	$("#icon").val("");
	$("#menu_delete").hide();
	$("#myform").attr("action", window.contextPath + "/menu/addMenu.do");
}

function edit() {
	/*wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-467 原来这里没有表单验证。这里加上。*/
	if (!$("#myform").form("validate")) {
		return;
	}
	if ($("#desc").text().length > 250) {
		alert("描述超长！");
		return;
	}
	if (confirm("确定要修改数据吗？")) {
		var str = "";
		// wangyan modified @ 20141010 for checked adapt in chrome/firefox
		$("[name='menuTypeCd']").each(function() {
			if (this.checked) {
				str = this.value;
			}
		});
		if (str == '1') {
			$("#parentMenuId").combotree('enable');
			subProductForm();
			$("#parentMenuId").combotree('disable');
		} else {
			subProductForm();
		}
	}
}

function subProductForm() {
	ajaxSubmit($("#myform").attr("action"), $('#myform'), function(r) {
		var obj = eval("(" + r + ")");
		alert(obj.result);
		loadMenu(obj.menu.menuId);
		$("#menuId").val(obj.menu.menuId);
		$("#name").val(obj.menu.name);
		$("#title").val(obj.menu.title);
		loadMenuTree($("#parentMenuId"), obj.menu.parentMenuId);
		$("#uri").val(obj.menu.uri);
		// wangyan modified @ 20141010 for checked adapt in chrome/firefox
		$("#menuType" + obj.menu.menuTypeCd)[0].checked = true;
		if (obj.menu.menuTypeCd == '1') {
			$("#parentMenuId").combotree('disable');
		} else {
			$("#parentMenuId").combotree('enable');
		}
		$("#desc").val(obj.menu.desc);
		$("#icon").val(obj.menu.icon);
		$("#menu_delete").show();
		$("#myform").attr("action", window.contextPath + "/menu/editMenu.do");

	});
}

function deleteMenu() {
	var menuId = $("#menuId").val();
	$.ajax({
		url : window.contextPath + '/menu/checkHasSon.do?menuId=' + menuId,
		data : "",
		async : false,
		success : function(data) {
			if (data == "Y") {
				alert("存在子菜单，无法删除！");
			} else {
				if (confirm('确定删除？')) {
					$.ajax({
						url : window.contextPath
								+ '/menu/deleteMenu.do?menuId=' + menuId,
						data : "",
						async : false,
						success : function(data) {
							var obj = eval("(" + data + ")");
							alert(obj.result);
							loadMenu();
							addMenu();
						}
					});
				}
			}
		}
	});
}
var parentMenuId = $("#parentMenuId").val();
function checkType() {
	if ($("#parentMenuId").combotree("getValue") != "") {
		parentMenuId = $("#parentMenuId").combotree("getValue");
	}
	// wangyan modified @ 20141010 for checked adapt in chrome/firefox
	var str = "";
	$("[name='menuTypeCd']").each(function() {
		if (this.checked) {
			str = this.value;
		}
	});
	if (str == '1') {
		$("#parentMenuId").combotree("setValue", "-1");
		$("#parentMenuId").combotree('disable');
	} else {
		$("#parentMenuId").combotree("setValue", parentMenuId);
		$("#parentMenuId").combotree('enable');
	}
}