package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tuser;
import com.util.MD5;

public class loginService
{
	public String login(String loginname,String loginpw,int userType)
	{
		System.out.println("userType111111111"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//·¢»õÈË
		{
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
					 /*
					 Toldman oldman=new Toldman();
						
						oldman.setId(rs.getString("id"));
						oldman.setName(rs.getString("name"));
						oldman.setSex(rs.getString("sex"));
						oldman.setAge(rs.getInt("age"));
						oldman.setTelephone(rs.getString("telephone"));
						oldman.setAddress(rs.getString("address"));
						oldman.setHealthy(rs.getString("healthy"));
						oldman.setContent(rs.getString("content"));
						oldman.setStatus(rs.getString("status"));
						oldman.setFlag(rs.getString("flag"));
						oldman.setFujian(rs.getString("fujian"));
						oldman.setGugua(rs.getString("Gugua"));
						oldman.setHistory(rs.getString("history"));
						oldman.setGuoming(rs.getString("guoming"));
						oldman.setZili(rs.getString("zili"));
						oldman.setLoginname(rs.getString("loginname"));
						oldman.setLoginpw(rs.getString("loginpw"));
						oldman.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
						*/
					 Tuser user=new Tuser();
					 user.setId(rs.getString("id"));
					 user.setName(rs.getString("name"));
					 user.setSex(rs.getString("sex"));
					 user.setAge(rs.getInt("age"));
					 user.setLoginname(rs.getString("loginname"));
					 user.setLoginpw(rs.getString("loginpw"));
					 //user.setDel(rs.getString("del"));
					 WebContext ctx = WebContextFactory.get(); 
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
			
		}
		
		
		if(userType==1)
		{
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
					 Tuser user=new Tuser();
					 user.setId(rs.getString("id"));
					 user.setName(rs.getString("name"));
					 user.setSex(rs.getString("sex"));
					 user.setAge(rs.getInt("age"));
					 user.setLoginname(rs.getString("loginname"));
					 user.setLoginpw(rs.getString("loginpw"));
					WebContext ctx = WebContextFactory.get(); 
					HttpSession session=ctx.getSession(); 
					session.setAttribute("userType", 1);
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
		}
		
		if(userType==2)
		{
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
					 Tuser user=new Tuser();
					 user.setId(rs.getString("id"));
					 user.setName(rs.getString("name"));
					 user.setSex(rs.getString("sex"));
					 user.setAge(rs.getInt("age"));
					 user.setLoginname(rs.getString("loginname"));
					 user.setLoginpw(rs.getString("loginpw"));
					WebContext ctx = WebContextFactory.get(); 
					HttpSession session=ctx.getSession(); 
					session.setAttribute("userType", 2);
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
		}
		
		if(userType==3)
		{
			String sql="select * from t_admin where userName=? and userPw=?";
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
					 TAdmin admin=new TAdmin();
					 admin.setUserId(rs.getString("userId"));
					 admin.setUserName(rs.getString("userName"));
					 admin.setUserPw(rs.getString("userPw"));
					 admin.setName(rs.getString("name"));
					 admin.setGonghao(rs.getString("gonghao"));
					 admin.setTelephone(rs.getString("telephone"));
					WebContext ctx = WebContextFactory.get(); 
					HttpSession session=ctx.getSession(); 
					session.setAttribute("userType", 2);
		            session.setAttribute("admin", admin);
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
		}
		if(userType==4)
		{
			
		}
		return result;
	}
	
	
	public String userLogout()
    {
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		
		session.setAttribute("userType", null);
        session.setAttribute("user", null);
		
		return "yes";
    }

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		
		String sql="update t_admin set userPw=? where userId=?";
		Object[] params={userPwNew,admin.getUserId()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		
		return "yes";
    }
    
    
}
