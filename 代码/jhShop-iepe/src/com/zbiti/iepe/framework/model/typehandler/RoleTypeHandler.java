package com.zbiti.iepe.framework.model.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import com.zbiti.iepe.framework.model.BaseUser;
import com.zbiti.iepe.framework.smo.RoleSmo;

/**
 * 角色类型转换
 * 
 * @author zhaoqi
 * 
 */
public class RoleTypeHandler implements TypeHandler<Object>
{

	/**
	 * 角色服务层
	 */
	@Autowired
	RoleSmo roleSmoImpl;

	@Override
	public Object getResult(ResultSet rs, String colName) throws SQLException
	{
		return roleSmoImpl.getRoleById(rs.getString(colName));
	}

	@Override
	public Object getResult(ResultSet rs, int i) throws SQLException
	{
		return roleSmoImpl.getRoleById(rs.getString(i));
	}

	@Override
	public Object getResult(CallableStatement cs, int i) throws SQLException
	{
		return roleSmoImpl.getRoleById(cs.getString(i));
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException
	{
		ps.setString(i, ((BaseUser) parameter).getUserId());
	}

}
