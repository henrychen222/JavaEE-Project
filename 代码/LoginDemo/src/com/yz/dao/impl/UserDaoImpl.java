package com.yz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yz.dao.UserDao;
import com.yz.domain.User;
import com.yz.utils.DBUtil;

public class UserDaoImpl implements UserDao{
	
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public int addUser(User user){
		int result=0;	
		try {			
			conn=DBUtil.getConnection();
			String sql="insert into user (id,username,password,) value (?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			result= ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
		
	}

}
