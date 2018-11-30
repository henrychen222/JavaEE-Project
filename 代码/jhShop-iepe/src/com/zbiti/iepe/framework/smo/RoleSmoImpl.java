package com.zbiti.iepe.framework.smo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.dao.RoleDao;
import com.zbiti.iepe.framework.model.BaseRole;
import com.zbiti.iepe.framework.model.BaseUser;

/**
 * 角色服务层
 * 
 * @author zhaoqi
 * 
 */
@Service
public class RoleSmoImpl implements RoleSmo {

	/**
	 * 角色持久层
	 */
	@Resource
	RoleDao roleDao;

	/**
	 * 菜单持久层
	 */
	@Resource
	MenuSmo menuSmoImpl;

	@Override
	public List<BaseRole> selectRolesByCond(BaseRole br, Page page) {
		return roleDao.selectRolesByCondlistPage(br, page);
	}

	/**
	 * 根据角色的id得到该角色下所有的用户
	 * 
	 * @param roleId
	 *            角色Id
	 * @return 该角色下所有用户的accountName
	 */
	@Override
	public List<BaseUser> selectUsersByRole(String roleId) {
		return roleDao.selectUsersByRole(roleId);
	}

	@Override
	public void deleteRole(String roleId) throws Exception {
		try {
			roleDao.deleteRole(roleId);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void addRole(BaseRole role) throws Exception {
		try {
			roleDao.addRole(role);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Map<String, String>> getRoleTypeList() {
		return roleDao.getRoleTypeList();
	}

	@Override
	public BaseRole getRoleById(String roleId) {
		return roleDao.getRoleById(roleId);
	}

	@Override
	public void editRole(BaseRole role) {
		roleDao.updateRole(role);
	}

	@Override
	public List<BaseRole> getRolesByUser(String userId) {
		List<BaseRole> roles = roleDao.getRolesByUser(userId);
		for (BaseRole r : roles) {
			r.setMenuPermission(menuSmoImpl.getMenusByRoleId(String.valueOf(r
					.getRoleId())));
		}
		return roles;
	}

	@Override
	public void deleteUserRole(String userId, String roleId) {
		roleDao.deleteUserRole(userId, roleId);

	}

	@Override
	public String saveUserRole(String[] userId, String[] roles,
			String startDate, String endDate) {
		String result = "";
		int i = 0;
		for (String u : userId) {
			/*wangyan modified @ 151118 ZBITI_2015_RJ(2)_KF002-N-465 ZBITI_2015_RJ(2)_KF002-N-455 
			 * 删除角色有问题，需要删除全量，否则无法编辑。*/
			for (BaseRole br : roleDao.getAllRoles()) {
				roleDao.deleteUserRole(u, br.getRoleId());
			}
			for (String roleId : roles) {
				try {
					roleDao.saveUserRole(u, roleId, startDate, endDate);
					i++;
				} catch (Exception e) {
					e.printStackTrace();
					result += "[roleId:" + roleId + "保存失败.原因：" + e.getMessage()
							+ "]";
				}
			}
		}
		result += "-----[保存完毕：总共保存" + i + "条]";
		return result;
	}

	@Override
	public List<BaseRole> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Override
	public void betchInsertUserRole(String fromUserId, String[] copyUserId,
			String[] copyRole) {
		roleDao.betchInsertUserRole(fromUserId, copyUserId, copyRole);
	}

	@Override
	public List<BaseUser> getUsersByRole(String roleId, Page page) {
		return roleDao.getUsersByRolelistPage(roleId, page);
	}

	@Override
	public BaseRole getRoleByRoleName(String roleName) {
		return roleDao.getRoleByRoleName(roleName);
	}

}
