<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE>
<html>
  <head>
    <title>二手跳蚤-宝贝发布</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
  </head>
  <script type="text/javascript">
  function test()
  {
  	var title=document.form.title.value;
  	var price=document.form.price.value;
  	var originalprice=document.form.originalprice.value;
  	var description=document.form.description.value;
  	var upload_image=document.form.upload_image.value;
  	
  	if(title=="")
  	{
  		alert("为您的商品取个名吧");
  		return false;
  	}else
  	if(price==""||originalprice=="")
  	{
  		alert("请给出卖价和原价");
  		return false;
  	}else
  	if(description=="")
  	{
  		alert("请填写商品描述");
  		return false;
  	}else
  	if(upload_image=="")
  	{
  		alert("为您的商品选一张美丽的照片吧");
  		return false;
  	}
  	return true;
  }
  
  </script>
  <body style="background-color: 00ced1">
   <jsp:include page="../page/head.jsp"></jsp:include>
    
	  <form enctype="multipart/form-data"  name="form"  action="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=UploadImage" onsubmit="return test()"  method="post">
	  <div class="container">
				<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="width:530px;">
						<div class="panel-heading">宝贝发布&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size=4 color="red">${message }</font></div>
						<div style="padding-left: 5%" class="panel-body">
							<div style="margin: 15px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<div style="width: 75%">
									<input type="text" name="title" class="form-control"
										placeholder="标题">
								</div>
							</div>
							<div  style="margin: 15px 0;" class="input-group input-group-sm">
								<span class="input-group-addon">&nbsp;&nbsp;&nbsp;&nbsp;类别：&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<div style="width: 75%">
									<select name="category"  class="form-control">
									<option value="null">请选择类别</option>
									<optgroup label="手机">
									<option value="智能手机">智能手机</option>
									<option value="非智能手机">非智能手机</option	>	
									</optgroup>			
									</select>
								</div>
							</div>
							<div style="margin: 15px 0;" class="input-group input-group-sm">
							   <span class="input-group-addon">交易类型：</span>							   							 
        						 <input type="radio"  name="trading"  checked  value="在线交易">在线交易
        						 <input type="radio"  name="trading"  value="线下交易">线下交易
        						 				 
							</div>
							
							<div style="margin: 15px 0;" class="input-group">
									<span class="input-group-addon">&nbsp;&nbsp;价格：&nbsp;&nbsp;</span>
									<div style="width:33%">
									<input type="text" name="price" class="form-control"  placeholder="卖价">
									<input type="text" name="originalprice" class="form-control"  placeholder="原价" >
									</div>
							</div>
							<div class="input-group">
								<span class="input-group-addon">&nbsp;&nbsp;描述：&nbsp;&nbsp;</span>
								<textarea rows="5" cols="50" name="description"></textarea>
							</div>
							
							<div style="margin: 15px 0;" class="form-group">
								<label for="exampleInputFile">宝贝图片：</label>
								<input type="file" name="upload_image">
								<p class="help-block">图片经上传不可修改，请选择适合的图片</p>
							</div>
							<div style="margin: 15px 0;">
							<button type="submit" class="btn btn-success">立刻发布</button>
							
							</div>
						</div>
					</div>
				</div>
			</div>
	  </form>
	</div> 
  </body>
</html>
