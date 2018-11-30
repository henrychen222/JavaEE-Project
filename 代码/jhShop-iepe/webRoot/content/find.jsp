<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>数据字典表查询</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/showStudent.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/bootstrap/css/bootstrap.css"/>
<script src="${pageContext.request.contextPath }/common/bootstrap/js/jquery.spinner.min.js"></script>
<script src="${pageContext.request.contextPath }/common/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" >
		$(function(){
				$("#add").click(function(){
						window.location.href="add.jsp";
				})
			
		})
	</script>
</head>
<body>
<form action="find.do" method="post">
	<table>
    	<tr>
    		<td>编号</td>
    		<td>更新时间</td>
    		<td>类别</td>
    		<td>地址</td>
    	</tr>
    	
    	<c:forEach items="${requestScope.blist}" var="b">
    		<tr>
	    		<td>${b.id }</td>
	    		<td><fm:formatDate value="${b.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    		<td>${b.type}</td>
	    		<td>${b.comType.address }</td>
	    	</tr>
    	</c:forEach>
    </table>
    <input type="button" value="添加" value="add"/>
</form>
	
</body>
</html>