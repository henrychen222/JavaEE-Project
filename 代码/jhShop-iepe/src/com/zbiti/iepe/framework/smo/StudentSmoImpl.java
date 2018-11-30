package com.zbiti.iepe.framework.smo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zbiti.iepe.framework.dao.StudentDao;
import com.zbiti.iepe.framework.model.PageBean;
import com.zbiti.iepe.framework.model.QueryInfo;
import com.zbiti.iepe.framework.model.Student;
import com.zbiti.iepe.framework.model.StudentQueryInfoCustom;

/**
 * 学生学籍管理服务层
 * */

@Service(value = "studentSmoImpl")
public class StudentSmoImpl implements StudentSmo{

	/**
	 * 学生持久层对象
	 */
	@Resource
	private StudentDao studentDao;
	
	/**
	 * 查询所有学生信息
	 * */
	public PageBean getAllStudent(QueryInfo info)throws Exception{
		List<Student> list = studentDao.getAllStudent(info);
		int totalrecord = studentDao.getStudentCount();
		PageBean bean = new PageBean();
		bean.setCurrentpage(info.getCurrentpage());
		bean.setList(list);
		bean.setPagesize(info.getPagesize());
		bean.setTotalrecord(totalrecord);
	return bean;
		
	}
	/**
	 *<p></p>
	 * @author:y.you
	 * 2016年3月31日
	 * @version：v1.0
	 */
	public PageBean findStudentByQuery(StudentQueryInfoCustom info){
		List<Student> list = studentDao.findStudentByQuery(info);
		int totalrecord = studentDao.getStudentByQueryCount(info);
		PageBean bean = new PageBean();
		bean.setCurrentpage(info.getCurrentpage());
		bean.setList(list);
		bean.setPagesize(info.getPagesize());
		bean.setTotalrecord(totalrecord);
	return bean;
		
	}
	@Override
	public void save(Student stu) {
		// TODO Auto-generated method stub
		studentDao.save(stu);
		
	}
}
