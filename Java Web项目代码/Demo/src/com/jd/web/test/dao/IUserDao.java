package com.jd.web.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jd.web.test.model.User;


public interface IUserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);
	
	int save(User user);
	
	void delete(User user);
	
	User findById(int id);
	
	int update(User user);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	
	List<User> queryAll(Map map);
}