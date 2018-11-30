package com.yz.service.impl;

import java.util.List;

import com.yz.dao.AdminTypeDao;
import com.yz.dao.impl.AdminTypeDaoImpl;
import com.yz.domain.AdminType;
import com.yz.service.AdminTypeService;

public class AdminTypeServiceImpl implements AdminTypeService {
	
	AdminTypeDao dao=null;
	/* (non-Javadoc)
	 * @see com.yz.service.impl.AdminTypeService#list()
	 */
	public List<AdminType> list()
	{
		dao=new AdminTypeDaoImpl();
		return dao.list();
	}
	
	public void addAdminType(AdminType adminType)
	{
		dao=new AdminTypeDaoImpl();
		dao.addAdminType(adminType);
	}
	
	public void deleteAdminType(String name)
	{
		dao=new AdminTypeDaoImpl();
		dao.delete(name);
	}
	
	public void updateAdminType(AdminType at)
	{
		dao=new AdminTypeDaoImpl();
		dao.update(at);
	}
	
	public AdminType findAdminType(String name)
	{
		dao=new AdminTypeDaoImpl();
		return dao.find(name);
	}
	
}
