package com.example.utils;

public class Constant {
	/**
	 * jwt
	 */
	public static final String JWT_ID = "jwt";
	public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
	public static final int JWT_TTL = 60*60*1000;  //millisecond
	public static final int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
	public static final int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond
	
	
	/**
	 * AES的秘钥
	 */
	public final static String AES_RULE = "boco";
	
	
	//成功
	public static final String SUCCESS = "000"; 
	//token不能为空
	public static final String TOKEN_IS_NOT_NULL = "100"; 
	//token解析失败，请重新登陆获取token!
	public static final String TOKEN_PARSE_FAIL = "101";
	//登录失败！
	public static final String LOGIN_FAIL = "102";
	//修改密码失败
	public static final String CHANGE_PASSWORD_FAIL = "103";
	//获取个人信息失败！
	public static final String GET_USER_INFO_FAIL = "104";
	//修改个人信息失败！
	public static final String CHANGE_USER_FAIL = "105";
	//初始化体温检测信息失败！
	public static final String INIT_TEMPERATUR_FAIL = "106";
	//体温检测提报失败！
	public static final String SUBMIT_TEMPERATUR_FAIL = "107";
	//获取体温填报历史记录失败！
	public static final String GET_TEMPERATUR_HISTORY_RECORD_FAIL = "108";
	//获取体温填报数据统计信息失败！
	public static final String GET_TEMPERATUR_SATE_FAIL = "109";
	//初始化外出记录信息失败！
	public static final String INIT_OUT_RECORD_FAIL = "110";
	//外出记录提报失败！
	public static final String SUBMIT_OUT_RECORD_FAIL = "111";
	//获取外出记录历史记录失败！
	public static final String GET_OUT_RECORD_HOSTORY_FAIL = "112";
	//初始化就诊记录信息失败！
	public static final String INIT_CLC_RECORD_FAIL = "113";
	//就诊记录提报失败！
	public static final String SUBMIT_CLC_FAIL = "114";
	//获取就诊记录历史记录失败！
	public static final String GET_CLC_RECORD_HISTORY_FAIL = "115";
	//初始化传染病记录信息失败！
	public static final String INIT_INFECTIOUS_RECORD_FAIL = "116";
	//传染病提报失败！
	public static final String SUBMIT_INFECTIOUS_FAIL = "117";
	//获取传染病历史记录失败！
	public static final String GET_INFECTIOUS_HISTORY_FAIL = "118";
	//获取数据统计数据失败！
	public static final String GET_STAT_FAIL = "119";
	//退出登录失败！
	public static final String LOGOUT_FAIL = "120";
	//初始化主页信息失败！
	public static final String INIT_INDEX_FAIL = "121";
	
	
	
	
	
	/*
	 * token解析失败提示
	 */
	//public static final String TOKEN_PARSE_FAIL = "token解析失败，请重新登陆获取token!";
	
	
	public static final String[] EXCEPT_URL = {"files/undefined","/register","/ind/","/files/","/record/","/record","/login","/ind/fourOfRecruitmentinfo","/ind/fourOfGoods","/ind/fourOfCoach","/ind/fourOfCourse","/files/1618158897664","/test","files/upload","/test/hello"};

}
