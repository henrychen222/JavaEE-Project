package com.zbiti.iepe.framework.model;

import java.util.Map;

/**
 * 用户信息扩展类
 * 
 * @author zhaoqi
 * 
 */
public abstract class BaseUserExtend
{

	/**
	 * 将子类中的属性转换成Map，非String类型的请转化成String；如email
	 * 则map.put("email",email)，类型转换请自定义;
	 * 
	 * @return Map
	 */
	public abstract Map<String, String> toMap();

	/**
	 * 从数据库中拿出扩展属性后，会转换成Map，本方法即从Map中解析出属性值逐一赋值，类型转换请自定义
	 * 
	 * @param map
	 *            扩展属性
	 * 
	 */
	public abstract void fromMap(Map<String, String> map);

}
