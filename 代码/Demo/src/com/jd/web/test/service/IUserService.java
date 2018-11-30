package com.jd.web.test.service;

import java.util.List;
import java.util.Map;

import com.jd.util.PagedResult;
import com.jd.web.test.model.User;


public interface IUserService {
	public User getUserById(int userId);

	public int addUser(User user);
	
	public int save(User user);
	
	public void delete(User user);
			
	User findById(int id);
	
	public void update(User user);
	
	public int insertUser(User user);

	List<User> queryAll();

	PagedResult<User> getUserList(Map map, int pageIndex, int pageSize);

	
}
