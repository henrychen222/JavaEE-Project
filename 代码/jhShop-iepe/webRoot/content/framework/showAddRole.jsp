<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="parse_add_user"
	style=" overflow:auto;  border:solid 1px #CCC; background:#FFF;">
	<input type="hidden" id="roleId" value = "${param.roleId}"/>
	<div>
		<form id="addRoleform" method="post"
			action="${pageContext.request.contextPath}/role/saveUserRole.do" target="workSpace">
			<div align="center">
				<table>
					<tr height="30">
						<td align="right" width=100> 选择用户：</td>
						<td colespan="3"><input id="roleUserName" name = 'roleUserName' class="easyui-validatebox validatebox-text" type="text" onclick="javascript:comSelectUser('roleUserName','roleUserId','n','',null,null)"/>
              			<input id="roleUserId" name = 'roleUserId' type="hidden" /></td>
					</tr>
					<tr height="30">
						<td align="right" width=100>
							<label>注册时间：</label>
						</td>
						<td align="left">
							 <input id="startDate" class="Wdate smwid1" type="text" onclick="WdatePicker()" required/>
						</td>
						<td align="right" width=100>
							<label>到期时间：</label>
						</td>
						<td align="left" >
							 <input id="endDate" class="Wdate smwid1" type="text" onclick="WdatePicker()" required/>
						</td>
					</tr>
				</table>
			</div>
			<div style="width:99%;text-align: center; padding-top: 12px;float:left;">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:saveUserRole()">提交</a>
			</div>
		</form>
	</div>
</div>
<script>

	$(document).ready(function (){
		$.parser.parse($("#parse_add_user").parent());
		$("#roleUserName").val("");
		$("#roleUserId").val("");
		$("#startDate").val(new Date().format("yyyy-MM-dd hh:mm:ss")); 
	});
	
	
	function saveUserRole(){
		var roleIds = $("#roleId").val();
		var userIds = $("#roleUserId").val();
		var startDate = $('#startDate').val();
		var endDate = $('#endDate').val();
		if(userIds==""){return;}
		var param = {userId:userIds,roleIds:roleIds,startDate:startDate,endDate:endDate};
		var data = Tool_Ajax('${pageContext.request.contextPath}/role/saveUserRole.do',param,'html');
		alert(data);
		loadUsersByRoleId(roleIds);
	}
	
</script>