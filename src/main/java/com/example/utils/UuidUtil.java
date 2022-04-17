package com.example.utils;

/**
 * UUID工具类
 * @author longenyue
 * @since 2018-02-28
 */
public class UuidUtil {
	//获取UUID(不带"-")
	public static String uuid(){
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
		
	//原始UUID
	public static String rawuuid(){
		return java.util.UUID.randomUUID().toString();
	}
}
