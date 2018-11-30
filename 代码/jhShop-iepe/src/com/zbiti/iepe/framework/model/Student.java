package com.zbiti.iepe.framework.model;

import java.util.Date;

public class Student {

	private int student_registration_id;
	private String student_number;
	private String student_name;
	private String college_name;
	private String class_name;
	private String gender;
	private Date createTime;
	private Date updateTime;
	private Date deleteTime;
	private int deleteUser;
	private int deleteFlage;
	
	public int getStudent_registration_id() {
		return student_registration_id;
	}
	public void setStudent_registration_id(int student_registration_id) {
		this.student_registration_id = student_registration_id;
	}
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public int getDeleteUser() {
		return deleteUser;
	}
	public void setDeleteUser(int deleteUser) {
		this.deleteUser = deleteUser;
	}
	public int getDeleteFlage() {
		return deleteFlage;
	}
	public void setDeleteFlage(int deleteFlage) {
		this.deleteFlage = deleteFlage;
	}
	
}
