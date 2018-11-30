package com.yz.domain;

import java.util.Date;

public class Orders {
	private String ordernumber;
	private int productid;
	private String imagepath;
	private String seller;
	private String purchaser;
	private String buyertetlphone;
	private String address;
	private String trading;
	private float amount; 
	private String orderstatus;
	private Date placeordertime;
	private String explains;
	private String productname;//生成订单时需要用
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public String getBuyertetlphone() {
		return buyertetlphone;
	}
	public void setBuyertetlphone(String buyertetlphone) {
		this.buyertetlphone = buyertetlphone;
	}
	public String getTrading() {
		return trading;
	}
	public void setTrading(String trading) {
		this.trading = trading;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getOrderStatus() {
		return orderstatus;
	}
	public void setOrderStatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public Date getPlaceordertime() {
		return placeordertime;
	}
	public void setPlaceordertime(Date placeordertime) {
		this.placeordertime = placeordertime;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
}
