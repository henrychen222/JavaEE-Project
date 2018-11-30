var editor;

$(function() {
	loadMenuTree($("#parentMenuId"), "-2");
	loadMenu();
	editor = KindEditor.create($('textarea[id="paramterarea"]'), {
		 height : "350px",
		uploadJson : window.contextPath + "/reqfwd/forKindEditor.do"
		//afterBlur: function(){this.sync();}
	});
	 $('#level').combobox({  
         onChange:function(){
        	 var flag = $('#level').combobox('getValue');
        	 if(flag == 3)
        	{
        		 document.getElementById("kit").style.display='';
        		 document.getElementById("uri").value = "/help/showPage.do"
        	}else
        		{
        		 document.getElementById("kit").style.display='none';
        		 document.getElementById("uri").value = ""
        		}
             }
         }) 
});

function loadMenu(showId) {
	$("#menuTree")
			.tree(
					{
						url : window.contextPath
								+ '/help/loadMenuTree.do?menuId=-2'
								+ '&opr=load',
						onClick : function(node) {
							$
									.ajax({
										url : window.contextPath
												+ "/help/selectMenuById.do?menuId="
												+ node.id + "&opr=edit",
										data : "",
										async : false,
										dataType : "html",
										success : function(data) {
											var obj = eval("(" + data + ")");
											$("#menuId").val(obj.menuId);
											$("#name").val(obj.name);
											loadMenuTree($("#parentMenuId"),
													obj.parentMenuId);
											$("#uri").val(obj.uri);
											$("#menuSortCd").numberbox('setValue', obj.menuSortCd);
											$('#level').combobox('select',obj.level);
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
											//$("#paramterarea").val("111");
											editor.html(obj.count);
											$("#count").val(obj.count);											
											$("#menu_delete").show();
											$("#myform")
													.attr(
															"action",
															window.contextPath
																	+ "/help/editMenu.do");
										}
									});
						},
						onBeforeExpand : function(node, param) {
							$("#menuTree").tree("options").url = window.contextPath
									+ "/help/loadMenuTree.do?menuId=" + node.id;
						},
						onLoadSuccess : function(node, param) {
							if (showId != null && showId != "") {
								$
										.ajax({
											url : window.contextPath
													+ "/help/getParentMenusById.do?menuId="
													+ showId,
											data : "",
											async : false,
											dataType : "html",
											success : function(data) {
												var pOrgObj = new Array();
												pOrgObj = data.split(',');
												if (pOrgObj != null) {
													for ( var i = 0; i < pOrgObj.length; i++) {
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
								+ '/help/loadMenuTree.do?menuId=-2',
						onBeforeExpand : function(node, param) {
							combotreeDom.combotree("tree").tree('options').url = window.contextPath
									+ '/help/loadMenuTree.do?menuId=' + node.id;// change
							// the
							// url
						},
						onLoadSuccess : function(node, param) {
							if (showId != null && showId != "") {
								$
										.ajax({
											url : window.contextPath
													+ "/help/getParentMenusById.do?menuId="
													+ showId,
											data : "",
											async : false,
											dataType : "html",
											success : function(data) {
												var pOrgObj = new Array();
												pOrgObj = data.split(',');
												if (pOrgObj != null) {
													for ( var i = 0; i < pOrgObj.length; i++) {
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
			"../help/selectMenuById.do?menuId=" + menuId + "&opr=edit");
}
function addMenu() {
	$("#menuId").val(0);
	$("#name").val("");
	$("#title").val("");
	loadMenuTree($("#parentMenuId"), "-2");
	$("#uri").val("");
	// wangyan modified @ 20141010 for checked adapt in chrome/firefox
	$("#menuType2")[0].checked = true;
	$("#parentMenuId").combotree('enable');
	$("#desc").val("");
	/*$("#menuSortCd").val("");*/
	$("#menuSortCd").numberbox('setValue','');
	$("#menu_delete").hide();
	$('#level').combobox('select',"请选择");
	document.getElementById("kit").style.display='none';
	$("#myform").attr("action", window.contextPath + "/help/addMenu.do");
}

function edit() {
	var name = $("#name").val().replace(/(^\s*)|(\s*$)/g, "");
	var number = $("#menuSortCd").val().replace(/(^\s*)|(\s*$)/g, "");
	if(name.length > 20){
		$.messager.alert("提示","菜单名称长度不能超过20个字符");
		return;
	}
	if(name =="" || number =="")
		{
		$.messager.alert("提示","菜单名称和菜单序号不能为空");
		return;
		}
	var reg = "^(0|[1-9][0-9]{0,3})$"; 
	var re = new RegExp(reg);

	if (number.search(re) == -1) {

		$.messager.alert("提示","请输入四位以内正整数菜单序号");
		return;

	} 
	var level = $('#level').combobox('getValue');
	var parentMent = $('#parentMenuId').combotree('getValue');
	if(parentMent !="-2" && parentMent !="") 
	{
		$.ajax( {
			url : window.contextPath+'/help/selectMenuById.do?menuId='+parentMent,
			data : "",
			async : false,
			success : function(data) {
				var obj = eval("(" + data + ")");
				$("#objLevel").val(obj.level)
			}
		});
	}
	var str = "";
	$("[name='menuTypeCd']").each(function() {
		if (this.checked) {
			str = this.value;
		}
	});
	if(level =="1")
	{
	
		if(parentMent != "-2" || str !="1")
		{
			$.messager.alert("提示","菜单为类别时,菜单类型请选择导航菜单");
			return;
		}
	}
	else if(level == "2")
	{
		var value = $("#objLevel").val();
		if( str !="2")
		{
			$.messager.alert("提示","菜单为一级时,菜单类型请选择树形菜单");
			return;
		}
		if(value != "1" )
		{
			$.messager.alert("提示","上级菜单请选择类别父菜单");
			return;
		}
	}
	else if(level == "3")
	{
		var value = $("#objLevel").val();
		if( str !="2")
		{
			$.messager.alert("提示","菜单为一级时,菜单类型请选择树形菜单");
			return;
		}
		if(value != "2" )
		{
			$.messager.alert("提示","上级菜单请选择一级菜单");
			return;
		}
	}else
	{
		    $.messager.alert("提示","请选择菜单级别");
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
			$("#count").val(editor.html());
			subProductForm();
		}
	}
}

function subProductForm() {
	ajaxSubmit($("#myform").attr("action"), $('#myform'), function(r) {
		var obj = eval("(" + r + ")");
		$.messager.alert('信息',obj.result,'info');
		loadMenu(obj.menu.menuId);
		$("#menuId").val(obj.menu.menuId);
		$("#name").val(obj.menu.name);
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
		$("#menu_delete").show();
		$("#myform").attr("action", window.contextPath + "/help/editMenu.do");

	});
}

function deleteMenu() {
	var menuId = $("#menuId").val();
	$.ajax({
		url : window.contextPath + '/help/checkHasSon.do?menuId=' + menuId,
		data : "",
		async : false,
		success : function(data) {
			if (data == "Y") {
				$.messager.alert("提示","存在子菜单，无法删除！");
			} else {
				if (confirm('确定删除？')) {
					$.ajax({
						url : window.contextPath
								+ '/help/deleteMenu.do?menuId=' + menuId,
						data : "",
						async : false,
						success : function(data) {
							var obj = eval("(" + data + ")");
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
		$("#parentMenuId").combotree("setValue", "-2");
		$("#parentMenuId").combotree('disable');
	} else {
		$("#parentMenuId").combotree("setValue", parentMenuId);
		$("#parentMenuId").combotree('enable');
	}
}