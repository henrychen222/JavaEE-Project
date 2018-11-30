$(function(){
    // 下拉框初始化
	$('#searchType').select();

    // 主色调配置
    var colorData = {
        'default' : '#123457',
        'hover' : '#e69b02',
        'active' : '#e69b02'
    };
    $('.nav, .shop-go, .btn-search').css('background', colorData.default);
    $('.shop-go').css('border-color', colorData.default);
    $('.contact-online').css('background', colorData.active);
    $('.nav').find('li a').hover(function(){
        $(this).css('background', colorData.hover);
    },function(){
        $(this).css('background', colorData.default);
    });
    $('.nav').find('.active a').hover(function(){
        $(this).css('background', colorData.hover);
    },function(){
        $(this).css('background', colorData.hover);
    });
    $('.shop-go, .contact-online, .btn-search').hover(function(){
        $(this).css({'color' : colorData.hover, 'border-color' : colorData.hover, 'background-color' : '#fff'});
    },function(){
        $(this).css({'color' : '#fff', 'border-color' : colorData.default, 'background-color' : colorData.default});
    });
    $('.nav').find('.active a').css('background', colorData.active);
    $('.shop-follow').css({'color' : colorData.default, 'border-color' : colorData.default});
    $('.shop-follow').hover(function(){
        $(this).css({'color' : colorData.hover, 'border-color' : colorData.hover, 'background-color' : '#fff'});
    },function(){
        $(this).css({'color' : colorData.default, 'border-color' : colorData.default, 'background-color' : '#fff'});
    });
    $('#proTabHead').find('.active').css({'color' : '#fff', 'background' : colorData.default});
   
	

    // 图片放大镜
    $(".jqzoom1").jqzoom({
        zoomType: 'standard',
        imageOpacity: 0.5,
        xOffset:10,
        lens:true,
        preloadImages: false,
        alwaysOn:false,
        title:false,
        zoomWidth:500,
        zoomHeight:500
    }); 

    // 返利比例
    var perVal = $('#returnPer').attr('returnper');
    /*switch(perVal){
        case 1 : 
            
    }*/

    // 产品详情tab页切换 start
    var tabHeadList = $('#proTabHead ul li');
    tabHeadList.each(function(i){
      $(this).find('a').off('click').on({'click' : function(){
        $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default'); 
		$('#proTabHead').find('.active a').css({'color' : '#fff', 'background' : colorData.default});
		$('#proTabHead').find('.default a').css({'color' : '#000', 'background' : 'none'});
		$('#proTabHead').find('.default').css({'color' : '#000', 'background' : 'none'});
        $('#proTabCont' + (i + 1)).css('display', 'block').siblings('div').css('display', 'none');
      }});
    });
    // tab切换 end

    // 产品排名tab页切换 start
    var tabHeadList = $('#proRankTab ul li');
    tabHeadList.each(function(i){
      $(this).find('a').off('click').on({'click' : function(){
        $(this).parent('li').attr('class', 'active').siblings('li').attr('class', 'default');
        $('#proRankTab' + (i + 1)).css('display', 'block').siblings('div').css('display', 'none');
      }});
    });
    // tab切换 end

    // 产品分类二级树
    $('.parent-cont').click(function(){
      var tmp = $(this);
      if(tmp.next('.child-wrap').is(':visible')){
        tmp.next('.child-wrap').hide();
        tmp.find('.child-mark').attr('class', 'parent-mark');
      }else{
        tmp.next('.child-wrap').css('display', 'block');
        tmp.find('.parent-mark').attr('class', 'child-mark');
      }
    });

    // 商品数量加减
    $('#minusNum').off('click').on({'click' : function(){
        var numVal = $('#numVal').html();
        if(numVal != '1'){
            numVal --;
            $('#numVal').html(numVal);
        }else{
             return false;
        }
    }});
    $('#addNum').off('click').on({'click' : function(){
        var numVal = $('#numVal').html();
        numVal ++;
        $('#numVal').html(numVal);
    }});
});