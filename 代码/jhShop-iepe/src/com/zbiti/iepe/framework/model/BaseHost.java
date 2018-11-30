package com.zbiti.iepe.framework.model;

import java.util.Date;

public class BaseHost {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public BaseCompany getComType() {
		return comType;
	}
	public void setComType(BaseCompany comType) {
		this.comType = comType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getDeleteFlage() {
		return deleteFlage;
	}
	public void setDeleteFlage(String deleteFlage) {
		this.deleteFlage = deleteFlage;
	}
	public String getDeleteUsers() {
		return deleteUsers;
	}
	public void setDeleteUsers(String deleteUsers) {
		this.deleteUsers = deleteUsers;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getApplication1() {
		return application1;
	}
	public void setApplication1(String application1) {
		this.application1 = application1;
	}
	public String getApplication2() {
		return application2;
	}
	public void setApplication2(String application2) {
		this.application2 = application2;
	}
	public String getApplication3() {
		return application3;
	}
	public void setApplication3(String application3) {
		this.application3 = application3;
	}
	private int id;
	private String remark;
	private String filepath;
	private String code;
	private BaseCompany comType;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	private String deleteFlage;
	private String deleteUsers;
	private String view;
	private String model;
	private String application1;
	private String application2;
	private String application3;
	public BaseHost() {
		super();
		// TODO Auto-generated constructor stub
	}

}
