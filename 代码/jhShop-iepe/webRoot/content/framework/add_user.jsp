<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/easyui/icon.css"/>
<div id="parse_add_role"
	style=" overflow:auto;  border:solid 1px #CCC; background:#FFF;width:675px;height:260px;">
	<div>
		<form id="addPositionform" method="post"
			action="${pageContext.request.contextPath}/position/saveUserPosition.do" target="workSpace">
			<input type="text"  class="easyui-validatebox" style="width:295px;margin-left: 100px" onpropertychange ="searchPosition(this)"/>
			<img src='<%=request.getContextPath()%>/common/style/imgs/search.png'>
			<div class="eauiDList" align="center">
				<input id="text" type ="hidden" value = "${param.orgId}"></input>
				<input id="id" type ="hidden" value = "${param.showId}"></input>
				<input type="hidden" id="addRoleUserId" name="addRoleUserId" value="${param.positionId}" />
				<ul style= "margin-left: 100px">
				  <li class="list"  style="width:300px;" align="right">
				   <div id="orgTree" align="left"  style=" float:left;overflow:auto; width:100%;height:154px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
						<ul id="allPositions" class="easyui-tree" ></ul>
				   </div>
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
							 <input id="startDate" class="Wdate smwid1" type="text" onclick="WdatePicker()" required/>
						</td>
						<td align="right" width=100>
							<!-- <label>到期时间：</label> -->
						</td>
						<td align="left" >
							 <input id="endDate" class="Wdate smwid1" type="hidden" onclick="WdatePicker()" required/>
						</td>
					</tr>
				</table>
			</div>
			<div style="width:99%;text-align: center; padding-top: 12px;float:left;">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:savePositionUser()">提交</a>
			</div>
		</form>
	</div>
</div>
<script>
	var lastValue="";
	var roles = new Array();
	$(document).ready(function() {
		var posHeight = $(".pos").height();
		$('#allPositions').tree({ 
			url:'${pageContext.request.contextPath}/org/loadOrgUser.do?orgId=',//loadUserOrg
			onClick: function(node){    
				$("#text").val(node.text);
				$("#id").val(node.id);
			},
			onBeforeExpand:function(node,param){
                $('#allPositions').tree('options').url = '${pageContext.request.contextPath}/org/loadOrgUser.do?orgId=' + node.id;// change the url                       
            }

		}); 
		
		$.parser.parse($("#parse_add_role").parent());
		$("#allPositions").dblclick(function(){
				addToUserRole();
			});	
		
		$("#allPositions").find("option").each(function (){
			var obj = new Object();
			obj.roleId = $(this).val();
			obj.roleName = $(this).text();
			roles.push(obj);
		});
		$("#startDate").val(new Date().format("yyyy-MM-dd hh:mm:ss")); 
	
	});

	
	
	
	function searchPosition(t){
		var value = $(t).val();
		if(lastValue == value){
			return;
		}
		lastValue = value;
		if(value == ""){//isStringNull(value)
			$('#allPositions').tree({ 
				url:'${pageContext.request.contextPath}/org/loadOrgUser.do?orgId=',
				onClick: function(node){
					$("#text").val(node.text);
					$("#id").val(node.id);
				},
				onBeforeExpand:function(node,param){
	                $('#allPositions').tree('options').url = '${pageContext.request.contextPath}/org/loadOrgUser.do?orgId=' + node.id;// change the url                       
	            }
			}); 
		}else{
			$('#allPositions').tree({ 
				url:'${pageContext.request.contextPath}/org/loadOrgUserDim.do?orgId=&userName='+value+'',
				onClick: function(node){        
					$("#text").val(node.text);
					$("#id").val(node.id);
				},
				onBeforeExpand:function(node,param){
	                $('#allPositions').tree('options').url = '${pageContext.request.contextPath}/org/loadOrgUserDim.do?orgId='+node.id+'&userName='+value+'';// change the url                       
	            }
			}); 
			$("#allPositions").dblclick(function(){
				addToUserRole();
			});	
		}
		
	}
	
	function addToUserRole(){
		var selObj = $("#userRoles");
		var value=$("#id").val();//选中用户id
		var text=$("#text").val();//选中用户名称
		
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
	
	function savePositionUser(){
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
			url : '${pageContext.request.contextPath}/user/savePositionUser.do?userIds='+roles.join()+'&positionId='+userId+"&startDate="+startDate,
			data : "",
			async : false,
			success : function(data) {
						//alert(data);
						$.messager.alert('提示',data);
						loadRoles();
			$("#addUserWindow").window("close");
			}
		});
		
		
	}
	
	
	function removeFromUserRole(){
		var selOpt = $("#userRoles option:selected");
		selOpt.remove();
	}
	
	
</script>