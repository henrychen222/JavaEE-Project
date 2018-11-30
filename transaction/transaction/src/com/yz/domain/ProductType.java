package com.yz.domain;

public class ProductType {

	private String id;
	private String name;
	private int level;
	private int pid;
	
	private int amount;//一级大类的总数
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	} 
	private int secondamount;//二级大类的各类总数
	public int getSecondamount() {
		return secondamount;
	}
	public void setSecondamount(int secondamount) {
		this.secondamount = secondamount;
	}
	private int threeamount;//三级大类的总数
	public int getThreeamount() {
		return threeamount;
	}
	public void setThreeamount(int threeamount) {
		this.threeamount = threeamount;
	}
	
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

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
