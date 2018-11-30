package com.zbiti.iepe.framework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCtest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.jdbc.Driver";
//      String url="jdbc:mysql://localhost:3306/school";
		String url="jdbc:mysql://172.16.1.14:3306/test84";
      Class.forName(driver);
      Connection connecter=DriverManager.getConnection(url,"root","123456");
          if(!connecter.isClosed()) System.out.println("success in getConnetion");
      Statement statement=connecter.createStatement();
      ResultSet rs=statement.executeQuery("select   bu.*,bo.org_id   from base_user bu   join   BASE_USER_2_ORGANIZATION bu2o   on bu2o.user_id = bu.user_id   join   base_organization bo   on bo.org_id = bu2o.organizational_id   where   bu.account_name = 'admin' and bu.is_delete = 0 and   bo.is_delete = 0 and bu.USER_STATE_CD = 1   order by bo.org_code,bu.user_id");
      System.out.println("编号"+"\t"+"名字"+"Phone"+"\t"+"Age");
      String No=null,Name=null,Age=null;
      while(rs.next())
      {
          No=rs.getString("id");
          Name=rs.getString("user_name");
          Age=rs.getString("age");
          System.out.println(No+"\t"+Name+"\t"+Age);
      }

	}

}
