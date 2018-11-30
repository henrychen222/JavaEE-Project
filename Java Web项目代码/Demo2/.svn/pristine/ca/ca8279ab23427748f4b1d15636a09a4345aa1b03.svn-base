function $getObj(id) {
	return document.getElementById(id);
}
function CommonTab(sum, obj, objG, objT, ps) {
	var g = document.getElementById(obj);
	var gG = g.getElementsByTagName(objG);
	for (var i = ps; i < gG.length; i++) {
		if (i == sum || gG[i] == sum) {
			with (gG[i]) {
				className = "down";
				style.cursor = "";
			}
			gG[i].onclick = function() {
				return false
			};
			gG[i].onmousemove = function() {
				return false
			};
			gG[i].onmouseout = function() {
				return false
			};
			if (objT != null) {
				document.getElementById(objT + i).style.display = "block";
			}
		} else {
			with (gG[i]) {
				className = "";
				style.cursor = "pointer";
			}
			gG[i].onclick = function() {
				CommonTab(this, obj, objG, objT, ps);
			};
			gG[i].onmousemove = function() {
				this.className = "move";
			};
			gG[i].onmouseout = function() {
				this.className = "";
			};
			if (objT != null) {
				document.getElementById(objT + i).style.display = "none";
			}
		}
	}
}
function CommonTabMove(sum, obj, objG, cursor, objT, objTG) {
	var cf = (cursor == 0) ? "pointer" : "";
	var g = document.getElementById(obj);
	var gG = g.getElementsByTagName(objG);
	if (objT != null && objTG != null) {
		var gT = document.getElementById(objT);
		var gTG = gT.getElementsByTagName(objTG);
	}
	for (var i = 0; i < gG.length; i++) {
		if (i == sum || gG[i] == sum) {
			with (gG[i]) {
				className = "down";
				style.cursor = cf;
			}
			gG[i].onmousemove = function() {
				return false
			};
			if (objT != null) {
				if (objTG == null) {
					document.getElementById(objT + i).style.display = "block";
				} else {
					gTG[i].style.display = "block";
				}
			}
		} else {
			with (gG[i]) {
				className = "";
				style.cursor = cf;
			}
			gG[i].onmousemove = function() {
				CommonTabMove(this, obj, objG, cursor, objT, objTG)
			};
			if (objT != null) {
				if (objTG == null) {
					document.getElementById(objT + i).style.display = "none";
				} else {
					gTG[i].style.display = "none";
				}
			}
		}
	}
}
function getBodyVal(str) {
	// 获取滚动条值, body实际宽高
	var t, l, h, w, html = $("html");
	t = html.scrollTop() == 0 ? document.body.scrollTop : html.scrollTop();
	l = html.scrollLeft() == 0 ? document.body.scrollLeft : html.scrollLeft();
	if ($.browser.msie) {
		h = html.height();
	} else {
		h = $(document).height();
	}
	w = document.body.clientWidth > html.width() ? document.body.clientWidth
			: html.width();
	w = document.body.clientHeight > html.height() ? document.body.clientWidth
			: w;
	return {
		top : t,
		left : l,
		height : h,
		width : w
	};
}
function objCenter(obj) {
	// 对象居中
	var left = $(obj).width() < $("html").width() ? -$(obj).width() / 2
			+ getBodyVal().left : -$(obj).width() / 2;
	var top = $(obj).height() < $("html").height() ? -$(obj).height() / 2
			+ getBodyVal().top : -$(obj).height() / 2;
	$(obj).css({
		marginLeft : left + "px",
		marginTop : top + "px"
	});
}
function NoticeViewerFun(t, g, tit) {
	// 左下提示信息
	var obj = $(g), em = $(t + " a em"), sp = $(t + " a span");
	if (obj.is(':visible')) {
		obj.slideUp(350);
		sp.html("点击展开" + tit);
		em.removeClass("Arrow1Down");
	} else {
		obj.slideDown(350).show();
		sp.html("点击收缩" + tit);
		em.addClass("Arrow1Down");
	}
}
function NoticeViewerFun_rt(t, g) {
	// 右上提示信息
	var obj = $(g), em = $(t);
	if (obj.is(':visible')) {
		em.css({
			display : "block"
		});
		obj.slideUp(350);
	} else {
		em.css({
			display : "none"
		});
		obj.slideDown(350).show();
	}
}
function StretchShrink(obj) {
	// 遍历所有伸展收缩
	$(obj).each(function(i) {
		var g = $(this).children(".Shrink_G");
		if ($(this).children(".Shrink_T").attr("class").indexOf("show") > 0) {
			$(this).children(".Shrink_G").css({
				display : "block"
			});
		}
		$(this).children(".Shrink_T").click(function() {
			if (g.is(':visible')) {
				g.slideUp('fast');
				$(this).removeClass("Shrink_T_show");
			} else {
				g.slideDown('fast').show();
				$(this).addClass("Shrink_T_show");
			}
		});
	});
}
function dialogWinFun(obj, tit, w, h, c, sty) {
	// obj对象,tit标题,w宽,h高,c另加关闭按钮对象,sty风格
	var clan = "DialogBox";
	if (sty == "win") {
		clan = "LayerWindow";
	}
	$(obj).attr("title", tit);
	$(obj).hide();
	$(obj).dialogWin({
		resizable : false,
		modal : true,
		width : w,
		height : h,
		className : clan,
		closeBut : c
	/* 给需要用到的关闭按钮设置关闭操作 */
	});
}
function pageFun() {
	// 滚动与放大缩小窗口触发此处函数
	if ($(".leftMenuID").length > 0) {
		$(".leftMenuID").css(
				{
					height : getBodyVal().height - $(".WrapHead").height()
							- $(".Footer").height() + "px"
				});
	}
	if ($(".goTopBut").length > 0) {
		if (getBodyVal().top > 20) {
			$(".goTopBut").css({
				display : "block"
			});
			if ($(".Footer").length > 0) {
				$(".goTopBut").css({
					bottom : $(".Footer").outerHeight() + "px"
				});
			}
		} else {
			$(".goTopBut").css({
				display : "none"
			});
		}
	}
	/*
	 * if($(".Head .bgRight").length>0){ //动态固定头部右块 $(".Head
	 * .bgRight").css({marginLeft:getBodyVal().left+"px"}); }
	 */
}
$(function() {
	pageFun();/* 加载初始 */
	window.onresize = function() {
		pageFun();
	};
	window.onscroll = function() {
		pageFun();
	};

	// 设置最小宽度
	if ($(".WrapHead").length > 0) {
		$("html").css({
			minWidth : "1000px"
		});
		$(".WrapHead_height").css({
			height : $(".WrapHead").outerHeight() + "px"
		});
	}
	// 菜单
	if ($(".WrapMenu").length > 0) {
		initMenu();
		var headMenuFun = new SellerScroll("#headMenuObj");
	} else {
		$("body").addClass("Popup");
		$("body")
				.append(
						"<a class='goTopBut' href='javascript:;' onclick='$(\"html\").scrollTop(0);$(\"body\").scrollTop(0);'></a>");
	}
	// 公告提示
	if ($(".NoticeGongG_T").length > 0) {
		function NoticeLink_Fun() {
			clearTimeout(NoticeLink_Time);
			NoticeViewerFun(".NoticeGongG_T", ".NoticeGongG_G", "公告");
		}
		NoticeLink_Fun();
		$(".NoticeGongG_T a").click(function() {
			NoticeLink_Fun();
		});
		var NoticeLink_Time = setTimeout(function() {
			NoticeLink_Fun();
		}, 4000);
	}
	// 错误提示
	if ($(".NoticeError_T").length > 0) {
		function NoticeError_T_Fun() {
			NoticeViewerFun(".NoticeError_T", ".NoticeError_G", "错误提醒");
		}
		NoticeError_T_Fun();
		$(".NoticeError_T a").click(function() {
			NoticeError_T_Fun();
		});
		$(".NoticeError_G .m b a").click(function() {
			NoticeError_T_Fun();
		});
	}
	// 错误提示_右上
	if ($(".NoticeError_T_rt").length > 0) {
		function NoticeError_T_Fun_rt() {
			NoticeViewerFun_rt(".NoticeError_T_rt", ".NoticeError_G_rt");
		}
		NoticeError_T_Fun_rt();
		$(".NoticeError_T_rt").click(function() {
			NoticeError_T_Fun_rt();
		});
		$(".NoticeError_G_rt .m b a").click(function() {
			NoticeError_T_Fun_rt();
		});
		$(".NoticeError_G_rt .up").click(function() {
			NoticeError_T_Fun_rt();
		});
	}
	// 左侧菜单显示隐藏
	if ($(".DragBar").length > 0) {
		$(".DragBar").click(function() {
			if ($(".WrapMiddle_L").is(':visible')) {
				$(".WrapMiddle_L").slideUp('fast');
				$(this).attr({
					title : "展开左侧菜单"
				});
				$(".DragBar b").addClass("toRight");
			} else {
				$(".WrapMiddle_L").slideDown('fast').show();
				$(this).attr({
					title : "收缩左侧菜单"
				});
				$(".DragBar b").removeClass("toRight");
			}
		});
	}
	// 输入框提示
	if ($(".txtPoint").length > 0) {
		$(".txtPoint").each(function(i) {
			$(this).attr({
				value : $(this).attr("alt")
			});
			$(this).focus(function() {
				$(this).removeClass("txtPoint");
				if (this.value == this.alt) {
					this.value = '';
				}
			});
			$(this).blur(function() {
				if (this.value == '') {
					this.value = this.alt;
					$(this).addClass("txtPoint");
				}
			});
		});
	}
	// 内页标签切换
	// if($("#tabT_obj").length>0){ new
	// CommonTab(0,"tabT_obj","li","tabG_obj_",0); }
	if ($("#tabs").length > 0) {
		$("#tabs").tabs();
	}

	if ($(".GRID").length > 0) {
		$(".GRID tr").each(function(i) {
			if (i % 2 == 0 && i != 0) {
				$(this).addClass("color");
			}
			if ($(this).attr("class") != "none") {
				$(this).hover(function(e) {
					$(this).addClass("move");
				}, function(e) {
					$(this).removeClass("move");
				});
			}
		});
	}

	// 收缩内容
	if ($(".ShrinkObj").length > 0) {
		StretchShrink(".ShrinkObj");
	}

	if ($.browser.msie && $.browser.version.substr(0, 1) == "6") {
		$("body").supersleight({
			shim : "style/images/transparent.gif"
		});
		$("input[type=text]").addClass("inputTxt");
		$(".Search input[type=text]").addClass("SearInputTxt");
		// $(".Footer").css({marginTop:getBodyVal().top+"px"});
	}
});

var menuIDArry = menuTimeArry = "";
function showHideMenu(obj, bool) {
	var n = lv2 = null, s = obj.attr("id");
	clearTimeout(menuTimeArry);
	if (s.indexOf("menu_lv1_") >= 0) {
		n = s.replace("menu_lv1_", "");
		lv2 = $("#menu_lv2_" + n);
		if (bool) {
			obj.addClass("move");
			if (lv2.children("li").length > 0) {
				// 执行二级菜单显示，提示：可放到另一个函数里执行，但对象要对
				lv2.slideDown('fast').show();
				lv2.css({
					left : obj.offset().left + "px",
					top : $(".WrapHead .Head").outerHeight()
							+ $(".WrapHead .WrapMenu").outerHeight() + "px",
					display : "block"
				});
				if (lv2.width() == 800) {
					lv2.css({
						width : "160px"
					});
					// 设置二级菜单总宽
					// var w=0;
					lv2.children("li").each(function() {
						// w += $(this).outerWidth(true);
						// 有子菜单就加箭头
						if ($(this).children("ul.lv3").length > 0) {
							$(this).addClass("jt");
						}
					});
					// lv2.css({width:w+"px"});
					// 设置二级菜单悬浮动作
					lv2.hover(function(e) {
						clearTimeout(menuTimeArry);
					}, function(e) {
						allTowMenuHide();
					});
					// 设置三级菜单滑动
					lv2.children("li").hover(function(e) {
						$(this).children(".lv3").slideDown('fast').show();
					}, function(e) {
						$(this).children(".lv3").hide();
						// $(this).children(".lv3").slideUp('fast');
					});
				}
				if (lv2.offset().left + lv2.width() > getBodyVal().width) {
					var l = lv2.offset().left
							- (lv2.offset().left + lv2.width() - getBodyVal().width);
					l = l <= 0 ? 0 : l;
					lv2.css({
						left : l + "px"
					});
				}
				// end
			} else {
				// 当没有载入二级菜单时显示loading
				// lv2.css({width:"100px", left:obj.offset().left+"px",
				// top:obj.offset().top+31+"px", display:"block"});
				lv2.css({
					left : obj.offset().left + "px",
					top : obj.offset().top + 31 + "px",
					display : "block"
				});
				lv2
						.html('<li><a href="#"><b><i>菜单二级菜单二级</i></b></a><ul class="lv3"><li class="up"></li><li><a href="#"><b><i>菜单三级</i></b></a></li><li class="cur"><a href="#"><b><i>菜单三级</i></b></a></li><li><a href="#"><b><i>菜单三级</i></b></a></li><li class="bottom"></li></ul></li><li><a href="#"><b><i>菜单二级</i></b></a></li><li class="bottom"></li>');
				// lv2.css({width:"3000px"});
				showHideMenu(obj, bool);
			}
		} else {
			obj.removeClass("move");
			lv2.slideUp('fast');
			// lv2.css({left:"", top:"", display:""});
		}
	}
}
function allTowMenuHide() {
	$(".menu_lv2_Obj .lv2").each(function() {
		// 隐藏显示的二级菜单
		if ($(this).is(':visible')) {
			var n = lv1 = null, s = $(this).attr("id");
			if (s.indexOf("menu_lv2_") >= 0) {
				n = s.replace("menu_lv2_", "");
				lv1 = $("#menu_lv1_" + n);
				lv1.removeClass("move");
			}
			// $(this).slideUp('fast');
			$(this).css({
				left : "",
				top : "",
				display : ""
			});
		}
	});
}
function WrapMenuFun() {
	// 菜单
	$(".menu_lv1_Obj .lv1").each(
			function() {
				// 设置一级菜单总宽
				var w = j = 0;
				$(this).children("li").each(
						function() {
							if ($(this).attr("id") != ""
									&& $(this).attr("id") != null
									&& $(this).attr("id") != "unbefined") {
								$(this).addClass("jt");
							}
							w += $(this).outerWidth(true);
							j++;
						});
				$(this).css({
					width : w + "px"
				});
				menuIDArry = new Array(j);
			});
	$(".menu_lv1_Obj .lv1 li").hover(function(e) {
		allTowMenuHide();
		showHideMenu($(this), true);
	}, function(e) {
		// 设置微秒后执行隐藏
		var n = null, s = $(this).attr("id");
		if (s.indexOf("menu_lv1_") >= 0) {
			n = s.replace("menu_lv1_", "");
			menuIDArry[parseInt(n)] = $(this);
			menuTimeArry = setTimeout(function() {
				showHideMenu(menuIDArry[n], false);
			}, 1);
		}
	});
}

/**
 * 获取菜单数据，并触发菜单渲染过程。
 * 
 * @author:wangyan
 */
function initMenu() {
	var prepareData = function(data) {
		data = $.parseJSON(data);
		var level1 = $("<ul class='lv1'></ul>");
		var level2Wrap = $("<div></div>");
		var index = 0;
		for ( var i in data) {
			var menu = data[i];
			// level 1
			if (menu.menuTypeCd == 1) {
				level1.append("<li id='menu_lv1_" + index
						+ "'><a href='javascript:void(0);'><b><i>" + menu.title
						+ "</i></b></a></li>");
			}
			// level 2
			var level2 = $("<ul class='lv2' id='menu_lv2_" + index + "'></ul>");
			// has no level2
			if (menu.children.length == 0) {
				level2.html("<div class='loading'></div>");
			} else {
				// has level2
				level2.append("<li class='up'></li>");
				for ( var i in menu.children) {
					var menu2 = menu.children[i];

					var level3Wrap = $("<li><a href='javascript:void(0);'><b><i>"
							+ menu2.title + "</i></b></a>");
					if (menu2.children.length > 0) {
						var level3 = $("<ul class='lv3'><li class='up'></li></ul>");
						for ( var i in menu2.children) {
							var menu3 = menu2.children[i];
							if (menu3.title == '信息变更申请') {
								level3
										.append("<li><a href='javascript:void(0);' "
												+ "onclick='openDialog(\""
												+ contextPath
												+ "/"
												+ menu3.uri
												+ "\");'><b><i>"
												+ menu3.title
												+ "</i></b></a></li>");
							} else {

								level3
										.append("<li><a href='javascript:void(0);' "
												+ "onclick='jumpPage(\""
												+ contextPath
												+ "/"
												+ menu3.uri
												+ "\");'><b><i>"
												+ menu3.title
												+ "</i></b></a></li>");
							}
						}
						level3.append("<li class='bottom'></li>");
						level3Wrap.append(level3);
					}
					level2.append(level3Wrap);
				}
				level2.append("<li class='bottom'></li>");
			}
			level2Wrap.append(level2);
			++index;
		}
		$("#menuLevel1").html(level1);
		$("#menuLevel2").html(level2Wrap);
		WrapMenuFun();
	};
	$.get(contextPath + "/login/getMenusJson.do", prepareData);
}

function jumpPage(url,pageName,type,fn) {
	var pageExists=$('#easyuiTabs').tabs('exists',pageName);
	//$("#iframeContent").attr("src", url);
	if(pageExists){
		$('#easyuiTabs').tabs('select',pageName);
		if(type==1){
			var tab = $('#easyuiTabs').tabs('getSelected');  // get selected panel
			$('iframe[data-name="'+pageName+'"]')[0].contentWindow.location.href=url;
		}
	}else{
		var tabhtml="<iframe id='frame_"+pageName+"' src='' data-name='"+pageName+"'"+
		"scrolling='auto' width='100%' style='height:100%' frameborder='0' marginwidth='0' marginheight='0' ></iframe>";
		$('#easyuiTabs').tabs('add',{
		    title: pageName,
		    content: tabhtml,
		    tools:[{
		        iconCls:'icon-mini-refresh',
		        handler:function(){
		        	$('iframe[data-name="'+pageName+'"]')[0].contentWindow.location.href=url;
		        }
		    }],
		    closable:true,
		    bodyCls:'noScroll'
		});
		//修改关闭询价单时出现flash_removeBack的错误 begin
		$('#easyuiTabs').tabs({
			  onBeforeClose: function(title,index){
					$("#frame_"+title).contents().find("body").empty();
					return true;
			  }
			});
		//修改关闭询价单时出现flash_removeBack的错误 end
		$('#easyuiTabs').tabs({
			  onClose: function(title,index){
				  index--;
				  $('#easyuiTabs').tabs('select',(index--));
				  if(!!fn){
					fn();
				  }
			  }
		});
		
		jumpPage(url,pageName,1,fn);
	}
}

function openDialog(url) {
	url = url.replace('page', 'insert');
	$.messager.confirm('申请变更提示', '是否确定变更!', function(bool) {
		if (bool) {
			$.ajax({
				url : window.ctxPath + '/jhInformationChange/insert.do',
				type : 'post',
				dataType : 'text',
				async : true,
				success : function(data) {
					$.messager.alert('申请变更提示', '已提交申请！', 'info');
				}
			})
		}
	})
}




function jumpPageRefresh(url,pageName) {
	var pageExists=$('#easyuiTabs').tabs('exists',pageName);
	if(pageExists){
		$('#easyuiTabs').tabs('select',pageName);
		var tab = $('#easyuiTabs').tabs('getSelected');  // get selected panel
		tab.tabs('refresh');
		//$('iframe[data-name="'+pageName+'"]')[0].contentWindow.location.href=url;
	}else{
		var tabhtml="<iframe id='frame_"+pageName+"' src='"+url+"' data-name='"+pageName+"'"+
		"scrolling='auto' width='100%' style='height:100%' frameborder='0' marginwidth='0' marginheight='0' ></iframe></div>"
		$('#easyuiTabs').tabs('add',{
		    title: pageName,
		    content: tabhtml,
		    tools:[{
		        iconCls:'icon-mini-refresh',
		        handler:function(){
		        	$('iframe[data-name="'+pageName+'"]')[0].contentWindow.location.href=url;
		        }
		    }],
		    closable:true,
		    bodyCls:'noScroll'
		});
	}
}

/**
 * 关闭当前tab
 * @return
 */
function tbclose(){
	$('#easyuiTabs').tabs('close',$('#easyuiTabs').find(".tabs-selected").find(".tabs-title").text());
}
