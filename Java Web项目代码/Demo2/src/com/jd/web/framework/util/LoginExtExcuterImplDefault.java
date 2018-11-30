package com.jd.web.framework.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录扩展默认执行器
 * 
 * @author zhaoqi
 * 
 */
public class LoginExtExcuterImplDefault implements LoginExtExcuter
{

	@Override
	public void afterLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{

	}

	@Override
	public void afterLoginOut(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{

	};
}
