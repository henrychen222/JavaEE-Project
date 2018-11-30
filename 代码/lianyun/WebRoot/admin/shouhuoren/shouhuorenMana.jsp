<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           
           
           function shouhuorenDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/shouhuoren?type=shouhuorenDel&id="+id;
               }
           }
           
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
	<form action="<%=path %>/shouhuoren?type=shouhuorenSearch" method="post">
		        <b style="font-size:15px">收货人姓名：</b><input type="text" name="name"/>&nbsp;
		         
		         &nbsp;<input type="submit" value="查询"/> 
		          </form>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="44" background="<%=path %>/img/tbg.gif">&nbsp;收货人管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="15%">收货人编号</td>
					<td width="15%">姓名</td>
					
					<td width="15%">收货人电话</td>
					<td width="15%">收货人地址</td>
					
					<td width="15%">产品名称</td>
					<td width="15%">收货状态</td>
					
					<td width="8%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.shouhuorenList}" var="shouhuoren" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
				    <td bgcolor="#FFFFFF" align="center">
						 ${shouhuoren.id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${shouhuoren.name}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${shouhuoren.tel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${shouhuoren.address}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${shouhuoren.productName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${shouhuoren.shouhuoStatus}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="shouhuorenDel(${shouhuoren.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			
	</body>
</html>
