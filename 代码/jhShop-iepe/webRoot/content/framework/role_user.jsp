<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<div id="parse_user_role">
<input type="hidden" id ="permissionRoleId" name = "permissionRoleId" value ="${param.roleId}"/>
<table id="list_user" cellspacing="0" cellpadding="0" style="height: 400px">  
</table> 
</div>
<div id="userRole_toolbar" style="padding:2px;height:25px">
    <div style="margin-bottom:2px">
        <a href="javascript:addRoleUser()" class="easyui-linkbutton">添加用户</a>
      <!--   <a href="javascript:deleteUserRole()" class="easyui-linkbutton">删除用户</a>  -->
    </div>
</div>

<div id="roleUserWindow" class="easyui-window" title="添加用户" data-options="iconCls:'icon-save',minimizable:true,maximizable:true,collapsible:true,closed: true" style="width:720px;height:320px;padding:10px;">
</div>
<script>
	function loadUsers(){
		var roleId = "${param.roleId}";
		loadUsersByRoleId(roleId);
	}
	function loadUsersByRoleId(roleId){
		$('#list_user').datagrid({
			url:"${pageContext.request.contextPath}/role/getUserByRole.do?roleId="+roleId,
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
			{field:'userId',checkbox:true,width:10},
			{field:'userName',title:'用户名称',width:120,align:'center'},
			{field:'accountName',title:'账号',width:120,align:'center'},
			{field:'orgName',title:'所属机构',width:200,align:'center'}
			]],
			toolbar: '#userRole_toolbar'
			});
		}
	$(document).ready(function(){
		$.parser.parse($("#parse_user_role").parent());
		loadUsers();
	});
	
	
	function deleteUserRole(){
	var roleId = $("#permissionRoleId").val();
	var str=new Array();
	$("#parse_user_role").find("[name='userId']:checked").each(function(){  
			str.push($(this).val());  
		});
	if(str.length==0){
		$.messager.alert('提示',"至少选择一条记录！");
		return;
	}
	$.messager.confirm('提示','确定要删除数据吗？',function(r){   
    if (r){   
        $.ajax( {
			url : '${pageContext.request.contextPath}/role/deleteUserRole.do?userId='+str.join()+'&roleId='+roleId,
			data : "",
			async : false,
			success : function(data) {
						$.messager.alert('提示',data);
						loadUsers();
				}
			});  
	    }   
	}); 
		}
	function addRoleUser(){
		var roleId = $("#permissionRoleId").val();
		$("#roleUserWindow").load('${pageContext.request.contextPath}/role/showAddRole.do?roleId='+roleId);
		$("#roleUserWindow").window("open");
	}
</script>