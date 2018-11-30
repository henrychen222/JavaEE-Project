<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>发布商品</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/userPuDoods.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/js/carousel.js"></script>
    <script src="${pageContext.request.contextPath }/js/LeftNavigation.js"></script>
  
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
  		alert("为您的商品选一张漂亮的图片吧");
  		return false;
  	}
  	return true;
  }
  
  </script>
  <body>
  <jsp:include page="../page/head.jsp"></jsp:include>
  <div id="left">
   <div class="panel panel-success" style="margin-bottom:0px;">
    <div class="panel-heading">
    	 &nbsp;
    </div>
  </div>
  <div class="panel panel-success" style="margin-bottom:0px;">
    <div class="panel-heading" align="center">
    	 <h3>我的交易</h3>
    </div>
  </div>
  <div class="panel panel-success" style="margin-bottom:0px;">
    <div class="panel-heading" align="center">
  	  <ul>
		 <li>
			  <a  href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=showSelfInfoUI&id=${user.id}">
	 		 	  个人资料
			 </a>
		 </li>
	  </ul>
	</div>
   </div>
   <div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		 <li>
			<a  href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=updatePasswordUI&id=${user.id}">
				修改密码
	 		</a>
		 </li>
	  </ul>
	</div>
   </div>
   <div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=listmeorder" rel="nofollow">
			         我的订单
			</a>
		</li>
	 </ul>
	</div>
   </div>
<div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=publishGoodsUI&id=${user.id}" >
			         发布商品
			</a>
		</li>
	 </ul>
	</div>
   </div>
    <div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listproduct&username=${user.username}" >
			         我的闲置
			</a>
		</li>
	 </ul>
	</div>
	</div>
	  <div class="panel panel-success" style="margin-bottom:0px;">
	    <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listSoldOutProduct&username=${user.username}" >
			      已经下架
			</a>
		</li>
	 </ul>
	</div>
	</div>
   <div class="panel panel-success" style="margin-bottom:0px;">
     <div class="panel-heading" align="center">
       <ul>
		<li>
			<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listCollect&id=${user.id}" >
			         我的收藏
			</a>
		</li>
	 </ul>
	</div>
   </div>
  <div class="panel panel-success" style="margin-bottom:0px;">
    <div class="panel-heading">
    	 &nbsp;
    </div>
  </div>
  </div>


  <div id="center">
	  <div class="container">
				<div class="row" style="opacity: 0.85;">
					<div class="panel panel-info" style="width:530px;">
						<div class="panel-heading">宝贝发布</div>
  	 					<form name="form" enctype="multipart/form-data" action="${pageContext.request.contextPath }/servlet/ProductManager?actiontype=UploadImage"  onsubmit="return test()"  method="post">
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
								<div style="width: 75%" >
									<select name="category"  class="form-control" >
									<option value="null">请选择类别</option>
									<optgroup label="手机、配件">
									<option value="3">智能手机</option>
									<option value="4">非智能手机</option	>
									<option value="6">蓝牙耳机</option	>	
									<option value="7">有线耳机</option>	
									<option value="8">耳机转接线</option>	
									<option value="9">手机音箱</option>
									<option value="11">标准电池</option>	
									<option value="12">商务电池</option>	
									<option value="13">充电器</option>	
									<option value="14">移动电源</option>
									<option value="16">存储卡</option>	
									<option value="17">读卡器</option>	
									<option value="18">数据线</option>
									<option value="20">手机保护膜</option>	
									<option value="21">手机挂件</option>	
									<option value="22">手机套</option>	
									</optgroup>	
									<optgroup label="摄影影像">
									<option value="25">数码相机</option>
									<option value="26">单反相机</option>
									<option value="27">单反配件</option>
									<option value="29">长焦镜头</option>
									<option value="30">广角镜头</option>
									<option value="31">微距镜头</option>
									<option value="32">三脚架</option>
									<option value="33">镜头布</option>
									<option value="34">单反其他配件</option>
									</optgroup>	
									<optgroup label="电脑、配件">
									<option value="37">笔记本电脑</option>
									<option value="38">平板电脑</option>
									<option value="40">台式电脑</option>
									<option value="41">主机</option>
									<option value="42">显示器</option>
									<option value="67">内存条</option>
									<option value="68">网卡</option>
									<option value="69">声卡</option>
									<option value="70">显卡</option>
									<option value="71">CPU</option>
									<option value="72">主板</option>
									<option value="73">硬盘</option>
									<option value="75">鼠标</option>
									<option value="76">键盘</option>
									<option value="77">电源</option>
									<option value="78">移动硬盘</option>
									<option value="79">U盘</option>
									<option value="80">电脑音箱</option>
									<option value="81">电脑包</option>
									<option value="82">摄像头</option>
									<option value="83">散热风扇</option>
									<option value="84">鼠标垫</option>
									<option value="85">电脑清洁工具</option>
									</optgroup>
									<optgroup label="书籍，学习资料">
									<option value="45">本科教材</option>
									<option value="46">专科教材</option>
									<option value="48">同步练习</option>
									<option value="49">阶段测试</option>
									<option value="50">复习类</option>
									<option value="52">小说</option>
									<option value="53">其他类</option>
							        </optgroup>
							        <optgroup label="随声影音">
							        <option value="56">MP3</option>
							        <option value="57">MP4</option>
							        <option value="58">MP5</option>
							        <option value="59">复读机</option>
							        <option value="60">录音笔</option>      
							        <option value="61">收录机</option>      
							        <option value="63">耳机</option>      
							        <option value="64">耳麦</option>      
							        </optgroup>
							        <optgroup label="办公设备">
							        <option value="88">打印机</option>
							        <option value="89">扫描仪</option>
							        <option value="90">投影仪</option>
							        <option value="91">复印机</option>
							        <option value="92">传真机</option>
							        <option value="94">无线路由</option>
							        <option value="95">有线路由</option>
							        <option value="96">交换机</option>
							        </optgroup>
							        <optgroup label="厨房用品">
							        <option value="99">电磁炉</option>
							        <option value="100">电饭煲</option>
							        <option value="101">微波炉</option>
							        <option value="102">电水煲/电水壶</option>
							        <option value="103">豆浆机</option>
							        <option value="104">其他</option>
							        <option value="106">餐具</option>
							        <option value="107">锅具</option>
							        <option value="108">杯</option>
							        <option value="109">其他</option>
							        </optgroup>
							        
							        <optgroup label="日常生活用品">
							        <option value="112">凉席</option>
							        <option value="113">蚊帐</option>
							        <option value="114">盆子</option>
							        <option value="115">水瓶</option>
							        <option value="116">雨具</option>
							        <option value="117">桌/椅</option>
							        <option value="118">其他</option>
							        <option value="120">电风扇</option>
							        <option value="121">台灯</option>
							        <option value="122">电吹风</option>
							        <option value="123">剃须刀</option>
							        <option value="124">美容美发器</option>
							        <option value="125">电热毯</option>
							        <option value="126">电热袋</option>
							        <option value="127">其他</option>
							        </optgroup>
							        
							        <optgroup label="服装鞋帽、箱包">
							        <option value="130">帽子</option>
							        <option value="131">眼镜</option>
							        <option value="132">皮带</option>
							        <option value="133">围巾</option>
							        <option value="134">发饰</option>
							        <option value="136">衬衫</option>
							        <option value="137">T恤</option>
							        <option value="138">裙装</option>
							        <option value="139">外套</option>
							        <option value="140">运动装</option>
							        <option value="141">休闲装</option>
							        <option value="142">牛仔裤</option>
							        <option value="143">鞋</option>
							        <option value="144">其他</option>
							        </optgroup>
							        <optgroup label="箱包、钟表首饰">
							        <option value="146">旅行箱</option>
							        <option value="147">运动休闲包</option>
							        <option value="148">手表</option>
							        <option value="149">闹钟</option>
							        <option value="150">耳环/耳钉/耳坠</option>
							        <option value="151">手链/手镯</option>
							        <option value="152">项链/吊坠</option>
							        <option value="153">戒指</option>
							        <option value="154">其他</option>
							        </optgroup>
							        <optgroup label="户外用品">
							        <option value="156">体育用品</option>
							        <option value="157">乒乓球用品</option>
							        <option value="158">羽毛球用品</option>
							        <option value="159">篮球用品</option>
							        <option value="160">足球用品</option>
							        <option value="161">网球用品</option>
							        <option value="162">排球用品</option>
							        <option value="164">自行车</option>
							        <option value="165">电动车</option>
							        <option value="166">健身器材</option>
							        </optgroup>
									</select>
								</div>
							</div>
							<div style="margin: 15px 0;" class="input-group input-group-sm">
							   <span class="input-group-addon">交易类型：</span>							   							 
        						  <input type="radio"  name="trading"  checked value="在线交易">在线交易
        						 <input type="radio"  name="trading"  value="线下交易">见面交易
        												 
							</div>
							
							<div style="margin: 15px 0;" class="input-group">
									<span class="input-group-addon">&nbsp;&nbsp;价格：&nbsp;&nbsp;</span>
									<div style="width:33%">
									<input type="text" name="price" class="form-control"  placeholder="卖价">
									<input type="text" name="originalprice" class="form-control"  placeholder="原价">
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
							<font size=4 color="red">${message }</font>
						</div>
    					</form>
					</div>
				</div>
			</div>
 	 </div>
 	 <div  id="right">
 	 
 	 <a title="${recommendProduct.name }" href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ recommendProduct.id}"target=_blank>
				     <img style="height: 300px" class="img-responsive img-rounded" data-src="holder.js/100%x180" src="${recommendProduct.uploadImage }" alt="${recommendProduct.name }">
				   </a>
  </body>
 
      
</html>