package com.yz.dao;

import java.util.List;

import com.yz.domain.AdminType;

public interface AdminTypeDao {

	public abstract void addAdminType(AdminType at);
 
	public abstract List<AdminType> list();

	public abstract void delete(String name);

	public abstract AdminType find(String name);

	public abstract void update(AdminType mt);

}