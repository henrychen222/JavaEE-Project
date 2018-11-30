package com.yz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.dao.OrderDao;
import com.yz.domain.Orders;
import com.yz.page.QueryInfo;
import com.yz.page.QueryResult;
import com.yz.util.DBUtil;
 
public class OrderDaoImpl implements OrderDao {
	
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	/* (non-Javadoc)
	 * @see com.yz.dao.impl.OrderDao#seveOrder(com.yz.domain.Orders)
	 */
	public int seveOrder(Orders order){
		int result=0;	
		try {			
			conn=DBUtil.getConnection();
			String sql="insert into orders (ordernumber,productid,productname,imagepath,seller,purchaser,buyertetlphone,address,trading,amount,orderStatus,placeordertime,explains) value (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, order.getOrdernumber());
			ps.setInt(2, order.getProductid());
			ps.setString(3, order.getProductname());
			ps.setString(4, order.getImagepath());
			ps.setString(5, order.getSeller());
			ps.setString(6, order.getPurchaser());
			ps.setString(7, order.getBuyertetlphone());
			ps.setString(8, order.getAddress());
			ps.setString(9, order.getTrading());
			ps.setFloat(10, order.getAmount());
			ps.setString(11, order.getOrderStatus());
			ps.setTimestamp(12, new java.sql.Timestamp(order.getPlaceordertime().getTime()));		
			ps.setString(13, order.getExplains());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
		
	}
	public  long findSerialNumber(String now){
		long result = 0;
		try {			
			conn=DBUtil.getConnection();
			String sql="select ordernumber from orders where ordernumber like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,now+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				result++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
		
	}
	public QueryResult findmeOrder(QueryInfo info,String purchaser){
		List<Orders> list = new ArrayList<Orders>();
		Orders order=null;
		QueryResult qr = new QueryResult();
		int count = 0;
		try {			
			conn=DBUtil.getConnection();
			String sql="select * from orders where purchaser=? or seller=? order by placeordertime desc limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,purchaser);
			ps.setString(2,purchaser);
			ps.setInt(3, info.getStartindex());
			ps.setInt(4, info.getPagesize());
			rs = ps.executeQuery();
			while(rs.next()){
			  order = new Orders();
				order.setOrdernumber(rs.getString("ordernumber"));
				order.setAddress(rs.getString("address"));
				order.setAmount(rs.getFloat("amount"));
				order.setBuyertetlphone(rs.getString("buyertetlphone"));
				order.setExplains(rs.getString("explains"));
				order.setImagepath(rs.getString("imagepath"));
				order.setOrderStatus(rs.getString("orderstatus"));
				order.setPlaceordertime(rs.getTimestamp("placeordertime"));
				order.setProductid(rs.getInt("productid"));
				order.setPurchaser(rs.getString("purchaser"));
				order.setSeller(rs.getString("seller"));
				order.setTrading(rs.getString("trading"));
				order.setProductname(rs.getString("productname"));
			  list.add(order);
			}
			qr.setList(list);
			sql = "select * from orders where purchaser=? or seller=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,purchaser);
			ps.setString(2,purchaser);
			rs = ps.executeQuery();
			while(rs.next()){
				qr.setTotalrecord(++count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		
		return qr;
	}
	public void deleteOrder(String ordernumber) {

		try {
			conn=DBUtil.getConnection();
			String sql="delete from orders where ordernumber=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,ordernumber);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
	}
	
}
