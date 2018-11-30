package com.jd.web.test.dao;

import java.util.List;
import java.util.Map;

import com.jd.web.test.model.Assignment;
import com.jd.web.test.model.User;

public interface AssignmentDao {
	
	int deleteByPrimaryKey(Integer id);

	int insert(Assignment record);

	int insertSelective(Assignment record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Assignment record);

	int updateByPrimaryKey(Assignment record);
	
	List<Assignment> queryAll(Map map);
	
	

	void addAssignment(Assignment ass);
	
	void delAssignmentById(Integer id);
	
	Assignment getAssignmentById(Integer id);
	
	void updateAssignment(Assignment ass);
}
