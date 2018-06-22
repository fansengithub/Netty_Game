package com.mmall.Object;

public class Result {
	public int success;
	public String message = "";

	public Result(int success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", message=" + message + "]";
	}
	
	
}