<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="parse_add_role"
	style=" overflow:auto;  border:solid 1px #CCC; background:#FFF;">
	<div>
		<form id="addRoleform" method="post"
			action="${pageContext.request.contextPath}/role/saveUserRole.do" target="workSpace">
			
			<input type="text" class="easyui-validatebox" style="margin-left: 150px;width:173px" onpropertychange ="searchRole(this)"/>
			<div class="eauiDList" align="center">
				<input type="hidden" id="addRoleUserId" name="addRoleUserId" value="${param.positionId}" />
				<ul style= "margin-left: 150px">
				  <li class="list">
				    <select id="allRoles" name="allRoles" size="10">
				      <c:forEach items="${roles }" var="item">
				      	<option value="${item.roleId }"><c:out value ="${item.roleName }"></c:out></option>
				      </c:forEach>
				    </select>
				  </li>
				  <li class="handler"><a href="#" class="arrowL" onclick="javascript:removeFromUserRole()"></a> <a href="#" class="arrowR" onclick="javascript:addToUserRole()"></a> </li>
				  <li class="list">
				    <select id="userRoles" name="userRoles" size="10">
				    </select>
				  </li>
				</ul>
				<table >
					<tr height="30">
						<td align="right" width=100>
							<label>注册时间：</label>
						</td>
						<td align="left">
							 <input id="startDate" class="Wdate smwid1" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" required/>
						</td>
						<td align="right" width=100>
							<label>到期时间：</label>
						</td>
						<td align="left" >
							 <input id="endDate" class="Wdate smwid1" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" required/>
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

	var lastValue="";
	var roles = new Array();
	$(document).ready(function (){
		$.parser.parse($("#parse_add_role").parent());
		$("#allRoles").dblclick(function(){
				addToUserRole();
			});	
		
		$("#allRoles").find("option").each(function (){
			var obj = new Object();
			obj.roleId = $(this).val();
			obj.roleName = $(this).text();
			roles.push(obj);
		});
		$("#startDate").val(new Date().format("yyyy-MM-dd")); 
	});
	
	function searchRole(t){
		var value = $(t).val();
		if(lastValue == value){
			return;
		}
		lastValue = value;
		if(value == "")
		{
			var roleSel = $("#allRoles");
			roleSel.find("option").remove();
			for(var i=0; i<roles.length; i++){
				var role = roles[i];
				roleSel.append("<option value='"+role.roleId+"'>"+role.roleName+"</option>");
			}
			firstLoad = true;
			return;
		}else{
			var showRoles = new Array();
			for(var i=0; i<roles.length; i++){
				var roleName = roles[i].roleName;
				if(roleName.indexOf(value)>=0){
					showRoles.push(roles[i]);
				}
			}
			var roleSel = $("#allRoles");
			roleSel.find("option").remove();
			
			for(var i=0; i<showRoles.length; i++){
				var role = showRoles[i];
				roleSel.append("<option value='"+role.roleId+"'>"+role.roleName+"</option>");
			}
			
			firstLoad = false;
		}
		
	}
	
	function addToUserRole(){
		var selObj = $("#userRoles");
		var value=$("#allRoles").val();
		var text=$("#allRoles option:selected").text();
		var isContent =false;
		$("#userRoles").find("option").each(function (){
			if($(this).val()==value){
				isContent =true;
			}
		});
		
		if(!isContent){
			selObj.append("<option value='"+value+"'>"+text+"</option>");
		}
	}
	
	function saveUserRole(){
		var userId = $('#addRoleUserId').val();
		var roles = new Array();
		$("#userRoles").find("option").each(function (){
			roles.push($(this).val());
		});
		var startDate = $('#startDate').val();
		var endDate = $('#endDate').val();
		if(roles.length==0){
			//alert("至少选择一条记录！");
			$.messager.alert('提示',"至少选择一条记录！");
			return;
		}
		$.ajax( {
			url : '${pageContext.request.contextPath}/role/savePositionRole.do?positionId='+userId+'&roleIds='+roles.join()+"&startDate="+startDate+"&endDate="+endDate,
			data : "",
			async : false,
			success : function(data) {
						//alert(data);
						$.messager.alert('提示',data);
						loadRoles();
			$("#addRoleWindows").window("close");
			}
		});
	}
	
	
	function removeFromUserRole(){
		var selOpt = $("#userRoles option:selected");
		selOpt.remove();
	}
	
	
</script>