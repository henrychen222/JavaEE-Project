package com.zbiti.iepe.framework.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zbiti.core.controller.BaseController;
import com.zbiti.core.dto.Page;
import com.zbiti.core.model.TreeNode;
import com.zbiti.core.util.StringUtil;
import com.zbiti.iepe.framework.model.BaseOrganization;
import com.zbiti.iepe.framework.model.BaseUser;
import com.zbiti.iepe.framework.smo.OrgSmo;
import com.zbiti.iepe.framework.smo.UserSmo;

/**
 * 机构控制层
 * 
 * @author zhaoqi
 * 
 */
@Controller
@RequestMapping("/org")
@SuppressWarnings("all")
public class OrgController extends BaseController {
	/**
	 * 机构服务层
	 */
	@Resource
	private OrgSmo orgSmoImpl;

	/**
	 * 用户服务层
	 */
	@Resource
	private UserSmo userSmoImpl;

	/**
	 * 机构主页
	 * 
	 * @param model
	 *            model对象
	 * @return 路径
	 */
	@RequestMapping("/showOrg")
	public String showOrg(ModelMap model) {
		List<HashMap<String, String>> orgType = orgSmoImpl.getOrgType();
		model.put("orgType", orgType);
		return "framework/org_index";
	}

	/**
	 * 加载机构树
	 * 
	 * @param orgId
	 *            父节点值
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/loadOrg")
	public void loadOrg(@RequestParam("orgId") String orgId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// 获取当前用户所在的分公司
		BaseUser user = (BaseUser) request.getSession().getAttribute("user");
		String areaId = user.getOrg().getAreaId().toString();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("areaId", areaId);
		paramMap.put("orgLevelCd", "3");
		paramMap.put("parentId", "17");
		paramMap.put("manageFlag", "1");// 后台管理调用
		// 获取子机构的值
		List<BaseOrganization> result = null;
		if ("17".equals(orgId))// 如果是组织机构则分权分域展示
		{
			result = orgSmoImpl.getAuthorOrg(paramMap);
		} else {
			result = orgSmoImpl.getOrgByParentId(orgId);
		}
		// List<BaseOrganization> result = orgSmoImpl.getOrgByParentId(orgId);
		if (result != null && result.size() != 0) {
			LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
			for (BaseOrganization bo : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bo.getOrgId());
				tn.setParentId(bo.getParentId());
				tn.setText(bo.getOrgName());
				List<BaseOrganization> son = orgSmoImpl.getOrgByParentId(bo
						.getOrgId());
				if (son != null && son.size() > 0) {
					tn.setState("closed");
				}
				tns.add(tn);
			}
			response.setCharacterEncoding("UTF-8");

			LinkedList<TreeNode> newOrgTree = new TreeNode(tns).getChildren();
			try {
				response.getWriter().write(
						JSONArray.fromObject(newOrgTree).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 加载机构树
	 * 
	 * @param orgId
	 *            父节点值
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/loadCurOrg")
	public void loadCurOrg(@RequestParam("orgId") String orgId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<BaseOrganization> result = null;
		if ("".equals(orgId) || orgId == null)
		// if (orgId == "" || orgId == null)
		{
			// 获取子机构的值
			result = orgSmoImpl.getOrgByParentId(orgId);
		} else {
			// 获取当前机构
			result = new ArrayList<BaseOrganization>();
			result.add(orgSmoImpl.getOrgById(orgId));
		}
		if (result != null && result.size() != 0) {
			LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
			for (BaseOrganization bo : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bo.getOrgId());
				tn.setParentId(bo.getParentId());
				tn.setText(bo.getOrgName());
				List<BaseOrganization> son = orgSmoImpl.getOrgByParentId(bo
						.getOrgId());
				if (son != null && son.size() > 0) {
					tn.setState("closed");
				}
				tns.add(tn);
			}
			response.setCharacterEncoding("UTF-8");

			LinkedList<TreeNode> newOrgTree = new TreeNode(tns).getChildren();
			try {
				response.getWriter().write(
						JSONArray.fromObject(newOrgTree).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据ID 查机构
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/selectOrgById")
	public void selectOrgById(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String orgId = request.getParameter("orgId");
		BaseOrganization bo = null;
		if (orgId != null && !"".equals(orgId)) {
			bo = orgSmoImpl.getOrgById(orgId);
			if (bo.getParentId() != null && !"".equals(bo.getParentId())) {
				BaseOrganization pbo = orgSmoImpl.getOrgById(bo.getParentId());
				bo.setParentOrg(pbo);
			}
		}
		List list = new ArrayList<BaseOrganization>();
		list.add(bo);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(JSONArray.fromObject(list).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ID 查下属机构
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/selectOrgByParentId")
	public void selectOrgByParentId(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String curPage = request.getParameter("page");
		String showCount = request.getParameter("rows");
		String orgId = request.getParameter("orgId");
		// 第一次加载加载用户所在根组织数据
		if ("".equals(orgId) || orgId == null) {
			BaseUser user = (BaseUser) request.getSession()
					.getAttribute("user");
			orgId = user.getOrg().getAreaId().toString();
		}
		Page page = new Page();
		page.setCurrentPage(Integer.parseInt(curPage));
		page.setShowCount(Integer.parseInt(showCount));
		List<BaseOrganization> bos = orgSmoImpl.getOrgByParentId(orgId, page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
		jsonMap.put("total", page.getTotalResult());// total键 存放总记录数，必须的
		jsonMap.put("rows", bos);// rows键 存放每页记录 list
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(
					JSONObject.fromObject(jsonMap).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ID 查下属机构
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 */
	@RequestMapping("/loadOrgByParentId")
	public void loadOrgByParentId(HttpServletRequest request,
			HttpServletResponse response) {
		page = new Page(request);// 初始化分页对象
		String orgIds = request.getParameter("orgIds");
		String initable = request.getParameter("initable");
		String orgName = request.getParameter("orgName");
		String orgId = request.getParameter("orgId");

		Map<String, Object> map = new HashMap<String, Object>();
		if ("Y".equals(initable))// 初始化
		{
			// 转换成List
			if (StringUtil.validate(orgIds)) {
				map.put("orgIds", Arrays.asList(orgIds.split(",")));
			} else {
				map.put("orgId", orgId);
			}
		} else {
			map.put("orgId", orgId);
		}
		map.put("orgName", orgName);
		List<BaseOrganization> bos = orgSmoImpl.getOrgByParentId(map, page);
		obj2Page(response, page, bos);// 分页输出
	}

	/**
	 * 保存机构
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param bo
	 *            机构对象
	 */
	@RequestMapping("/saveOrg")
	public void saveOrg(HttpServletRequest request,
			HttpServletResponse response, BaseOrganization bo) {
		String showId = request.getParameter("showId");
		String msg = "";
		try {
			orgSmoImpl.saveOrg(bo);
			msg = "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "保存失败：" + e.getMessage();
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑机构
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 * @return 路径
	 */
	@RequestMapping("/editOrg")
	public String editOrg(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		//获取参数
		String orgId = request.getParameter("orgId");
		String parentOrgId = request.getParameter("parentOrgId");
		String opr = request.getParameter("opr");
		//获取组织机构类型
		List<HashMap<String, String>> orgType = orgSmoImpl.getOrgType();
		model.put("orgType", orgType);
		
		BaseOrganization bo = new BaseOrganization();
		//根据参数获取当前组织机构和上级机构的数据
		if (orgId != null && !"".equals(orgId)) {
			bo = orgSmoImpl.getOrgById(orgId);
		}
		
		if (bo.getParentId() == null || "".equals(bo.getParentId())) {
			bo.setParentId(parentOrgId);
		}
		
		if (bo.getParentId() != null && !"".equals(bo.getParentId())) {
			BaseOrganization pbo = orgSmoImpl.getOrgById(bo.getParentId());
			bo.setParentOrg(pbo);
		}

		model.put("orgInfo", bo);
		if(opr !=null && "add".equals(opr)){
			return "framework/add_org";
		}else{
			return "framework/edit_org";
		}
			
		
	}

	/**
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param bo
	 *            机构对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/deleteOrg")
	public void deleteOrg(HttpServletRequest request,
			HttpServletResponse response, BaseOrganization bo, ModelMap model) {
		String orgId = request.getParameter("orgId");
		bo = orgSmoImpl.getOrgById(orgId);
		bo.setIsDelete("1");
		String msg = "";
		try {
			orgSmoImpl.saveOrg(bo);
			msg = "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "删除失败：" + e.getMessage();
		}
		model.put("msg", msg);
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param response
	 *            返回对象
	 * @param orgId
	 *            机构ID
	 */
	@RequestMapping("/getPatentsByOrgId")
	public void getPatentsByOrgId(HttpServletResponse response,
			@RequestParam("orgId") String orgId) {
		String parentOrgStr = "";
		List<BaseOrganization> parentOrgs = orgSmoImpl.getParentsByOrgId(orgId);

		if (parentOrgs != null) {
			for (BaseOrganization bo : parentOrgs) {
				parentOrgStr += bo.getOrgId() + ",";
			}
		}
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(parentOrgStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param orgId
	 *            机构ID
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/queryOrgByorgId")
	public void queryOrgByorgId(@RequestParam("orgId") String orgId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// 获取子机构的值
		List<BaseOrganization> result = orgSmoImpl.getOrgByParentId(orgId);

		response.setCharacterEncoding("UTF-8");

		try {
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("data", result);
			response.getWriter().write(
					JSONObject.fromObject(jsonMap).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载用户机构树
	 * 
	 * @param orgId
	 *            父节点值
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/loadUserOrg")
	public void loadUserOrg(@RequestParam("orgId") String orgId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// 获取子机构的值
		List<BaseOrganization> result = orgSmoImpl.getOrgByParentIdU(orgId);

		if (result != null && result.size() != 0) {
			LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
			for (BaseOrganization bo : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bo.getOrgId());
				tn.setParentId(bo.getParentId());
				tn.setText(bo.getOrgName());
				List<BaseOrganization> son = orgSmoImpl.getOrgByParentIdU(bo
						.getOrgId());
				if (son != null && son.size() > 0) {
					tn.setState("closed");
				}
				tns.add(tn);
			}
			response.setCharacterEncoding("UTF-8");

			LinkedList<TreeNode> newOrgTree = new TreeNode(tns).getChildren();
			try {
				response.getWriter().write(
						JSONArray.fromObject(newOrgTree).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 加载用户机构树
	 * 
	 * @param orgId
	 *            父节点值
	 * @param userName
	 *            用户名
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/loadUserOrgDim")
	public void loadUserOrgDim(@RequestParam("orgId") String orgId,
			@RequestParam("userName") String userName,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws UnsupportedEncodingException {
		userName = new String(userName.getBytes("ISO8859-1"), "gb2312");
		// 获取子机构的值
		List<BaseOrganization> result = orgSmoImpl.getOrgByParentIdDim(orgId,
				userName);

		if (result != null && result.size() != 0) {
			LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
			for (BaseOrganization bo : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bo.getOrgId());
				tn.setParentId(bo.getParentId());
				tn.setText(bo.getOrgName());
				List<BaseOrganization> son = orgSmoImpl.getOrgByParentIdDim(
						bo.getOrgId(), userName);
				if (son != null && son.size() > 0) {
					tn.setState("closed");
				}
				tns.add(tn);
			}
			response.setCharacterEncoding("UTF-8");

			LinkedList<TreeNode> newOrgTree = new TreeNode(tns).getChildren();
			try {
				response.getWriter().write(
						JSONArray.fromObject(newOrgTree).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 加载岗位机构树
	 * 
	 * @param orgId
	 *            父节点值
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/loadPositionOrg")
	public void loadPositionOrg(@RequestParam("orgId") String orgId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// 获取子机构的值
		List<BaseOrganization> result = orgSmoImpl.getOrgByParentIdP(orgId);

		if (result != null && result.size() != 0) {
			LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
			for (BaseOrganization bo : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bo.getOrgId());
				tn.setParentId(bo.getParentId());
				tn.setText(bo.getOrgName());
				List<BaseOrganization> son = orgSmoImpl.getOrgByParentIdP(bo
						.getOrgId());
				if (son != null && son.size() > 0) {
					tn.setState("closed");
				}
				tns.add(tn);
			}
			response.setCharacterEncoding("UTF-8");

			LinkedList<TreeNode> newOrgTree = new TreeNode(tns).getChildren();
			try {
				response.getWriter().write(
						JSONArray.fromObject(newOrgTree).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 加载用岗位构树
	 * 
	 * @param orgId
	 *            父节点值
	 * @param positionName
	 *            岗位名称
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/loadPositionOrgDim")
	public void loadPositionOrgDim(@RequestParam("orgId") String orgId,
			@RequestParam("positionName") String positionName,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws UnsupportedEncodingException {
		positionName = new String(positionName.getBytes("ISO8859-1"), "gb2312");
		// 获取子机构的值
		List<BaseOrganization> result = orgSmoImpl.getOrgByParentIdPDim(orgId,
				positionName);

		if (result != null && result.size() != 0) {
			LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
			for (BaseOrganization bo : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bo.getOrgId());
				tn.setParentId(bo.getParentId());
				tn.setText(bo.getOrgName());
				List<BaseOrganization> son = orgSmoImpl.getOrgByParentIdPDim(
						bo.getOrgId(), positionName);
				if (son != null && son.size() > 0) {
					tn.setState("closed");
				}
				tns.add(tn);
			}
			response.setCharacterEncoding("UTF-8");

			LinkedList<TreeNode> newOrgTree = new TreeNode(tns).getChildren();
			try {
				response.getWriter().write(
						JSONArray.fromObject(newOrgTree).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 用户机构
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/loadOrgUser")
	public void loadOrgUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String orgId = request.getParameter("orgId");
		// 最后要返回的json串
		StringBuffer ztreeNodes = new StringBuffer();
		ztreeNodes.append("[");

		// 获取子机构的值
		List<BaseOrganization> result = orgSmoImpl.getOrgByParentId(orgId);
		if (result != null && result.size() != 0) {
			String boJson = "";// 机构的json
			String boUJoson = "";// 机构对应的人员的json
			for (BaseOrganization bo : result) {
				boJson = "{\"id\":\""
						+ bo.getOrgId()
						+ "\",\"text\":\""
						+ bo.getOrgName()
						+ "\",\"iconCls\":\"icon-org\",\"state\":\"closed\",\"open\":false,\"parentId\":"
						+ bo.getParentId() + "},";
				ztreeNodes.append(boJson);
			}

			// 添加机构下面的人员
			List<BaseUser> baseUsers = userSmoImpl.selectUserByOrg(orgId);
			if (baseUsers != null && baseUsers.size() != 0) {
				for (BaseUser user : baseUsers) {
					boUJoson = "{\"id\":\""
							+ user.getAccountName()
							+ "\",\"text\":\""
							+ user.getUserName()
							+ "\",\"iconCls\":\"icon-person\",\"state\":\"open\",\"open\":false},";
					ztreeNodes.append(boUJoson);
				}
			}

			// //添加岗位
			// if (null != orgId && !orgId.equals("null"))
			// {
			// String positionJson = "";// 岗位的json
			//
			// List<BasePosition> positions =
			// positionSmoImpl.selectPositionByOrg(orgId);
			// if (positions != null && positions.size() != 0)
			// {
			// for (BasePosition pos : positions)
			// {
			// positionJson = "{\"id\":\"" + pos.getPositionId() +
			// "\",\"text\":\""
			// + pos.getPositionName()
			// +
			// "\",\"iconCls\":\"icon-position\",\"state\":\"closed\",\"open\":false},";
			// ztreeNodes.append(positionJson);
			//
			// }
			// }
			// }

		}

		response.setCharacterEncoding("UTF-8");
		String ztreeNodes1 = ztreeNodes.substring(0, ztreeNodes.length() - 1);
		ztreeNodes1 = ztreeNodes1 + "]";

		System.out.println(ztreeNodes1);
		try {
			response.getWriter().write(ztreeNodes1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据用户名加载用户机构
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/loadOrgUserDim")
	public void loadOrgUserDim(HttpServletRequest request,
			HttpServletResponse response, ModelMap model)
			throws UnsupportedEncodingException {
		String orgId = request.getParameter("orgId");
		String userName = request.getParameter("userName");
		userName = new String(userName.getBytes("ISO8859-1"), "gb2312");
		// 最后要返回的json串
		StringBuffer ztreeNodes = new StringBuffer();
		ztreeNodes.append("[");

		// 获取子机构的值
		List<BaseOrganization> result = orgSmoImpl.getOrgByParentId(orgId);
		if (result != null && result.size() != 0) {
			String boJson = "";// 机构的json
			String boUJoson = "";// 机构对应的人员的json
			for (BaseOrganization bo : result) {
				boJson = "{\"id\":\""
						+ bo.getOrgId()
						+ "\",\"text\":\""
						+ bo.getOrgName()
						+ "\",\"iconCls\":\"icon-org\",\"state\":\"closed\",\"open\":false,\"parentId\":"
						+ bo.getParentId() + "},";
				ztreeNodes.append(boJson);
			}

			// 添加机构下面的人员
			List<BaseUser> baseUsers = userSmoImpl.selectUserByOrgDim(orgId,
					userName);
			if (baseUsers != null && baseUsers.size() != 0) {
				for (BaseUser user : baseUsers) {
					boUJoson = "{\"id\":\""
							+ user.getAccountName()
							+ "\",\"text\":\""
							+ user.getUserName()
							+ "\",\"iconCls\":\"icon-person\",\"state\":\"open\",\"open\":false},";
					ztreeNodes.append(boUJoson);
				}
			}

		}

		response.setCharacterEncoding("UTF-8");
		String ztreeNodes1 = ztreeNodes.substring(0, ztreeNodes.length() - 1);
		ztreeNodes1 = ztreeNodes1 + "]";

		System.out.println(ztreeNodes1);
		try {
			response.getWriter().write(ztreeNodes1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
