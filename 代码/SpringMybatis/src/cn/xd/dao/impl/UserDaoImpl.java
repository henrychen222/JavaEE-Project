package cn.xd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.xd.po.User;


public class UserDaoImpl extends SqlSessionDaoSupport{

	/**
	 * @author y.you
	 * 
	 * */
	public User findUserById(String id) throws Exception {
		//继承SqlSessionDaoSupport，通过this.getSqlSession()获得sqlSession
		SqlSession sqlSession = this.getSqlSession();
		
		User user = sqlSession.selectOne("user.findUserById",id);
		
		return user;
	}
	/**
	 * @author y.you
	 * 
	 * */
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		
		List<User> list = sqlSession.selectList("user.findUserByName",name);
		
		return list;
	}
	/**
	 * @author y.you
	 * 
	 * */
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		
		//list中的user和映射文件中reaultType所指定的类型一致
		sqlSession.insert("test.insertUser",user);
		//提交事务
		sqlSession.commit();
	}
	/**
	 * @author y.you
	 * 
	 * */
	public void deleteUser(String id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		
		//执行删除操作
		sqlSession.delete("user.deleteUser",id);
		//提交事务
		sqlSession.commit();
	}

}
