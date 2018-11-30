(function($) {
	
	$.fn.exportExcel = function(options) {
		var opts = $.extend({}, $.fn.exportExcel.defaults, options);
		return this.each(function() {
			var $this = $(this);
			var o = $.meta ? $.extend({}, opts, $this.data()) : opts;
			$this.click(function(){
				$.fn.execExport(o,$this);
			});
		});
	};
	$.fn.exportExcel.defaults = {
			single 	: false
	};
	$.fn.execExport = function(opts,obj){
		var url = getRootPath() + '/export/highcharts/';
		if (!!!opts["single"]) {
			url = url + 'writeHighchartsToExcel.do';
		} else {
			url = url + 'writeBigDataToExcel.do';
		}

		if (!!!opts["bussclass"]) {
			$.messager.alert("提示信息", "请设置报表的业务处理类全名", "warning");
			return;
		}
		if (!!!opts["fileName"]) {
			$.messager.alert("提示信息", "请设置导出表格的文件名", "warning");
			return;
		}
		url = url + '?bussclass=' + opts["bussclass"] + '&fileName='
				+ opts["fileName"];
		for ( var o in opts["data"]) {
			url = url + '&' + o + '=' + opts["data"][o];
		}

		var iframe = document.createElement("iframe");

		iframe.src = url;

		var imgPath = getRootPath() + "/common/images/blue-loading.gif";

		$.blockUI( {
			message : "<img src='" + imgPath + "' /><h4>正在导出中，请稍后.... </h4>",
			css : {
				background : 'none',
				color : '#000',
				border : 'none'
			},

			overlayCSS : {
				backgroundColor : '#C5E1F0',
				opacity : '0.4'
			}

		});
		if(!!window.ActiveXObject || "ActiveXObject" in window){//ie浏览器
			if(!!!window.ActiveXObject){
				setTimeout(function(){$.unblockUI();},10000);
			}else{
				iframe.onreadystatechange = function() {
					// 文件下载是在http请求的interactive也就是浏览器交互阶段。
					if (iframe.readyState == "interactive") {
						$.unblockUI();
					}
				};
			}
		}else{//非ie浏览器
			iframe.onload = function() {
				$.unblockUI();
			};
		}
		iframe.style.display = 'none';
		document.body.appendChild(iframe);
	};
	//js获取项目根路径，如： http://localhost:8083/uimcardprj
	function getRootPath(){
	    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	    var curWwwPath=window.document.location.href;
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName=window.document.location.pathname;
	    var pos=curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083
	    var localhostPaht=curWwwPath.substring(0,pos);
	    //获取带"/"的项目名，如：/uimcardprj
	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	    return(localhostPaht+projectName);
	}
})(jQuery);
