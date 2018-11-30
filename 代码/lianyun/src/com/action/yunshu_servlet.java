package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
import com.orm.Tyunshu;

public class yunshu_servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
        if(type.endsWith("yunshuAdd"))
		{
			yunshuAdd(req, res);
		}
        if(type.endsWith("chuhuorenChakanYunshu"))
		{
        	chuhuorenChakanYunshu(req, res);
		}
        if(type.endsWith("yunshuSearch"))
		{
        	yunshuSearch(req, res);
		}
        
        if(type.endsWith("yunshuMana"))
		{
			yunshuMana(req, res);
		}
        if(type.endsWith("yunshuManaAdmin"))
		{
        	yunshuManaAdmin(req, res);
		}
        if(type.endsWith("yunshuMana1"))
		{
			yunshuMana1(req, res);
		}
        if(type.endsWith("yunshuQuery"))
		{
        	yunshuQuery(req, res);
		}
        if(type.endsWith("yunshuDel"))
		{
        	yunshuDel(req, res);
		}
        if(type.endsWith("yunshuEdit"))
		{
        	yunshuEdit(req, res);
		}
        if(type.endsWith("chaxunYunshuByDay"))
		{
        	chaxunYunshuByDay(req, res);
		}
        if(type.endsWith("chaxunYunshuByMonth"))
		{
        	chaxunYunshuByMonth(req, res);
		}
        if(type.endsWith("chaxunYunshuByYear"))
		{
        	chaxunYunshuByYear(req, res);
		}
	}
	
	public void yunshuDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from yunshu where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "yunshu?type=yunshuManaAdmin");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void yunshuManaAdmin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yunshuList=new ArrayList();
		String sql="select * from yunshu";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyunshu yunshu=new Tyunshu();
				yunshu.setId(rs.getString("id"));
				yunshu.setProductName(rs.getString("productName"));
				yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
				yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
				yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
				yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
				yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
				yunshu.setShijian(rs.getString("shijian"));
				yunshu.setFeiyong(rs.getInt("feiyong"));
				yunshuList.add(yunshu);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yunshuList", yunshuList);
		req.getRequestDispatcher("admin/yunshu/yunshuMana.jsp").forward(req, res);
	}
	
	
	public void yunshuEdit(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		String id=req.getParameter("id");
		String productName=req.getParameter("productName");
		String chuhuorenName=req.getParameter("chuhuorenName");
		String shouhuorenName=req.getParameter("shouhuorenName");
		String chuhuorenTel=req.getParameter("chuhuorenTel");
		String shouhuorenTel=req.getParameter("shouhuorenTel");
		String yunshuStyle=req.getParameter("yunshuStyle");
		String feiyong=req.getParameter("feiyong");
		String sql="update yunshu set productName=?,chuhuorenName=?,shouhuorenName=?,chuhuorenTel=?,shouhuorenTel=?,yunshuStyle=?,feiyong=? where id="+id;
		System.out.println("1111111111"+sql);
		Object[] params={productName,chuhuorenName,shouhuorenName,chuhuorenTel,shouhuorenTel,yunshuStyle,feiyong};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "yunshu?type=yunshuMana1");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	
	public void yunshuQuery(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		Tyunshu yunshu=new Tyunshu();
		
		String sql="select * from yunshu where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			yunshu.setId(rs.getString("id"));
			yunshu.setProductName(rs.getString("productName"));
			yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
			yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
			yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
			yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
			yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
			yunshu.setShijian(rs.getString("shijian"));
			yunshu.setFeiyong(rs.getInt("feiyong"));
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		// WebContext ctx = WebContextFactory.get(); 
		 //HttpSession session=ctx.getSession(); 
		req.setAttribute("yunshu", yunshu);
		req.getRequestDispatcher("qiantai/yunshu/yunshuEidt1.jsp").forward(req, res);
	}
	
	
	
	
	public void yunshuMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yunshuList=new ArrayList();
		String sql="select * from yunshu";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyunshu yunshu=new Tyunshu();
				yunshu.setId(rs.getString("id"));
				yunshu.setProductName(rs.getString("productName"));
				yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
				yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
				yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
				yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
				yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
				yunshu.setShijian(rs.getString("shijian"));
				yunshu.setFeiyong(rs.getInt("feiyong"));
				yunshuList.add(yunshu);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yunshuList", yunshuList);
		req.getRequestDispatcher("qiantai/yunshu/yunshuMana.jsp").forward(req, res);
	}
	public void chaxunYunshuByDay(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yunshuList=new ArrayList();
		String sql="select * from yunshu where date(shijian) = curdate()";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyunshu yunshu=new Tyunshu();
				yunshu.setId(rs.getString("id"));
				yunshu.setProductName(rs.getString("productName"));
				yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
				yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
				yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
				yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
				yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
				yunshu.setShijian(rs.getString("shijian"));
				yunshu.setFeiyong(rs.getInt("feiyong"));
				yunshuList.add(yunshu);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yunshuList", yunshuList);
		req.getRequestDispatcher("qiantai/yunshu/yunshuMana1.jsp").forward(req, res);
	}
	
	public void chaxunYunshuByMonth(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yunshuList=new ArrayList();
		String sql="select * from yunshu where DATE_SUB(CURDATE(), INTERVAL 1 MONTH) <= date(shijian)";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyunshu yunshu=new Tyunshu();
				yunshu.setId(rs.getString("id"));
				yunshu.setProductName(rs.getString("productName"));
				yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
				yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
				yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
				yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
				yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
				yunshu.setShijian(rs.getString("shijian"));
				yunshu.setFeiyong(rs.getInt("feiyong"));
				yunshuList.add(yunshu);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yunshuList", yunshuList);
		req.getRequestDispatcher("qiantai/yunshu/yunshuMana1.jsp").forward(req, res);
	}
	
	public void chaxunYunshuByYear(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yunshuList=new ArrayList();
		String sql="select * from yunshu where DATE_SUB(CURDATE(), INTERVAL 12 MONTH) <= date(shijian)";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyunshu yunshu=new Tyunshu();
				yunshu.setId(rs.getString("id"));
				yunshu.setProductName(rs.getString("productName"));
				yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
				yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
				yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
				yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
				yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
				yunshu.setShijian(rs.getString("shijian"));
				yunshu.setFeiyong(rs.getInt("feiyong"));
				yunshuList.add(yunshu);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yunshuList", yunshuList);
		req.getRequestDispatcher("qiantai/yunshu/yunshuMana1.jsp").forward(req, res);
	}
	
	public void yunshuMana1(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yunshuList=new ArrayList();
		String sql="select * from yunshu";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyunshu yunshu=new Tyunshu();
				yunshu.setId(rs.getString("id"));
				yunshu.setProductName(rs.getString("productName"));
				yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
				yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
				yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
				yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
				yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
				yunshu.setShijian(rs.getString("shijian"));
				yunshu.setFeiyong(rs.getInt("feiyong"));
				yunshuList.add(yunshu);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yunshuList", yunshuList);
		req.getRequestDispatcher("qiantai/yunshu/yunshuMana1.jsp").forward(req, res);
	}
	
	
	
	public void yunshuSearch(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		List yunshuList=new ArrayList();
		String chuhuorenName=req.getParameter("chuhuorenName");
		String yunshuStyle=req.getParameter("yunshuStyle");
		String sql="select * from yunshu where chuhuorenName='" +chuhuorenName
				+ "' and yunshuStyle='" +yunshuStyle
				+ "'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyunshu yunshu=new Tyunshu();
				yunshu.setId(rs.getString("id"));
				yunshu.setProductName(rs.getString("productName"));
				yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
				yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
				yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
				yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
				yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
				yunshu.setShijian(rs.getString("shijian"));
				yunshu.setFeiyong(rs.getInt("feiyong"));
				yunshuList.add(yunshu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yunshuList", yunshuList);
		req.getRequestDispatcher("qiantai/yunshu/chuhuorenChakanyunshuMana1.jsp").forward(req, res);
	}
	
	
	public void chuhuorenChakanYunshu(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yunshuList=new ArrayList();
		String sql="select * from yunshu";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyunshu yunshu=new Tyunshu();
				yunshu.setId(rs.getString("id"));
				yunshu.setProductName(rs.getString("productName"));
				yunshu.setChuhuorenName(rs.getString("chuhuorenName"));
				yunshu.setShouhuorenName(rs.getString("shouhuorenName"));
				yunshu.setChuhuorenTel(rs.getString("chuhuorenTel"));
				yunshu.setShouhuorenTel(rs.getString("shouhuorenTel"));
				yunshu.setYunshuStyle(rs.getString("yunshuStyle"));
				yunshu.setShijian(rs.getString("shijian"));
				yunshu.setFeiyong(rs.getInt("feiyong"));
				yunshuList.add(yunshu);
		    }
			rs.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yunshuList", yunshuList);
		req.getRequestDispatcher("qiantai/yunshu/chuhuorenChakanyunshuMana.jsp").forward(req, res);
	}
	
	
	public void yunshuAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String productName=req.getParameter("productName");
		String chuhuorenName=req.getParameter("chuhuorenName");
		String shouhuorenName=req.getParameter("shouhuorenName");
		String chuhuorenTel=req.getParameter("chuhuorenTel");
		String shouhuorenTel=req.getParameter("shouhuorenTel");
		String yunshuStyle=req.getParameter("yunshuStyle");
		String feiyong=req.getParameter("feiyong");
		String shijian=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		String sql="insert into yunshu values(?,?,?,?,?,?,?,?,?)";
		Object[] params={id,productName,chuhuorenName,shouhuorenName,chuhuorenTel,shouhuorenTel,yunshuStyle,feiyong,shijian};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "yunshu?type=yunshuMana");
		
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
