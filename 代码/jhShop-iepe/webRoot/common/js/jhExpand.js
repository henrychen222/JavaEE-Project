 var inputKeyCode=[48,49,50,51,52,53,54,55,56,57,96,97,98,99,100,101,102,103,104,105,8,37,38,39,40];
 
 function checkNumEmpty(obj,value){
	 var regtext=/^[0-9]*$/;
		if(!regtext.test(obj.value)){
			obj.value=value;
		}
 }
 function checkPriceEmpty(obj,value){
	 var regtext=/^[0-9]+.{0,1}[0-9]*$/;
		if(!regtext.test(obj.value)){
			obj.value=value;
		}
 }
 Array.prototype.contains = function(item){
    for(i=0;i<this.length;i++){
        if(this[i]==item){return true;}
    }
    return false;
};

//str去空
String.prototype.trim=function() {  
    return this.replace(/(^\s*)|(\s*$)/g,'');  
};  
//form 转Json
Array.prototype.toJson = function(paramData){
	if(!paramData){
		paramData={};
	}
	var len=this.length;
	for(var i=0;i<len;i++){
		var paramName=this[i].name;
		var paramValue=this[i].value;
		if(paramData[paramName]==null){
			if(paramValue!=null&&paramValue!='')
				paramData[paramName]=paramValue;
		}else{
			if(typeof(paramData[paramName])=='string'){
				var paramValues=[paramData[paramName],paramValue];
				paramData[paramName]=paramValues;
			}else{
				paramData[paramName].push(paramValue);
			}
		}
	}
	return paramData;
 }




//JS版
//将传入数据转换为字符串,并清除字符串中非数字与.的字符
//按数字格式补全字符串
var getFloatStr = function(num){
    num += '';
    num = num.replace(/[^0-9|\.]/g, ''); //清除字符串中的非数字非.字符
    
    if(/^0+/) //清除字符串开头的0
        num = num.replace(/^0+/, '');
    if(!/\./.test(num)) //为整数字符串在末尾添加.00
        num += '.00';
    if(/^\./.test(num)) //字符以.开头时,在开头添加0
        num = '0' + num;
    num += '00';        //在字符串末尾补零
    num = num.match(/\d+\.\d{2}/)[0];
    return num;
};

function getParamValue(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}

//获取当前窗口滚动高度
function getTop(height){
	if(!height){
		height=$(document).scrollTop()
	}
	return "srcollHeight="+height;
}


function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}


function getScrollTop(){
	var regText=GetQueryString("srcollHeight");
	if(regText!=null&&regText[0]!=null){
		return parseInt(regText);
	}
	return 0;
}