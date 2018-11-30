<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看所有学生信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/showStudent.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/bootstrap/css/bootstrap.css"/>
<script src="${pageContext.request.contextPath }/common/bootstrap/js/jquery.spinner.min.js"></script>
<script src="${pageContext.request.contextPath }/common/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	  		$(document).ready(function(){ 
			$('.son_ul').hide(); //初始ul隐藏
			$('.select_box span').hover(function(){ //鼠标移动函数
			$(this).parent().find('ul.son_ul').slideDown();  //找到ul.son_ul显示
			$(this).parent().find('li').hover(function(){$(this).addClass('hover')},function(){$(this).removeClass('hover')}); //li的hover效果
			$(this).parent().hover(function(){},
			function(){
				$(this).parent().find("ul.son_ul").slideUp(); 
			});
		 	},function(){
		 	});
				$('ul.son_ul li').click(function(){
				$(this).parents('li').find('span').html($(this).html());
				$(this).parents('li').find('ul').slideUp();
				});
		 	});
	  	  	function gotopage(currentpage){
 	  		var pagesize = document.getElementById("pagesize").value;
 	  		var pagenum = document.getElementById("pagenum").value;
 	  		var url = document.getElementById("url").value;
 	  		var totalpage = ${pagebean.totalpage};
 	  			if(pagesize<=0||currentpage<=0){
 	  				window.confirm("这填的数字要大于0哦！！");
 	  				return;
 	  			}else if(pagenum>totalpage){
 	  				window.confirm("这填的数字不能大于"+totalpage+"哦！！");
 	  				return;
 	  			}else{
 	  				window.location.href = '${pageContext.request.contextPath}/student/${url}.do?'+'currentpage='+currentpage+'&pagesize='+pagesize; 
 	  			}
 	  		}
	  	  	function selectStudent(){
		  	  	var studentId = document.getElementById("studentId").value;
	 	  		var studentName = document.getElementById("studentName").value;
	 	  		if(studentId==""&studentName==""){
	 	  			window.confirm("学籍号和姓名不能同时为空哦！！！");
		  			return;
	 	  		}else{
	 	  			window.location.href = '${pageContext.request.contextPath}/student/findStudentByQuery.do?'+'studentId='+studentId+'&studentName='+studentName;
	 	  		}
	  	  	}
    </script>
</head>
<body>
	<input id="roleUserId" type="hidden" />
	<input id="roleUser" type="hidden" />
	<div id="page">
	  <div id="page-top">
		<div id="pt-1">
			<div class="crumbs">
        		<em class="crumbs-title">您的位置：</em>
				<a href="#" class="crumbs-nav">后台管理</a>
				<span class="pipe-gt">&gt;</span>
				<a href="${pageContext.request.contextPath }/student/registration.do" class="crumbs-nav">学生学籍管理</a>
		    </div>
		</div>
		<div style="padding-top:10px;padding-left:20px;padding-bottom:10px;border:0px solid;">
			学生学籍号：<input id="studentId" name="studentId" type="text"class="easyui-validatebox" /> 
			学生姓名：	<input id="studentName" name="studentName" type="text"class="easyui-validatebox" />
			<a href="javascript:void(0)" onclick="selectStudent()">查询</a> 
			<a href="${pageContext.request.contextPath}/student/addStudentUI.do">添加</a>
		</div>	
	<div class="row">
			<div class="panel panel-primary">
		  		<div class="panel-heading">查看学生学籍信息</div>
		 		<div class="panel-body">
					<table class="table table-bordered">
						<tr>
							<th>学&nbsp;&nbsp;籍&nbsp;&nbsp;号</th>
							<th>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</th>
						    <th>班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级</th>
						    <th>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</th>
						    <th>创建时间</th>
						  	<th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
					   </tr>
					   <c:forEach var="list" items="${requestScope.pagebean.list}" varStatus="status">
					   <tr>
					   	   <td>${list.student_number}</td>
						   <td>${list.student_name}</td>
						   <td>${list.class_name}</td>
						   <td>${list.gender}</td>
						   <td>${list.createTime}</td>
						   <td> 
						    <a href="${pageContext.request.contextPath }/stutent/updateStudent.do?id=${list.student_registration_id}">[修&nbsp;&nbsp;改]</a>
							<a href="${pageContext.request.contextPath }/stutent/deleteStudent.do?id=${list.student_registration_id}">[删&nbsp;&nbsp;除]</a>
							</td>
					   </tr>
					   </c:forEach>
					  </table>
				</div>
      		</div>
		</div>
	<div class="main paging_algin" style="margin:5px auto;border: 0px solid;">
		<div class="paging"style="height: 40px;line-height: 40px;">
			<span>
			 	共[&nbsp;${pagebean.totalrecord }&nbsp;]条记录,
			   	每页<input type="text" id="pagesize" value="${pagebean.pagesize }" onchange="gotopage(1)" style="width:30px" maxlength="2">条,
			   	共[&nbsp;${pagebean.totalpage }&nbsp;]页,
				当前[<font color="red">&nbsp;${pagebean.currentpage }&nbsp;</font>]页
			 </span>&nbsp;&nbsp;   
			 <a href="javascript:void(o)" onclick="gotopage(${pagebean.previouspage})">上一页</a>
			 <c:forEach var="pagenum" items="${pagebean.pagebar}">
				<c:if test="${pagenum==pagebean.currentpage}">
					<span class="a_this">${pagenum}</span>
				</c:if>
				<c:if test="${pagenum!=pagebean.currentpage}">
					<a href="javascript:void(0)" onclick="gotopage(${pagenum})">${pagenum }</a>
				</c:if>
			 </c:forEach>
			 <a href="javascript:void(0)" onclick="gotopage(${pagebean.nextpage})">下一页</a>
			   <span>
			    	跳转至      
				    <input type = "text" id = "pagenum" style="width:30px"maxlength="2">&nbsp;页
				    <input type = "button" value = "GO" onclick = "gotopage(document.getElementById('pagenum').value)">
				    <input type="hidden"id="url"value="${url}">
			   </span> 
		    </div>
		 </div>
	   </div>
	 </div>
</body>
</html>