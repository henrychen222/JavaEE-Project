package com.zbiti.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

public class NumberUtil {

	static DecimalFormat   fnum  =   new  DecimalFormat("###,###0.00");
	
	public static BigDecimal toBigDecimal(String number) throws ParseException{
		Number num = fnum.parse(number);
		return new BigDecimal(num.doubleValue());
	}
	
	public static BigDecimal toBigDecimal(Double number) throws ParseException{
		return new BigDecimal(number);
	}
	
	public static String bigDecimalToStr(BigDecimal bd){
		return fnum.format(bd);
	}
	
	public static String bigDecimalToStr(BigDecimal bd,DecimalFormat format){
		return format.format(bd);
	}
	
	public static void main(String[] args) throws ParseException {
		String number = "323,423,465.80";
		System.out.println(bigDecimalToStr(toBigDecimal(number)));
	}
}
