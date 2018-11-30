package com.jd.web.framework.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 扩展登录.如需扩展登录操作，需要实现该接口 并修改spring配置文件中的loginExtExcuterImpl bean的指向类为新的操作类
 * 
 * @author zhaoqi
 * 
 */
public interface LoginExtExcuter
{

	/**
	 * 扩展登录操作
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            响应
	 * @param session
	 *            会话信息
	 */
	public void afterLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session);

	/**
	 * 扩展登出操作
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            响应
	 * @param session
	 *            会话信息
	 */
	public void afterLoginOut(HttpServletRequest request, HttpServletResponse response, HttpSession session);
}
