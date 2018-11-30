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
<title>Bootstrap分页实例</title>

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
		<button id="plusButton" class="btn btn-primary" type="button" onclick="addUser()">添加</button>
	</div>
	<form id="form1">
		<table class="table table-bordered" id='tableResult'>
			<caption>查询用户结果</caption>
			<thead>
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>密码</th>
					<th>年龄</th>
				</tr>
			</thead>
			<tbody id="tableBody">
			</tbody>
		</table>
		<!-- 底部分页按钮 -->
		<div id="bottomTab"></div>
	</form>
	<script type='text/javascript'>
	
	//添加用户
	function addUser(){
		window.location.href = urlRootContext + "/content/demo/addUser.jsp";
	}
	
	
	
	//删除用户
	function delUser(id){
		var url = urlRootContext + "/user/deleteUser.do"  
	    var reqParams = {
				'id' : id
		};//请求数据
		$(function(){
			
			$.ajax({
				type : "POST",
				url : url,
				data : reqParams,
				async : false,
				dataType : "json",
				success : function(data) {
					
				},
				error : function(e) {
					if (confirm("是否确认删除？！")) {
						buildTable("", 1, 10);
					}
				}
			});
		});
	}
			
			
	
	//根据id查询
	function findById(id){
		window.location.href = urlRootContext + "/user/findById.do?id=" + id;
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
			var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
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
				$.ajax({
					type : "POST",
					url : url,
					data : reqParams,
					async : false,
					dataType : "json",
					success : function(data) {
						// options.totalPages = data.pages;
						var newoptions = {
							currentPage : pageNumber, //当前页数
							totalPages : data.pages == 0 ? 1 : data.pages, //总页数
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
								case "0":
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
						$('#bottomTab').bootstrapPaginator("setOptions", newoptions); //重新设置总页面数目
						var dataList = data.rows;
						$("#tableBody").empty();//清空表格内容
						if (dataList.length > 0) {
							$(dataList).each(function() {//重新生成
								$("#tableBody").append('<tr>');
								$("#tableBody").append('<td>' + this.id + '</td>');
								$("#tableBody").append('<td>' + this.userName + '</td>');
								$("#tableBody").append('<td>' + this.password + '</td>');
								$("#tableBody").append('<td>' + this.age + '</td>');
								$("#tableBody").append('<td><a onClick=\'javascript:delUser('+this.id+');\' href=\'javascript:void(0);\'>删除</a>丨<a onClick=\'javascript:findById('+this.id+');\'href=\'javascript:void(0);\'>修改</a></td>');
								$("#tableBody").append('<tr>');
								

							});
						} else {
							$("#tableBody").append('<tr><th colspan ="4"><center>查询无数据</center></th></tr>');
						}
					},
					error : function(e) {
						alert("查询失败:" + e);
					}
				});
			});
		}
	</script>
</body>
</html>
