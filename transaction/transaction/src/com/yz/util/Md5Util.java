package com.yz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Md5Util {
	
	public static String md5(String message)
	{
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
		byte[] result=md.digest(message.getBytes());
		BASE64Encoder encoder=new BASE64Encoder();
		return encoder.encode(result);
	}
}
