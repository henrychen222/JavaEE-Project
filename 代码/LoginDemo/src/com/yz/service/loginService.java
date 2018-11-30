package com.yz.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.yz.dao.DB;
import com.yz.domain.User;
import com.yz.utils.MD5;

public class loginService
{
	public String login(String loginname,String loginpw,int userType)
	{
		
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}
		
		String result="no";
		
		
			String sql="select * from user where loginname=? and loginpw=?";
			Object[] params={loginname,new MD5().complie(loginpw.trim())};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					
					 User user=new User();
					 user.setId(rs.getString("id"));
					 user.setUsername(rs.getString("username"));
					 user.setPassword(rs.getString("password"));
					 user.setRealname(rs.getString("realname"));
					 user.setBirthday(rs.getString("birthday"));
					 user.setEmail(rs.getString("email"));
					 
					 WebContext ctx = WebContextFactory.get();  //dwr
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 0);
		             session.setAttribute("user", user);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("µÇÂ¼Ê§°Ü£¡");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
		
		     return	result;
		}
		
		 
			
	

  
    
}
