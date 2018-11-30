package com.yz.util;

import javax.servlet.http.HttpServletRequest;

import com.yz.page.QueryInfo;

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
		/*try {
			T bean = beanClass.newInstance();
			Map map = request.getParameterMap();
			ConvertUtils.register(new Converter()
			{
				public Object convert(Class type,Object value)
				{
					if(value==null)
					{
						return null;
					}
					String str = (String) value;
					if(str.trim().equals(""))
					{
						return null;
					}
					
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
						try {
							return df.parse(str);
						} catch (ParseException e) {
							throw new RuntimeException(e);
						}					
				}
				
			},Date.class);		
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}*/
	
	}

}
