package com.jd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;


/**
 * <p>把request请求中所带参数封装为相应的对象</p>
 * <p>使用方法如下：</p>
 * <p>User u = WebUtils.request2Bean(request, User.class)</p>
 * @author y.you
 * @date 2016年4月6日
 * @version：v1.0
 */
public class ControllerUtil {
	
	@SuppressWarnings("rawtypes")
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass)
	{
		try {
			T bean = beanClass.newInstance();
			//获取request中的数据
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
				//处理日期格式数据	
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
		}
	}	
}