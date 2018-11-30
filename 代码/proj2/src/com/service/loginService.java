package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.DB;
import com.item.User;
import com.util.MD5;

public class loginService
{
	public String login(String loginname,String loginpwd)
	{
		
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}
		
		String result="no";
		
			String sql="select * from register where loginname=? and loginpwd=?";
			Object[] params={loginname,loginpwd.trim()};
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
					 user.setLoginname(rs.getString("loginname"));
					 user.setLoginpwd(rs.getString("loginpwd"));
					 user.setName(rs.getString("name"));
					 user.setSex(rs.getString("sex"));
					 user.setAge(rs.getInt("age"));
					 
					 
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 
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
			
	

		return result;
	} 
}
