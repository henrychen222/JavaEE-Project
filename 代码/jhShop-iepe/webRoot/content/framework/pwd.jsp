<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%@include file="../_head.jsp" %>
</head>
<body>
	<form id="pwdForm" method="post">
		<table width="100%">
			<tr>
				<td width="30%" align="right"><b style="color:#ff0000">*</b>原密码:</td>
				<td width="70%" align="left"><input id="oldPwd" name="oldPwd" type="password" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<td width="30%" align="right"><b style="color:#ff0000">*</b>新密码:</td>
				<td width="70%" align="left"><input id="newPwd" name="newPwd" type="password" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<td width="30%" align="right"><b style="color:#ff0000">*</b>确认密码:</td>
				<td width="70%" align="left"><input id="againPwd" type="password" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<td width="100%" align="center" colspan="2" id="msg"></td>
			</tr>
			<tr>
				<td width="100%" align="center" colspan="2"><a href="javascript:void(0)" class="easyui-linkbutton" onClick="savePwd()">保存</a></td>
			</tr>
		</table>
	</form>
    <script type="text/javascript">
    function savePwd(){
		var oldPwd=$('#oldPwd').val();
    	if(!isStringNull(oldPwd))
		{
    		$("#msg").empty();
    		$("#msg").append("<b style='color:#ff0000'>原密码不能为空！</b>");
			return;
		}
		var newPwd=$('#newPwd').val();
    	if(!isStringNull(newPwd))
		{
    		$("#msg").empty();
    		$("#msg").append("<b style='color:#ff0000'>新密码不能为空！</b>");
			return;
		}
		var againPwd=$('#againPwd').val();
		if(newPwd!=againPwd){
			$("#msg").empty();
    		$("#msg").append("<b style='color:#ff0000'>两次密码不一致！</b>");
			return;
		}

    	$("#pwdForm").form("submit",{
    		url:"${pageContext.request.contextPath}/main/savePwd.do",
    	    onSubmit: function(){  
    	    },  
    		success:function(data){
    			if(data=='2'){
    				$("#msg").empty();
    	    		$("#msg").append("<b style='color:#ff0000'>原密码不正确！</b>");
    			}else if(data=='3'){
    				$("#msg").empty();
    	    		$("#msg").append("<b style='color:#ff0000'>修改密码失败！</b>");
    			}else{
        			window.parent.ymPrompt.close();
    			}
    		} 
		}); 
    } 
    </script>
</body>
</html>
