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
              
                   window.location.href="<%=path %>/yunshu?type=yunshuEdit&id="+id;
               
           }
		    
        </script>
	</head>
	<body>
			<form action="<%=path %>/yunshu?type=yunshuEdit" name="form1" method="post">
			 <input type="hidden" name="id" value="${requestScope.yunshu.id }"/>
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
				 <tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							产品&nbsp;&nbsp;&nbsp;&nbsp;名称：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.yunshu.productName }" name="productName" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							出货人&nbsp;&nbsp;&nbsp;&nbsp;姓名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.yunshu.chuhuorenName }" name="chuhuorenName" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货人&nbsp;&nbsp;&nbsp;&nbsp;姓名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.yunshu.shouhuorenName }" name="shouhuorenName" style="width: 150px;"/>
						</td>
					</tr>
					
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							出货人&nbsp;&nbsp;&nbsp;&nbsp;电话：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.yunshu.chuhuorenTel }" name="chuhuorenTel" style="width: 150px;"/>
						</td>
					</tr>
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货人&nbsp;&nbsp;&nbsp;&nbsp;电话：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.yunshu.shouhuorenTel }" name="shouhuorenTel" style="width: 150px;"/>
						</td>
					</tr>
					
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							运输&nbsp;&nbsp;&nbsp;&nbsp;方式：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<select name="yunshuStyle">
							<option value="">请选择选择......!</option>
							<option value="海--陆运输">海--陆运输</option>
							<option value="海--陆--空运输">海--陆--空运输</option>
							<option value="海上运输">海上运输</option>
							<option value="海--空运输">海--空运输</option>
							<option value="陆上运输">陆上运输</option>
							<option value="陆--空运输">陆--空运输</option>
							<option value="空中运输">空中运输</option>
							</select>
						</td>
						
					</tr>
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							运输&nbsp;&nbsp;&nbsp;&nbsp;费用：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.yunshu.feiyong }" name="feiyong" style="width: 150px;"/>元
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
