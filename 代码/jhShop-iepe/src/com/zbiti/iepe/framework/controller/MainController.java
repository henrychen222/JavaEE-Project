package com.zbiti.iepe.framework.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.core.controller.BaseController;
import com.zbiti.core.util.Log;
import com.zbiti.iepe.framework.dao.UserDao;
import com.zbiti.iepe.framework.model.BaseUser;

/**
 * 首页
 * 
 * @author Administrator
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

	private Log log = Log.getLog(MainController.class);
	@Resource
	private UserDao userDao;

	/**
	 * 跳转到主页面
	 * 
	 * @return 主页面路径
	 */
	@RequestMapping("mainPage")
	public String toMainPage() {
		return "framework/mainPage";
	}

	/**
	 * 密码修改页面
	 * 
	 */
	@RequestMapping("modifyPwd")
	public String modifyPwd() {
		return "framework/pwd";
	}

	/**
	 * 密码修改页面
	 * 
	 */
	@RequestMapping("savePwd")
	public void savePwd(String oldPwd, String newPwd, HttpSession session,
			HttpServletResponse response) {
		String rs = "1";
		BaseUser user = (BaseUser) session.getAttribute("user");
		if (!user.getAccountPasswordCd().equals(oldPwd)) {
			rs = "2";
		} else {
			try {
				BaseUser bu = new BaseUser();
				bu.setUserId(user.getUserId());
				bu.setAccountPasswordCd(newPwd);

				userDao.editUser(bu);
			} catch (Exception e) {
				log.error("保存密码出错！{}", e.getMessage());
				rs = "3";
			}
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(rs);
		} catch (IOException ex) {
			log.error("响应失败！{}", ex.getMessage());
		}
	}
}
