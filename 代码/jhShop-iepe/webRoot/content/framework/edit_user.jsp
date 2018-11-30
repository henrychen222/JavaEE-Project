<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/js/framework/edit_user.js"></script>
<c:if test="${param.opr=='add'}">
	<input type="hidden" id="isAdd" value="1" />
</c:if>
<form id="ff" method="post">
	<input type="hidden" name="showId" value="${param.orgId}" /> <input
		type="hidden" name="userId" value="${userInfo.userId}" /> <input
		type="hidden" id="val_orgId" value="${userInfo.org.orgId}" /> <input
		type="hidden" id="val_parentOrgs" value="${parentOrgs}" />
	<table>
		<tr height="30">
			<td align="right" width=100><label>用户名称：</label><label
				style="color: red;">*</label>
			</td>
			<!-- wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-452 原来没有校验，这里加上。 -->
			<td align="left"><input name="userName" id="uname"
				class="easyui-validatebox" type="text" data-options="required:true,validType:'length[1,100]'"
				value="${userInfo.userName}" />
			</td>
			<td align="right" width=100><label>用户账号：</label><label
				style="color: red;">*</label>
			</td>
			<td align="left"><input name="accountName" id="uaccountname"
				class="easyui-validatebox" type="text" data-options="required:true,validType:'length[1,100]'"
				value="${userInfo.accountName}" /></td>
		</tr>
		
			<tr height="30">
				<td align="right" width=100><label>密码：</label><label
					style="color: red;">*</label>
				</td>
				<td align="left"><input name="accountPasswordCd" id="uPwd"
					class="easyui-validatebox" type="password"
					data-options="required:true,validType:'length[1,100]'" value="${userInfo.accountPasswordCd}" />
				</td>
				<td align="right" width=100><label>确认密码：</label><label
					style="color: red;">*</label>
				</td>
				<td align="left"><input name="accountPassworkCdRepeat"
					id="urePwd" class="easyui-validatebox" type="password"
					validType="equalTo['#uPwd']" value="${userInfo.accountPasswordCd}"
					data-options="required:true,validType:'length[1,100]'" /></td>
			</tr>
		
		<tr height="30">
			<td align="right" width=100><label>所属机构：</label><label
				style="color: red;">*</label>
			</td>
			<td align="left" colspan=3><input id="org_orgId"
				name="org.orgId" class="easyui-combotree" style="width: 410px">
			</td>
		</tr>
		<tr height="30">
			<td align="right" width=100><label>联系电话：</label>
			</td>
			<td align="left"><input name="phoneNumber" type="text"
				class="easyui-validatebox,validType:'length[1,100]'" value="${userInfo.phoneNumber}" />
			</td>
			<td align="right" width=100><label>状态：</label>
			</td>
			<td align="left"><select name="userStateCd"
				class="easyui-combobox" style="width: 150px"
				data-options="panelHeight:'auto'">
					<option value="1"
						<c:if test="${userInfo.userStateCd=='1'}" >selected</c:if>>有效</option>
					<option value="0"
						<c:if test="${userInfo.userStateCd=='0'}" >selected</c:if>>无效</option>
			</select>
			</td>
		</tr>
		<tr height="30">
			<td colspan='4' align="center"><a href="javascript:void(0)"
				iconCls="icon-save" class="easyui-linkbutton"
				onclick="javascript:saveUser()">提交</a></td>
		</tr>
	</table>
</form>
