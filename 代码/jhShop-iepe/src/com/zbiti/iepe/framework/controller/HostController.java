package com.zbiti.iepe.framework.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbiti.iepe.framework.model.BaseCompany;
import com.zbiti.iepe.framework.model.BaseHost;
import com.zbiti.iepe.framework.smo.HostSmo;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/prototype")
public class HostController {
	
	@Resource
	HostSmo hostSmo;
	
	@RequestMapping("/find")
	public ModelAndView find(HttpServletRequest request ){
		List<BaseHost> blist=hostSmo.findOne2Many();
		request.setAttribute("blist", blist);
		
		return new ModelAndView("find.jsp");
	}

	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,BaseCompany bc ){
		hostSmo.save(bc);
		return new ModelAndView("add.jsp");
	}

}
