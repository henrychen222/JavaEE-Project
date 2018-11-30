<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <script type="text/javascript">
      function userLogout()
	        {
	            document.getElementById("indicator1").style.display="block";
	            loginService.userLogout(callback1);
	        }
	        function callback1(data)
			{
			    document.getElementById("indicator1").style.display="none";
			    if(data=="no")
			    {
			        alert("系统错误，请联系管理员");
			    }
			    if(data=="yes")
			    {   alert("成功退出系统");
			        window.location.reload();
			    }
			    
			}
         function admin()
         {
            var url="<%=path %>/login.jsp";
            window.location.href=url;
         } 
         
         function userReg()
         {
                var url="<%=path %>/qiantai/userinfo/userReg.jsp";
                var ret = window.showModalDialog(url,"","dialogWidth:800px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
         }
         
         function liuyanAll(){
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path %>/liuyan?type=liuyanAll";
				var targetWinName="newWin";
				var features="width="+screen.width-200+" ,height="+screen.height-150+" ,toolbar=no, top=0, left=0, menubar=no, scrollbars=no, resizable=no,location=no, status=no"
				var new_win=window.open(url,targetWinName,features);
            </c:if>
         } 
         function userShow(){
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                var url="<%=path %>/user?type=userMana";
				window.location.href=url;
            </c:if>
         }
          function chuhuoren(){
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null&&sessionScope.userType==0||sessionScope.userType==3}">
                var url="<%=path %>/chuhuoren?type=chuhuorenMana";
				window.location.href=url;
            </c:if>
         }
        
        
        function jingyingren(){
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null&&sessionScope.userType==1||sessionScope.userType==3}">
                var url="<%=path %>/jingyingren?type=jingyingrenMana";
				window.location.href=url;
            </c:if>
         }
        
         function shouhuoren(){
            <c:if test="${sessionScope.user==null}">
                  alert("请先登录");
            </c:if>
            
            <c:if test="${sessionScope.user!=null&&sessionScope.userType==2||sessionScope.userType==3}">
                var url="<%=path %>/shouhuoren?type=shouhuorenMana";
				window.location.href=url;
            </c:if>
         }
        
         function newsAll()
         {
            var url="<%=path %>/news?type=newsAll";
            window.location.href=url;
         } 
       
      </script>
  </head>
  
  <body>
       <TABLE  border=0 cellSpacing=0 cellPadding=0 width=772 align=center style="background-image: url('<%=path %>/image/banner.jpg'); background-repeat : repeat-xy">
		  <TR>
		    <TD style="height: 30px;font-weight: 900;color: #fdfcfc; ">
		         &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="chuhuoren()"><font size="3" color="#e9f1f4">出货人托运申请</font></A>
		         &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="jingyingren()"><font size="3" color="#e9f1f4">多式联运经营人管理</font></A>
		      &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="shouhuoren()"><font size="3" color="#e9f1f4">收货人管理</font></A>
		         
		         &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="admin()"><font size="3" color="#e9f1f4">管理员登录</font></a>
		    &nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="userLogout()"><font size="3" color="#e9f1f4">安全退出</font></a>
		    </TD>
		  </TR>
	   </TABLE>
  </body>
</html>
