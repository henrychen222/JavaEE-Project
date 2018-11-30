package com.zbiti.iepe.framework.smo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.model.BaseUser;

/**
 * 用户服务层
 * 
 * @author zhaoqi
 * 
 */
public interface UserSmo {

	/**
	 * 根据条件查询用户
	 * 
	 * @param map
	 *            条件Map
	 * @param page
	 *            分页对象
	 * @return 用户
	 */
	public List<BaseUser> selectUserByCond(HashMap<String, Object> map,
			Page page);

	/**
	 * 查询所用用户
	 * 
	 * @return 用户列表
	 */
	public List<BaseUser> selectAllUser();

	/**
	 * 根据组织的id查询用户
	 * 
	 * @param orgId
	 *            机构ID
	 * @return 该组织下的所有用户
	 */
	public List<BaseUser> selectUserByOrg(String orgId);

	/**
	 * 根据组织的id查询用户数量
	 * 
	 * @param orgId
	 *            机构ID
	 * @return 该组织下的所有用户
	 */
	public Map<String, Object> selectUserCountByOrg(String orgId);

	/**
	 * 根据ID查用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return 用户
	 */
	public BaseUser getUserById(String userId);

	/**
	 * 保存User到Base_User表
	 * 
	 * @param bu
	 *            新用户对象
	 */
	public void saveUser(BaseUser bu);

	/**
	 * 保存User到BaseUser，base_user_2_organizatio，base_user_extend
	 * 
	 * @param user
	 *            新用户对象
	 * @throws Exception
	 *             异常
	 */
	public void addUserInfo(BaseUser user) throws Exception;

	/**
	 * 修改用户
	 * 
	 * @param user
	 *            新用户对象
	 * @throws Exception
	 *             异常
	 */
	public void editUserInfo(BaseUser user) throws Exception;

	/**
	 * 根据账号查用户
	 * 
	 * @param userAccount
	 *            用户账号
	 * @return 用户对象
	 */
	public BaseUser getUserByAccount(String userAccount);

	/**
	 * 
	 * 
	 * @Function: com.zbiti.iepe.framework.smo.UserSmo.getUserByAccounted
	 * @Description:
	 * 
	 * @param userAccount
	 * @return
	 * 
	 * @date:2014-7-28 下午5:04:31
	 * 
	 * @Modification History:
	 * @date:2014-7-28 @author:zhangx create
	 */
	public BaseUser getUserByAccounted(String userAccount);

	/**
	 * 
	 * 
	 * @Function: com.zbiti.iepe.framework.smo.UserSmo.getUserByAccounteds
	 * @Description:
	 * 
	 * @param userAccount
	 * @return
	 * 
	 * @date:2014-7-28 下午5:04:42
	 * 
	 * @Modification History:
	 * @date:2014-7-28 @author:zhangx create
	 */
	public BaseUser getUserByAccounteds(String userAccount);

	/**
	 * 根据账号查用户数量
	 * 
	 * @param userAccount
	 *            用户账号
	 * @return 用户对象
	 */
	public int getUserCountByAccount(String userAccount);

	/**
	 * 根据账号查用户
	 * 
	 * @param userAccount
	 *            用户账号
	 * @return 用户对象
	 */
	public BaseUser getUserByAccountAndSys(String userAccount, String sys);

	/**
	 * 根据公司的id查询用户
	 * 
	 * @param orgId
	 *            可以放入orgId（公司）
	 * @return 该组织下的所有用户的accountName
	 */
	public List<BaseUser> selectUserByCom(String orgId);

	/**
	 * 获取所有的用户
	 * 
	 * @return 所有的用户
	 */
	public List<BaseUser> getAllUsers();

	/**
	 * 根据组织的id,用户名查询用户
	 * 
	 * @param orgId
	 * @param userName
	 * @return
	 */
	public List<BaseUser> selectUserByOrgDim(String orgId, String userName);

	/**
	 * 根据用户的accountName查找号码以及区域ID
	 * 
	 * @author ChengKai 2014-5-4
	 * @param accountName
	 * @return
	 */
	public List<Map<String, Object>> selectPhoneAndAreaIdByAccountName(
			String accountName);

	/**
	 * 根据用户的position查找号码以及区域ID
	 * 
	 * @author ChengKai 2014-5-5
	 * @param positionId
	 * @return
	 */
	public List<Map<String, Object>> selectPhoneAndAreaIdByPositionId(
			Long positionId);

	/*
	 * 入库前检查
	 */
	public BaseUser checkUser(String Account);

	public String getTopOrgIdByAreaId(String areaId);

	public List<BaseUser> selectUserByCondTwo(HashMap<String, Object> map,
			Page page);

}