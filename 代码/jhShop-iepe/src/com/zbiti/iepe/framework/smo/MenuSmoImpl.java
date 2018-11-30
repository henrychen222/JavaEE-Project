package com.zbiti.iepe.framework.smo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zbiti.iepe.framework.dao.MenuDao;
import com.zbiti.iepe.framework.model.BaseMenu;
import com.zbiti.iepe.framework.model.BaseRole;

/**
 * 菜单权限服务层
 * 
 * @author zhaoqi
 * 
 */
@Service
public class MenuSmoImpl implements MenuSmo {

	/**
	 * 菜单权限持久层
	 */
	@Resource
	MenuDao menuDao;

	@Override
	public List<BaseMenu> getAllMenus() {
		return menuDao.getAllMenus();
	}

	@Override
	public BaseMenu selectMenuById(String menuId) {
		return menuDao.selectMenuById(menuId);
	}

	@Override
	public void addMenu(BaseMenu bm) {
		menuDao.addMenu(bm);
	}

	@Override
	public void editMenu(BaseMenu bm) {
		menuDao.editMenu(bm);
	}

	@Override
	public List<BaseMenu> selectMenuByParentId(String menuId) {
		return menuDao.selectMenuByParentId(menuId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteMenu(String menuId) {
		// 删除菜单与角色关系
		menuDao.deleteRoleMenu(menuId);
		// 删除菜单
		menuDao.deleteMenu(menuId);
	}

	@Override
	public List<BaseMenu> getMenusByRoleId(String roleId) {
		return menuDao.getMenusByRoleId(roleId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveRoleMenus(String roleId, List<String> menuList) {
		// 删除该用户下的所有菜单权限
		this.deleteRoleMenuByRole(roleId);
		List<Map<String, String>> saveMenus = new ArrayList<Map<String, String>>();
		if (menuList != null && menuList.size() > 0) {
			for (String m : menuList) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("roleId", roleId);
				map.put("menuId", m);
				saveMenus.add(map);
			}
			menuDao.saveRoleMenus(saveMenus);
		}
	}

	@Override
	public void deleteRoleMenuByRole(String roleId) {
		menuDao.deleteRoleMenuByRole(roleId);
	}

	@Override
	public List<Map<String, String>> selectMenuType() {
		return menuDao.selectMenuType();
	}

	@Override
	public LinkedList<BaseMenu> convertMenu(ArrayList<BaseMenu> menuList) {

		if (menuList == null) {
			return null;
		}
		// 将列表转换成以ID为键的Map
		LinkedHashMap<Integer, BaseMenu> tnMaps = new LinkedHashMap<Integer, BaseMenu>();
		for (BaseMenu n : new ArrayList<BaseMenu>(menuList)) {
			tnMaps.put(n.getMenuId(), n);
		}
		// 用于记录存在父节点的节点，最后移除
		List<Integer> removeNotes = new ArrayList<Integer>();

		Set<Integer> tnKey = tnMaps.keySet();
		Iterator<Integer> it = tnKey.iterator();
		while (it.hasNext()) {
			int id = it.next();
			BaseMenu tn = tnMaps.get(id);
			int parentId = tn.getParentMenuId();
			if (parentId != 0 && parentId != -1 && tnMaps.get(parentId) != null) {
				// 存在父节点
				removeNotes.add(id);
				if (tnMaps.get(parentId).getChildren() == null) {
					tnMaps.get(parentId)
							.setChildren(new LinkedList<BaseMenu>());
				}
				// 将子节点加入父节点中
				tnMaps.get(parentId).getChildren().add(tn);
			}
		}
		// 删除有父节点的，保留无父节点的，即最上层
		for (int s : removeNotes) {
			tnMaps.remove(s);
		}

		LinkedList<BaseMenu> result = new LinkedList<BaseMenu>();
		Iterator<Integer> it2 = tnKey.iterator();
		while (it2.hasNext()) {
			result.add(tnMaps.get(it2.next()));
		}
		return result;
	}

	@Override
	public ArrayList<BaseMenu> distinctMenu(List<BaseRole> roles) {
		// 解析菜单
		ArrayList<BaseMenu> menuPermission = new ArrayList<BaseMenu>();
		// 用于去重
		List<Integer> menuId = new ArrayList<Integer>();
		if (roles != null) {
			for (BaseRole br : roles) {
				List<BaseMenu> roleMenu = br.getMenuPermission();
				for (BaseMenu bm : roleMenu) {
					if (menuId.contains(bm.getMenuId())) {
						continue;
					}
					menuPermission.add(new BaseMenu(bm));
					menuId.add(bm.getMenuId());
				}
			}
		}
		return menuPermission;
	}

	@Override
	public List<BaseMenu> selectMenuByParentIdbyrole(String menuId,
			String roleId) {
		Map<String, Object> params = new HashMap<String, Object>();  
		params.put("menuId", menuId);
		params.put("roleId", roleId);
		return menuDao.selectMenuByParentIdbyroleId(params);
	}

}
