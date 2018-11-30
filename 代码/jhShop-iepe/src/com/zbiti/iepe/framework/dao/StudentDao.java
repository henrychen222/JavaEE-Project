package com.zbiti.iepe.framework.dao;

import java.util.List;

import com.zbiti.iepe.framework.model.QueryInfo;
import com.zbiti.iepe.framework.model.Student;
import com.zbiti.iepe.framework.model.StudentQueryInfoCustom;

public interface StudentDao {
	
	public List<Student> getAllStudent(QueryInfo info)throws Exception;
	
	public int getStudentCount()throws Exception;

	/**
	 * @param info
	 * @return
	 */
	public List<Student> findStudentByQuery(StudentQueryInfoCustom info);

	/**
	 * @param info
	 * @return
	 */
	public int getStudentByQueryCount(StudentQueryInfoCustom info);
	
	/**
	 * 
	 * @param stu
	 */
	public void save(Student stu);
}
