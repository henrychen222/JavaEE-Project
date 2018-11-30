<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		    function eidt(id)
           {
              
                   window.location.href="<%=path %>/shouhuoren?type=shouhuorenEdit&id="+id;
               
           }
		    
        </script>
	</head>
	<body>
			<form action="<%=path %>/shouhuoren?type=shouhuorenEdit" name="form1" method="post">
			 <input type="hidden" name="id" value="${requestScope.shouhuoren.id }"/>
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
				 
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货人&nbsp;&nbsp;&nbsp;&nbsp;姓名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.shouhuoren.name }" name="name" style="width: 150px;"/>
						</td>
					</tr>
					
					
					
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货人&nbsp;&nbsp;&nbsp;&nbsp;电话：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.shouhuoren.tel }" name="tel" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货人&nbsp;&nbsp;&nbsp;&nbsp;地址：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.shouhuoren.address }" name="address" style="width: 150px;"/>
						</td>
					</tr>
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							产品&nbsp;&nbsp;&nbsp;&nbsp;名称：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.shouhuoren.productName }" name="productName" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货&nbsp;&nbsp;&nbsp;&nbsp;状态：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<select name="shouhuoStatus">
							<option value="请选择..........!">请选择..........!</option>
							<option value="未收货">未收货</option>
							<option value="已收货">已收货</option>
							</select>
						</td>
					</tr>
					
					
					
					
					
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="submit" value="确定" />
							<input type="button" value="取消" onclick="closeOpen()"/>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>
