package com.zbiti.iepe.framework.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.core.dto.Page;
import com.zbiti.iepe.framework.model.BaseOrganization;
import com.zbiti.iepe.framework.model.BaseOrganizationLocationCode;
import com.zbiti.iepe.framework.model.BaseUserRoleCode;

/**
 * 组织架构持久层
 * 
 * @author zhaoqi
 * 
 */
public interface OrgDao {
	/**
	 * 获取所有组织架构
	 * 
	 * @return List
	 */
	public List<BaseOrganization> getAllOrgs();

	/**
	 * 根据主键查机构
	 * 
	 * @param orgId
	 *            主键
	 * @return 机构
	 */
	public BaseOrganization getOrgById(@Param("orgId") String orgId);

	/**
	 * 根据父机构查机构
	 * 
	 * @param orgId
	 *            父机构
	 * @param page
	 *            分页对象
	 * @return List
	 */
	public List<BaseOrganization> getOrgByParentIdlistPage(
			@Param("orgId") String orgId, @Param("page") Page page);

	/**
	 * 根据父机构查机构
	 * 
	 * @param map
	 *            参数
	 * @param page
	 *            分页对象
	 * @return List
	 */
	public List<BaseOrganization> getOrgByParentIdTwolistPage(
			@Param("map") Map<String, Object> map, @Param("page") Page page);

	/**
	 * 保存机构
	 * 
	 * @param bo
	 *            机构
	 */
	public void saveOrg(BaseOrganization bo);

	/**
	 * 查用户机构
	 * 
	 * @param userId
	 *            用户
	 * @return 机构
	 */
	public BaseOrganization getOrgByUser(@Param("userId") String userId);

	/**
	 * 机构类型
	 * 
	 * @return 机构类型
	 */
	public List<HashMap<String, String>> getOrgType();

	/**
	 * 获取子机构
	 * 
	 * @param orgId
	 *            机构
	 * @return 子机构
	 */
	public LinkedList<BaseOrganization> getOrgByParentId(
			@Param("orgId") String orgId);

	/**
	 * 根据机构编码得到机构
	 * 
	 * @param orgCode
	 *            机构编码
	 * @return 机构
	 */
	public BaseOrganization getOrgByOrgCode(@Param("orgCode") String orgCode);

	/**
	 * 更新机构
	 * 
	 * @param bo
	 *            机构
	 */
	public void updateOrg(BaseOrganization bo);

	/**
	 * 获取机构所在公司
	 * 
	 * @param orgId
	 *            机构
	 * @return 所在公司
	 */
	public BaseOrganization getCompanyByOrg(@Param("orgId") String orgId);

	/**
	 * 根据userId获取用户所在地区的code
	 * 
	 * @param userId
	 * @return
	 */
	public BaseOrganizationLocationCode getUserLocationCode(
			@Param("userId") String userId);

	/**
	 * 根据userId获取用户的角色等级
	 * 
	 * @param userId
	 * @return
	 */
	public BaseUserRoleCode getUserRoleCode(
			@Param("roleTypeCd") String roleTypeCd);

	/**
	 * 获取子机构
	 * 
	 * @param orgId
	 *            机构
	 * @return 子机构
	 */
	public LinkedList<BaseOrganization> getOrgByParentIdU(
			@Param("orgId") String orgId);

	/**
	 * 获取子机构
	 * 
	 * @param orgId
	 *            机构
	 * @param userName
	 *            用户名
	 * @return 子机构
	 */
	public LinkedList<BaseOrganization> getOrgByParentIdDim(
			@Param("orgId") String orgId, @Param("userName") String userName);

	/**
	 * 获取子机构
	 * 
	 * @param orgId
	 *            机构
	 * @return 子机构
	 */
	public LinkedList<BaseOrganization> getOrgByParentIdP(
			@Param("orgId") String orgId);

	/**
	 * 获取子机构
	 * 
	 * @param orgId
	 *            机构
	 * @param positionName
	 *            岗位名
	 * @return 子机构
	 */
	public LinkedList<BaseOrganization> getOrgByParentIdPDim(
			@Param("orgId") String orgId,
			@Param("positionName") String positionName);

	public List<BaseOrganization> getAuthorOrg(Map<String, String> paramMap);

	public List<String> getChildrenOrgIds(@Param("orgId") String orgId);

	/**
	 * 传入多个OrgId，返回他们所有的子节点。
	 */
	public List<String> getChildrenOrgIdByParentIds(
			@Param("orgIds") List<String> orgIds);

	/**
	 * 传入多个OrgId，返回他们所有组织对象。
	 */
	public LinkedList<BaseOrganization> getOrgByOrgIds(
			@Param("orgIds") List<String> orgIds);

}