<#assign param>
<@compress single_line=true>
<#if (pkCols?size=0) >
	'
<#else>
<#list pkCols as col>
	<#if col_index == 0>
	?${col.code}=' + row.${col.code}
	<#else>
	+ '&${col.code}=' + row.${col.code}
	</#if>
</#list>
</#if>
</@compress>
</#assign>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%@include file="../_head.jsp" %>
  </head>
  
  <body class="easyui-layout">
  	<div data-options="region:'north'" style="height:110px;">
	    <form id="${domainObjectName}Form" style="padding:10 0 0 0;margin:0px;">
			<table width="100%" border="0" cellspacing="3" cellpadding="0">
				<#list queryCols as col>
				<#if col_index%3 == 0>
				<tr>
				</#if>
					<td align="right" width="13%">${col.name?if_exists}:</td>
					<td align="left" width="20%">${col.text?if_exists}</td>
					<#if col_index%3 < 2 && !col_has_next>
					<#if col_index%3 == 0>
					<td align="right" width="13%">&nbsp;</td>
					<td align="left" width="20%">&nbsp;</td>
					<td align="right" width="13%">&nbsp;</td>
					<td align="left" width="20%">&nbsp;</td>
					<#elseif col_index%3 == 1>
					<td align="right" width="13%">&nbsp;</td>
					<td align="left" width="20%">&nbsp;</td>
					</#if>
					</#if>
				<#if col_index%3 == 2 || !col_has_next>
				</tr>
				</#if>
				</#list>
				<tr>
					<td align="right" colspan="6">
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="list();">查询</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="add();">增加</a>  
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="edit();">修改</a>  
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="detail();">详情</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="del();">删除</a>  
					</td>
				</tr>
			</table>
	    </form>
  	</div>
  	<div data-options="region:'center'">
		<table id="${domainObjectName}Grid" class="easyui-datagrid" data-options="border:false,fit:true,nowrap:false,pageSize:20,
				rownumbers:true,striped:true,singleSelect:true,pagination:true,url:'${domainObjectName}/list.do'">
			<thead>
				<tr>
					<th field="ck" checkbox="true"></th>
				    <#list displayCols as col>
				    ${col.text?if_exists}
					</#list>
				</tr>
			</thead>
		</table>
  	</div>
  	
  	<div id="${domainObjectName}Win" class="easyui-window" title="员工" style="width:600px;height:400px"   
        data-options="collapsible:false,minimizable:false,maximizable:false,resizable:false,closed:true">   
	</div>
	
	<script type="text/javascript">
		function list(){
			var array = ${"$"}('#${domainObjectName}Form').serializeArray();
			var json = ${"$"}.array2Json(array);
			${"$"}('#${domainObjectName}Grid').datagrid('load',json); 
		}
		
		function add(){
			${"$"}('#${domainObjectName}Win').window('open').window('refresh', '${domainObjectName}/add.do');  
		}
		
		function edit(){
			var row = ${"$"}('#${domainObjectName}Grid').datagrid('getSelected');
			if (!row){  
				${"$"}.messager.alert('警告','请选择一条记录！','warning');
	         	return; 
		    }
		   	${"$"}('#${domainObjectName}Win').window('open').window('refresh', '${domainObjectName}/edit.do${param});
		}
		
		function detail(){
			var row = ${"$"}('#${domainObjectName}Grid').datagrid('getSelected');
			if (!row){  
				${"$"}.messager.alert('警告','请选择一条记录！','warning');
	         	return; 
		    }
			${"$"}('#${domainObjectName}Win').window('open').window('refresh', '${domainObjectName}/detail.do${param});
		}
		
		function del(){
			var row = ${"$"}('#${domainObjectName}Grid').datagrid('getSelected');
			if (!row){  
				${"$"}.messager.alert('警告','请选择一条记录！','warning');
	         	return; 
		    }
		    ${"$"}.post(
		   		'${domainObjectName}/delete.do${param},
		   		function(data){
		   			var rs = ${"$"}.parseJSON(data);
		   			${"$"}.messager.alert('信息',rs.msg,'info');
		   			list();
		   		}
		   	);
		}
	</script>
  </body>
</html>
