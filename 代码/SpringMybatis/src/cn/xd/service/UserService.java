package cn.xd.service;

import cn.xd.po.User;

public interface UserService {

	public void insertUser(User user) throws Exception;
	
	public User findUserById(String id)throws Exception;

}