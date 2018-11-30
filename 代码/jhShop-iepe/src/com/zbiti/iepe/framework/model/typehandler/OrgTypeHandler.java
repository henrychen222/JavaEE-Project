package com.zbiti.iepe.framework.model.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.zbiti.iepe.framework.model.BaseOrganization;

/**
 * 机构类型转换
 * 
 * @author zhaoqi
 * 
 */
public class OrgTypeHandler implements TypeHandler<Object>
{

	@Override
	public Object getResult(ResultSet rs, String colName) throws SQLException
	{
		BaseOrganization bo = new BaseOrganization();
		bo.setOrgId(rs.getString(colName));
		return bo;
	}

	@Override
	public Object getResult(ResultSet rs, int i) throws SQLException
	{
		BaseOrganization bo = new BaseOrganization();
		bo.setOrgId(rs.getString(i));
		return bo;
	}

	@Override
	public Object getResult(CallableStatement cs, int i) throws SQLException
	{
		BaseOrganization bo = new BaseOrganization();
		bo.setOrgId(cs.getString(i));
		return bo;
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException
	{
		ps.setString(i, ((BaseOrganization) parameter).getOrgId());
	}

}
