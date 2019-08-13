package com.think123.yr_online.dto;
/**
 * 封装处理结果
 * @author Administrator
 *
 */
public class Result {
	
	public static Result successResult() {
		return new Result(true,null,null);
	}
	
	public static Result successResult(String message) {
		return new Result(true,message,null);
	}
	
	public static Result successResult(String message,Object data) {
		return new Result(true,message,data);
	}
	
	public static Result failResult() {
		return new Result(false,null,null);
	}
	
	public static Result failResult(String message) {
		return new Result(false,message,null);
	}
	
	public static Result failResult(String message,Object data) {
		return new Result(false,message,data);
	}
	
	private boolean success;
	private String message;
	private Object data;
	
	
	private Result(boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
	
	

}
