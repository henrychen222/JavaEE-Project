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
import com.orm.Tjingyingren;

public class jingyingren_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
        if(type.endsWith("jingyingrenMana"))
		{
			jingyingrenMana(req, res);
		}
        if(type.endsWith("jingyingrenAdd"))
		{
			jingyingrenAdd(req, res);
		}
        if(type.endsWith("jingyingrenManaxinxi"))
		{
			jingyingrenManaxinxi(req, res);
		}

		if(type.endsWith("jingyingrenQuery"))
		{
			jingyingrenQuery(req, res);
		}
		if(type.endsWith("jingyingrenEdit"))
		{
			jingyingrenEdit(req, res);
		}
		if(type.endsWith("jingyingrenManaAdmin"))
		{
			jingyingrenManaAdmin(req, res);
		}
		if(type.endsWith("jingyingrenDel"))
		{
			jingyingrenDel(req, res);
		}
		if(type.endsWith("jingyingrenSearch"))
		{
			jingyingrenSearch(req, res);
		}
	}
	
	
	public void jingyingrenSearch(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		List jingyingrenList=new ArrayList();
		String name=req.getParameter("name");
		
		String sql="select * from jingyingren where name='" +name
				+ "'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tjingyingren jingyingren=new Tjingyingren();
				jingyingren.setId(rs.getString("id"));
				jingyingren.setName(rs.getString("name"));
				jingyingren.setSex(rs.getString("sex"));
				jingyingren.setAge(rs.getInt("age"));
				jingyingren.setZigezhengFujian(rs.getString("zigezhengFujian"));
				jingyingren.setJingyan(rs.getString("jingyan"));
				jingyingren.setGongsi(rs.getString("gongsi"));
				jingyingren.setFujian(rs.getString("fujian"));
				jingyingren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				jingyingren.setZigezhengFujianYuanshiming(rs.getString("zigezhengFujianYuanshiming"));
				jingyingrenList.add(jingyingren);
				
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("jingyingrenList", jingyingrenList);
		req.getRequestDispatcher("admin/jingyingren/jingyingrenManaSearch.jsp").forward(req, res);
	}
	
	
	public void jingyingrenDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from jingyingren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jingyingren?type=jingyingrenManaAdmin");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void jingyingrenEdit(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		//System.out.println("id="+id);
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String gongsi=req.getParameter("gongsi");
		String jingyan=req.getParameter("jingyan");
		String sql="update jingyingren set name=?,sex=?,age=?,gongsi=?,jingyan=? where id="+id;
		System.out.println("1111111111"+sql);
		Object[] params={name,sex,age,gongsi,jingyan};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "jingyingren?type=jingyingrenManaxinxi&id="+id);
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void jingyingrenManaAdmin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List jingyingrenList=new ArrayList();
		String sql="select * from jingyingren";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tjingyingren jingyingren=new Tjingyingren();
				jingyingren.setId(rs.getString("id"));
				jingyingren.setName(rs.getString("name"));
				jingyingren.setSex(rs.getString("sex"));
				jingyingren.setAge(rs.getInt("age"));
				jingyingren.setZigezhengFujian(rs.getString("zigezhengFujian"));
				jingyingren.setJingyan(rs.getString("jingyan"));
				jingyingren.setGongsi(rs.getString("gongsi"));
				jingyingren.setFujian(rs.getString("fujian"));
				jingyingren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				jingyingren.setZigezhengFujianYuanshiming(rs.getString("zigezhengFujianYuanshiming"));
				jingyingrenList.add(jingyingren);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("jingyingrenList", jingyingrenList);
		req.getRequestDispatcher("admin/jingyingren/jingyingrenMana.jsp").forward(req, res);
	}
	
	
	
	public void jingyingrenQuery(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tjingyingren jingyingren=new Tjingyingren();
		
		String sql="select * from jingyingren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			jingyingren.setId(rs.getString("id"));
			jingyingren.setName(rs.getString("name"));
			jingyingren.setSex(rs.getString("sex"));
			jingyingren.setAge(rs.getInt("age"));
			jingyingren.setZigezhengFujian(rs.getString("zigezhengFujian"));
			jingyingren.setJingyan(rs.getString("jingyan"));
			jingyingren.setGongsi(rs.getString("gongsi"));
			jingyingren.setFujian(rs.getString("fujian"));
			jingyingren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			jingyingren.setZigezhengFujianYuanshiming(rs.getString("zigezhengFujianYuanshiming"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("jingyingren", jingyingren);
		req.getRequestDispatcher("qiantai/jingyingren/jingyingrenEdit1.jsp").forward(req, res);
	}
	
	public void jingyingrenManaxinxi(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tjingyingren jingyingren=new Tjingyingren();
		
		String sql="select * from jingyingren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			jingyingren.setId(rs.getString("id"));
			jingyingren.setName(rs.getString("name"));
			jingyingren.setSex(rs.getString("sex"));
			jingyingren.setAge(rs.getInt("age"));
			jingyingren.setZigezhengFujian(rs.getString("zigezhengFujian"));
			jingyingren.setJingyan(rs.getString("jingyan"));
			jingyingren.setGongsi(rs.getString("gongsi"));
			jingyingren.setFujian(rs.getString("fujian"));
			jingyingren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			jingyingren.setZigezhengFujianYuanshiming(rs.getString("zigezhengFujianYuanshiming"));
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("jingyingren", jingyingren);
		req.getRequestDispatcher("qiantai/jingyingren/jingyingrenMana.jsp").forward(req, res);
	}
	
	public void jingyingrenMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List jingyingrenList=new ArrayList();
		String sql="select * from jingyingren";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tjingyingren jingyingren=new Tjingyingren();
				jingyingren.setId(rs.getString("id"));
				jingyingren.setName(rs.getString("name"));
				jingyingren.setSex(rs.getString("sex"));
				jingyingren.setAge(rs.getInt("age"));
				jingyingren.setZigezhengFujian(rs.getString("zigezhengFujian"));
				jingyingren.setJingyan(rs.getString("jingyan"));
				jingyingren.setGongsi(rs.getString("gongsi"));
				jingyingren.setFujian(rs.getString("fujian"));
				jingyingren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				jingyingren.setZigezhengFujianYuanshiming(rs.getString("zigezhengFujianYuanshiming"));
				jingyingrenList.add(jingyingren);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("jingyingrenList", jingyingrenList);
		req.getRequestDispatcher("qiantai/jingyingren/jingyingrenPhoto.jsp").forward(req, res);
	}
	public void jingyingrenAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String zigezhengFujian=req.getParameter("zigezhengFujian");
		String zigezhengFujianYuanshiming=req.getParameter("zigezhengFujianYuanshiming");
		String jingyan=req.getParameter("jingyan");
		String gongsi=req.getParameter("gongsi");
		String fujian=req.getParameter("fujian");
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		String sql="insert into jingyingren values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params={id,name,zigezhengFujian,jingyan,sex,age,gongsi,fujian,fujianYuanshiming,zigezhengFujianYuanshiming};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "注册成功！");
		
        String targetURL = "/common/msg.jsp";
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
