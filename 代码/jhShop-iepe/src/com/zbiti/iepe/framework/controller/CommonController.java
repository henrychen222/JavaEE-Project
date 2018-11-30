package com.zbiti.iepe.framework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbiti.core.controller.BaseController;
import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.dao.CommonDao;

/**
 * 目前用于查找带回功能的动态查询。
 * 
 * @author wangyan
 * 
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	// private Log log = Log.getLog(CommonControl.class);
	@Resource
	private CommonDao dao;

	@ResponseBody
	@RequestMapping("queryBySql")
	public List<Map<String, Object>> queryBySql(HttpServletRequest request) {
		String sql = request.getParameter("sql");
		return dao.queryBySql(sql);
	}

	@ResponseBody
	@RequestMapping("queryBySqllistPage")
	public Map<String, Object> queryBySqllistPage(HttpServletRequest request) {
		Page page = new Page();
		page.setCurrentPage(request.getParameter("page") == "" ? 1 : Integer
				.parseInt(request.getParameter("page")));
		page.setShowCount(request.getParameter("rows") == "" ? 10 : Integer
				.parseInt(request.getParameter("rows")));
		String sql = request.getParameter("sql");
		if (sql == null || sql.length() == 0) {
			return new HashMap<String, Object>();
		}
		List<Map<String, Object>> data = dao.queryBySqllistPage(sql, page);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", page.getTotalResult());
		resultMap.put("rows", data);
		return resultMap;
	}
}
