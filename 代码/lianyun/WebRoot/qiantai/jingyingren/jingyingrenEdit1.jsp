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
              
                   window.location.href="<%=path %>/jingyingren?type=jingyingrenEdit&id="+id;
               
           }
		    
        </script>
	</head>
	<body>
			<form action="<%=path %>/jingyingren?type=jingyingrenEdit" name="form1" method="post">
			 <input type="hidden" name="id" value="${requestScope.jingyingren.id }"/>
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
				 
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;姓名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.jingyingren.name }" name="name" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
						多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;性别：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
						<input type="radio" name="sex" value="男" checked="checked"/>男&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="女"/>女
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;年龄：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.jingyingren.age }" name="age" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;公司：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.jingyingren.gongsi }" name="gongsi" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;经验：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" value="${requestScope.jingyingren.jingyan }" name="jingyan" style="width: 150px;"/>
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
