package com.zbiti.iepe.framework.model;

import java.util.LinkedList;

/**
 * 菜单
 * 
 * @author zhaoqi
 * 
 */
public class BaseMenu
{
	/**
	 * 菜单ID
	 */
	private int menuId; // 菜单ID

	/**
	 * 菜单名称
	 */
	private String name;// 菜单名称

	/**
	 * 菜单显示名称
	 */
	private String title;// 菜单显示名称

	/**
	 * 父级菜单
	 */
	private int parentMenuId; // 父级菜单

	/**
	 * uri
	 */
	private String uri;// uri

	/**
	 * 菜单类型
	 */
	private int menuTypeCd;// 菜单类型

	/**
	 * 菜单排序
	 */
	private int menuSortCd;// 菜单排序

	/**
	 * 菜单说明
	 */
	private String desc;// 菜单说明

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 子菜单
	 */
	private LinkedList<BaseMenu> children;

	/**
	 * 构造函数
	 * 
	 * @param menuId
	 *            menuId
	 * @param name
	 *            name
	 * @param title
	 *            title
	 * @param parentMenuId
	 *            parentMenuId
	 * @param uri
	 *            uri
	 * @param menuTypeCd
	 *            menuTypeCd
	 * @param menuSortCd
	 *            menuSortCd
	 * @param desc
	 *            desc
	 * @param icon
	 *            icon
	 * @param children
	 *            children
	 */
	public BaseMenu(int menuId, String name, String title, int parentMenuId, String uri, int menuTypeCd,
			int menuSortCd, String desc, String icon, LinkedList<BaseMenu> children)
	{
		super();
		this.menuId = menuId;
		this.name = name;
		this.title = title;
		this.parentMenuId = parentMenuId;
		this.uri = uri;
		this.menuTypeCd = menuTypeCd;
		this.menuSortCd = menuSortCd;
		this.desc = desc;
		this.icon = icon;
		this.children = children;
	}

	/**
	 * 构造函数
	 * 
	 * @param bm
	 *            菜单
	 */
	public BaseMenu(BaseMenu bm)
	{
		super();
		this.menuId = bm.getMenuId();
		this.name = bm.getName();
		this.title = bm.getTitle();
		this.parentMenuId = bm.getParentMenuId();
		this.uri = bm.getUri();
		this.menuTypeCd = bm.getMenuTypeCd();
		this.menuSortCd = bm.getMenuSortCd();
		this.desc = bm.getDesc();
		this.icon = bm.getIcon();
		if (bm.getChildren() != null)
		{
			this.children = new LinkedList<BaseMenu>();
		}
	}

	/**
	 * 构造函数
	 */
	public BaseMenu()
	{
		super();
	}

	public LinkedList<BaseMenu> getChildren()
	{
		return children;
	}

	public void setChildren(LinkedList<BaseMenu> children)
	{
		this.children = children;
	}

	public int getMenuId()
	{
		return menuId;
	}

	public void setMenuId(int menuId)
	{
		this.menuId = menuId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getParentMenuId()
	{
		return parentMenuId;
	}

	public void setParentMenuId(int parentMenuId)
	{
		this.parentMenuId = parentMenuId;
	}

	public String getUri()
	{
		return uri;
	}

	public void setUri(String uri)
	{
		this.uri = uri;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public int getMenuTypeCd()
	{
		return menuTypeCd;
	}

	public void setMenuTypeCd(int menuTypeCd)
	{
		this.menuTypeCd = menuTypeCd;
	}

	public int getMenuSortCd()
	{
		return menuSortCd;
	}

	public void setMenuSortCd(int menuSortCd)
	{
		this.menuSortCd = menuSortCd;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

}
