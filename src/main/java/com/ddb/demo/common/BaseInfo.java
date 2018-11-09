package com.ddb.demo.common;

public class BaseInfo {

	public static final String SUCCESSS_MESSAGES = "success";
	public static final String FAIL_MESSAGES = "success";
	public static final int SUCCESSS_STATUS = 200;
	public static final int FAIL_STATUS = 400;
	
	private String message = SUCCESSS_MESSAGES;
	private int status = SUCCESSS_STATUS;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
