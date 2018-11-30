package com.jd.web.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jd.util.AjaxRult;
import com.jd.util.MapUtil;
import com.jd.util.PagedResult;
import com.jd.web.test.model.Assignment;
import com.jd.web.test.model.User;
import com.jd.web.test.service.AssignmentService;
import com.jd.web.test.service.IUserService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
	private static Logger logger = Logger.getLogger(UserController.class);  
	@Resource
	private AssignmentService assignmentService;
	
	
	
	
	// 作业推送
			@RequestMapping("/demo_Assignment")
			public String demoAssignment(HttpServletRequest request, Model model) throws Exception {
				return "demo/demo_Assignment";
			}
	
	
		

	
	
	/**
	 * 添加新作业
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	
	@RequestMapping("/addAssignment")
	public String addUser(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
			Assignment ass = new Assignment();
			ass.setTitle(title);
			ass.setContent(content);
									
			assignmentService.addAssignment(ass);
			return "demo/demo_Assignment";	
	}
	
	
	/**
	 * 根据id查询作业信息
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/update_Assignment")
	public String updateUser(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Assignment ass = assignmentService.getAssignmentById(id);
		System.err.println(ass.getTitle());  //根据作业标题打印错误
		model.addAttribute("assignment", ass);      //往前台视图传参数，类似于request.setAttribute()
		return "demo/update_Assignment";
	}
	
	
	
	/**
	 * 修改作业
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	
	@RequestMapping("/update")
	public String updateUserA(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		String title = request.getParameter("user_name");
		String content = request.getParameter("password");
		String people = request.getParameter("age");

		Assignment ass = new Assignment();
		ass.setId(id);
		ass.setTitle(title);
		ass.setContent(content);
		ass.setPeople(people);

		assignmentService.updateAssignment(ass);

		model.addAttribute("assignment", ass);
		return "demo/demo_Assignment";
	}
	
	
	
	/**
	 * 删除作业
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/del")
	public String delUser(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id = Integer.valueOf(request.getParameter("id"));
		assignmentService.delUserById(id);

		return "demo/demo_Assignment";
	
	}
}