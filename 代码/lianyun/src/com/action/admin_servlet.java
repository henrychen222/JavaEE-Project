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
import com.orm.TAdmin;
import com.util.MD5;

/**
 * 管理员管理
 * @author Administrator
 *
 */
public class admin_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("adminMana"))
		{
			adminMana(req, res);
		}
		if(type.endsWith("adminAdd"))
		{
			adminAdd(req, res);
		}
		if(type.endsWith("adminDel"))
		{
			adminDel(req, res);
		}
	}
	
	/**
	 * 管理员列表
	 * @author Administrator
	 *
	 */
	public void adminMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List adminList=new ArrayList();
		String sql="select * from t_admin";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TAdmin admin=new TAdmin();
				admin.setUserId(rs.getString("userId"));
				admin.setUserName(rs.getString("userName"));
				admin.setUserPw(rs.getString("userPw"));
				admin.setGonghao(rs.getString("gonghao"));
				admin.setName(rs.getString("name"));
				admin.setTelephone(rs.getString("telephone"));
				adminList.add(admin);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("adminList", adminList);
		req.getRequestDispatcher("admin/admin/adminMana.jsp").forward(req, res);
	}
	
	/**
	 * 管理员添加
	 * @author Administrator
	 *
	 */
	public void adminAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String userId=String.valueOf(new Date().getTime());
		String userName=req.getParameter("userName");
		String userPw=new MD5().complie(req.getParameter("userPw"));
		String gonghao=req.getParameter("gonghao");
		String telephone=req.getParameter("telephone");
		String name=req.getParameter("name");
		String sql="insert into t_admin values(?,?,?,?,?,?)";
		Object[] params={userId,userName,userPw,gonghao,name,telephone};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "admin?type=adminMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	/**
	 * 管理员删除
	 * @author Administrator
	 *
	 */
	public void adminDel(HttpServletRequest req,HttpServletResponse res)
	{
		//System.out.println(req.getParameter("userId")+"**");
		String userId=req.getParameter("userId");
		String sql="delete from t_admin where userId="+userId;
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "admin?type=adminMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
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
