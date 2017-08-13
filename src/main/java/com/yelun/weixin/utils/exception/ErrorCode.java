package com.yelun.weixin.utils.exception;

public enum ErrorCode {
	
	SQL_SELECT_ERROR(-1001, "查询错误"),

	
	;


	private final int code;
	private final String description;
	
	ErrorCode(int code, String description){
		this.code =code;
		this.description = description;
	}
	
	public int code(){
		return this.code;
	}
	
	public String description(){
		return this.description;
	}
}
