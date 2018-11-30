package com.zbiti.iepe.framework.model.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import com.zbiti.iepe.framework.model.BaseUser;
import com.zbiti.iepe.framework.smo.UserSmo;

/**
 * 用户对象TypeHandler
 * 
 * @author zhaoqi
 * 
 */
public class UserTypeHandler implements TypeHandler<Object>
{

	/**
	 * 用户服务层
	 */
	@Autowired
	UserSmo userSmoImpl;

	@Override
	public Object getResult(ResultSet rs, String colName) throws SQLException
	{
		return userSmoImpl.getUserById(rs.getString(colName));
	}

	@Override
	public Object getResult(ResultSet rs, int i) throws SQLException
	{
		return userSmoImpl.getUserById(rs.getString(i));
	}

	@Override
	public Object getResult(CallableStatement cs, int i) throws SQLException
	{
		return userSmoImpl.getUserById(cs.getString(i));
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException
	{
		ps.setString(i, ((BaseUser) parameter).getUserId());
	}

}
