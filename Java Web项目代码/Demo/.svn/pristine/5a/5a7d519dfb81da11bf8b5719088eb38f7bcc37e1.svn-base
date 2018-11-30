package com.jd.web.framework.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	private List<String> excludedUrls;//放行的URL
	public List<String> getExcludedUrls() {
        return excludedUrls;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  	
		 String requestUri = request.getRequestURI();
	        for (String url : excludedUrls) {//判断是否为登陆或者退出URL,是则忽略拦截
	            if (requestUri.endsWith(url)) {
	                return true;
	            }
	        }
		if(request.getSession().getAttribute("user") == null)//如果验证成功返回true（这里直接写false来模拟验证失败的处理）
		{
			if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求响应头会有，x-requested-with  
	            response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
	        }else{
	        	//返回到登录界面
	        	response.sendRedirect("/gq/login/logOut.do");
	        }  
    		return false;
		}
    	else
    	{
    		return true;
    	}   	
	 }
}