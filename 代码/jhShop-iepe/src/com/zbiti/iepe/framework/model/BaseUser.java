package com.zbiti.iepe.framework.model;

import java.util.Date;
import java.util.List;

/**
 * 用户Bean
 * 
 * @author zhaoqi
 * 
 */
@SuppressWarnings("all")
public class BaseUser {
	/**
	 * 用户ID
	 */
	private String userId; // 用户ID

	/**
	 * 用户姓名
	 */
	private String userName; // 用户姓名

	/**
	 * 机构姓名
	 */
	private String orgName; // 机构姓名

	/**
	 * 账号
	 */
	private String accountName; // 账号

	/**
	 * 密码
	 */
	private String accountPasswordCd; // 密码

	/**
	 * 用户状态
	 */
	private String userStateCd; // 用户状态

	/**
	 * 显示顺序
	 */
	private String showOrderNo; // 显示顺序

	/**
	 * 是否逻辑删除
	 */
	private String isDelete; // 是否逻辑删除

	/**
	 * 身份证号
	 */
	private String identityId; // 身份证号

	/**
	 * 性别
	 */
	private String gender; // 性别

	/**
	 * 年龄
	 */
	private String age; // 年龄

	/**
	 * 联系电话
	 */
	private String phoneNumber; // 联系电话

	/**
	 * EMAIL
	 */
	private String email; // EMAIL

	/**
	 * 描述
	 */
	private String description;// 描述

	/**
	 * 用户所属机构
	 */
	private BaseOrganization org;// 用户所属机构

	/**
	 * 用户所属公司
	 */
	private BaseOrganization company;// 用户所属公司

	/**
	 * 用户拥有的角色
	 */
	private List<BaseRole> roles;// 用户拥有的角色

	/**
	 * 用户拥有的数据维度权限
	 */
	private List dataPermission;// 用户拥有的数据维度权限

	/**
	 * 用户注册岗位时间
	 */
	private Date createTime;// 用户注册岗位时间

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 用户扩展
	 */
	private BaseUserExtend userExtend;

	public List<BaseRole> getRoles() {
		return roles;
	}

	public void setRoles(List<BaseRole> roles) {
		this.roles = roles;
	}

	public List getDataPermission() {
		return dataPermission;
	}

	public void setDataPermission(List dataPermission) {
		this.dataPermission = dataPermission;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPasswordCd() {
		return accountPasswordCd;
	}

	public void setAccountPasswordCd(String accountPasswordCd) {
		this.accountPasswordCd = accountPasswordCd;
	}

	public String getUserStateCd() {
		return userStateCd;
	}

	public void setUserStateCd(String userStateCd) {
		this.userStateCd = userStateCd;
	}

	public String getShowOrderNo() {
		return showOrderNo;
	}

	public void setShowOrderNo(String showOrderNo) {
		this.showOrderNo = showOrderNo;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getIdentityId() {
		return identityId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public BaseOrganization getOrg() {
		return org;
	}

	public void setOrg(BaseOrganization org) {
		this.org = org;
	}

	public BaseUserExtend getUserExtend() {
		return userExtend;
	}

	public void setUserExtend(BaseUserExtend userExtend) {
		this.userExtend = userExtend;
	}

	public BaseOrganization getCompany() {
		return company;
	}

	public void setCompany(BaseOrganization company) {
		this.company = company;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
