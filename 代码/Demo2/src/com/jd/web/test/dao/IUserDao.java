package com.jd.web.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jd.web.test.model.User;


public interface IUserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	List<User> queryAll(Map map);
	
	void addUserA(User user);

	User getUserById(Integer id);

	void updateUserA(User user);


	void delUserById(Integer id);
}