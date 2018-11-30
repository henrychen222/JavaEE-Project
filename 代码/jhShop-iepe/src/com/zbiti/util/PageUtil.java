package com.zbiti.util;

import javax.servlet.http.HttpServletRequest;

import com.zbiti.iepe.framework.model.QueryInfo;

public class PageUtil {
	
	public static  QueryInfo QueryInfo(HttpServletRequest request) 
	{
		String currentpage=request.getParameter("currentpage");
		String pagesize=request.getParameter("pagesize");
		
		QueryInfo info=new QueryInfo();
		if(currentpage!=null&&currentpage.trim()!=null)
		{
			info.setCurrentpage(Integer.parseInt(currentpage));
		}
		if(pagesize!=null&&pagesize.trim()!=null)
		{
			info.setPagesize(Integer.parseInt(pagesize));
		}
		return info;
	
	}

}
