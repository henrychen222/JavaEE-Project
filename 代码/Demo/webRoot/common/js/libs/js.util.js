/**
 * JS实现Map功能 get、set、remove、isEmpty、size等方法
 * @returns {Map}
 * 
 * @author 罗伟
 */
function Map() {
	var struct = function(key, value) {
		this.key = key;
		this.value = value;
	}
	 
	var put = function(key, value){
		for (var i = 0; i < this.arr.length; i++) {
			if ( this.arr[i].key === key ) {
			this.arr[i].value = value;
			return;
			}
		}
		this.arr[this.arr.length] = new struct(key, value);
	}
		 
	var get = function(key) {
		for (var i = 0; i < this.arr.length; i++) {
			if ( this.arr[i].key === key ) {
				return this.arr[i].value;
			}
		}
		return null;
	}
		 
	var remove = function(key) {
		var v;
		for (var i = 0; i < this.arr.length; i++) {
			v = this.arr.pop();
			if ( v.key === key ) {
				continue;
			}
			this.arr.unshift(v);
		}
	}
		 
	var size = function() {
		return this.arr.length;
	}
		 
	var isEmpty = function() {
		return this.arr.length <= 0;
	} 
	
	this.arr = new Array();
	this.get = get;
	this.put = put;
	this.remove = remove;
	this.size = size;
	this.isEmpty = isEmpty;
}

/**
 * 动态组装JSON格式的字符串
 * @param array 存放JSON的key值
 * @param map 存放JSON的key和value键值对
 * 
 * @returns String to JSON
 * 
 * @author 罗伟
 */
function toJsonStr(array, map) {
	
	if(null==array || null==map){
		return;
	}
	
	var strs="";
	
	for(var i=0; i<array.length; i++){
		strs+=
			'"'+array[i]+'"' +':'+ '"'+(null!=map.get(array[i])?map.get(array[i]):"")+'"' + ',';
	}
	
	if(strs.length>0)
		strs=strs.substring(0, strs.length-1);
	
	return "{"+strs+"}";
}

/**
 * 复选框 公共方法
 * 
 * @param allname 全选name属性值
 * @param oncename 单选name属性值
 * 
 * @author 罗伟
 */
function selectAll(allname,oncename){
	
	var obj=document.getElementsByName(allname)[0];
	
	if($(obj).attr("checked")){
		$("input[name='"+oncename+"']").each(function(){
			$(this).attr("checked",true);
		});
	}else{
		$("input[name='"+oncename+"']").each(function(){
			$(this).attr("checked",false);
		});
	}
}

/**
 * 复选框单选事件
 * 
 * @param obj 点击对象
 * @param allname 全选name属性值
 * @param oncename 单选name属性值
 * 
 * @author 罗伟
 */
function selected(obj, allname, oncename){
	
	var obje=document.getElementsByName(allname)[0];
	
	var i=0;
	
	if($(obj).attr("checked")){
		$("input[name='"+oncename+"']").each(function(){
			if(!$(this).attr("checked")){
				i++;
			}
		});
		if(i==0) 
			$(obje).attr("checked",true);
	}else{
		$(obje).attr("checked",false);
	}
}

/**
 * 将数值四舍五入(保留2位小数)后格式化成金额形式
 *
 * @param num 数值(Number或者String)
 * @return 金额格式的字符串,如'1,234,567.45'
 * @type String
 * 
 * @author 罗伟
 */
function formatCurrency(num) {
	if(null==num || ""==$.trim(num)) num="0";
    num = num.toString().replace(/\$|\,/g,'');
    
    if(isNaN(num))
    	num = "0";
    
    sign = (num == (num = Math.abs(num)));
    
    num = Math.floor(num*100+0.50000000001);
    
    cents = num%100;
    
    num = Math.floor(num/100).toString();
    
    if(cents<10)
    	cents = "0" + cents;
    
    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
    	num = num.substring(0,num.length-(4*i+3))+','+num.substring(num.length-(4*i+3));
    	
    return (((sign)?'':'-') + num + '.' + cents);
}

/**
 * 设置select选中值
 * 
 * @param id 待要选中select标签的ID
 * @param key 选中的值 option中的value值
 * @param redisKey redis中配置的key
 * 
 * @author luowei
 */
function setSelectedData(id, key, redisKey){
	
	var jsonObject=getRedisData(redisKey);
	var jsonstr="";
	
	if(null!=jsonObject){
		var jsonArray=null;
		jsonArray=jsonObject[redisKey];
		if(null!=jsonArray){
			
			var j=0;
			var strs="";
			
			jsonArray=$.parseJSON(jsonArray);
			
			for(var i=0; i<jsonArray.length; i++){
				if(jsonArray[i].key!=key){
					strs+=
						'{"value":"'+jsonArray[i].value+'","key":"'+jsonArray[i].key+'"},'
				}else{
					j++;
					strs+=
						'{"value":"'+jsonArray[i].value+'","key":"'+jsonArray[i].key+'","selected":true},'
				}
			}
			
			if(j>0 && strs.length>0){
				jsonstr='[{"value":"请选择","key":""},'+strs.substring(0, strs.length-1)+']';
			}else if(j==0 && strs.length>0){
				jsonstr='[{"value":"请选择","key":"","selected":true},'+strs.substring(0, strs.length-1)+']';
			}else if(j==0 && strs.length==0){
				jsonstr='[{"value":"请选择","key":"","selected":true}]';
			}else{
				jsonstr='[{"value":"请选择","key":"","selected":true}]';
			}
		}
	}else{
		jsonstr='[{"value":"请选择","key":"","selected":true}]';
	}
	
	$("#" +id).combobox({
		data:$.parseJSON(jsonstr),
		valueField:'key',
		textField:'value',
		panelHeight:'auto',
		editable:false
	});
}

/**
 * 解析redis数组
 * 
 * @param array1 存放待要初始化的select标签的id
 * @param array2 存放业务key 这里的key用来查询redis对应的value值
 * @param jsonObject 
 * 
 * @author 罗伟
 */
function preAnalyRedisArrayData(array1, array2, jsonObject, globle){
	if(null!=array1 && null!=array2 && null!=jsonObject){
		for(var i=0; i<array1.length; i++){
			if(array2[i]==undefined){
				analyRedisArrayData(array1[i], jsonObject[array2[0]], globle);
			}else{
				analyRedisArrayData(array1[i], jsonObject[array2[i]], globle);
			}
			
		}
	}
}

/**
 * @param id id值
 * @param jsonArray 数组 实际是String 需要转换成json数组
 * 
 * @author 罗伟
 */
function analyRedisArrayData(id, jsonArray, globle){
	var showNull='y';
	var initname="请选择";
	if(globle){
		initname=globle.name;	
		showNull=globle.showNull;
	}
	
	var strs='[{"value":"'+initname+'","key":"","selected":true}';
	
	if('n'==showNull){
		strs='[';
	}
	
	if(jsonArray!=""){//处理redis停止页面报错
		if('[]'!=$.trim(jsonArray)&&strs!='['){
			strs += ",";
		}
		jsonArray=jsonArray.replace("[", strs);
	}else{
		jsonArray = strs+"]";
	}
	$("#" +id).combobox({
		data:$.parseJSON(jsonArray),
		valueField:'key',
		textField:'value',
		panelHeight:'auto',
		editable:false
	});
}

/**
 * @param keystrs key拼接的字符串
 * @param idstr 标签id拼接的字符串
 * @param jsonObj json
 * @param globle json格式 形如{name:'xxx',...} 扩展参数 设置显示名称 
 */
function analyRedisData(keystrs, idstr, jsonObj, globle){
	preAnalyRedisArrayData(idstr.split(","), keystrs.split(","), jsonObj, globle);
}

/**
 * redis中键值映射
 * 
 * @param code 
 * @param type
 * @param json_object
 * @returns
 */
function keyTransValue(code, type, json_object){
	var obj=null;
	var value="";
	if(null!=json_object){
		obj=json_object[$.trim(type)];
	}
	
	if(null!=obj){
		obj =$.parseJSON(obj);
		if(null!=obj){
			for(var i=0; i<obj.length; i++){
				if(obj[i].key==code){
					value=obj[i].value;
					break;
				}
			}
		}
	}
	return ""!=value?value:code;
}

/**
 * redis中键值转换 
 * @param key 就是key value键值对中的key
 * @param redisKey redis业务配置的key
 */
function keyTransValueByRedisKey(code, type){
	json_object=getRedisData(type);
	var obj=null;
	var value="";
	if(null!=json_object){
		obj=json_object[$.trim(type)];
	}
	
	if(null!=obj){
		obj =$.parseJSON(obj);
		if(null!=obj){
			for(var i=0; i<obj.length; i++){
				if(obj[i].key==code){
					value=obj[i].value;
					break;
				}
			}
		}
	}
	return ""!=value?value:code;
}


var extendG;//公用选人页面的扩展参数
var selRowsG;//选中的人
var backFunNameG;
/**
  *选择用户公用页面 wangh
  *@param nameId 页面显示值的标签ID
  *@param keyId 页面隐藏值的标签ID
  *@param isSingle 单选 ：Y/y  多选:N/n 默认单选(可选)
  *@param orgId 组织Id  默认是当前登陆用户的组织(可选)
  *@param backFunName 执行关闭时的回调整函数名 //入参为当前选中行对象
  *@param extend     扩展控制json对象{filter:"用户id(多个用英文逗号分隔)"}
  *  loadUserOrgId:指定加载右则用户机构
*/
function comSelectUser(nameId,keyId,isSingle,orgId,backFunName,extend){
	if(document.getElementById("commUserWin"))
		$("#commUserWin").remove();
	//动态添加一个DIV  <div id="selUserWin"></div>
	$("body").append("<div id='commUserWin' style='overflow:hidde;'></div>");
	//默认项的设置
	if(typeof (orgId) == "undefined")
		orgId='';
	if(typeof (isSingle)=="undefined" || $.trim(isSingle)=="")
		isSingle="y";
	if(!document.getElementById(nameId)){
		$.messager.alert('提示','参数不正确：id为'+nameId+'的标签对象不存在！','error');
		return;
	}
	
	$("#"+nameId).blur();//失去焦点
	if(!document.getElementById(keyId)){
		$.messager.alert('提示','参数不正确：id为'+keyId+'的标签对象不存在！','error');
		return;
	}
	if(isNull(extend))
		extendG = extend;
	//获取项目的绝对路径
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	var urlTo =projectName+'/user/selectUser.do?keyId='+keyId+'&nameId='+nameId+'&orgId='+orgId+'&isSingle='+isSingle;
	if(typeof backFunName === 'function')
		backFunNameG = backFunName;
	$('#commUserWin').window({
		href:urlTo,
		title:"选择用户",
  		top:10,
	    width:720,  
	    height:510,  
	    zIndex:5,
	    collapsible:false,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    draggable:false,
	    cache:false,
	    modal:true,
	    onClose:function(){
	    },
	    onLoad:function(){
	    	//$(".window").css("position","fixed");//绝对定位
	    	//根据页面相对定位
	    	var top = $(document).scrollTop(); 
	    	var left = $(document).scrollLeft(); 
	    	$("#commUserWin").parent().css({"top":top+"px"});
	    	$(".window-shadow").css({"top":top+"px"});
	    }
	});
}

/**
 *选择机构公用页面 wangh
 *@param id 显示值的标签id   取机构尖id 属性 orgId  机构code Code
 *@param  paramJson {singleSelect:是否单选,orgId:树机构根节点(默认为当节用户的单位id)}
*/
var paramsJosnG={};
function comSelectOrg(id,paramsJosn){
	if(document.getElementById("commOrgWin"))
		$("#commOrgWin").remove();
	//动态添加一个DIV  <div id="selUserWin"></div>
	$("body").append("<div id='commOrgWin' style='overflow:hidde;'></div>");
	paramsJosn = isNull(paramsJosn)?paramsJosn:{};
	paramsJosn.target = id;
	paramsJosnG  = paramsJosn;
	var url =curProjectUrl+"/content/manage/select_org.jsp?width=720&height=510";
	$('#commOrgWin').window({
		href:url,
		title:"选择机构",
 		top:5,
	    width:720,  
	    height:460,  
	    zIndex:5,
	    collapsible:false,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    draggable:false,
	    cache:false,
	    modal:true,
	    onClose:function(){
	    },
	    onLoad:function(){
	    	//$(".window").css("position","fixed");//绝对定位
	    	//根据页面相对定位
	    	var top = $(document).scrollTop(); 
	    	var left = $(document).scrollLeft(); 
	    	$("#commOrgWin").parent().css({"top":top+"px"});
	    	$(".window-shadow").css({"top":top+"px"});
	    }
	});
}

/**
 * 处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外
 */    
function banBackSpace(e){  
	
    //alert(event.keyCode)   
    var ev = e || window.event;//获取event对象      
    var obj = ev.target || ev.srcElement;//获取事件源        
    var t = obj.type || obj.getAttribute('type');//获取事件源类型        
    
    //获取作为判断条件的事件类型    
    var vReadOnly = obj.readonly;  
    var vDisabled = obj.disabled;  
    
    //处理undefined值情况    
    vReadOnly = (vReadOnly == undefined) ? false : vReadOnly;  
    vDisabled = (vDisabled == undefined) ? true : vDisabled;  
    //当敲Backspace键时，事件源类型为密码或单行、多行文本的，     
    //并且readOnly属性为true或disabled属性为true的，则退格键失效     
    var flag1 = ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea") && (vReadOnly == true || vDisabled == true);  
   
    //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效       
    var flag2 = ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea";  
   
    //判断       
    if (flag2 || flag1)   
        ev.returnValue = false;//这里如果写 return false 无法实现效果    
} 

/**禁用退格键**/
function forbiddenBackapace(){
	
	//禁止退格键 作用于Firefox、Opera    
    document.onkeypress = banBackSpace;  
   
    //禁止退格键 作用于IE、Chrome   
    document.onkeydown = banBackSpace; 
}

var curProjectUrl=getProjectUrl();

/**
 * 获取项目绝对路径
 * @returns /audit
 */
function getProjectUrl(){
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return projectName;
}

/**
 * 获取REDIS数据
 * @param keystrs
 * @returns
 */
function getRedisData(keystrs){
	var jsonData=null;
	$.ajax({
		url:getProjectUrl()+"/getRedis.do",
		async : false,//同步
		data:{"keys":keystrs},
		dataType :"json",//json数据格式
		success:function(data){
			var jsonStr = data;
            var jsonObj = eval(jsonStr); //简单的绑定
            jsonData= jsonObj;
		}
	});
	return jsonData;
}

/**
 * 获取字典数据
 * @param keystrs
 * @returns
 */
function getDic(keystrs,table){
	var jsonData=null;
	$.ajax({
		url:getProjectUrl()+"/status/getDic.do",
		async : false,//同步
		data:{"key":keystrs,'table':table},
		dataType :"json",//json数据格式
		success:function(data){
			jsonData = eval(data); //简单的绑定
		}
	});
	return jsonData;
}
function getD(type){
	var jsonData=null;
	$.ajax({
		url:getProjectUrl()+"/status/getD.do",
		data:{"type":type},
		async : false,//同步
		dataType :"json",//json数据格式
		success:function(data){
			jsonData = eval(data); //简单的绑定
		}
	});
	return jsonData;
}

/**
 * 获取字典数据
 * @param keystrs
 * @returns
 */
function getCombobox(url){
	var jsonData=null;
	$.ajax({
		url:getProjectUrl()+ url,
		async : false,//同步
		data:{},
		dataType :"json",//json数据格式
		success:function(data){
			jsonData = eval(data); //简单的绑定
		}
	});
	return jsonData;
}

/**
 * 初始化select  默认添加"请选择"
 * 
 * @param keystrs key拼接的字符串
 * @param idstr  标签id拼接的字符串
 * @param gloable_json_object 页面全局变量
 */
function initSelect(keystrs, idstr, gloable_json_object){
	$.ajax({
		url:getProjectUrl()+"/getRedis.do",
		async : false,//同步
		data:{"keys":keystrs},
		dataType :"json",//json数据格式
		success:function(data){
			var jsonStr = data;
            var jsonObj = eval(jsonStr); //简单的绑定
			analyRedisData(keystrs, idstr, jsonObj);                    
			//这个方法不是公用方法  根据每个页面的不同其内容也不同
			gloable_json_object=jsonObj;
		}
	});
}

/*
* 非空验证  传入json数据  键为ID 值为提示信息    easyui取值传递加上类型符中间用=分隔  如combobox=type
* 如var fields = {"userName":"用户名不能为空！","password":"密码不能为空！","combobox=type":"类型不以为空"};
*/
function vilidateEmpty(jsonFields) {
    var alertMsg = "";
    var val;
    for (id in jsonFields) {
    	if(id.indexOf("=")>-1){//easyui取值
    		var ids = id.split("=");
    		val = getValByType(ids[0],ids[1]);
    	}else{
    		var obj = document.getElementById(id);
    		if(!obj){continue;}
    		val = obj.value;
    	}
        if (val==null||val=="") {
           alertMsg +=jsonFields[id]+"<br/>";
        }
   }
   if (alertMsg!="") {
       $.messager.alert("提示", alertMsg);
       return false;
   }
   return true;
}

/**获取easyui的值*/
function getValByType(type,id){
	id="#"+id;
	if(type=="combobox")//下拉
		return $(id).combobox("getValue");
	if(type=="datebox")//日期
		return $(id).datebox('getValue');
	if(type=="datetimebox")//日期
		return $(id).datetimebox('getValue');
}

/**
 * 大小写转换
 * @param currencyDigits
 * @returns
 */
function convertCurrency(currencyDigits) { 
	// Constants: 
	    var MAXIMUM_NUMBER = 99999999999.99; 
	    // Predefine the radix characters and currency symbols for output: 
	    var CN_ZERO = "零"; 
	    var CN_ONE = "壹"; 
	    var CN_TWO = "贰"; 
	    var CN_THREE = "叁"; 
	    var CN_FOUR = "肆"; 
	    var CN_FIVE = "伍"; 
	    var CN_SIX = "陆"; 
	    var CN_SEVEN = "柒"; 
	    var CN_EIGHT = "捌"; 
	    var CN_NINE = "玖"; 
	    var CN_TEN = "拾"; 
	    var CN_HUNDRED = "佰"; 
	    var CN_THOUSAND = "仟"; 
	    var CN_TEN_THOUSAND = "万"; 
	    var CN_HUNDRED_MILLION = "亿"; 
	    var CN_SYMBOL = ""; 
	    var CN_DOLLAR = "元"; 
	    var CN_TEN_CENT = "角"; 
	    var CN_CENT = "分"; 
	    var CN_INTEGER = "整"; 
	    var CN_FU="";
	     
	// Variables: 
	    var integral;    // Represent integral part of digit number. 
	    var decimal;    // Represent decimal part of digit number. 
	    var outputCharacters;    // The output result. 
	    var parts; 
	    var digits, radices, bigRadices, decimals; 
	    var zeroCount; 
	    var i, p, d; 
	    var quotient, modulus; 
	     
	// Validate input string: 
	    currencyDigits = currencyDigits.toString();    
	    if (currencyDigits.substr(0,1) == "-"){
	    	currencyDigits = currencyDigits.substr(1);
	    	CN_FU = "负";
	    }
	    if (currencyDigits == "") { 
	       // alert("Empty input!"); 
	        return ""; 
	    } 
	    if (currencyDigits.match(/[^,.\d]/) != null) { 
	       alert("Invalid characters in the input string!");  
	        return ""; 
	    } 
	    if ((currencyDigits).match(/^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/) == null) { 
	        alert("Illegal format of digit number!"); 
	        return ""; 
	    } 
	     
	// Normalize the format of input digits: 
	    currencyDigits = currencyDigits.replace(/,/g, "");    // Remove comma delimiters. 
	    currencyDigits = currencyDigits.replace(/^0+/, "");    // Trim zeros at the beginning. 
	    // Assert the number is not greater than the maximum number. 
	   /* if (Number(currencyDigits) > MAXIMUM_NUMBER) { 
	        alert("Too large a number to convert!"); 
	        return ""; 
	    } */
	     
	// Process the coversion from currency digits to characters: 
	    // Separate integral and decimal parts before processing coversion: 
	    parts = currencyDigits.split("."); 
	    if (parts.length > 1) { 
	        integral = parts[0]; 
	        decimal = parts[1]; 
	        // Cut down redundant decimal digits that are after the second. 
	        decimal = decimal.substr(0, 2); 
	    } 
	    else { 
	        integral = parts[0]; 
	        decimal = ""; 
	    } 
	    // Prepare the characters corresponding to the digits: 
	    digits = new Array(CN_ZERO, CN_ONE, CN_TWO, CN_THREE, CN_FOUR, CN_FIVE, CN_SIX, CN_SEVEN, CN_EIGHT, CN_NINE); 
	    radices = new Array("", CN_TEN, CN_HUNDRED, CN_THOUSAND); 
	    bigRadices = new Array("", CN_TEN_THOUSAND, CN_HUNDRED_MILLION); 
	    decimals = new Array(CN_TEN_CENT, CN_CENT); 
	    // Start processing: 
	    outputCharacters = ""; 
	    // Process integral part if it is larger than 0: 
	    if (Number(integral) > 0) { 
	        zeroCount = 0; 
	        for (i = 0; i < integral.length; i++) { 
	            p = integral.length - i - 1; 
	            d = integral.substr(i, 1); 
	            quotient = p / 4; 
	            modulus = p % 4; 
	            if (d == "0") { 
	                zeroCount++; 
	            } 
	            else { 
	                if (zeroCount > 0) 
	                { 
	                    outputCharacters += digits[0]; 
	                } 
	                zeroCount = 0; 
	                outputCharacters += digits[Number(d)] + radices[modulus]; 
	            } 
	            if (modulus == 0 && zeroCount < 4) { 
	                outputCharacters += bigRadices[quotient]; 
	            } 
	        } 
	        outputCharacters += CN_DOLLAR; 
	    } 
	    // Process decimal part if there is: 
	    if (decimal != "") { 
	        for (i = 0; i < decimal.length; i++) { 
	            d = decimal.substr(i, 1); 
	            if (d != "0") { 
	                outputCharacters += digits[Number(d)] + decimals[i]; 
	            }
	            else
	            {
	            	if (decimals[i]=="角" && i+1<decimal.length && decimal.substr(i+1, 1)!="0")  //by ddb
	            	{
	            		outputCharacters +="零";
	            	}
	            } 
	        } 
	    } 
	    // Confirm and return the final output string: 
	    if (outputCharacters == "") { 
	        outputCharacters = CN_ZERO + CN_DOLLAR; 
	    } 
	    if (decimal == "") { 
	       // outputCharacters += CN_INTEGER; 
	    } 
	    
	   if (outputCharacters.substr(outputCharacters.length-1) == "元"){
	    	outputCharacters = outputCharacters + "整";
	    }
	    
	    if (outputCharacters.substr(outputCharacters.length-1) == "角"){
	    	outputCharacters = outputCharacters + "整";
	    }
	    
	    outputCharacters = CN_FU + CN_SYMBOL + outputCharacters; 
	    return outputCharacters; 
	}


var workFlowG;//发起流程的全局变量 
var WFDataG;//发起成功后的信息
var userDataG;//发起流程的人员信息
var dealWFMethodG;

/**送审
* @author wangh
* @param bizId 业务ID 
* @param applyId 业务单ID
* @param applyTitle 业务单名称
* @param global 全局变量  json 类型 或 json字符串 (非必须)   动态人员设定  dynamic:"人员id,人员id",nextPiont：“动态人员节点名”
* @param dealWFMethod 处理流程发送后的方法 JS方法入参为流程处理信息 json类型  (非必须) 
*  {msg:成功失败信息,error：失败信息,instance:成功后的流程实例,personSelected:选中的人,curLink:流程当前处理环节名称,applyId:工单号,processId：流程定义ID}
* @param sendable 启动流程后是否直接发送 boolean 类型
*/
function setWFStart(bizId,applyId,applyTitle,global,dealWFMethod,sendable){
	WFDataG={};
	if(!isStringNull(bizId)|| !isStringNull(applyId)){
		$.messager.alert('提示','传入参数不正确！','error');
		return;
	}
	var processId = Tool_Ajax(getProjectUrl()+"/baseWorkflow/queryProcessId.do",{"bizId":bizId});
	
	if(!isStringNull(processId)){$.messager.alert('提示','该用户所在的省份的流程定义不存在！','error');return;}
	
	applyTitle = typeof(applyTitle) =="undefined" ?"":applyTitle;
	global = typeof(global) =="undefined"||global==null?"":typeof(global)=="string"?global:JSON.stringify(global);
	workFlowG={"processId":processId,"applyId":applyId,"applyTitle":applyTitle,"global":global};
	dealWFMethodG =dealWFMethod;
	if(typeof(sendable)!="undefined"&&sendable==true){//直接找人发送
		WFDataG = Tool_Ajax(getProjectUrl()+"/baseWorkflow/sendWorkFlow.do",workFlowG,"json");
		if(isStringNull(WFDataG)){
			if(WFDataG.msg=="n"){
				$.messager.alert("提示","流程发起失败！"+WFDataG.error,"info");
				return;
			}
			if(typeof(dealWFMethodG)!="undefined"){
				if(typeof(dealWFMethodG)=="function"){
					dealWFMethodG(WFDataG)//JS方法
				}
				else{
					WFDataG=Tool_Ajax(getProjectUrl()+"/"+dealWFMethod,WFDataG,"json");//JAVA处理
				}
			}
		}else{
			$.messager.alert("提示","流程发起失败！","info");
		}
		return;
	}
	if(document.getElementById("workflow-win")!=null){
		$("#workflow-win").remove();
	}
	//流程虚拟人员处理  直接 发送
	$("body").append("<div id='workflow-win'></div>");
		$('#workflow-win').window({
		title:"流程发起",
  		href:getProjectUrl()+"/baseWorkflow/setWFStartPopedom.do", 
  		top:10,
	    width:564,  
	    height:'auto',  
	    zIndex:3,
	    collapsible:false,
	    minimizable :false,
	    maximizable:false,
	    draggable:false,
	    resizable:false,
	    shadow:false,
	    cache:false,
	    modal:true,
	    onClose:function(){
	    	
	    },
	    onLoad:function(){
	    	$(".window").css("position","fixed");
	    }

	});
}


//删除流程
function deleteIns(instanceWfId){
	var data = Tool_Ajax(curProjectUrl+'/workflow/deleteIns.do',{instanceWfId:instanceWfId});
	return data=="true";
}

function getWFSendData(){
	return WFDataG;
}

/**
 * 将RedisJSON字符串由[{key:**,value:**}]转换成Map(key,value)
 * @param jsonStr
 */
function parseRedisToMap(jsonStr){
	var jsonObj = $.parseJSON(jsonStr);
	if(typeof jsonObj !="undefined"&&jsonObj!=null&&jsonObj!='null'){
		var result = new Map();
		for(var i=0;i<jsonObj.length;i++){
			var key = jsonObj[i].key;
			var value = jsonObj[i].value;
			result.put(key,value);
		}
		return result;
	}else{
		return null;
	}
}

/**
 * 时间格式化
*/
//对Date的扩展，将 Date 转化为指定格式的String 
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function(fmt) 
{ 	
	//author: meizz 
	var o = { 
	 "M+" : this.getMonth()+1,                 //月份 
	 "d+" : this.getDate(),                    //日 
	 "h+" : this.getHours(),                   //小时 
	 "m+" : this.getMinutes(),                 //分 
	 "s+" : this.getSeconds(),                 //秒 
	 "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	 "S"  : this.getMilliseconds()             //毫秒 
	}; 
	if(/(y+)/.test(fmt)) 
	 fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	for(var k in o) 
	 if(new RegExp("("+ k +")").test(fmt)) 
	fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
	return fmt; 
}

var g_upadifyindex=0;

/**
 * @param param1 方法名
 * 
 * @param param2 页面sessionID
 * @param 扩展JSON对象  global{ closeable:是否自动关闭,multi:是否多附件上传}
 * 
 * @author luowei
 */
function commonUploadifyFile(param1, param2, global){
	
	//如果存在 则删除这个元素
	if(document.getElementById("commUploadifyWin")) $("#commUploadifyWin").remove();
	
	//动态添加一个DIV  <div id="selUserWin"></div>
	$("body").append("<div id='commUploadifyWin'></div>");
	
	$("#commUploadifyWin").window({
		title:"文件上传",
  		href:getProjectUrl()+'/project/toUpload.do',  
  		//top:120,
  		bottom:100,
	    width:410,  
	    height:320,  
	    zIndex:1,
	    collapsible:false,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    draggable:false,
	    cache:false,
	    modal:true,
	    onLoad:function(){
	    	var multiable = true;
	    	if(global){
	    		if(global.multi==false)
	    			multiable=false;
	    	}
            $("#uploadify").uploadify({
                'swf': getProjectUrl()+'/common/uploadify/uploadify.swf',
                'uploader': getProjectUrl()+'/project/uploadFile.do;jsessionid='+param2,
                'buttonText': '添加附件',
                'queueID' : 'fileQueue',
            	'queueSizeLimit' : 4,
            	'width':80,//设置添加附件按钮的宽度
            	'height':20,
                'auto': true,//选择文件后自动上传
                'multi':multiable,//设置为true将允许多文件上传
                'removeTimeout':1,
                'fileSizeLimit':'20MB',
                onCancel:function(){
                	//alert('cancel');//点击取消叉号触发
                },
                onSelect:function(){
                	//alert('select');//选择文件时触发
                	g_upadifyindex++;
                },
                onClearQueue:function(event,data){
                	//alert();//点击取消所有时  触发这个事件
                },
                onUploadSuccess :function(file,data,response){
                	param1(file,data,response);
                	g_upadifyindex--;
                	 if(global){
                		 if(global.closeable){
                			 $('#commUploadifyWin').window('close');
                		 }
                	 }else{
                		 if(0==g_upadifyindex){
                			 $.messager.confirm("提示", "是否要继续上传?",function(result){
                				 //确认
                				 if(!result) {
                					 $('#commUploadifyWin').window('close');
                				 }else{
                					 //$('#uploadify').uploadifyUpload();
                					 
                				 }
                			 });
                			 var aBtns = $(".messager-button .l-btn-text");
                			 $(aBtns[0]).text("继续");
                		 }
                	 }
                }
                
            });
	    },
	    onBeforeClose:function(){
	    	if ($("#uploadify").length > 0) { //注意jquery下检查一个元素是否存在必须使用 .length >0 来判断
			    $("#uploadify").uploadify("destroy");
			}
	    }
	});
}

/**上传**/
function upload(){
	if($.trim($("#fileQueue").text())==""){
		alert("请选择文件!");
		return;
	}
	$("#uploadify").uploadify("upload","*");//上传所有文件
}
/**取消上传**/
function cancel(){
	$("#uploadify").uploadify("cancel","*");//* 代表所有队列中文件
}

/**
 * 初始化状态
 * @param projectId
 * @param auditTypeCode
 */
function c_initStatusInfo(projectId, auditTypeCode){
	Tool_Ajax(getProjectUrl()+'/status/initStatus.do', {projectId:projectId, auditTypeCode:auditTypeCode});
}

/**
 * 更新状态
 * @param workFinishId 完成项id
 * @param projectId
 * @param auditTypeCode
 * @param status 0：未完成 1：完成
 */
function c_updateStatus(projectId, auditTypeCode, status){
	Tool_Ajax(getProjectUrl()+'/status/updateStatus.do', {projectId:projectId, auditTypeCode:auditTypeCode, status:status});
}

/**
 * 更新状态
 * @param workFinishId 完成项id
 * @param projectId
 * @param auditTypeCode
 * @param status 0：未完成 1：完成
 */
function c_updateStatusTwo(workFinishId){
	Tool_Ajax_Async(getProjectUrl()+'/status/updateStatus.do', {workFinishId:workFinishId});
}

/**
 * 更新状态
 * @param projectId
 * @param auditTypeCode
 * @param status 0：未完成 1：完成
 */
function c_goBackStatus(projectId, auditTypeCode){
	Tool_Ajax(getProjectUrl()+'/status/goBack.do', {projectId:projectId, auditTypeCode:auditTypeCode});
}

/**
 * 查询状态
 * @param projectId
 * @param auditTypeCode
 */
function c_queryStatus(projectId, auditTypeCode){
	var jsonObj=Tool_Ajax(getProjectUrl()+'/status/queryStatus.do', {projectId:projectId, auditTypeCode:auditTypeCode}, "json");
	return jsonObj;
}

/**加载状态流程图**/
function loadStatus(giveitemId, globle){
	var type="JIESUAN";
	if(globle){
		type=globle.type;
	}
	//var giveitemId=$("#giveitemId").val();
	var jsonObj=c_queryStatus(giveitemId,type);
	if(null!=jsonObj){
		var workFinishId="";
		var finishTime="";
		var workItemName="";
		var workUrl="";
		var status="";
		var str1="";
		var str2="";
		var str3="";
		var lastNavId ="";
		var lastNavIdBack = "";
		var oneJson;
		for(var i=0; i<jsonObj.length; i++){
			oneJson = jsonObj[i];
			status=oneJson.status;
			lastNavId = status=="0" ? oneJson.workFinishId : lastNavId;
			if(i==0){
				str1+=
					'<small class="sty1">'+jsonObj[i].workItemName+'</small>';
				str2+=
					'<small>'+jsonObj[i].finishTime+'</small>';
				str3+=
					'<small class="sty2">'+(i+1)+'</small>';
			}else{
				var canClick="";//是否可点击
				if(status!=''){
					canClick='jumpTo(this)';
					lastNavIdBack = oneJson.workFinishId;
				}
				str1+=
					'<span'+(i==(jsonObj.length-1)?' class="bgsy2"':'')+'>'+oneJson.workItemName+'</span>';
				str2+=
					'<span>'+(oneJson.finishTime!=""?oneJson.finishTime:(status==""?"&nbsp;":"进行中"))+'</span>';
				str3+=
					'<span navstatus="'+status+'" id="'+oneJson.workFinishId+'" workUrl="'+oneJson.workUrl+'" onclick="'+canClick+'" projectId="'+oneJson.projectId+'" '+(i==(jsonObj.length-1)?' class="bgsy1 sty2"':(status!=''?' class="sty3"':''))+'>'+(i+1)+'</span>'
			}
		}
		str1=
			'<p>'+str1+'</p>'+
			'<p class="heig">'+
	      		str3+
	      	'</p>'+
	      	'<p>'+str2+'</p>';
	    
	    $("#statusid").append(str1);
	    var canClicks =  $("#statusid span[navstatus!='']");
	    canClicks.each(function(){
	    	$(this).css("cursor","pointer");
	    	if($(this).hasClass("sty1"))
				$(this).removeClass("sty1");
	    });
	    //显示转动
	    var curUrl = window.location.href;
	    //匹配url参数
		var navId = Page_GetUrlParamValue(curUrl,"navId");
		if(isStringNull(navId)){
			lastNavId = navId;
		}
		//状态有误时启动备份方案最后一个亮的转动
		if(!isStringNull(lastNavId)){
			lastNavId = lastNavIdBack;
		}
	    workFinishG = document.getElementById(lastNavId);
	    showNav();
	}
}

//跳转
function jumpTo(obj){
	var url = $(obj).attr("workUrl");
	var id = $(obj).attr("projectId");
	window.location.href=curProjectUrl+url.replace("{0}",id)+"&navId="+obj.id;
}
//显示转动
function showNav(){
	if($(workFinishG).hasClass("sty3"))
		$(workFinishG).removeClass("sty3");
	$(workFinishG).addClass("sty1");
	$(workFinishG).removeAttr("onclick");
	
}

var workFinishG;

//获取当前的导航id
function getNavId(){
	return workFinishG.id;
}

/**
 * @param param  data{ ftpFileId:FTP唯一标示,
 * 					   ftpFileName:文件名,
 * 					   ftpFileType:文件类型（word/excel）,
 * 					   isReadOnly:是否只读（1为只读）,
 * 					   bookMarks:标签(json字符串)}
 * @author lijie
 */
function upLoadNTKO(data){
	var url=getProjectUrl()+'/ntko/edit.do';
	var name="ntko";
	var result=openPostWindow(url, data, name);
	}

/**
 * @param url 跳转页面地址
 * @param data 传递数据
 * @param name 表单名称
 * @author lijie
 */
function openPostWindow(url, data, name){  
      var tempForm = document.createElement("form");  
          tempForm.id="ntkoForm";  
          tempForm.method="post";  
          tempForm.action=url;  
          tempForm.target=name;  
          
      var hideInput1 = document.createElement("input");  
          hideInput1.type="hidden";  
          hideInput1.name= "ftpFileId";
          hideInput1.value= data.ftpFileId;
          tempForm.appendChild(hideInput1);  

	  var hideInput2 = document.createElement("input");  
          hideInput2.type="hidden";  
          hideInput2.name= "ftpFileName";
          hideInput2.value= data.ftpFileName;
          tempForm.appendChild(hideInput2); 

	  var hideInput3 = document.createElement("input");  
          hideInput3.type="hidden";  
          hideInput3.name= "ftpFileType";
          hideInput3.value= data.ftpFileType;
          tempForm.appendChild(hideInput3); 
          
      var hideInput4 = document.createElement("input");  
          hideInput4.type="hidden";  
          hideInput4.name= "isReadOnly";
          hideInput4.value= data.isReadOnly;
          tempForm.appendChild(hideInput4); 
          
      var hideInput5 = document.createElement("input");  
          hideInput5.type="hidden";  
          hideInput5.name= "bookMarks";
          hideInput5.value= data.bookMarks;
          tempForm.appendChild(hideInput5); 

          tempForm.attachEvent("onsubmit",function(){ openWindow(name); });
          document.body.appendChild(tempForm);  
          
          tempForm.fireEvent("onsubmit");
          tempForm.submit();
          document.body.removeChild(tempForm);
     }

/**
 * @param name 表单名称
 * @author lijie
 */
 function openWindow(name)  
      {  
          window.open('about:blank',name,'left=0,top=0,width='+ (screen.availWidth - 10) +',height='+ (screen.availHeight-50) +',scrollbars,resizable=yes,toolbar=no');   
      }  

 /**
  * 用于datagrid中对后台传给前台的日期进行格式化
  */
 var Common = {
		    //EasyUI用DataGrid用日期格式化
		    TimeFormatter: function (value, rec, index) {
		    	if(value==null){
		    		return "";
		    	}
		    	var year = parseInt(value.year)+1900;
		    	var month = parseInt(value.month)+1;
		    	var date = value.date;
		    	var hours = value.hours;
		    	if(hours<10){
		    		hours='0'+hours;
		    	}
		    	var minutes = value.minutes;
		    	if(minutes<10){
		    		minutes='0'+minutes;
		    	}
		    	var seconds = value.seconds;
		    	if(seconds<10){
		    		seconds='0'+seconds;
		    	}
		        var val = year+"-"+month+"-"+date+" "+hours+":"+minutes+":"+seconds;
		        return val;
		    },
		  //EasyUI用DataGrid用日期格式化
		    DateFormatter: function (value, rec, index) {
		    	if(value==null){
		    		return "";
		    	}
		    	var year = parseInt(value.year)+1900;
		    	var month = parseInt(value.month)+1;
		    	var date = value.date;
		    	if(month<10){
		    		month='0'+month;
		    	}
		    	if(date<10){
		    		date='0'+date;
		    	}
		        var val = year+"-"+month+"-"+date;
		        return val;
		    }

		};

		Date.prototype.format = function(format) {
		    /*
		     * eg:format="YYYY-MM-dd hh:mm:ss";
		     */
		    var o = {
		        "M+" :this.getMonth() + 1, // month
		        "d+" :this.getDate(), // day
		        "h+" :this.getHours(), // hour
		        "m+" :this.getMinutes(), // minute
		        "s+" :this.getSeconds(), // second
		        "q+" :Math.floor((this.getMonth() + 3) / 3), // quarter
		        "S" :this.getMilliseconds()
		    // millisecond
		    }
		    if (/(y+)/.test(format)) {
		        format = format.replace(RegExp.$1, (this.getFullYear() + "")
		                .substr(4 - RegExp.$1.length));
		    }
		    for ( var k in o) {
		        if (new RegExp("(" + k + ")").test(format)) {
		            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
		                    : ("00" + o[k]).substr(("" + o[k]).length));
		        }
		    }
		    return format;
		}
 /**下载ftp文件
  * @param data 时间戳 多个以逗号分隔
  * @param fileName 下载时出现的文件名  含文件类型
*/
function downloadFtpFile(data,fileName){
	fileName = isStringNull(fileName)?encodeURI(encodeURI(fileName)):"";
	var url = curProjectUrl + "/ftpfile/download.do?data="+data+"&filename="+fileName;
	window.open(url); 
}

/**
 * 其它文档相关的全局变量
 */
var g_businessId;
var g_businessType;
var g_ReadOnly;

/**
 * 其它文档
 * @param businessId 业务数据编号
 * @param businessType 业务类型（业务表名称）
 * @param readOnly 是否只读 0：否   1：是
 */
function gOtherWord(params){
	if(params){
		g_businessId=params.businessId;
		g_businessType=params.businessType;
		g_ReadOnly='undefined'==params.readOnly?'0':params.readOnly;
		gOtherWordWin();
	}
}

function gOtherWordWin(){
	if(document.getElementById("otherWordWin")) $("#otherWordWin").remove();
	$("body").append("<div id='otherWordWin'></div>");
	
	$('#otherWordWin').window({
		title:"其它文档",
  		href:getProjectUrl()+'/audit/otherWord.do',
  		top:20,
	    width:700,  
	    height:400,  
	    zIndex:2,
	    collapsible:false,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    draggable:false,
	    shadow:false,
	    cache:false,
	    modal:true,
	    onLoad:function(){
	    	$(".window").css("position","fixed");
	    } 
	});
}



/**
 *选择用岗位用页面 wangh
 *@param nameId 页面显示值的标签ID
 *@param keyId 页面隐藏值的标签ID
 *@param isSingle 单选 ：Y/y  多选:N/n 默认单选(可选)
 *@param orgId 组织Id  默认是当前登陆用户的组织(可选)
 *@param backFunName 执行关闭时的回调整函数名 //入参为当前选中行对象
 *@param extend     扩展控制json对象{filter:"用户id(多个用英文逗号分隔)"}
 *  loadUserOrgId:指定加载右则用户机构
*/
function comSelectPosition(nameId,keyId,isSingle,orgId,backFunName,extend){
	if(document.getElementById("commUserWin"))
		$("#commUserWin").remove();
	//动态添加一个DIV  <div id="selUserWin"></div>
	$("body").append("<div id='commUserWin' style='overflow:hidde;'></div>");
	//默认项的设置
	if(typeof (orgId) == "undefined")
		orgId='';
	if(typeof (isSingle)=="undefined" || $.trim(isSingle)=="")
		isSingle="y";
	if(!document.getElementById(nameId)){
		$.messager.alert('提示','参数不正确：id为'+nameId+'的标签对象不存在！','error');
		return;
	}
	
	$("#"+nameId).blur();//失去焦点
	if(!document.getElementById(keyId)){
		$.messager.alert('提示','参数不正确：id为'+keyId+'的标签对象不存在！','error');
		return;
	}
	if(isNull(extend))
		extendG = extend;
	//获取项目的绝对路径
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	var urlTo =projectName+'/position/selectPosition.do?keyId='+keyId+'&nameId='+nameId+'&orgId='+orgId+'&isSingle='+isSingle;
	if(typeof backFunName === 'function')
		backFunNameG = backFunName;
	$('#commUserWin').window({
		href:urlTo,
		title:"选择岗位",
 		top:10,
	    width:720,  
	    height:510,  
	    zIndex:5,
	    collapsible:false,
	    minimizable:false,
	    maximizable:false,
	    resizable:false,
	    draggable:false,
	    cache:false,
	    modal:true,
	    onClose:function(){
	    },
	    onLoad:function(){
	    	//$(".window").css("position","fixed");//绝对定位
	    	//根据页面相对定位
	    	var top = $(document).scrollTop(); 
	    	var left = $(document).scrollLeft(); 
	    	$("#commUserWin").parent().css({"top":top+"px"});
	    	$(".window-shadow").css({"top":top+"px"});
	    }
	});
}
