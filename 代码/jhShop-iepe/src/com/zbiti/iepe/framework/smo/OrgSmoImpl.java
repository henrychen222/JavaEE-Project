package com.zbiti.iepe.framework.smo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.dao.OrgDao;
import com.zbiti.iepe.framework.model.BaseOrganization;
import com.zbiti.iepe.framework.model.BaseOrganizationExtend;
import com.zbiti.iepe.framework.model.BaseOrganizationLocationCode;
import com.zbiti.iepe.framework.model.BaseUserRoleCode;

/**
 * 机构服务层
 * 
 * @author zhaoqi
 * 
 */
@Service
public class OrgSmoImpl implements OrgSmo {
	/**
	 * 机构持久对象
	 */
	@Resource
	private OrgDao orgDao;

	@Override
	public List<BaseOrganization> getAllOrgs() {
		return orgDao.getAllOrgs();
	}

	@Override
	public BaseOrganization getOrgById(String orgId) {
		BaseOrganization bo = orgDao.getOrgById(orgId);

		return bo;
	}

	@Override
	public List<BaseOrganization> getOrgByParentId(String orgId, Page page) {
		return orgDao.getOrgByParentIdlistPage(orgId, page);
	}

	@Override
	public List<BaseOrganization> getOrgByParentId(Map<String, Object> map,
			Page page) {
		return orgDao.getOrgByParentIdTwolistPage(map, page);
	}

	@Override
	public void saveOrg(BaseOrganization bo) {
		BaseOrganization bo1 = new BaseOrganization();
		if (bo.getOrgId() != null && !"".equals(bo.getOrgId())) {
			bo1 = orgDao.getOrgById(bo.getOrgId());
		}

		if (bo1 == null || bo1.getOrgId() == null || "".equals(bo1.getOrgId())) {
			// 若不存在机构
			orgDao.saveOrg(bo);

			BaseOrganizationExtend boe = bo.getOrgExtend();

			List<Map<String, String>> extedsProperties = new ArrayList<Map<String, String>>();
			if (boe != null) {
				Map<String, String> kV = boe.toMap();

				if (kV != null && kV.size() > 0) {
					Iterator<String> it = kV.keySet().iterator();
					while (it.hasNext()) {
						Map<String, String> m = new HashMap<String, String>();
						m.put("orgId", bo.getOrgId());
						String key = it.next();
						m.put("propCode", key);
						m.put("propValue", kV.get(key));
						extedsProperties.add(m);
					}
				}
			}
			if (extedsProperties != null && extedsProperties.size() > 0) {
				// orgDao.saveOrgExtends(extedsProperties);
			}
		} else {
			orgDao.updateOrg(bo);
			BaseOrganizationExtend boe = bo.getOrgExtend();

			if (boe != null) {
				Map<String, String> kV = boe.toMap();

				if (kV != null && kV.size() > 0) {
					Iterator<String> it = kV.keySet().iterator();
					while (it.hasNext()) {
						Map<String, String> m = new HashMap<String, String>();
						m.put("orgId", bo.getOrgId());
						String key = it.next();
						m.put("propCode", key);
						m.put("propValue", kV.get(key));
						// orgDao.updateOrgExtends(m);
					}
				}
			}

		}

	}

	@Override
	public BaseOrganization getOrgByUser(String userId) {
		return orgDao.getOrgByUser(userId);
	}

	@Override
	public List<HashMap<String, String>> getOrgType() {
		return orgDao.getOrgType();
	}

	@Override
	public LinkedList<BaseOrganization> getOrgByParentId(String orgId) {
		return orgDao.getOrgByParentId(orgId);
	}

	@Override
	public LinkedList<BaseOrganization> getParentsByOrgId(String orgId) {
		LinkedList<String> orgIds = new LinkedList<String>();
		orgIds.add(orgId);
		BaseOrganization bo;
		while (orgId != null) {
			bo = orgDao.getOrgById(orgId);
			orgId = bo.getParentId();
			orgIds.add(orgId);
		}
		return orgDao.getOrgByOrgIds(orgIds);
	}

	@Override
	public BaseOrganization getOrgByOrgCode(String orgCode) {
		return orgDao.getOrgByOrgCode(orgCode);
	}

	@Override
	public BaseOrganization getCompanyByOrg(String orgId) {
		return orgDao.getCompanyByOrg(orgId);
	}

	@Override
	public BaseOrganizationLocationCode getUserLocationCode(String userId) {
		return orgDao.getUserLocationCode(userId);
	}

	@Override
	public BaseUserRoleCode getUserRoleCode(String roleTypeCd) {
		return orgDao.getUserRoleCode(roleTypeCd);
	}

	@Override
	public LinkedList<BaseOrganization> getOrgByParentIdU(String orgId) {
		return orgDao.getOrgByParentIdU(orgId);
	}

	@Override
	public LinkedList<BaseOrganization> getOrgByParentIdDim(String orgId,
			String userName) {
		return orgDao.getOrgByParentIdDim(orgId, userName);
	}

	@Override
	public LinkedList<BaseOrganization> getOrgByParentIdP(String orgId) {
		return orgDao.getOrgByParentIdP(orgId);
	}

	@Override
	public LinkedList<BaseOrganization> getOrgByParentIdPDim(String orgId,
			String positionName) {
		return orgDao.getOrgByParentIdPDim(orgId, positionName);
	}

	@Override
	public List<BaseOrganization> getAuthorOrg(Map<String, String> paramMap) {
		return orgDao.getAuthorOrg(paramMap);
	}

	@Override
	public List<String> getAllChildrenOrgId(String orgId) {
		List<String> listOrgIds = new ArrayList<String>();
		listOrgIds.add(orgId);
		List<String> listParentIds = new ArrayList<String>();
		listParentIds.add(orgId);
		while (listParentIds.size() > 0) {
			List<String> result = orgDao
					.getChildrenOrgIdByParentIds(listParentIds);
			listParentIds.clear();
			for (String orgId1 : result) {
				listParentIds.add(orgId1);
				listOrgIds.add(orgId1);
			}
		}
		return listOrgIds;
	}

}
