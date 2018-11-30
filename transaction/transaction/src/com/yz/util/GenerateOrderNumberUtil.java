package com.yz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yz.service.OrderService;
import com.yz.service.impl.OrderServiceImpl;


public class GenerateOrderNumberUtil {
	public static String buildOrderid(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		StringBuilder sb = new StringBuilder(dateFormat.format(date));
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			OrderService service = new OrderServiceImpl();
			long count = service.findSerialNumber(sb.toString());
			sb.append(fillZero(8, String.valueOf(count+1)));
			
		} catch (Exception e) {
			throw new RuntimeException("生成订单号失败~~");
		}
		return sb.toString();
	}
	private static String fillZero(int length, String source) {
		StringBuilder result = new StringBuilder(source);
		for(int i=result.length(); i<length ; i++){
			result.insert(0, '0');
		}
		return result.toString();
	}
}
