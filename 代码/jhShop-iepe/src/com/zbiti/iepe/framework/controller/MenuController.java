package com.zbiti.iepe.framework.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zbiti.core.model.TreeNode;
import com.zbiti.iepe.framework.model.BaseMenu;
import com.zbiti.iepe.framework.model.BaseRole;
import com.zbiti.iepe.framework.model.BaseUser;
import com.zbiti.iepe.framework.smo.MenuSmo;
import com.zbiti.iepe.framework.smo.RoleSmo;

/**
 * 菜单控制类
 * 
 * @author zhaoqi
 * 
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

	/**
	 * c菜单服务层
	 */
	@Resource
	MenuSmo menuSmoImpl;

	/**
	 * 角色服务层
	 */
	@Resource
	RoleSmo roleSmoImpl;
	/**
	 * 菜单主页
	 * 
	 * @param model
	 *            model对象 返回对象
	 * @return 路径
	 */
	@RequestMapping("/index")
	public String showOrg(ModelMap model) {
		List<Map<String, String>> menuType = menuSmoImpl.selectMenuType();
		model.put("menuType", menuType);
		return "framework/menu_index";
	}

	/**
	 * 加载机构树
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/loadMenuTreeAll")
	public void loadMenuTreeAll(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		List<BaseMenu> result = menuSmoImpl.getAllMenus();

		LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
		if (result != null && result.size() != 0) {
			for (BaseMenu bm : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bm.getMenuId());
				tn.setParentId(bm.getParentMenuId());
				tn.setText(bm.getTitle());
				tn.setName(bm.getTitle());
				tns.add(tn);
			}
		}

		TreeNode treenode = new TreeNode(tns);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(
					JSONArray.fromObject(treenode.getChildren()).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载机构树
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/loadMenuTree")
	public void loadMenuTree(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String menuId = request.getParameter("menuId");
		String opr = request.getParameter("opr");
		List<BaseMenu> result = menuSmoImpl.selectMenuByParentId(menuId);

		TreeNode root = new TreeNode();
		root.setId(-1);
		root.setText("请选择，如导航菜单点则不选");
		root.setName("请选择，如导航菜单则不选");
		if (result != null && result.size() > 0) {
			root.setState("open");
		}
		LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
		if (result != null && result.size() != 0) {
			for (BaseMenu bm : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bm.getMenuId());
				tn.setParentId(bm.getParentMenuId());
				tn.setText(bm.getTitle());
				tn.setName(bm.getTitle());
				List<BaseMenu> son = menuSmoImpl.selectMenuByParentId(String
						.valueOf(bm.getMenuId()));
				if (son != null && son.size() > 0) {
					tn.setState("closed");
				}
				tns.add(tn);
			}
		}
		root.setChildren(tns);

		response.setCharacterEncoding("UTF-8");
		try {
			if ("-1".equals(menuId) && !"load".equals(opr)) {
				response.getWriter().write(
						"[" + JSONObject.fromObject(root).toString() + "]");
			} else {
				response.getWriter()
						.write(JSONArray.fromObject(tns).toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 加载机构树
	 * 
	 * @param request
	 *            请求
	 * @param response
	 *            返回对象
	 * @param model
	 *            model对象
	 */
	@RequestMapping("/loadMenu")
	public void loadMenu(HttpServletRequest request,
		HttpServletResponse response, ModelMap model,HttpSession session) {
		BaseUser bu = (BaseUser)session.getAttribute("user");
		List<BaseRole> roles = roleSmoImpl.getRolesByUser(bu.getUserId());
		
		String menuId = request.getParameter("menuId");
		String opr = request.getParameter("opr");
		List<BaseMenu> result = menuSmoImpl.selectMenuByParentIdbyrole(menuId,roles.get(0).getRoleId());

		TreeNode root = new TreeNode();
		root.setId(-1);
		root.setText("请选择，如导航菜单点则不选");
		root.setName("请选择，如导航菜单则不选");
		if (result != null && result.size() > 0) {
			root.setState("open");
		}
		LinkedList<TreeNode> tns = new LinkedList<TreeNode>();
		if (result != null && result.size() != 0) {
			for (BaseMenu bm : result) {
				TreeNode tn = new TreeNode();
				tn.setId(bm.getMenuId());
				tn.setParentId(bm.getParentMenuId());
				tn.setText(bm.getTitle());
				tn.setName(bm.getTitle());
				List<BaseMenu> son = menuSmoImpl.selectMenuByParentId(String
						.valueOf(bm.getMenuId()));
				if (son != null && son.size() > 0) {
					tn.setState("closed");
				}
				tns.add(tn);
			}
		}
		root.setChildren(tns);

		response.setCharacterEncoding("UTF-8");
		try {
			if ("-1".equals(menuId) && !"load".equals(opr)) {
				response.getWriter().write(
						"[" + JSONObject.fromObject(root).toString() + "]");
			} else {
				response.getWriter()
						.write(JSONArray.fromObject(tns).toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * id查菜单
	 * 
	 * @param menuId
	 *            菜单Id
	 * @param response
	 *            返回对象
	 */
	@RequestMapping("/selectMenuById")
	public void selectMenuById(@RequestParam("menuId") String menuId,
			HttpServletResponse response) {
		BaseMenu baseMenu = new BaseMenu();
		if (menuId != null && !"".equals(menuId)) {
			baseMenu = menuSmoImpl.selectMenuById(menuId);
		}
		response.setCharacterEncoding("UTF-8");
		List<BaseMenu> menuList = new ArrayList<BaseMenu>();
		menuList.add(baseMenu);
		try {
			response.getWriter().write(
					JSONObject.fromObject(baseMenu).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加菜单
	 * 
	 * @param bm
	 *            菜单
	 * @param response
	 *            返回对象
	 */
	@RequestMapping("/addMenu")
	public void addMenu(BaseMenu bm, HttpServletResponse response) {
		HashMap<String, Object> resultMsg = new HashMap<String, Object>();
		try {
			menuSmoImpl.addMenu(bm);
			resultMsg.put("result", "保存成功！");
		} catch (Exception e) {
			resultMsg.put("result", "保存失败：" + e.getMessage());
			e.printStackTrace();
		}
		resultMsg.put("menu", bm);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(
					JSONObject.fromObject(resultMsg).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 编辑菜单
	 * 
	 * @param bm
	 *            菜单
	 * @param response
	 *            返回对象
	 */
	@RequestMapping("/editMenu")
	public void editMenu(BaseMenu bm, HttpServletResponse response) {
		HashMap<String, Object> resultMsg = new HashMap<String, Object>();
		try {
			menuSmoImpl.editMenu(bm);
			resultMsg.put("result", "保存成功！");
		} catch (Exception e) {
			resultMsg.put("result", "保存失败：" + e.getMessage());
			e.printStackTrace();
		}
		resultMsg.put("menu", bm);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(
					JSONObject.fromObject(resultMsg).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 是否有子节点
	 * 
	 * @param menuId
	 *            菜单Id
	 * @param response
	 *            返回对象
	 */
	@RequestMapping("/checkHasSon")
	public void checkHasSon(@RequestParam("menuId") String menuId,
			HttpServletResponse response) {
		List<BaseMenu> baseMenu = new ArrayList<BaseMenu>();
		if (menuId != null && !"".equals(menuId)) {
			baseMenu = menuSmoImpl.selectMenuByParentId(menuId);
		}
		String result = "N";
		if (baseMenu != null && baseMenu.size() > 0) {
			result = "Y";
		}
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除菜单
	 * 
	 * @param menuId
	 *            菜单Id 菜单ID
	 * @param response
	 *            返回对象
	 */
	@RequestMapping("/deleteMenu")
	public void deleteMenu(@RequestParam("menuId") String menuId,
			HttpServletResponse response) {
		HashMap<String, Object> resultMsg = new HashMap<String, Object>();
		try {
			menuSmoImpl.deleteMenu(menuId);
			resultMsg.put("result", "保存成功！");
		} catch (Exception e) {
			resultMsg.put("result", "保存失败：" + e.getMessage());
			e.printStackTrace();
		}
		resultMsg.put("menuId", menuId);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(
					JSONObject.fromObject(resultMsg).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取父菜单
	 * 
	 * @param menuId
	 *            菜单Id
	 * @param response
	 *            返回对象
	 */
	@RequestMapping("/getParentMenusById")
	public void getParentMenusById(@RequestParam("menuId") String menuId,
			HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		BaseMenu bm;
		while ((bm = menuSmoImpl.selectMenuById(menuId)) != null) {
			sb.append(menuId).append(",");
			menuId = Integer.toString(bm.getParentMenuId());
		}
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
