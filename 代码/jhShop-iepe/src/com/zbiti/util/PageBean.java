package com.zbiti.util;
import java.util.List;

public class PageBean {
	@SuppressWarnings("rawtypes")
	private List list;//查询对象以list集合储存
	private int totalrecord;//总记录数
	private int pagesize;//每页多少条记录
	private int totalpage;//总页数
	private int currentpage;//当前页数
	private int previouspage;//前一页 
	private int nextpage;//下一页
	private int[] pagebar;//页码
		
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
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {
		
		if(this.totalrecord%this.pagesize==0)
		{
			this.totalpage = this.totalrecord/this.pagesize;
		}
		else{
			this.totalpage = this.totalrecord/this.pagesize+1;
		}
		
		return totalpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
			this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if(this.currentpage<=1){
			this.previouspage = 1;
		}
		else{
			this.previouspage = this.currentpage-1;
		}	
		return previouspage;
	}
	public int getNextpage() {
		
		if(this.currentpage>=this.totalpage){
			this.nextpage = this.totalpage;
		}
		else{
			this.nextpage = this.currentpage+1;
		}
		
		return nextpage;
	}
	public int[] getPagebar() {
		int startpage;
		int endpage;
		int pagebar[] = null;
		if(this.totalpage<=10)
		{
			pagebar = new int[this.totalpage];
			startpage = 1;
			endpage = this.totalpage;
		}else{
			pagebar = new int[10];
			startpage = this.currentpage - 4;
			endpage = this.currentpage + 5;
		if(startpage<1){
			startpage=1;
			endpage=10;
		}
		if(endpage>this.totalpage){
			endpage = this.totalpage;
			startpage = this.totalpage - 9;
		}
	}		
		int index = 0;
		for(int i =startpage;i<=endpage;i++)
		{
			pagebar[index++] = i;
		}
		this.pagebar = pagebar;
		return this.pagebar;
	}	
}
