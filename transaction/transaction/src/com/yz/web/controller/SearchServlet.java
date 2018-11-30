package com.yz.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yz.page.PageBean;
import com.yz.page.QueryInfo;
import com.yz.service.ProductService;
import com.yz.service.impl.ProductServiceImpl;
import com.yz.util.PageUtil;

public class SearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actiontype = request.getParameter("actiontype");
		if("search".equals(actiontype)){
			doSearchProducts(request,response);
			return;
		}else if("searchpaging".equals(actiontype)){
			doSearchPaging(request,response);
			return;
		}
		
	}

	private void doSearchPaging(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		search = new String(search.getBytes("iso-8859-1"),"utf-8");
		QueryInfo info = PageUtil.QueryInfo(request);
		if(search!=null&&search.trim()!=""){
			//
			ProductService service = new ProductServiceImpl();
			PageBean pagebean = service.searchProduct(info,search);
			if(pagebean!=null){
				request.setAttribute("pagebean",pagebean );
				request.setAttribute("String",search );
				
			}else{
				request.setAttribute("message", "很抱歉，您想找的宝贝还没人出售！！！");
				request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/WEB-INF/jsp/page/searchResult.jsp").forward(request, response);	
		}else{
			return;
		}
	}

	private void doSearchProducts(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		QueryInfo info = PageUtil.QueryInfo(request);
		if(search!=null&&search.trim()!=""){
			//
			ProductService service = new ProductServiceImpl();
			PageBean pagebean = service.searchProduct(info,search);
			if(pagebean!=null){
				request.setAttribute("pagebean",pagebean );
				request.setAttribute("String",search );
				
			}else{
				request.setAttribute("message", "很抱歉，您想找的宝贝还没人出售！！！");
				request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
				return;
			}
			request.getRequestDispatcher("/WEB-INF/jsp/page/searchResult.jsp").forward(request, response);	
		}else{
			return;
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
