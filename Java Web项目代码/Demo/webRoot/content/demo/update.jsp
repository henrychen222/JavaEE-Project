<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
         $function(){
        	 $("#back").click(function(){
        		 window.location.href = "demo/demo_PageHelper"
        	 })
        	 
        	  $("#sub").click(function(){
        		var name = $("#name").val();
        		if (name == null || name == "") {
					alert("姓名不能为空");
					return;
				}
        		document.forms[0].submit();
        	 })
         }


</script>

<body>
<form action="${pageContext.request.contextPath}/user/updateUser.do" method="post">
		
		<input type="hidden" name="u.id" value="" />
		
		id:<input type="text" name="id" value="${user.id}"/> </br>
		name:<input type="text" name="userName" value="${user.userName}"> </br>
		password:<input type="text" type="password" name="password" value="${user.password}"> </br>
		age:<input type="text" name="age" value="${user.age}" /> </br>
		
		<input type="submit" value="更新" id="sub" />
		<input type="submit" value="返回" id="back" />
	</form>
</body>
</html>