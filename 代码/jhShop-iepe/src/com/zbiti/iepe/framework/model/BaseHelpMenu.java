package com.zbiti.iepe.framework.model;

import java.util.LinkedList;
/**
 * 帮助菜单类
 * @File:  BaseHelpMenu.java
 * @Description: 
 * @author shidiwen 
 * @date 2016年1月13日 下午4:20:26
 */
public class BaseHelpMenu
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

	private int level;
	
	private String icon;
	
	/**
	 * 菜单说明
	 */
	private String desc;// 菜单说明

	private String createTime;
	
	private int delflag;
	
	private String count;
	/**
	 * 子菜单
	 */
	private LinkedList<BaseHelpMenu> children;

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
	 * @param children
	 *            children
	 */
	public BaseHelpMenu(int menuId, String name, String title, int parentMenuId, String uri, int menuTypeCd,
			String count,int level,String icon,int menuSortCd, String desc,String createTime,int delflag,LinkedList<BaseHelpMenu> children)
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
		this.createTime = createTime;
		this.delflag = delflag;
		this.children = children;
		this.icon = icon;
		this.level = level;
		this.count = count;
	}

	/**
	 * 构造函数
	 * 
	 * @param bm
	 *            菜单
	 */
	public BaseHelpMenu(BaseHelpMenu bm)
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
		this.createTime = bm.getCreateTime();
		this.delflag = bm.getDelflag();
		this.icon = bm.getIcon();
		this.level = bm.getLevel();
		this.count = bm.getCount();
		if (bm.getChildren() != null)
		{
			this.children = new LinkedList<BaseHelpMenu>();
		}
	}

	/**
	 * 构造函数
	 */
	public BaseHelpMenu()
	{
		super();
	}

	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public LinkedList<BaseHelpMenu> getChildren()
	{
		return children;
	}

	public void setChildren(LinkedList<BaseHelpMenu> children)
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

}
