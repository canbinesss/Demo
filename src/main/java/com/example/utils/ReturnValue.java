package com.example.utils;

public class ReturnValue {
	/**
	 * 状态
	 */
	private boolean status;
	/**
	 * 返回值
	 */
	private String value;
	/**
	 * 消息
	 */
	private String message;
	  
	public boolean isStatus()
	{
		return this.status;
	}
	  
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	  
	public String getValue()
	{
		return this.value;
	}
	  
	public void setValue(String value)
	{
		this.value = value;
	}
	  
	public String getMessage()
	{
		return this.message;
	}
	  
	public void setMessage(String message)
	{
		this.message = message;
	}
}
