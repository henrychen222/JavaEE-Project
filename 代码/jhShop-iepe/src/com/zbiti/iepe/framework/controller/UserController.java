package com.zbiti.iepe.framework.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbiti.core.controller.BaseController;
import com.zbiti.core.dto.Page;
import com.zbiti.core.model.TreeNode;
import com.zbiti.iepe.framework.model.BaseOrganization;
import com.zbiti.iepe.framework.model.BaseUser;
import com.zbiti.iepe.framework.smo.OrgSmo;
import com.zbiti.iepe.framework.smo.UserSmo;

/**
 * 用户控制层
 * 
 * @author zhaoqi
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * 用户服务层对象
	 */
	@Resource
	private UserSmo userSmoImpl;

	/**
	 * 机构服务层对象
	 */
	@Resource
	private OrgSmo orgSmoImpl;

	/**
	 * 初始化页面
	 * 
	 * @return jsp路径
	 */
	@RequestMapping("/showUser")
	public String initPage() {
		return "framework/user_index";
	}

	/**
	 * 条件查询
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @throws IOException
	 *             异常 异常
	 */
	@RequestMapping("/selectUserByCond")
	public void selectUserByCond(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String curPage = request.getParameter("page");
		String showCount = request.getParameter("rows");
		String orgId = request.getParameter("orgId");
		// 第一次加载加载用户所在根组织数据
		if ("".equals(orgId) || orgId == null || "17".equals(orgId)) {
			BaseUser user = (BaseUser) request.getSession()
					.getAttribute("user");
			String areaId = user.getOrg().getAreaId().toString();
			orgId = userSmoImpl.getTopOrgIdByAreaId(areaId);
		}
		String accountName = request.getParameter("accountName");
		String userName = request.getParameter("userName");
		String userStateCd = request.getParameter("userStateCd");
		HashMap<String, Object> map = new HashMap<String, Object>();
		Page page = new Page();
		page.setCurrentPage(Integer.parseInt(curPage));
		page.setShowCount(Integer.parseInt(showCount));
		// wangyan modified @ 20150105 for get all children orgid in java
		List<String> orgIds = orgSmoImpl.getAllChildrenOrgId(orgId);
		map.put("orgIds", orgIds);
		// map.put("orgId", orgId);
		map.put("accountName", accountName);
		map.put("userName", userName);
		map.put("userStateCd", userStateCd);
		map.put("page", page);
		List<BaseUser> users = userSmoImpl.selectUserByCond(map, page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
		jsonMap.put("total", page.getTotalResult());// total键 存放总记录数，必须的
		jsonMap.put("rows", users);// rows键 存放每页记录 list
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(JSONObject.fromObject(jsonMap).toString());
	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param session
	 *            会话
	 */
	@RequestMapping("/deleteUser")
	public void deleteOrg(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		BaseUser bu = new BaseUser();
		String userId = request.getParameter("userId");
		bu = userSmoImpl.getUserById(userId);
		bu.setIsDelete("1");
		String msg = "";

		try {
			userSmoImpl.saveUser(bu);
			msg = "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "删除失败：" + e.getMessage();
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑用户跳转
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            返回对象
	 * @return jsp路径
	 */
	@RequestMapping("/editUser")
	public String editUser(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String userId = request.getParameter("userId");
		BaseUser bu = new BaseUser();
		if (userId != null && !"".equals(userId)) {
			bu = userSmoImpl.getUserById(userId);
		}

		// 如果用户为新增，则把组织ID为orgId的组织放进用户中
		String orgId = request.getParameter("orgId");
		if (orgId.length() == 0) {
			orgId = "17";
		}

		if (bu.getUserId() == null || "".equals(bu.getUserId())) {
			BaseOrganization org = new BaseOrganization();
			if (orgId != null && !"".equals(orgId)) {
				org = orgSmoImpl.getOrgById(orgId);
			}
			bu.setOrg(org);
		}

		// 找出用户组织的上级组织
		String parentOrgStr = "";
		if (bu.getOrg() != null && bu.getOrg().getOrgId() != null
				&& !"".equals(bu.getOrg().getOrgId())) {
			List<BaseOrganization> parentOrgs = orgSmoImpl.getParentsByOrgId(bu
					.getOrg().getOrgId());

			if (parentOrgs != null) {
				for (BaseOrganization bo : parentOrgs) {
					parentOrgStr += bo.getOrgId() + ",";
				}
			}
		}

		// 机构树
		List<BaseOrganization> result = orgSmoImpl.getAllOrgs();
		LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
		for (BaseOrganization bo : result) {
			TreeNode tn = new TreeNode();
			tn.setId(bo.getOrgId());
			tn.setText(bo.getOrgName());
			tn.setParentId(bo.getParentId());
			tns.add(tn);
		}
		TreeNode tnNew = new TreeNode(tns);
		response.setCharacterEncoding("UTF-8");
		model.put("selectTree", tnNew.getSelectTreeList(""));
		model.put("userInfo", bu);
		model.put("parentOrgs", parentOrgStr);
		return "framework/edit_user";
	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 *            请求
	 * @param session
	 *            session
	 * @param user
	 *            用户
	 * @param model
	 *            返回模型
	 * @return jsp路径
	 */
	@RequestMapping("/addUserInfo")
	public void addUser(HttpServletRequest request, HttpSession session,
			BaseUser user, ModelMap model, HttpServletResponse response) {
		String msg = "人员添加成功！";
		try {
			BaseUser u = userSmoImpl.checkUser(user.getAccountName());
			if (u == null) {
				// user.setAccountPasswordCd(Md5Util.GetMD5Code(user.getAccountPasswordCd()));
				userSmoImpl.addUserInfo(user);
			} else {
				// wangyan modified @ 20140929 for handle logic delete
				if (u.getIsDelete() != null && u.getIsDelete().equals("1")) {
					user.setUserId(u.getUserId());
					user.setIsDelete("0");
					userSmoImpl.editUserInfo(user);
				} else {
					System.out.println("人员添加失败，该用户账号已存在！");
					msg = "人员添加失败，该用户账号已存在！";
				}
			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain;charset=UTF-8");
			/*wangyan modified @ 151117 ZBITI_2015_RJ(2)_KF002-N-353 ie返回乱码，顺便解决了。*/
			response.getWriter().write(msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("人员添加失败！失败原因：" + e.getMessage());
		}
		// return "framework/user_index";
	}

	/**
	 * 编辑用户
	 * 
	 * @param session
	 *            会话
	 * @param user
	 *            用户
	 * @return jsp路径
	 */
	@RequestMapping("/editUserInfo")
	public void editUser(HttpSession session, BaseUser user,
			HttpServletResponse response) {
		String msg = "人员修改成功！";
		try {
			userSmoImpl.editUserInfo(user);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(URLEncoder.encode(msg, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return "framework/user_index";
	}

	/**
	 * 添加用户窗口
	 * 
	 * @return 路径
	 */
	@RequestMapping("/addUserWindow")
	public ModelAndView addUserWindow() {
		ModelAndView mv = new ModelAndView();
		List<BaseUser> users = userSmoImpl.getAllUsers();
		mv.setViewName("framework/add_user");
		mv.addObject("users", users);
		return mv;
	}

	@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request, ModelMap model) {
		String orgId = request.getParameter("orgId");
		// orgId = StringUtil.validate(orgId) ? orgId : ((BaseUser)
		// request.getSession().getAttribute("user"))
		// .getCompany().getOrgId();
		model.put("s_keyId", request.getParameter("keyId"));
		model.put("s_nameId", request.getParameter("nameId"));
		model.put("s_orgId", orgId);
		model.put("s_isSingle", request.getParameter("isSingle").toLowerCase());
		return "framework/select_user";
	}

	@RequestMapping("/selectUserByCondTwo")
	public void selectUserByCondTwo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String curPage = request.getParameter("page");
		String showCount = request.getParameter("rows");
		String orgId = request.getParameter("orgId");// 组织;
		String userIds = request.getParameter("userIds");// 已选用户
		String userName = request.getParameter("userName");// 检索用户
		String initFlag = request.getParameter("initFlag");
		String[] userIdsArr = null;
		if ("Y".equals(initFlag))// 搜索参数为空时默认显示选 中的用户
		{
			if (userIds != null && !"".equals(userIds)) {
				userIdsArr = userIds.split(",");
				orgId = "";
			}
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		Page page = new Page();
		page.setCurrentPage(Integer.parseInt(curPage));
		page.setShowCount(Integer.parseInt(showCount));
		// wangyan modified @ 20150112 for query root org (17)
		if (orgId.length() == 0) {
			orgId = "17";
		}
		map.put("orgId", orgId);
		map.put("userName", userName);
		map.put("userIds", userIdsArr);
		map.put("page", page);
		// 获取用户的areaId
		BaseUser user = (BaseUser) request.getSession().getAttribute("user");
		String areaId = user.getOrg().getAreaId().toString();
		map.put("areaId", areaId);
		// wangyan modified @ 20150112 for get all children orgid in java
		List<String> orgIds = orgSmoImpl.getAllChildrenOrgId(orgId);
		map.put("orgIds", orgIds);
		List<BaseUser> users = userSmoImpl.selectUserByCondTwo(map, page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
		jsonMap.put("total", page.getTotalResult());// total键 存放总记录数，必须的
		jsonMap.put("rows", users);// rows键 存放每页记录 list
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(JSONObject.fromObject(jsonMap).toString());
	}

}
