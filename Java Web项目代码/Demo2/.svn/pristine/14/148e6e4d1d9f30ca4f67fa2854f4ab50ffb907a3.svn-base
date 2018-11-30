package com.jd.util;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
@SuppressWarnings("all")
public class MapUtil {

	
	public static Map getParameterValue(HttpServletRequest request){
		Map map = new HashMap();
		Enumeration<String> paraNames=request.getParameterNames();
		for(Enumeration e=paraNames;e.hasMoreElements();){
		       String thisName=e.nextElement().toString();
		       String thisValue;
		       try {
				thisValue= java.net.URLDecoder.decode(request.getParameter(thisName),"UTF-8");
				map.put(thisName, thisValue);
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return map;
	}
	
	public static Map getParamterValues(HttpServletRequest request){
		Map map = new HashMap();
		Enumeration<String> paraNames=request.getParameterNames();
		for(Enumeration e=paraNames;e.hasMoreElements();){
		       String thisName=e.nextElement().toString();
		       String thisValue [];
		       thisValue = request.getParameterValues(thisName);
				map.put(thisName, thisValue);
		}
		return map;
	}
}
