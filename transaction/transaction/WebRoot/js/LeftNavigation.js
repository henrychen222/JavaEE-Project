/**
 *@author yu_you
 *@dependence jquery 1.2
 *@since 2014/4/25
 *@version 1.1
 */  
jQuery.easing['jswing'] = jQuery.easing['swing'];
jQuery.extend( jQuery.easing,
{
	def: 'easeOutQuad',
	easeOutCubic: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t + 1) + b;
	}
});
 
(function() {
	$.suning || ($.suning = {});
	$.suning.productView = {};
	//继承
	$.suning.productView.extend = function (subClass, superClass) {
		var F = function() {};
		F.prototype = superClass.prototype;
		subClass.prototype = new F();
		superClass.prototype.constructor = superClass;
		subClass.prototype.constructor = subClass;
		subClass.base = superClass.prototype;
	}
})();

/* 首页左侧导航 */
function SNmenuNav(){
	$("#SNmenuNav dl").hover(function(){
		$(this).find("dt a").addClass("on");
		$(this).find("dd").show();
		$(this).find("dt b").hide();
	},function(){
		$(this).find("dt a").removeClass("on");
		$(this).find("dd").hide();
		$(this).find("dt b").show();
	})
}

$(function(){
	SNmenuNav();
    function lazyload(option){var settings={defObj:null,defHeight:0};settings=$.extend(settings,option||{});var defHeight=settings.defHeight,defObj=(typeof settings.defObj=="object")?settings.defObj.find("img"):$(settings.defObj).find("img");var pageTop=function(){var d=document,y=(navigator.userAgent.toLowerCase().match(/iPad/i)=="ipad")?window.pageYOffset:Math.max(d.documentElement.scrollTop,d.body.scrollTop);return d.documentElement.clientHeight+y-settings.defHeight};var imgLoad=function(){defObj.each(function(){if($(this).offset().top<=pageTop()){var src2=$(this).attr("src2");if(src2){$(this).attr("src",src2).removeAttr("src2")}}})};$(window).bind("scroll",function(){imgLoad()})};
	lazyload({defObj:"#snfoor01"});
	lazyload({defObj:"#snfoor02"});
	lazyload({defObj:"#snfoor03"});
	lazyload({defObj:"#snfoor04"});
	lazyload({defObj:"#snfoor05"});
	lazyload({defObj:"#snfoor06"});
	lazyload({defObj:"#snfoor07"});
	lazyload({defObj:".ad80"});		     	
})
//下拉框样式
  $(document).ready(function(){
							 $('.son_ul').hide(); //初始ul隐藏
							 $('.select_box span').hover(function(){ //鼠标移动函数
																  $(this).parent().find('ul.son_ul').slideDown();  //找到ul.son_ul显示
																  $(this).parent().find('li').hover(function(){$(this).addClass('hover')},function(){$(this).removeClass('hover')}); //li的hover效果
																  $(this).parent().hover(function(){},
																						 function(){
																							 $(this).parent().find("ul.son_ul").slideUp(); 
																							 }
																						 );
																  },function(){}
																  );
							 $('ul.son_ul li').click(function(){
															  $(this).parents('li').find('span').html($(this).html());
															  $(this).parents('li').find('ul').slideUp();
															  });
					}
);