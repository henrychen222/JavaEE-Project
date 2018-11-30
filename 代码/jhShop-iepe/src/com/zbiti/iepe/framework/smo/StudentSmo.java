package com.zbiti.iepe.framework.smo;

import com.zbiti.iepe.framework.model.PageBean;
import com.zbiti.iepe.framework.model.QueryInfo;
import com.zbiti.iepe.framework.model.Student;
import com.zbiti.iepe.framework.model.StudentQueryInfoCustom;

public interface StudentSmo {

	/**
	 * 查询所有学生
	 * @param info 
	 * @return 学生list集合
	 */
	public PageBean getAllStudent(QueryInfo info)throws Exception;

	/**
	 * @param info
	 * @return
	 */
	public PageBean findStudentByQuery(StudentQueryInfoCustom info);
	
	/**
	 * 
	 * @param stu
	 */
	public void save(Student stu);
	
	
}
