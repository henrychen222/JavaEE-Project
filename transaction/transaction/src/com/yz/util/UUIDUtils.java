package com.yz.util;

import java.util.UUID;

public class UUIDUtils {
	
	public static String generateID()
	{
		return UUID.randomUUID().toString();
	}
}
