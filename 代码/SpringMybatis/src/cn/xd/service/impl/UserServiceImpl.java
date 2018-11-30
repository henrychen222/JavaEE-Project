package cn.xd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xd.mapper.UserMapper;
import cn.xd.po.User;
import cn.xd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public void insertUser(User user)throws Exception{
		userMapper.insertUser(user);
	}
	
	@Override
	public User findUserById(String id)throws Exception{
		return userMapper.findUserById(id);
	}
	
}
