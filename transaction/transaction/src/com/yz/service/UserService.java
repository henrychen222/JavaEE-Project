package com.yz.service;
import java.util.List;

import com.yz.dao.UserDao;
import com.yz.domain.Collect;
import com.yz.domain.User;

public class UserService {

	UserDao dao=null;
	//用户注册
	public int addUser(User user) {

		dao=new UserDao();
		
		return dao.addUser(user);
	}
 
	//登陆判断
	public User login(String username,String password)
	{
		dao=new UserDao();
		return dao.find(username, password);
		
	}
	
	//查找是否用户名已被使用
	public User findRepeatUser(String username)
	{
		dao=new UserDao();
		return dao.findRepeatUser(username);
	}
	
	//查找该用户是否存在
	public int findPassword(String id,String password)
	{
		dao=new UserDao();
		return dao.findPassword(id,password);
		
	}

	//修改密码
	public int updatePassword(String id, String password1) {

		dao=new UserDao();
		return dao.updatePassword(id,password1);
	}

	//根据id获取对象
	public User findUser(String id) {

		dao=new UserDao();
		return dao.findUser(id);
	}

	//修改个人资料
	public void updateUserSelfInfo(User user) {

		dao=new UserDao();
		dao.updateUserSelfInfo(user);
	}

	public User findByUsername(String username) {
		dao=new UserDao();
		return dao.findByUsername(username);
	}

	public User findEmail(String username, String email,String realname) {

		dao=new UserDao();
		return dao.findEmail(username,email,realname);
	}

	public List<Collect> getCollectList(String userId) {

		dao=new UserDao();
		return dao.getCollectList(userId);
	}

	public void updateCenterInfo(User user) {

		dao=new UserDao();
		dao.updateCenterInfo(user);
		
	}

	




}
