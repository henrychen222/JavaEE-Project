
/*
 *AJDX调用后面的方法
 */
function Tool_Ajax(url,param,dataType)
{ 
	var resultData;
	var _dataType = dataType || "text";
	url += url.indexOf("?")>-1?"&":"?";
	$.ajax({
		   async: false, 
		   type: "post",
		   url: url + Math.random(),
		   data: param,
		   dataType: _dataType,
		   success:function(data){
		   		resultData=data;
		   },
		   error: function (XMLHttpRequest, textStatus, errorThrown) {
	          $.messager.alert("错误","ajax请求错误："+textStatus,"error");
	       }
	});
	return resultData;
}
function toSubstr(value){
	if(value !=null&&value.length>=20){
		var content = value.substring(0,20);
		return "<a title='"+value+"'>"+content+"...</a>";
	}else{
		return  "<a title='"+value+"'>"+value+"</a>";;
	}
}

function fixWidth(percent) {
	return document.body.clientWidth * percent;
}
/**异步ajax*/
function Tool_Ajax_Async(url,param,dataType){
	dataType = dataType || "text";
	url += url.indexOf("?")>-1?"&":"?";
	var AjaxO = $.ajax({
			   async: true, 
			   type: "post",
			   url: url + Math.random(),
			   data: param,
			   dataType: dataType,
			   error: function (err) {
		            $.messager.alert("错误",err,"error");
		       }
			});
	return AjaxO;
}


/**************************非空验证********************************************/
//验证字符串是否为空
String.prototype.isEmpty = function()
{

	if (this == null || this == "" || this == "undefined" || this.Trim() == "" || this.Trim().length == 0)
	{
		return false;
	}
	return true;
};
// 去掉字符串两端空格
String.prototype.Trim = function()
{

	return this.replace(/(^\s*)|(\s*$)/g, "");
};
// 去掉字符串左端空格
String.prototype.LTrim = function()
{

	return this.replace(/(^\s*)/g, "");
};
// 去掉字符串右端空格
String.prototype.RTrim = function()
{
		return this.replace(/(\s*$)/g, "");
};
//判断字符串对象是否为null
function isStringNull(pram)
{
	if (isNull(pram) && (pram + '').isEmpty() && (pram + '').Trim() != 'null' && (pram + '').Trim() != 'NULL' && (pram + '').Trim() != 'undefined')
	{
		return true;
	}
	return false;
}

//判断对象是否为null
function isNull(pram)
{

	if (typeof(pram) == "undefined" || pram == null)
	{
		return false;
	}
	return true;
}


/**************REDIS数据处理*********************/
/**
 * 根据redis取出的json数组进行转换成一个新的json对象
 * @param arr 从redis获取的数组
 */
function redisArrToJson(arr){
	var jsonStr="";
	if(isNull(arr) && arr!=""){
		if(typeof(arr)=="string")
			arr = $.parseJSON(arr);
		var jsonObj;
		for(var i=0;i<arr.length;i++){
			jsonObj = arr[i];
			if(jsonObj!=null){
				if(jsonStr=="")
					jsonStr +="\""+jsonObj["key"]+"\":\""+jsonObj["value"]+"\"";
				else
					jsonStr +=","+ "\""+jsonObj["key"]+"\":\""+jsonObj["value"]+"\"";
			}
		}
	}
	return $.parseJSON("{"+jsonStr+"}");
}

/**
*combobox自动选中 或虽入请选择
*@param id combobox的id
*@param strArr JSON数组字符串
*@param 要选中的key值 可选
*/
function setSelectCombo(id,strArr,key){
	if(!isStringNull(key)){//为空默认加上请选择
		analyRedisArrayData(id,strArr);
		return;
	}
	var data=[];
	data.push({"value":"请选择","key":""});
	if(isStringNull(strArr)&&strArr!="[]"){
		var jsonArray=$.parseJSON(strArr);
		for(var i=0; i<jsonArray.length; i++){
			if(jsonArray[i].key==key){
				jsonArray[i].selected=true;
			}
			data.push(jsonArray[i]);
		}
	}
	$("#" +id).combobox({
		data:data,
		valueField:'key',
		textField:'value',
		panelHeight:'auto',
		editable:false
	});
}
/**<input id="dd" class ="easyui-combobox">
 *combobox自动选中 扩展
 * json {id:combobox的id,data:加载的数组,dataStr:加载的数组字符串,selectedKey:被选中的键,key:key键的对应,
 * 			value:value键的对应,name:初始化的名称,onSelect:选中的参数,joinable:是否加入请选选择默认true}
 */
function setSelectComboEx(json){
	//默认值的设定
	if(!json.key)
		json.key="key";
	if(!json.value)
		json.value="value";
	if(!json.name)
		json.name="请选择";
	var data=[];
	//默认加入空值域
	if(!isNull(json.joinable) || json.joinable){
		var defaultJson ="{\"" +json.value +"\":\""+json.name+"\",\""+json.key+"\":\"\"}";
		data.push($.parseJSON(defaultJson));
	}
	//数据源获取
	var jsonArray = json.data
	if(!jsonArray){
		jsonArray = $.parseJSON(json.dataStr);
	}
	var len = jsonArray.length;
	//传入设定的selectedKey自动选中，否则选择空的那个
	if(json.selectedKey){
		for(var i=0; i<len; i++){
			if(jsonArray[i][json.key]==json.selectedKey){
				jsonArray[i].selected=true;
			}
			data.push(jsonArray[i]);
		}
	}else{
		for(var i=0; i<len; i++){
			data.push(jsonArray[i]);
		}
		if(len==1){
			data[1].selected=true;
		}else{
			data[0].selected=true;
		}
			
	}
	//设定
	$("#" +json.id).combobox({
		data:data,
		valueField:json.key,
		textField:json.value,
		panelHeight:'auto',
		editable:false,
		onSelect:json.onSelect,
		multiple:json.multiple
	});
}


/**绑定计数与自动增长
 * textarea里加入maxlength属性
 * 
 * */
function bindTextare(){
	$("textarea").css("overflow","hidden");
	$("textarea").each(function(){
		//此处不能通用，根据不同页面进行调整
		if($(this).prev()[0].tagName=="TD"){
			if($(this).parent().siblings().find('em').length==0){
				$(this).parent().siblings().append("<br><span class='spnsty'>(剩余<em>"+$(this).attr("maxlength")+"</em>字)</span>");
			}
		}
		else{
			if($(this).prev().find('em').length==0){
				$(this).prev().append("<br><span class='spnsty'>(剩余<em>"+$(this).attr("maxlength")+"</em>字)</span>");
			}
		}
	});
	$("textarea").bind("keydown keyup input",function(event){
    	var height = this.scrollHeight>38?this.scrollHeight:38;
    	this.style.height=height + 'px';
    	var textarea = $(this);
    	var em = textarea.parent().find("em");
    	var len =textarea.val().length;
    	var lens = textarea.attr("maxlength")*1;
    	var remain = lens - len;
    	//文字超出
    	if(remain<0){
    		var content = textarea.val().substring(0,lens);
    		textarea.val(content);
    	}else{
    		$(em).text(remain);
    	}
    });
}


/**********自定义alert**********/
function myAlert(alertContent,type){
	if(!type)
		type="info";
	$.messager.alert("提示",alertContent,type);
}

/*************解决公用div弹出样式问题******************/
/**
 * 动态加入样式文件
 */
function addCSS(path) {
    var link = document.createElement('link');
    link.type = 'text/css';
    link.rel = 'stylesheet';
    link.href = curProjectUrl + path;
    //document.getElementsByTagName("head")[0].appendChild(link);
    $("head").append(link);
}

/**
 * 获取URL参数值 url ：URL name ：参数名
 */
function Page_GetUrlParamValue(url, name)
{

	if (url == null || url == "")
	{
		msg_error_debug = "Page_GetUrlParamValue函数的第一个参数为空!";
		return null;
	}
	if (name == null || name == "")
	{
		msg_error_debug = "Page_GetUrlParamValue函数的第二个参数为空!";
		return null;
	}

	var s = unescape(url);
	var reg = new RegExp("&?" + name + "=([^&]*)", "i");
	var arr = s.match(reg);
	if (arr == null)
		return null;
	else
		return arr[1];
}

//找开窗口
function openWin(json){
	var id = json.id;
	if(!isStringNull(id)){
		myAlert("传入参数不正确");
	}
	if(document.getElementById(id))
		$("#"+id).remove();
	//动态添加一个DIV  <div id="selUserWin"></div>
	$("body").append("<div id='"+id+"' style='overflow:hidde;'></div>");
	var url = json.url;
	url += url.indexOf("?")>0?"&winid="+id:"?winid="+id;
	$('#'+id).window({
		href:url,
		title:json.title,
  		top:10,
	    width:json.width,  
	    height:json.height,  
	    zIndex:5,
	    collapsible:false,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    draggable:false,
	    shadow:false,
	    cache:false,
	    modal:true,
	    onClose:function(){
	    },
	    onLoad:function(){
	    	if(json.position){//绝对定位
	    		$(".window").css("position","fixed");
	    	}else{
	    		//根据页面相对定位
		    	var top = $(document).scrollTop(); 
		    	var left = $(document).scrollLeft(); 
		    	$("#"+id).parent().css({"top":top+"px"});
		    	$(".window-shadow").css({"top":top+"px"});
	    	}
	    	$.parser.parse($("#lkjh").parent());
	    }
	});
}


var paramsG;
/**
 * 其它文档
 * @param params {bookmarks：模版标签赋值变量,callback:回调}
 */
function com_otherDoc(params){
	paramsG = params;
	var width = 1000;//window.screen.width-300; //窗口宽度
	var height = window.screen.height-200; //窗口高度
	var resizable = "No"; //是否可调整大小
	var wtop=(window.screen.height-height)/2;
	var wleft=(window.screen.width-width)/2;
	var url = curProjectUrl + "/template/otherDocCom.do?&height="+height+"&width="+width;
	window.open(url,"其它文档","height=" + height + ",width=" + width + ", resizable="+ resizable +",status=yes,center=yes,top=" + wtop + ",left=" + wleft);

}