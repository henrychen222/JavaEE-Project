<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品互换市场交易网站</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/js/carousel.js"></script>
    <script src="${pageContext.request.contextPath }/js/recommend_commodities.js"></script>
    <script src="${pageContext.request.contextPath }/js/LeftNavigation.js"></script>
    <script src="${pageContext.request.contextPath }/js/holder.js"></script>
  </head>
 
  
  <body class="root">
  	<jsp:include page="head.jsp"></jsp:include> 
  	<!--  body-top  start -->
  	  <div id="body-top">
  	  	 <div id="top-1">
  	  	 	<div id="logo" class="ld" >
  	  	 		<a href="${pageContext.request.contextPath }/servlet/IndexServlet" class="logo"title="点击返回首页"></a>
  	  	 	</div>
  	  	 	<div id="search">
  	  	 		<div class="search-from">
				  <form class="navbar-form navbar-left pull-left" action="${pageContext.request.contextPath }/servlet/SearchServlet?actiontype=search" method="post" target="_blank" role="search">		  	  	 	
		             <div class="search-group">
					      <div class="form-group">
					        <input style="width:300px;height:34px;" class="search-input" name="search" type="text" placeholder="输入关键字搜索" autofocus=" " x-webkit-speech=" ">
					      </div>
					      <button type="submit" class="btn btn-success">搜&nbsp;&nbsp;索</button>
					</div>
				  </form>
			   </div>
  	  	 	</div>
			<c:if test="${user.username!=null}">
  	  	 	<div id="my-home">
  	  	 		<dl class="m-h">
					<dt class="m-h-center">
						
						<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=centerUI" target="_blank">我的商品</a>
					</dt>
				</dl>
  	  	 	</div>
  	  	 	<div id="shop-cat">
  	  	 		<dl class="s-c">
					<dt class="s-c-center">
						<s></s>
						<a href="${pageContext.request.contextPath }/servlet/businessServlet?actiontype=gotoCartUI" target="_blank"id="settleup-url">购物车</a> 
					</dt>
				</dl>
  	  	 	</div>
			</c:if>
  	  	 </div>
  	  	 <div id="top-2">
  	  	 	<div id="navigation">
  	  	 		<div id="shop-sort">
					<H4>热门二手分类<b></b></H4>
  	  	 		</div>
  	  	 		<div id="n-right">
					<c:if test="${user.username!=null}">
					<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=publishGoodsUI&id=${user.id}"target="_blank"class="btn btn-success" >发布宝贝</a>
					<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listproduct"target="_blank"class="btn btn-success">我的闲置</a>
					</c:if>
					<c:if test="${user.username==null}">
					<a href="${pageContext.request.contextPath }/servlet/UserServlet?actiontype=loginUI2"target="_blank"class="btn btn-success" >发布宝贝</a>
					<a href="${pageContext.request.contextPath}/servlet/UserServlet?actiontype=listproduct"target="_blank"class="btn btn-success">我的闲置</a>
					</c:if>
				</div>
  	  	 		<ul id="navitems">
				</ul>
  	  	 	</div>
  	  	 </div>
	  </div>
	<!--  body-top  end -->
  	<!--  body-neck  start -->
	  <div id="body-neck">
	  	 <div class="b-n-left">
	  	 	<DIV class=menuNav>
		      <DIV id=SNmenuNav class=navlist>
		        <DL>
		          <DT class=icon01><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=1&style=image" target=_blank>手机、配件</A></DT>
		         <DD class=menv01>
		           <UL class=sideleft>
		             <H3>手机、配件</H3>
		              <LI><B>手机</B>
		                <DIV><A title=智能手机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=3&style=image" target=_blank>智能手机</A> 
							 <A title=非智能手机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=4&style=image" target=_blank>非智能手机</A> 
						</DIV>
		                <SPAN class=clear></SPAN>
					  </LI>
		              <LI><B>音频配件</B>
		                <DIV><A title=蓝牙耳机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=6&style=image" target=_blank>蓝牙耳机</A> 
							 <A title=有线耳机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=7&style=image" target=_blank>有线耳机</A> 
							 <A title=耳机转接线 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=8&style=image" target=_blank>耳机转接线</A> 
							 <A title=手机音箱 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=9&style=image" target=_blank>手机音箱</A> 
						</DIV>
		                <SPAN class=clear></SPAN>
					  </LI>
		              <LI><B>充电配件</B>
		                <DIV><A title=标准电池 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=11&style=image" target=_blank>标准电池</A> 
							 <A title=商务电池 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=12&style=image" target=_blank>商务电池</A> 
							 <A title=充电器 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=13&style=image" target=_blank>充电器</A> 
							 <A title=移动电源 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=14&style=image" target=_blank>移动电源</A> 
						</DIV>
		                <SPAN class=clear></SPAN>
					  </LI>
		              <LI><B>数据配件</B>
		                <DIV><A title=存储卡 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=16&style=image" target=_blank>存储卡</A> 
							 <A title=读卡器 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=17&style=image" target=_blank>读卡器</A> 
							 <A title=数据线 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=18&style=image" target=_blank>数据线</A> 
						</DIV>
		                <SPAN class=clear></SPAN>
					  </LI>
		              <LI><B>手机饰品</B>
		                <DIV><A title=手机保护膜 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=20&style=image" target=_blank>手机保护膜</A> 
							 <A title=手机挂件 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=21&style=image" target=_blank>手机挂件</A> 
							 <A title=手机套 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=22&style=image" target=_blank>手机套</A> 
						</DIV>
		                <SPAN class=clear></SPAN>
					  </LI>
		            </UL>
		         </DD>
		        </DL>
		        <DL>
		          <DT class=icon02><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=23&style=image" target=_blank>数码影像</A></DT>
		            <DD class=menv02>
		             <UL class=sideleft>
		              <H3>数码影像</H3>
		              <LI><B>摄影摄像</B>
		                <DIV><A title=数码相机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=25&style=image" target=_blank>数码相机</A> 
							 <A title=单反相机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=26&style=image" target=_blank>单反相机</A> 
							 <A title=数码摄像机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=27&style=image" target=_blank>数码摄像机</A> 
						</DIV>
		                <SPAN class=clear></SPAN>
					  </LI>
		              <LI><B>单反配件</B>
		                <DIV><A title=长焦镜头 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=29&style=image" target=_blank>长焦镜头</A> 
							 <A title=广角镜头 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=30&style=image" target=_blank>广角镜头</A>
							 <A title=微距镜头 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=31&style=image" target=_blank>微距镜头</A> 
							 <A title=三脚架 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=32&style=image" target=_blank>三脚架</A> 
							 <A title=镜头布 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=33&style=image" target=_blank>镜头布</A> 
							 <A title=单反其他配件 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=34&style=image" target=_blank>单反其他配件</A> 
						</DIV>
		                <SPAN class=clear></SPAN>
					  </LI>
		            </UL>
		          </DD>
		        </DL>
				
		        <DL>
		          <DT class=icon03><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=35&style=image" target=_blank>笔记本、台式机</A></DT>
		           <DD class=menv03>
		            <UL class=sideleft>
		              <H3>笔记本、台式机</H3>
		              <LI><B>便携式电脑</B>
		                <DIV><A title=笔记本电脑 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=37&style=image" target=_blank>笔记本电脑</A> 
							 <A title=平板电脑 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=38&style=image" target=_blank>平板电脑</A> </DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI><B>台式电脑</B>
		                <DIV><A title=台式电脑 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=40&style=image" target=_blank>台式电脑</A> 
							 <A title=主机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=41&style=image" target=_blank>主机</A> 
							 <A title=显示器 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=42&style=image" target=_blank>显示器</A> </DIV>
		                <SPAN class=clear></SPAN></LI>
		            </UL>
		          </DD>
		        </DL>
				
		        <DL>
		          <DT class=icon04><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=43&style=image" target=_blank>书籍、学习资料</A></DT>
		           <DD class=menv04>
		            <UL class=sideleft>
		              <H3>书籍、学习资料</H3>
		              <LI><B>教材</B>
		                <DIV><A title=本科教材 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=45&style=image" target=_blank>本科教材</A> 
							 <A title=专科教材 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=46&style=image" target=_blank>专科教材</A> </DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI><B>辅助资料书</B>
		                <DIV><A title=同步练习 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=48&style=image" target=_blank>同步练习</A> 
							 <A title=阶段测试 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=49&style=image" target=_blank>阶段测试</A>
							 <A title=复习类 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=50&style=image" target=_blank>复习类</A> </DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI><B>文学书籍</B>
		                <DIV><A title=小说 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=52&style=image" target=_blank>小说</A> 
							 <A title=其他类 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=53&style=image" target=_blank>其他类</A>
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		            </UL>
		          </DD>
		        </DL>
				
		        <DL>
		          <DT class=icon05><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=54&style=image" target=_blank>随身影音</A></DT>
		          <DD class=menv05>
		            <UL class=sideleft>
		              <H3>随身影音</H3>
		              <LI><B>影音娱乐</B>
		                <DIV><A title=MP3 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=56&style=image" target=_blank>MP3</A> 
							 <A title=MP4 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=57&style=image" target=_blank>MP4</A> 
							 <A title=MP5 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=58&style=image" target=_blank>MP5</A> 
							 <A title=复读机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=59&style=image" target=_blank>复读机</A> 
							 <A title=录音笔 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=60&style=image" target=_blank>录音笔</A> 
							 <A title=收录机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=61&style=image" target=_blank>收录机</A>
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI><B>耳机/耳麦</B>
		                <DIV><A title=耳机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=63&style=image" target=_blank>耳机</A> 
							 <A title=耳麦 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=64&style=image" target=_blank>耳麦</A> </DIV>
		                <SPAN class=clear></SPAN></LI>       
		            </UL>
		          </DD>
		        </DL>
				
		        <DL>
		          <DT class=icon06><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=65&style=image" target=_blank>电脑配件</A></DT>
		          <DD class=menv06>
		            <UL class=sideleft>
		              <H3>电脑配件</H3>         
		    		  <LI><B>电脑内部配件</B>
		                <DIV><A title=内存条 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=67&style=image" target=_blank>内存条</A> 
							 <A title=网卡 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=68&style=image" target=_blank>网卡</A> 
							 <A title=声卡 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=69&style=image" target=_blank>声卡</A> 
							 <A title=显卡 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=70&style=image" target=_blank>显卡</A> 
							 <A title=CPU href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=71&style=image" target=_blank>CPU</A> 
							 <A title=主板 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=72&style=image" target=_blank>主板</A> 
							 <A title=硬盘 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=73&style=image" target=_blank>硬盘</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI class=noline><B>电脑外设配件</B>
		                <DIV><A title=鼠标 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=75&style=image" target=_blank>鼠标</A> 
							 <A title=键盘 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=76&style=image" target=_blank>键盘</A> 
							 <A title=电源 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=77&style=image" target=_blank>电源</A> 
							 <A title=移动硬盘 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=78&style=image" target=_blank>移动硬盘</A> 
							 <A title=U盘 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=79&style=image" target=_blank>U盘</A> 
							 <A title=电脑音箱 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=80&style=image" target=_blank>电脑音箱</A> 
							 <A title=电脑包 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=81&style=image" target=_blank>电脑包</A> 
							 <A title=摄像头 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=82&style=image" target=_blank>摄像头</A> 
							 <A title=散热风扇 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=83&style=image" target=_blank>散热风扇</A> 
							 <A title=鼠标垫 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=84&style=image" target=_blank>鼠标垫</A> 
							 <A title=电脑清洁工具 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=85&style=image" target=_blank>电脑清洁工具</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		            </UL>
		          </DD>
		        </DL>
				
			<DL>
		          <DT class=icon07><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=86&style=image" target=_blank>办公设备</A></DT>
		          <DD class=menv07>
		            <UL class=sideleft>
		              <H3>办公设备</H3>
		              
		              <LI><B>常用办公设备</B>
		                <DIV><A title=打印机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=88&style=image" target=_blank>打印机</A> 
							 <A title=扫描仪 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=89&style=image" target=_blank>扫描仪</A> 
							 <A title=投影仪 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=90&style=image" target=_blank>投影仪</A> 
							 <A title=复印机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=91&style=image" target=_blank>复印机</A> 
							 <A title=传真机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=92&style=image" target=_blank>传真机</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI><B>网络设备</B>
		                <DIV><A title=无线路由 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=93&style=image" target=_blank>无线路由</A> 
							 <A title=有线路由 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=94&style=image" target=_blank>有线路由</A> 
							 <A title=交换机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=95&style=image" target=_blank>交换机</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		            </UL>
		          </DD>
		        </DL>
				
		        <DL>
		          <DT class=icon08><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=97&style=image" target=_blank>厨房电器</A></DT>
		          <DD class=menv08>
		            <UL class=sideleft>
		              <H3>厨房电器</H3>
		              <LI><B>厨房小电器</B>
		                <DIV>
							 <A title=电磁炉 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=99&style=image" target=_blank>电磁炉</A> 
							 <A title=电饭煲 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=100&style=image" target=_blank>电饭煲</A> 
							 <A title=微波炉 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=101&style=image" target=_blank>微波炉</A> 
							 <A title=电水煲/电水壶 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=102&style=image" target=_blank>电水煲/电水壶</A> 
		                	 <A title=豆浆机 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=103&style=image" target=_blank>豆浆机</A>
							 <A title=其他 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=104&style=image" target=_blank>其他</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>                      
		              <LI><B>厨房用具</B>
		                <DIV><A title=餐具 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=106&style=image" target=_blank>餐具</A>
							 <A title=锅具 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=107&style=image" target=_blank>锅具</A> 
							 <A title=杯 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=108&style=image" target=_blank>杯</A> 
							 <A title=其他 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=109&style=image" target=_blank>其他</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>                      
		            </UL>         
		          </DD>
		        </DL>
		        
		        <DL>
		          <DT class=icon09><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=110&style=image" target=_blank>日常生活用品</A></DT>
		          <DD class=menv09>
		            <UL class=sideleft>
		              <H3>日常生活用品</H3>
		              <LI><B>生活用品</B>
		                <DIV>
							 <A title=凉席 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=112&style=image" target=_blank>凉席</A> 
							 <A title=蚊帐 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=113&style=image" target=_blank>蚊帐</A> 
							 <A title=盆子 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=114&style=image" target=_blank>盆子</A> 
							 <A title=水瓶 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=115&style=image" target=_blank>水瓶</A> 
							 <A title=雨具 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=116&style=image" target=_blank>雨具</A> 
							 <A title=桌/椅 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=117&style=image" target=_blank>桌/椅</A> 
							 <A title=其他 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=118&style=image" target=_blank>其他</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI><B>日用电器</B>
		                <DIV><A title=电风扇 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=120&style=image" target=_blank>电风扇</A>
		                	 <A title=台灯 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=121&style=image" target=_blank>台灯</A> 
		                	 <A title=电吹风 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=122&style=image" target=_blank>电吹风</A>
		                	 <A title=剃须刀 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=123&style=image" target=_blank>剃须刀</A> 
		                	 <A title=美容美发器 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=124&style=image" target=_blank>美容美发器</A> 
		                	 <A title=电热毯 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=125&style=image" target=_blank>电热毯</A> 
							 <A title=电热袋 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=126&style=image" target=_blank>电热袋</A> 
							 <A title=其他 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=127&style=image" target=_blank>其他</A> 
		                </DIV>
		                <SPAN class=clear></SPAN></LI>
		            </UL>            
		          </DD>
		        </DL>
				
		        <DL>
		          <DT class=icon10><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=128&style=image" target=_blank>服装鞋帽、箱包</A></DT>
		          <DD class=menv10>
		            <UL class=sideleft>
		              <H3>服装鞋帽、箱包</H3>
		              <LI><B>服装配饰</B>
		                <DIV><A title=帽子 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=130&style=image" target=_blank>帽子</A>
							 <A title=眼镜 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=131&style=image" target=_blank>眼镜</A> 
		                	 <A title=皮带 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=132&style=image" target=_blank>皮带</A> 
		                	 <A title=围巾 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=133&style=image" target=_blank>围巾</A> 
							 <A title=发饰 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=134&style=image" target=_blank>发饰</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI><B>服装</B>
		                <DIV><A title=衬衫 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=136&style=image" target=_blank>衬衫</A> 
							 <A title=T恤 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=137&style=image" target=_blank>T恤</A> 
							 <A title=裙装 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=138&style=image" target=_blank>裙装</A> 
							 <A title=外套 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=139&style=image" target=_blank>外套</A> 
							 <A title=运动装 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=140&style=image" target=_blank>运动装</A> 
							 <A title=休闲裤 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=141&style=image" target=_blank>休闲裤</A> 
							 <A title=牛仔裤 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=142&style=image" target=_blank>牛仔裤</A> 
							 <A title=鞋 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=143&style=image" target=_blank>鞋</A> 
							 <A title=其他 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=144&style=image" target=_blank>其他</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		              <LI><B>箱包、首饰</B>
		                <DIV><A title=旅行箱 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=146&style=image" target=_blank>旅行箱</A> 
							 <A title=运动休闲包 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=147&style=image" target=_blank>运动休闲包</A>  
							 <A title=手表 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=148&style=image" target=_blank>手表</A> 
							 <A title=闹钟 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=149&style=image" target=_blank>闹钟</A> 
							 <A title=耳环/耳钉/耳坠 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=150&style=image" target=_blank>耳环/耳钉/耳坠</A> 
							 <A title=手链/手镯 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=151&style=image" target=_blank>手链/手镯</A> 
							 <A title=项链/吊坠 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=152&style=image" target=_blank>项链/吊坠</A> 
							 <A title=戒指 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=153&style=image" target=_blank>戒指</A> 
							 <A title=其他 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=154&style=image" target=_blank>其他</A>
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		             </UL>          
		          </DD>
		        </DL>
		        
				<DL>
		          <DT class=icon11><A href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dolistAll&id=155&style=image" target=_blank>户外用品</A></DT>
		          <DD class=menv11>
		            <UL class=sideleft>
		              <H3>户外用品</H3>
		              <LI><B>体育用品</B>
		                <DIV><A title=乒乓球用品 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=157&style=image" target=_blank>乒乓球用品</A> 
							 <A title=羽毛球用品 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=158&style=image" target=_blank>羽毛球用品</A> 
							 <A title=篮球用品 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=159&style=image" target=_blank>篮球用品</A> 
							 <A title=足球用品 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=160&style=image" target=_blank>足球用品</A> 
							 <A title=网球用品 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=161&style=image" target=_blank>网球用品</A> 
							 <A title=排球用品 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=162&style=image" target=_blank>排球用品</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>          
		              <LI><B>休闲健身</B>
		                <DIV>
		                	 <A title=电动车 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=164&style=image" target=_blank>电动车</A> 
							 <A title=自行车 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=165&style=image" target=_blank>自行车</A> 
							 <A title=运动器材 href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=dotypelist&id=166&style=image" target=_blank>运动器材</A> 
						</DIV>
		                <SPAN class=clear></SPAN></LI>
		            </UL>         
		          </DD>
		        </DL>
		      </DIV>
		    </DIV>
	  	 </div>
	  	 <div id="b-n-right">
		  	 <div id="b-n-advertise">
		  	 	<div class="bs-example">
			      <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			        <ol class="carousel-indicators">
			          <li data-target="#carousel-example-generic" data-slide-to="0"></li>
			          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
			          <li data-target="#carousel-example-generic" data-slide-to="2" class="active"></li>
			          <li data-target="#carousel-example-generic" data-slide-to="3"></li>
			          <li data-target="#carousel-example-generic" data-slide-to="4"></li>
			        </ol>
			        <div class="carousel-inner">
			          <div class="item">
			          <img src="${pageContext.request.contextPath }/images/lunbo1.png" alt="680x230">
			          </div>
			          <div class="item">
			          <img src="${pageContext.request.contextPath }/images/lunbo2.png" alt="680x230">
			          </div>
			          <div class="item active">
			          <img src="${pageContext.request.contextPath }/images/lunbo3.png" alt="680x230">
			          </div>
			          <div class="item">
			          <img src="${pageContext.request.contextPath }/images/lunbo2.png" alt="680x230">
			          </div>
			          <div class="item">
			          <img src="${pageContext.request.contextPath }/images/lunbo1.png" alt="680x230">
			          </div>
			        </div>
			        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
				      <span class="glyphicon glyphicon-chevron-left"></span>
				    </a>
			        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
			          <span class="glyphicon glyphicon-chevron-right"></span>
			        </a>
			      </div>
			    </div>
		  	 </div>
		  	 <div class="body-neck b-n-rt">
		  	 	<div style="width:280px;height:160px;border:1px solid #F1F1F1;border-bottom: 1px solid #eee;border-radius: 4px;border-radius: 4px;float:left">
		  	 		<div style="width: 280px;margin-bottom: 10px;float: right;overflow: hidden;zoom: 1;">
						<div style="height: 25px;line-height: 16px;padding: 7px 0;border-bottom: 2px solid #AAA;">
							<strong style="color:#8D8181; font-size: 14px;">商品快报</strong>
							<div style="float: right;">
							<a style="color: #005EA7;"href="${pageContext.request.contextPath }/servlet/NewsManager?actiontype=showAllNews" target="_blank">更多快报&nbsp;&gt;</a>
							</div>
						</div>
						<div style="width: 280px;height: 135px;padding: 4px 0;border-style: solid;border-color: #F1F1F1;border-width: 0 1px 1px;overflow: hidden;zoom: 1;">
							<ul style="width: 280px;height: 135px;overflow: hidden;">
							  <c:forEach var="new" items="${news}">
								<li style="float: left;width: 208px;height: 25px;padding: 0 10px;line-height: 25px;overflow: hidden;">
									<a href="${pageContext.request.contextPath }/servlet/NewsManager?actiontype=showNews&id=${new.id}" target="_blank" title="${new.title }">
										<c:out value="${fn:substring(new.title,0,14)}"></c:out>
				        				<c:if test="${fn:length(new.title)>14}">···</c:if>
									</a>
								</li>
								<li style="float: right;width: 72px;height: 25px;line-height: 25px;overflow: hidden;">
									<em>${new.createtime }</em>
								</li>
							   </c:forEach>
							</ul>
						</div>
					</div>
		  	 	</div>
		  	 	<div style="width:280px;height:235px;border:1px solid green;border-bottom: 1px solid #eee;border-radius: 4px;border-radius: 4px;float:left">
		  	 	
		  	 	
		  	 	
		  	 	这是经典商品置顶
		  	 	
		  	 	</div>
		  	 </div>
		  	 <div id="b-n-botton">
		  	 	<!-- recommend_commodities start  -->
				<div class="recommend_commodities"> 
				  <a class="LeftBotton" onmousedown="ISL_GoUp_1()" onmouseup="ISL_StopUp_1()" onmouseout="ISL_StopUp_1()" href="javascript:void(0);" target="_self"></a>
				  <div class="pcont" id="ISL_Cont_1">
					<div class="ScrCont">
					  <div id="List1_1">
						<!-- piclist begin -->
						<c:forEach var="pr" items="${productRecomend}">
							<a class="pl" href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${pr.id}"title="${pr.name }"target=_blank >
								<img src="${pr.uploadImage }" alt="${pr.name }"width="150" height="150"/>
							</a> 
						</c:forEach>
						<!-- piclist end -->
					  </div>
					  <div id="List2_1"></div>
					</div>
				  </div>
				  <a class="RightBotton" onmousedown="ISL_GoDown_1()" onmouseup="ISL_StopDown_1()" onmouseout="ISL_StopDown_1()" href="javascript:void(0);" target="_self"></a> 
				</div>
				<div class="c"></div>
				<script type="text/javascript">		
					picrun_ini()			
				</script>
				<!-- recommend_commodities end -->
		  	 </div>
	  	 </div>
	  </div>
<!--
	  <div id="body-interesting">
	  	 <div id="b-i-left">
	  	 	<div class="b-i-head ">
	  	 		<ul class="b-i-type">
                	<li class="nav">最近浏览的宝贝</li>
            	</ul>
	  	 	</div>
	  	 	<div class="b-i-matter">
	  	 		<div class="reload"><b></b>清除</div>
	  	 		<ul>
	  	 			<li>
		  	 			<div style="width:210px;height:155px;border:1px solid green;border-bottom: 1px solid #eee;border-radius: 4px;float:left">这是经典商品置顶</div>
		  	 			<p></p>
	  	 			</li>
	  	 			<li>
		  	 			<div style="width:220px;height:155px;border:1px solid green;border-bottom: 1px solid #eee;border-radius: 4px;float:left">这是经典商品置顶</div>
		  	 			<p></p>
	  	 			</li>
	  	 			<li>
		  	 			<div style="width:220px;height:155px;border:1px solid green;border-bottom: 1px solid #eee;border-radius: 4px;float:left">这是经典商品置顶</div>
		  	 			<p></p>
	  	 			</li>
	  	 			<li>
		  	 			<div style="width:220px;height:155px;border:1px solid green;border-bottom: 1px solid #eee;border-radius: 4px;float:left">这是经典商品置顶</div>
		  	 			<p></p>
	  	 			</li>
	  	 			<li>
		  	 			<div style="width:220px;height:155px;border:1px solid green;border-bottom: 1px solid #eee;border-radius: 4px;float:left">这是经典商品置顶</div>
		  	 			<p></p>
	  	 			</li>
		  	 	</ul>
	  	 	</div>
	  	 </div>
	  </div>
-->
	  <div id="body-middle">
	  	     <div class="row">
		  	 <c:forEach var="products" items="${products}">
			    <div class="thumbnail">
			      <a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ products.id}"target=_blank>
				     <img style="height: 200px" class="img-responsive img-rounded" data-src="holder.js/100%x180" src="${products.uploadImage }" alt="${products.name }">
				   </a>
			      <div class="caption">
			      	<div style="width:220px;height: 20px;">
					    <div style="float:left;">
							<span>
								<b style="font-size: 14;color: gray;">¥</b>
								<em style="font-size: 14;color: #ff7100;"><strong>${products.price }</strong></em>
							</span>
						</div>
	                </div>
			      </div>
			      <div style="width: 210px;height: 26px;">
			        <p style="text-align:center;font-size: 14px;">
			        	<a href="${pageContext.request.contextPath }/servlet/PageAction?actiontype=showProduct&id=${ products.id}" target=_blank>
			        		<c:out value="${fn:substring(products.name,0,13)}"></c:out>
			        		<c:if test="${fn:length(products.name)>13}">···</c:if>
			        	</a>
			        </p>
			      </div>
			    </div>
		 	</c:forEach>
			</div>
	  </div>
	<!--  body-neck  end -->
	<hr>
    <jsp:include page="foot.jsp"></jsp:include> 
  </body>
</html>
