package com.zbiti.iepe.framework.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.core.util.DateFormat;
import com.zbiti.core.util.Log;
import com.zbiti.iepe.framework.model.BaseMenu;
import com.zbiti.iepe.framework.model.BaseOrganization;
import com.zbiti.iepe.framework.model.BaseRole;
import com.zbiti.iepe.framework.model.BaseUser;
import com.zbiti.iepe.framework.smo.MenuSmo;
import com.zbiti.iepe.framework.smo.OrgSmo;
import com.zbiti.iepe.framework.smo.RoleSmo;
import com.zbiti.iepe.framework.smo.UserSmo;

/**
 * 登录控制层
 * 
 * @author zhaoqi
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	/**
	 * 日志
	 */
	private static Log LOG = Log.getLog(LoginController.class);

	/**
	 * 用户服务层
	 */
	@Resource
	UserSmo userSmoImpl;

	/**
	 * 角色服务层
	 */
	@Resource
	RoleSmo roleSmoImpl;

	/**
	 * 机构服务层
	 */
	@Resource
	OrgSmo orgSmoImpl;

	/**
	 * 菜单服务层
	 */
	@Resource
	MenuSmo menuSmoImpl;

	/**
	 * 跳主页
	 * 
	 * @return 路径
	 */
	@RequestMapping("/index")
	public String index() {
		return "login";
	}

	/**
	 * 跳初始页
	 * 
	 * @return 路径
	 */
	@RequestMapping("/indexPage")
	public String indexPage() {
		return "index";
	}

	/**
	 * 登录
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回
	 * @param session
	 *            会话
	 * @param model
	 *            返回对象
	 * @return 路径
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, ModelMap model) {
		String userAccount = request.getParameter("userAccount");
		String pwd = request.getParameter("pwd");
		String sys = request.getParameter("sys");

		LOG.info("==>检测到用户{}登录:登录IP：{}", userAccount, request.getRemoteAddr());
		if (userAccount != null && !"".equals(userAccount)) {
			BaseUser bu = null;
			if (sys != null && !"".equals(sys)) {
				try {
					bu = userSmoImpl.getUserByAccountAndSys(userAccount, sys);
				} catch (Exception e) {
					model.put("message", "查询用户出错！");
					LOG.info("==>查询用户{}出错！{}", userAccount, e.getMessage());
					return "login";
				}
			} else {
				try {
					bu = userSmoImpl.getUserByAccount(userAccount);
				} catch (Exception e) {
					e.printStackTrace();
					model.put("message", "查询用户出错！");
					LOG.info("==>查询用户{}出错！{}", userAccount, e.getMessage());
					return "login";
				}
			}

			if (bu == null) {
				model.put("message", "用户不存在！");
				LOG.info("==>用户{}不存在！", userAccount);
				return "login";
			}
			if (!bu.getAccountPasswordCd().equals(pwd)) {
				model.put("message", "用户密码不正确！");
				LOG.info("==>用户{}密码{}不正确！", userAccount, pwd);
				return "login";
			}

			// 用户拥有的角色
			List<BaseRole> roles = roleSmoImpl.getRolesByUser(bu.getUserId());
			bu.setRoles(roles);

			// 用户所属的机构
			BaseOrganization bo = orgSmoImpl.getOrgByUser(bu.getUserId());
			bu.setOrg(bo);

			// 用户所属的公司
			BaseOrganization bc = orgSmoImpl.getCompanyByOrg(bo.getOrgId());
			bu.setCompany(bc);
			ArrayList<BaseMenu> menuPermission = menuSmoImpl
					.distinctMenu(roles);
			List<?> resultList = menuSmoImpl.convertMenu(menuPermission);
			session.setAttribute("user", bu);
			session.setAttribute("userAccountName", bu.getAccountName());
			session.setAttribute("menuPermission", resultList);
			session.setAttribute("menuList", menuPermission);
			session.setAttribute("isOut", false);
			LOG.info("==>用户{}登录成功！", userAccount);
			session.setAttribute("loginTime", new Date());
			return "redirect:indexPage.do";
		}
		return "login";
	}

	/**
	 * 请求菜单json。
	 * 
	 * @throws IOException
	 */
	@RequestMapping("getMenusJson")
	public void getMenusJson(HttpServletResponse response, HttpSession session)
			throws IOException {
		String str = JSONArray.fromObject(
				session.getAttribute("menuPermission")).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(str);
	}

	/**
	 * 请求
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回
	 * @param session
	 *            会话
	 * @return 路径
	 */
	@RequestMapping("logOut")
	public String logOut(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String userAccount = (String) session.getAttribute("userAccountName");
		//boolean isOut = (Boolean) session.getAttribute("isOut");
		Date loginTime = (Date) session.getAttribute("loginTime");
		if (userAccount != null && "".equals(userAccount)) {
			LOG.info("==>用户{}退出登录！登录时间：{},退出登录时间：{}", userAccount, DateFormat
					.getStringCurrentTime(loginTime, "yyyy-MM-dd HH:mm:ss"),
					DateFormat.getStringCurrentDate());
			session.removeAttribute("user");
			session.removeAttribute("userAccountName");
			session.removeAttribute("menuPermission");
			session.removeAttribute("menuList");
			session.removeAttribute("dataAuthority");

		}

		/*if (isOut) {
			return "out_login";
		}*/
		return "login";
	}

	@RequestMapping("timeOut")
	public String timeOut() {
		return "timeOut";
	}
}
