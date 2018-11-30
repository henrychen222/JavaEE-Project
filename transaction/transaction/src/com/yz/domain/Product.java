package com.yz.domain;

import java.util.Date;

public class Product {

	private int id;
	private String name;
	private float originalprice;
	private float price;
	private String description;
	private String uploadimage;
	private String category;//在上传图片里用到
	private int  categoryID;
	private int clickcount; 
	private String status;
	private String trading;
	private Date createtime ;
	private Date updatetime ;
	private String publisher;
	private String purchaser;
	//查看宝贝详细时用到
	private String realname;
	private String address;
	private String phone;
	

	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getOriginalprice() {
		return originalprice;
	}
	public void setOriginalprice(float originalprice) {
		this.originalprice = originalprice;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float d) {
		this.price = d;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUploadImage() {
		return uploadimage;
	}
	public void setUploadImage(String uploadimage) {
		this.uploadimage = uploadimage;
	}
	public int getCategoryID() {                         
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getClickcount() {
		return clickcount;
	}
	public void setClickcount(int clickcount) {
		this.clickcount = clickcount;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTrading() {
		return trading;
	}
	public void setTrading(String trading) {
		this.trading = trading;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
