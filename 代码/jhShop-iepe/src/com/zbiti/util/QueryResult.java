package com.zbiti.util;

import java.util.List;

public class QueryResult {
	
	@SuppressWarnings("rawtypes")
	private List list;
	private int totalrecord;//总数记录
	
	 
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	

}
