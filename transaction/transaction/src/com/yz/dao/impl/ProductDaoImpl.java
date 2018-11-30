package com.yz.dao.impl;


import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yz.dao.ProductDao;
import com.yz.domain.Product;
import com.yz.domain.ProductType;
import com.yz.page.QueryInfo;
import com.yz.page.QueryResult;
import com.yz.util.DBUtil;
 

public class ProductDaoImpl implements ProductDao{

		private Connection conn=null;
		private PreparedStatement ps=null;
		private ResultSet rs=null;
		private ResultSet rs1=null;
		/**
		 * 添加宝贝
		 * */
		public int addProduct(Product product)
		{
			int result=0;
			try {
				conn=DBUtil.getConnection();
				String sql="insert into product (name,originalprice,price,description,uploadimage,categoryID,trading,createtime,updatetime,publisher) values(?,?,?,?,?,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, product.getName());	
				ps.setFloat(2, product.getOriginalprice());
				ps.setFloat(3, product.getPrice());
				ps.setString(4,product.getDescription());
				ps.setString(5,product.getUploadImage());
				ps.setInt(6, product.getCategoryID());
				ps.setString(7, product.getTrading());
				ps.setTimestamp(8, new java.sql.Timestamp(((product.getCreatetime()).getTime())));
				ps.setTimestamp(9, new java.sql.Timestamp(((product.getUpdatetime()).getTime())));
				ps.setString(10, product.getPublisher());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
		 return result;
		}
		/**
		 * 获取所有的宝贝
		 * */
		public List<Product> getAllProduct()
		{
			List<Product> list=new ArrayList<Product>();
			try {
				conn=DBUtil.getConnection();
				String sql="select * from product where status='上架' order by createtime desc";
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next())
				{
					Product product=new Product();
					product.setId(Integer.parseInt(rs.getString("id")));
					product.setName(rs.getString("name"));
					product.setTrading(rs.getString("trading"));
					product.setOriginalprice(rs.getFloat("originalprice"));
					product.setPrice(rs.getFloat("price"));
					product.setDescription(rs.getString("description"));
					product.setUploadImage("http://localhost:8080/transaction/images/image200x/"+rs.getString("uploadimage"));
					product.setCategoryID(rs.getInt("categoryID"));
					product.setClickcount(rs.getInt("clickcount"));
					product.setCreatetime(rs.getTimestamp("createtime"));
					product.setPublisher(rs.getString("publisher"));
					product.setStatus(rs.getString("status"));
					
					list.add(product);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
			return list;
			
		}
		/**
		 * 获取所有的分类名称
		 * */
		public List<ProductType> getAllProductType()
		{
			List<ProductType> list=new ArrayList<ProductType>();
			try {
				conn=DBUtil.getConnection();
				String sql="select * from productcategory";
				ps=conn.prepareStatement(sql);
			
				rs=ps.executeQuery();
				while(rs.next())
			{
				ProductType producttype=new ProductType();
				producttype.setName(rs.getString("name"));
				//producttype.setDescription(rs.getString("description"));
				//producttype.setCreateTime(rs.getDate("createtime"));
				list.add(producttype);
			}} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
			return list;
		}
		public void delete(String id)
		{
			try {
				conn=DBUtil.getConnection();
				String sql="delete from product where id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1,id);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
			
		}
		/**
		 * 更新宝贝的信息
		 * */
		public void update(Product product){
			try {
				conn=DBUtil.getConnection();
				String sql="update product set name=?,price=?,updatetime=?where id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, product.getName());
				ps.setDouble(2, product.getPrice());
				ps.setDate(3,new java.sql.Date(new Date().getTime()));
				ps.setInt(4, product.getId());
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
		}
		/**
		 * 更新某个宝贝的浏览次数
		 * */
		public void updateClickcount(int clickcount, String id){
			try {
				conn=DBUtil.getConnection();
				String sql="update product set clickcount=? where id=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1,clickcount );
				ps.setString(2, id);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
		}
		/**
		 * 通过id查询商品信息
		 * */
		public Product find(String id)
		 {
			Product product=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from product where id=?"; 
				ps=conn.prepareStatement(sql);
				ps.setString(1,id);
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					product=new Product();
					product.setId(Integer.parseInt(rs.getString("id")));
					product.setName(rs.getString("name"));
					product.setOriginalprice(rs.getFloat("originalprice"));
					product.setPrice(rs.getFloat("price"));
					product.setDescription(rs.getString("description"));
					product.setUploadImage("http://localhost:8080/transaction/images/productimages/"+rs.getString("uploadimage"));
					product.setCategoryID(rs.getInt("categoryID"));
					product.setClickcount(rs.getInt("clickcount"));
					product.setTrading(rs.getString("trading"));
					product.setUpdatetime(rs.getTimestamp("updatetime"));
					product.setPublisher(rs.getString("publisher"));
					product.setStatus(rs.getString("status"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
			return product;
		 }
		/**
		 * 通过某分类的名称查询其id
		 * */
	 public int findCategoryID(String category){
	    	int result = 0;	
			try {			
				conn=DBUtil.getConnection();
				String sql="select id from productcategory where name=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, category);
				rs=ps.executeQuery();
				if(rs.next())
					result=rs.getInt("id");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.release(conn, ps, rs);
			}
			return result;
	}
	 /**
	  * 保存图片路径返回其保存的id
	  * */	
	public int seavePath(String path){
		int result=0;	
		try {			
			conn=DBUtil.getConnection();
			String sql="insert into uploadimage (path) value (?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, path);
			result= ps.executeUpdate();
			if(result>0){
				String sql1="select id from uploadimage where path=?";
				ps=conn.prepareStatement(sql1);
				ps.setString(1, path);
				rs=ps.executeQuery();
				if(rs.next())
					result=rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	/**
	 * 查询二级分类的所有id
	 * */
	public ArrayList<Integer> findTwoLevelIdByPid(int pid){
		try {
			ArrayList<Integer> list=new ArrayList<Integer>();//声明一个ArrayList为int型的数组
			conn=DBUtil.getConnection();
			String sql="select id from productcategory where pid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(rs.getInt("id"));			
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 查询三级分类的所有id
	 * */
	public ArrayList<Integer> findThreeLevelIdByPid(ArrayList<Integer> list){
		try {
			ArrayList<Integer> list2=new ArrayList<Integer>();//声明一个ArrayList为int型的数组
			conn=DBUtil.getConnection();
			for(int i=0;i<list.size();i++){  
				String sql="select id from productcategory where pid=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, list.get(i));
				rs=ps.executeQuery();
				while(rs.next()){
					list2.add(rs.getInt("id"));			
				}
			} 
			return list2;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 查询某一级分类中包含所有二级分类的名称及其下宝贝总数
	 * */
	public ArrayList<ProductType> findSecondLevelNameByid(ArrayList<Integer> list,ArrayList<Integer> list2){
		ArrayList<ProductType> list3=new ArrayList<ProductType>();
		try {
			conn=DBUtil.getConnection();
			for(int i=0;i<list.size();i++){  
				String sql="select * from productcategory where id=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, list.get(i));
				rs=ps.executeQuery();
				while(rs.next()){
					ArrayList<Integer> list4=new ArrayList<Integer>();
					ProductType pt = new ProductType();
					int count = 0;
						pt.setId(rs.getString("id"));
						pt.setName(rs.getString("name"));
					//查询二级各类子类  
						String sql1="select id from productcategory where pid=?";
						ps=conn.prepareStatement(sql1);
						ps.setString(1,rs.getString("id"));
						rs=ps.executeQuery();
						while(rs.next()){
							list4.add(rs.getInt("id"));			
						}
					//得到总数
						for(int k=0;k<list4.size();k++){
							sql = "select categoryID from product where categoryID=?";
							ps = conn.prepareStatement(sql);
							ps.setInt(1,list4.get(k));
							rs = ps.executeQuery();
						while(rs.next()){
							pt.setAmount(++count);
							}
						}
					list3.add(pt);
				}
			} 
			return list3;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 查询某二级分类中包含所有三级分类的名称及其下宝贝总数
	 * */
	public ArrayList<ProductType> findThreeLevelNameBypid(String id){
		ArrayList<ProductType> list=new ArrayList<ProductType>();
		try {
			conn=DBUtil.getConnection();
			String sql="select * from productcategory where pid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			while(rs.next()){
				ProductType pt = new ProductType();
				int count = 0;
				pt.setId(rs.getString("id"));
				pt.setName(rs.getString("name"));
				String sql1="select count(id) from product where categoryID=?";//聚合函数，查询其总数
				ps=conn.prepareStatement(sql1);
				ps.setString(1,rs.getString("id"));
				rs1 =ps.executeQuery();
				while(rs1.next()) {
		                count = rs1.getInt(1);
		            }
				pt.setAmount(count);
				list.add(pt);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
			try {
				rs1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 查询二级分类的名称
	 * */
	public ProductType findThreeLevelNameById(String categoryID){
		try {
			ProductType pt = new ProductType();
			conn=DBUtil.getConnection();
			String sql="select * from productcategory where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,categoryID);
			rs=ps.executeQuery();
			while(rs.next()){
				pt.setName(rs.getString("name"));
				pt.setPid(rs.getInt("pid"));
			}
		
			return pt;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 查询一级分类中包含所有宝贝
	 * */
	public QueryResult findOneLevelAllProducts(QueryInfo info, ArrayList<Integer> list2){
		try {
			List<Product> list = new ArrayList<Product>();
			QueryResult qr = new QueryResult();
			int count=0,j=0;
			int startindex = info.getStartindex();
			conn=DBUtil.getConnection();
			String sql="select * from product order by createtime desc";//以发布时间降序排列desc
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
				while(rs.next()){
					for(int i=0;i<list2.size();i++){
						if(rs.getInt("categoryID")==list2.get(i)){
							if(count++>=startindex&&j++<info.getPagesize()){
								Product product=new Product();
								product.setId(Integer.parseInt(rs.getString("id")));
								product.setName(rs.getString("name"));
								product.setOriginalprice(rs.getFloat("originalprice"));
								product.setPrice(rs.getFloat("price"));
								product.setDescription(rs.getString("description"));
								product.setUploadImage("http://localhost:8080/transaction/images/image200x/"+rs.getString("uploadimage"));
								product.setCategoryID(rs.getInt("categoryID"));
								product.setClickcount(rs.getInt("clickcount"));
								product.setCreatetime(rs.getTimestamp("createtime"));
								product.setUpdatetime(rs.getTimestamp("updatetime"));
								product.setPublisher(rs.getString("publisher"));
								product.setStatus(rs.getString("status"));
								list.add(product);
							}
						}
					}
				}
				qr.setList(list);
				qr.setTotalrecord(count);
				return qr;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 查询上一级类别的名称
	 */
	public  ProductType findUpOneLevelName(String categoryID){
		try {
			conn=DBUtil.getConnection();
			String sql="select pid from productcategory where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, categoryID);
			rs=ps.executeQuery();
			if(rs.next()){
				String sql1="select id,name from productcategory where id=?";
				ps=conn.prepareStatement(sql1);
				ps.setString(1, rs.getString("pid"));
				rs=ps.executeQuery();
				if(rs.next()){
					ProductType pt = new ProductType();
					pt.setId(rs.getString("id"));
					pt.setName(rs.getString("name"));
					return pt;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 查询当前id所表示类别的名称
	 * */
	public  String findSecondLevelName(String id){
		try {
			conn=DBUtil.getConnection();
			String sql="select name from productcategory where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				return rs.getString("name");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 *查询三级所有宝贝 
	 */
	public QueryResult findThreeLevelProducts(QueryInfo info, String categoryID){
		try {
			List<Product> list =new ArrayList<Product>();
			QueryResult qr = new QueryResult();
			int count = 0;
			conn=DBUtil.getConnection();
			String sql="select * from product where categoryID=? limit ?,?"; 
			ps=conn.prepareStatement(sql);
			ps.setString(1,categoryID);
			ps.setInt(2, info.getStartindex());
			ps.setInt(3, info.getPagesize());
			rs=ps.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setOriginalprice(rs.getFloat("originalprice"));
				product.setPrice(rs.getFloat("price"));
				product.setDescription(rs.getString("description"));
				product.setUploadImage("http://localhost:8080/transaction/images/image200x/"+rs.getString("uploadimage"));
				product.setCategoryID(rs.getInt("categoryID"));
				product.setClickcount(rs.getInt("clickcount"));
				product.setCreatetime(rs.getTimestamp("createtime"));
				product.setPublisher(rs.getString("publisher"));
				product.setStatus(rs.getString("status"));
				list.add(product);
			}
			qr.setList(list);
			String sql1 = "select * from product where categoryID=?";
			ps = conn.prepareStatement(sql1);
			ps.setString(1,categoryID);
			rs = ps.executeQuery();
			while(rs.next()){
				qr.setTotalrecord(++count);
			}
			return qr;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 查询一级分类的名称
	 * */
	public String findOneLevelNameByid(int id){
		try {
			conn=DBUtil.getConnection();
			String sql="select name from productcategory where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				return rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	/**
	 * 模糊查询宝贝
	 * */
	public QueryResult searchProduct(QueryInfo info, String search){
		try {
			List<Product> list =new ArrayList<Product>();
			QueryResult qr = new QueryResult();
			int count = 0;
			conn=DBUtil.getConnection();
			String sql="select * from product where name like \'%"+search+"%\' limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, info.getStartindex());
			ps.setInt(2, info.getPagesize());
			rs=ps.executeQuery();
				while(rs.next()){
					Product product=new Product();
					product.setId(Integer.parseInt(rs.getString("id")));
					product.setName(rs.getString("name"));
					product.setOriginalprice(rs.getFloat("originalprice"));
					product.setPrice(rs.getFloat("price"));
					product.setDescription(rs.getString("description"));
					product.setUploadImage("http://localhost:8080/transaction/images/image200x/"+rs.getString("uploadimage"));
					product.setCategoryID(rs.getInt("categoryID"));
					product.setClickcount(rs.getInt("clickcount"));
					product.setCreatetime(rs.getTimestamp("createtime"));
					product.setPublisher(rs.getString("publisher"));
					product.setStatus(rs.getString("status"));
					list.add(product);
				}
				qr.setList(list);
				String sql1="select * from product where name like \'%"+search+"%\'";
				ps=conn.prepareStatement(sql1);
				rs=ps.executeQuery();
				while(rs.next()){
					qr.setTotalrecord(++count);
				}
			return qr;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return null;
	}
	
	/**
	 * 查看用户个人的闲置商品
	 * */
	public QueryResult getUserProduct(QueryInfo info, String username){

		List<Product> list=new ArrayList<Product>();
		QueryResult qr = new QueryResult();
		int count = 0;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from product where status='上架' and  publisher=? order by createtime desc limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setInt(2, info.getStartindex());
			ps.setInt(3, info.getPagesize());
			rs=ps.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setOriginalprice(rs.getFloat("originalprice"));
				product.setPrice(rs.getFloat("price"));
				product.setDescription(rs.getString("description"));
				product.setTrading(rs.getString("trading"));
				product.setUploadImage("http://localhost:8080/transaction/images/image200x/"+rs.getString("uploadimage"));
				product.setCategoryID(rs.getInt("categoryID"));
				product.setClickcount(rs.getInt("clickcount"));
				product.setCreatetime(rs.getTimestamp("createtime"));
				product.setPublisher(rs.getString("publisher"));
				product.setPurchaser(rs.getString("purchaser"));
				product.setStatus(rs.getString("status"));
				list.add(product);
			}
			qr.setList(list);
			sql = "select * from product where status='上架' and publisher=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			while(rs.next()){
				qr.setTotalrecord(++count);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return qr;
	}
	/**
	 * 收藏商品：把商品id和用户id放入collect表
	 * */
	public int addCollect(String productId, String userId) {
		
		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into collect (productid,userid) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, productId);
			ps.setString(2, userId);
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	/**
	 * 查找用户收藏的商品
	 * */
	public int findCollect(String productId, String userId) {
		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from  collect where productid=? and userid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, productId);
			ps.setString(2, userId);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 删除收藏商品
	 * */
	public int deleteCollect(String productId) {
		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from collect where productid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, productId);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	/**
	 * 商品下架
	 * */
	public int soldOut(String id) {
		
		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="update  product set status='已下架' where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return result;
	}
	/**
	 * 查找用户下架的商品
	 * */
	public QueryResult getUserSoldOutProduct(QueryInfo info, String username) {
		List<Product> list=new ArrayList<Product>();
		QueryResult qr = new QueryResult();
		int count = 0;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from product where status='已下架' and  publisher=? order by createtime desc limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setInt(2, info.getStartindex());
			ps.setInt(3, info.getPagesize());
			rs=ps.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setOriginalprice(rs.getFloat("originalprice"));
				product.setPrice(rs.getFloat("price"));
				product.setDescription(rs.getString("description"));
				product.setTrading(rs.getString("trading"));
				product.setUploadImage(rs.getString("uploadimage"));
				product.setCategoryID(rs.getInt("categoryID"));
				product.setClickcount(rs.getInt("clickcount"));
				product.setCreatetime(rs.getTimestamp("createtime"));
				product.setPublisher(rs.getString("publisher"));
				product.setPurchaser(rs.getString("purchaser"));
				product.setStatus(rs.getString("status"));
				list.add(product);
			}
			qr.setList(list);
			sql = "select * from product where  status='已下架' and publisher=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			while(rs.next()){
				qr.setTotalrecord(++count);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return qr;
	}
	/**
	 * 移除下架的商品
	 * */
	public int deleteSoldOUt(String id) {

		int result=0;
		try {
			conn=DBUtil.getConnection();
			String sql="update  product set status='隐藏已下架' where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 添加商品的买家
	 * */
	public void setPurchaserIntoProduct(String id,String purchaser) {

		try {
			conn=DBUtil.getConnection();
			String sql="update product set purchaser=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, purchaser);
			ps.setString(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
	}
	/**
	 * 商品的推荐
	 * */
	public void updateProductRecomend(String id){
		try {
			conn=DBUtil.getConnection();
			String sql="update product set recomend=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"推荐" );
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		
	}
	/**
	 *查找推荐的商品
	 * */
	public List<Product> getProductRecomend(){
		List<Product> list=new ArrayList<Product>();
		try {
			conn=DBUtil.getConnection();
			String sql="select * from product where recomend='推荐'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setTrading(rs.getString("trading"));
				product.setOriginalprice(rs.getFloat("originalprice"));
				product.setPrice(rs.getFloat("price"));
				product.setDescription(rs.getString("description"));
				product.setUploadImage("http://localhost:8080/transaction/images/image200x/"+rs.getString("uploadimage"));
				product.setCategoryID(rs.getInt("categoryID"));
				product.setClickcount(rs.getInt("clickcount"));
				product.setCreatetime(rs.getTimestamp("createtime"));
				product.setPublisher(rs.getString("publisher"));
				product.setStatus(rs.getString("status"));
				
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		return list;
	}
	
 }
