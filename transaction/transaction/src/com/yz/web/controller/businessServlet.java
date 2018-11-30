package com.yz.web.controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yz.domain.Cart;

import com.yz.domain.Orders;
import com.yz.domain.Product;
import com.yz.domain.User;
import com.yz.page.PageBean;
import com.yz.page.QueryInfo;
import com.yz.service.OrderService;
import com.yz.service.ProductService;
import com.yz.service.UserService;
import com.yz.service.impl.OrderServiceImpl;
import com.yz.service.impl.ProductServiceImpl;
import com.yz.util.GenerateOrderNumberUtil;
import com.yz.util.PageUtil;

public class businessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actiontype = request.getParameter("actiontype");
		if(actiontype.equals("addShopCar")){
			doAddShopCar(request,response);
			return;
		}else if(actiontype.equals("gotoCartUI")){
			doGotoCart(request,response);
			return;
		}else if(actiontype.equals("delete")){
			doDeleteItem(request,response);
			doGotoCart(request,response);
			return;
		}else if(actiontype.equals("clearcart")){
			doClearCart(request,response);
			doGotoCart(request,response);
			return;
		}else if(actiontype.equals("confirmOrder")){
			doConfirmOrder(request,response);
			return;
		}else if(actiontype.equals("settleAccounts")){
			doSettleAccounts(request,response);
			return;
		}else if(actiontype.equals("listmeorder")){
			doListMeOrder(request,response);
			return;
		}else if(actiontype.equals("deleteOrder")){
			//删除我的订单
			doDeleteOrder(request,response);
			return;
		}else if(actiontype.equals("collect")){
			//收藏商品
			doCollect(request,response);
			return;
		}
	}
	private void doCollect(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
			request.setCharacterEncoding("utf-8");
			String productId=request.getParameter("id");
			User user = (User) request.getSession().getAttribute("user");
			//收藏成功与否，该页面都应该与原来页面商品数据一样
			ProductService service=new ProductServiceImpl();
			Product product=service.find(productId);
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(1800);
			if(!(product.getPublisher()).equals(user.getUsername()))
			{

				ProductService service2=new ProductServiceImpl();
				int result1=service2.findCollect(productId,user.getId());
				
				
				if(result1==0)
				{
					int result2=service2.addCollect(productId,user.getId());
					if(result2==1)
					{
						request.setAttribute("product", product);
						request.setAttribute("messageC", "收藏成功");
						request.getRequestDispatcher("/WEB-INF/jsp/page/showProduct.jsp").forward(request, response);
					}else
					{
						request.setAttribute("product", product);
						request.setAttribute("messageC", "您已经收藏了，不用再收藏了");
						request.getRequestDispatcher("/WEB-INF/jsp/page/showProduct.jsp").forward(request, response);
					}
				}else
				{
					request.setAttribute("product", product);
					request.setAttribute("messageC", "您已经收藏了，不用再收藏了");
					request.getRequestDispatcher("/WEB-INF/jsp/page/showProduct.jsp").forward(request, response);
				}
			}else
			{
				request.setAttribute("product", product);
				request.setAttribute("messageC", "自己发布的藏品不能收藏哦");
				request.getRequestDispatcher("/WEB-INF/jsp/page/showProduct.jsp").forward(request, response);
			}
		
	}
	//删除订单并返回
	private void doDeleteOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
			String ordernumber=request.getParameter("ordernumber");
			String url = "actiontype=listmeorder";
			OrderService service = new OrderServiceImpl();
				service.deleteOrder(ordernumber);
				QueryInfo info = PageUtil.QueryInfo(request);
				User user = (User) request.getSession().getAttribute("user");
					String purchaser = user.getUsername();
				PageBean pagebean = service.findmeOrder(info,purchaser);
				if(pagebean!=null){
					request.setAttribute("URL", url);
					request.setAttribute("pagebean", pagebean);
					request.getRequestDispatcher("/WEB-INF/jsp/user/userForm.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "订单查询失败！！");
					request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
				}
	}
	//查询卖家或买家所有订单
	private void doListMeOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String at = request.getParameter("actiontype"); 
		String url = "actiontype="+at;
		QueryInfo info = PageUtil.QueryInfo(request);
		User user = (User) request.getSession().getAttribute("user");
			String purchaser = user.getUsername();
		OrderService service = new OrderServiceImpl();
			PageBean pagebean = service.findmeOrder(info,purchaser);
		if(pagebean!=null){
			request.setAttribute("URL", url);
			request.setAttribute("user", user);
			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("/WEB-INF/jsp/user/userForm.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "订单查询失败！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
		}
	}
	//利用线程锁防止生成订单号重复，局限于当前服务器。
	private synchronized void doSettleAccounts(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("productid");
		String explains = request.getParameter("explains");
		//查询商品
		ProductService service = new ProductServiceImpl();
			Product product = service.find(id);
		//查询卖家信息
		UserService service1 = new UserService();
			User seller = service1.findByUsername(product.getPublisher());
		//用Session得到买家信息
		User purchaser = (User) request.getSession().getAttribute("user");
		//封装数据
		Orders order = new Orders();
			order.setPlaceordertime(new Date());
			order.setOrdernumber(GenerateOrderNumberUtil.buildOrderid(order.getPlaceordertime()));
			order.setProductid(product.getId());
			order.setProductname(product.getName());
			order.setImagepath(product.getUploadImage());
			order.setSeller(seller.getUsername());
			order.setPurchaser(purchaser.getUsername());
			order.setBuyertetlphone(purchaser.getPhone());
			order.setAddress(purchaser.getAddress());
			order.setTrading(product.getTrading());
			order.setAmount(product.getPrice());
			order.setProductname(product.getName());
			order.setOrderStatus("等待买家付款");
			order.setExplains(explains);
		OrderService service2 = new OrderServiceImpl();
			int result = service2.seveOrder(order);
		if(result>0){
			//订单生成后商品自动下架
			service.soldOUt(id);
			request.setAttribute("message", "订单已生成！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "订单生成失败，请稍后再试！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
		}
		
		
	}

	private void doConfirmOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String id =request.getParameter("id"); 
		ProductService service = new ProductServiceImpl();
		Product product = service.find(id);
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("message", "请先登录，再下订单！");
			request.setAttribute("action", "login2Buy");
			request.setAttribute("URL", id);
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
		}else if(product.getPublisher().equals(user.getUsername())){
			request.setAttribute("message", "对不起，这是您发布的宝贝，不能购买哦！");		
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
		}else{
			//把购买者加进商品表中
			service.setPurchaserIntoProduct(id,user.getUsername());
			Orders order = new Orders();
			order.setProductid(product.getId());
			order.setProductname(product.getName());
			order.setImagepath(product.getUploadImage());
			order.setSeller(product.getPublisher());
			order.setPurchaser(user.getRealname());
			order.setBuyertetlphone(user.getPhone());
			order.setTrading(product.getTrading());
			order.setAddress(user.getAddress());
			order.setAmount(product.getPrice());
		request.setAttribute("order", order);		
		request.getRequestDispatcher("/WEB-INF/jsp/page/order.jsp").forward(request, response);
		}
		
	}

	private void doClearCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.getMap().clear();//清除购物车
	}

	private void doDeleteItem(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
			cart.getMap().remove(id);//删除购物车中选中的一项
	}

	private void doGotoCart(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		User user= (User) request.getSession().getAttribute("user");
		if(user!=null){
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if(cart != null)
			{
				request.getSession().setAttribute("cart",cart);
				request.getRequestDispatcher("/WEB-INF/jsp/page/checkCart.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "购物车里空荡荡的哦！");
				request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
				return;
			}		
		}else{
			request.setAttribute("message", "您的登录身份已过期，请重新登录！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
		
	}

	private void doAddShopCar(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		User user= (User) request.getSession().getAttribute("user");
		if(user!=null){
			String id = request.getParameter("id");
			ProductService service = new ProductServiceImpl();
				Product product= service.find(id);
				Cart cart = (Cart) request.getSession().getAttribute("cart");
				if(cart == null)
				{
					cart = new Cart();
					request.getSession().setAttribute("cart",cart);
				}		
				cart.add(product);
				request.getRequestDispatcher("/WEB-INF/jsp/page/checkCart.jsp").forward(request, response);
			return;
		}else{
			request.setAttribute("message", "您的登录身份已过期，请重新登录！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
