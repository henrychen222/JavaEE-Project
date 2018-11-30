package com.zbiti.iepe.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期时间工具类
 * 
 * @author ChengKai 2013-11-14
 */
public class DateUtil
{

	/**
	 * 将日期格式转换为Long yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateTime
	 * @return
	 */
	public static long timeToLong(String dateTime)
	{
		Date dt;
		long lSysTime1 = 0;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dt = sdf.parse(dateTime);
			lSysTime1 = dt.getTime() / 1000; // 得到秒数，Date类型的getTime()返回毫秒数
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return lSysTime1;
	}

	/**
	 * 将日期格式转换为Long yyyy-MM-dd HH:mm
	 * 
	 * @param dateTime
	 * @return
	 */
	public static long timeToLong1(String dateTime)
	{
		Date dt;
		long lSysTime1 = 0;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			dt = sdf.parse(dateTime);
			lSysTime1 = dt.getTime(); // 得到秒数，Date类型的getTime()返回毫秒数
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return lSysTime1;
	}

	/**
	 * 将日期格式转换为Long yyyy-MM-dd
	 * 
	 * @param dateTime
	 * @return
	 */
	public static long timeToLong2(String dateTime)
	{
		Date dt;
		long lSysTime1 = 0;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dt = sdf.parse(dateTime);
			lSysTime1 = dt.getTime(); // 得到秒数，Date类型的getTime()返回毫秒数
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return lSysTime1;
	}

	/**
	 * 将日期格式转换为Long yyyy-MM-dd HH
	 * 
	 * @param dateTime
	 * @return
	 */
	public static long timeToLong3(String dateTime)
	{
		Date dt;
		long lSysTime1 = 0;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
			dt = sdf.parse(dateTime);
			lSysTime1 = dt.getTime(); // 得到秒数，Date类型的getTime()返回毫秒数
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return lSysTime1;
	}

	public static long timeToLong(String dateTime, String patter)
	{
		Date dt;
		long lSysTime1 = 0;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(patter);
			dt = sdf.parse(dateTime);
			lSysTime1 = dt.getTime(); // 得到秒数，Date类型的getTime()返回毫秒数
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return lSysTime1;
	}

	/**
	 * 获取三个月后的时间
	 * 
	 * @return
	 */
	public static String afterThreeMonth()
	{
		long nowLong = nowTime();
		long threeMonth = nowLong + 3 * 30 * 24 * 3600;
		return longToStringDate1(threeMonth);
	}

	/**
	 * 将数字转化为日期时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param tms
	 * @return
	 */
	public static String longToStringDate(long tms)
	{
		String sDateTime = "";
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date dt = new Date(tms * 1000);
			sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006 21:08:00
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return sDateTime;
	}

	/**
	 * 将数字转化为日期时间 yyyy-MM-dd HH:mm
	 * 
	 * @param tms
	 * @return
	 */
	public static String longToStringDate1(long tms)
	{
		String sDateTime = "";
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			java.util.Date dt = new Date(tms * 1000);
			sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006 21:08
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return sDateTime;
	}

	/**
	 * 将数字转化为日期时间 yyyy-MM-dd
	 * 
	 * @param tms
	 * @return
	 */
	public static String longToStringDate3(long tms)
	{
		String sDateTime = "";
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dt = new Date(tms * 1000);
			sDateTime = sdf.format(dt); // 得到精确到秒的表示：08/31/2006 21:08
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return sDateTime;
	}

	/**
	 * 取到当前时间
	 * 
	 * @return
	 */
	public static long nowTime()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return timeToLong(df.format(new Date()));
	}

	public static Date nowDateTime()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			return df.parse(nowTimeString());
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static String getCurrentTimeString(String formatter)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		Date dt = new Date();
		return sdf.format(dt).toString();
	}

	public static String nowTimeString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = new Date();
		return sdf.format(dt).toString();
	}

	public static String nowTimeString1()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date dt = new Date();
		return sdf.format(dt).toString();
	}

	public static String nowTimeString2()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		return sdf.format(dt).toString();
	}

	public static long msToH(long time)
	{
		return time / 3600;
	}

	/**
	 * 将指定类型的yyyy-MM-dd转化为Date
	 * 
	 * @param date
	 * @return
	 */
	public static Date strToDate(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try
		{
			dt = sdf.parse(date);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return dt;
	}

	public static Date strToDate(String date, String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date dt = null;
		try
		{
			dt = sdf.parse(date);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * 获取本周一
	 * 
	 * @return
	 */
	public static String getSunDayofNextWeek()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		Calendar cal = Calendar.getInstance();
		// cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //获取本周一的日期
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.WEEK_OF_YEAR, 2);
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取本周日
	 * 
	 * @return
	 */
	public static String getSunDayofWeek()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		Calendar cal = Calendar.getInstance();
		// cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //获取本周一的日期
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.WEEK_OF_YEAR, 1);
		return sdf.format(cal.getTime());
	}

	public static String getFirstDayofWeek()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
		return sdf.format(cal.getTime());
	}

	/**
	 * Sat Mar 15 09:00:00 CST 2014
	 * 
	 * @param date
	 * @return
	 */
	public static String dataToString(Date date)
	{
		SimpleDateFormat sdf = null;
		Date untilDate = null;
		try
		{
			sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.ENGLISH);
			untilDate = sdf.parse(date.toString());
			sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sdf.format(untilDate);
	}

	public static String dataToString1(Date date)
	{
		SimpleDateFormat sdf = null;
		Date untilDate = null;
		try
		{
			sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.ENGLISH);
			untilDate = sdf.parse(date.toString());
			sdf.applyPattern("yyyy-MM-dd");
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sdf.format(untilDate);
	}
	
	/**
	 * 传入具体日期 ，返回具体日期个月。
	 * 
	 * @param date
	 *            当前日期(如2014-04-20)
	 * @param num
	 *            增加月数
	 * @return 增加过后的月份
	 * @throws ParseException
	 * 
	 */
	public static String addMonth(String date, int num) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date dt = sdf.parse(date);
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(dt);
			rightNow.add(Calendar.MONTH, num);
			Date dt1 = rightNow.getTime();
			String reStr = sdf.format(dt1);
			return reStr;
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(getSunDayofNextWeek());
	}
}
