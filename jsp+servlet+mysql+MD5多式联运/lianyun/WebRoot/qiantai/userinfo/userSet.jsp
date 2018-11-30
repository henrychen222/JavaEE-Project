<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <base target="_self"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<script language="javascript">
            function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		    function setLoginname(id)
		    {
		        if(confirm('您确定修改吗？'))
               {
                   window.location.href="<%=path %>/user?type=setLoginname&id="+id;
               }
		        document.form1.submit();
		    }
        </script>
	</head>
	<body>
			<form action="<%=path %>/user?type=setLoginname" name="form1" method="post">
			<c:forEach items="${requestScope.userList}" var="user" varStatus="ss1">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							会&nbsp;员&nbsp;号：
						</td>
						<td bgcolor="#FFFFFF" align="left">
						${user.id}
					</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							登&nbsp;录&nbsp;名：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="loginname" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							姓&nbsp;&nbsp;&nbsp;&nbsp;名：
						</td>
						<td bgcolor="#FFFFFF" align="left">
						${user.name}
					</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							性&nbsp;&nbsp;&nbsp;&nbsp;别：
						</td>
						<td bgcolor="#FFFFFF" align="left">
						${user.sex}
					</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							年&nbsp;&nbsp;&nbsp;&nbsp;龄：
						</td>
					<td bgcolor="#FFFFFF" align="left">
						${user.age}
					</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="button" value="确定" onclick="setLoginname(${user.id});"/>
							<input type="button" value="取消" onclick="closeOpen();"/>
						</td>
					</tr>
				</table>
				</c:forEach>
			</form>
	</body>
</html>
