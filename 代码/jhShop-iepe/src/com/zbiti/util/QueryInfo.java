package com.zbiti.util;

public class QueryInfo {
	
	private int currentpage=1;//默认起始页数
	private int pagesize=20;//默认每页20条记录
	private int startindex;//根据页数和每页的记录条数算出查询的起始位置
	
	
	public int getCurrentpage() {
		return currentpage;
	} 
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartindex() {
		this.startindex=(this.currentpage-1)*this.pagesize;
		return startindex;
	}
	
	
	

}
