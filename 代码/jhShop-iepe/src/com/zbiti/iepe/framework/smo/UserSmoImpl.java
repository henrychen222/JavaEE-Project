package com.zbiti.iepe.framework.smo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.dao.OrgDao;
import com.zbiti.iepe.framework.dao.UserDao;
import com.zbiti.iepe.framework.model.BaseOrganization;
import com.zbiti.iepe.framework.model.BaseUser;
import com.zbiti.iepe.framework.model.BaseUserExtend;

/**
 * 用户服务层
 * 
 * @author zhaoqi
 * 
 */
@Service(value = "userSmoImpl")
public class UserSmoImpl implements UserSmo {

	/**
	 * 用户持久层对象
	 */
	@Resource
	private UserDao userDao;

	/**
	 * 机构持久层
	 */
	@Resource
	private OrgDao orgDao;

	@Override
	public List<BaseUser> selectUserByCond(HashMap<String, Object> map,
			Page page) {
		List<BaseUser> baseUsers = userDao.selectUserByCondlistPage(map);
		if (baseUsers != null) {
			for (BaseUser bu : baseUsers) {
				BaseOrganization bo = orgDao.getOrgById(bu.getOrg().getOrgId());
				bu.setOrg(bo);
			}
		}
		return baseUsers;
	}

	/**
	 * 查询所用用户
	 * 
	 * @return 所用用户
	 */
	public List<BaseUser> selectAllUser() {
		return userDao.selectAllUser();
	}

	/**
	 * 根据组织的id查询用户
	 * 
	 * @param orgId
	 *            可以放入orgId（包括公司和部门）
	 * @return 该组织下的所有用户accountName
	 */
	@Override
	public List<BaseUser> selectUserByOrg(String orgId) {
		return userDao.selectUserByOrg(orgId);
	}

	@Override
	public Map<String, Object> selectUserCountByOrg(String orgId) {
		return userDao.selectUserCountByOrg(orgId);
	}

	@Override
	public BaseUser getUserById(String userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public void saveUser(BaseUser bu) {
		userDao.saveUser(bu);
	}

	/*wangyan modified @ 151117 ZBITI_2015_RJ(2)_KF002-N-353 原来的新增user的时候mapper里面的写法错误，
	 * 没有把userid带出来，导致后面插入权限报错。*/
	@Override
	@Transactional
	public void addUserInfo(BaseUser user) throws Exception {
		try {
			// 保存到base_user
			userDao.addUser(user);
			// userDao.addUserExtends(user);

			// 用户扩展信息
			BaseUserExtend userExtend = user.getUserExtend();
			if (userExtend != null) {
				List<Map<String, String>> extedsProperties = new ArrayList<Map<String, String>>();
				Map<String, String> kv = userExtend.toMap();
				if (kv != null && kv.size() > 0) {
					Iterator<String> it = kv.keySet().iterator();
					while (it.hasNext()) {
						Map<String, String> m = new HashMap<String, String>();
						m.put("userId", String.valueOf(user.getUserId()));
						String key = it.next();
						m.put("propCode", key);
						m.put("propValue", kv.get(key));
						extedsProperties.add(m);
					}

					if (extedsProperties != null && extedsProperties.size() > 0) {
						userDao.saveUserExtends(extedsProperties);

					}
				}
			}
			userDao.addUser2Org(user);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public void editUserInfo(BaseUser user) throws Exception {
		// 保存到base_user
		try {
			userDao.editUser(user);
			userDao.editUser2Org(user);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public BaseUser getUserByAccount(String userAccount) {
		BaseUser bu = userDao.getUserByAccount(userAccount);
		return bu;
	}

	@Override
	public BaseUser getUserByAccounted(String userAccount) {
		BaseUser bu = userDao.getUserByAccounted(userAccount);
		return bu;
	}

	@Override
	public BaseUser getUserByAccounteds(String userAccount) {
		BaseUser bu = userDao.getUserByAccounteds(userAccount);
		return bu;
	}

	@Override
	public int getUserCountByAccount(String userAccount) {
		int count = userDao.getUserCountByAccount(userAccount);
		return count;
	}

	@Override
	public BaseUser getUserByAccountAndSys(String userAccount, String sys) {
		BaseUser bu = userDao.getUserByAccountAndSys(userAccount, sys);
		return bu;
	}

	/**
	 * 根据公司的id查询用户
	 * 
	 * @param orgId
	 *            可以放入orgId（公司）
	 * @return 该组织下的所有用户的accountName
	 */
	public List<BaseUser> selectUserByCom(String orgId) {
		return userDao.selectUserByCom(orgId);
	}

	@Override
	public List<BaseUser> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<BaseUser> selectUserByOrgDim(String orgId, String userName) {
		return userDao.selectUserByOrgDim(orgId, userName);
	}

	@Override
	public List<Map<String, Object>> selectPhoneAndAreaIdByAccountName(
			String accountName) {
		return userDao.selectPhoneAndAreaIdByAccountName(accountName);
	}

	@Override
	public List<Map<String, Object>> selectPhoneAndAreaIdByPositionId(
			Long positionId) {
		return userDao.selectPhoneAndAreaIdByPositionId(positionId);
	}

	@Override
	public BaseUser checkUser(String Account) {

		return userDao.checkUser(Account);
	}

	@Override
	public String getTopOrgIdByAreaId(String areaId) {
		return userDao.getTopOrgIdByAreaId(areaId);

	}

	@Override
	public List<BaseUser> selectUserByCondTwo(HashMap<String, Object> map,
			Page page) {
		List<BaseUser> baseUsers = userDao.selectUserByCondTwolistPage(map);
		if (baseUsers != null) {
			for (BaseUser bu : baseUsers) {
				BaseOrganization bo = orgDao.getOrgById(bu.getOrg().getOrgId());
				bu.setOrg(bo);
			}
		}
		return baseUsers;
	}

}
