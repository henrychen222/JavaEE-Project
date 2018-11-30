package com.zbiti.iepe.framework.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbiti.iepe.framework.model.PageBean;
import com.zbiti.iepe.framework.model.QueryInfo;
import com.zbiti.iepe.framework.model.Student;
import com.zbiti.iepe.framework.model.StudentQueryInfoCustom;
import com.zbiti.iepe.framework.smo.StudentSmo;
import com.zbiti.util.PageUtil;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	/**
	 * 学生服务层
	 * */
	@Resource
	StudentSmo studentSmoImpl;
	
	
	/**
	 * 查询所有学生学籍信息
	 * */
	@RequestMapping("/registration")
	public String showAllStudent(Model model,HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		
		QueryInfo info = PageUtil.QueryInfo(request);
		PageBean bean = (PageBean) studentSmoImpl.getAllStudent(info);
		model.addAttribute("pagebean",bean);
		model.addAttribute("url","registration");
		return "showSudents";
	}
	
	@RequestMapping("/findStudentByQuery")
	public String findStudentByQuery(Model model,HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		String studentId = request.getParameter("studentId");
			studentId=new String(studentId.getBytes("iso-8859-1"),"utf-8");//解决乱码问题	
		String studentName = request.getParameter("studentName");
			studentName=new String(studentName.getBytes("iso-8859-1"),"utf-8");
			System.err.println("66666666666666");
			StudentQueryInfoCustom info = (StudentQueryInfoCustom) PageUtil.QueryInfo(request);
				info.setStudentId(studentId);
				info.setStudentName(studentName);
			System.err.println(info.getStartindex()+"66666"+info.getPagesize());
			PageBean bean = studentSmoImpl.findStudentByQuery(info);
			
			model.addAttribute("pagebean",bean);
			model.addAttribute("url","findStudentByQuery");
			return "showSudents";
	}
	
	@RequestMapping("/addStudentUI")
	public ModelAndView saveStudentUI(HttpServletRequest request){
		//studentSmoImpl.save(stu);
		return new ModelAndView("add");
	}
	
	@RequestMapping("/addStudent")
	public String saveStudent(Model model, HttpServletRequest request) throws Exception{
		String number = request.getParameter("student_number");
		String student_name = request.getParameter("student_name");
		String class_name = request.getParameter("class_name");
		String gender = request.getParameter("gender");
		Student s= new Student();
			s.setStudent_number(number);
			s.setStudent_name(student_name);
			s.setClass_name(class_name);
			s.setGender(gender);
		studentSmoImpl.save(s);
		QueryInfo info = PageUtil.QueryInfo(request);
		PageBean bean = (PageBean) studentSmoImpl.getAllStudent(info);
		model.addAttribute("pagebean",bean);
		model.addAttribute("url","registration");
		return "showSudents";
	}
}
