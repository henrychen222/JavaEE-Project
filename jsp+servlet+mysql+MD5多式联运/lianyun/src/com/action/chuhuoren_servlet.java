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




public class chuhuoren_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("chuhuorenMana"))
		{
			chuhuorenMana(req, res);
		}
		if(type.endsWith("jingyingrenYunxuApply"))
		{
			jingyingrenYunxuApply(req, res);
		}
		if(type.endsWith("chakanChuhuoren"))
		{
			chakanChuhuoren(req, res);
		}
		if(type.endsWith("chuhuorenSearch"))
		{
			chuhuorenSearch(req, res);
		}
		if(type.endsWith("chuhuorenDel"))
		{
			chuhuorenDel(req, res);
		}
		if(type.endsWith("chuhuorenManaAdmin"))
		{
			chuhuorenManaAdmin(req, res);
		}
		if(type.endsWith("chuhuorenAdd"))
		{
			chuhuorenAdd(req, res);
		}
		if(type.endsWith("chuhuorenManaxinxi"))
		{
			chuhuorenManaxinxi(req, res);
		}
		
		if(type.endsWith("chuhuorenQuery"))
		{
			chuhuorenQuery(req, res);
		}
		if(type.endsWith("chuhuorenFahuo"))
		{
			chuhuorenFahuo(req, res);
		}
		if(type.endsWith("chuhuorenFahuo1"))
		{
			chuhuorenFahuo1(req, res);
		}
		if(type.endsWith("chuhuorenApply"))
		{
			chuhuorenApply(req, res);
		}
		if(type.endsWith("chuhuorenEdit"))
		{
			chuhuorenEdit(req, res);
		}
	}
	
	public void chuhuorenSearch(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		List chuhuorenList=new ArrayList();
		String name=req.getParameter("name");
		String shouhuorenName=req.getParameter("shouhuorenName");
		String sql="select * from chuhuoren where name='" +name
				+ "' and shouhuorenName='" +shouhuorenName
				+ "' ";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuhuoren chuhuoren=new Tchuhuoren();
				chuhuoren.setId(rs.getString("id"));
				chuhuoren.setName(rs.getString("name"));
				chuhuoren.setSex(rs.getString("sex"));
				chuhuoren.setAge(rs.getInt("age"));
				chuhuoren.setTelephone(rs.getString("telephone"));
				chuhuoren.setAddress(rs.getString("address"));
				chuhuoren.setShouhuorenAddress(rs.getString("shouhuorenAddress"));
				chuhuoren.setProductName(rs.getString("productName"));
				chuhuoren.setApplyStatus(rs.getString("applyStatus"));
				chuhuoren.setIdentity(rs.getString("identity"));
				chuhuoren.setFujian(rs.getString("fujian"));
				chuhuoren.setProductFujian(rs.getString("productFujian"));
				chuhuoren.setShouhuorenTel(rs.getString("shouhuorenTel"));
				chuhuoren.setShouhuorenName(rs.getString("shouhuorenName"));
				chuhuoren.setFahuoStatus(rs.getString("fahuoStatus"));
				chuhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				chuhuoren.setProductFujianYuanshiming(rs.getString("productFujianYuanshiming"));
				chuhuorenList.add(chuhuoren);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chuhuorenList", chuhuorenList);
		req.getRequestDispatcher("admin/chuhuoren/chuhuorenManaSearch.jsp").forward(req, res);
	}
	
	public void chuhuorenDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from chuhuoren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chuhuoren?type=chuhuorenManaAdmin");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void chuhuorenEdit(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		System.out.println("id="+id);
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String telephone=req.getParameter("telephone");
		String address=req.getParameter("address");
		String shouhuorenAddress=req.getParameter("shouhuorenAddress");
		String productName=req.getParameter("productName");
		String identity=req.getParameter("identity");
		String shouhuorenTel=req.getParameter("shouhuorenTel");
		String shouhuorenName=req.getParameter("shouhuorenName");
		String sql="update chuhuoren set name=?,sex=?,age=?,telephone=?,address=?,shouhuorenAddress=?,productName=?,identity=?,shouhuorenTel=?,shouhuorenName=? where id="+id;
		System.out.println("1111111111"+sql);
		Object[] params={name,sex,age,telephone,address,shouhuorenAddress,productName,identity,shouhuorenTel,shouhuorenName};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chuhuoren?type=chuhuorenManaxinxi&id="+id);
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void chuhuorenFahuo1(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		String sql="update chuhuoren set fahuoStatus='已发货' where id="+id;
		System.out.println("1111111111"+sql);
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chuhuoren?type=chuhuorenFahuo&id="+id);
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void jingyingrenYunxuApply(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		String sql="update chuhuoren set applyStatus='已申请' where id="+id;
		System.out.println("1111111111"+sql);
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chuhuoren?type=chakanChuhuoren");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void chuhuorenQuery(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tchuhuoren chuhuoren=new Tchuhuoren();
		
		String sql="select * from chuhuoren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			chuhuoren.setId(rs.getString("id"));
			chuhuoren.setName(rs.getString("name"));
			chuhuoren.setSex(rs.getString("sex"));
			chuhuoren.setAge(rs.getInt("age"));
			chuhuoren.setTelephone(rs.getString("telephone"));
			chuhuoren.setAddress(rs.getString("address"));
			chuhuoren.setShouhuorenAddress(rs.getString("shouhuorenAddress"));
			chuhuoren.setProductName(rs.getString("productName"));
			chuhuoren.setApplyStatus(rs.getString("applyStatus"));
			chuhuoren.setIdentity(rs.getString("identity"));
			chuhuoren.setFujian(rs.getString("fujian"));
			chuhuoren.setProductFujian(rs.getString("productFujian"));
			chuhuoren.setShouhuorenTel(rs.getString("shouhuorenTel"));
			chuhuoren.setShouhuorenName(rs.getString("shouhuorenName"));
			chuhuoren.setFahuoStatus(rs.getString("fahuoStatus"));
			chuhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			chuhuoren.setProductFujianYuanshiming(rs.getString("productFujianYuanshiming"));
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("chuhuoren", chuhuoren);
		req.getRequestDispatcher("qiantai/chuhuoren/chuhuorenEidt1.jsp").forward(req, res);
	}
	
	
	public void chuhuorenFahuo(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tchuhuoren chuhuoren=new Tchuhuoren();
		
		String sql="select * from chuhuoren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			chuhuoren.setId(rs.getString("id"));
			chuhuoren.setName(rs.getString("name"));
			chuhuoren.setSex(rs.getString("sex"));
			chuhuoren.setAge(rs.getInt("age"));
			chuhuoren.setTelephone(rs.getString("telephone"));
			chuhuoren.setAddress(rs.getString("address"));
			chuhuoren.setShouhuorenAddress(rs.getString("shouhuorenAddress"));
			chuhuoren.setProductName(rs.getString("productName"));
			chuhuoren.setApplyStatus(rs.getString("applyStatus"));
			chuhuoren.setIdentity(rs.getString("identity"));
			chuhuoren.setFujian(rs.getString("fujian"));
			chuhuoren.setProductFujian(rs.getString("productFujian"));
			chuhuoren.setShouhuorenTel(rs.getString("shouhuorenTel"));
			chuhuoren.setShouhuorenName(rs.getString("shouhuorenName"));
			chuhuoren.setFahuoStatus(rs.getString("fahuoStatus"));
			chuhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			chuhuoren.setProductFujianYuanshiming(rs.getString("productFujianYuanshiming"));
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("chuhuoren", chuhuoren);
		req.getRequestDispatcher("qiantai/chuhuoren/chuhuorenFahuofeiyong.jsp").forward(req, res);
	}
	
	
	public void chuhuorenApply(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tchuhuoren chuhuoren=new Tchuhuoren();
		
		String sql="select * from chuhuoren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			chuhuoren.setId(rs.getString("id"));
			chuhuoren.setName(rs.getString("name"));
			chuhuoren.setSex(rs.getString("sex"));
			chuhuoren.setAge(rs.getInt("age"));
			chuhuoren.setTelephone(rs.getString("telephone"));
			chuhuoren.setAddress(rs.getString("address"));
			chuhuoren.setShouhuorenAddress(rs.getString("shouhuorenAddress"));
			chuhuoren.setProductName(rs.getString("productName"));
			chuhuoren.setApplyStatus(rs.getString("applyStatus"));
			chuhuoren.setIdentity(rs.getString("identity"));
			chuhuoren.setFujian(rs.getString("fujian"));
			chuhuoren.setProductFujian(rs.getString("productFujian"));
			chuhuoren.setShouhuorenTel(rs.getString("shouhuorenTel"));
			chuhuoren.setShouhuorenName(rs.getString("shouhuorenName"));
			chuhuoren.setFahuoStatus(rs.getString("fahuoStatus"));
			chuhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			chuhuoren.setProductFujianYuanshiming(rs.getString("productFujianYuanshiming"));
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("chuhuoren", chuhuoren);
		req.getRequestDispatcher("qiantai/chuhuoren/chuhuorenApply.jsp").forward(req, res);
	}
	
	
	
	public void chuhuorenManaxinxi(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tchuhuoren chuhuoren=new Tchuhuoren();
		
		String sql="select * from chuhuoren where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			chuhuoren.setId(rs.getString("id"));
			chuhuoren.setName(rs.getString("name"));
			chuhuoren.setSex(rs.getString("sex"));
			chuhuoren.setAge(rs.getInt("age"));
			chuhuoren.setTelephone(rs.getString("telephone"));
			chuhuoren.setAddress(rs.getString("address"));
			chuhuoren.setShouhuorenAddress(rs.getString("shouhuorenAddress"));
			chuhuoren.setProductName(rs.getString("productName"));
			chuhuoren.setApplyStatus(rs.getString("applyStatus"));
			chuhuoren.setIdentity(rs.getString("identity"));
			chuhuoren.setFujian(rs.getString("fujian"));
			chuhuoren.setProductFujian(rs.getString("productFujian"));
			chuhuoren.setShouhuorenTel(rs.getString("shouhuorenTel"));
			chuhuoren.setShouhuorenName(rs.getString("shouhuorenName"));
			chuhuoren.setFahuoStatus(rs.getString("fahuoStatus"));
			chuhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
			chuhuoren.setProductFujianYuanshiming(rs.getString("productFujianYuanshiming"));
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("chuhuoren", chuhuoren);
		req.getRequestDispatcher("qiantai/chuhuoren/chuhuorenMana.jsp").forward(req, res);
	}
	
	public void chuhuorenAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String telephone=req.getParameter("telephone");
		String address=req.getParameter("address");
		String shouhuorenAddress=req.getParameter("shouhuorenAddress");
		String productName=req.getParameter("productName");
		String applyStatus=req.getParameter("applyStatus");
		String identity=req.getParameter("identity");
		String fujian=req.getParameter("fujian");
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		String shouhuorenTel=req.getParameter("shouhuorenTel");
		String shouhuorenName=req.getParameter("shouhuorenName");
		String fahuoStatus=req.getParameter("fahuoStatus");
		String productFujian=req.getParameter("productFujian");
		String productFujianYuanshiming=req.getParameter("productFujianYuanshiming");
		String sql="insert into chuhuoren values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={id,name,sex,age,telephone,address,shouhuorenAddress,productName,applyStatus,identity,fujian,fujianYuanshiming,shouhuorenTel,shouhuorenName,fahuoStatus,productFujian,productFujianYuanshiming};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "注册成功！");
		
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void chuhuorenMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chuhuorenList=new ArrayList();
		String sql="select * from chuhuoren";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuhuoren chuhuoren=new Tchuhuoren();
				chuhuoren.setId(rs.getString("id"));
				chuhuoren.setName(rs.getString("name"));
				chuhuoren.setSex(rs.getString("sex"));
				chuhuoren.setAge(rs.getInt("age"));
				chuhuoren.setTelephone(rs.getString("telephone"));
				chuhuoren.setAddress(rs.getString("address"));
				chuhuoren.setShouhuorenAddress(rs.getString("shouhuorenAddress"));
				chuhuoren.setProductName(rs.getString("productName"));
				chuhuoren.setApplyStatus(rs.getString("applyStatus"));
				chuhuoren.setIdentity(rs.getString("identity"));
				chuhuoren.setFujian(rs.getString("fujian"));
				chuhuoren.setProductFujian(rs.getString("productFujian"));
				chuhuoren.setShouhuorenTel(rs.getString("shouhuorenTel"));
				chuhuoren.setShouhuorenName(rs.getString("shouhuorenName"));
				chuhuoren.setFahuoStatus(rs.getString("fahuoStatus"));
				chuhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				chuhuoren.setProductFujianYuanshiming(rs.getString("productFujianYuanshiming"));
				chuhuorenList.add(chuhuoren);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chuhuorenList", chuhuorenList);
		req.getRequestDispatcher("qiantai/chuhuoren/chuhuorenPhoto.jsp").forward(req, res);
	}
	
	public void chakanChuhuoren(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chuhuorenList=new ArrayList();
		String sql="select * from chuhuoren";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuhuoren chuhuoren=new Tchuhuoren();
				chuhuoren.setId(rs.getString("id"));
				chuhuoren.setName(rs.getString("name"));
				chuhuoren.setSex(rs.getString("sex"));
				chuhuoren.setAge(rs.getInt("age"));
				chuhuoren.setTelephone(rs.getString("telephone"));
				chuhuoren.setAddress(rs.getString("address"));
				chuhuoren.setShouhuorenAddress(rs.getString("shouhuorenAddress"));
				chuhuoren.setProductName(rs.getString("productName"));
				chuhuoren.setApplyStatus(rs.getString("applyStatus"));
				chuhuoren.setIdentity(rs.getString("identity"));
				chuhuoren.setFujian(rs.getString("fujian"));
				chuhuoren.setProductFujian(rs.getString("productFujian"));
				chuhuoren.setShouhuorenTel(rs.getString("shouhuorenTel"));
				chuhuoren.setShouhuorenName(rs.getString("shouhuorenName"));
				chuhuoren.setFahuoStatus(rs.getString("fahuoStatus"));
				chuhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				chuhuoren.setProductFujianYuanshiming(rs.getString("productFujianYuanshiming"));
				chuhuorenList.add(chuhuoren);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chuhuorenList", chuhuorenList);
		req.getRequestDispatcher("qiantai/jingyingren/jingyingrenChakanChuhuoren.jsp").forward(req, res);
	}
	
	public void chuhuorenManaAdmin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List chuhuorenList=new ArrayList();
		String sql="select * from chuhuoren";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchuhuoren chuhuoren=new Tchuhuoren();
				chuhuoren.setId(rs.getString("id"));
				chuhuoren.setName(rs.getString("name"));
				chuhuoren.setSex(rs.getString("sex"));
				chuhuoren.setAge(rs.getInt("age"));
				chuhuoren.setTelephone(rs.getString("telephone"));
				chuhuoren.setAddress(rs.getString("address"));
				chuhuoren.setShouhuorenAddress(rs.getString("shouhuorenAddress"));
				chuhuoren.setProductName(rs.getString("productName"));
				chuhuoren.setApplyStatus(rs.getString("applyStatus"));
				chuhuoren.setIdentity(rs.getString("identity"));
				chuhuoren.setFujian(rs.getString("fujian"));
			    chuhuoren.setProductFujian(rs.getString("productFujian"));
				chuhuoren.setShouhuorenTel(rs.getString("shouhuorenTel"));
				chuhuoren.setShouhuorenName(rs.getString("shouhuorenName"));
				chuhuoren.setFahuoStatus(rs.getString("fahuoStatus"));
				chuhuoren.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				chuhuoren.setProductFujianYuanshiming(rs.getString("productFujianYuanshiming"));
				chuhuorenList.add(chuhuoren);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("chuhuorenList", chuhuorenList);
		req.getRequestDispatcher("admin/chuhuoren/chuhuorenMana.jsp").forward(req, res);
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
