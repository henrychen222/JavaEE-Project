<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

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
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
		<script language="javascript">
		  function up()
		   {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/upload/upload.jsp");
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
		   }
		    function upup()
		   {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/upload/uploadZigezheng.jsp");
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
		   }
            function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		    function check1()
		    {
		        if(document.form1.name.value=="")
		        {
		            alert("请输入名字 ");
		            return false;
		        }
		        if(document.form1.age.value=="")
		        {
		            alert("请输入年龄");
		            return false;
		        }
		         
		        
		        document.form1.submit();
		    }
		    
		   
           
        </script>
	</head>
	<body>
			<form action="<%=path %>/jingyingren?type=jingyingrenAdd" name="form1" method="post">
			
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
				  <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						   <td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							头&nbsp;&nbsp;&nbsp;&nbsp;像：
						</td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="fujian" id="fujian" style="width: 300px;" readonly="readonly"/>
						        <input type="button" value="上传" onclick="up()"/>
						        <input type="hidden" name="fujianYuanshiming" id="fujianYuanshiming"/>
						    </td>
						</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;姓名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="name" style="width: 150px;"/>
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
							<input type="text" name="age" style="width: 150px;"/>岁
						</td>
					</tr>
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;经验：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="jingyan" style="width: 150px;"/>年
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;公司：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="gongsi" style="width: 150px;"/>
						</td>
					</tr>
					 <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						   <td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							多式联运经营人&nbsp;&nbsp;&nbsp;&nbsp;资格证附件：
						</td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="zigezhengFujian" id="zigezhengFujian" style="width: 300px;" readonly="readonly"/>
						        <input type="button" value="上传" onclick="upup()"/>
						        <input type="hidden" name="zigezhengFujianYuanshiming" id="zigezhengFujianYuanshiming"/>
						    </td>
						</tr>
					
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="button" value="确定" onclick="check1();"/>
							<input type="button" value="取消" onclick="closeOpen()"/>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>
