package cn.xd.po;

import java.util.*;

/**
 * <b>”√ªß</b>
 * @author y.you
 * @see
 * @since 2016-03-15
 * 
 */
public class User {
	private String id;
	private String name;
	private String password;
	private String realname;
	private String phone;
	private String email;
	private String address;
	private Date  createtime;
	public String getId() {
		return id;
	} 
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String  email) {
		this. email =  email;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", realname=" + realname + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", createtime=" + createtime
				+ "]";
	}

}
