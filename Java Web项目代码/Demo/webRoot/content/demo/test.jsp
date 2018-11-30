<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试</title>
<script type="text/javascript">
	function test1() {
		$.ajax({
			//url : window.contextPath + "/user/test1?id=1",
			url : "${ctx}/user/test1?id=1",		
			async : true,
			dataType : "json",
			success : function(data) {
				alert(data);
			}
		});
	}
</script>
</head>
<body onclick="test1()" class="test" id="test">
	<div>
		装饰器测试二 
	</div>
</body>
</html>
