package com.orm;

public class Thuifu {
	private String id;

	private String content;
	private String shijian;
	private String shoujianren; 
	private String user_id;
	private Tuser user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShijian() {
		return shijian;
	}
	public void setShijian(String shijian) {
		this.shijian = shijian;
	}
	public String getShoujianren() {
		return shoujianren;
	}
	public void setShoujianren(String shoujianren) {
		this.shoujianren = shoujianren;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	public Tuser getUser() {
		return user;
	}
	public void setUser(Tuser user) {
		this.user = user;
	}
	
}
