package com.zbiti.iepe.framework.dao;

import java.util.List;



import com.zbiti.iepe.framework.model.BaseCompany;
import com.zbiti.iepe.framework.model.BaseHost;



public interface HostDao {
	/**
	 * 一对多查询全部
	 */
	public List<BaseHost> findOne2Many();
	
	/**
	 * 增加用户
	 */
	public void save(BaseCompany bc);

}
