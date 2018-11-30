<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<div id="addRole" style=" overflow:auto; height:150px; border:solid 1px #CCC; background:#FFF;">
	<div  style="width:99%;text-align: center; padding-top: 12px;float:left;">
		<form id="addform" method="post" class="easyui-form"
			action="${pageContext.request.contextPath}/role/<c:if test="${opr=='add'}">addRole.do</c:if><c:if test="${opr=='edit'}">editRole.do</c:if>">
			<div class="reptopbox">
					<input type="hidden" name='roleId' value = "${role.roleId}"/>
					<input type="hidden" name='createOp' value = "${role.createOp}"/>
					<input type="hidden" name='isDelete' value = "${role.isDelete}"/>
				<ul>
					<!-- wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-461 原来这里没有校验条件，所以会造成超长。这里加上。-->
				
			        <li> <b class="widsy">角色名称：</b>
			            <input name='roleName' class="easyui-validatebox" type="text"
							data-options="required:true,validType:'length[1,100]'" value="${role.roleName}"/>
			        </li>
			        <li> <b>角色类型：</b>
			            <select id='roleTypeCd1' name='roleTypeCd'  class="easyui-combobox" data-options="editable:false">
							<c:forEach items="${roleType}" var="rt">
								<option value="${rt.ROLE_TYPE_CD}"<c:if test="${role.roleTypeCd == rt.ROLE_TYPE_CD}">selected</c:if>>${rt.NAME}</option>
							</c:forEach>
						</select>
			        </li>
			    </ul><ul>
			        <li style="width:70%;text-align: left"> <b class="widsy">角色描述：</b>
			          <textarea name="roleDesc" class="esuitextarea" style="width:70%;height: 58px" id="roleDesc"><c:out value="${role.roleDesc}"></c:out></textarea>
			        </li>
			    </ul>
			</div>
		</form>
	</div>
</div>
<div style="width:99%;text-align: center; padding-top: 12px;float:left;">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:commitEdit()">保存</a>
</div>
<script>
	$(document).ready(function (){
		$.parser.parse($("#addRole").parent());
		/*wangyan modified @ 151117 ZBITI_2015_RJ(2)_KF002-N-209 无指定值默认给一个。*/
		setTimeout(function(){
			if(!"${role.roleTypeCd}"){
				$("#roleTypeCd1").combobox("setValue","1");
			}
			/*wangyan modified @ 151117 ZBITI_2015_RJ(2)_KF002-N-37 强制选择当前编辑的角色。*/
			else{
				$("#roleTypeCd1").combobox("setValue","${role.roleTypeCd}");
			}
		},100);
	})
</script>