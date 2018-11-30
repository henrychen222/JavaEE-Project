package com.zbiti.iepe.framework.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zbiti.core.controller.BaseController;
import com.zbiti.core.dto.Page;
import com.zbiti.core.util.Log;
import com.zbiti.iepe.framework.model.BaseMenu;
import com.zbiti.iepe.framework.model.BaseRole;
import com.zbiti.iepe.framework.model.BaseUser;
import com.zbiti.iepe.framework.smo.MenuSmo;
import com.zbiti.iepe.framework.smo.RoleSmo;

/**
 * 角色控制层
 * 
 * @author zhaoqi
 * 
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	/**
	 * 日志
	 */
	private static final Log LOGGER = Log.getLog(RoleController.class);

	/**
	 * 角色服务层
	 */
	@Resource
	private RoleSmo roleSmoImpl;

	/**
	 * 菜单服务层
	 */
	@Resource
	private MenuSmo menuSmoImpl;

	/**
	 * 加载页面
	 * 
	 * @param model
	 *            返回对象 返回对象
	 * @return 路径 路径 路径
	 */
	@RequestMapping("/index")
	public String index(ModelMap model) {
		List<Map<String, String>> roleType = roleSmoImpl.getRoleTypeList();
		model.put("roleType", roleType);
		return "framework/role_index";
	}

	/**
	 * 条件查询
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象 返回对象
	 * @param model
	 *            返回对象 返回对象
	 */
	@RequestMapping("/selectRolesByCond")
	public void selectRolesByCond(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String curPage = request.getParameter("page");
		String showCount = request.getParameter("rows");
		Page page = new Page();
		page.setCurrentPage(Integer.parseInt(curPage));
		page.setShowCount(Integer.parseInt(showCount));
		String roleName = request.getParameter("roleName");
		String roleTypeCd = request.getParameter("roleTypeCd");
		BaseRole br = new BaseRole();
		br.setRoleName(roleName);
		br.setRoleTypeCd(roleTypeCd);
		List<BaseRole> roles = roleSmoImpl.selectRolesByCond(br, page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
		jsonMap.put("total", page.getTotalResult());// total键 存放总记录数，必须的
		jsonMap.put("rows", roles);// rows键 存放每页记录 list
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(
					JSONObject.fromObject(jsonMap).toString());
		} catch (IOException e) {
			LOGGER.error("response写入失败", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 获取所有角色
	 * 
	 * @param response
	 *            返回对象 返回对象
	 */
	@RequestMapping("/getAllRoles")
	public void getAllRoles(HttpServletResponse response) {
		List<BaseRole> roles = roleSmoImpl.getAllRoles();
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
		jsonMap.put("total", roles.size());// total键 存放总记录数，必须的
		jsonMap.put("rows", roles);// rows键 存放每页记录 list
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(
					JSONObject.fromObject(jsonMap).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加角色窗口
	 * 
	 * @return 路径 路径
	 */
	@RequestMapping("/addRoleWindow")
	public ModelAndView addRoleWindow(@RequestParam("userId") String userId) {
		ModelAndView mv = new ModelAndView();
		List<BaseRole> roles = roleSmoImpl.getAllRoles();
		StringBuilder hasRoles = new StringBuilder();

		for (BaseRole br : roleSmoImpl.getRolesByUser(userId)) {
			hasRoles.append(br.getRoleId()).append(",");
		}
		mv.setViewName("framework/add_role");
		mv.addObject("userId", userId);
		mv.addObject("roles", roles);
		mv.addObject("hasRoles", hasRoles.toString());
		return mv;
	}

	/**
	 * 删除角色窗口
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象 返回对象
	 * @param session
	 *            会话 会 话
	 * @param page
	 *            分页对象
	 * @param model
	 *            返回对象 返回对象
	 */
	@RequestMapping("/deleteRole")
	public void deleteRole(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Page page,
			ModelMap model) {
		String roleId = request.getParameter("roleId");
		String msg = "";
		try {
			roleSmoImpl.deleteRole(roleId);
			msg = "删除成功";
		} catch (Exception e) {
			msg = "删除出错:" + e.getMessage();
			LOGGER.error(msg);
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param model
	 *            返回对象
	 * @return 路径
	 */
	@RequestMapping("/addNew")
	public String addNew(ModelMap model) {
		List<Map<String, String>> roleType = roleSmoImpl.getRoleTypeList();
		BaseRole br = new BaseRole();
		model.put("roleType", roleType);
		model.put("opr", "add");
		model.put("role", br);
		return "framework/edit_role";
	}

	/**
	 * 
	 * @param model
	 *            返回对象
	 * @param roleId
	 *            角色Id
	 * @return 路径
	 */
	@RequestMapping("/editNew")
	public String editNew(ModelMap model, @RequestParam("roleId") String roleId) {
		List<Map<String, String>> roleType = roleSmoImpl.getRoleTypeList();
		BaseRole br = roleSmoImpl.getRoleById(roleId);
		model.put("roleType", roleType);
		model.put("opr", "edit");
		model.put("role", br);
		return "framework/edit_role";
	}

	/**
	 * 
	 * @param role
	 *            角色
	 * @param response
	 *            返回对象
	 * @param session
	 *            会话
	 */
	@RequestMapping("/editRole")
	public void editRole(BaseRole role, HttpServletResponse response,
			HttpSession session) {

		String msg = "";

		// 判断创建角色名称是否重复
		BaseRole roleRepeat = roleSmoImpl.getRoleByRoleName(role.getRoleName());
		if (roleRepeat == null) {
			try {
				roleSmoImpl.editRole(role);
				msg = "修改成功";
			} catch (Exception e) {
				msg = "修改出错:" + e.getMessage();
				LOGGER.error(msg);
				e.printStackTrace();
			}
		} else {
			/*wangyan added @ 151117 ZBITI_2015_RJ(2)_KF002-N-350
			 * 有角色是逻辑删除，这部分角色即使看不到也不能插入，
			 * 这里处理一下，如果是逻辑删除而又需要新增，则把它处理回来变为正常状态。*/
			if (roleRepeat.getIsDelete() != null
					&& roleRepeat.getIsDelete().equals("1")) {
				role.setRoleId(roleRepeat.getRoleId());
				role.setIsDelete("0");
				roleSmoImpl.editRole(role);
				msg = "添加成功";
			} else {
				if(role.getRoleId().equals(roleRepeat.getRoleId())){
					roleSmoImpl.editRole(role);
					msg = "修改成功";
				}else{
					msg = "角色名称已被创建";
				}				
			}
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param role
	 *            角色
	 * @param response
	 *            返回对象
	 * @param session
	 *            会话
	 */
	@RequestMapping("/addRole")
	public void addRole(BaseRole role, HttpServletResponse response,
			HttpSession session) {
		// 从Session中取创建人
		BaseUser user = (BaseUser) session.getAttribute("user");
		role.setCreateOp(String.valueOf(user.getUserId()));
		String msg = "";

		// 判断创建角色名称是否重复
		BaseRole roleRepeat = roleSmoImpl.getRoleByRoleName(role.getRoleName());
		if (roleRepeat == null) {
			try {
				roleSmoImpl.addRole(role);
				msg = "添加成功";
			} catch (Exception e) {
				msg = "添加出错:" + e.getMessage();
				LOGGER.error(msg);
				e.printStackTrace();
			}
		} else {
			// wangyan modified @ 20140929 for handle logic delete
			if (roleRepeat.getIsDelete() != null
					&& roleRepeat.getIsDelete().equals("1")) {
				role.setRoleId(roleRepeat.getRoleId());
				role.setIsDelete("0");
				roleSmoImpl.editRole(role);
				msg = "添加成功";
			} else {
				msg = "角色名称已被创建";
			}
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param userId
	 *            用户ID
	 * @param model
	 *            返回对象
	 * @return 路径
	 */
	@RequestMapping("/userRole")
	public String userRole(@RequestParam("userId") String userId, ModelMap model) {
		List<Map<String, String>> roleType = roleSmoImpl.getRoleTypeList();
		List<BaseRole> roles = roleSmoImpl.getRolesByUser(userId);
		model.put("roleList", roles);
		model.put("roleType", roleType);
		return "framework/user_role";
	}

	/**
	 * 
	 * @param response
	 *            返回对象
	 * @param userId
	 *            用户Id
	 */
	@RequestMapping("/getRoleByUser")
	public void getRoleByUser(HttpServletResponse response,
			@RequestParam("userId") String userId) {
		List<BaseRole> roles = roleSmoImpl.getRolesByUser(userId);
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
		jsonMap.put("total", roles.size());// total键 存放总记录数，必须的
		jsonMap.put("rows", roles);// rows键 存放每页记录 list
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(
					JSONObject.fromObject(jsonMap).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param userId
	 *            用户ID
	 * @param roleId
	 *            角色Id
	 * @param response
	 *            返回对象
	 * @param session
	 *            会话
	 */
	@RequestMapping("/deleteUserRole")
	public void deleteUserRole(@RequestParam("userId") String userId,
			@RequestParam("roleId") String roleId,
			HttpServletResponse response, HttpSession session) {
		String msg = "";
		if (roleId != null && roleId.endsWith(",")) {
			roleId = roleId.substring(0, roleId.length() - 1);
		}

		try {
			if (!"".equals(roleId) && !"".equals(userId)) {
				roleSmoImpl.deleteUserRole(userId, roleId);
			}
			msg = "保存成功";
		} catch (Exception e) {
			msg = "保存失败：" + e.getMessage();
			LOGGER.error(msg);
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param userId
	 *            用户ID
	 * @param roleIds
	 *            角色Ids
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param response
	 *            返回对象
	 * @param session
	 *            会话
	 */
	@RequestMapping("/saveUserRole")
	public void saveUserRole(@RequestParam("userId") String userId,
			@RequestParam("roleIds") String roleIds,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			HttpServletResponse response, HttpSession session) {
		String[] roles = null;
		String resultMsg = "";
		if (roleIds != null) {
			roles = roleIds.split(",");
		}
		String[] users = userId.split(",");
		resultMsg = roleSmoImpl.saveUserRole(users, roles, startDate, endDate);
		if (resultMsg != "" || !"".equals(resultMsg)){
			resultMsg = "保存成功！";
		}else{
			resultMsg = "保存失败！";
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(resultMsg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param roleId
	 *            角色Id
	 * @param model
	 *            返回对象
	 * @return 路径
	 */
	@RequestMapping("/rolePermission")
	public String rolePermission(@RequestParam("roleId") String roleId,
			ModelMap model) {
		List<BaseMenu> bms = menuSmoImpl.getMenusByRoleId(roleId);
		BaseRole br = roleSmoImpl.getRoleById(roleId);
		model.put("role", br);
		model.put("roleMenus", bms);
		return "framework/role_permission";
	}

	/**
	 * 
	 * @param response
	 *            返回对象
	 * @param session
	 *            会话
	 * @param roleId
	 *            角色Id
	 * @param menus
	 *            菜单
	 */
	@RequestMapping("/saveRoleMenu")
	public void saveRoleMenu(HttpServletResponse response, HttpSession session,
			@RequestParam("roleId") String roleId,
			@RequestParam("menus") String menus) {
		String result = "";
		List<String> menuList = new ArrayList<String>();
		try {
			if (menus != null) {
				if (menus.endsWith(",")) {
					menus = menus.substring(0, menus.length() - 1);
					String[] menuArr = menus.split(",");
					menuList = Arrays.asList(menuArr);
				}
			}
			menuSmoImpl.saveRoleMenus(roleId, menuList);
			result = "保存成功";
		} catch (Exception e) {
			result = "保存失败：" + e.getMessage();
			LOGGER.error(result);
			e.printStackTrace();
		}
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示分配用户页面
	 * 
	 * @return
	 */
	@RequestMapping("roleUser")
	public ModelAndView roleUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("framework/role_user");
		return mv;
	}

	/**
	 * 显示分配用户页面
	 * 
	 * @return
	 */
	@RequestMapping("showAddRole")
	public ModelAndView showAddRole() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("framework/showAddRole");
		return mv;
	}

	/**
	 * 分配用户页面
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回
	 */
	@RequestMapping("getUserByRole")
	public void getUserByRole(HttpServletRequest request,
			HttpServletResponse response) {
		String roleId = request.getParameter("roleId");
		page = new Page(request);
		List<BaseUser> users = roleSmoImpl.getUsersByRole(roleId, page);
		super.obj2Page(response, page, users);
	}

	/**
	 * 添加角色窗口
	 * 
	 * @return 路径 路径
	 */
	@RequestMapping("/addRoleWindows")
	public ModelAndView addRoleWindows() {
		ModelAndView mv = new ModelAndView();
		List<BaseRole> roles = roleSmoImpl.getAllRoles();
		mv.setViewName("framework/add_rolep");
		mv.addObject("roles", roles);
		return mv;
	}

}
