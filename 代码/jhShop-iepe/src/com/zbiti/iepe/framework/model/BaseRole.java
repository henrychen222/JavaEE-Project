package com.zbiti.iepe.framework.model;

import java.util.Date;
import java.util.List;

/**
 * 角色
 * 
 * @author zhaoqi
 * 
 */
@SuppressWarnings("all")
public class BaseRole
{
	/**
	 * 角色Id
	 */
	private String roleId; // 角色Id

	/**
	 * 角色名
	 */
	private String roleName; // 角色名

	/**
	 * 角色类型
	 */
	private String roleTypeCd; // 角色类型

	/**
	 * 角色类型
	 */
	private String roleTypeCdName; // 角色类型

	/**
	 * 创建用户
	 */
	private String createOp;// 创建用户

	/**
	 * 创建用户
	 */
	private String createOpName;

	/**
	 * 角色描述
	 */
	private String roleDesc;// 角色描述

	/**
	 * 逻辑删除
	 */
	private String isDelete;

	/**
	 * 角色注册时间
	 */
	private Date roleStartTime;// 角色注册时间（只有用户关联角色的时候可用,表示某用户对该角色的使用时限）

	/**
	 * 角色到期时间
	 */
	private Date roleEndTime;// 角色到期时间（只有用户关联角色的时候可用,表示某用户对该角色的使用时限）

	/**
	 * 角色拥有的菜单权限
	 */
	private List<BaseMenu> menuPermission;// 角色拥有的菜单权限

	/**
	 * 角色拥有的元素权限
	 */
	private List elPermission;// 角色拥有的元素权限//TODO

	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public String getRoleTypeCd()
	{
		return roleTypeCd;
	}

	public void setRoleTypeCd(String roleTypeCd)
	{
		this.roleTypeCd = roleTypeCd;
	}

	public String getCreateOp()
	{
		return createOp;
	}

	public void setCreateOp(String createOp)
	{
		this.createOp = createOp;
	}

	public String getCreateOpName()
	{
		return createOpName;
	}

	public void setCreateOpName(String createOpName)
	{
		this.createOpName = createOpName;
	}

	public String getRoleDesc()
	{
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc)
	{
		this.roleDesc = roleDesc;
	}

	public Date getRoleStartTime()
	{
		return roleStartTime;
	}

	public void setRoleStartTime(Date roleStartTime)
	{
		this.roleStartTime = roleStartTime;
	}

	public Date getRoleEndTime()
	{
		return roleEndTime;
	}

	public void setRoleEndTime(Date roleEndTime)
	{
		this.roleEndTime = roleEndTime;
	}

	public List<BaseMenu> getMenuPermission()
	{
		return menuPermission;
	}

	public void setMenuPermission(List<BaseMenu> menuPermission)
	{
		this.menuPermission = menuPermission;
	}

	public List getElPermission()
	{
		return elPermission;
	}

	public void setElPermission(List elPermission)
	{
		this.elPermission = elPermission;
	}

	public String getIsDelete()
	{
		return isDelete;
	}

	public void setIsDelete(String isDelete)
	{
		this.isDelete = isDelete;
	}

	public String getRoleTypeCdName()
	{
		return roleTypeCdName;
	}

	public void setRoleTypeCdName(String roleTypeCdName)
	{
		this.roleTypeCdName = roleTypeCdName;
	}

}
