package com.yz.service.impl;

import com.yz.dao.UserDao;
import com.yz.dao.impl.UserDaoImpl;
import com.yz.domain.User;
import com.yz.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao dao=null;
	public int addUser(User user){
		dao=new UserDaoImpl();
		return dao.addUser(user);
	}

}
