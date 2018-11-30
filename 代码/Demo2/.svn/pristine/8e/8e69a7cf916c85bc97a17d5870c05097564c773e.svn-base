function typePage(code){
	location.href=ctx+'/purchase/index.do?type='+code;
}
function typePage1(code){
	location.href=ctx+'/purchase/index.do?jumpPage=1&type='+code;
}

function moreProduct(type){
		if(type==1){
			var code=$('#newprod_type .active a').attr('code');
			location.href=ctx+'/purchase/index.do?type='+code;
		}else{
			var code=$('#groupProd_type .active a').attr('code');
			location.href=ctx+'/group/index.do?type='+code;
		}
}
function moreCasesharing(){
	var code=$('#CaseSharingType .active a').attr('dataid');
	if(typeof(code)  == "undefined")
	{
		code = "";
	}
	location.href=ctx+'/indexCaseSharing.do?caseType='+code;
}
function moreCompany(type){
		if(type==1){
			var code=$('#comp_type_1 .active a').attr('dataid');
			if(typeof(code)  == "undefined")
			{
				code = "";
			}
			location.href=ctx+'/searchCompany.do?type='+code;
		}else{
			var code=$('#comp_type_2 .active a').attr('dataid');
			if(typeof(code)  == "undefined")
			{
				code = "";
			}
			location.href=ctx+'/searchCompany.do?type='+code;
		}
}
function caseSharingAll(){
	var id=$('#CaseSharingType .active a').attr('dataId');
	if(id==null){
		location.href=ctx+'/selectCaseSharingList.do?id=0';
	}else{
		location.href=ctx+'/selectCaseSharingList.do?id='+id;
	}
	
}


function advertising(id,staticDiv){
	$.ajax({
		url:'selectAdvertising.do?id='+id,
		dataType:'json',
		type:'post',
		async:true,
		success:function(data){
			if(data.length!=0){
				staticDiv.html('<a href="javascript:checkUserPerm(\''+data[0].recommendUrl+'\',[],'+perm+',true)"><img src="'+data[0].pic+'" /></a>'+
			            '<a href="javascript:checkUserPerm(\''+data[1].recommendUrl+'\',[],'+perm+',true)"><img src="'+data[1].pic+'" /></a>'+
			            '<div class="clear-no-height"></div>'+
			            '<a href="javascript:checkUserPerm(\''+data[2].recommendUrl+'\',[],'+perm+',true)"><img src="'+data[2].pic+'" /></a>'+
			            '<a href="javascript:checkUserPerm(\''+data[3].recommendUrl+'\',[],'+perm+',true)"><img src="'+data[3].pic+'" /></a>'+
			            '<div class="clear-no-height"></div>'+
			            '<a href="javascript:checkUserPerm(\''+data[4].recommendUrl+'\',[],'+perm+',true)"><img src="'+data[4].pic+'" /></a>'+
			            '<a href="javascript:checkUserPerm(\''+data[5].recommendUrl+'\',[],'+perm+',true)"><img src="'+data[5].pic+'" /></a>'+
			            '<div class="clear-no-height"></div>'+
			            '<a href="javascript:checkUserPerm(\''+data[6].recommendUrl+'\',[],'+perm+',true)"><img src="'+data[6].pic+'" /></a>'+
			            '<a href="javascript:checkUserPerm(\''+data[7].recommendUrl+'\',[],'+perm+',true)"><img src="'+data[7].pic+'" /></a>'+
			            '<div class="clear-no-height"></div>'+
			            '<div class="pro-hot">'+
			            '    <a href="javascript:checkUserPerm(\''+data[8].recommendUrl+'\',[],'+perm+',true)" style="height:155px;">'+
			            '        <p class="blue">推荐产品</p>'+
			            '        '+
			            '        <img src="'+data[8].pic+'" style="height: 110px;margin-right: 25px;margin-top: 5px;width: 110px;" />'+
			            '    </a>'+
			            ' </div>'+
			           	'<div class="pro-hot">'+
			           	'    <a href="javascript:checkUserPerm(\''+data[9].recommendUrl+'\',[],'+perm+',true)" style="height:155px;">'+
			            '        <p class="blue">推荐产品</p>'+
			            '        '+
			            '        <img src="'+data[9].pic+'" style="height: 110px;margin-right: 25px;margin-top: 5px;width: 110px;" />'+
			            '    </a>'+
			            '</div>');
			}else{
				staticDiv.html('<a href="#"><img src="common/jhShop/image-pro/shop1.png" /></a>'+
			            '<a href="#"><img src="common/jhShop/image-pro/shop2.png" /></a>'+
			            '<div class="clear-no-height"></div>'+
			            '<a href="#"><img src="common/jhShop/image-pro/shop4.png" /></a>'+
			            '<a href="#"><img src="common/jhShop/image-pro/shop3.png" /></a>'+
			            '<div class="clear-no-height"></div>'+
			            '<a href="#"><img src="common/jhShop/image-pro/shop6.png" /></a>'+
			            '<a href="#"><img src="common/jhShop/image-pro/shop1.png" /></a>'+
			            '<div class="clear-no-height"></div>'+
			            '<a href="#"><img src="common/jhShop/image-pro/shop2.png" /></a>'+
			            '<a href="#"><img src="common/jhShop/image-pro/shop4.png" /></a>'+
			            '<div class="clear-no-height"></div>'+
			            '<div class="pro-hot">'+
			            '    <a href="#">'+
			            '        <p class="blue">简约办公桌椅</p>'+
			            '        <p class="grey">森林木家具</p>'+
			            '        <img src="common/jhShop/image-pro/pro1.png" style="width:80px;" />'+
			            '    </a>'+
			            ' </div>'+
			           	'<div class="pro-hot">'+
			           	'    <a href="#">'+
			            '        <p class="blue">简约办公桌椅</p>'+
			            '        <p class="grey">森林木家具</p>'+
			            '        <img src="common/jhShop/image-pro/pro2.png" style="width:45px; margin-top:-15px; margin-right:32px;" />'+
			            '    </a>'+
			            '</div>');
			}
			
		}
	});
}
function init1F(){
				floorToggle(1);
}
function init3F(){
			floorToggle(3);
}
function init4F(){
	$.ajax({
		url : 'selectTypeValue.do',
		dataType : 'json',
		type : 'post',
		async:true,
		success : function(data) {
			$(data).each(function(index, row) {
				var li = $('<li></li>');
				var a = $('<a href="javascript:void(1);" dataId="'+row.id+'">' + row.dictdataValue + '</a>');
				li.append(a);
				$('#comp_type_2').append(li);
			});
			//init4FData();
//			floorToggle(5);
		}
	});
}

function init5F(){
	$.ajax({
		url : 'selectCaseSharingType.do',
		dataType : 'json',
		type : 'post',
		async:true,
		success : function(data) {
			$(data).each(function(index, row) {
				var li = $('<li id=cst_'+row.id+' ></li>');
				var a = $('<a href="javascript:void(1);"  onclick="CaseSharingId('+row.id+');" dataId="'+row.id+'">' + row.dictdataValue + '</a>');
				li.append(a);
				$('#CaseSharingType').append(li);
			});
			init5FDefaultData();
		}
	});
}


function jumpIntroPage(productId,loginFlag){
	var text=$.ajax({
		url:ctx+'/login/checkUser.do',
		type:'post',
		async:false,
	}).responseText;

	checkUser.execCallBack=function(){
		callback.apply(window,fnParam);
	}
	if(text==''){
		checkUser.index=layer.open({
    	    type: 2,
    	    title:'登录',
    	    fix: false, //不固定
    	    area: ['500px', '450px'],
    	    content:$.basePath+'/content/jhShop/insideLogin.jsp'
		});
	}else{
		var json = JSON.parse(text);
		companystate = json.company.state;
		if(loginFlag == 2){
			window.location.href =ctx+"/product/page.do?productId="+productId;
		}else if(companystate != 16){
			window.location.href = ctx+'/jhCompanyBase/RZauthentication.do';
		}
	}
};
function init3FData(){
	var newsList = $('#floor4Tab ul li');
	newsList.each(function(i) {
		var ahover = function() {
			$(this).parent('li').attr('class', 'active').siblings('li').attr(
					'class', 'default');
			var id=$(this).attr('dataId')||'all',divInfo=$('#4F').find('#'+id);
			if(!divInfo.length){
				var div=$('<div></div');
				div.attr("id",id);
				var ul=$('<ul></ul>');
				$(getCompanyF4($(this).attr('dataId'))).each(function(index,row){
					var li=$('<li style="height:150px"></li>');
					var	a=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/introPage.do?company='+row.companyId+'\',[],'+perm+',true)" class="pro-img"></a>');
					p=$('<p class="shop-name">'+cutstr(row.companyName,26)+'</p>');
					img=$(' <img src="'+row.companyLogo+'"/>');
					img.css({width:185,height:94});
					a.append(p).append(img);
					li.append(a);
					ul.append(li);
						ul.append('<li class="line"  style="height:150px"></li>');
				});
				div.append(ul);
				$('#4F').append(div);
				div.siblings('div').hide();
			}else{
				divInfo.show();
				divInfo.siblings('div').hide();
			}
		}
		$(this).find('a').hover(ahover, function() {});
		if(i==0){
			ahover();
		}		
	});
}

function init5FDefaultData(){
	$.ajax({
		url : 'selectCaseSharing.do?id=0',
		dataType : 'json',
		type : 'post',
		async:true,
		success : function(data) {
			if(data != "" && data != null && data.length>0){
				var li=$('<div class="floor-tab-cont" id="3F">' +
						' <div  class="floor3TabList">' +
						'<div class="case-show-list"><div class="case-show-row1">' +
						' <div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[0].url+'\',[],true,true)"><img src="'+data[0].showImage+'"></a>' +
						' <div class="cover"></div></div><div class="descbox">' +
						'<div class="left-desc"><h2 class="type-name">'+cutstr(data[0].title,20)+'</h2>' +
						'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[0].url+'\',[],true,true)">'+cutstr(data[0].content,40)+'</a>' +
						' <p class="case-infor">' +
						' 作者：'+data[0].companyName+' &nbsp;&nbsp;积分：'+data[0].integral+' &nbsp;&nbsp;</p> </div>' +
						'<div class="left-arrow"></div><div class="right-desc">' +
						'<h2 class="type-name">'+cutstr(data[1].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[1].url+'\',[],true,true)">'+cutstr(data[1].content,40)+'</a>' +
						'<p class="case-infor">'+
						'作者：'+data[1].companyName+' &nbsp;&nbsp; 积分：'+data[1].integral+' &nbsp;&nbsp;</p></div>'+
						' <div class="right-arrow"></div></div>'+
						'<div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[1].url+'\',[],true,true)"><img src="'+data[1].showImage+'"></a>'+
						'<div class="cover"></div></div><div class="imgbox row-end">'+
						'<a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[2].url+'\',[],true,true)"><img src="'+data[2].showImage+'"></a>'+
						'<div class="left-desc"><h2 class="type-name">'+cutstr(data[2].title,20)+'</h2>'+
						'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[2].url+'\',[],true,true)">'+cutstr(data[2].content,40)+'</a><p class="case-infor">'+
						'作者：'+data[2].companyName+' &nbsp;&nbsp; 积分：'+data[2].integral+' &nbsp;&nbsp;</p></div>'+
						'<div class="cover"></div></div></div>'+
						'<div class="case-show-row2"><div class="imgbox row-begin">'+
						'<a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[3].url+'\',[],true,true)"><img src="'+data[3].showImage+'"></a>'+
						'<div class="left-desc"><h2 class="type-name">'+cutstr(data[3].title,20)+'</h2>'+
						'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[3].url+'\',[],true,true)">'+cutstr(data[3].content,40)+'</a><p class="case-infor">'+
						'作者：'+data[3].companyName+' &nbsp;&nbsp;积分：'+data[3].integral+'&nbsp;&nbsp; </p></div>'+
						'<div class="cover"></div></div>'+
						'<div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[4].url+'\',[],true,true)"><img src="'+data[4].showImage+'"></a>'+
						' <div class="cover"></div></div><div class="descbox"><div class="left-desc">'+
						'<h2 class="type-name">'+cutstr(data[4].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[4].url+'\',[],true,true)">'+cutstr(data[4].content,40)+'</a>'+
						'<p class="case-infor"> 作者：'+data[4].companyName+'  &nbsp;&nbsp;积分：'+data[4].integral+' &nbsp;&nbsp;</p></div>'+
						'<div class="left-arrow"></div><div class="right-desc">'+
						'<h2 class="type-name">'+cutstr(data[5].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[5].url+'\',[],true,true)">'+cutstr(data[5].content,40)+'</a>'+
						'<p class="case-infor">作者：'+data[5].companyName+' &nbsp;&nbsp;积分：'+data[5].integral+' &nbsp;&nbsp;</p></div>'+
						'<div class="right-arrow"></div></div>'+
						'<div class="imgbox imgbox-end"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[5].url+'\',[],true,true)"><img src="'+data[5].showImage+'"></a>'+
						'<div class="cover"></div></div></div></div>'+
						'<div class="case-show-list"><div class="case-show-row1">' +
						' <div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[6].url+'\',[],true,true)"><img src="'+data[6].showImage+'"></a>' +
						' <div class="cover"></div></div><div class="descbox">' +
						'<div class="left-desc"><h2 class="type-name">'+cutstr(data[6].title,20)+'</h2>' +
						'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[6].url+'\',[],true,true)">'+cutstr(data[6].content,40)+'</a>' +
						' <p class="case-infor">' +
						' 作者：'+data[6].companyName+' &nbsp;&nbsp;积分：'+data[6].integral+' &nbsp;&nbsp;</p> </div>' +
						'<div class="left-arrow"></div><div class="right-desc">' +
						'<h2 class="type-name">'+cutstr(data[7].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[7].url+'\',[],true,true)">'+cutstr(data[7].content,40)+'</a>' +
						'<p class="case-infor">'+
						'作者：'+data[7].companyName+' &nbsp;&nbsp; 积分：'+data[7].integral+' &nbsp;&nbsp;</p></div>'+
						' <div class="right-arrow"></div></div>'+
						'<div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[7].url+'\',[],true,true)"><img src="'+data[7].showImage+'"></a>'+
						'<div class="cover"></div></div><div class="imgbox row-end">'+
						'<a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[8].url+'\',[],true,true)"><img src="'+data[8].showImage+'"></a>'+
						'<div class="left-desc"><h2 class="type-name">'+cutstr(data[8].title,20)+'</h2>'+
						'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[8].url+'\',[],true,true)">'+cutstr(data[8].content,40)+'</a><p class="case-infor">'+
						'作者：'+data[8].companyName+' &nbsp;&nbsp; 积分：'+data[8].integral+' &nbsp;&nbsp;</p></div>'+
						'<div class="cover"></div></div></div>'+
						'<div class="case-show-row2"><div class="imgbox row-begin">'+
						'<a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[9].url+'\',[],true,true)"><img src="'+data[9].showImage+'"></a>'+
						'<div class="left-desc"><h2 class="type-name">'+cutstr(data[9].title,20)+'</h2>'+
						'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[9].url+'\',[],true,true)">'+cutstr(data[9].content,40)+'</a><p class="case-infor">'+
						'作者：'+data[9].companyName+' &nbsp;&nbsp;积分：'+data[9].integral+'&nbsp;&nbsp; </p></div>'+
						'<div class="cover"></div></div>'+
						'<div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[10].url+'\',[],true,true)"><img src="'+data[10].showImage+'"></a>'+
						' <div class="cover"></div></div><div class="descbox"><div class="left-desc">'+
						'<h2 class="type-name">'+cutstr(data[10].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[10].url+'\',[],true,true)">'+cutstr(data[10].content,40)+'</a>'+
						'<p class="case-infor"> 作者：'+data[10].companyName+'  &nbsp;&nbsp;积分：'+data[10].integral+' &nbsp;&nbsp;</p></div>'+
						'<div class="left-arrow"></div><div class="right-desc">'+
						'<h2 class="type-name">'+cutstr(data[11].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[11].url+'\',[],true,true)">'+cutstr(data[11].content,40)+'</a>'+
						'<p class="case-infor">作者：'+data[11].companyName+' &nbsp;&nbsp;积分：'+data[11].integral+' &nbsp;&nbsp;</p></div>'+
						'<div class="right-arrow"></div></div>'+
						'<div class="imgbox imgbox-end"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[11].url+'\',[],true,true)"><img src="'+data[11].showImage+'"></a>'+
						'<div class="cover"></div></div></div></div></div></div></div>');
						
				$('#3FCaseSharingAll').append(li);
			}
		}
	});
}
function init4FData(){
	  
	var newsList = $('#floor5Tab ul li');
	newsList.each(function(i) {
		var ahover = function() {
			$(this).parent('li').attr('class', 'active').siblings('li').attr(
					'class', 'default');
			var id=$(this).attr('dataId')||'all',divInfo=$('#5F').find('#'+id);
			if(!divInfo.length){
				var div=$('<div></div');
				div.attr("id",id);
				var ul=$('<ul></ul>');
				$(getCompanyF5($(this).attr('dataId'))).each(function(index,row){
					var li=$('<li style="height:150px"></li>');
					var a=$("<a href='javascript:void(0);' onclick=\"checkUserPerm('"+ctx+"/product/introPage.do?company="+row.companyId+"',[],"+perm+",true)\" class='pro-img'></a>");
					p=$('<p class="shop-name">'+cutstr(row.companyName,26)+'</p>');
					img=$(' <img src="'+row.companyLogo+'"/>');
					img.css({width:185,height:94});
					a.append(p).append(img);
					li.append(a);
					ul.append(li);
						ul.append('<li class="line"  style="height:150px"></li>');
				});
				div.append(ul);
				$('#5F').append(div);
				div.siblings('div').hide();
			}else{
				divInfo.show();
				divInfo.siblings('div').hide();
			}
		}
		$(this).find('a').hover(ahover, function() {});
		if(i==0){
			ahover();
		}		
	});
}
function inithelpcomp(){
	$.ajax({
		url : 'selectPartners.do',
		dataType : 'json',
		type : 'post',
		async:true,
		success : function(data) {
			$(data).each(function(index, row) {
				var li = $('<li></li>');
				var a = $('<a  target="_blank" href="'+row.content+'"><img width="120px;" height="40px;"  src="'+row.pic+'" ></a>');
				li.append(a);
				$('#iepe-Partners').append(li);
			});
		}  
	});
}
var initDataBool={};
function initQuery(){
//	var top=$(window).scrollTop();
//	var screenHeight=$(window).height();
//	if(((top+screenHeight)>=$('#floor1').offset().top-20||screenHeight>=$('#floor1').offset().top-20)&&initDataBool['1f']==null){
//		initDataBool['1f']=true;
		init1F();
//	}
//	if(((top+screenHeight)>=$('#floor2').offset().top-10||screenHeight>=$('#floor2').offset().top-10)&&initDataBool['2f']==null){
//		if($('#groupProd_type').find('li').length>0){
//			initDataBool['2f']=true;
			floorToggle(2);
//		}
//	}
//	if(((top+screenHeight)>=$('#floor3').offset().top-10||screenHeight>=$('#floor3').offset().top-10)&&initDataBool['3f']==null){
//		initDataBool['3f']=true;
		init3F();
//	}
//	if(((top+screenHeight)>=$('#floor4').offset().top-10||screenHeight>=$('#floor4').offset().top-10)&&initDataBool['4f']==null){
//		initDataBool['4f']=true;
		//init4F();
//	}
//	if(((top+screenHeight)>=$('#floor5').offset().top-10||screenHeight>=$('#floor5').offset().top-10)&&initDataBool['5f']==null){
//		initDataBool['5f']=true;
		//init5F();
//	}
//	if(((top+screenHeight)>=$('#iepe-Partners').offset().top-10||screenHeight>=$('#iepe-Partners').offset().top-10)&&initDataBool['helpC']==null){
//		initDataBool['helpC']=true;
		inithelpcomp();
//	}
}
$(function(){
	initQuery();
//	$(window).scroll(function () {
//		initQuery();
//	});
//	
//	$(window).resize(function () {
//		initQuery();
//	});
	//用户 产品数量
	/*$.ajax({
		url : 'selectCount.do',
		dataType : 'json',
		type : 'post',
		async:true,
		success : function(data) {
			$(data).each(function(index, row) {
				var li = $('<li ></li>');
				var a = $('<p class="num" style="background: white;">'+392+'<img src="'+ctx+'/common/images/arrow-up.png"/></p><p style="background: white;">买家数量</p>');
				var li1= $('<li></li>');
				var a1 = $('<p class="num" style="background: white;">'+1785+'<img src="'+ctx+'/common/images/arrow-up.png"/></p><p style="background: white;">商品数量</p>');
				li.append(a);
				li1.append(a1);
				$('#selectCount').append(li);
				$('#selectCount').append(li1);
			});
		}
	});*/
	
    // 下拉框初始化
	$('#searchType').select();

    // 导航
    $('.menu-item').hover(function(){
        var self = $(this);
        if(self.find('.menu-icon').attr('pic')){
        	self.find('.menu-icon').css("background",'rgba(0, 0, 0, 0) url("'+self.find('.menu-icon').attr('hover')+'") no-repeat scroll 0 0');
        }
        if(self.find('.inner-wrap').length > 0){
        	 var typeId=self.attr('data-typeID');
             var code=self.attr('data-typeCode');
             if(self.find('.inner-wrap ul').length==0){
            	 var innerUl=$('<ul>');
            	 var staticDiv=$('<div class="right-shop"></div>');
            	 codelistAll(code,innerUl,typeId);
//            	 advertising(typeId,staticDiv);
            	 self.find('.inner-wrap').append(innerUl);
            	 self.find('.inner-wrap').append(staticDiv);
            	 self.find('.inner-wrap').bind('click',function(event){
            		 event.stopPropagation(); 
            	 });
             }
            self.find('.inner-wrap').css('display', 'block');
            self.find('.mask').css('display', 'block');
            self.find('.right-mark').css('display', 'none');
        }else{
           /* self.css('border-right','1px solid #f6f6f6');*/
        }
    }, function(){
        var self = $(this);
        if(self.find('.menu-icon').attr('pic')){
        	self.find('.menu-icon').css("background",'rgba(0, 0, 0, 0) url("'+self.find('.menu-icon').attr('pic')+'") no-repeat scroll 0 0');
        }
        if(self.find('.inner-wrap').length > 0){
            self.find('.inner-wrap').css('display', 'none');
            self.find('.mask').css('display', 'none');
            self.find('.right-mark').css('display', 'block');
        }else{
            /*self.css('border-right','1px solid #184c81');*/
        }
    });
    // 更多 hover显示右边展开内容
    $('#moreType').hover(function(){
        var self = $(this);
        if(self.find('.inner-wrap').length > 0){
            self.find('.inner-wrap').css('display', 'block');
            self.find('.mask').css('display', 'block');
            //self.find('.right-mark').css('display', 'none');
        }else{
           /* self.css('border-right','1px solid #f6f6f6');*/
        }
    }, function(){
        var self = $(this);
        if(self.find('.inner-wrap').length > 0){
            self.find('.inner-wrap').css('display', 'none');
            self.find('.mask').css('display', 'none');
            //self.find('.right-mark').css('display', 'block');
        }else{
           /* self.css('border-right','1px solid #184c81');*/
        }
    });
    

    // menu hover显示下拉
    $('#indexMenu li').hover(function(){
        var self = $(this);
        if(self.find('ul').length > 0){
            self.addClass('active');
            self.find('ul').css('display', 'block');
        }
    },function(){
        var self = $(this);
        if(self.find('ul').length > 0){
            self.removeClass('active');
            self.find('ul').css('display', 'none');
        }
    });

    // 首页幻灯片
    index.initSlider(); 

    // 幻灯片右边tab
    var tabHeadList = $('#contditionTab ul li');
    tabHeadList.each(function(i){
       $(this).find('a').hover(function(){
            $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
            $('#contditionTab' + (i + 1)).css('display', 'block').siblings('div').css('display', 'none');
       },function(){});
    });

    /*var newsList = $('#newsTab ul li');
    newsList.each(function(i){
      $(this).find('a').hover(function(){
        $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
        $('#newsTab' + (i + 1)).css('display', 'block').siblings('div').css('display', 'none');
      },function(){});
    });*/

 //   floorToggle('1');
    //floorToggle('2');
 //   floorToggle('3');

  
    

    // 案例展示部分 鼠标移上透明遮罩层显示效果
    $('.imgbox').hover(function(){
        $(this).find('.cover').css('display','block');
    },function(){
        $(this).find('.cover').css('display','none');
    });

    // 首页固定导航
    $('#lift').css({'top' : $(window).height()/2 - $('#lift').height()/4});

    // 楼层鼠标移上效果
    hoverStepFloor(1, 105, '1F新品热卖');
    hoverStepFloor(2, 65, '2F团购');
    hoverStepFloor(5, 105, '5F案例展示');
    hoverStepFloor(3, 135, '3F办公家具厂家');
    hoverStepFloor(4, 135, '4F办公配套厂家');


    $('#toTop').click(function(){
        $('body,html').animate({scrollTop:0},1000);
    });
    
    
    //加载购物车数量
    showCartNum();

});

function newUrl(url){
	if(url!=null && url!=""){
		window.location.href="http://"+url;
	}
}

function codelistAll(code,ul,id){
	$.ajax({
		url : 'selectCodeList.do?code='+code,
		dataType : 'json',
		type : 'post',
		async:true,
		success : function(data) {
			$(data).each(function(index, row) {
				var names=row.name.split('-');
				var name=names[0];
				if(names.length>1){
					name=names[1];
				}
				var li = $('<li class="type"></li>');
				var a = $('<a href="javascript:void(0);" onclick="checkUserPerm(\'purchase/index.do?type='+code+'&prop='+row.id+'&jumpPage=2\',[],'+perm+',true)">'+name+'</a>');
				li.append(a);
				ul.append(li);
			});
		}
	});
}

function getProducts(code,type){
	var text=$.ajax({
		url:'indexProducts.do',
		data:{code:code,type:type},
		type:'post',
		async:false
	}).responseText;
	return eval('('+text+')');
}
function getCompanyF4(id){
	var data=id==null?{}:{id:id};
	var text=$.ajax({
		url : 'select4F.do',
		dataType : 'json',
		data:data,
		type : 'post',
		async:false
	}).responseText;
	return eval('('+text+')');
}

function getCompanyF5(id){
	var data=id==null?{}:{id:id};
	var text=$.ajax({
		url : 'select5F.do',
		dataType : 'json',
		data:data,
		type : 'post',
		async:false
	}).responseText;
	return eval('('+text+')');
}

function getGroupDiv(){
	var div=$('<div></div>');
	div.addClass('case-show-list');
	return div;
}
//倒计时
/*function countTime(obj,secondTime, dayObj, hourObj, minObj, secObj, i){
    var SetRemainTime = 'SetRemainTime'+i;
    var InterValObj = 'InterValObj'+i;
    SetRemainTime = function() {
        if (secondTime > 0) {
           secondTime = secondTime - 1;
           var second = Math.floor(secondTime % 60);             // 计算秒    
           var minite = Math.floor((secondTime / 60) % 60);      //计算分
           var hour = Math.floor((secondTime / 3600) % 25);      //计算小时
           var day = Math.floor((secondTime / 3600) / 24);        //计算天
           dayObj.html(day);
           hourObj.html(hour);
           minObj.html(minite);
           secObj.html(second);
          } else {//剩余时间小于或等于0的时候，就停止间隔函数
            window.clearInterval(InterValObj);
            $(obj).parent().find('.pro-img').removeAttr('href');
            $(obj).parent().find('.pro-img').find('.overimg').show();
            $(obj).parent().find('.pro-name').attr('href','javascript:void(0)');
          }
    }
    SetRemainTime();
    InterValObj = window.setInterval(SetRemainTime, 1000);
}*/
function countTime(obj,secondTime, dayObj, hourObj, minObj, secObj){
    var SetRemainTime = 'SetRemainTime';
    var InterValObj = 'InterValObj';
    SetRemainTime = function() {
        if (secondTime > 0) {
        	 secondTime = secondTime - 1000;
           var second = Math.floor(secondTime / 1000) %60;             // 计算秒    
           var minite = Math.floor(secondTime / (1000 * 60)) % 60;      //计算分
           var hour = Math.floor(secondTime / (1000 * 60 * 60)) % 24;      //计算小时
           var day = Math.floor(secondTime / (1000 * 60 * 60 * 24));        //计算天
           dayObj.html(day);
           hourObj.html(hour);
           minObj.html(minite);
           secObj.html(second);
          } else {//剩余时间小于或等于0的时候，就停止间隔函数
            window.clearInterval(InterValObj);
            dayObj.html("0");
            hourObj.html("0");
            minObj.html("0");
            secObj.html("0");
            $(obj).parent().find('.pro-img').removeAttr('href');
            $(obj).parent().find('.pro-img').find('.overimg').show();
            $(obj).parent().find('.pro-name').attr('href','javascript:void(0)');
          }
    }
    SetRemainTime();
    InterValObj = window.setInterval(SetRemainTime, 1000);
}
function hoverStepFloor(index, width, html){
    var tmpTime;
    $('#floorStep'+index).hover(function(){
        tmpTime = setTimeout(function(){
            $('#floorStep'+index).css('border-color', '#123457');
            $('#floorStep'+index).animate({width:width},300,function(){}).html(html);
        },200);
    },function(){
        clearTimeout(tmpTime);
        $('#floorStep'+index).css('border-color', '#dfdfdf');
        $(this).animate({width:38},0.1,function(){}).html(index+'F');
    });
}


function CaseSharingId(id){
	$('#CaseSharingType li').removeClass('active');
	$('#cst_'+id).attr('class','active');
	$('#3FCaseSharingAll').empty();
	$.ajax({
		url : 'selectCaseSharing.do?id='+id,
		dataType : 'json',
		type : 'post',
		async:true,
		success : function(data) {
			var li=$('<div class="floor-tab-cont" id="3F">' +
					' <div  class="floor3TabList">' +
					'<div class="case-show-list"><div class="case-show-row1">' +
					' <div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[0].url+'\',[],true,true)"><img src="'+data[0].showImage+'"></a>' +
					' <div class="cover"></div></div><div class="descbox">' +
					'<div class="left-desc"><h2 class="type-name">'+cutstr(data[0].title,20)+'</h2>' +
					'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[0].url+'\',[],true,true)">'+cutstr(data[0].content,40)+'</a>' +
					' <p class="case-infor">' +
					' 作者：'+data[0].companyName+' &nbsp;&nbsp;积分：'+data[0].integral+' &nbsp;&nbsp;</p> </div>' +
					'<div class="left-arrow"></div><div class="right-desc">' +
					'<h2 class="type-name">'+cutstr(data[1].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[1].url+'\',[],true,true)">'+cutstr(data[1].content,40)+'</a>' +
					'<p class="case-infor">'+
					'作者：'+data[1].companyName+' &nbsp;&nbsp; 积分：'+data[1].integral+' &nbsp;&nbsp;</p></div>'+
					' <div class="right-arrow"></div></div>'+
					'<div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[1].url+'\',[],true,true)"><img src="'+data[1].showImage+'"></a>'+
					'<div class="cover"></div></div><div class="imgbox row-end">'+
					'<a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[2].url+'\',[],true,true)"><img src="'+data[2].showImage+'"></a>'+
					'<div class="left-desc"><h2 class="type-name">'+cutstr(data[2].title,20)+'</h2>'+
					'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[2].url+'\',[],true,true)">'+cutstr(data[2].content,40)+'</a><p class="case-infor">'+
					'作者：'+data[2].companyName+' &nbsp;&nbsp; 积分：'+data[2].integral+' &nbsp;&nbsp;</p></div>'+
					'<div class="cover"></div></div></div>'+
					'<div class="case-show-row2"><div class="imgbox row-begin">'+
					'<a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[3].url+'\',[],true,true)"><img src="'+data[3].showImage+'"></a>'+
					'<div class="left-desc"><h2 class="type-name">'+cutstr(data[3].title,20)+'</h2>'+
					'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[3].url+'\',[],true,true)">'+cutstr(data[3].content,40)+'</a><p class="case-infor">'+
					'作者：'+data[3].companyName+' &nbsp;&nbsp;积分：'+data[3].integral+'&nbsp;&nbsp; </p></div>'+
					'<div class="cover"></div></div>'+
					'<div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[4].url+'\',[],true,true)"><img src="'+data[4].showImage+'"></a>'+
					' <div class="cover"></div></div><div class="descbox"><div class="left-desc">'+
					'<h2 class="type-name">'+cutstr(data[4].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[4].url+'\',[],true,true)">'+cutstr(data[4].content,40)+'</a>'+
					'<p class="case-infor"> 作者：'+data[4].companyName+'  &nbsp;&nbsp;积分：'+data[4].integral+' &nbsp;&nbsp;</p></div>'+
					'<div class="left-arrow"></div><div class="right-desc">'+
					'<h2 class="type-name">'+cutstr(data[5].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[5].url+'\',[],true,true)">'+cutstr(data[5].content,40)+'</a>'+
					'<p class="case-infor">作者：'+data[5].companyName+' &nbsp;&nbsp;积分：'+data[5].integral+' &nbsp;&nbsp;</p></div>'+
					'<div class="right-arrow"></div></div>'+
					'<div class="imgbox imgbox-end"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[5].url+'\',[],true,true)"><img src="'+data[5].showImage+'"></a>'+
					'<div class="cover"></div></div></div></div>'+
					'<div class="case-show-list"><div class="case-show-row1">' +
					' <div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[6].url+'\',[],true,true)"><img src="'+data[6].showImage+'"></a>' +
					' <div class="cover"></div></div><div class="descbox">' +
					'<div class="left-desc"><h2 class="type-name">'+cutstr(data[6].title,20)+'</h2>' +
					'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[6].url+'\',[],true,true)">'+cutstr(data[6].content,40)+'</a>' +
					' <p class="case-infor">' +
					' 作者：'+data[6].companyName+' &nbsp;&nbsp;积分：'+data[6].integral+' &nbsp;&nbsp;</p> </div>' +
					'<div class="left-arrow"></div><div class="right-desc">' +
					'<h2 class="type-name">'+cutstr(data[7].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[7].url+'\',[],true,true)">'+cutstr(data[7].content,40)+'</a>' +
					'<p class="case-infor">'+
					'作者：'+data[7].companyName+' &nbsp;&nbsp; 积分：'+data[7].integral+' &nbsp;&nbsp;</p></div>'+
					' <div class="right-arrow"></div></div>'+
					'<div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[7].url+'\',[],true,true)"><img src="'+data[7].showImage+'"></a>'+
					'<div class="cover"></div></div><div class="imgbox row-end">'+
					'<a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[8].url+'\',[],true,true)"><img src="'+data[8].showImage+'"></a>'+
					'<div class="left-desc"><h2 class="type-name">'+cutstr(data[8].title,20)+'</h2>'+
					'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[8].url+'\',[],true,true)">'+cutstr(data[8].content,40)+'</a><p class="case-infor">'+
					'作者：'+data[8].companyName+' &nbsp;&nbsp; 积分：'+data[8].integral+' &nbsp;&nbsp;</p></div>'+
					'<div class="cover"></div></div></div>'+
					'<div class="case-show-row2"><div class="imgbox row-begin">'+
					'<a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[9].url+'\',[],true,true)"><img src="'+data[9].showImage+'"></a>'+
					'<div class="left-desc"><h2 class="type-name">'+cutstr(data[9].title,20)+'</h2>'+
					'<a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[9].url+'\',[],true,true)">'+cutstr(data[9].content,40)+'</a><p class="case-infor">'+
					'作者：'+data[9].companyName+' &nbsp;&nbsp;积分：'+data[9].integral+'&nbsp;&nbsp; </p></div>'+
					'<div class="cover"></div></div>'+
					'<div class="imgbox"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[10].url+'\',[],true,true)"><img src="'+data[10].showImage+'"></a>'+
					' <div class="cover"></div></div><div class="descbox"><div class="left-desc">'+
					'<h2 class="type-name">'+cutstr(data[10].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[10].url+'\',[],true,true)">'+cutstr(data[10].content,40)+'</a>'+
					'<p class="case-infor"> 作者：'+data[10].companyName+'  &nbsp;&nbsp;积分：'+data[10].integral+' &nbsp;&nbsp;</p></div>'+
					'<div class="left-arrow"></div><div class="right-desc">'+
					'<h2 class="type-name">'+cutstr(data[11].title,20)+'</h2><a href="javascript:void(0);" class="case-name"   onclick="checkUserPerm(\''+data[11].url+'\',[],true,true)">'+cutstr(data[11].content,40)+'</a>'+
					'<p class="case-infor">作者：'+data[11].companyName+' &nbsp;&nbsp;积分：'+data[11].integral+' &nbsp;&nbsp;</p></div>'+
					'<div class="right-arrow"></div></div>'+
					'<div class="imgbox imgbox-end"><a href="javascript:void(0);"   onclick="checkUserPerm(\''+data[11].url+'\',[],true,true)"><img src="'+data[11].showImage+'"></a>'+
					'<div class="cover"></div></div></div></div></div></div></div>');
					
			$('#3FCaseSharingAll').append(li);
		}
	});
}
function jumpProduct(productId,loginFlag){
	var text=$.ajax({
		url:ctx+'/login/checkUser.do',
		type:'post',
		async:false,
	}).responseText;

	checkUser.execCallBack=function(){
		callback.apply(window,fnParam);
	}
	if(text==''){
		checkUser.index=layer.open({
    	    type: 2,
    	    title:'登录',
    	    fix: false, //不固定
    	    area: ['500px', '450px'],
    	    content:$.basePath+'/content/jhShop/insideLogin.jsp'
		});
	}else{
		var json = JSON.parse(text);
		companystate = json.company.state;
		if(loginFlag == 2){
			window.location.href =ctx+"/product/page.do?productId="+productId;
			
		}else if(companystate != 16){
			window.location.href = ctx+'/jhCompanyBase/RZauthentication.do';
		}
	}
}
function jumpCompany(companyId,loginFlag){
	var text=$.ajax({
		url:ctx+'/login/checkUser.do',
		type:'post',
		async:false,
	}).responseText;

	checkUser.execCallBack=function(){
		callback.apply(window,fnParam);
	}
	if(text==''){
		checkUser.index=layer.open({
    	    type: 2,
    	    title:'登录',
    	    fix: false, //不固定
    	    area: ['500px', '450px'],
    	    content:$.basePath+'/content/jhShop/insideLogin.jsp'
		});
	}else{
		var json = JSON.parse(text);
		companystate = json.company.state;
		if(loginFlag == 2){
			window.location.href =ctx+"/product/searchPro.do?company="+companyId;
		}else if(companystate !=16){
			window.location.href = ctx+'/jhCompanyBase/RZauthentication.do';
		}
	}
}
function floorToggle(floorNum){
	var floorEvent=this;
    var i=0; //第i+1个tab开始
    var offset = 5000; //轮换时间
    var timer = 'timer'+floorNum;
    floorEvent.ahover1=function(){
	      $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
	      var code=$(this).attr('code'),divInfo=$('#1F').find('#'+code);
			if(!divInfo.length){
				var div=$('<div></div');
				div.attr("id",code);
				var ul=$('<ul></ul>');
				ul.addClass('pro-ul');
				var prodList=getProducts(code,1);
				$(prodList).each(function(index,row){
					var picPath=row.attrList!=null&&row.attrList.length>0?row.attrList[0].home_path:"common/images/common/blank.gif";
					var li=$('<li class="pro-block"  title="'+(row.extended1)+'"></li>');
					li.css('cursor','pointer').click(function(){
						checkUserPerm(ctx+'/product/page.do?productId='+row.productId,[],perm,true);
					});
						ul1=$('<ul></ul>');
						img=$('<li class="pro-img"><img src="'+row.productSrc+'" alt="" /></li>');
						title=$('<li class="pro-title">'+cutstr(row.extended1+'',27)+'</li>');
				//		img=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/page.do?productId='+row.productId+'\',[],'+perm+',true)"  class="pro-img"><img src="'+row.productSrc+'"  style="width:220px;height:220px;padding-top:8px;" /></a>');
				//		title=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/page.do?productId='+row.productId+'\',[],'+perm+',true)" class="pro-name">'+cutstr(row.extended1+'',27)+'</a>');
//						if(row.loginFlag == "2"){
//							p=$('<p><span class="price"><i>￥'+row.productPice+'</i>/件</span><span class="order-per">返点比例：<i>'+row.productRebate+'</i>%</span></p>');
//						}else{
//							p=$('<p><span class="price"><i>￥认证会员可见</i></span><span class="order-per">返点比例：<i>'+row.productRebate+'</i>%</span></p>');
//						}
						p='<li class="pro-prise">￥'+row.productPice+'</li>';                
						//p1=$('<p><img src="common/jhShop/icon-history.png">&nbsp;生产周期：'+row.productCycle+'天<span class="order-per">已售'+(!row.saleCount?0:row.productSell)+'件</span></p>');
						//p2=$('<p class="time-last"><a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/searchPro.do?company='+row.productCompanyId+'\',[],'+perm+',true)" class="shopname">'+row.productCompany+'</a></p>');
						ul1.append(img).append(title).append(p);
						li.append(ul1);
						ul.append(li);
						//if((index+1)%5!=0||index==0){
							//ul.append('<li class="line"></li>');
						//}
						//if(prodList.length>5){
							//li.css("border-bottom",'1px solid #dfdfdf');
//						}
					
				});
				div.append(ul);
				$('#1F').append(div);
				div.siblings('div').hide();
			}else{
				divInfo.show();
				divInfo.siblings('div').hide();
			}
	      };
	      
//	  floorEvent.ahover2=function(){
//          $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
//          var code=$(this).attr('code'),divInfo=$('#2F').find('#'+code);	
//          if(!divInfo.length){
//				var div=$('<div></div');
//				div.attr("id",code);
//				var ul=$('<ul></ul>');
//				ul.addClass('pro-ul');
//				var prodList=getProducts(code,2);
//				$(prodList).each(function(index,row){
//					var picPath=row.attrList!=null&&row.attrList.length>0?row.attrList[0].home_path:"common/images/common/blank.gif";
//					var li=$('<li class="pro-block"  title="'+(row.extended1)+'"></li>');
//					ul1=$('<ul></ul>');
//					img=$('<li class="pro-img"><img src="'+row.productSrc+'" alt="" /></li>');
//					title=$('<li class="pro-title">'+cutstr(row.extended1+'',27)+'</li>');
//					p='<li class="pro-prise">￥'+row.productPice+'</li>';                
////					var li=$('<li title="'+row.extended1+'"></li>');
////						img=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/page.do?productId='+row.productId+'\',[],'+perm+',true)" class="pro-img"><img src="'+row.productSrc+'"  style="width:220px;height:220px;padding-top:8px;" /></a>'),
////						overimg=$("<img src='"+ctx+"/common/images/gbuyover.png' class='overimg'></img>"),
////						title=$('<a href="javascript:void(0);"  onclick="checkUserPerm(\''+ctx+'/product/page.do?productId='+row.productId+'\',[],'+perm+',true)" class="pro-name">'+cutstr(row.extended1,27)+'</a>'),
////						companyName=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/searchPro.do?company='+row.productCompanyId+'\',[],'+perm+',true)" class="shopname">'+row.productCompany+'</a>'),
////						p=$('<p class="time-last"  code='+code+' lostTime="'+row.overTimeLong+'"><img src="common/jhShop/icon-history.png" />&nbsp;剩余时间：<span class="day"></span>天<span class="hour"></span>时<span class="min"></span>分<span class="sec"></span>秒</p>');
////						img.css("position","relative");
////						overimg.css({
////							position:"absolute",
////							bottom:0,
////							width:220,
////							height:35,
////							left:3,
////							display:'none'
////						});
////						img.append(overimg);
////						li.append(img).append(title).append(p).append(companyName);
////						ul.append(li);
////						var curObj=p;
////						countTime(curObj,
////					            curObj.attr('lostTime'), 
////					            curObj.find('.day'), 
////					            curObj.find('.hour'), 
////					            curObj.find('.min'), 
////					            curObj.find('.sec')
////					            );
//					ul1.append(img).append(title).append(p);
//						li.append(ul1);
//						ul.append(li);
////						if((index+1)%5!=0||index==0){
////							ul.append('<li class="line"></li>');
////						}
////						if(prodList.length>5){
////							li.css("border-bottom",'1px solid #dfdfdf');
////						}
////					
//					
//				});
//				div.append(ul);
//				$('#2F').append(div);
//				div.siblings('div').hide();
//			}else{
//				divInfo.show();
//				divInfo.siblings('div').hide();
//			}
//	  } ;
	      floorEvent.ahover2=function(){
		      $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
		      var code=$(this).attr('code'),divInfo=$('#2F').find('#'+code);
				if(!divInfo.length){
					var div=$('<div></div');
					div.attr("id",code);
					var ul=$('<ul></ul>');
					ul.addClass('pro-ul');
					var prodList=getProducts(code,3);
					$(prodList).each(function(index,row){
						var picPath=row.attrList!=null&&row.attrList.length>0?row.attrList[0].home_path:"common/images/common/blank.gif";
						var li=$('<li class="pro-block"  title="'+(row.extended1)+'"></li>');
						li.css('cursor','pointer').click(function(){
							checkUserPerm(ctx+'/product/page.do?productId='+row.productId,[],perm,true);
						});
							ul1=$('<ul></ul>');
							img=$('<li class="pro-img"><img src="'+row.productSrc+'" alt="" /></li>');
							title=$('<li class="pro-title">'+cutstr(row.extended1+'',27)+'</li>');
					//		img=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/page.do?productId='+row.productId+'\',[],'+perm+',true)"  class="pro-img"><img src="'+row.productSrc+'"  style="width:220px;height:220px;padding-top:8px;" /></a>');
					//		title=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/page.do?productId='+row.productId+'\',[],'+perm+',true)" class="pro-name">'+cutstr(row.extended1+'',27)+'</a>');
//							if(row.loginFlag == "2"){
//								p=$('<p><span class="price"><i>￥'+row.productPice+'</i>/件</span><span class="order-per">返点比例：<i>'+row.productRebate+'</i>%</span></p>');
//							}else{
//								p=$('<p><span class="price"><i>￥认证会员可见</i></span><span class="order-per">返点比例：<i>'+row.productRebate+'</i>%</span></p>');
//							}
							p='<li class="pro-prise">￥'+row.productPice+'</li>';                
							//p1=$('<p><img src="common/jhShop/icon-history.png">&nbsp;生产周期：'+row.productCycle+'天<span class="order-per">已售'+(!row.saleCount?0:row.productSell)+'件</span></p>');
							//p2=$('<p class="time-last"><a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/searchPro.do?company='+row.productCompanyId+'\',[],'+perm+',true)" class="shopname">'+row.productCompany+'</a></p>');
							ul1.append(img).append(title).append(p);
							li.append(ul1);
							ul.append(li);
							//if((index+1)%5!=0||index==0){
								//ul.append('<li class="line"></li>');
							//}
							//if(prodList.length>5){
								//li.css("border-bottom",'1px solid #dfdfdf');
//							}
						
					});
					div.append(ul);
					$('#2F').append(div);
					div.siblings('div').hide();
				}else{
					divInfo.show();
					divInfo.siblings('div').hide();
				}
		      };
	  floorEvent.ahover3=function(){
	      $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
	      var code=$(this).attr('code'),divInfo=$('#3F').find('#'+code);
			if(!divInfo.length){
				var div=$('<div></div');
				div.attr("id",code);
				var ul=$('<ul></ul>');
				ul.addClass('pro-ul');
				var prodList=getProducts(code,3);
				$(prodList).each(function(index,row){
					var picPath=row.attrList!=null&&row.attrList.length>0?row.attrList[0].home_path:"common/images/common/blank.gif";
					var li=$('<li class="pro-block"  title="'+(row.extended1)+'"></li>');
					li.css('cursor','pointer').click(function(){
						checkUserPerm(ctx+'/product/page.do?productId='+row.productId,[],perm,true);
					});
						ul1=$('<ul></ul>');
						img=$('<li class="pro-img"><img src="'+row.productSrc+'" alt="" /></li>');
						title=$('<li class="pro-title">'+cutstr(row.extended1+'',27)+'</li>');
				//		img=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/page.do?productId='+row.productId+'\',[],'+perm+',true)"  class="pro-img"><img src="'+row.productSrc+'"  style="width:220px;height:220px;padding-top:8px;" /></a>');
				//		title=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/page.do?productId='+row.productId+'\',[],'+perm+',true)" class="pro-name">'+cutstr(row.extended1+'',27)+'</a>');
//						if(row.loginFlag == "2"){
//							p=$('<p><span class="price"><i>￥'+row.productPice+'</i>/件</span><span class="order-per">返点比例：<i>'+row.productRebate+'</i>%</span></p>');
//						}else{
//							p=$('<p><span class="price"><i>￥认证会员可见</i></span><span class="order-per">返点比例：<i>'+row.productRebate+'</i>%</span></p>');
//						}
						p='<li class="pro-prise">￥'+row.productPice+'</li>';                
						//p1=$('<p><img src="common/jhShop/icon-history.png">&nbsp;生产周期：'+row.productCycle+'天<span class="order-per">已售'+(!row.saleCount?0:row.productSell)+'件</span></p>');
						//p2=$('<p class="time-last"><a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/searchPro.do?company='+row.productCompanyId+'\',[],'+perm+',true)" class="shopname">'+row.productCompany+'</a></p>');
						ul1.append(img).append(title).append(p);
						li.append(ul1);
						ul.append(li);
						//if((index+1)%5!=0||index==0){
							//ul.append('<li class="line"></li>');
						//}
						//if(prodList.length>5){
							//li.css("border-bottom",'1px solid #dfdfdf');
//						}
					
				});
				div.append(ul);
				$('#3F').append(div);
				div.siblings('div').hide();
			}else{
				divInfo.show();
				divInfo.siblings('div').hide();
			}
	      };
	  
	  floorEvent.ahover4=function(){
	      $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
	      var id=$(this).attr('dataId'),divInfo=$('#4F').find('#'+id);
				if(!divInfo.length){
					var div=$('<div></div');
					div.attr("id",id);
					var ul=$('<ul></ul>');
					$(getCompanyF4($(this).attr('dataId'))).each(function(index,row){
						var li=$('<li style="height:150px"></li>');
						if(perm){
						//var	a=$('<a href="javascript:void(0);" onclick="checkUser(jumpIntroPage,['+row.companyId+'])" class="pro-img"></a>');
							var	a=$('<a href="javascript:void(0);" onclick="checkUserPerm(\''+ctx+'/product/introPage.do?company='+row.companyId+'\',[],'+perm+',true)" class="pro-img"></a>');
						}else{
						var	a=$("<a href="+ctx+'/product/introPage.do?company='+row.companyId+" target='_blank' class='pro-img'></a>");
						}
						p=$('<p class="shop-name">'+cutstr(row.companyName,26)+'</p>');
						img=$(' <img src="'+row.companyLogo+'"/>');
						img.css({width:185,height:94});
						a.append(p).append(img);
						li.append(a);
						ul.append(li);
							ul.append('<li class="line"  style="height:150px"></li>');
					});
					div.append(ul);
					$('#4F').append(div);
					div.siblings('div').hide();
				}else{
					divInfo.show();
					divInfo.siblings('div').hide();
				}
	    };
	    floorEvent.ahover5=function(){
			$(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
			var id=$(this).attr('dataId'),divInfo=$('#5F').find('#'+id);
			if(!divInfo.length){
				var div=$('<div></div');
				div.attr("id",id);
				var ul=$('<ul></ul>');
				$(getCompanyF5($(this).attr('dataId'))).each(function(index,row){
					var li=$('<li style="height:150px"></li>');
					if(perm){
						//var a=$("<a href='javascript:void(0);' onclick='checkUser(jumpIntroPage,["+row.companyId+"])' class='pro-img'></a>");
						var a=$("<a href='javascript:void(0);' onclick=\"checkUserPerm('"+ctx+"/product/introPage.do?company="+row.companyId+"',[],"+perm+",true)\" class='pro-img'></a>");
					}else{
						var a=$("<a href="+ctx+'/product/introPage.do?company='+row.companyId+" target='_blank' class='pro-img'></a>");
					}
					p=$('<p class="shop-name">'+cutstr(row.companyName,26)+'</p>');
					img=$(' <img src="'+row.companyLogo+'"/>');
					img.css({width:185,height:94});
					a.append(p).append(img);
					li.append(a);
					ul.append(li);
						ul.append('<li class="line"  style="height:150px"></li>');
				});
				div.append(ul);
				$('#5F').append(div);
				div.siblings('div').hide();
			}else{
				divInfo.show();
				divInfo.siblings('div').hide();
			}
	    };
	autoroll();
	hookThumb();
    function autoroll(){
    	var a=$('#floor'+floorNum+'Tab ul li:eq('+i+')').find('a');
    	floorEvent['ahover'+floorNum].call(a);
    	var length=$('#floor'+floorNum+'Tab ul li').length-1;
    	if(i<length){
    		i++;
    	}else{
    		i=0;
    	}
        timer = window.setTimeout(autoroll, offset);
    }
    function slide(a){
    	floorEvent['ahover'+floorNum].call(a);
    }

    function hookThumb(){    
        $('#floor'+floorNum+'Tab ul li').each(function(i,obj){
        	$(this).find("a").hover(
        	        function(){
        	        	slide(this); 
        	            if(timer){
        	                clearTimeout(timer);
        	                slide(this); 
        	            }
        	        },function(){
        	           timer = window.setTimeout(autoroll, offset);  
        	            this.blur();            
        	            return false;
        	        }); 
        });
        $('#floor'+floorNum).find('.floor-tab-cont').hover(
            function(){
                if(timer){
                    clearTimeout(timer);
                 //   i = $(this).prevAll().length;
                   // slide(i); 
                }
            },function(){
                timer = window.setTimeout(autoroll, offset);  
                this.blur();            
                return false;
        });
    }
}

(function ($){
    var index = function(){
        var slider ={
            initSlider : function(){
                var currentSlide = 0;
                var oldSlide = 0;
                var slideCount = $('#slideList li').length;
                var slideWidth = $('#slideList li').innerWidth();
                $('#slideList').css('width', slideWidth * slideCount);
                $('#slideControl a.slide-num').eq(0).addClass('contr-active');
                var slideTimeout;
                if(slideCount > 1){
                    $('#slideControl').css('display','block');
                    var slideRotation = function() {
                        oldSlide = currentSlide;
                        currentSlide = (currentSlide + 1) % slideCount;
                        $('#slideControl a.slide-num').eq(oldSlide).removeClass('contr-active');
                        $('#slideControl a.slide-num').eq(currentSlide).addClass('contr-active');
                        $('#slideList').fadeOut('6000', function() {
                            $(this).css('left', -slideWidth * currentSlide);
                            $(this).fadeIn();
                        });
                        slideTimeout = setTimeout(slideRotation, 6000);
                    };
                    slideTimeout = setTimeout(slideRotation, 1000);//启动轮转程序
                }else{
                    $('#slideControl').css('display','none');
                }
                
                //鼠标悬停
                $('#slideControl').hover(function() {
                    clearTimeout(slideTimeout);
                },//鼠标悬停时停止轮转
                function() {
                    slideTimeout = setTimeout(slideRotation, 2500);
                }//鼠标移开后重新开始轮转程序        
                );//hover function end
                $('#slideControl .slide-num').click(function() {
                    clearTimeout(slideTimeout);
                    $('#slideControl a.slide-num').removeClass('contr-active');//取消所有标有当前标记的控制数
                    $(this).addClass('contr-active');//添加当前标记给控制数
        
                    var c_num = $(this).attr("name");
                    currentSlide = parseInt(c_num) - 1;
                    oldSlide = currentSlide - 1;
                    $('#slideList').fadeOut('6000', function() {
                            $(this).css('left', -slideWidth * currentSlide);
                            $(this).fadeIn();
                        });
                });
            }
        }
        return slider;
    }();window.index = index;
}(jQuery)); 



//------------------------申请托管 2015-6-2 xuwb----------------------------

/**
 * 反馈
 */
function feedback(){
	var location = (window.location+'').split('/'); 
	var basePath = location[0]+'//'+location[2]+'/'+location[3];
	layer.open({
	    type: 2,
	    area: ['800px', '600px'],
	    skin: 'layui-layer-rim', //加上边框
	    content: [basePath+'/content/jhShop/collocation.jsp', 'no']
	});
}



function showCartNum(){
	$.ajax({
		url:ctx+"/selectProCartNum.do",
		type:'post',
		dataType : "json",
		async: true,
		success: function(data){
			$('.shopcar').find('.shopcar-num').html(data.cartNum);
		}
	})
}
