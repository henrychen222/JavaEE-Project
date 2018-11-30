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
import com.orm.Tchuhuoren;
import com.orm.Tshouhuoren;

public class shouhuoren_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
        if(type.endsWith("shouhuorenMana"))
		{
			shouhuorenMana(req, res);
		}
        if(type.endsWith("chuhuorenChakanshouhuoStatus"))
		{
        	chuhuorenChakanshouhuoStatus(req, res);
		}
        if(type.endsWith("shouhuorenManaxinxi"))
		{
			shouhuorenManaxinxi(req, res);
		}
        if(type.endsWith("shouhuorenAdd"))
		{
		shouhuorenAdd(req, res);
		}
        if(type.endsWith("shouhuorenQuery"))
		{
			shouhuorenQuery(req, res);
		}
        if(type.endsWith("shouhuorenEdit"))
		{
			shouhuorenEdit(req, res);
		}
        if(type.endsWith("shouhuorenManaAdmin"))
		{
			shouhuorenManaAdmin(req, res);
		}
        if(type.endsWith("shouhuorenDel"))
		{
			shouhuorenDel(req, res);
		}
        if(type.endsWith("shouhuorenSearch"))
		{
			shouhuorenSearch(req, res);
		}
        if(type.endsWith("shouhuorenSearch1"))
		{
			shouhuorenSearch1(req, res);
		}
        if(type.endsWith("shouhuorenUpdateshouhuoStatus"))
		{
        	shouhuorenUpdateshouhuoStatus(req, res);
		}
	}
	
	
	public void shouhuorenSearch(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		List shouhuorenList=new ArrayList();
		String name=req.getParameter("name");
		String sql="select * from shouhuoren where name='" +name
				+ "'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshouhuoren shouhuoren=new Tshouhuoren();
				shouhuoren.setId(rs.getString("id"));
				shouhuoren.setName(rs.getString("name"));
				shouhuoren.setTel(rs.getString("tel"));
				shouhuoren.setAddress(rs.getString("address"));
				shouhuoren.setProductName(rs.getString("productName"));
				shouhuoren.setShouhuoStatus(rs.getString("shouhuoStatus"));
				shouhuoren.setFujian(rs.getString("fujian"));
				shouhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shouhuorenList.add(shouhuoren);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shouhuorenList", shouhuorenList);
		req.getRequestDispatcher("admin/shouhuoren/shouhuorenManaSearch.jsp").forward(req, res);
	}
	
	public void shouhuorenSearch1(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		List shouhuorenList=new ArrayList();
		String name=req.getParameter("name");
		String sql="select * from shouhuoren where name='" +name
				+ "'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshouhuoren shouhuoren=new Tshouhuoren();
				shouhuoren.setId(rs.getString("id"));
				shouhuoren.setName(rs.getString("name"));
				shouhuoren.setTel(rs.getString("tel"));
				shouhuoren.setAddress(rs.getString("address"));
				shouhuoren.setProductName(rs.getString("productName"));
				shouhuoren.setShouhuoStatus(rs.getString("shouhuoStatus"));
				shouhuoren.setFujian(rs.getString("fujian"));
				shouhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shouhuorenList.add(shouhuoren);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shouhuorenList", shouhuorenList);
		req.getRequestDispatcher("qiantai/chuhuoren/chuhuorenChakanshouhuoStatus1.jsp").forward(req, res);
	}
	
	public void shouhuorenDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from shouhuoren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "shouhuoren?type=shouhuorenManaAdmin");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void shouhuorenManaAdmin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shouhuorenList=new ArrayList();
		String sql="select * from shouhuoren";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshouhuoren shouhuoren=new Tshouhuoren();
				shouhuoren.setId(rs.getString("id"));
				shouhuoren.setName(rs.getString("name"));
				shouhuoren.setTel(rs.getString("tel"));
				shouhuoren.setAddress(rs.getString("address"));
				shouhuoren.setProductName(rs.getString("productName"));
				shouhuoren.setShouhuoStatus(rs.getString("shouhuoStatus"));
				shouhuoren.setFujian(rs.getString("fujian"));
				shouhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shouhuorenList.add(shouhuoren);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shouhuorenList", shouhuorenList);
		req.getRequestDispatcher("admin/shouhuoren/shouhuorenMana.jsp").forward(req, res);
	}
	
	
	public void shouhuorenEdit(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		System.out.println("id="+id);
		String name=req.getParameter("name");
		
		String tel=req.getParameter("tel");
		String address=req.getParameter("address");
		String shouhuoStatus=req.getParameter("shouhuoStatus");
		String productName=req.getParameter("productName");
		
		String sql="update shouhuoren set name=?,tel=?,address=?,shouhuoStatus=?,productName=? where id="+id;
		System.out.println("1111111111"+sql);
		Object[] params={name,tel,address,shouhuoStatus,productName};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "shouhuoren?type=shouhuorenManaxinxi&id="+id);
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void shouhuorenUpdateshouhuoStatus(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		System.out.println("id="+id);
		String sql="update shouhuoren set shouhuoStatus='已收货' where id="+id;
		
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "shouhuoren?type=shouhuorenManaxinxi&id="+id);
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void shouhuorenQuery(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tshouhuoren shouhuoren=new Tshouhuoren();
		
		String sql="select * from shouhuoren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			    shouhuoren.setId(rs.getString("id"));
			    shouhuoren.setName(rs.getString("name"));
			    shouhuoren.setTel(rs.getString("tel"));
			    shouhuoren.setAddress(rs.getString("address"));
			    shouhuoren.setProductName(rs.getString("productName"));
			    shouhuoren.setShouhuoStatus(rs.getString("shouhuoStatus"));
			    shouhuoren.setFujian(rs.getString("fujian"));
				shouhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("shouhuoren", shouhuoren);
		req.getRequestDispatcher("qiantai/shouhuoren/shouhuorenEidt1.jsp").forward(req, res);
	}
	
	public void shouhuorenAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String name=req.getParameter("name");
		String tel=req.getParameter("tel");
		String address=req.getParameter("address");
		String shouhuoStatus=req.getParameter("shouhuoStatus");
		String productName=req.getParameter("productName");
		String fujian=req.getParameter("fujian");
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		String sql="insert into shouhuoren values(?,?,?,?,?,?,?,?)";
		Object[] params={id,name,address,tel,productName,shouhuoStatus,fujian,fujianYuanshiming};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "注册成功！");
		
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void shouhuorenManaxinxi(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tshouhuoren shouhuoren=new Tshouhuoren();
		
		String sql="select * from shouhuoren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
		    shouhuoren.setId(rs.getString("id"));
		    shouhuoren.setName(rs.getString("name"));
		    shouhuoren.setTel(rs.getString("tel"));
		    shouhuoren.setAddress(rs.getString("address"));
		    shouhuoren.setProductName(rs.getString("productName"));
		    shouhuoren.setShouhuoStatus(rs.getString("shouhuoStatus"));
		    shouhuoren.setFujian(rs.getString("fujian"));
			shouhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("shouhuoren", shouhuoren);
		req.getRequestDispatcher("qiantai/shouhuoren/shouhuorenMana.jsp").forward(req, res);
	}
	
	
	
	
	public void shouhuorenMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shouhuorenList=new ArrayList();
		String sql="select * from shouhuoren";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshouhuoren shouhuoren=new Tshouhuoren();
				shouhuoren.setId(rs.getString("id"));
				shouhuoren.setName(rs.getString("name"));
				shouhuoren.setTel(rs.getString("tel"));
				shouhuoren.setAddress(rs.getString("address"));
				shouhuoren.setProductName(rs.getString("productName"));
				shouhuoren.setShouhuoStatus(rs.getString("shouhuoStatus"));
				shouhuoren.setFujian(rs.getString("fujian"));
				shouhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shouhuorenList.add(shouhuoren);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shouhuorenList", shouhuorenList);
		req.getRequestDispatcher("qiantai/shouhuoren/shouhuorenPhoto.jsp").forward(req, res);
	}
	
	public void chuhuorenChakanshouhuoStatus(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List shouhuorenList=new ArrayList();
		String sql="select * from shouhuoren";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tshouhuoren shouhuoren=new Tshouhuoren();
				shouhuoren.setId(rs.getString("id"));
				shouhuoren.setName(rs.getString("name"));
				shouhuoren.setTel(rs.getString("tel"));
				shouhuoren.setAddress(rs.getString("address"));
				shouhuoren.setProductName(rs.getString("productName"));
				shouhuoren.setShouhuoStatus(rs.getString("shouhuoStatus"));
				shouhuoren.setFujian(rs.getString("fujian"));
				shouhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				shouhuorenList.add(shouhuoren);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("shouhuorenList", shouhuorenList);
		req.getRequestDispatcher("qiantai/chuhuoren/chuhuorenChakanshouhuoStatus.jsp").forward(req, res);
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
