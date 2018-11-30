package com.jd.web.test.service;

import com.jd.web.test.model.Assignment;
import com.jd.web.test.model.User;

public interface AssignmentService {
	
	public void addAssignment(Assignment ass);
		
	public void delUserById(Integer id);
	
	public Assignment getAssignmentById(Integer id);
	
	public Assignment updateAssignment(Assignment ass);
		
	

}
