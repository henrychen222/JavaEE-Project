<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div style=" overflow:auto;  border:solid 1px #CCC; background:#FFF;">
	<div>
		<form id = "addform" method="post"
			action="${pageContext.request.contextPath}/org/saveOrg.do" target="workSpace">
			<div>
				<input id="edit_orgId" name="orgId" type = "hidden" value="${orgInfo.orgId}"/>
				<p style="height: 40px;line-height:40px;padding-left: 20px"> <label>机构名称：</label>
					<input id="edit_orgName" name="orgName" type="text"  value="${orgInfo.orgName}" class="easyui-validatebox" data-options="required:true"/></p>
				<p style="height: 40px;line-height:40px;;padding-left: 20px"><label>机构代码：</label> 
					<input id="edit_orgCode2" name="orgCode" type = "hidden" value="${orgInfo.orgCode}"/>
					<c:if test ="${(fn:startsWith(orgInfo.orgCode,orgInfo.parentOrg.orgCode))||orgInfo.orgCode==null||orgInfo.orgCode==''}"><span id="edit_parentCode" style="font-size:14px;line-height:30px;height: 30px;">${orgInfo.parentOrg.orgCode}</span><input id="edit_orgCode" name="edit_orgCode" type="text"  value="${fn:substring(orgInfo.orgCode, fn:length(orgInfo.parentOrg.orgCode),fn:length(orgInfo.orgCode)) }" class="easyui-validatebox" data-options="required:true"/></c:if>
					<c:if test ="${!fn:startsWith(orgInfo.orgCode,orgInfo.parentOrg.orgCode)&&orgInfo.orgCode!=null&&orgInfo.orgCode!=''}"><span id="edit_parentCode" style="font-size:14px;line-height:30px;height: 30px;"></span><input id="edit_orgCode" name="edit_orgCode" type="text"  value="${orgInfo.orgCode}" class="easyui-validatebox" data-options="required:true"/></c:if>
				</p>
				<p style="height: 40px;line-height:40px;;padding-left: 20px"><label>机构类型：</label>
					<select id ="edit_orgTypeId" name="orgTypeId"  class="easyui-combobox">
						<option value="" <c:if test="${orgInfo.orgTypeId==''}">selected</c:if>>请选择...</option>
						<c:forEach items="${orgType }" var="ot" >
							<option value="${ot.ORG_TYPE_ID }" <c:if test="${orgInfo.orgTypeId==ot.ORG_TYPE_ID}">selected</c:if>>${ot.ORG_TYPE_NAME }</option>
						</c:forEach>
					</select>
				</p>
				<p style="height: 40px;line-height:40px;;padding-left: 20px">
				<label>所属机构：</label><span><c:out value="${orgInfo.parentOrg.orgName}"></c:out></span>
				<input name="parentId" value="${orgInfo.parentOrg.orgId}" type="hidden"/>
				</p>
				<div style="height: 40px;line-height:40px;" align="center">
                	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:edit()">保存</a>
				</div>
			</div>
		</form>
	</div>
</div>
<script>
	$(document).ready(function() {
	 	$.parser.parse($("#addform").parent().parent());
	 	/*wangyan modified @ 151117 ZBITI_2015_RJ(2)_KF002-N-28 无指定值默认给一个。*/
		setTimeout(function(){
			if(!"${orgInfo.orgTypeId}"){
				$("#edit_orgTypeId").combobox("setValue","1");
			}
			/*wangyan modified @ 151117 ZBITI_2015_RJ(2)_KF002-N-28 强制选择当前编辑的角色。*/
			else{
				$("#edit_orgTypeId").combobox("setValue","${orgInfo.orgTypeId}");
			}
		},100);
	});
	
	//新增组织机构
	function edit(){
		var edit_orgName = $("#edit_orgName").val();
		var orgCode = $("#edit_parentCode").html()+$("#edit_orgCode").val();
		$("#edit_orgCode2").val(orgCode);
		
		if (edit_orgName =='' || edit_orgName.length<=0){
			myAlert("机构名称不能为空！");
			return;
		}

		
		if(confirm("确定要新增数据吗？")){
			//if ('${param.opr}'=='add'||$("#eidt_orgName")!=null||$("#eidt_orgCode")!=null){
				subProductForm($("#addform").attr("action"));
			//}
		}
	}
	
	//form提交
	function subProductForm(url){
     	ajaxSubmit(url,$('#addform'), function(r){
			loadOrgs("${orgInfo.parentId}");
			loadOrgTree($("#tt"),"${orgInfo.parentId}");
			$("#editOrgWindow").window("close");
     	});
     }
</script>