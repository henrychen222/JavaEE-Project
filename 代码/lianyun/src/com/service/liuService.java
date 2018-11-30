package com.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.DB;

import com.orm.Tnews;
import com.orm.Tuser;

public class liuService
{
	public static Tuser getUser(String id)
	{
		Tuser user=new Tuser();
		String sql="select * from user where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				//user.setLoginpw(rs.getString("loginpw"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return user;
	}
	public static List getNewsList()
	{
		List newsList=new ArrayList();
		String sql="select * from t_news";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tnews news=new Tnews();
				
				news.setId(rs.getString("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setShijian(rs.getString("shijian"));
				
				newsList.add(news);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return newsList;
	}
	
	
	/*
	
	public static List getNewsList()
	{
		List newsList=new ArrayList();
		String sql="select * from t_news";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tnews news=new Tnews();
				
				news.setId(rs.getString("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setShijian(rs.getString("shijian"));
				
				newsList.add(news);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return newsList;
	}
	
	
	public static void yudingDel(String id)
	{
		String sql="delete from t_yuding where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
	}
	
	public static void dingcaiDel(String id)
	{
		String sql="delete from t_dingcai where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
	}
	public static Tkefang get_kefang(String id)
	{
		Tkefang kefang=new Tkefang();
		
		String sql="select * from t_kefang where del='no' and id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				kefang.setId(rs.getString("id"));
				kefang.setFangjianhao(rs.getString("fangjianhao"));
				kefang.setFangjianmianji(rs.getInt("fangjianmianji"));
				kefang.setFangjianjianjie(rs.getString("fangjianjianjie"));
				
				kefang.setFujian(rs.getString("fujian"));
				kefang.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				kefang.setKefangleixing(rs.getString("kefangleixing"));
				kefang.setRijiage(rs.getInt("rijiage"));
				
				kefang.setDel(rs.getString("del"));
				
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return kefang;
	}
	public static Tcaipin get_caipin(String id)
	{
		Tcaipin caipin=new Tcaipin();
		
		String sql="select * from t_caipin where del='no' and id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				caipin.setId(rs.getString("id"));
				caipin.setCaipinjianjie(rs.getString("caipinjianjie"));
				caipin.setCaipinming(rs.getString("caipinming"));
				caipin.setCaipinjiage(rs.getInt("caipinjiage"));
				caipin.setDel(rs.getString("del"));
				caipin.setTupian(rs.getString("tupian"));
				
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return caipin;
	}
	
	public static int panduan_fangjianhao(String fangjianhao)
	{
		int i=0;
		String sql="select * from t_kefang where del='no' and fangjianhao=?";
		Object[] params={fangjianhao.trim()};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				i=1;
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return i;
	}
	public static int panduan_caipinming(String caipinming)
	{
		int i=0;
		String sql="select * from t_caipin where del='no' and caipinming=?";
		Object[] params={caipinming.trim()};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				i=1;
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return i;
	}
	*/
}



