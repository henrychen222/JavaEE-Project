<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>俱合家具网</title>
<%@include file="_head.jsp"%>
<link href="<%=request.getContextPath()%>/common/css/login.css"
	rel="stylesheet" type="text/css"></link>
<script src="<%=request.getContextPath()%>/common/js/framework/login.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="logintop">
		<div class="middle">
			<a href="#" class="audittit"> <img
				src="../common/images/common/auditlogin.png" alt="俱合网" title="俱合网" />
			</a> <a href="#" class="auditlogin"> <img
				src="../common/images/common/logintitle.png" alt="管理平台"
				title="管理平台" /> </a>
		</div>
	</div>
	<div class="logininfo">
		<div class="logintub">
			<div class="middle">
				<div class="loginifleft">
					<dl>
						<dd>
						</dd>
					</dl>
				</div>
				<form id="myForm" method="post"
					action="<%=request.getContextPath()%>/login/login.do">
					<div class="loginifright" id="focus">
						<ul>
							<p class="ptit">登录系统</p>
							<li><span id="uname"></span> <input id="id"
								class="input_txt" name="userAccount" type="text" value="" />
							</li>
							<li><span id="upsw"></span> <input id="password"
								class="input_txt" name="pwd" type="password" value="" />
							</li>
							<p class="jzpwd">
								<span id="bumeng" style="display: none;"></span>
								<div id="error">
									<font size="2" face="arial" color="red">${message}</font>
								</div>
							</p>
							<p class="loginbtuif">
								<a href="javascript:void(0);" class="loginbtu">登录系统</a> <a
									href="javascript:void(0);" class="nopwdbtu">忘记密码</a>
							</p>
						</ul>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
