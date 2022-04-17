package com.example.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;


/**
 * H5统一返回的结果对象
 * 
 * @author blooms
 */
@SuppressWarnings("serial")
public class ServiceH5Result implements Serializable {

    /**
     * 返回结果
     */
    private String result;
    
    /**
     * 错误类型
     */
    private String errorType;      

	/**
     * 提示信息
     */
    private String msg;
    /**
     * 结果的内容
     */
    private Object data;
    /**
     * token
     */
    private String token;



    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	 public String getErrorType() {
		return errorType;
	 }

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	 
	
	public ServiceH5Result(){
		
	}
	
    public ServiceH5Result(String _result, String _message, String _errorType,String _token) {
        this.result = _result == null ? "0" : result;
        this.msg = _message;
        this.errorType = _errorType;
        this.token = _token;
    }

    public ServiceH5Result(String _result, String _message, String _errorType,String _token, Object _data) {
        super();
        this.result = _result;
        this.msg = _message;
        this.token = _token;
        this.errorType = _errorType;
        this.data = _data;        
    }
    
    @Override
    public String toString() {
        return "ServiceH5Result [result=" + result + ",errorType=" + errorType +  ", msg=" + msg  +",token="+ token + ", data=" + data  +  "]";
    }

}