<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>装饰器测试一</title>
<script type="text/javascript">
	$(function() {
		initDg();
	});
	var data = [ {
		"id" : 1,
		"text" : "text1"
	}, {
		"id" : 2,
		"text" : "text2"
	}, {
		"id" : 3,
		"text" : "text3",
		"selected" : true
	}, {
		"id" : 4,
		"text" : "text4"
	}, {
		"id" : 5,
		"text" : "text5"
	} ]
	function test() {
		$('#cc').combobox({
			data : data,
			valueField : 'id',
			textField : 'text'
		});

	}
	function test1() {
		$.ajax({
			//url : window.contextPath + "/user/test1?id=1",
			url : "${ctx}/user/queryAll",
			async : true,
			dataType : "json",
			success : function(data) {
				alert(data);
			}
		});
	}
	function initDg() {
		$('#dg').datagrid({
			url : '${ctx}/user/queryAll',
			width : "auto",
			height : "500px",
			pagination : true,
			rownumbers : true,
			pageNumber : 1,
			pageSize : 10,
			pageList : [ 5, 10, 20, 50 ],
			singleSelect : true,
			sortName:"id",
			sortOrder:"desc",
			columns : [ [ {
				field : 'id',
				title : 'id',
				width : 100,
				sortable:true
			}, {
				field : 'userName',
				title : '姓名',
				width : 100,
				sortable:true
			}, {
				field : 'password',
				title : '密码',
				width : 100,
				sortable:true
			}, {
				field : 'age',
				title : '年龄',
				width : 100,
				align : 'right',
				sortable:true
			} ] ]
		});

	}

	function queryAll() {
		var userName=$("#userName").val();
		alert(userName);
		$('#dg').datagrid('load', {
			userName : userName
		});

	}
</script>
</head>
<body class="test">
	<div onclick="queryAll()">装饰器测试一</div>
	${user.userName}
	<div onclick="test1()">json数据测试</div>
	<input id="cc" name="dept" value="aa" onclick="test()">
	<div>EasyUI分页测试</div>
	<div>
		用户名：<input type="text" id="userName">
		<input type="button" value="查询" onclick="queryAll()">
	</div>
	<table id="dg"></table>

</body>
</html>
