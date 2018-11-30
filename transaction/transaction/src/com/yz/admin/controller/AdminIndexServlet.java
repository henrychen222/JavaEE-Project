package com.yz.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.domain.Admin;
import com.yz.service.AdminService;
import com.yz.service.impl.AdminServiceImpl;
import com.yz.util.Md5Util;

public class AdminIndexServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			String actiontype = request.getParameter("actiontype");
			if("loginUI".equals(actiontype)){
				request.getRequestDispatcher("/WEB-INF/jsp/admin/AdminLogin.jsp").forward(request, response);
				return;
			}else if("actionLogin".equals(actiontype)){
				doActionLogin(request,response);
				return;
			}else if("actionLogExit".equals(actiontype)){
				doActionLoginExit(request,response);
				return;
			}
	}

	private void doActionLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
//		request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
		
		String name = request.getParameter("name");
		String password = Md5Util.md5(request.getParameter("password"));
		
		AdminService adminService = new AdminServiceImpl();
			Admin admin = adminService.Login(name,password);
		if(admin==null)
		{
			request.setAttribute("message", "管理员不存在或密码错误！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/admin/AdminLogin.jsp").forward(request, response);
			return;
		}else if(name!=null&&name.trim()!=""
			&&"4QrcOUm6Wau+VuBX8g+IPg==".equals(password))
		{
			request.setAttribute("name", name);
			request.setAttribute("message", "系统检测您是首次登录，请修改默认密码后方可登录！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/return2UpPassword.jsp").forward(request, response);
			return;
		}else{
			String type = admin.getType();
			String power = adminService.findPower(type);
			
			request.getSession().setAttribute("admin", admin);
			request.setAttribute("power", power);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/index.jsp").forward(request, response);
			return;
		}
	}

	private void doActionLoginExit(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.removeAttribute("admin");
//			session.invalidate();//销毁session
			response.sendRedirect("/transaction/index.jsp");
			return;
		}else{
			request.setAttribute("message", "您的登录身份已过期，请重新登录！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/admin/AdminLogin.jsp").forward(request, response);
			return;
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
	}
	
}
