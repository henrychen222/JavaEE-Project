function cutstr(str, len) {
    var str_length = 0;
    var str_len = 0;
    str_cut = [];
    str_len = str.length;
    for (var i = 0; i <str_len; i++) {
        a = str.charAt(i);
        str_length++;
        if (escape(a).length > 4||(String.fromCharCode(a)>=65&&String.fromCharCode(a)<=90)) {
            // 中文字符的长度经编码之后大于4
            str_length++;
        }

       str_cut.push(a);
        if (str_length>len) {
        	var index=i;
        	while(str_length+3>len){
        		a = str.charAt(index);
        		if (escape(a).length > 4) {
        			str_length-=2;
        		}else{
        			str_length--;
        		}
        		str_cut[index]='';
        		index--;
        	}
        	if(str_cut[index]==' '){
        		str_cut[index]='';
        	}
            str_cut.push("...");
            return str_cut.join('');
        }

    }
    // 如果给定字符串小于指定长度，则返回源字符串；
    if (str_length <= len) {
        return str;
    }
}

//下拉框 start */
(function($){
    $.fn.select = function(options){
        //定义常量
        var settings = $.extend({},options);
         
        this.each(function() {
        	$(this).siblings('.combo-box').remove();
            // 下拉框对象
            var $html = $('<div class="combo-box"><div class="combo-box-top"><span class="fir-txt"></span><span class="down-mark"></span></div><ul></ul></div>');
            // 将下拉框隐藏，把模版插入其后
            var $this = $(this).hide().after($html);
            //声明全局变量
            var $list = $html.find('ul'),
                $default = $html.find('.combo-box-top'),
                $span = $default.find('.fir-txt'),
                $label = $default.find('.down-mark');

            //将option遍历到li中
            $this.find('option').each(function(){
                var $option = $(this);
                $('<li val="'+$option.val()+'">'+$option.text()+'</li>').appendTo($list);
 
                if($option.prop('selected') === true){
                    $this.val($option.val());
                    $span.text($option.text());
                }
            });

            if($span.text() === ''){
                var $li = $list.find('li').first();
                $this.val($li.attr('val'));
                $span.text($li.text());
            }
            
            // 宽度设置
            var comboBoxWidth = $(this).attr('width');
            if(comboBoxWidth != null || comboBoxWidth != ''){
                $default.width(comboBoxWidth);
                $list.width(parseInt(comboBoxWidth) + 8);
            }

            // click 事件
            $default.click(function(event){
                //阻止事件冒泡
                event.stopPropagation();
                if(!$list.find('li').size())
                    return ;
                $list.slideToggle(100);
            });

            $list.find('li').click(function(){
                var $li = $(this);
                $span.text($li.text());
                if($this.val() != $li.attr('val'))
                    $this.val($li.attr('val')).change();
            }).hover(function(){
                $(this).toggleClass('active');
            });
             
            $this.change(function(){
                var index = $this[0].selectedIndex,
                	$li = $list.find('li:eq('+index+')');
                $span.text($li.text());
            });
 
            $(document).click(function(){
                $list.css('display', 'none');
            });
        });
        return this;
    };
    var location_ = (window.location+'').split('/'); 
    
    $.basePath = location_[0]+'//'+location_[2]+'/'+location_[3];
})(jQuery);
/* 下拉框 end */

/* 弹出层组件 start */
(function(o){
	window.dialog = {
		newDialog : function(options){
            options.id = options.id || 'dialog';
			options.width = options.width || '500'; // width : 弹出层的宽度
			options.dialogTit = options.dialogTit || '提示'; // dialogTit : 弹出层标题
			options.dialogCloseTit = options.dialogCloseTit || '关闭'; // dialogCloseTit : 弹出层右上角关闭按钮的title
			options.isShowCloseIcon = options.isShowCloseIcon || true; // isShowCloseIcon : 是否显示右上角关闭按钮
			options.isShowMask = options.isShowMask || true; // isShowMask : 是否显示遮罩层
			options.dialogContentHtml = options.dialogContentHtml || '<p>出错啦~</p>'; // dialogContentHtml : 错误提示内容(HTML标签集合)
			options.isBtnClose = options.isBtnClose || false, // 是否显示关闭按钮
            options.btnCloseVal = options.btnCloseVal || '确定'; // btnCloseVal : 关闭按钮显示的文字
            options.btnCloseCallback = options.btnCloseCallback || null; // 确定按钮点击之后的回调函数
            options.isBtnCancel = options.isBtnCancel || false;
            options.btnCancelVal = options.btnCancelVal || '取消';
            options.callback = options.callback || null; // 弹出层对象建立之后的回调函数
			

			var dialogObjStr = '', isShowMask = options.isShowMask, dialogObjAll = this,
				dialogClose = '<div class="dialog-close" title="'+options.dialogCloseTit+'"></div>', // 右上角关闭按钮
				dialogBtnClose = '<input class="dialog-btn-close input-btn-middle" type="button" value="'+options.btnCloseVal+'" />', // 底部关闭按钮
			    dialogBtnCancel = '<input class="dialog-btn-cancel input-btn-middle mrgin-r-10" type="button" value="'+options.btnCancelVal+'" />';
            dialogObjAll.isShowMask = isShowMask; // 是否显示遮罩 boolean
            dialogObjAll.isShowCancelBtn = options.btnCancelVal; // 是否显示取消按钮 boolean
			// dialog对象HTML
			dialogObjStr = ('<div class="dialog" id="'+options.id+'">' +
								'<div class="dialog-cont">' +
						            '<div class="dialog-top">' +
						            	'<div class="dialog-tit">' + options.dialogTit + '</div>');

			// 弹出层右上角关闭按钮
			options.isShowCloseIcon ? dialogObjStr += dialogClose : dialogObjStr;

			dialogObjStr += '</div><div class="dialog-center">'+options.dialogContentHtml+'</div>';
            if(options.isBtnCancel || options.isBtnClose){
                dialogObjStr += '<div class="dialog-bottom">';
                options.isBtnCancel ? dialogObjStr += dialogBtnCancel : dialogObjStr;
                options.isBtnClose ? dialogObjStr += dialogBtnClose : dialogObjStr;
                dialogObjStr += '</div>';
            }

            dialogObjStr += '</div></div>';
			
            // 弹出层宽度设置 左右居中
            dialogObjAll.dialogObj = $(dialogObjStr);
			dialogObjAll.dialogObj.width(options.width).css('margin-left', -options.width/2).appendTo('body');

			if(isShowMask){ // 有蒙层
                if($('.dialog-mask').length > 0){
                    $('.dialog-mask').css('display', 'block');
                    dialogObjAll.mask = $('.dialog-mask');
                }else{
                    dialogObjAll.mask = $('<div class="dialog-mask"></div>').appendTo('body');
                }
			}
			// 确定按钮事件绑定
			$('.dialog-btn-close').off('click').on({'click':function(){
				dialogObjAll.dialogObj.css('display', 'none');
                if(options.btnCloseCallback){
                    options.btnCloseCallback(); // 确定按钮 回调函数
                }
                
				if(dialogObjAll.isShowMask){
					dialogObjAll.mask.css('display', 'none');
				}
			}});
            // 右上角关闭按钮 取消按钮 事件绑定
            $('.dialog-btn-cancel, .dialog-close').off('click').on({'click':function(){
                dialogObjAll.dialogObj.css('display', 'none');
                if(dialogObjAll.isShowMask){
                    dialogObjAll.mask.css('display', 'none');
                }
            }});

            //回调函数
            options.callback();

		}
	};
})(window);
/* 弹出层组件 end */

 $(function(){
    /* 单选框 复选框 */
    $("input[type='checkbox']").click(function(){ 
        if($(this).is(':checked')){ 
            $(this).attr("checked","checked"); 
            $(this).parent().removeClass("c_off").addClass("c_on"); 
        }else{ 
            $(this).removeAttr("checked"); 
            $(this).parent().removeClass("c_on").addClass(" c_off"); 
        } 
    }); 
    $("input[type='radio']").click(function(){ 
        $("input[type='radio']").removeAttr("checked").removeClass("r_on").addClass("r_off").parent().removeClass("r_on").addClass("r_ff"); 
        $(this).attr("checked","checked"); 
        $(this).parent().removeClass("r_off").addClass("r_on").siblings().removeClass("r_on").addClass("r_off"); 
    }); 

    /* 下拉复选带树结构 */
    for( var i =0;i < $('.combo-box-check-tree').length; i++){
        var tar =  $('.combo-box-check-tree').eq(i), chooseValue = '', tip = tar.attr('tip');
        // 控制下拉的显示与隐藏
        tar.find('.combo-box-check-tree-top').click(function(){
            var dropObj = tar.find('.combo-box-check-tree-dropdown');
            dropObj.is(':visible') ? dropObj.css('display', 'none') : dropObj.css('display', 'block');
        });

        // 默认是子级元素全部呈展开状态
        tar.find('.combo-child').css('display', 'block');
        // 提示语展示
        tar.find('.fir-txt').html(tip);
        tar.find('.combo-box-check-tree-top').attr('title', tip);

        // 展开 收缩 icon 转换
        tar.find('.combo-parent-cont').click(function(){
            var isShowObj = $(this).next('.combo-child');
            if(isShowObj.is(':visible')){
                isShowObj.css('display', 'none').find('.child-mark');
                $(this).find('.child-mark').attr('class', 'parent-mark');
            }else{
                isShowObj.css('display', 'block');
                $(this).find('.parent-mark').attr('class', 'child-mark');
            }
        });
        
        // 复选框 点击事件
        tar.find('label[class^=label]').off('click').on({'click' : function(){
            chooseValue = '';
            var label = $(this);

            // checkbox效果模拟
            if(label.attr('class') == 'label-checked'){
                $(this).attr('class', 'label-uncheck');
                // 判断自己的子级是否有父级
                if($(this).parent().parent().find('.combo-parent-cont').length > 0){
                    $(this).parent().parent().find('.combo-child').find('label[class^=label]').attr('class', 'label-uncheck');
                }
            }else{
                $(this).attr('class', 'label-checked');
                if($(this).parent().parent().find('.combo-parent-cont').length > 0){
                    $(this).parent().parent().find('.combo-child').find('label[class^=label]').attr('class', 'label-checked');
                }
            }  
            
            // 选择的数据拼接
            tar.find('.label-checked').each(function()  {
                var childObj = $(this).parent().parent();
                if(childObj.find('.combo-child').length == 0){
                    chooseValue += $.trim($(this).next('span').html()) + ', ';
                }
            });
            tar.find('.fir-txt').html(chooseValue == '' ? tip : chooseValue);
            tar.find('.combo-box-check-tree-top').attr('title', chooseValue == '' ? tip : chooseValue);

            
            // 阻止冒泡至父级元素
            return false;
        }});
    }
 });

$(function(){
    // 导航
    $('#btnAllTypePro').hover(function(){
        $('#allTypeProCont').css('display', 'block');
    },function(){
        $('#allTypeProCont').css('display', 'none');
    });

    $('#allTypeProCont').hover(function(){
        $(this).css('display', 'block');
    },function(){
        $(this).css('display', 'none');
    });
    
    $('.menu-item').hover(function(){
        var self = $(this);
        if(self.find('.inner-wrap').length > 0){
            self.find('.inner-wrap').css('display', 'block');
            self.find('.mask').css('display', 'block');
            self.find('.right-mark').css('display', 'none');
        }else{
            /*self.css('border-right','1px solid #f6f6f6');*/
        }
    }, function(){
        var self = $(this);
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
            /*self.css('border-right','1px solid #f6f6f6');*/
        }
    }, function(){
        var self = $(this);
        if(self.find('.inner-wrap').length > 0){
            self.find('.inner-wrap').css('display', 'none');
            self.find('.mask').css('display', 'none');
            //self.find('.right-mark').css('display', 'block');
        }else{
            /*self.css('border-right','1px solid #184c81');*/
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
});


$(function(){
	$('.content-tab-left ul').find('li').bind('click',function(){
		var re = getClass($(this).attr('class'),'active');
		if(re){
		}else{
			var menuId = $(this).attr('menuId');
			var li = $('.content-tab-left ul').find('li[isOpen="true"]').removeClass('active').attr('isOpen','false')
			$('.content-tab-right ul').find('li[isShow="true"]').attr('isShow','false').hide();
			$('.content-tab-right ul').find('li[parentId="'+menuId+'"]').show().attr('isShow','true');
			$(this).addClass('active').attr('isOpen','true');
		}
	});
	
	$('.content-tab-left ul').find('li:first').click();
})

function getClass(str,str2){
	var result = false;
	if(str != undefined && str != ""){
		var classArr = str.split(" ");
		for ( var i in classArr) {
			var className = classArr[i];
			if (className.indexOf(str2) == 0) {
				result = true;
				break;
			}
		}
	}
	return result;
}
