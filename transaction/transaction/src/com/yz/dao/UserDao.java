package com.yz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.domain.Collect;
import com.yz.domain.User;
import com.yz.util.JdbcUtil;

public class UserDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	//注册时添加用户
	public int addUser(User user)
	{
		int result=0; 
		try {
			conn=JdbcUtil.getConnection();
			String sql="insert into user (id,username,password) values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3,user.getPassword());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		return result;
	}

	
	//用户登陆判断用户是否存在
	public User find(String username,String password)
	{
		User user=null;
		try {
			conn=JdbcUtil.getConnection();
			String sql="select * from user where username=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setRealname(rs.getString("realname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		
		return user;
	}
//查找数据库是否有重名的用户，即该用户是否被注册
	public User findRepeatUser(String username) {

		User user=null;
		try {
			conn=JdbcUtil.getConnection();
			String sql="select username from user where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setUsername(rs.getString("username"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		return user;
	}

	//修改密码判断初始密码是否正确
	public int findPassword(String id, String password) {
		int result=0;
		try {			
			conn=JdbcUtil.getConnection();
			String sql="select id,password from user where id=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs= ps.executeQuery();
			if(rs.next())
			{
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		return result;
	}


	//修改密码
	public int updatePassword(String id, String password1) {

		int result=0;
		try {			
			conn=JdbcUtil.getConnection();
			String sql="update user set password=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, password1);
			ps.setString(2, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		return result;
	}


	//根据id查找对象
	public User findUser(String id) {

		User user=null;
		try {
			conn=JdbcUtil.getConnection();
    		String sql="select * from user where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setRealname(rs.getString("realname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		return user;
	}


	//修改个人资料
	public void updateUserSelfInfo(User user) {
		try {
			conn=JdbcUtil.getConnection();
    		String sql="update user set realname=?,phone=?,email=? ,address=?where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getRealname());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getId());
			ps.execute();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		
	}

	public User findByUsername(String username) {
		User user=null;
		try {
			conn=JdbcUtil.getConnection();
    		String sql="select id,username,realname,phone,email,address from user where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			rs=ps.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setRealname(rs.getString("realname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		return user;
	}


	public User findEmail(String username, String email,String realname) {

		User user=null;
		try {
			conn=JdbcUtil.getConnection();
			String sql="select * from user where (username=? and email=?) and realname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, realname);
			rs=ps.executeQuery();
			if(rs.next())
			{
				user=new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setRealname(rs.getString("realname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		return user;
		
	}


	public List<Collect> getCollectList(String userId) {

		Collect collect=null;
		List<Collect> list=new ArrayList<Collect>();
		try {
			conn=JdbcUtil.getConnection();
			String sql="select * from collect where userid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				collect=new Collect();
				collect.setProductId(rs.getInt("productid"));
				collect.setUserId(rs.getString("userid"));
				list.add(collect);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
		
		return list;
	}


	public void updateCenterInfo(User user) {

		try {
			conn=JdbcUtil.getConnection();
    		String sql="update user set realname=?,phone=?,email=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getRealname());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getId());
			ps.execute();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally
		{
			JdbcUtil.Release(rs, ps, conn);
		}
	}
}



