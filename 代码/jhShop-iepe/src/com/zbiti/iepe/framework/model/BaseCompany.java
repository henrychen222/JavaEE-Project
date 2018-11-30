package com.zbiti.iepe.framework.model;

import java.util.Date;

public class BaseCompany {
	private int id;
	private int hostId;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	private String name;
	private String address;
	private int range;
	private String nature;
	private String application1;
	private String application2;
	private String application3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
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

}
