<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/common/bootstrap/css/bootstrap.min.css" rel="stylesheet"  type="text/css"></link>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/js/libs/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/bootstrap/js/bootstrap-paginator.min.js"></script>
<title>用户管理</title>

<style type="text/css">
#queryDiv {
	margin-right: auto;
	margin-left: auto;
	width: 600px;
}

#textInput {
	margin-top: 10px;
}

#tableResult {
	margin-right: auto;
	margin-left: auto;
	width: 600px;
}

td {
	width: 150px
}
#bottomTab ul li a[title]{
cursor: pointer;
}
#bottomTab ul li[class=active] a[title]{
cursor: auto;
}
</style>
</head>
<body>
	<div id="queryDiv">
		<input id="textInput" type="text" placeholder="请输入用户名">
		<button id="queryButton" class="btn btn-primary" type="button">查询</button>
		<button id="addButton" class="btn btn-primary" type="button" onclick="addUser()">添加</button>
		<button id="delButton" class="btn btn-primary" type="button"onclick="deleteAll()">批量删除</button>
	</div>
	<form id="form1">
		<table class="table table-bordered" id='tableResult'>
			<caption>查询用户结果</caption>
			<thead>
				<tr>
					<th><a href="#" onclick="selectAll()">全选</a>
        				<a href="#" onclick="reSelect()">反选</a></th>
					<th>序号</th>
					<th>用户名</th>
					<th>密码</th>
					<th>年龄</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="tableBody">
			</tbody>
		</table>
		<!-- 底部分页按钮 -->
		<div id="bottomTab"></div>
	</form>
	<script type='text/javascript'>
		
		//跳转添加用户
		function addUser(){
			window.location.href = '${pageContext.request.contextPath}/user/add_User.do';
		
		}

		//渲染完就执行
		$(function() {
			//生成底部分页栏
			$('#bottomTab').bootstrapPaginator(options);
			buildTable("", 1, 10);//默认空白查全部
			//创建结算规则
			$("#queryButton").bind("click", function() {
				var userName = $("#textInput").val();
				buildTable(userName, 1, PAGESIZE);
			});
		});
		var PAGESIZE = 10;
		var options = {
			currentPage : 1, //当前页数
			totalPages : 10, //总页数，这里只是暂时的，后头会根据查出来的条件进行更改
			size : "normal",
			alignment : "center",
			itemTexts : function(type, page, current) {
				switch (type) {
				case "first":
					return "第一页";
				case "prev":
					return "前一页";
				case "next":
					return "后一页";
				case "last":
					return "最后页";
				case "page":
					return page;
				}
			},
			onPageClicked : function(e, originalEvent, type, page) {
				var userName = $("#textInput").val(); //取内容
				switch (type) {
				case "prev":
					page = page + 1;
					break;
				case "next":
					page = page - 1;
					break;
				}
				buildTable(userName, page, PAGESIZE);//默认每页最多10条
			}
		}

		//获取当前项目的路径
		var urlRootContext = (function() {
			var strPath = window.document.location.pathname;
			var postPath = strPath.substring(0,
					strPath.substr(1).indexOf('/') + 1);
			return postPath;
		})();

		//生成表格
		function buildTable(userName, pageNumber, pageSize) {
			var url = urlRootContext + "/user/queryAll.do"; //请求的网址
			var reqParams = {
				'userName' : userName,
				'page' : pageNumber,
				'rows' : pageSize
			};//请求数据
			$(function() {
				$
						.ajax({
							type : "POST",
							url : url,
							data : reqParams,
							async : false,
							dataType : "json",
							success : function(data) {
								// options.totalPages = data.pages;
								var newoptions = {
									currentPage : pageNumber, //当前页数
									totalPages : data.pages == 0 ? 1
											: data.pages, //总页数
									size : "normal",
									alignment : "center",
									itemTexts : function(type, page, current) {
										switch (type) {
										case "first":
											return "第一页";
										case "prev":
											return "前一页";
										case "next":
											return "后一页";
										case "last":
											return "最后页";
										case "page":
											return page;
										}
									},
									onPageClicked : function(e, originalEvent,
											type, page) {
										var userName = $("#textInput").val(); //取内容
										switch (type) {
										case "prev":
											page = page + 1;
											break;
										case "next":
											page = page - 1;
											break;
										}
										buildTable(userName, page, PAGESIZE);//默认每页最多10条
									}
								}
								$('#bottomTab').bootstrapPaginator(
										"setOptions", newoptions); //重新设置总页面数目
								var dataList = data.rows;
								$("#tableBody").empty();//清空表格内容
								if (dataList.length > 0) {
									$(dataList)
											.each(
													function() {//重新生成
														$("#tableBody").append(
																'<tr>');
														$("#tableBody").append("<td><input name='ch' type='checkbox' value=" + this.id + " /></td>");
														$("#tableBody")
																.append(
																		'<td>'
																				+ this.id
																				+ '</td>');
														$("#tableBody")
																.append(
																		'<td>'
																				+ this.userName
																				+ '</td>');
														$("#tableBody")
																.append(
																		'<td>'
																				+ this.password
																				+ '</td>');
														$("#tableBody")
																.append(
																		'<td>'
																				+ this.age
																				+ '</td>');
														$("#tableBody")
																.append(
																		'<td>'
																				+ '<a href="${pageContext.request.contextPath}/user/update_User.do?'+'id='+this.id+'">修改</a>'
																				+ '<a href="${pageContext.request.contextPath}/user/del.do?'+'id='+this.id+'">删除</a>'
																				+ '</td>');
														$("#tableBody").append(
																'</tr>');
													});
								} else {
									$("#tableBody")
											.append(
													'<tr><th colspan ="4"><center>查询无数据</center></th></tr>');
								}
							},
							error : function(e) {
								alert("查询失败:" + e);
							}
						});
			});
		}
		//删除所选
		function deleteAll() {
			 var idStr="";
			 if ($("input[name='ch']:checked").size() <= 0) {
			  alert("你没有选择删除对象，请先选择");
			  return;
			 }
			 if (confirm('是否确认删除！')) {
			  $("input[name='ch']:checked").each(function() {
			   if (idStr != "") {
			    idStr += ',';
			   }
			   idStr += $(this).val();
			  });
			  //var url = "${pageContext.request.contextPath}/deleteUserAll.do?idStr="+idStr;		
			  window.alert(idStr);	
			 // window.location='${pageContext.request.contextPath}/deleteUserAll.do?idString='+idStr;
			  
			 } else {
			  return;
			 }
			}
		//全选
		function selectAll() {
			 var chs = document.getElementsByName("ch");
			 for ( var i = 0; i < chs.length; i++) {
				  chs[i].checked = true;
			 }
			 var cha = document.getElementById("cbxReSel");
			 cha.checked = false;
			}
		//反选
		function reSelect() {
			 var chs = document.getElementsByName("ch");
			 for ( var i = 0; i < chs.length; i++) {
			  chs[i].checked = chs[i].checked ? false : true;
			 }
			 var cha = document.getElementById("cbxSelAll");
			 cha.checked = false;
			}
	</script>
</body>
</html>