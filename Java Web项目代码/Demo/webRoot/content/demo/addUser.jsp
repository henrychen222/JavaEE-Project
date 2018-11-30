<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/addUser.do"
		method="post">
		id:<input type="text" name="id" value=""> 
		name:<input type="text" name="userName" value="">
		password:<input type="text" type="password" name="password" value=""> 
		age:<input type="text" name="age" value=""> 
		<input type="submit" name="添加">
		<input type="reset" name="重置">
	</form>

</body>
</html>