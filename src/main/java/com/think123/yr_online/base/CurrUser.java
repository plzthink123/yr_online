package com.think123.yr_online.base;
/**
 * 封装当前登录用户
 * @author Administrator
 *
 */
public class CurrUser {
	
	private String userId;
	private String userName;
	
	
	
	public CurrUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	
	

}