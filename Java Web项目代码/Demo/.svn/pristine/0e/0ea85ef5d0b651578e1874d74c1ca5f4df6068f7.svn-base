window.permObj={
		execFunc:function(){
			permObj.execCallBack(permObj);
		},
		login:function(){
			window.permObj.index=layer.open({
			    type: 2,
			    title:'登录',
			    fix: false, //不固定
			    area: ['500px', '450px'],
			    content:$.basePath+'/content/jhShop/insideLogin.jsp'
			})
		},
		loginClose:function(){
			layer.close(window.permObj.index);
		},
		getUser:function(){
			var user=$.ajax({
				url:ctx+'/login/checkUser.do',
				type:'post',
				async:false
			}).responseText;
			return user;
		},
		targetHref:function(href){
			var a=$('#target_a');
			if(a.length==0){
				a=$('<form>');
				$('body').append(a);
				a.attr('target',"_blank");
			}
			a.attr('action',href);
			a.attr('method',"post");
			a.submit();
		}

};

function checkUser(callback,fnParam,userCheckState,target,companyParam){
	window.permObj.userCheckState=userCheckState;
	var text=$.ajax({
		url:ctx+'/login/checkUser.do',
		type:'post',
		async:false,
	}).responseText;

	window.permObj.execCallBack=function(obj){
		if(obj.userCheckState!=null&&obj.userCheckState==true&&obj.state==null){
			var text=window.permObj.getUser();
			var user=eval("("+text+")");
			if(user!=null&&user.company!=null&&user.company.state!=16){
				window.location.href=$.basePath+"/login/indexPage.do";
				return;
			}
		}else if(obj.state!=16&&obj.userCheckState==true){
				window.location.href=$.basePath+"/login/indexPage.do";
				return;
		}
		if(callback==null){
			location.reload();
		}else{
			if(typeof(callback)=='string'&&target!=1){
				location.href=callback;
			}else if(typeof(callback)=='string'&&target==1){
				window.permObj.targetHref(callback);
			}else{
				callback.apply(window,fnParam);
			}
		}
	}
	var text=window.permObj.getUser();
	if(text==''){
		permObj.login();
	}else{
		var user=eval("("+text+")");
		window.permObj.state=user.company.state;
		window.permObj.execFunc();
	}
}
/*
 * callback 可以是IP地址，必须加上项目上下文路径;也可以是一个function方法，比如'/JhShop/index.do',function(obj1,obj2){}
 * fnParam 如果callback是function格式的参数，这个就是function方法中参数，参数类型是数组格式[],按对应顺序
 * perm 权限开关
 * userCheckState 用户认证过滤  如果为true当登录的用户为未认证的用户则跳入后台认证页面，false则跳入要执行的结果
 * target 跳转方式 1：打开新页面 不填或者为其他值时代表本页面跳转，callback为function类型参数，这个参数无用
 */

function checkUserPerm(callback,fnParam,perm,userCheckState,target){
	window.permObj.userCheckState=userCheckState;
	window.permObj.perm=perm;
	window.permObj.execCallBack=function(obj){
		if(obj.userCheckState!=null&&obj.userCheckState==true&&obj.perm==true&&obj.state==null){
			var text=window.permObj.getUser();
			var user=eval("("+text+")");
			if(user!=null&&user.company!=null&&user.company.state!=16){
				window.location.href=$.basePath+"/login/indexPage.do";
				return;
			}
		}else if(obj.state!=16&&obj.userCheckState==true&&obj.perm==true){
				window.location.href=$.basePath+"/login/indexPage.do";
				return;
		}
		if(callback==null){
			location.reload();
		}else{
			if(typeof(callback)=='string'&&target!=1){
				location.href=callback;
			}else if(typeof(callback)=='string'&&target==1){
				window.permObj.targetHref(callback);
			}else{
				callback.apply(window,fnParam);
			}
		}
	}
	if(perm!=null&&perm==true){
		var text=window.permObj.getUser();
		if(text==""){
			permObj.login();
		}else{
			var user=eval("("+text+")");
			window.permObj.state=user.company.state;
			window.permObj.execFunc();
		}
	}else{
		window.permObj.execFunc();
	}
}

function companyStateValid(callback){
	var option=1;
}
