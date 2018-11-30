<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html>
  <head>

    
    <title>index</title>
	
  </head>
  
  <body>
  <h2>商品类型列表</h2>
    <table border="1">
    	<tr>
    	   
    		<td>name</td>
    		
    	
    	
    	</tr>
    	<c:forEach var="producttype" items="${producttype}">
    		<tr>
    		    
    			<td>${producttype.name }</td>
    			
    		</tr>
    	</c:forEach>
    	
    </table>
  </body>
</html>
