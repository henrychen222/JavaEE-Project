package com.yz.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yz.domain.Product;
import com.yz.domain.ProductType;
import com.yz.domain.User;
import com.yz.page.PageBean;
import com.yz.page.QueryInfo;
import com.yz.service.ProductService;
import com.yz.service.UserService;
import com.yz.service.impl.ProductServiceImpl;
import com.yz.util.PageUtil;

public class PageAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actiontype = request.getParameter("actiontype");
		if("dolistAll".equals(actiontype)){
			doListOneLevelProducts(request,response);
			return;
		}else if("dosecondlist".equals(actiontype)){
			doListSecondLevelProducts(request,response);
			return;
		}else if("dotypelist".equals(actiontype)){
			doListThreeLevelProducts(request,response);
			return;
		}else if("showProduct".equals(actiontype)){
			doShowProduct(request,response);
			return;
		}
		
	}
	
	private void doShowProduct(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		ProductService service = new ProductServiceImpl();
			Product product= service.find(id);
				int clickcount = product.getClickcount()+1;
				service.updateClickcount(clickcount,id);
			UserService service1 = new UserService();
				User user = service1.findByUsername(product.getPublisher());
					product.setRealname(user.getRealname());
					product.setAddress(user.getAddress());
					product.setPhone(user.getPhone());
		request.setAttribute("product", product);
		request.getRequestDispatcher("/WEB-INF/jsp/page/showProduct.jsp").forward(request, response);
	}
	
	private void doListThreeLevelProducts(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String categoryID = request.getParameter("id");
		String style = request.getParameter("style");
		String at = request.getParameter("actiontype");
		String url = "actiontype="+at+"&id="+categoryID;
		QueryInfo info = PageUtil.QueryInfo(request);
		
		ProductService service = new ProductServiceImpl();
			ProductType pt = service.findThreeLevelNameById(categoryID);
			ProductType pt1  = service.findUpOneLevelName(String.valueOf(pt.getPid()));
			String OneLevelUrl = "actiontype=dolistAll"+"&id="+pt1.getId();
			ProductType pt2  = service.findUpOneLevelName(categoryID);
			String SecondLevelUrl = "actiontype=dosecondlist"+"&id="+pt2.getId();
			PageBean pagebean = service.findThreeLevelProducts(info,categoryID);
		
		if(pagebean!=null){
			request.setAttribute("pagebean",pagebean );
		}else{
			request.setAttribute("message", "很抱歉，您想找的宝贝还没人出售！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
		request.setAttribute("URL", url);
		request.setAttribute("OneLevelUrl", OneLevelUrl);
		request.setAttribute("SecondLevelUrl", SecondLevelUrl);
		request.setAttribute("title",pt1.getName() );
		request.setAttribute("title2", pt2.getName());
		request.setAttribute("title3", pt.getName());
		request.setAttribute("style", style);
		if(style.equals("image")){
			request.getRequestDispatcher("/WEB-INF/jsp/page/showimageProducts.jsp").forward(request, response);
		}else if(style.equals("imagetext")){
			request.getRequestDispatcher("/WEB-INF/jsp/page/showImg-TextProducts.jsp").forward(request, response);
		}
	}
	
	private void doListSecondLevelProducts(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String at = request.getParameter("actiontype");
		String style = request.getParameter("style");
		String id = request.getParameter("id");
		String url = "actiontype="+at+"&id="+id;
		String url2 = "actiontype=dotypelist";
		ProductService service = new ProductServiceImpl();
			ProductType type = service.findUpOneLevelName(id);
			String OneLevelUrl = "actiontype=dolistAll"+"&id="+type.getId();
			String SecondLevelTitle = service.findSecondLevelName(id);
			ArrayList<ProductType> type2 = service.findThreeLevelNameBypid(id);
		QueryInfo info = PageUtil.QueryInfo(request);
		ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(Integer.valueOf(id));
		ArrayList<Integer> list2 = service.findThreeLevelIdByPid(list);
		PageBean pagebean = service.findOneLevelAllProducts(info,list2);
		request.setAttribute("URL", url);
		request.setAttribute("OneLevelUrl", OneLevelUrl);
		request.setAttribute("SecondLevelUrl", "");
		request.setAttribute("URL2", url2);
		request.setAttribute("style", style);
		request.setAttribute("title", type.getName());
		request.setAttribute("title2", SecondLevelTitle);
		request.setAttribute("title3", "");
		request.setAttribute("type", type2);
		request.setAttribute("pagebean", pagebean);
		if(style.equals("image")){
			request.getRequestDispatcher("/WEB-INF/jsp/page/showimageProducts.jsp").forward(request, response);
		}else if(style.equals("imagetext")){
			request.getRequestDispatcher("/WEB-INF/jsp/page/showImg-TextProducts.jsp").forward(request, response);
		}
	}

	private void doListOneLevelProducts(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String at = request.getParameter("actiontype");
		String style = request.getParameter("style");
		int id = Integer.parseInt(request.getParameter("id"));
		String url = "actiontype="+at+"&id="+id;
		String url2 = "actiontype=dosecondlist";
		
		/*获取传递过来的页面的url
		String url = request.getServletPath();//获取请求servlet
		String url2 = request.getQueryString();//获取其参数
		*/
		ProductService service = new ProductServiceImpl();
		//查找一级标题
		String OneLevelTitle = service.findOneLevelNameByid(id);
		//返回  二级关联所有id
			ArrayList<Integer> list = service.findTwoLevelIdByPid(id);
		//返回  三级关联所有id
			ArrayList<Integer> list2 = service.findThreeLevelIdByPid(list);
		//查找所有一级类别的宝贝
			ArrayList<ProductType> type = service.findSecondLevelNameByid(list,list2);
		QueryInfo info = PageUtil.QueryInfo(request);	
		PageBean pagebean = service.findOneLevelAllProducts(info,list2);
		
		request.setAttribute("URL", url);
		request.setAttribute("OneLevelUrl", url);
		request.setAttribute("SecondLevelUrl", "url");
		request.setAttribute("URL2", url2);
		request.setAttribute("style", style);
		request.setAttribute("title", OneLevelTitle);
		request.setAttribute("title2", "");
		request.setAttribute("title3", "");
		request.setAttribute("type", type);
		request.setAttribute("pagebean", pagebean);
		if(style.equals("image")){
			request.getRequestDispatcher("/WEB-INF/jsp/page/showimageProducts.jsp").forward(request, response);
		}else if(style.equals("imagetext")){
			request.getRequestDispatcher("/WEB-INF/jsp/page/showImg-TextProducts.jsp").forward(request, response);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
