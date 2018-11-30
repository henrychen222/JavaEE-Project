<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
  <head>
    <title>AdminManagerIndex</title>
  </head>
  
	  <frameset rows="58px,*" frameborder="Yes" border="0" framespacing="0">
		<frame name="top" scrolling="No" noresize="noresize" src="${pageContext.request.contextPath }/servlet/AdminTopUI">	  
			<frameset cols="170px,*" frameborder="Yes" border="1" framespacing="1">
				<frame name="left" scrolling="No" noresize="noresize" src="${pageContext.request.contextPath }/servlet/AdminLeftUI?id=${admin.id }&admin=${admin.name }&power=${power}">
				<frame name="main" src="">
			</frameset>
	  </frameset>
	  
</html>
