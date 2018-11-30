package com.jd.web.framework.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;


/**
 * 登录扩展切入点
 * 
 * @author zhaoqi
 * 
 */
public class LoginExt
{

	/**
	 * 登录扩展执行器
	 */
	private LoginExtExcuter loginExtExcuter;

	public LoginExtExcuter getLoginExtExcuter()
	{
		return loginExtExcuter;
	}

	public void setLoginExtExcuter(LoginExtExcuter loginExtExcuter)
	{
		this.loginExtExcuter = loginExtExcuter;
	}

	/**
	 * 登录后操作
	 * 
	 * @param point
	 *            切入点
	 */
	public void afterLogin(JoinPoint point)
	{
		Object[] obj = point.getArgs();
		HttpServletRequest request = (HttpServletRequest) obj[0];
		HttpServletResponse response = (HttpServletResponse) obj[1];
		HttpSession session = (HttpSession) obj[2];
		String userAccount = request.getParameter("userAccount");
		Object user = session.getAttribute("user");
//		if (user != null && ((BaseUser) user).getAccountName().equals(userAccount) && loginExtExcuter != null)
//		{
//			// session中存在user,且登陆账号与请求中的账号一致
//			loginExtExcuter.afterLogin(request, response, session);
//		}
	}

	/**
	 * 登出后操作
	 * 
	 * @param point
	 *            切入点
	 */
	public void afterLoginOut(JoinPoint point)
	{
		Object[] obj = point.getArgs();
		HttpServletRequest request = (HttpServletRequest) obj[0];
		HttpServletResponse response = (HttpServletResponse) obj[1];
		HttpSession session = (HttpSession) obj[2];

		if (session.getAttribute("user") == null && loginExtExcuter != null)
		{
			loginExtExcuter.afterLoginOut(request, response, session);
		}
	}
}
