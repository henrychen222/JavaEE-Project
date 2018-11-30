package cn.xd.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.xd.po.User;
import cn.xd.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/register",method={RequestMethod.POST})
	public ModelAndView userRegister(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String pwd2 = request.getParameter("password2");
		System.err.println(name);
		ModelAndView modelAndView = new ModelAndView();
		if(name==null||name.trim()==""){
			String message="用户名不能为空！！！"; 
			//相当于request的setAttribute
				modelAndView.addObject("message",message);
			//指定视图
				modelAndView.setViewName("index");
		}else if(pwd.trim()==""||pwd2.trim()==""){
			String message="密码不能为空！！！"; 
				modelAndView.addObject("message",message);
				modelAndView.setViewName("index");
		}else if(!pwd.equals(pwd2)){
			String message="两次密码不一致！！！"; 
				modelAndView.addObject("message",message);
				modelAndView.setViewName("index");
		}else{
			User user = new User();
				user.setId(UUID.randomUUID().toString());
				user.setName(name);
				user.setPassword(pwd2);
				System.err.println(user.getPassword()+"++++"+user.getId());
			userService.insertUser(user);
			
				String message="注册成功！！！"; 
					modelAndView.addObject("message",message);
					modelAndView.setViewName("login");
		}
		return modelAndView;
	}
}
