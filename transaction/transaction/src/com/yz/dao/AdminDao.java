package com.yz.dao;

import java.util.List;

import com.yz.domain.Admin;

public interface AdminDao {

	public abstract Admin Login(String name, String password); 
	 
	public abstract String findPower(String type);
	
	public abstract int add(Admin admin);

	public abstract List<Admin> list();

	public abstract Admin findAdmin(String id);

	public abstract String findAdminName(String AdminName);
	
	public abstract int findPassword(String id, String password);
	
	public abstract int findPasswordByAdmin(String admin, String password);
	
	public abstract int updatePassword(String id, String password1);
	
	public abstract int updatePasswordByAdmin(String admin, String password1);
	
	public abstract int update(Admin at);

	public abstract int delete(String id);







}