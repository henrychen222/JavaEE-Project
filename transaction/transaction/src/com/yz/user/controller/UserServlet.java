package com.yz.user.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.yz.domain.Collect;
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
import com.yz.util.Md5Util;
import com.yz.util.PageUtil;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actiontype = request.getParameter("actiontype");
		if("register".equals(actiontype))
		{
				doRegister(request,response);
				return;
		}else if("login".equals(actiontype))
		{
			doLogin(request,response);
			return;
		}else if("login2".equals(actiontype))
		{
			doLogin2(request,response);
			return;
		}else if("login3".equals(actiontype))
		{
			doLogin3(request,response);
			return;
		}
		else if("login4".equals(actiontype))
		{
			doLogin4(request,response);
			return;
		}
		else if("login2Buy".equals(actiontype))
		{
			doLogin2Buy(request,response);
			return;
		}
		else if("findPasswordUI".equals(actiontype))
		{
			//用户找回密码的跳转路径
			request.getRequestDispatcher("/WEB-INF/jsp/user/findPassword1.jsp").forward(request, response);
			return;
		}else if("findUsername".equals(actiontype))
		{
			//用户找回密码前先确定该用户是否存在
			doFindUsername(request,response);
			return;
		}else if("findEmail".equals(actiontype))
		{
			//输入验证邮箱，并验证是否与绑定邮箱一直
			try {
				doFindEmail(request,response);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return;
		}else if("findEmailCode".equals(actiontype))
		{
			//输入邮箱验证码
			doFindEmailCode(request,response);
			return;
		}
		else if("centerUI".equals(actiontype))
		{
			String user=request.getParameter("user");
			request.setAttribute("user", user);
			HttpSession session = request.getSession(); 
			session.setMaxInactiveInterval(1800); 
			request.getRequestDispatcher("/WEB-INF/jsp/user/userCenter.jsp").forward(request, response);
			return;
		}else if("logOut".equals(actiontype))
		{
			HttpSession session = request.getSession();
			if(session!=null){
				//只注销了user对象，session还在
				session.removeAttribute("user");
				//销毁session
				session.invalidate();
				ProductService service = new ProductServiceImpl();
					List<Product> products = service.getAllProduct();
				request.setAttribute("products", products);
				request.getRequestDispatcher("/WEB-INF/jsp/page/index.jsp").forward(request, response);
				return;
			}else{
				request.setAttribute("message", "您的登录身份已过期，请重新登录！！！");
				request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
				return;
			}
		}else if("loginUI".equals(actiontype))
		{	
			String URL = request.getParameter("URL");
			request.setAttribute("URL", URL);
			request.setAttribute("action", "login");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}else if("loginUI2".equals(actiontype))
		{	//专门为未登录时发布宝贝做提示并跳转到登陆页面所用
			request.setAttribute("message", "请先登录再发布");
			request.setAttribute("action", "login2");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
		else if("loginUI3".equals(actiontype))
		{	//专门为未登录时查看我的订单做提示并跳转到登陆页面所用
			request.setAttribute("message", "请先登录再查看订单");
			request.setAttribute("action", "login3");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
		else if("registerUI".equals(actiontype))
		{
			request.getRequestDispatcher("/WEB-INF/jsp/user/userRegister.jsp").forward(request, response);
			return;
		}else if("updatePasswordUI".equals(actiontype))
		{
			doUpdatePasswordUI(request,response);
			return;
		}
		else if("updatePassword".equals(actiontype))
		{
			//知道密码时，在个人中心修改密码
			doUpdatePassword(request,response);
			return;
		}else if("updatePassword2".equals(actiontype))
		{
			//忘记密码，通过邮箱验证时修改密码
			doUpdatePassword2(request,response);
			return;
		}
		else if("updateCenterInfo".equals(actiontype))
		{
			//跳转到个人中心页面
			doUpdateCenterInfo(request,response);
			return;
		}
		else if("showSelfInfoUI".equals(actiontype))
		{
			//跳转到个人资料页面
			doshowSelfInfoUI(request,response);
			return;
		}
		else if("updateSelfInfo".equals(actiontype))
		{
			//修改个人资料
			doUpdateSelfInfo(request,response);
			return;
		}else if("publishGoodsUI".equals(actiontype))
		{
			//跳转到发布商品页面
			doPublishGoodsUI(request,response);
			return;
		}
		else if("listproduct".equals(actiontype))
		{
			//跳转到个人闲置商品列表
			doListproduct(request,response);
			return;
		}else if("listSoldOutProduct".equals(actiontype))
		{
			//跳转到已经下架的商品列表
			doListSoldOutProduct(request,response);
			return;
		}
		else if("deleteProduct".equals(actiontype))
		{
			//下架商品
			doDeleteProduct(request,response);
			return;
		}else if("deleteSoldOutProduct".equals(actiontype))
		{
			//隐藏已下架的商品
			doDeleteSoldOutProduct(request,response);
			return;
		}
		else if("updateProduct".equals(actiontype))
		{
			//更新商品
			doUpdateProduct(request,response);
			return;
		}else if("listCollect".equals(actiontype))
		{
			//展示收藏的商品
			doListCollect(request,response);
			return;
		}else if("deleteCollect".equals(actiontype))
		{
			//删除收藏的商品
			doDeleteCollect(request,response);
			return;
		}
	}

	private void doDeleteSoldOutProduct(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		 request.setCharacterEncoding("utf-8");
		 String id=request.getParameter("id");
		 ProductService service=new ProductServiceImpl();
		 //隐藏已下架的商品
		 int result=service.deleteSoldOUt(id);
		 if(result==1)
		 	{
				User user = (User)request.getSession().getAttribute("user");
				String username = user.getUsername();
				String url = "actiontype=listproduct"+"&username="+username;
				QueryInfo info = PageUtil.QueryInfo(request);
				ProductServiceImpl service2=new ProductServiceImpl();
				PageBean pagebean =service2.getUserSoldOutProduct(info,username);
				request.setAttribute("pagebean", pagebean);
				request.setAttribute("URL", url);
				request.getRequestDispatcher("/WEB-INF/jsp/user/soldOut.jsp").forward(request, response);
		 	}else
		 	{
		 		request.setAttribute("message", "删除下架商品失败，请等等再做尝试");
		 		request.getRequestDispatcher("/WEB-INF/jsp/user/message.jsp").forward(request, response);
		 	}
		
	}



	private void doListSoldOutProduct(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");
		String at = request.getParameter("actiontype");
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null)
		{
			String url = "actiontype="+at;
			QueryInfo info = PageUtil.QueryInfo(request);
			ProductServiceImpl service=new ProductServiceImpl();
				PageBean pagebean =service.getUserSoldOutProduct(info,user.getUsername());
			request.setAttribute("pagebean", pagebean);
			request.setAttribute("URL", url);
			request.getRequestDispatcher("/WEB-INF/jsp/user/soldOut.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "请先登录再查看您的下架宝贝！");
			request.setAttribute("action", "login4");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
	}



	private void doDeleteCollect(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		String productId=request.getParameter("productId");
		String userId=request.getParameter("userId");
		ProductService service=new ProductServiceImpl();
		int result=service.deleteCollect(productId);
		if(result==1)
		{
			
			UserService service2=new UserService();
			List<Collect> list=new ArrayList<Collect>();
			list=service2.getCollectList(userId);
			
			List<Product> list2=new ArrayList<Product>();
			Iterator<Collect> it = list.iterator();
			while (it.hasNext()) {
				Collect collect=it.next();
				/*把int型的id 转换成string 型的，原因是ProductServiceImpl
				 里已经有通过string型的id获得Product对象，无需再重写方法
				 */
				 productId=Integer.toString(collect.getProductId());
				ProductService service3=new ProductServiceImpl();
				Product product=service3.find(productId);
				list2.add(product);
				
			}
			User user=(User)request.getSession().getAttribute("user");
			request.setAttribute("user", user);
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("/WEB-INF/jsp/user/userCollect.jsp").forward(request, response);
			
		}else
		{
			request.setAttribute("message", "删除收藏失败，请重试");
			
			request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
		}
	}

	private void doListCollect(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		String userId=request.getParameter("id");
		UserService service=new UserService();
		List<Collect> list=new ArrayList<Collect>();
		list=service.getCollectList(userId);
		
		List<Product> list2=new ArrayList<Product>();
		Iterator<Collect> it = list.iterator();
		while (it.hasNext()) {
			Collect collect=it.next();
			/*把int型的id 转换成string 型的，原因是ProductServiceImpl
			 里已经有通过string型的id获得Product对象，无需再重写方法
			 */
			String productId=Integer.toString(collect.getProductId());
			ProductService service2=new ProductServiceImpl();
			Product product=service2.find(productId);
			list2.add(product);
			
		}
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("/WEB-INF/jsp/user/userCollect.jsp").forward(request, response);
	}

	private void doLogin3(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=Md5Util.md5(request.getParameter("password"));
		UserService service=new UserService();
		User user=service.login(username, password);
		if(user!=null)
		{
			String purchaser = user.getUsername();
			String url = "actiontype=listmeorder";
			request.getSession().setAttribute("user", user);
			OrderService service1 = new OrderServiceImpl();
				QueryInfo info = PageUtil.QueryInfo(request);
				PageBean pagebean = service1.findmeOrder(info,purchaser);
				if(pagebean!=null){
					request.setAttribute("URL", url);
					request.setAttribute("pagebean", pagebean);
					request.getRequestDispatcher("/WEB-INF/jsp/user/userForm.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "订单查询失败！！");
					request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
				}
			return;
		}else
		{
			request.setAttribute("message","用户名或密码错误！请重新登陆");
			request.setAttribute("action", "login");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
	}

	private void doUpdatePassword2(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = Md5Util.md5(request.getParameter("password"));
		UserService service=new UserService();
		int result=service.updatePassword(id,password);
		if(result>0)
			{
			
			request.setAttribute("message","修改密码成功,请登录");
			request.setAttribute("action", "login");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			}else
			{
				request.getRequestDispatcher("/WEB-INF/errors/erroe500.jsp").forward(request, response);
			}
		
	}

	private void doFindEmailCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		String emailCode=request.getParameter("emailCode");
		String id=request.getParameter("id");
		UserService service=new UserService();
		User user1=service.findUser(id);
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(60);
		String serverCode=(String) session.getAttribute("checkcode_key");
		if(emailCode.equals(serverCode))
		{
			request.setAttribute("user1", user1);
			request.getRequestDispatcher("/WEB-INF/jsp/user/findPassword4.jsp").forward(request, response);
			
		}else
		{
			request.setAttribute("user1", user1);
			request.setAttribute("message", "验证码不正确,请重新输入");
			request.getRequestDispatcher("/WEB-INF/jsp/user/findPassword3.jsp").forward(request, response);
			
		}
		
	}

	//输入验证邮箱，并验证邮箱是否与用户绑定的邮箱一致
	private void doFindEmail(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, MessagingException{

		String email=request.getParameter("email");
		String username=new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		String realname=request.getParameter("realname");
		UserService service=new UserService();
		User user1=service.findEmail(username,email,realname);
		if(user1!=null)
		{
			request.setAttribute("user1", user1);
			
			
			/*******************************发送邮件的代码*******************************/
			
			//第一步：声明properties放信息对象
			Properties prop=new Properties();
			//设置连接哪台服务器
			prop.setProperty("mail.host", "smtp.163.com");
			//设置是否验证
			prop.setProperty("mail.smtp.auth", "true");
			//声明用户名和密码
			Authenticator auth=new Authenticator() {
				//返回用户名和密码的对象
				public PasswordAuthentication getPasswordAuthentication()
				{
					PasswordAuthentication pa=new PasswordAuthentication("transactionGov", "Gov2014");
					return pa;
				}
			};
			//获得邮件对象
			Session session=Session.getDefaultInstance(prop, auth);
			//设置session的调试模式
			session.setDebug(true);
			//第三步：声明信息
			MimeMessage mm=new MimeMessage(session);
			//第四步：设置发件人email
			Address from=new InternetAddress("transactionGov@163.com");
			mm.setFrom(from);
			//第五步：设置收件人
			mm.setRecipient(RecipientType.TO, new InternetAddress(email));
			//第六步：设置主题
			mm.setSubject("跳蚤市场密码找回的验证码");
			
			/***************随机生成4位数字的验证码****************/
			
			Random random = new Random();
			String sRand = "";
			for (int i = 0; i < 4; i++) {
				String rand = String.valueOf(random.nextInt(10));
				sRand += rand;
			}
			// 将认证码存入SESSION
			request.getSession().setAttribute("checkcode_key", sRand);

			
			
			/***************随机生成4位数字的验证码****************/
			mm.setContent(sRand, "text/plain;charset=utf-8");
			//第七步： 发送邮件
			Transport.send(mm);
			
			/*******************************发送邮件的代码*******************************/
			
			
			
			request.setAttribute("message", "邮件已发送");
			request.getRequestDispatcher("/WEB-INF/jsp/user/findPassword3.jsp").forward(request, response);
			
		}else
		{
			request.setAttribute("message", "邮箱或者真实姓名不匹配");
			request.getRequestDispatcher("/WEB-INF/jsp/user/findPassword2.jsp").forward(request, response);
		}
	}

	//找回密码前先获得用户
	private void doFindUsername(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		String username=request.getParameter("username");
		String checkCode=request.getParameter("checkcode");
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(1800);
		String serverCode=(String) session.getAttribute("checkcode_key");
		if(serverCode.equals(checkCode))
		{
			//request.getSession().removeAttribute("checkcode_key");
			UserService service=new UserService();
			User user1=service.findByUsername(username);
			if(user1!=null)
			{
				request.setAttribute("user1", user1);
				request.getRequestDispatcher("/WEB-INF/jsp/user/findPassword2.jsp").forward(request, response);
				return;
			}else
			{
				request.setAttribute("message","用户不存在");
				request.getRequestDispatcher("/WEB-INF/jsp/user/findPassword1.jsp").forward(request, response);
				return;
			}
		}else
		{
			request.setAttribute("message","验证码错误");
			request.getRequestDispatcher("/WEB-INF/jsp/user/findPassword1.jsp").forward(request, response);
			return;
		}
		
	}


	private void doUpdateProduct(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		String id=request.getParameter("id");
		ProductService service=new ProductServiceImpl();
		Product product=service.find(id);
		request.setAttribute("product",product);
		request.getRequestDispatcher("/WEB-INF/jsp/user/updateproduct.jsp").forward(request, response);
		return;
		
	}


	private void doDeleteProduct(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		 request.setCharacterEncoding("utf-8");
		 String id=request.getParameter("id");
		 ProductService service=new ProductServiceImpl();
		 int result=service.soldOUt(id);
		 if(result==1)
		 	{
				User user = (User)request.getSession().getAttribute("user");
				String username = user.getUsername();
				String url = "actiontype=listproduct"+"&username="+username;
				QueryInfo info = PageUtil.QueryInfo(request);
				ProductServiceImpl service2=new ProductServiceImpl();
				PageBean pagebean =service2.getUserProduct(info,username);
				request.setAttribute("pagebean", pagebean);
				request.setAttribute("URL", url);
				request.getRequestDispatcher("/WEB-INF/jsp/user/userLibrary.jsp").forward(request, response);
		 	}else
		 	{
		 		request.setAttribute("message", "下架失败，请等等再做尝试");
		 		request.getRequestDispatcher("/WEB-INF/jsp/user/message.jsp").forward(request, response);
		 	}
	}

	private void doListproduct(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		request.setCharacterEncoding("utf-8");
		String at = request.getParameter("actiontype");
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null)
		{
			String url = "actiontype="+at;
			QueryInfo info = PageUtil.QueryInfo(request);
			ProductServiceImpl service=new ProductServiceImpl();
				PageBean pagebean =service.getUserProduct(info,user.getUsername());
			request.setAttribute("pagebean", pagebean);
			request.setAttribute("URL", url);
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLibrary.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "请先登录再查看个人闲置宝贝！");
			request.setAttribute("action", "login4");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
	}
	
	private void doLogin4(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=Md5Util.md5(request.getParameter("password"));
		UserService service=new UserService();
		User user=service.login(username, password);
		if(user!=null)
		{
			request.getSession().setAttribute("user", user);
			String url = "actiontype=listproduct";
			QueryInfo info = PageUtil.QueryInfo(request);
			ProductServiceImpl service2=new ProductServiceImpl();
				PageBean pagebean =service2.getUserProduct(info,user.getUsername());
			request.setAttribute("pagebean", pagebean);
			request.setAttribute("URL", url);
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLibrary.jsp").forward(request, response);
			return;
		}else
		{
			request.setAttribute("message","用户名或密码错误！请重新登陆");
			request.setAttribute("action", "login");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
	}
	private void doPublishGoodsUI(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		String id=request.getParameter("id");
		UserService service=new UserService();
		User user=service.findUser(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/user/publishGoods.jsp").forward(request, response);
		
	}

	private void doshowSelfInfoUI(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		String id=request.getParameter("id");
		UserService service=new UserService();
		User user=service.findUser(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/user/showSelfInfo.jsp").forward(request, response);
	}

	//修改个人信息，并返回到个人资料页面
	private void doUpdateSelfInfo(HttpServletRequest request,
			HttpServletResponse response)throws IOException, ServletException {

		String id=request.getParameter("id");
		String realname=request.getParameter("realname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		if(phone.length()==11)
		{
			/***************************正则表达式判断邮箱格式*************************/
			String regex="[a-zA-Z0-9]\\w+@\\w+\\.\\w+";
			boolean flag=email.matches(regex);
			if(flag==true)
			{
				UserService service=new UserService();
				User user=service.findUser(id);
				user.setRealname(realname);
				user.setEmail(email);
				user.setPhone(phone);
				user.setAddress(address);
				UserService ser=new UserService();
				ser.updateUserSelfInfo(user);
				request.setAttribute("user",user);
				request.setAttribute("message", "资料修改成功");
				request.getRequestDispatcher("/WEB-INF/jsp/user/showSelfInfo.jsp").forward(request, response);
			}else {
				
				request.setAttribute("message", "邮箱格式不正确");
				request.getRequestDispatcher("/WEB-INF/jsp/user/showSelfInfo.jsp").forward(request, response);
				
				
			}
		}else {
			
			request.setAttribute("message", "手机格式不正确");
			request.getRequestDispatcher("/WEB-INF/jsp/user/showSelfInfo.jsp").forward(request, response);
			
			
		}
			
	}
	
	private void doUpdateCenterInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		String id=request.getParameter("id");
		String realname=request.getParameter("realname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		if(phone.length()==11)
		{
			/***************************正则表达式判断邮箱格式*************************/
			String regex="[a-zA-Z0-9]\\w+@\\w+\\.\\w+";
			boolean flag=email.matches(regex);
			if(flag==true)
			{
				UserService service=new UserService();
				User user=service.findUser(id);
				user.setRealname(realname);
				user.setEmail(email);
				user.setPhone(phone);
				UserService ser=new UserService();
				ser.updateCenterInfo(user);
				request.setAttribute("user",user);
				request.setAttribute("message", "资料修改成功");
				request.getRequestDispatcher("/WEB-INF/jsp/user/userCenter.jsp").forward(request, response);
			}else {
				
				request.setAttribute("message", "邮箱格式不正确");
				request.getRequestDispatcher("/WEB-INF/jsp/user/userCenter.jsp").forward(request, response);
				
				
			}
		}else {
			
			request.setAttribute("message", "手机格式不正确");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userCenter.jsp").forward(request, response);
			
			
		}
		
	}


	//重置密码路径跳转到重置密码的jsp页面
	private void doUpdatePasswordUI(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/jsp/user/updatePassword.jsp").forward(request, response);
	}

	
	//重置密码
	private void doUpdatePassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = Md5Util.md5(request.getParameter("password"));
		String password1 = Md5Util.md5(request.getParameter("password1"));
			UserService service=new UserService();
			int result=service.findPassword(id, password);
			if(result>0)
			{
				
					UserService service1=new UserService();
					int result1=service1.updatePassword(id,password1);
					if(result1>0)
					{
						//登陆成功自动跳转到登陆页面
						request.setAttribute("message","修改密码成功,请重新登录");
						request.setAttribute("action", "login");
						request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
					}
			}else
			{
				//跳转到修改密码页面
				request.setAttribute("message", "原始密码错误");
				request.getRequestDispatcher("/WEB-INF/jsp/user/updatePassword.jsp").forward(request, response);
			}
		}

	private void doLogin2Buy(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=Md5Util.md5(request.getParameter("password"));
		String id = request.getParameter("URL");
		UserService service=new UserService();
		User user=service.login(username, password);
		if(user!=null)
		{
			request.getSession().setAttribute("user", user);
			ProductService service1 = new ProductServiceImpl();
			Product product = service1.find(id);
			 if(product.getPublisher().equals(user.getUsername())){
					request.setAttribute("message", "对不起，这是您发布的宝贝，不能购买哦！");		
					request.getRequestDispatcher("/WEB-INF/jsp/message/message.jsp").forward(request, response);
				}else{
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
		}else
		{
			request.setAttribute("message","用户名或密码错误！请重新登陆");
			request.setAttribute("action", "login2Buy");
			request.setAttribute("URL", id);
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
		
	}
	//登陆处理
	private void doLogin2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=Md5Util.md5(request.getParameter("password"));
		UserService service=new UserService();
		User user=service.login(username, password);
		if(user!=null)
		{
			request.setAttribute("message","\""+ username+"\"登陆成功！！！");
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/jsp/user/publishGoods.jsp").forward(request, response);
			return;
		}else
		{
			request.setAttribute("message","用户名或密码错误！请重新登陆");
			request.setAttribute("action", "login");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
		
	}
	
	//登陆处理
	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=Md5Util.md5(request.getParameter("password"));
		String URL=request.getParameter("URL");
		UserService service=new UserService();
		User user=service.login(username, password);
		if(user!=null)
		{
			request.setAttribute("message","\""+ username+"\"登陆成功！！！");
			request.getSession().setAttribute("user", user);
			request.setAttribute("URL", URL);
			request.getRequestDispatcher("/WEB-INF/jsp/message/loginmessage.jsp").forward(request, response);
			return;
		}else
		{
			request.setAttribute("message","用户名或密码错误！请重新登陆");
			request.setAttribute("action", "login");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
			return;
		}
		
	}
	
	//注册处理
	private void doRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String checkCode=request.getParameter("checkcode");
		HttpSession session=request.getSession();
		String serverCode=(String) session.getAttribute("checkcode_key");
		if(checkCode.equals(serverCode))
		{
			User user=new User();
			UserService service=new UserService();
			user=service.findRepeatUser(username.replace(" ", ""));
			if(user==null)
			{
				service=new UserService();
				user=new User();
				String password=Md5Util.md5(request.getParameter("password"));
				user.setId(UUID.randomUUID().toString());
				user.setUsername(username);
				user.setPassword(password);
				int result=service.addUser(user);
				if(result==1)
				{
				request.setAttribute("message","注册成功,请登录");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/WEB-INF/jsp/user/userLogin.jsp").forward(request, response);
				}else
				{
					request.getRequestDispatcher("/WEB-INF/errors/error500.jsp").forward(request, response);
				}
			}else
			{
				request.setAttribute("message","该用户已被注册");
				
				request.getRequestDispatcher("/WEB-INF/jsp/user/userRegister.jsp").forward(request, response);
			}
		}else
		{
			request.setAttribute("message", "验证码错误");
			request.getRequestDispatcher("/WEB-INF/jsp/user/userRegister.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
