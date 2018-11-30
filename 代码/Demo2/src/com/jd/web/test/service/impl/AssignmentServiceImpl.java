package com.jd.web.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jd.web.test.dao.AssignmentDao;
import com.jd.web.test.model.Assignment;
import com.jd.web.test.model.User;
import com.jd.web.test.service.AssignmentService;

@Service("assignment")
public class AssignmentServiceImpl implements AssignmentService{
	
	@Resource
	private AssignmentDao assignmentDao;
	
	@Override
	public void addAssignment(Assignment ass) {
		assignmentDao.addAssignment(ass);
	}
	
	public void delUserById(Integer id){
		assignmentDao.delAssignmentById(id);
	}
	
	public Assignment getAssignmentById(Integer id){
		 return assignmentDao.getAssignmentById(id);
	}
	
	public Assignment updateAssignment(Assignment ass){
		assignmentDao.updateAssignment(ass);
		return assignmentDao.getAssignmentById(ass.getId());
		
	}

}
