package com.yz.service;

import java.util.List;

import com.yz.domain.AdminType;

public interface AdminTypeService {

	public abstract List<AdminType> list();

	public abstract void addAdminType(AdminType at);

	public abstract void deleteAdminType(String name);
	
	public abstract void updateAdminType(AdminType at);
	
	public abstract AdminType findAdminType(String name);

} 