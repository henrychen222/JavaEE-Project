<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			overflow:hidden;
		}
		-->
	</style>
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
	 <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
	 <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
	      
	 <script language="javascript">
	 function check1()
	 {                                                                                         
	     if(document.ThisForm.userName.value=="")
		 {
		 	alert("请输入用户名");
			document.ThisForm.userName.focus();
			return false;
		 }
		 if(document.ThisForm.userPw.value=="")
		 {
		 	alert("请输入密码");
			document.ThisForm.userPw.focus();
			return false;
		 }
		 document.getElementById("indicator").style.display="block";
		 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,3,callback);
	 }
	
	 function callback(data)
	 {
	    document.getElementById("indicator").style.display="none";
	    if(data=="no")
	    {
	        alert("用户名或密码错误");
	    }
	    if(data=="yes")
	    {
	        alert("通过验证,系统登录成功");
	        window.location.href="<%=path %>/loginSuccess.jsp";
	    }
	 }
	 </script>
  </head>
  
  <body>
		<FORM action="<%=path %>/admin/index.jsp" name="ThisForm" method="post">
			<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="#1da3db">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="608" background="<%=path %>/img/login_03.gif">
						<table width="862" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="266" background="<%=path %>/img/login_04.gif">
								     <div style="FONT-WEIGHT: bold; FONT-SIZE: 28pt; " align="center">
								          
								     </div>
								</td>
							</tr>
							<tr>
								<td height="95">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="424" height="95" background="<%=path %>/img/login_06.gif">
												&nbsp;
											</td>
											<td width="183" background="<%=path %>/img/login_07.gif">
												<table width="100%" border="0" height="90" cellspacing="2" cellpadding="0">
													<tr>
														<td width="25%" height="15">
															<span style="font-size: 12px;">
															   用户名: 
															</span>
														</td>
														<td width="75%" height="15">
															<span class="STYLE3">
															   <input type="text" id=a name="userName" style="height:18px; width:100px; border:solid 1px ; font-size:12px; ">
															</span>
														</td>
													</tr>
													<tr>
														<td width="25%" height="15">
															<span style="font-size: 12px;">
															   密&nbsp;&nbsp;&nbsp;码: 
															</span>
														</td>
														<td width="75%" height="15">
															<span class="STYLE3">
															   <input type="password" id=a name="userPw" style="height:18px; width:100px; border:solid 1px; font-size:12px; ">
															</span>
														</td>
													</tr>
													<tr style="display: none">
														<td width="25%" height="15">
															<span style="font-size: 12px;">
															   类&nbsp;&nbsp;&nbsp;&nbsp;型: 
															</span>
														</td>
														<td width="75%" height="15">
															<span class="STYLE3">
															     <select style="width: 100" name="userType">
																 </select>
															</span>
														</td>
													</tr>
													<tr>
														<td width="25%" height="15">
															<span style="font-size: 12px;">
															</span>
														</td>
														<td width="75%" height="15">
															<span class="STYLE3">
															    <img src="<%=path %>/img/login.gif" onclick="check1()">
															    <img src="<%=path %>/img/reset.png" onclick="">
															</span>
														</td>
													</tr>
												</table>
											</td>
											<td width="255" background="<%=path %>/img/login_08.gif">
												&nbsp;<img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="247" valign="top" background="<%=path %>/img/login_09.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="22%" height="30">
												&nbsp;
											</td>
											<td width="56%">
												&nbsp;
											</td>
											<td width="22%">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td height="30">
												<table width="476" border="0" cellspacing="0"
													cellpadding="0" height="24">
													<tr>
														<td width="44%" height="20">
															&nbsp;
														</td>
														<td width="56%">
															<span style="font-size: 12px;"></span>
														</td>
													</tr>
												</table>
											</td>
											<td>
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td bgcolor="#60c0e8">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
