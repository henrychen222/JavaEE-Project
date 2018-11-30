<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="find.do" method="post">
	<table>
    	<tr>
    		<td>编号</td>
    		<td>类型</td>
    		<td>标记</td>
    		<td>路径</td>
    		<td>地址</td>
    		<td>创建时间</td>
    		<td>修改时间</td>
    		<td>删除时间</td>
    	</tr>
    	
    	<c:forEach items="${requestScope.blist}" var="b">
    		<tr>
	    		<td>${b.id }</td>
	    		<td>${b.comType.type }</td>
	    		<td>${b.remark }</td>
	    		<td>${b.filepath }</td>
	    		<td>${b.comType.address }</td>
	    		<td><fm:formatDate value="${b.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    		<td><fm:formatDate value="${b.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    		<td><fm:formatDate value="${b.deleteTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	    	</tr>
    	</c:forEach>
    </table>
   </form>
</body>
</html>