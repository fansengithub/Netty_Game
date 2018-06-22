package com.mmall.Object;


public class SignResult extends Result {
	public String signature;
	public long timestamp;
	public String noncestr;
	public String appId;
	public String openId;

	public SignResult(int success, String message, String signature, long timestamp, String noncestr, String appId) {
		super(success, message);
		this.signature = signature;
		this.timestamp = timestamp;
		this.noncestr = noncestr;
		this.appId = appId;
	}

}