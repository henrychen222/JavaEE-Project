package com.yz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenProcessor {
	/*
	1、把构造函数私有
	2、自己创建一个
	3、对外暴露一个方法，允许获取上面创建的对象
	*/
	private TokenProcessor(){}
	private static final TokenProcessor instance = new TokenProcessor();
	public static TokenProcessor getInstance(){
		return instance;
	}

	public String generateToken(){
		String token = System.currentTimeMillis() + new Random().nextInt()+"";
		try{
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(token.getBytes());
	
			//base64编码
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}
}
