var addTabs = function (id,title,url) {
	id="tab_"+id;
	url=urlRootContext + url;
	 $(".active").removeClass("active");
	  //如果TAB不存在，创建一个新的TAB 
		 //固定TAB中IFRAME高度
	 	    mainHeight = 550;
		    //创建新TAB的title
		    title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab">' +title;
		    title += ' <i class="icon-remove" tabclose="' + id + '"></i>';
			title += '</a></li>';
			content = '<div role="tabpanel" class="tab-pane" id="' + id + '"><iframe src="' + url + '" width="100%" height="' + mainHeight +          '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe></div>';
			//加入TABS
			 $(".nav-tabs").append(title);   
			 $(".tab-content").append(content);
			 //激活TAB
			 $("#tab_" + id).addClass('active');
			 $("#" + id).addClass("active");
};
	var closeTab = function (id) {  
	//如果关闭的是当前激活的TAB，激活他的前一个TAB  
	if ($("li.active").attr('id') == "tab_" + id) {
		$("#tab_" + id).prev().addClass('active');    
		$("#" + id).prev().addClass('active'); 
	}  
	//关闭TAB  
	$("#tab_" + id).remove();
	$("#" + id).remove();
};
	$(function () {  mainHeight = $(document.body).height() - 45;
	$('.main-left,.main-right').height(mainHeight);  $("[addtabs]").click(function () {  
		addTabs(); 
	}); 
	$(".nav-tabs").on("click", "[tabclose]", function (e) {   
		id = $(this).attr("tabclose");  
		closeTab(id);  
	});
});
	
	
	//获取当前项目的路径
	var urlRootContext = (function() {
		var strPath = window.document.location.pathname;
		var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
		return postPath;
	})();	
