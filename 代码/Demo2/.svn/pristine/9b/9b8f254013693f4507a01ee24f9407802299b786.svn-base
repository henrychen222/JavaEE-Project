package com.jd.web.test.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.jd.util.BeanUtil;
import com.jd.util.PagedResult;
import com.jd.web.test.dao.IUserDao;
import com.jd.web.test.model.User;
import com.jd.web.test.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	/**
	 * 测试事务管理是否配置正确
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int addUser(User user) {
		this.userDao.updateByPrimaryKey(user);
		user.setId(8);
		user.setUserName("朱玉付2");
		this.userDao.insertSelective(user);
		return 1;
	}

	@Override
	public int insertUser(User user) {
		return userDao.insert(user);
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll(null);
	}

	@Override
	public PagedResult<User> getUserList(Map map, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize); // startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return BeanUtil.toPagedResult(userDao.queryAll(map));
	}
	
	
	
	@Override
	public void addUserA(User user) {
		 userDao.addUserA(user);
	}

	public User getUserById(Integer id){
		 return userDao.getUserById(id);
	}
	
	
	public User updateUserA(User user){
		userDao.updateUserA(user);
		return userDao.getUserById(user.getId());
		
	}
	public void delUserById(Integer id){
		userDao.delUserById(id);
	}

}