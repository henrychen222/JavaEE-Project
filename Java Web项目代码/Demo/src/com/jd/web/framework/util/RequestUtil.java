package com.jd.web.framework.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.LinkedMap;


public class RequestUtil{
	public static Map getParamMap(HttpServletRequest request){
		Map<String,String[]> map=request.getParameterMap();
		Map<String,Object> paramMap=new HashMap();
		for (String key : map.keySet()) {
			String[] params= map.get(key);
			if(params.length>1){
				paramMap.put(key, Arrays.asList(params));
			}else{
				paramMap.put(key, params[0]);
			}
		}
		return paramMap;
	}
	
	public static Map getOrderParamMap(HttpServletRequest request,Map<String,List<Integer>> indexList,String indexStr,Map typeMap){
		Map<String,String[]> map=request.getParameterMap();
		Map<String,Object> paramMap=new HashMap();
		for (String key : map.keySet()) {
			String[] params= map.get(key);
			String compId=getRegStr(key,"([0-9]+)\\[");
			if(compId!=null){
				if(!typeMap.containsKey(compId)){
					typeMap.put(compId,new LinkedMap());
				}
			}
			if(key.contains(indexStr)){
				Integer index=Integer.parseInt(getRegStr(key,indexStr+"_([0-9]+)\\]"));
				if(indexList.containsKey(compId)){
					List indexs=indexList.get(compId);
					indexs.add(index);
				}else{
					List indexs=new ArrayList();
					indexs.add(index);
					indexList.put(compId,indexs);
				}
				
			}else if(key.contains("type")){
				Map type=(Map) typeMap.get(compId);
				type.put(params[0], null);
			}
			if(params.length>1){
				paramMap.put(key, Arrays.asList(params));
			}else{
				paramMap.put(key, params[0]);
			}
		}
		return paramMap;
	}
	private static String getRegStr(String str,String regEx){
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        ArrayList<String> strs = new ArrayList<String>();
        while (m.find()) {
            strs.add(m.group(1));            
        } 
       if(strs.size()>0){
    	   return strs.get(0);
       }
       return null;
	}
}
