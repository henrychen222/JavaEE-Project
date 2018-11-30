package com.yz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	// 配置文件中读取数据库连接信息
	private static Properties config = new Properties();
	// 使用连接池得到数据库连接
	static {
		try {
			config.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(config.getProperty("driver"));
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		/**
		 * 连接池获得数据连�?
		 */
		/*try {
			Connection conn = t.get();
			if (conn == null) {
				conn = ds.getConnection();
				// t.set(conn);
			}
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}*/
		
		  //配置文件获得连接 
		 String url=config.getProperty("url"); 
		 String username=config.getProperty("username"); 
		 String password=config.getProperty("password"); 
		 return DriverManager.getConnection(url,username,password);

	}

	/**
	 * �?��线程�?��模式的事�?
	 */
	/*public static void startTransaction() {
		try {
			Connection conn = t.get();
			if (conn == null) {
				conn = getConnection();
				t.set(conn);
			}
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/

	/**
	 * 使用线程�?��模式提交事务
	 */
	/*public static void commitTransaction() {
		try {
			Connection conn = t.get();
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/

	/**
	 * 使用线程�?��模式关闭事务
	 */
	/*public static void closeTransaction() {

		try {
			Connection conn = t.get();
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			t.remove();
		}
	}*/

	/**
	 * 得到数据库连接池
	 * 
	 * @return
	 */
	/*public static DataSource getDataSource() {
		return ds;
	}*/

	/**
	 * 关闭数据库资�?
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void release(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 if (conn != null) {
		 try {
			 conn.close();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 	}
		 }
	}

}
