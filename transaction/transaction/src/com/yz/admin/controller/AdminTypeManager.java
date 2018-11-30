package com.yz.admin.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yz.domain.AdminType;
import com.yz.service.AdminTypeService;
import com.yz.service.impl.AdminTypeServiceImpl;

public class AdminTypeManager extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			 
			String actiontype = request.getParameter("actiontype");
		if("addUI".equals(actiontype))
		{
			gotoAdminTypeUI(request,response);
			return ;
		}else if("addManagerType".equals(actiontype))
		{
			doAddAdminType(request,response);
			return;
		}else if("update".equals(actiontype))
		{
			doUpdateAdminType(request,response);
			return;
		}else if("delete".equals(actiontype))
		{
			doDeleteAdminType(request,response);
			return;
		}else if("findAdminType".equals(actiontype))
		{
			doFindAdminType(request,response);
			return;
		}
		
	}
	//查找管理员类型
	private void doFindAdminType(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		AdminTypeService service = new AdminTypeServiceImpl();
			AdminType at = service.findAdminType(name);
		request.setAttribute("list", at);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/updateAdminType.jsp").forward(request, response);
		return;
	}
	
	//更新管理员类型及权限
	private void doUpdateAdminType(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		String power = request.getParameter("power");
		String description = request.getParameter("description");
		AdminType at = new AdminType();	
			at.setName(name);
			at.setPower(power);
			at.setDescription(description);
			at.setUpdatetime(new Date());
			
		AdminTypeService service = new AdminTypeServiceImpl();
			service.updateAdminType(at);
		gotoAdminTypeUI(request,response);
	}
	
	//删除管理员类型
	private void doDeleteAdminType(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		AdminTypeService service=new AdminTypeServiceImpl();
		service.deleteAdminType(name);
		gotoAdminTypeUI(request,response);
	}

	//增加管理员类型
	private void doAddAdminType(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String power = request.getParameter("power");
		String description = request.getParameter("description");
		
		//对信息进行校验........
		if(name!=null&&name.trim()!=""
			&&power!=null&&power.trim()!=""
			 &&description!=null&&description.trim()!="")
		{
		AdminType at = new AdminType();	
			at.setName(name);
			at.setPower(power);
			at.setDescription(description);
			at.setUpdatetime(new Date());
			at.setCreatetime(new Date());
		AdminTypeService service = new AdminTypeServiceImpl();
			service.addAdminType(at);
		gotoAdminTypeUI(request,response);
		}else
		{
			request.setAttribute("message", "您的请求参数不正确");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return ;
		}
	}

	//跳转增加管理员类型页面和显示已有管理员类型
	private void gotoAdminTypeUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		AdminTypeService service=new AdminTypeServiceImpl();
		List<AdminType> list=service.list();
        request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/adminType.jsp").forward(request, response);
		return ;
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
