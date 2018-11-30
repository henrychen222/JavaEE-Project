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

import com.zbiti.iepe.framework.model.BaseHelpMenu;
import com.zbiti.iepe.framework.model.BaseRole;
import com.zbiti.iepe.framework.dao.HelpMenuDao;


@Service
public class HelpMenuSmoImpl implements HelpMenuSmo {

	/**
	 * 菜单权限持久层
	 */
	@Resource
	 HelpMenuDao HelpMenuDao;

	@Override
	public List<BaseHelpMenu> getAllMenus() {
		return HelpMenuDao.getAllMenus();
	}

	@Override
	public BaseHelpMenu selectMenuById(String menuId) {
		return HelpMenuDao.selectMenuById(menuId);
	}

	@Override
	public void addMenu(BaseHelpMenu bm) {
		HelpMenuDao.addMenu(bm);
	}

	@Override
	public void editMenu(BaseHelpMenu bm) {
		HelpMenuDao.editMenu(bm);
	}

	@Override
	public List<BaseHelpMenu> selectMenuByParentId(String menuId) {
		return HelpMenuDao.selectMenuByParentId(menuId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteMenu(String menuId) {
		// 删除菜单
		HelpMenuDao.deleteMenu(menuId);
	}

	@Override
	public List<BaseHelpMenu> getMenusByRoleId(String roleId) {
		return HelpMenuDao.getMenusByRoleId(roleId);
	}

/*	@Override
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
			HelpMenuDao.saveRoleMenus(saveMenus);
		}
	}*/

/*	@Override
	public void deleteRoleMenuByRole(String roleId) {
		HelpMenuDao.deleteRoleMenuByRole(roleId);
	}*/

	@Override
	public List<Map<String, String>> selectMenuType() {
		return HelpMenuDao.selectMenuType();
	}

	@Override
	public LinkedList<BaseHelpMenu> convertMenu(ArrayList<BaseHelpMenu> menuList) {

		if (menuList == null) {
			return null;
		}
		// 将列表转换成以ID为键的Map
		LinkedHashMap<Integer, BaseHelpMenu> tnMaps = new LinkedHashMap<Integer, BaseHelpMenu>();
		for (BaseHelpMenu n : new ArrayList<BaseHelpMenu>(menuList)) {
			tnMaps.put(n.getMenuId(), n);
		}
		// 用于记录存在父节点的节点，最后移除
		List<Integer> removeNotes = new ArrayList<Integer>();

		Set<Integer> tnKey = tnMaps.keySet();
		Iterator<Integer> it = tnKey.iterator();
		while (it.hasNext()) {
			int id = it.next();
			BaseHelpMenu tn = tnMaps.get(id);
			int parentId = tn.getParentMenuId();
			if (parentId != 0 && parentId != -1 && tnMaps.get(parentId) != null) {
				// 存在父节点
				removeNotes.add(id);
				if (tnMaps.get(parentId).getChildren() == null) {
					tnMaps.get(parentId)
							.setChildren(new LinkedList<BaseHelpMenu>());
				}
				// 将子节点加入父节点中
				tnMaps.get(parentId).getChildren().add(tn);
			}
		}
		// 删除有父节点的，保留无父节点的，即最上层
		for (int s : removeNotes) {
			tnMaps.remove(s);
		}

		LinkedList<BaseHelpMenu> result = new LinkedList<BaseHelpMenu>();
		Iterator<Integer> it2 = tnKey.iterator();
		while (it2.hasNext()) {
			result.add(tnMaps.get(it2.next()));
		}
		return result;
	}

	/*@Override
	public ArrayList<BaseHelpMenu> distinctMenu(List<BaseRole> roles) {
		// 解析菜单
		ArrayList<BaseHelpMenu> menuPermission = new ArrayList<BaseHelpMenu>();
		// 用于去重
		List<Integer> menuId = new ArrayList<Integer>();
		if (roles != null) {
			for (BaseRole br : roles) {
				List<BaseHelpMenu> roleMenu = br.getMenuPermission();
				for (BaseHelpMenu bm : roleMenu) {
					if (menuId.contains(bm.getMenuId())) {
						continue;
					}
					menuPermission.add(new BaseHelpMenu(bm));
					menuId.add(bm.getMenuId());
				}
			}
		}
		return menuPermission;
	}*/

	@Override
	public List<BaseHelpMenu> selectMenuByParentIdbyrole(String menuId,
			String roleId) {
		Map<String, Object> params = new HashMap<String, Object>();  
		params.put("menuId", menuId);
		params.put("roleId", roleId);
		return HelpMenuDao.selectMenuByParentIdbyroleId(params);
	}

}
