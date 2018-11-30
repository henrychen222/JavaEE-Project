package com.jd.util;

import java.util.UUID;

public class Identity {

	public static String getIDentity(){
		String key = UUID.randomUUID().toString();
		return key.replaceAll("-", "");
	}
}
