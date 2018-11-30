package com.zbiti.iepe.framework.model;

/**
 * 组织信息
 * 
 * @author zhaoqi
 * 
 * @modify ChengKai
 * @Date 2014-6-6
 */
public class BaseOrganization
{
	/**
	 * 组织Id
	 */
	private String orgId;

	/**
	 * 上级组织
	 */
	private String parentId; // 上级组织

	/**
	 * 组织类型
	 */
	private String orgTypeId;// 组织类型

	/**
	 * 组织类型
	 */
	private String orgTypeName;// 组织类型

	/**
	 * 组织名称
	 */
	private String orgName; // 组织名称

	/**
	 * 组织编码
	 */
	private String orgCode; // 组织编码

	/**
	 * 组织级别
	 */
	private String orgLevelCd; // 组织级别

	/**
	 * 组织级别
	 */
	private String orgLevelName; // 组织级别

	/**
	 * 显示顺序
	 */
	private String showOrderNo; // 显示顺序

	/**
	 * 是否逻辑删除
	 */
	private String isDelete; // 是否逻辑删除

	/**
	 * 机构名简称
	 */
	private String orgNameShort; // 机构名简称

	/**
	 * 机构名简称
	 */
	private String orgNameJp; // 机构名简称

	/**
	 * 父机构对象
	 */
	private BaseOrganization parentOrg;// 父机构对象
	/**
	 * 区域ID
	 * 
	 * @author ChengKai
	 * @date 2014-6-6
	 */
	private Long areaId;

	/**
	 * 机构扩展
	 */
	private BaseOrganizationExtend orgExtend;

	public BaseOrganization getParentOrg()
	{
		return parentOrg;
	}

	public void setParentOrg(BaseOrganization parentOrg)
	{
		this.parentOrg = parentOrg;
	}

	public String getOrgId()
	{
		return orgId;
	}

	public void setOrgId(String orgId)
	{
		this.orgId = orgId;
	}

	public String getParentId()
	{
		return parentId;
	}

	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}

	public String getOrgTypeId()
	{
		return orgTypeId;
	}

	public void setOrgTypeId(String orgTypeId)
	{
		this.orgTypeId = orgTypeId;
	}

	public String getOrgName()
	{
		return orgName;
	}

	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}

	public String getOrgCode()
	{
		return orgCode;
	}

	public void setOrgCode(String orgCode)
	{
		this.orgCode = orgCode;
	}

	public String getOrgLevelCd()
	{
		return orgLevelCd;
	}

	public void setOrgLevelCd(String orgLevelCd)
	{
		this.orgLevelCd = orgLevelCd;
	}

	public String getOrgLevelName()
	{
		return orgLevelName;
	}

	public void setOrgLevelName(String orgLevelName)
	{
		this.orgLevelName = orgLevelName;
	}

	public String getShowOrderNo()
	{
		return showOrderNo;
	}

	public void setShowOrderNo(String showOrderNo)
	{
		this.showOrderNo = showOrderNo;
	}

	public String getIsDelete()
	{
		return isDelete;
	}

	public void setIsDelete(String isDelete)
	{
		this.isDelete = isDelete;
	}

	public String getOrgNameShort()
	{
		return orgNameShort;
	}

	public void setOrgNameShort(String orgNameShort)
	{
		this.orgNameShort = orgNameShort;
	}

	public String getOrgNameJp()
	{
		return orgNameJp;
	}

	public void setOrgNameJp(String orgNameJp)
	{
		this.orgNameJp = orgNameJp;
	}

	public String getOrgTypeName()
	{
		return orgTypeName;
	}

	public void setOrgTypeName(String orgTypeName)
	{
		this.orgTypeName = orgTypeName;
	}

	public BaseOrganizationExtend getOrgExtend()
	{
		return orgExtend;
	}

	public void setOrgExtend(BaseOrganizationExtend orgExtend)
	{
		this.orgExtend = orgExtend;
	}

	public Long getAreaId()
	{

		return areaId;
	}

	public void setAreaId(Long areaId)
	{

		this.areaId = areaId;
	}

}
