<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
  <head>
    <title>left</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/js/collapse.js"></script>
  </head>
  
  <body>
  	<div style="border-right: 1px solid #01AA11">
  	  <div class="panel-group" id="accordion">
  		<div class="panel panel-success" style="margin-bottom:0px;">
    		<div class="panel-heading">
     			<h6 class="panel-title">
        			<a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
         				 管理员：${admin}
        			</a>
      		    </h6>
    		</div>
	    	<div id="collapseOne" class="panel-collapse collapse in">
	      		<div class="panel-body" style="padding:0px;">
			 	   <ul>
			   		  <li><a href="${pageContext.request.contextPath }/servlet/AdminManager?actiontype=findAdmin&action=updateAdminInformation&id=${id}" target="main">个人资料</a></li>
			   		  <li><a href="${pageContext.request.contextPath }/servlet/AdminManager?actiontype=updatePasswordUI&action=changeAgain&id=${id}" target="main">修改密码</a></li>
			       </ul>
	      		</div>
	    	</div>
  		</div>
  		<%
  		String power=request.getParameter("power");
    	if(power.contains("a")){
    	%>
  		<div class="panel panel-success" style="margin-bottom: 0px;">
    	  <div class="panel-heading">
      		<h5 class="panel-title">
        	  <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
               	用户信息管理
              </a>
      		</h5>
     	  </div>
    	  <div id="collapseTwo" class="panel-collapse collapse">
      		<div class="panel-body" style="padding: 0px">
        	  <ul>
		   		<li><a href="">精确查找</a></li>
		   		<li><a href="">找回密码</a></li>
		   	  </ul>
      		</div>
    	  </div>
  		</div><% } %>
  		<%if(power.contains("b")){ %>
  		<div class="panel panel-success" style="margin-bottom: 0px;">
    	  <div class="panel-heading">
      		<h5 class="panel-title">
        	  <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
               	用户分析
              </a>
      		</h5>
     	  </div>
    	  <div id="collapseThree" class="panel-collapse collapse">
      		<div class="panel-body" style="padding: 0px">
        	  <ul>
		   		<li><a href="">用户注册统计</a></li>
		   		<li><a href="">用户登录统计</a></li>
		   		<li><a href="">用户激活统计</a></li>
		   	  </ul>
      		</div>
    	  </div>
  		</div><% } %>
  		<%if(power.contains("c")){ %>
  		<div class="panel panel-success">
    	  <div class="panel-heading" style="margin-bottom: 0px">
      		<h5 class="panel-title">
        	  <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
          		商品管理
        	  </a>
      		</h5>
    	  </div>
    	  <div id="collapseFour" class="panel-collapse collapse">
      		<div class="panel-body" style="padding: 0px">
        	  <ul>
			   	<li><a href="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=listproduct"  target="main">查看商品</a></li>
			   	<li><a href="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=listproducttype" target="main">查看商品类别</a></li>
			  </ul>
      		</div>
    	  </div>
  		</div><% } %>
  		<% if(power.contains("d")){%>
  		<div class="panel panel-success">
    	  <div class="panel-heading" style="margin-bottom: 0px">
      		<h5 class="panel-title">
        	  <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
          		新闻管理
        	  </a>
      		</h5>
    	  </div>
    	  <div id="collapseFive" class="panel-collapse collapse">
      		<div class="panel-body" style="padding: 0px">
        	  <ul>
		         <li><a href="${pageContext.request.contextPath }/servlet/NewsManager?actiontype=addUI&admin=${admin}"target="main">新闻管理</a></li>
		      </ul>
      		</div>
    	  </div>
  		</div><% } %>
  		<% if(power.contains("e")){%>
  		<div class="panel panel-success">
    	  <div class="panel-heading" style="margin-bottom: 0px">
      		<h5 class="panel-title">
        	  <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseSix">
          		管理员管理
        	  </a>
      		</h5>
    	  </div>
    	  <div id="collapseSix" class="panel-collapse collapse">
      		<div class="panel-body" style="padding: 0px">
        	  <ul>
		   		<li><a href="${pageContext.request.contextPath }/servlet/AdminTypeManager?actiontype=addUI" target="main">添加管理员类型</a></li>
		   		<li><a href="${pageContext.request.contextPath }/servlet/AdminManager?actiontype=addUI" target="main">添加管理员</a></li>
		   		<li><a href="${pageContext.request.contextPath }/servlet/AdminManager?actiontype=ListAdmin" target="main">管理员权限分配</a></li>
		   	  </ul>
      		</div>
    	  </div>
  		</div><% } %>
	  </div>
	</div> 	
  </body>
</html>
