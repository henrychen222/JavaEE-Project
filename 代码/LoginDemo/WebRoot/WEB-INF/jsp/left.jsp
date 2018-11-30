<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
   String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <meta http-equiv="pragma" content="no-cache">
	  <meta http-equiv="cache-control" content="no-cache">
	  <meta http-equiv="expires" content="0">    
	  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	  <meta http-equiv="description" content="This is my page">
      
      <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
     <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
      <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
     
      <script type="text/javascript">
            function check()
			{                                                                                         
			     if(document.ThisForm.loginname.value=="")
				 {
				 	alert("请输入账号");
					return false;
				 }
				 if(document.ThisForm.loginpw.value=="")
				 {
				 	alert("请输入密码");
					return false;
				 }
				
				 loginService.login(document.ThisForm.loginname.value,document.ThisForm.loginpw.value,document.ThisForm.userType.value,callback);
			}
		
			function callback(data)
			{
			    document.getElementById("indicator").style.display="none";
			    if(data=="no")
			    {
			        alert("账号或密码错误");
			    }
			    if(data=="yes")
			    {   alert("登陆成功");
			        window.location.href="<%=path %>/front/center.jsp";
			    }
			}
	                
	        	       
			function userReg(){
			 var url="<%=path %>/front/userReg.jsp"
            window.location.href=url;
			}
			
      </script>
  </head>
  
  <body>
        	       
		
		       
		    
		        <tr>
		          <td class=b vAlign=top>
		            <table border=0 cellSpacing=0 cellPadding=0 width=178>
		              <tr>
				          <td height="27" style="background-image: url('<%=path %>/image/gonggao.gif'); background-repeat : repeat-xy;">
				             &nbsp;&nbsp;&nbsp;&nbsp;<font color="white" style="font-weight: 700">******登录窗口******</font>
				          </td>
				      </tr>
		            </table>
		            <table border=0 cellSpacing=3 cellPadding=3 width=178 height=22>
		              <tr>
		                <td height=22 vAlign=middle width="100%">
		                    <c:if test="${sessionScope.user==null}">
		                    <form action="<%=path %>/user?type=userLogin" name="ThisForm" method="post">
							      <table cellspacing="0" cellpadding="0" width="98%" align="center" border="0" height="60">
							          <tr>
							            <td align="center" colspan="2" height="10"></td>
							          </tr>
							           
							          <tr>
							            <td align="right" width="31%" height="30" style="font-size: 11px;">类型：</td>
							            <td align="left" width="69%">
							            <select name="userType">
							            <option value="">请选择</option>
							            <option value="0">用户</option>
							           
							            </select>
							            </td>
							          </tr>
							         
							          <tr>
							            <td align="right" width="31%" height="30" style="font-size: 11px;">账号：</td>
							            <td align="left" width="69%"><input name="loginname" type="text" style="width: 100px;"/></td>
							          </tr>
							          <tr>
							            <td align="right" height="30" style="font-size: 11px;">密码：</td>
							            <td align="left"><input type="password" style="width: 100px;" name="loginpw"/></td>
							          </tr>
							          <tr>
							            <td align="center" colspan="2" height="10"></td>
							          </tr>
							          <tr>
							            <td align="center" colspan="2" height="60">
							               <input type="button" value="登  录" onclick="check()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
										   <input type="button" value="注  册" onclick="userReg()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
							               <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
							            </td>
							          </tr>
							      </table>
						    </form>
						    </c:if>
						    <c:if test="${sessionScope.user!=null}">
						     <br/> <br/>
						     <a href="#" onclick="userLogout()">安全退出</a> 
							    <img id="indicator1" src="<%=path %>/img/loading.gif" style="display:none"/>
						       
						        欢迎您：${sessionScope.user.loginname } 
							    
							    <br/><br/><br/>
							</c:if>
		                </td>
		              </tr>
		            </table>
		          </td>
		        </tr>
		        <tr><td height="10"></td></tr>
		        
		</TABLE> 
  </body>
</html>
