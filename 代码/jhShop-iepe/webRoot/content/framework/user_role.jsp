<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<div id="parse_user_role">
<input type="hidden" id ="permissionUserId" name = "permissionUserId" value ="${param.userId}"/>
<input type="hidden" id ="resultMsg" name = "resultMsg" value ="${resultMsg}"/>
<table id="list_role" cellspacing="0" cellpadding="0" style="height: 400px">  
</table> 
</div>
<div id="userRole_toolbar" style="padding:2px;height:25px">
    <div style="margin-bottom:2px">
    <!-- wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-465 删除角色功能是有的，这里的按钮写错了，应该是编辑角色。-->
        <a href="javascript:addUserRole()" class="easyui-linkbutton">编辑角色</a>
   <!--       <a href="javascript:deleteUserRole()" class="easyui-linkbutton">删除角色</a> -->
    </div>
</div>

<div id="addRoleWindow" class="easyui-window" title="添加角色" data-options="iconCls:'icon-save',minimizable:true,maximizable:true,collapsible:true,closed: true" style="width:720px;height:320px;padding:10px;">
</div>
<script>
	function loadRoles(){
		$('#list_role').datagrid({
			url:"${pageContext.request.contextPath}/role/getRoleByUser.do?userId=${param.userId}",
			width: 'auto',
			height: 'auto',
			nowrap:false,
			iconCls:'icon-save',
			striped:true,
			pagination:true,
			rownumbers:true,
			pageNumber:1,
            pageSize:10,
            pageList:[5,10,20,50],
            singleSelect:false,
			loadMsg:'数据加载中......',
			columns:[[
			{field:'roleId',checkbox:true,width:10},
			{field:'roleName',title:'角色名称',width:120,align:'center'},
			{field:'createOpName',title:'创建人',width:120,align:'center'},
			{field:'roleTypeCdName',title:'角色类型',width:120,align:'center'},
			{field:'roleStartTime',title:'注册时间',width:120,formatter:Common.TimeFormatter,align:'center'},
			{field:'roleEndTime',title:'到期时间',width:120,formatter:Common.TimeFormatter,align:'center'}
			]],
			toolbar: '#userRole_toolbar'
			});
		}
		
	$.parser.parse($("#parse_user_role").parent());
	loadRoles();
	
	function deleteUserRole(){
	var userId = $("#permissionUserId").val();
	var str='';
	$("#parse_user_role").find("[name='roleId']:checked").each(function(){  
			str+=$(this).val()+",";  
		});
	if(str==""){
		$.messager.alert('提示',"至少选择一条记录！");
		return;
	}
	$.messager.confirm('提示','确定要删除数据吗？',function(r){   
    if (r){   
        $.ajax( {
			url : '${pageContext.request.contextPath}/role/deleteUserRole.do?userId='+userId+'&roleId='+str,
			data : "",
			async : false,
			success : function(data) {
						$.messager.alert('提示',data);
						loadRoles();
				}
			});  
	    }   
	}); 
		}
	function addUserRole(){
		var userId = $("#permissionUserId").val();
		$("#addRoleWindow").load('${pageContext.request.contextPath}/role/addRoleWindow.do?userId='+ userId);
		$("#addRoleWindow").window("open");
	}
</script>