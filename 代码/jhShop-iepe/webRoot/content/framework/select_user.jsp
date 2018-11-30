<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<!-- 页面隐藏值 -->
	<input id="showId" type="hidden" value="${param.showId}"></input>
	<input id="s_orgId" type="hidden" value="${s_orgId}"></input>
	<input id="s_isSingle" type="hidden" value="${s_isSingle}"></input>
	<input id="s_keyId" type="hidden" value="${s_keyId}"></input>
	<input id="s_nameId" type="hidden" value="${s_nameId}"></input>
	<input type="hidden" value="" id="userIds" />
	<span id="clock" style=" display:none;"></span>
	<div id="orgTree"
		style="float:left;overflow:auto; width:30%; height:470px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
		<ul id="tt" class="easyui-tree"></ul>
	</div>
	<div id="selectUser">
		<div class="easyui-panel" title="用户查询">
			<div id="tb-user" style="padding:5px;height:auto">
				<div style="float: left;">
					<table >
						<tr>
							<td>&nbsp;姓名：</td>
							<td>
								<input id="userName" name="userName" class="validatebox-text" />
							</td>
							<td>
								<a href="javascript:void(0)" class="easyui-linkbutton marglt10" onclick="javascript:loadUsers()"><img src="<%=request.getContextPath()%>/common/images/common/icon_bu_01.png"/>查询</a>
							</td>
						</tr>
					</table>
				</div>
				<div style="margin-bottom:5px;float:right; padding-right:10px;">
								<a href="javascript:void(0)" class="easyui-linkbutton marglt10" onclick="doSelectUser()">确认</a>
								<a href="javascript:void(0)" class="easyui-linkbutton marglt10" onclick="cleanAllUser()">清除</a>
				</div>
				<div  style="clear:both"></div>
				<div id="userNames" style="overflow:auto;height:68px; margin-top:2px; border:solid 1px #CCC; line-height:21px; background:#FFF;"></div>
			</div>
			<table id="list_data" cellspacing="0" cellpadding="0"
				style="height: 445px">
			</table>
		</div>
	</div>
	<!-- <textarea readonly="readonly" id="userNames" rows="2" cols="75"></textarea> -->
	<script language="javascript">
		var initFlag="Y";
		$(document).ready(function() {
			var posHeight = 460; //$(".pos").height();
			$('#tt').tree({
				url : '<%=request.getContextPath()%>/org/loadCurOrg.do?orgId='+$("#s_orgId").val(),
				onClick : function(node) {
					$("#s_orgId").val(node.id);
					$("#userName").val("");
					$("#accountName").val("");
					initFlag="N";
					loadUsers();
				},
				onBeforeExpand : function(node,param) {
					$('#tt').tree('options').url = '<%=request.getContextPath()%>/org/loadOrg.do?orgId='
							+ node.id;// change the url                       
				}
			});
			initParams();
			loadUsers();
		});
		/**
		* 初始化选中的人
		*/
		function initParams(){
			var keyId = $('#s_keyId').val();
			var nameId = $('#s_nameId').val();
			$("#userNames").html(document.getElementById(nameId).value);
			$("#userIds").val(document.getElementById(keyId).value);
		}
		
		/**
		*加载datagrid数据和配置
		*/
		
		function loadUsers() {
			var EventFlag=$("#s_isSingle").val()=='y';
			var queryParams;
			if(isNull(extendG))
				queryParams={'orgId' : $("#s_orgId").val(),userName : $("#userName").val(),accountName : $("#accountName").val(),userIds:$("#userIds").val(),initFlag:initFlag,extend:JSON.stringify(extendG)};
			else
				queryParams={'orgId' : $("#s_orgId").val(),userName : $("#userName").val(),accountName : $("#accountName").val(),userIds:$("#userIds").val(),initFlag:initFlag};
			extendG=null;
			$('#list_data').datagrid({
				url : "<%=request.getContextPath()%>/user/selectUserByCondTwo.do",
				queryParams : queryParams,
				width : 'auto',
				//	height: workHeight-34-30,
				nowrap : false,
				iconCls : 'icon-save',
				striped : true,
				pagination : true,
				rownumbers : true,
				idField:'userId',
				pageNumber : 1,
				pageSize : 10,
				pageList : [ 5, 10, 20, 50 ],
				loadMsg:'数据加载中.....',
				columns : [ [{field : 'userId',hidden : true},
						{field : 'userName',title : '用户姓名',width : 100},
						{field : 'accountName',title : '账号',width : 130},
						{field : 'orgName',title : '所属机构',width : 200,
							formatter : function(value,
									rowData, rowIndex) {
								var org = rowData.org;
								return org.orgName;
						}}, ] ],
				toolbar : '#tb-user',
				singleSelect:EventFlag,
				onClickRow:onClickRow,
				//onSelect:onSelect,
				onLoadSuccess:function(data){
					if($("#userIds").val()!=""){
						if(initFlag=="Y"){
							//初始化选中所有已选用户
							$('#list_data').datagrid('selectAll');
						}else{//选中已有用户
							var selUserIds = $("#userIds").val();
							if(selUserIds==""){return;}
							var selUserArr= selUserIds.split(',');
							for ( var i in selUserArr) {
									$('#list_data').datagrid('selectRecord',selUserArr[i]);
							}
							initFlag="N";
						}
					}else{
						initFlag="N";
					}
				}
			});
			setPage();
		}
		/**
		*绑定单选或多选事件
		*/
		function initEvents(){
			var isSingle=$("#s_isSingle").val()=='y';
			//是否多选
			if(isSingle){//单选
				$('#list_data').datagrid({onCheck:onCheck,onClickRow:onClickRow});
			}else{//多选
				$('#list_data').datagrid(
							{onUncheckAll:onUncheckAll,onCheckAll : onCheckAll,
							onSelect : onSelect,onUnselect:onUnselect
								});			
			}
		}
		
		function setPage(){
		var p = $('#list_data').datagrid('getPager');
		    $(p).pagination({    
				  pageSize: 10,//每页显示的记录条数，默认为10  
				  pageList: [5,10,15],//可以设置每页记录条数的列表  
				  beforePageText: '第',//页数文本框前显示的汉字  
				  afterPageText: '页    共 {pages} 页', 
				  displayMsg:'共 {total} 条记录' //'当前显示 {from} - {to} 条记录   共 {total} 条记录'
		    });
		}
		
		function onSelect(index, row) {
				replaceOrAdd(index,row);
		}
		
		function onUnselect(index, row) {
				replaceOrAdd(index, row);
				
		}
		
		function onClickRow(index,row){
			if($("#s_isSingle").val().toLowerCase()=='y'){//点选
				 $("#userNames").html(row.userName);//旧值
				$("#userIds").val(row.userId);//旧值
			}else{
				replaceOrAdd(index,row);//多选
			}
		}
		
		function onCheck(index,row){
			 $("#userNames").html(row.userName);//旧值
			$("#userIds").val(row.userId);//旧值
		}
		
		
		
	//添加或删除用户
	function replaceOrAdd(index,row) {
			var isContant = true;
			var oldNames = $("#userNames").html();//旧值
			var oldIds = $("#userIds").val();//旧值
			var id = row.userId;//选中
			var name = row.userName;//选 中
			//遍历 存在清除  不存在添加
			var names = oldNames.split(",");
			var len = names.length;
				for(var i=0;i<len;i++){
					if(names[i]==name){//包含取消
						if(len==1){
							$("#userNames").html(oldNames.replace(name, ""));
							$("#userIds").val(oldIds.replace(id, ""));
						}else if(i==(len-1)){
							$("#userNames").html(oldNames.replace(","+name, ""));
							$("#userIds").val(oldIds.replace(","+id, ""));
						}else{
							$("#userNames").html(oldNames.replace((name+","), ""));
							$("#userIds").val(oldIds.replace((id+","), ""));
						}
						
						isContant=false;
						break;
					}
				}
				if(isContant){
					 if (oldNames == ""){
						$("#userNames").html(name);
						$("#userIds").val(id);
					}
					else{ 
						$("#userNames").html(oldNames+","  + name);
						$("#userIds").val(oldIds+","  + id);
					}
				}
		}

		function onCheckAll(index) {
			var curRows = $('#list_data').datagrid('getSelections');
			for(var i=0;i<curRows.length;i++){
				replaceOrAdd(null,curRows[i]);
			}
		}
		
		function onUncheckAll(index){
			var curRows = $('#list_data').datagrid('getSelections');
			for(var i=0;i<curRows.length;i++){
				alert(curRows[i].userName);
				replaceOrAdd(null,curRows[i]);
			}
		}
		function cleanAllUser(){
			$("#userNames").html("");
			$("#userIds").val("");
			//设置当前选中的样式
			$('#list_data').datagrid('unselectAll');
		}
		function closeUser(){
			$('#commUserWin').window('close');
		}
		
		
		//确认选择  keyId是要隐藏值的input id nameId是要显示值的input或textarea id
		function doSelectUser(){
			var keyId = $('#s_keyId').val();
			var nameId = $('#s_nameId').val();
			var ids = $("#userIds").val();
			var names = $("#userNames").html();
			document.getElementById(nameId).value=names;
			document.getElementById(keyId).value=ids;
			//selRowsG = $('#list_data').datagrid('getSelections');
			if(typeof backFunNameG ==="function"){
				//返回选中的row
				var selRows =[];
				if(isStringNull(ids)){
					var idsArr = ids.split(",");
					var namesArr = names.split(",");
					for(var i in idsArr){
						var row ={
							userId:idsArr[i],
							userName:namesArr[i]
						};
						selRows.push(row);
					}
				}
				backFunNameG(selRows);
			}
			$('#commUserWin').window('close');
		}
	</script>
</body>
</html>