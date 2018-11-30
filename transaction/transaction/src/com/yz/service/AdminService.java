package com.yz.service;

import java.util.List;

import com.yz.domain.Admin;
import com.yz.web.formbean.AdminFormBean;

public interface AdminService {
 
	public abstract int addAdmin(AdminFormBean adminFormBean);

	public abstract Admin Login(String name,String password);

	public abstract String findPower(String type); 
	
	public abstract List<Admin> list();

	public abstract Admin findAdmin(String id);
	
	public abstract String findAdminName(String AdminName);
	
	public abstract int findPassword(String id, String password);
	
	public abstract int findPasswordByAdmin(String admin, String password);
	
	public abstract int updatePassword(String id, String password1);
	
	public abstract int updatePasswordByAdmin(String admin, String password1);
	
	public abstract int deleteAdmin(String id);

	public abstract int updateAdmin(Admin at);





}