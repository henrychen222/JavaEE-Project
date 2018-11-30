package com.zbiti.iepe.framework.smo;

import java.util.List;
import java.util.Map;

import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.model.BaseRole;
import com.zbiti.iepe.framework.model.BaseUser;

/**
 * 角色服务层
 * 
 * @author zhaoqi
 * 
 */
public interface RoleSmo {

	/**
	 * 条件查询角色
	 * 
	 * @param br
	 *            条件角色对象
	 * @param page
	 *            分页对象（分页必须）
	 * @return 角色列表
	 */
	public List<BaseRole> selectRolesByCond(BaseRole br, Page page);

	/**
	 * 根据角色的id得到该角色下所有的用户
	 * 
	 * @param roleId
	 *            角色的id
	 * @return 该角色下所有用户的
	 */
	public List<BaseUser> selectUsersByRole(String roleId);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 *            角色ID
	 * @throws Exception
	 *             异常
	 */
	public void deleteRole(String roleId) throws Exception;

	/**
	 * 新增角色
	 * 
	 * @param role
	 *            新角色对象
	 * @throws Exception
	 *             异常
	 */
	public void addRole(BaseRole role) throws Exception;

	/**
	 * 角色类型
	 * 
	 * @return 角色类型
	 */
	public List<Map<String, String>> getRoleTypeList();

	/**
	 * 角色ID查找角色对象
	 * 
	 * @param roleId
	 *            角色ID
	 * @return 角色对象ID
	 */
	public BaseRole getRoleById(String roleId);

	/**
	 * 编辑角色
	 * 
	 * @param role
	 *            新角色对象
	 */
	public void editRole(BaseRole role);

	/**
	 * 获取某个用户拥有的角色
	 * 
	 * @param userId
	 *            用户ID
	 * @return 该用户拥有的角色列表
	 */
	public List<BaseRole> getRolesByUser(String userId);

	/**
	 * 清除用户与角色的关系
	 * 
	 * @param userId
	 *            用户ID
	 * @param roleId
	 *            角色ID
	 */
	public void deleteUserRole(String userId, String roleId);

	/**
	 * 保存用户与角色的关系
	 * 
	 * @param users
	 *            用户ID
	 * @param roles
	 *            角色ID 数组 1,2,3,
	 * @param startDate
	 *            注册时间
	 * @param endDate
	 *            到期时间
	 * @return 关系
	 */
	public String saveUserRole(String[] users, String[] roles,
			String startDate, String endDate);

	/**
	 * 获取所有的角色
	 * 
	 * @return 所有的角色
	 */
	public List<BaseRole> getAllRoles();

	/**
	 * 批量插入用户角色
	 * 
	 * @param fromUserId
	 *            目标人
	 * @param copyUserId
	 *            批量插入的用户ID
	 * @param copyRole
	 *            批量插入的角色ID
	 */
	public void betchInsertUserRole(String fromUserId, String[] copyUserId,
			String[] copyRole);

	/**
	 * 根据角色查用户
	 * 
	 * @param roleId
	 * @param page
	 * @return
	 */
	public List<BaseUser> getUsersByRole(String roleId, Page page);

	/**
	 * 角色名称查找角色对象
	 * 
	 * @param roleName
	 *            角色名称
	 * @return 角色对象ID
	 */
	public BaseRole getRoleByRoleName(String roleName);

}