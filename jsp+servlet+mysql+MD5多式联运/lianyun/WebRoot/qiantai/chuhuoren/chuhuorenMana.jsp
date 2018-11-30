<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="java.util.ArrayList"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
    String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<title>多式联运价比平台</title>
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<style type="text/css">
           .style12 {color: #FF6633;font-size: 14px;}
		    td {FONT-SIZE:9pt; LINE-HEIGHT:150%; COLOR: #353535} 
		    body {background-image: url(<%=path %>/image/background.gif);FONT-SIZE:9pt;LINE-HEIGHT:150%;margin: 0px;} 
			a:link {color: #fdfcfc; text-decoration: none}
			a:visited {color: #333333; text-decoration: none}
			a:active {color: #333333; text-decoration: none}
			a:hover {color: #fdfcfc text-decoration: underline}
			A:unknown LINK {TEXT-DECORATION: none}
			.list_link {FONT-WEIGHT: bold; FONT-SIZE: 12px; COLOR: #8d1c1c; TEXT-DECORATION: none}
			.wenbenkuang {BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; FONT-SIZE: 9pt; BORDER-LEFT: #999999 1px solid; COLOR: #333333; BORDER-BOTTOM: #999999 1px solid; FONT-FAMILY: "宋体"}
			.go-wenbenkuang {BORDER-RIGHT: #666666 1px solid; PADDING-RIGHT: 1px; BORDER-TOP: #ffffff 1px solid; PADDING-LEFT: 1px; FONT-SIZE: 9pt; PADDING-BOTTOM: 1px; BORDER-LEFT: #ffffff 1px solid; CURSOR: hand; COLOR: #333333; PADDING-TOP: 1px; BORDER-BOTTOM: #666666 1px solid; FONT-FAMILY: "宋体"; HEIGHT: 19px; BACKGROUND-COLOR: #eeeeee}
			.table-zuoyou {BORDER-RIGHT: #A9A9A9 1px solid; BORDER-LEFT: #A9A9A9 1px solid}
			.table-shangxia {BORDER-TOP: #A9A9A9 1px solid; BORDER-BOTTOM: #A9A9A9 1px solid}
			.table-sxzy {BORDER-TOP: #A9A9A9 1px solid; BORDER-BOTTOM: #A9A9A9 1px solid;#A9A9A9 1px solid; BORDER-LEFT: #A9A9A9 1px solid;BORDER-RIGHT: #A9A9A9 1px solid}
			.table-you {BORDER-RIGHT: #A9A9A9 1px solid}
			.table-zuo {BORDER-LEFT: #A9A9A9 1px solid}
			.table-shang {BORDER-TOP: #A9A9A9 1px solid}
			.table-xia {BORDER-BOTTOM: #A9A9A9 1px solid}
			.table-xu {BORDER-BOTTOM: #A9A9A9 1px dotted}
			.matrix {FONT-SIZE: 12px}
			.matrix A {COLOR: #93393a}
			.matrix_sub {BORDER-RIGHT: #c9c9c9 1px solid; PADDING-RIGHT: 4px; BORDER-TOP: 0px; PADDING-LEFT: 4px; BACKGROUND-IMAGE: url(<%=path %>/image/botton2.gif); PADDING-BOTTOM: 4px; BORDER-LEFT: #c9c9c9 1px solid; COLOR: #000000; PADDING-TOP: 1px; BORDER-BOTTOM: #c9c9c9 1px solid; BACKGROUND-COLOR: #f7f7f7}
			.matrix_header {BORDER-RIGHT: #c9c9c9 1px solid; BORDER-TOP: #c9c9c9 1px solid; PADDING-LEFT: 5px; BACKGROUND-IMAGE: url(<%=path %>/image/botton2.gif); PADDING-BOTTOM: 6px; BORDER-LEFT: #c9c9c9 1px solid; COLOR: #00469e; PADDING-TOP: 6px; BORDER-BOTTOM: #838383 1px solid; BACKGROUND-COLOR: #ffffff}
			.matrix_info {BORDER-RIGHT: #c9c9c9 1px solid; PADDING-RIGHT: 4px; PADDING-LEFT: 4px; PADDING-BOTTOM: 4px; BORDER-LEFT: #c9c9c9 1px solid; PADDING-TOP: 4px; BORDER-BOTTOM: #eae9e9 1px solid; BACKGROUND-COLOR: #f7f7f7}
			.matrix_info_header {BORDER-RIGHT: #c9c9c9 1px solid; PADDING-RIGHT: 4px; BORDER-TOP: #c9c9c9 1px solid; PADDING-LEFT: 4px; PADDING-BOTTOM: 4px; BORDER-LEFT: #c9c9c9 1px solid; PADDING-TOP: 4px; BORDER-BOTTOM: #eae9e9 1px solid; BACKGROUND-COLOR: #ebeaea}
			.matrix_content {COLOR: #353535; BACKGROUND-COLOR: #ffffff}
			.matrix_left {BORDER-LEFT: #c9c9c9 1px solid}
			.error {BORDER-RIGHT: #ff0000 2px solid; BORDER-TOP: #ff0000 2px solid; BORDER-LEFT: #ff0000 2px solid; WIDTH: 95%; BORDER-BOTTOM: #ff0000 2px solid; BACKGROUND-COLOR: #ffdede}
			.error TD {FONT-SIZE: 12px; COLOR: #ff0000}
			.error .title {BACKGROUND-COLOR: #ff9393}
			.error .title TD {FONT-WEIGHT: bold; FONT-SIZE: 12px; COLOR: #ffffff}
			.select {BORDER-TOP: #c4c4c4 1px solid; BORDER-LEFT: #c4c4c4 1px solid}
			.tableBorder {WIDTH: 98%;BACKGROUND-COLOR: #ffffff;border: 1px solid #0066FF;}
			.edfour {BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid; BACKGROUND-COLOR: #ffffff}
			.color {FONT-SIZE: 12px; COLOR: #d7fd62; TEXT-DECORATION: none}
			.line {FONT-SIZE: 12px; LINE-HEIGHT: 25px; TEXT-DECORATION: none}
			.unnamed1 {FONT-SIZE: 12px; COLOR: #000000; TEXT-DECORATION: none}
			.unnamed2 {FONT-SIZE: 12px; LINE-HEIGHT: 25px; TEXT-DECORATION: none}
			.da {font-size: 14px;color: #FFFFFF;letter-spacing: 1px;}
      </style>
      
      <script language="javascript">
             function chuhuorenAdd()
             {
                var url="<%=path %>/qiantai/chuhuoren/chuhuorenAdd.jsp";
				var ret = window.showModalDialog(url,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
               
             }
               function chuhuorenEdit(id)
           {
              
                   window.location.href="<%=path %>/chuhuoren?type=chuhuorenQuery&id="+id;
               
           }
          
            function apply(id){
            
            window.location.href="<%=path %>/chuhuoren?type=chuhuorenApply&id="+id;
           
           } 
           
            function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }
		   
		   
		     function shouhuo(){
            
            window.location.href="<%=path %>/shouhuoren?type=chuhuorenChakanshouhuoStatus";
           
           } 		
        </script>

  </head>
  
  <BODY leftMargin=0 topMargin=0 bgColor=#ffffff>
		<TABLE border=0 cellSpacing=0 cellPadding=0 width=772 bgColor=#ffffff align=center style="background-image: url('<%=path %>/image/logo.jpg'); background-repeat : repeat-xy">
		  <TR>
		    <TD height=80 width=772 align=center>
			     &nbsp;
		    </TD>
		  </TR>
		</TABLE>
		
        <jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
  
		<TABLE border=0 cellSpacing=0 cellPadding=0 width=772 bgColor=#ffffff align=center>
		  <TR>
		    <TD class=b vAlign=top width=178>
		       <jsp:include flush="true" page="/qiantai/inc/incLeft.jsp"></jsp:include>
		    </TD>
		    
		    
		    <td width="1" bgcolor="#A9A9A9"></td>
		    <td width="3" bgcolor="white"></td>
		    <!-- 右部分-->
		    <TD class=b vAlign=top width=591 align=left>
		      <TABLE border=0 cellSpacing=0 cellPadding=0 width=590 align=center bgcolor="#CCCCCC" style="margin-top: 2px;">
		        <TR>
		          <TD height="25">
		               &nbsp;&nbsp;&nbsp;
                  </TD>
		        </TR>
		      </TABLE>
		      <TABLE border=0 cellSpacing=0 cellPadding=2 width=590 align=left height=133>
		        <TR>
		          <TD height=129 vAlign=top align=center style="color:green;font-size:30px">
		         
		         
		          
		          
		        
		         
		        
		          
		              <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">出货申请&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					
					<td width="10%">出货人编号</td>
					<td width="10%">姓名</td>
					<td width="5%">性别</td>
					<td width="5%">年龄</td>
					<td width="10%">出货人电话</td>
					<td width="10%">出货人地址</td>
					<td width="10%">收货人地址</td>
					<td width="10%">产品名称</td>
					<td width="10%">产品图片</td>
					<td width="5%">申请状态</td>
					<td width="5%">发货状态</td>
					<td width="10%">收货人电话</td>
					<td width="10%">收货人姓名</td>
					<td width="10%">操作</td>
		        </tr>	
				
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
				    <td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.sex}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.age}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.telephone}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.address}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.shouhuorenAddress}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.productName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <div onmouseover = "over('<%=path %>/upload/${requestScope.chuhuoren.productFujianYuanshiming}')" onmouseout = "out()" style="cursor:hand;">
							查看图片
					   </div>
					</td>
					<c:if test="${requestScope.chuhuoren.applyStatus=='未申请'}">
					<td bgcolor="#FFFFFF" align="center" style="color:green">
						 ${requestScope.chuhuoren.applyStatus}
					</td>
					</c:if>
					<c:if test="${requestScope.chuhuoren.applyStatus=='已申请'}">
					<td bgcolor="#FFFFFF" align="center" style="color:red">
						 ${requestScope.chuhuoren.applyStatus}
					</td>
					</c:if>
					<c:if test="${requestScope.chuhuoren.fahuoStatus=='未发货'}">
					<td bgcolor="#FFFFFF" align="center" style="color:green">
						 ${requestScope.chuhuoren.fahuoStatus}
					</td>
					</c:if>
					<c:if test="${requestScope.chuhuoren.fahuoStatus=='已发货'}">
					<td bgcolor="#FFFFFF" align="center" style="color:red">
						 ${requestScope.chuhuoren.fahuoStatus}
					</td>
					</c:if>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.shouhuorenTel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${requestScope.chuhuoren.shouhuorenName}
					</td>
					<c:if test="${requestScope.chuhuoren.applyStatus=='未申请'}">
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="申请" onclick="apply( ${requestScope.chuhuoren.id})"/>
						<input type="button" value="修改" onclick="chuhuorenEdit( ${requestScope.chuhuoren.id})"/>
					</td>
					</c:if>
					<c:if test="${requestScope.chuhuoren.applyStatus=='已申请'&&requestScope.chuhuoren.fahuoStatus=='未发货'}">
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="申请" disabled="disabled" onclick="apply( ${requestScope.chuhuoren.id})"/>
						<input type="button" value="查看是否收到货" disabled="disabled" onclick="shouhuo()"/>
					</td>
					</c:if>
					<c:if test="${requestScope.chuhuoren.applyStatus=='已申请'&&requestScope.chuhuoren.fahuoStatus=='已发货'}">
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="申请" disabled="disabled" onclick="apply( ${requestScope.chuhuoren.id})"/>
						<input type="button" value="查看是否收到货"  onclick="shouhuo()"/>
					</td>
					</c:if>
				</tr>
				
			</table>
		          </TD>
		        </TR>
		      </TABLE>
		   </TD>
		  </TR>
		</TABLE>


		<TABLE border=0 cellSpacing=0 cellPadding=0 width=772 bgColor=#a9a9a9 align=center>
		  <TR><TD rowSpan=5 width=1></TD></TR>
		</TABLE>
    
    
        <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
   <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
			<TABLE id="tipTable" border="0" bgcolor="#ffffee">
				<TR align="center">
					<TD><img id="photo" src="" height="80" width="80"></TD>
				</TR>
			</TABLE>
		</div>
  </BODY>
</html>
