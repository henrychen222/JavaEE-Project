package com.yz.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	

	public static <T> String obj2Json(T t)
	{
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
	    
	    try {
			mapper.writeValue(out,t);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	    final byte[] data = out.toByteArray();
	    
	    String str=null;;
		try {
			str = new String(data,"iso-8859-1");
			str=new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    System.out.println(str);
		return str;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T Json2Obj(String json,T t)
	{
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
	    T t1=null;
	    try {
			t1=(T) mapper.readValue(json,t.getClass());
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	    final byte[] data = out.toByteArray();
	    
	    String str=null;;
		try {
			str = new String(data,"iso-8859-1");
			str=new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    System.out.println(str);
		return t1;
	}

	//转换为json格式的入口
	@SuppressWarnings("unchecked")
	public static String toJson(Object o) {    
		if (o==null)      
			return "null";     
		if (o instanceof String)     
			return string2Json((String)o);  
		if (o instanceof Boolean)      
			return boolean2Json((Boolean)o); 
		if (o instanceof Number)        
			return number2Json((Number)o);   
		if (o instanceof List)         
			return list2Json((List)o);  
		if (o instanceof Map)         
			return map2Json((Map<String, Object>)o);  
		if (o instanceof Object[])       
			return array2Json((Object[])o);    
		throw new RuntimeException("Unsupported type: " + o.getClass().getName()); 
	} 
	
	private static <T> String list2Json(List<T> t)
	{
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
	    
	    try {
			mapper.writeValue(out,t);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	    final byte[] data = out.toByteArray();
	    
	    String str=null;;
		try {
			str = new String(data,"iso-8859-1");
			str=new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
		
	}
	
	private static String string2Json(String s) {    
		StringBuilder sb = new StringBuilder(s.length()+20);      
		sb.append('\"');     
		for (int i=0; i<s.length(); i++) {       
			char c = s.charAt(i);      
			switch (c) {      
			case '\"':sb.append("\\\"");break;       
			case '\\':sb.append("\\\\");break;        
			case '/':sb.append("\\/");break;     
			case '\b':sb.append("\\b");break;      
			case '\f':sb.append("\\f");break;        
			case '\n':sb.append("\\n");break;    
			case '\r':sb.append("\\r");break;    
			case '\t':sb.append("\\t");break;       
			default:sb.append(c);         
			}      
		}     
		sb.append('\"');     
		return sb.toString();   
	}
	
	private static String array2Json(Object[] array) {    
		if (array.length==0)     
			return "[]";  
	    StringBuilder sb = new StringBuilder(array.length << 4);  
	    sb.append('[');     
	    for (Object o : array) {       
	    	sb.append(toJson(o));        
	    	sb.append(',');      }    
	    // 将最后添加的 ',' 变为 ']':   
	    sb.setCharAt(sb.length()-1, ']');   
	    return sb.toString();  
	}  
	
	private static String map2Json(Map<String, Object> map) {   
		if (map.isEmpty())        
			return "{}";    
		StringBuilder sb = new StringBuilder(map.size() << 4);   
		sb.append('{');    
		Set<String> keys = map.keySet();  
		for (String key : keys) {       
			Object value = map.get(key);     
			sb.append('\"');        
			sb.append(key);      
			sb.append('\"');      
			sb.append(':');      
			sb.append(toJson(value));  
			sb.append(',');     
			}      
			// 将最后的 ',' 变为 '}':    
		sb.setCharAt(sb.length()-1, '}');   
		return sb.toString(); 
	} 
	
	private static String boolean2Json(Boolean bool) {    
		return bool.toString();   
		} 
	
	private static String number2Json(Number number) {
		return number.toString();   
		}  

}
