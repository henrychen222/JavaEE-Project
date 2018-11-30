package com.yz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yz.dao.AdminDao;
import com.yz.domain.Admin;
import com.yz.util.DBUtil;
 
public class AdminDaoImpl implements AdminDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	/* (non-Javadoc)
	 * @see com.yz.dao.impl.AdminDao#add(com.yz.domain.Admin)
	 */
	public int add(Admin admin) {
		
		int result=0;	
		try {			
			conn=DBUtil.getConnection();
			String sql="insert into admin (id,name,password,description,type,updatetime,createtime) value (?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, admin.getId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getDescription());
			ps.setString(5, admin.getType());
			ps.setTimestamp(6, new java.sql.Timestamp(admin.getCreatetime().getTime()));		
			ps.setTimestamp(7, new java.sql.Timestamp(admin.getUpdatetime().getTime()));
			result= ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	
	public Admin Login (String name,String password) {
		
		Admin admin=null;	
		try {			
			conn=DBUtil.getConnection();
			String sql="select * from admin where name=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				admin=new Admin();
				admin.setId(rs.getString("id"));
				admin.setName(rs.getString("name"));	
				admin.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return admin;
	}
	
	public String findPower(String type){
		String power=null;	
		try {			
			conn=DBUtil.getConnection();
			String sql="select power from manager_type where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, type);
			rs=ps.executeQuery();
			if(rs.next())
				power=rs.getString("power");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return power;
	}
	
	public List<Admin> list()
	{
		List<Admin> list = new ArrayList<Admin>();
		try {
			conn=DBUtil.getConnection();
			String sql="select admin.id,admin.name,admin.type,admin.updatetime,admin.createtime,manager_type.description from admin,manager_type where admin.type=manager_type.name";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				Admin at=new Admin();
				at.setId(rs.getString("id"));
				at.setName(rs.getString("name"));
				at.setDescription(rs.getString("description"));
				at.setType(rs.getString("type"));
				at.setUpdatetime(rs.getTimestamp("updatetime"));
				at.setCreatetime(rs.getTimestamp("createtime"));
				list.add(at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return list;
	}
	
	public Admin findAdmin(String id)
	{
			Admin at = null;			
		try {
			conn=DBUtil.getConnection();
			String sql="select * from admin where id=? ";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, id);
			rs=ps.executeQuery();
			 while(rs.next())
			    {
			    	at=new Admin();	
			    	at.setId(rs.getString("id"));
			    	at.setName(rs.getString("name"));
			    	at.setType(rs.getString("type"));
			    	at.setDescription(rs.getString("description"));
			    	at.setUpdatetime(rs.getTimestamp("updatetime"));
			    	at.setCreatetime(rs.getTimestamp("createtime"));
			    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return at;
	}
	
	public String findAdminName(String AdminName)
	{
		String at = null;			
		try {
			conn=DBUtil.getConnection();
			String sql="select name from admin where name=? ";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, AdminName);
			rs=ps.executeQuery();
			if(rs.next())
			{
				at=rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return at;
	}
	
	public int findPassword(String id,String password)
	{
		int result=0;
		try {			
			conn=DBUtil.getConnection();
			String sql="select id,password from admin where id=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs= ps.executeQuery();
			if(rs.next())
				result = 1;
		} catch (SQLException e) {
			System.out.println("dao层错误");
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	
	public int findPasswordByAdmin(String admin, String password) {
		int result=0;
		try {			
			conn=DBUtil.getConnection();
			String sql="select name,password from admin where name=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, admin);
			ps.setString(2, password);
			
			rs= ps.executeQuery();
			if(rs.next())
				result = 1;
		} catch (SQLException e) {
			System.out.println("dao层错误");
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	
	public int updatePassword(String id,String password1)
	{
		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="update admin set password=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, password1);
			ps.setString(2, id);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("dao层错误");
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	
	public int updatePasswordByAdmin(String admin,String password1)
	{
		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="update admin set password=? where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, password1);
			ps.setString(2, admin);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("dao层错误");
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	
	public int update(Admin at)
	{
		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="update admin set name=?,type=?,description=?,updatetime=? where id=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, at.getName());
			ps.setString(2, at.getType());
			ps.setString(3, at.getDescription());
			ps.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
			ps.setString(5, at.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	
	public int delete(String id)
	{
		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from admin where id=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, id);
			result=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao层错误");
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, null);
		}
		return result;
	}

}
