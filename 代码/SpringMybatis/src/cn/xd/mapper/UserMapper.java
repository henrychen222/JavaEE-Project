package cn.xd.mapper;

import java.util.List;

import cn.xd.po.User;

public interface UserMapper {
	
	//根据id查找用户
	public User findUserById(String id)throws Exception;
	
	//根据用户名查询所有匹配的用户
	public List<User> findUserByName(String name)throws Exception;
	
	//添加用户信息
	public void insertUser(User user)throws Exception;
	
	//删除用户信息
	public void deleteUser(String id)throws Exception;
}
