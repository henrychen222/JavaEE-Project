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
import com.jd.web.test.model.User;
import com.jd.web.test.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);  
	@Resource
	private IUserService userService;
	
	/*
	 * 添加用户
	 * 
	 */
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String password = request.getParameter("password");
		User user = new User();
		//传值到后台
		user.setAge(age);
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		userService.save(user);     //调用Service中的方法
		return "demo/demo_PageHelper";
	}
	
	/*
	 * 根据id删除用户信息
	 * 
	 */
	@RequestMapping("/deleteUser")
	public AjaxRult delUser(HttpServletRequest request, Model model) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		user.setId(id);
		userService.delete(user);     
		return AjaxRult.create(0, true, "测试", null);
	}
	
	/*
	 * 根据id查询用户信息
	 * 
	 */
	@RequestMapping("/findById")
	public String findById(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		user = this.userService.findById(id);
		request.setAttribute("user", user);   
		return "demo/update";
	}
	
	/*
	 * 更新用户信息
	 * 
	 */
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request, Model model) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setAge(age);
		System.out.println(user.getPassword());
		this.userService.update(user);
		return "demo/demo_PageHelper";
	}
	
	
	

	// 访问页面测试
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) throws Exception {
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "demo/showUser";
	}

	// 装饰器测试
	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) throws Exception {
		return "demo/test";
	}

	// 装饰器测试
	@RequestMapping("/demo_PageHelper")
	public String demoPageHelper(HttpServletRequest request, Model model) throws Exception {
		return "demo/demo_PageHelper";
	}

	// 返回json数据中文是否乱码测试
	@RequestMapping("/getUsers")
	public void getUsers(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		System.out.println(request.getCharacterEncoding());
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);

		User user = this.userService.getUserById(userId);
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(JSONArray.fromObject(userList).toString());
	}

	// 使用注解返回ajax的json数据测试
	@ResponseBody
	@RequestMapping("/getUserInfo")
	public AjaxRult getUserInfo(HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		User user = this.userService.getUserById(userId);
		return AjaxRult.create(0, true, "测试", user);
	}

	/**
	 * 分页测试
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/queryAll")
	public PagedResult<User> queryAll(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String index = request.getParameter("page");
		String size = request.getParameter("rows");
		Map map = MapUtil.getParameterValue(request);
		int pageIndex = 1, pageSize = 10;
		if (index != null && !"".equals(index)) {
			pageIndex = Integer.parseInt(index);
		}
		if (size != null && !"".equals(size)) {
			pageSize = Integer.parseInt(size);
		}
		response.setCharacterEncoding("UTF-8");
		PagedResult<User> pagedResult = this.userService.getUserList(map, pageIndex, pageSize);
		//response.getWriter().write(JSONObject.fromObject(pagedResult).toString());
		pagedResult.getRows();
		return pagedResult;
	}

}