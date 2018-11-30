package com.yz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import com.yz.dao.NewsDao;
import com.yz.domain.News;
import com.yz.util.DBUtil;
import com.yz.util.DateUtil;
 
public class NewsDaoImpl implements NewsDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
       /* (non-Javadoc)
	 * @see com.yz.dao.impl.NewsDao#addNew(com.yz.domain.News)
	 */
    public int addNew(News news) {
		
		int result=0;	
		try {			
			conn=DBUtil.getConnection();
			String sql="insert into new (id,title,publisher,content,updatetime,createtime) values (?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, news.getId());
			ps.setString(2, news.getTitle());
			ps.setString(3, news.getPublisher());
			ps.setString(4, news.getContent());
			ps.setTimestamp(5, new java.sql.Timestamp((new Date()).getTime()));
			ps.setTimestamp(6, new java.sql.Timestamp((new Date()).getTime()));
			result= ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.release(conn, ps, rs);
		}
		
		return result;
	
		}
    /* (non-Javadoc)
	 * @see com.yz.dao.impl.NewsDao#findAllNews()
	 */
    public List<News> findAllNews() {
	   ArrayList<News> list=new ArrayList<News>();
	   try {
		conn=DBUtil.getConnection();
		String sql="select * from new";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			News news=new News();
			news.setId(rs.getString("id"));
			news.setTitle(rs.getString("title"));
			news.setPublisher(rs.getString("publisher"));
			news.setContent(rs.getString("content"));
			news.setCreatetime(rs.getTimestamp("createtime"));
			news.setUpdatetime(rs.getTimestamp("updatetime"));
			list.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.release(conn, ps, rs);
		}
		return list;
    }
    public List<News> findOne2FiveNews(){
       ArrayList<News> list=new ArrayList<News>();
  	   try {
  		conn=DBUtil.getConnection();
  		String sql="select * from new order by createtime desc limit ?,?";
  		ps=conn.prepareStatement(sql);
  		ps.setInt(1, 0);
		ps.setInt(2, 5);
  		rs=ps.executeQuery();
  		while(rs.next()){
  			News news=new News();
  			news.setId(rs.getString("id"));
  			news.setTitle(rs.getString("title"));
  			news.setPublisher(rs.getString("publisher"));
  			news.setContent(rs.getString("content"));
  			news.setCreatetime(rs.getDate("createtime"));
			news.setUpdatetime(rs.getDate("updatetime"));
  			list.add(news);
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}finally{
  			DBUtil.release(conn, ps, rs);
  		}
  		return list;
    }
     /* (non-Javadoc)
	 * @see com.yz.dao.impl.NewsDao#findNews(java.lang.String)
	 */
    public News findNews(String id) {
	   News news=new News();
	   try {
		conn=DBUtil.getConnection();
		String sql="select * from new where id=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		rs=ps.executeQuery();
		
		if(rs.next()){
			
			news.setId(rs.getString("id"));
			news.setTitle(rs.getString("title"));
			news.setPublisher(rs.getString("publisher"));
			news.setContent(rs.getString("content"));
			news.setCreatetime(DateUtil.str2Date(rs.getString("createtime")));
			news.setUpdatetime(DateUtil.str2Date(rs.getString("updatetime")));
			
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBUtil.release(conn, ps, rs);
	}
	return news;
       
   }
    /* (non-Javadoc)
	 * @see com.yz.dao.impl.NewsDao#updateNews(com.yz.domain.News)
	 */
    public void updateNews(News news) {
	   try {			
		conn=DBUtil.getConnection();
		String sql="update new set title=?,publisher=?,content=?,updatetime=?,createtime=? where id=?";
		ps=conn.prepareStatement(sql);

		ps.setString(1, news.getTitle());
		ps.setString(2, news.getPublisher());
		ps.setString(3, news.getContent());
		ps.setDate(4,new java.sql.Date(((news.getUpdatetime()).getTime() )));
		ps.setDate(5, new java.sql.Date((new Date()).getTime()));
		ps.setString(6, news.getId());
		ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}finally
	{
		DBUtil.release(conn, ps, rs);
	}
    }/* (non-Javadoc)
	 * @see com.yz.dao.impl.NewsDao#deleteNews(java.lang.String)
	 */
    public void deleteNews(String id) {
	   try {			
		conn=DBUtil.getConnection();
		String sql="delete from new  where id=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		DBUtil.release(conn, ps, rs);
	}
	
}

}