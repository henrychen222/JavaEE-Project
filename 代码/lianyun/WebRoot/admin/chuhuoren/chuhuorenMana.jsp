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
           
           
           function chuhuorenDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/chuhuoren?type=chuhuorenDel&id="+id;
               }
           }
           
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
	<form action="<%=path %>/chuhuoren?type=chuhuorenSearch" method="post">
		        <b style="font-size:15px">出货人姓名：</b><input type="text" name="name"/>&nbsp;
		         <b style="font-size:15px">收货人姓名：</b><input type="text" name="shouhuorenName"/>
		         &nbsp;<input type="submit" value="查询"/> 
		          </form>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="44" background="<%=path %>/img/tbg.gif">&nbsp;出货人申请管理&nbsp;</td>
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
					<td width="5%">申请状态</td>
					<td width="5%">发货状态</td>
					<td width="10%">收货人电话</td>
					<td width="10%">收货人姓名</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.chuhuorenList}" var="chuhuoren" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
				    <td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.sex}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.age}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.telephone}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.address}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.shouhuorenAddress}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.productName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.applyStatus}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.fahuoStatus}
					</td>
					 <td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.shouhuorenTel}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuhuoren.shouhuorenName}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="chuhuorenDel(${chuhuoren.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			
	</body>
</html>
