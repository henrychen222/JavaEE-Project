<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'oldmanEdit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
 
 function edit()
             {
            
               <c:if test="${requestScope.chuhuoren.applyStatus=='未申请'}">
                
                 alert("等待多式联运经营人进行核实该申请...............！");
                  
                 
            </c:if>
            
            <c:if test="${requestScope.chuhuoren.applyStatus=='已申请'}">
             var url="<%=path %>/yunshu?type=yunshuMana";
				window.location.href=url;
            </c:if>
               
             }
             </script>
  </head>
  
  <body onload="edit()">
 <div style="margin-top:250px">
  <center style="font-size:30px;color:red"><strong>等待多式联运经营人进行核实并且进行认证.........................！</strong></center>
   </div>
  </body>
</html>
