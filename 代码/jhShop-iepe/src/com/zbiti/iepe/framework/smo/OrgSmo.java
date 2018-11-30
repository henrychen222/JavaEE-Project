package com.zbiti.iepe.framework.smo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.model.BaseOrganization;
import com.zbiti.iepe.framework.model.BaseOrganizationLocationCode;
import com.zbiti.iepe.framework.model.BaseUserRoleCode;

/**
 * 机构服务层
 * 
 * @author zhaoqi
 * 
 */
public interface OrgSmo {
	/**
	 * 获取所有机构
	 * 
	 * @return 所有机构列表
	 */
	public List<BaseOrganization> getAllOrgs();

	/**
	 * 根据ORG_ID查机构详细
	 * 
	 * @param orgId
	 *            机构ID
	 * @return 机构对象
	 */
	public BaseOrganization getOrgById(String orgId);

	/**
	 * 根据父机构ID查机构列表
	 * 
	 * @param orgId
	 *            父机构ID
	 * @param page
	 *            分页对象（分页必须）
	 * @return 机构列表
	 */
	public List<BaseOrganization> getOrgByParentId(String orgId, Page page);

	/**
	 * 根据父机构ID查机构列表
	 * 
	 * @param map
	 *            参数对象
	 * @param page
	 *            分页对象（分页必须）
	 * @return 机构列表
	 */
	public List<BaseOrganization> getOrgByParentId(Map<String, Object> map,
			Page page);

	/**
	 * 保存机构
	 * 
	 * @param bo
	 *            新机构对象
	 */
	public void saveOrg(BaseOrganization bo);

	/**
	 * 查用户所属机构
	 * 
	 * @param userId
	 *            用户ID
	 * @return 用户所属机构对象
	 */
	public BaseOrganization getOrgByUser(String userId);

	/**
	 * 机构类型
	 * 
	 * @return 机构类别
	 */
	public List<HashMap<String, String>> getOrgType();

	/**
	 * 获取子机构
	 * 
	 * @param orgId
	 *            父机构ID
	 * @return 所有子机构列表
	 */
	public LinkedList<BaseOrganization> getOrgByParentId(String orgId);

	/**
	 * 获取父机构
	 * 
	 * @param showId
	 *            机构ID
	 * @return 递归查出的所有父机构对象
	 */
	public LinkedList<BaseOrganization> getParentsByOrgId(String showId);

	/**
	 * 根据机构编码得到机构
	 * 
	 * @param orgCode
	 *            机构编码
	 * @return 机构对象
	 */
	public BaseOrganization getOrgByOrgCode(String orgCode);

	/**
	 * 获取机构所在的公司
	 * 
	 * @param orgId
	 *            机构
	 * @return 公司
	 */
	public BaseOrganization getCompanyByOrg(String orgId);

	/**
	 * 根据用户的userId获取所在的地区编码
	 * 
	 * @param userId
	 * @return
	 */
	public BaseOrganizationLocationCode getUserLocationCode(String userId);

	/**
	 * 根据用户的userId获取角色類型
	 * 
	 * @param userId
	 * @return
	 */
	public BaseUserRoleCode getUserRoleCode(String roleTypeCd);

	/**
	 * 获取子机构
	 * 
	 * @param orgId
	 *            父机构ID
	 * @return 所有子机构列表
	 */
	public LinkedList<BaseOrganization> getOrgByParentIdU(String orgId);

	/**
	 * 根据获取子机构
	 * 
	 * @param orgId
	 *            父机构ID
	 * @param userName
	 *            用户名
	 * @return 所有子机构列表
	 */
	public LinkedList<BaseOrganization> getOrgByParentIdDim(String orgId,
			String userName);

	/**
	 * 获取子机构
	 * 
	 * @param orgId
	 *            父机构ID
	 * @return 所有子机构列表
	 */
	public LinkedList<BaseOrganization> getOrgByParentIdP(String orgId);

	/**
	 * 根据获取子机构
	 * 
	 * @param orgId
	 *            父机构ID
	 * @param positionName
	 *            岗位名
	 * @return 所有子机构列表
	 */
	public LinkedList<BaseOrganization> getOrgByParentIdPDim(String orgId,
			String positionName);

	public List<BaseOrganization> getAuthorOrg(Map<String, String> paramMap);

	/**
	 * 获取所有子机构id
	 * 
	 * @param parentOrgId
	 * @return
	 */
	public List<String> getAllChildrenOrgId(String orgId);

}