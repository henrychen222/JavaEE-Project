package com.yz.service.impl;

import java.util.Date;
import java.util.List;

import com.yz.dao.AdminDao;
import com.yz.dao.impl.AdminDaoImpl;
import com.yz.domain.Admin;
import com.yz.service.AdminService;
import com.yz.util.Md5Util;
import com.yz.util.UUIDUtils;
import com.yz.web.formbean.AdminFormBean;

public class AdminServiceImpl implements AdminService {
	AdminDao admindao=new AdminDaoImpl();
	/* (non-Javadoc)
	 * @see com.yz.service.impl.AdminService#addAdmin(com.yz.domain.Admin)
	 */
	public int addAdmin(AdminFormBean adminFormBean) {
		Admin admin = adminFormBean2admin(adminFormBean);
		return admindao.add(admin);
	}
	
	public Admin Login(String name,String password){
		
		return admindao.Login(name,password);
	}
	
	public String findPower(String type){
		return admindao.findPower(type);
	}
	
	public List<Admin> list()
	{
		return admindao.list();
	}
	
	public Admin findAdmin(String id)
	{
		return admindao.findAdmin(id);
	}
	
	public String findAdminName(String AdminName)
	{
		return admindao.findAdminName(AdminName);
	}
	
	public int findPassword(String id,String password)
	{
		return admindao.findPassword(id,password);
	}
	
	public int findPasswordByAdmin(String admin,String password)
	{
		return admindao.findPasswordByAdmin(admin,password);
	}
	
	public int updatePassword(String id,String password1)
	{
		return admindao.updatePassword(id,password1);
	}
	
	public int updatePasswordByAdmin(String admin,String password1)
	{
		return admindao.updatePasswordByAdmin(admin,password1);
	}
	
	public int updateAdmin(Admin at)
	{
		return admindao.update(at);
	}
	
	public int deleteAdmin(String id)
	{
		return admindao.delete(id);
	}
	
	
	
	/*private Admin adminFormBean2Login(AdminFormBean adminFormBean) {
		Admin admin = new Admin();
		admin.setName(adminFormBean.getName());
		String password = Md5Util.md5(adminFormBean.getPassword());//密码加密
		admin.setPassword(password);
		return admin;
	}*/
	private Admin adminFormBean2admin(AdminFormBean adminFormBean) {
		Admin admin = new Admin();
		admin.setId(UUIDUtils.generateID());
		admin.setName(adminFormBean.getName());
		String password = Md5Util.md5(adminFormBean.getPassword());//密码加密
		admin.setPassword(password);
		admin.setType(adminFormBean.getType());
		admin.setDescription(adminFormBean.getDescription());
		admin.setCreatetime(new Date());
		admin.setUpdatetime(new Date());
		return admin;
	}

	
}
