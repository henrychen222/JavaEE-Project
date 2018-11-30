package com.yz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.dao.AdminTypeDao;
import com.yz.domain.AdminType;
import com.yz.util.DBUtil;
 
public class AdminTypeDaoImpl implements AdminTypeDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	/* (non-Javadoc)
	 * @see com.yz.dao.impl.AdminTypeDao#add(com.yz.domain.AdminType)
	 */
	public void addAdminType(AdminType at)
	{
		try {
			conn=DBUtil.getConnection();
			String sql="insert into manager_type values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,at.getName() );
			ps.setString(2,at.getPower() );
			ps.setString(3,at.getDescription() );
			ps.setTimestamp(4,new java.sql.Timestamp(((at.getUpdatetime()).getTime() )));
			ps.setTimestamp(5,new java.sql.Timestamp(((at.getCreatetime()).getTime() )));
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, ps, rs);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.yz.dao.impl.AdminTypeDao#list()
	 */
	public List<AdminType> list()
	{
		List<AdminType> list = new ArrayList<AdminType>();
		try {
			conn=DBUtil.getConnection();
			String sql="select * from manager_type";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				AdminType at=new AdminType();
				at.setName(rs.getString("name"));
				at.setPower(rs.getString("power"));
				at.setDescription(rs.getString("description"));
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
	/* (non-Javadoc)
	 * @see com.yz.dao.impl.AdminTypeDao#delete(java.lang.String)
	 */
	public void delete(String name)
	{
		try {
			conn=DBUtil.getConnection();
			String sql="delete from manager_type where name=?";
			name=new String(name.getBytes("iso8859-1"),"utf-8");//解决乱码

			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao层错误");
		}finally
		{
			DBUtil.release(conn, ps, null);
		}
	}
	/* (non-Javadoc)
	 * @see com.yz.dao.impl.AdminTypeDao#find(java.lang.String)
	 */
	public AdminType find(String name)
	{	
		 		AdminType  mt = null;			
			try {
				conn=DBUtil.getConnection();
				String sql="select * from manager_type where name=? ";
				ps=conn.prepareStatement(sql);
				
				ps.setString(1, name);
				rs=ps.executeQuery();
				 while(rs.next())
				    {
				    	mt=new AdminType ();			    	
				    	mt.setName(rs.getString("name"));
				    	mt.setPower(rs.getString("power"));
				    	mt.setDescription(rs.getString("description"));
				    	mt.setUpdatetime(rs.getTimestamp("updatetime"));
				    	mt.setCreatetime(rs.getTimestamp("createtime"));
				    }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
			return mt;
		}

	/* (non-Javadoc)
	 * @see com.yz.dao.impl.AdminTypeDao#update(com.yz.domain.AdminType)
	 */
	public void update(AdminType mt)
	{
	
		try {
			conn=DBUtil.getConnection();
			String sql="update  manager_type set power=?,description=?,updatetime=? where name=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, mt.getPower());
			ps.setString(2, mt.getDescription());
			ps.setTimestamp(3, new java.sql.Timestamp(mt.getUpdatetime().getTime()));
			ps.setString(4, mt.getName());	
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
    }
}
