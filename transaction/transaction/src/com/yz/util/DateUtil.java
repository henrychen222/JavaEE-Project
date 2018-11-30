package com.yz.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//将字符串转换成日期
	public static Date str2Date(String source) {
		Date date=null;
		DateFormat formate=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		try {
			if(source!=null)
			{
				date= formate.parse(source);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	//将成日期转换字符串
	public static String date2String(Date date){
		String str="";
		if(date!=null)
		{
			DateFormat formate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			str= formate.format(date);
		}
		return str;
	}
	
	//将成日期转换字符串
	public static String date2PatternStr(Date date,String pattern){
		String str="";
		if(date!=null)
		{
			DateFormat formate=new SimpleDateFormat(pattern);
			str= formate.format(date);
		}
		return str;
	}

}
