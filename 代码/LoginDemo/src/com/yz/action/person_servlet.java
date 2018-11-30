package com.yz.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yz.dao.DB;
import com.yz.domain.User;
import com.yz.service.UserService;
import com.yz.service.impl.UserServiceImpl;
import com.yz.utils.MD5;




public class person_servlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("register"))
		{
			userRegister(req, res);
		}
		
		if(type.endsWith("userQueryMana"))
		{
			userQueryMana(req, res);
		}
		
	}
	
	
	
//	public void personAdd(HttpServletRequest req,HttpServletResponse res)
//	{
//		String id=String.valueOf(new Date().getTime());
//		String username=req.getParameter("username");
//		String password=req.getParameter("password");
//		String realname=req.getParameter("realname");
//		String birthday=req.getParameter("birthday");
//		String email=req.getParameter("email");
//		int phone=Integer.parseInt(req.getParameter("phone"));
//		String createtime= req.getParameter("createtime");
//		String address=req.getParameter("address");
//	
//		String oa="insert into user values(?,?,?,?,?,?,?,?,?)";
//		Object[] params={id,username,password,realname,birthday,email,phone,createtime,address};
//		DB mydb=new DB();
//		mydb.doPstm(oa, params);
//		mydb.closed();
//		
//		req.setAttribute("msg", "注册成功！");
//		
//        String targetURL = "/common/msg.jsp";
//		dispatch(targetURL, req, res);
//	}
	
	
	/**
	 * 查询用户
	 * @param req
	 * @param res
	 */
	public void userQueryMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		ArrayList userList=new ArrayList();
		String sql="select * from user";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				User user=new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRealname(rs.getString("realname"));
				user.setBirthday(rs.getString("birthday"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getInt("phone"));
				user.setAddress(rs.getString("address"));
				
				userList.add(user);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("front/userqueryMana.jsp").forward(req, res);
	}
	
	
	/**
	 * 插入用户(注册)
	 * @author陈伟
	 * @param req
	 * @param res
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void userRegister(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String username=req.getParameter("username");
		String password=new MD5().complie(req.getParameter("password"));
		User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setUsername(username);
			user.setPassword(password);
			user.setCreate(new Date());
		UserService service = new UserServiceImpl();
			int rs = service.addUser(user);
		if(rs==1){
			req.getRequestDispatcher("/WEB-INF/jsp/left.jsp").forward(req, res);
		}else{
			req.getRequestDispatcher("/WEB-INF/jsp/userReg.jsp").forward(req, res);
		}
		
		
	}
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
