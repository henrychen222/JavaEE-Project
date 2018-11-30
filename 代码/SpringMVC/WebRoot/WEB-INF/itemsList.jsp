<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Contextype" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>

<body>
	<form action="${pageContext.request.contextPath}/item/queryItem.action"
		method="post"></form>
	查询条件:
	<table>
		<tr>
			<td><input type="submit" value="查询" />
			</td>
		</tr>
	</table>
	商品列表
	<table width="100%" border="1">
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品概述</td>
			<td>操作</td>

		</tr>
	</table>

</body>
</html>
