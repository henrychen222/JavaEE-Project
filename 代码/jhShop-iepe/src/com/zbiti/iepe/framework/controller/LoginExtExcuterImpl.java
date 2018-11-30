package com.zbiti.iepe.framework.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zbiti.core.util.Log;
import com.zbiti.iepe.framework.smo.UserSmo;
import com.zbiti.iepe.framework.util.LoginExtExcuter;

/**
 * 登录扩展
 * 
 * @author zhaoqi
 * 
 */
public class LoginExtExcuterImpl implements LoginExtExcuter {

	/**
	 * 日志
	 */
	private static final Log LOGGER = Log.getLog(LoginExtExcuterImpl.class);

	/**
	 * 用户服务层
	 */
	@Resource(name = "userSmoImpl")
	UserSmo usersmo;

	@Override
	public void afterLogin(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		session.setAttribute("ext", "扩展对象");
		LOGGER.debug("登录扩展成功：{}！", session.getAttribute("ext"));
	}

	@Override
	public void afterLoginOut(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		session.removeAttribute("ext");
		LOGGER.debug("登出扩展成功：{}！", session.getAttribute("ext"));
	}
}
