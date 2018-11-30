package com.zbiti.iepe.framework.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.iepe.framework.smo.MetaSmo;

/**
 * This controller is made for iepe-controls.js, used for query meta data json.
 * 
 * @author wangyan
 * 
 */
@Controller
@RequestMapping("/meta")
public class MetaController {
	// private Log log = Log.getLog(MetaController.class);
	@Resource
	private MetaSmo serv;

	@RequestMapping("getMetaData")
	public void getMetaData(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Map<String, Object>> result = serv.getMetaData();
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(JSONArray.fromObject(result).toString());
	}

}
