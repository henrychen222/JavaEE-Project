<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>数据字典表查询</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/showStudent.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/bootstrap/css/bootstrap.css"/>

</head>
<body>
<form action="${pageContext.request.contextPath}/student/addStudent.do" method="post">
   	<input type="text" name="student_number" value="student_number"/>
   	<input type="text" name="student_name" value="student_name"/>
   	<input type="text" name="class_name" value="class_name"/>
   	<input type="text" name="gender" value="gender"/>
   	<input type="submit" value="添加"/>
   	<input type="reset" value="重置"/>
   	
</form>
	
</body>
</html>