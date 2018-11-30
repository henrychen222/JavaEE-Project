package com.yz.admin.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yz.domain.Admin;
import com.yz.service.AdminService;
import com.yz.service.impl.AdminServiceImpl;
import com.yz.util.Md5Util;
import com.yz.web.formbean.AdminFormBean;

public class AdminManager extends HttpServlet {

	 
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			String actiontype = request.getParameter("actiontype");
			if("addUI".equals(actiontype))
			{
				gotoAdminUI(request,response);
				return;
			}else if("updatePasswordUI".equals(actiontype))
			{
				doUpdatePasswordUI(request,response);
				return;
			}else if("addAdmin".equals(actiontype))
			{
				doAddAdmin(request,response);
				return;
			}else if("ListAdmin".equals(actiontype))
			{
				doListAdmin(request,response);
				return;
			}else if("findAdmin".equals(actiontype))
			{
				doFindAdmin(request,response);
				return;
			}else if("updateInitialPassword".equals(actiontype))
			{
				doUpdateInitialPassword(request,response);
				return;
			}else if("updatePassword".equals(actiontype))
			{
				doUpdatePassword(request,response);
				return;
			}else if("update".equals(actiontype))
			{
				doUpdate(request,response);
				return;
			}else if("delete".equals(actiontype))
			{
				doDeleteAdmin(request,response);
				return;
			}
			
	}

	//增加管理员
	private void doAddAdmin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		
		AdminFormBean adminFormBean = new AdminFormBean();
			adminFormBean.setName(name);
			adminFormBean.setPassword(password);
			adminFormBean.setType(type);
			adminFormBean.setDescription(description);
		AdminService service = new AdminServiceImpl();
			int result = service.addAdmin(adminFormBean);
		if(result>0){
			gotoAdminUI(request,response);
		}else{
			request.setAttribute("message","添加管理员失败！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
	}
	
	//重置管理员初始密码
	private void doUpdateInitialPassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String AdminName = request.getParameter("name");
		AdminName = new String(AdminName.getBytes("iso-8859-1"),"utf-8");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		AdminService service = new AdminServiceImpl();
			String admin = service.findAdminName(AdminName);
		if(admin==null){
			request.setAttribute("message","服务器内部出错！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}else if(password==null || password.trim()==""
			||password1==null || password1.trim()==""
				||password2==null || password2.trim()==""){
			request.setAttribute("name",AdminName);
			request.setAttribute("message", "输入密码不能为空！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/admin/updatePassword.jsp").forward(request, response);
			return;
		}else{
			String pas = Md5Util.md5(password);
			String pas1 = Md5Util.md5(password1);
			String pas2 = Md5Util.md5(password2);
		  	int result=service.findPasswordByAdmin(admin,pas);
				if(result==0){
					request.setAttribute("name",AdminName);
					request.setAttribute("message", "原始密码错误！！！");
					request.getRequestDispatcher("/WEB-INF/jsp/admin/updatePassword.jsp").forward(request, response);
					return;
				}else if("123456".equals(password1)){
					request.setAttribute("name",AdminName);
					request.setAttribute("message", "重置密码不能设置为初始密码！！！");
					request.getRequestDispatcher("/WEB-INF/jsp/admin/updatePassword.jsp").forward(request, response);
					return;
				}else if(!pas1.equals(pas2)){
					request.setAttribute("name",AdminName);
					request.setAttribute("message", "两次密码不一致！！！");
					request.getRequestDispatcher("/WEB-INF/jsp/admin/updatePassword.jsp").forward(request, response);
					return;
				}else{
					AdminService service1 = new AdminServiceImpl();
						int result1=service1.updatePasswordByAdmin(admin,pas1);
					if(result1>0){
						request.setAttribute("message","重置密码成功！！！");
						request.getRequestDispatcher("/WEB-INF/jsp/message/return2AdminLogin.jsp").forward(request, response);
					}else{
						request.setAttribute("message","重置密码失败！！！");
						request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
					}
					
				}
				
		  }
		
	}
	
	//按ID查找管理员
	private void doFindAdmin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String action = request.getParameter("action");
		
		AdminService service = new AdminServiceImpl();
			Admin admin = service.findAdmin(id);
		if(admin!=null&&"updateAdmin".equals(action)){
			request.setAttribute("list", admin);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/updateAdmin.jsp").forward(request, response);
		}else if(admin!=null&&"updateAdminInformation".equals(action)){
			request.setAttribute("list", admin);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/updateAdminInformation.jsp").forward(request, response);
		}else if(admin!=null&&"updateAdminManager".equals(action)){
			request.setAttribute("list", admin);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/showAdminManager.jsp").forward(request, response);
		}else{
			request.setAttribute("message","查找管理员失败！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
	}
	
	//修改管理员、管理员权限、管理员个人资料
	private void doUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String action = request.getParameter("action");
		Admin at = new Admin();
			at.setId(id);
			at.setName(name);
			at.setType(type);
			at.setDescription(description);
			at.setUpdatetime(new Date());
			
		AdminService service = new AdminServiceImpl();
			int result=service.updateAdmin(at);
		if(result>0&&"updateAdmin".equals(action)){
			gotoAdminUI(request,response);
		}else if(result>0&&"updateAdminManager".equals(action)){
			doListAdmin(request,response);
		}else if(result>0&&"updateAdminInformation".equals(action)){
			request.setAttribute("message","资料保存成功！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
		}else{
			request.setAttribute("message","更新失败！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;	
		}
	}
	
	//重置管理员密码
	private void doUpdatePassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		if(id!=null&&id.trim()!=""
			&&password!=null&&password.trim()!=""
				&&password1!=null&&password1.trim()!=""
					&&password2!=null&&password2.trim()!="")
		{
			String pas = Md5Util.md5(password);
			String pas1 = Md5Util.md5(password1);
			String pas2 = Md5Util.md5(password2);
		  AdminService service = new AdminServiceImpl();
		  	int result=service.findPassword(id,pas);
				if(result>0)
				{
					if(pas1.equals(pas2))
					{
						AdminService service1 = new AdminServiceImpl();
							int result1=service1.updatePassword(id,pas1);
							if(result1>0)
							{
								request.setAttribute("message","修改密码成功！！！");
								request.getRequestDispatcher("/WEB-INF/jsp/message/return2AdminLogin.jsp").forward(request, response);
							}else
							{
								request.setAttribute("message","修改密码失败！！！");
								request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
							}
					}else
					{
						request.setAttribute("id",id);
						request.setAttribute("message", "两次密码不一致！！！");
						request.getRequestDispatcher("/WEB-INF/jsp/admin/updatePassword.jsp").forward(request, response);
					}
				}else
				{
					request.setAttribute("id",id);
					request.setAttribute("message", "原始密码错误！！！");
					request.getRequestDispatcher("/WEB-INF/jsp/admin/updatePassword.jsp").forward(request, response);
				}
		}else{
			request.setAttribute("id",id);
			request.setAttribute("message", "输入密码不能为空！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/admin/updatePassword.jsp").forward(request, response);
			return;
		}
		
	}
	
	//删除管理员
	private void doDeleteAdmin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		AdminService service = new AdminServiceImpl();
			int result=service.deleteAdmin(id);
		if(result>0){
			gotoAdminUI(request,response);
		}else{
			request.setAttribute("message","删除管理员失败！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
	}
	
	//查询所有的管理员
	private void doListAdmin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		AdminService service = new AdminServiceImpl();
			List<Admin> list = service.list();
		if(list!=null){
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/showAdmins.jsp").forward(request, response);
		}else{
			request.setAttribute("message","跳转到增加管理员页面和显示已有管理员失败！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
	}

	//跳转到增加管理员页面和显示已有管理员
	private void gotoAdminUI(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		AdminService service = new AdminServiceImpl();
			List<Admin> list = service.list();
		if(list!=null){
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/admin.jsp").forward(request, response);
		}else{
			request.setAttribute("message","跳转到增加管理员页面和显示已有管理员失败！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
	}
	
	//跳转更新密码页面
	private void doUpdatePasswordUI(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		if("changeAgain".equals(action)){
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/updatePassword.jsp").forward(request, response);
		}else if("firstChange".equals(action)){
			String name = request.getParameter("name");
			name = new String(name.getBytes("iso-8859-1"),"utf-8");//防止中文乱码
			request.setAttribute("name", name);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/updateInitialPassword.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}