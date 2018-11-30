package com.action;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.item.User;



public class user_servlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
	    String type=req.getParameter("type");
	    
	 if(type.endsWith("userReg1"))
	 {
		userReg1(req, res);
	 }
	 
	 if(type.endsWith("userQueryMana"))
	 {
		 userQueryMana(req, res);
	 }
	 
	 if(type.endsWith("userDel"))
	 {
		 userDel(req, res);
	 }
	 	 	 
	 if(type.endsWith("userQuery"))
	 {
		 userQuery(req, res);
	 }
	 if(type.endsWith("userEdit"))
	 {
		 userEdit(req, res);
	 }
	 
	
	 if(type.endsWith("userCenterMana"))
	 {
		 userCenterMana(req, res);
	 }
	
	 
   }
	
	/**
	 *  用户注册(添加用户)
	 */
	public void userReg1(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String loginname=req.getParameter("loginname");
		String loginpwd=req.getParameter("loginpwd");
		String name=req.getParameter("name");
		
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		
		
		String sql="insert into register values(?,?,?,?,?,?)";
		Object[] params={id,loginname,loginpwd,name,sex,age};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		
		req.setAttribute("msg", "注册成功,请登录");
        String targetURL = "/common/msg.jsp";
        dispatch(targetURL, req, res);
	}
	
	
	/**
	 * 用户查询
	 * @param req
	 * @param res
	 */
	public void userQueryMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List userList=new ArrayList();
		String sql="select * from register";
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
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpwd(rs.getString("loginpwd"));
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
		req.getRequestDispatcher("/userqueryMana.jsp").forward(req, res);
	}
	
	/**
	 * 用户删除
	 * @author Administrator
	 *
	 */
	public void userDel(HttpServletRequest req,HttpServletResponse res)
	{
		
		String id=req.getParameter("id");
		String sql="delete from register where id="+id;
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user?type=userQueryMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	/**
	 * 用户个人中心信息
	 * @param req
	 * @param res
	 */
	public void userCenterMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		System.out.println("IDeweiiqgqgeugqgeui"+id);
		String sql="select * from register where id=?";
		User user=new User();
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			user.setId(rs.getString("id"));
			user.setLoginname(rs.getString("loginname"));
			user.setLoginpwd(rs.getString("loginpwd"));
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
		req.setAttribute("user", user);
		req.getRequestDispatcher("personalMana.jsp").forward(req, res);
	}
	
	/**
	 * 用户修改查询（将要修改的信息反馈回来进行修改）
	 * @author Administrator
	 *
	 */
	
	public void userQuery(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		String sql="select * from register where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			User user=new User();
			user.setId(rs.getString("id"));
			user.setLoginname(rs.getString("loginname"));
			user.setLoginpwd(rs.getString("loginpwd"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setAge(rs.getInt("age"));
			req.setAttribute("user", user);
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		req.getRequestDispatcher("userEdit.jsp").forward(req, res);
	}
	
	
	/**
	 * 用户修改
	 * @author Administrator
	 *
	 */
	
	public void userEdit(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		String loginname=req.getParameter("loginname");
		String loginpwd=req.getParameter("loginpwd");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String sql="update register set loginname=?,loginpwd=?,name=?,sex=?,age=? where id="+id;
		Object[] params={loginname,loginpwd,name,sex,age};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user?type=userQueryMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
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
	
}