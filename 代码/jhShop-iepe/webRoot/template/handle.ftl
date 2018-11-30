<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form id="${domainObjectName}HandleForm" method="POST">
	<#list editCols as col>
	<#if col.hidden == "true">
	${col.text?if_exists}
	</#if>
	</#list>
	<table width="100%" border="0" cellspacing="3" cellpadding="0">
		<#list editCols as col>
		<#if col.hidden == "false">
		<tr>
			<td align="right" width="40%">${col.name?if_exists}：</td>
			<td align="left" width="60%">${col.text?if_exists}</td>
		</tr>
		</#if>
		</#list>
		<c:if test="${"$"}{opr!='detail'}">
		<tr>
			<td align="center" colspan="2">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="save();">保存</a>
			</td>
		</tr>
		</c:if>
	</table>
</form>

<script>
<c:if test="${"$"}{opr!='detail'}">
	function save(){
		${"$"}('#${domainObjectName}HandleForm').form('submit', {
			<c:if test="${"$"}{opr=='add'}">
			url:'${domainObjectName}/insert.do', 
			</c:if>
			<c:if test="${"$"}{opr=='edit'}">
			url:'${domainObjectName}/update.do', 
			</c:if>
	        onSubmit: function(){   
				return ${"$"}(this).form('validate');
	        }, 
			success:function(data){
	   			var rs = ${"$"}.parseJSON(data);
		        ${"$"}.messager.alert('信息',rs.msg,'info');
		        ${"$"}('#${domainObjectName}Win').window('close');
		        list();
			}
		});
	}
</c:if>
</script>