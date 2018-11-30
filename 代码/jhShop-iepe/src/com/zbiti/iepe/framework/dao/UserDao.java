package com.zbiti.iepe.framework.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.iepe.framework.model.BaseUser;

/**
 * 用户持久层
 * 
 * @author zhaoqi
 * 
 */
public interface UserDao {
	/**
	 * 账号找人
	 * 
	 * @param user
	 *            账号
	 * @return 人员对象
	 */
	public BaseUser selectUserByAccount(BaseUser user);

	/**
	 * 条件查询用户
	 * 
	 * @param map
	 *            条件
	 * @return 人员对象
	 */
	public List<BaseUser> selectUserByCondlistPage(HashMap<String, Object> map);

	/**
	 * 查询所用用户
	 * 
	 * @return 所用用户
	 */
	public List<BaseUser> selectAllUser();

	/**
	 * 根据公司的id查询用户
	 * 
	 * @param orgId
	 *            可以放入orgId（公司）
	 * @return 该组织下的所有用户的accountName
	 */
	public List<BaseUser> selectUserByCom(@Param("orgId") String orgId);

	/**
	 * 根据组织的id查询用户
	 * 
	 * @param orgId
	 *            可以放入orgId（部门）
	 * @return 该组织下的所有用户的accountName
	 */
	public List<BaseUser> selectUserByOrg(@Param("orgId") String orgId);

	/**
	 * 根据组织的id查询用户
	 * 
	 * @param orgId
	 *            可以放入orgId（部门）
	 * @return 该组织下的所有用户的数量
	 */
	public Map<String, Object> selectUserCountByOrg(@Param("orgId") String orgId);

	/**
	 * 根据ID查用户
	 * 
	 * @param userId
	 *            ID
	 * @return 用户
	 */
	public BaseUser getUserById(@Param("userId") String userId);

	/**
	 * 更新用户
	 * 
	 * @param bu
	 *            用户
	 */
	public void saveUser(BaseUser bu);

	/**
	 * 新增用户
	 * 
	 * @param user
	 *            用户
	 */
	public void addUser(BaseUser user);

	/**
	 * 新建用户扩展信息
	 * 
	 * @param user
	 */
	// public void addUserExtends(BaseUser user);

	/**
	 * 新建用户组织对应关系
	 * 
	 * @param user
	 *            用户
	 */
	public void addUser2Org(BaseUser user);

	/**
	 * 修改用户
	 * 
	 * @param user
	 *            用户
	 */
	public void editUser(BaseUser user);

	/**
	 * 修改用户扩展
	 * 
	 * @param user
	 *            用户
	 */
	// public void editUserExtends(BaseUser user);

	/**
	 * 修改用户机构
	 * 
	 * @param user
	 *            用户
	 */
	public void editUser2Org(BaseUser user);

	/**
	 * 根据Ids查询用户
	 * 
	 * @param userIds
	 *            用户Id
	 * @return 用户
	 */
	public List<BaseUser> queryUserByIds(List<String> userIds);

	/**
	 * 账号查用户
	 * 
	 * @param userAccount
	 *            用户账号
	 * @return 用户
	 */
	public BaseUser getUserByAccount(@Param("userAccount") String userAccount);

	public BaseUser getUserByAccounted(@Param("userAccount") String userAccount);

	public BaseUser getUserByAccounteds(@Param("userAccount") String userAccount);

	/**
	 * 账号查用户数量
	 * 
	 * @param userAccount
	 *            用户账号
	 * @return 用户
	 */
	public int getUserCountByAccount(@Param("userAccount") String userAccount);

	/**
	 * 账号和系统查用户
	 * 
	 * @param userAccount
	 *            用户账号
	 * @return 用户
	 */
	public BaseUser getUserByAccountAndSys(
			@Param("userAccount") String userAccount, @Param("sys") String sys);

	/**
	 * 保存用户扩展
	 * 
	 * @param extedsProperties
	 *            用户扩展
	 */
	public void saveUserExtends(List<Map<String, String>> extedsProperties);

	/**
	 * 修改用户扩展
	 * 
	 * @param extedsProperties
	 *            用户扩展
	 */
	public void updateUserExtends(Map<String, String> extedsProperties);

	/**
	 * 获取该岗位下用户
	 * 
	 * @param positionId
	 * 
	 * @return 拥有的的岗位
	 */
	List<BaseUser> getUsersByPosition(@Param("positionId") String positionId);

	/**
	 * 获取该岗位下用户数量
	 * 
	 * @param positionId
	 * @return 拥有的的岗位
	 */
	Map<String, Object> getUsersCountByPosition(
			@Param("positionId") String positionId);

	/**
	 * 获取所有的岗位
	 * 
	 * @return 所有的岗位
	 */
	List<BaseUser> getAllUsers();

	/**
	 * 根据账号查询用户id
	 * 
	 * @param Account
	 * @return
	 */
	public BaseUser getUserIdByAccount(@Param("Account") String Account);

	/**
	 * 根据组织的id,用户名查询用户
	 * 
	 * @param orgId
	 * @param userName
	 * @return
	 */
	public List<BaseUser> selectUserByOrgDim(@Param("orgId") String orgId,
			@Param("userName") String userName);
	
	/**
	 * select phone number and areaId by accountName
	 * 
	 * @param accountName
	 * @return
	 */
	public List<Map<String, Object>> selectPhoneAndAreaIdByAccountName(
			@Param("accountName") String accountName);

	/**
	 * select phone number and areaId by positionId
	 * 
	 * @param positionId
	 * @return
	 */
	public List<Map<String, Object>> selectPhoneAndAreaIdByPositionId(
			@Param("positionId") Long positionId);

	/**
	 * <!-- 入库前验证 -->
	 * 
	 * @param Account
	 * @return
	 */
	public BaseUser checkUser(@Param("Account") String Account);

	public String getTopOrgIdByAreaId(@Param("areaId") String areaId);

	public List<BaseUser> selectUserByCondTwolistPage(
			HashMap<String, Object> map);
}
