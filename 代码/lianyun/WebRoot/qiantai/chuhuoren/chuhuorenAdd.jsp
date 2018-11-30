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
	            pop.setContent("contentUrl","<%=path %>/upload/upload1.jsp");
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
		         if(document.form1.telephone.value=="")
		        {
		            alert("请输入联系方式");
		            return false;
		        }
		         if(document.form1.address.value=="")
		        {
		            alert("请输入家庭住址");
		            return false;
		        }
		        
		        document.form1.submit();
		    }
		    
		   
           
        </script>
	</head>
	<body>
			<form action="<%=path %>/chuhuoren?type=chuhuorenAdd" name="form1" method="post">
			
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
							出货人&nbsp;&nbsp;&nbsp;&nbsp;姓名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="name" style="width: 150px;"/>
						</td>
					</tr>
					
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
						出货人&nbsp;&nbsp;&nbsp;&nbsp;性别：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
						<input type="radio" name="sex" value="男" checked="checked"/>男&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="女"/>女
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							出货人&nbsp;&nbsp;&nbsp;&nbsp;年龄：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="age" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货人&nbsp;&nbsp;&nbsp;&nbsp;姓名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="shouhuorenName" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							出货人&nbsp;&nbsp;&nbsp;&nbsp;电话：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="telephone" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货人&nbsp;&nbsp;&nbsp;&nbsp;电话：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="shouhuorenTel" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							出货人&nbsp;&nbsp;&nbsp;&nbsp;住址：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="address" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							收货人&nbsp;&nbsp;&nbsp;&nbsp;住址：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="shouhuorenAddress" style="width: 150px;"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							产品&nbsp;&nbsp;&nbsp;&nbsp;名称：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="productName" style="width: 150px;"/>
						</td>
					</tr>
					 <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						   <td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							产品&nbsp;&nbsp;&nbsp;&nbsp;图片：
						</td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="productFujian" id="productFujian" style="width: 300px;" readonly="readonly"/>
						        <input type="button" value="上传" onclick="upup()"/>
						        <input type="hidden" name="productFujianYuanshiming" id="productFujianYuanshiming"/>
						    </td>
						</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							申请&nbsp;&nbsp;&nbsp;&nbsp;状态：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<select name="applyStatus">
							<option value="">请选择选择......!</option>
							<option value="已申请">已申请</option>
							<option value="未申请">未申请</option>
							
							</select>
						</td>
					</tr>
					
					
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							发货&nbsp;&nbsp;&nbsp;&nbsp;状态：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<select name="fahuoStatus">
							<option value="请选择发货状态............">请选择发货状态............</option>
							<option value="未发货">未发货</option>
							<option value="已发货">已发货</option>
							
							</select>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
							身份证&nbsp;&nbsp;&nbsp;&nbsp;信息：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="identity" style="width: 150px;"/>
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
