package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.Tuser;
import com.util.MD5;

/**
 * 会员信息管理类
 * @author Administrator
 *
 */
public class user_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("userReg"))
		{
			userReg(req, res);
		}
		if(type.endsWith("userQuery"))
		{
			userQuery(req, res);
		}
		if(type.endsWith("userEdit"))
		{
			userEdit(req, res);
		}
		if(type.endsWith("userReg1"))
		{
			userReg1(req, res);
		}
		if(type.endsWith("userMana"))
		{
			userMana(req, res);
		}
		if(type.endsWith("userMana1"))
		{
			userMana1(req, res);
		}
		if(type.endsWith("userDel"))
		{
			userDel(req, res);
		}
		if(type.endsWith("userDetail"))
		{
			userDetail(req, res);
		}
		if(type.endsWith("qianuserDetail"))//前台会员修改个人信息
		{
			qianuserDetail(req, res);
		}
		if(type.endsWith("setLoginname"))
		{
			setLoginname(req, res);
		}
		if(type.endsWith("kongjian"))
		{
			kongjian(req, res);
		}
	}
	
	
	/**
	 * 会员注册
	 * @author Administrator
	 *
	 */
	public void userEdit(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		System.out.println("id="+id);
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String loginname=req.getParameter("loginname");
		String loginpw=req.getParameter("loginpw");
		String sql="update user set name=?,sex=?,age=?,loginname=?,loginpw=? where id="+id;
		System.out.println("1111111111"+sql);
		Object[] params={name,sex,age,loginname,loginpw};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user?type=userMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void userQuery(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tuser user=new Tuser();
		
		String sql="select * from user where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			user.setId(rs.getString("id"));
			user.setLoginname(rs.getString("loginname"));
			user.setLoginpw(rs.getString("loginpw"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setAge(rs.getInt("age"));
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("user", user);
		req.getRequestDispatcher("qiantai/userinfo/userEdit.jsp").forward(req, res);
	}
	public void userReg(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String loginname=req.getParameter("loginname");
		String loginpw=req.getParameter("loginpw");
		String name=req.getParameter("name");
		
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String del="no";
		
		String sql="insert into user values(?,?,?,?,?,?,?)";
		Object[] params={id,loginname,loginpw,name,sex,age,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		
		req.setAttribute("msg", "注册成功,请登录");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void userReg1(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String loginname=req.getParameter("loginname");
		String loginpw=new MD5().complie(req.getParameter("loginpw"));
		String name=req.getParameter("name");
		
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String del="no";
		
		String sql="insert into user values(?,?,?,?,?,?,?)";
		Object[] params={id,loginname,loginpw,name,sex,age,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		
		req.setAttribute("msg", "注册成功,请登录");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	/**
	 * 会员登录
	 * @author Administrator
	 *
	 */
	public void setLoginname(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		String loginname=req.getParameter("loginname");
		String sql="update user set loginname='"+loginname+"' where id=?";
		Object[] params={id,loginname};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user?type=userMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	/**
	 * 会员信息查看
	 * @author Administrator
	 *
	 */
	public void kongjian(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="select user.id,t_user.loginname,t_yuding.id,t_yuding.kefang_id,t_yuding.yajin,t_dingcai.id,t_dingcai";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user?type=userMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	/**
	 * 会员信息删除
	 * @author Administrator
	 *
	 */
	public void userDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="update user set del='yes' where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user?type=userMana1");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void userMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List userList=new ArrayList();
		String sql="select * from user where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tuser user=new Tuser();
				
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				//user.setLoginpw(rs.getString("loginpw"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				
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
		req.getRequestDispatcher("qiantai/userinfo/userMana.jsp").forward(req, res);
	}
	public void userMana1(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List userList=new ArrayList();
		String sql="select * from user where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tuser user=new Tuser();
				
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				//user.setLoginpw(rs.getString("loginpw"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				
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
		req.getRequestDispatcher("admin/user/userMana.jsp").forward(req, res);
	}
	
	/**
	 * 会员信息详情
	 * @author Administrator
	 *
	 */
	public void userDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List userList=new ArrayList();
		String sql="select * from user where id=?";
		Object[] params={req.getParameter("id")};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tuser user=new Tuser();
				
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				
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
		req.getRequestDispatcher("admin/user/userDetail.jsp").forward(req, res);
	}
	
	
	
	public void qianuserDetail(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List<Tuser> userList=new ArrayList();
		String sql="select * from user where id=?";
		Object[] params={req.getParameter("id")};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tuser user=new Tuser();
				
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				
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
		//req.getRequestDispatcher("qiantai/indexUser.jsp").forward(req, res);
		//req.getRequestDispatcher("qiantai/userinfo/userSet.jsp").forward(req, res);
	}	
	
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) {
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try {
		    dispatch.forward(request, response);
		    return;
		} catch (ServletException e) {
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
