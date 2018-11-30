<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<LINK href="<%=path %>/css/admin.css" type="text/css" rel="stylesheet">
<SCRIPT language=javascript>
	function expand(el)
	{
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none')
		{
			childObj.style.display = 'block';
		}
		else
		{
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
</HEAD>
<BODY>
<div id="PARENT">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170 
background=<%=path %>/images/menu_bg.jpg border=0>
  <TR>
    <TD vAlign=top align=middle>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        
        <TR>
          <TD height=10></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=path %>/images/menu_bt.jpg><A  
            class=menuParent onclick=expand(1) 
            href="javascript:void(0);">修改个人密码</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
      <TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=path %>/admin/userinfo/userPw.jsp" 
            target="I1" >修改密码</A></TD></TR>
            <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=path %>/admin/admin/adminAdd.jsp" 
            target="I1" >添加管理员</A></TD></TR>
             <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=path %>/admin?type=adminMana" 
            target="I1" >管理员管理</A></TD></TR>
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>
          
       
            <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=path %>/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(2) 
            href="javascript:void(0);">出货人申请管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
            <TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
      
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
           href="<%=path %>/chuhuoren?type=chuhuorenManaAdmin"
            target="I1" >出货人申请管理</A></TD></TR>
      
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>
          
          <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=path %>/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(3) 
            href="javascript:void(0);">多式联运经营人管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
            <TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
      
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
           href="<%=path %>/jingyingren?type=jingyingrenManaAdmin"
            target="I1" >多式联运经营人管理</A></TD></TR>
      
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>    
          
          <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=path %>/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(4) 
            href="javascript:void(0);">收货人管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
            <TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
      
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
           href="<%=path %>/shouhuoren?type=shouhuorenManaAdmin"
            target="I1" >收货人管理</A></TD></TR>
      
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>  
          
          <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=path %>/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(5) 
            href="javascript:void(0);">运输管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
            <TABLE id=child5 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
      
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
           href="<%=path %>/yunshu?type=yunshuManaAdmin"
            target="I1" >运输管理</A></TD></TR>
      
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>  
          
          
          
           <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
        <TR height=22>
          <TD style="PADDING-LEFT: 30px" background=<%=path %>/images/menu_bt.jpg><A 
            class=menuParent onclick=expand(6) 
            href="javascript:void(0);">站内资讯管理</A></TD></TR>
        <TR height=4>
          <TD></TD></TR></TABLE>
            <TABLE id=child6 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
      width=150 border=0>
      
        <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
           href="<%=path %>/news?type=newsMana"
            target="I1" >站内资讯管理</A></TD></TR>
       <TR height=20>
          <TD align=middle width=30><IMG height=9 
            src="<%=path %>/images/menu_icon.gif" width=9></TD>
          <TD><A class=menuChild 
            href="<%=path %>/admin/news/newsAdd.jsp"
            target="I1" >站内资讯添加</A></TD></TR>
        <TR height=4>
          <TD colSpan=2></TD></TR></TABLE>
          
          
          
          
          
            
                    
          
          
          
          
          
          
          
          
          
          
           
          
          
          
          
          
          
          
          
          
          
      </TD>
    <TD width=1 bgColor=#d1e6f7></TD></TR></TABLE>
    
        </div>
    </BODY></HTML>
