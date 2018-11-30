<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    
    <title></title>
	
  </head>
  
  <body>
  		<div class="container">
  			<div class="row">
  				<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">&nbsp;增加新闻 </h3>
				</div>
					<form target="main" class="form-horizontal" action="${pageContext.request.contextPath }/servlet/NewsManager?actiontype=add&admin=${admin}" method="post">
						<table class="table table-bordered">
							<tr>
								<th>标题</th><td><input style="width:100%;" type="text" name="title"></td>
							</tr>
							<tr>
								<th>内容</th><td><textarea class="form-control" rows="10" name="content"></textarea></td>
							</tr>
							<tr>
								<th></th><td><button type="submit" class="btn btn-sucess">发布新闻</button></td>
							</tr>
						</table>
					</form>
				</div>	
  			</div>
  			
  			<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
								    <script type="text/javascript">
								 	CKEDITOR.replace( 'content', {
								 		toolbar : 'Standard',
								        uiColor : '#9AB8F3',
										filebrowserImageUploadUrl : '${pageContext.request.contextPath}/ckeditor/uploader?Type=Image',  
        								filebrowserWindowWidth: '640',
								 	    filebrowserWindowHeight: '480'
									});
			 </script>
  			
  			<div class="row">
  				<div class="panel panel-primary">
  					<div class="panel-heading">新闻列表</div>
  					<table class="table table-bordered">
						<tr> 
							<th>标题</th>
							<th>发布人</th>
							<th>创建时间</th>
							<th>更新时间</th>
							<th>操作</th>
						</tr>
						<c:forEach var="news" items="${newses}">
							<tr>
								<td>${news.title}</td>
								<td>${news.publisher}</td>
								<td>${news.createtime}</td>
								<td>${news.updatetime}</td>
								<td>
									<a href="${pageContext.request.contextPath}/servlet/NewsManager?actiontype=show&id=${news.id}" >查看</a>
									<a href="${pageContext.request.contextPath}/servlet/NewsManager?actiontype=updatenewui&id=${news.id}">更新</a>
									<a href="${pageContext.request.contextPath}/servlet/NewsManager?actiontype=delete&id=${news.id}">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
  				</div>
  			</div>
  		</div>
  
  
  
		
	</body>
</html>