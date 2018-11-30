package com.yz.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.domain.Product;
import com.yz.domain.ProductType;
import com.yz.domain.User;
import com.yz.service.ProductService;
import com.yz.service.impl.ProductServiceImpl;
import com.yz.util.ImageUploadUtil;

public class ProductManager extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String actionType=request.getParameter("actiontype");
		if(actionType.equals("addUI"))
		{
			//被userservlet替代
			doAddUI(request,response);
			return;
		}
		else if(actionType.equals("addtypeUI"))
		{
			request.getRequestDispatcher("/WEB-INF/jsp/admin/addProductType.jsp").forward(request, response);
		}
		else if(actionType.equals("listproduct"))
		{
			request.setCharacterEncoding("utf-8");
			ProductServiceImpl service=new ProductServiceImpl();
			List<Product> list=service.getAllProduct();
			request.setAttribute("product", list);
			
			request.getRequestDispatcher("/WEB-INF/jsp/admin/productlist.jsp").forward(request, response);
		}
		
		else if(actionType.equals("listproducttype"))
		{
			request.setCharacterEncoding("utf-8");
			ProductServiceImpl service=new ProductServiceImpl();
			List<ProductType> list=service.getAllProductType();
			request.setAttribute("producttype", list);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/producttypelist.jsp").forward(request, response);
		}
		else if(actionType.equals("delete"))
		{
			 String id=request.getParameter("id");
			 ProductService service=new ProductServiceImpl();
			 service.delete(id);
			 List<Product> list=service.getAllProduct();
			 request.setAttribute("product", list);
			 request.getRequestDispatcher("/WEB-INF/jsp/admin/productlist.jsp").forward(request, response);
		}
		else if(actionType.equals("recommend"))
		{
			//管理员推荐商品，在用户个人中心显示
			request.setCharacterEncoding("utf-8");
			String id=request.getParameter("id");
			ProductService service=new ProductServiceImpl();
				
				Product recommendProduct=new Product();
				recommendProduct=service.find(id);
				HttpSession session = request.getSession(); 
				session.setMaxInactiveInterval(1800); 
				session.setAttribute("recommendProduct", recommendProduct);
			service.updateProductRecomend(id);
			
			request.setAttribute("message","推荐成功");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
		
		else if(actionType.equals("update"))
		{
			String id=request.getParameter("id");
			ProductService service=new ProductServiceImpl();
			Product product=service.find(id);
			request.setAttribute("product",product);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/updateproduct.jsp").forward(request, response);
			return;
		}else if(actionType.equals("updateproduct"))
		{
			response.setCharacterEncoding("UTF-8"); 
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String id = request.getParameter("id");
			Product product = new Product();
			product.setName(name);
			product.setPrice(Float.parseFloat(price));
			product.setId(Integer.parseInt(id));
			
			ProductService service=new ProductServiceImpl();
			service.update(product);
				request.setAttribute("product", product);
			 request.setAttribute("message", "更新成功");
			 request.getRequestDispatcher("/WEB-INF/jsp/user/updateproduct.jsp").forward(request, response);
			
		}
		else if(actionType.equals("UploadImage")){
			response.setCharacterEncoding("UTF-8");  
			ProductService service=new ProductServiceImpl();
			String category=request.getParameter("category");
			User user = (User)request.getSession().getAttribute("user");
			Product pt = ImageUploadUtil.doUploadImage(request,response);
			
			//int categoryID=service.findCategoryID(pt.getCategory());
			
			int categoryID=Integer.valueOf(pt.getCategory());
				pt.setCategory(category);
				pt.setCategoryID(categoryID);
				pt.setCreatetime(new Date());
				pt.setUpdatetime(new Date());
				pt.setPublisher(user.getUsername());
			int result = service.addProduct(pt);
			if(result==0){
				request.setAttribute("message", "宝贝发布未成功！再去发布试试！！");
				request.getRequestDispatcher("/WEB-INF/jsp/user/publishGoods.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "恭喜，宝贝发布成功！");
				request.getRequestDispatcher("/WEB-INF/jsp/user/publishGoods.jsp").forward(request, response);
			}
			return;
		}else {
			
		}
		
	}

	private void doAddUI(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(); 
		session.setMaxInactiveInterval(1800); 
		User user= (User) session.getAttribute("user");
		if(user==null){
			request.setAttribute("URL", "/servlet/ProductManager?actiontype=addUI");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
		}else{
		request.getRequestDispatcher("/WEB-INF/jsp/admin/addProduct.jsp").forward(request, response);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
