package com.zbiti.iepe.framework.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.model.BaseRole;
import com.zbiti.iepe.framework.model.BaseUser;

/**
 * 角色持久层
 * 
 * @author zhaoqi
 * 
 */
public interface RoleDao {

	/**
	 * 分页条件查询角色
	 * 
	 * @param br
	 *            角色
	 * @param page
	 *            分页对象
	 * @return 条件查询出的角色列表
	 */
	List<BaseRole> selectRolesByCondlistPage(@Param("role") BaseRole br,
			@Param("page") Page page);

	/**
	 * 根据角色的id得到该角色下所有的用户
	 * 
	 * @param roleId
	 *            角色
	 * @return 该角色下所有用户
	 */
	List<BaseUser> selectUsersByRole(@Param("roleId") String roleId);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 *            角色
	 * @throws Exception
	 *             异常
	 */
	void deleteRole(@Param("roleId") String roleId) throws Exception;

	/**
	 * 添加角色
	 * 
	 * @param role
	 *            角色
	 */
	void addRole(BaseRole role);

	/**
	 * 更新角色
	 * 
	 * @param role
	 *            角色
	 */
	void updateRole(BaseRole role);

	/**
	 * 获取角色类型
	 * 
	 * @return 角色类型
	 */
	List<Map<String, String>> getRoleTypeList();

	/**
	 * 根据角色ID获取角色
	 * 
	 * @param roleId
	 *            角色ID
	 * @return 角色
	 */
	BaseRole getRoleById(@Param("roleId") String roleId);

	/**
	 * 获取某个用户拥有的角色
	 * 
	 * @param userId
	 * 
	 * @return 拥有的的角色
	 */
	List<BaseRole> getRolesByUser(@Param("userId") String userId);


	/**
	 * 删除用户角色对用关系
	 * 
	 * @param userId
	 *            用户
	 * @param roleId
	 *            角色
	 */
	void deleteUserRole(@Param("userId") String userId,
			@Param("roleId") String roleId);

	/**
	 * 保存用户角色对应关系
	 * 
	 * @param userId
	 *            用户
	 * @param roleId
	 *            角色
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            到期时间
	 */
	void saveUserRole(@Param("userId") String userId,
			@Param("roleId") String roleId,
			@Param("startDate") String startDate,
			@Param("endDate") String endDate);

	/**
	 * 获取所有角色
	 * 
	 * @return 所有角色
	 */
	List<BaseRole> getAllRoles();

	/**
	 * 批量复制权限
	 * 
	 * @param fromUserId
	 *            目标ID
	 * @param copyUserId
	 *            复制人
	 * @param copyRole
	 *            复制目标角色
	 */
	void betchInsertUserRole(@Param("fromUserId") String fromUserId,
			@Param("copyUserId") String[] copyUserId,
			@Param("copyRole") String[] copyRole);

	/**
	 * 根据角色查用户
	 * 
	 * @param roleId
	 *            角色ID
	 * @param page
	 *            分页对象
	 * @return 用户
	 */
	List<BaseUser> getUsersByRolelistPage(@Param("roleId") String roleId,
			@Param("page") Page page);

	/**
	 * 根据角色名称获取角色
	 * 
	 * @param roleName
	 *            角色名称
	 * @return 角色
	 */
	BaseRole getRoleByRoleName(@Param("roleName") String roleName);

}
