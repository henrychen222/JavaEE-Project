<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-454 布局不好看，修复布局。 -->
<script
	src="<%=request.getContextPath()%>/common/js/framework/add_role.js"
	type="text/javascript"></script>
<div id="parse_add_role" style="padding-left:20px;padding-top:10px;">
	<input type="hidden" id="hasRoles" value="${hasRoles}" /> <input
		type="hidden" id="userId" value="${userId}" />
	<table style="margin:0 auto;">
		<tr height="50">
			<c:forEach items="${roles}" var="item" varStatus="status">
				<td>		
					<input id="chk_${status.index}" name="chk_${status.index}" type="checkbox" value="${item.roleId}" />
					<label for="chk_${status.index}">${item.roleName }</label>
					<c:if test="${status.index%6==5}">
						</tr>
						<tr height="50">
					</c:if>
				</td>
			</c:forEach>
		</tr>
	</table>
	<div style="height:20px;"></div>
	<table>
		<tr height="30">
			<td align="right" width=100><label>注册时间：</label>
			</td>
			<td align="left"><input id="startDate" class="Wdate smwid1"
				type="text" onclick="WdatePicker()" required />
			</td>
			<td align="right" width=100><label>到期时间：</label>
			</td>
			<td align="left"><input id="endDate" class="Wdate smwid1"
				type="text" onclick="WdatePicker()" required />
			</td>
		</tr>
	</table>
	<div style="height:20px;"></div>
</div>
<a href="javascript:void(0)" class="easyui-linkbutton" style="display:block;margin:0 auto;width:50px;"
	onclick="javascript:saveUserRole()">提交</a>