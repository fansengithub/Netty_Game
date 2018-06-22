package com.mmall.mypayutil;

public class PayConfig {
	
	//映射地址或者公网IP与端口号
	private static String IP = "http://cl.ruanzhuang.net/CurtainManage/pay/";
	
	// 日志记录目录（固定，如果想改也能改）
	public static String log_path = "/log";

/****************************************支付宝参数****************************/
	// 商户appid
	public static String APPID = "2017112800226190";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = 
			"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPn7JaOnbVMQqP3v\r\n" + 
			"XixM37l6fCiDXOVAUr/JoDaY1ed3kMf7Pr6/iDJY/SnCH3Tb1jsDxIl0ugzw+yZM\r\n" + 
			"umy839Qu5l6SqLGI0Gx2mI3dU7NY4fsmWpePomk0+M2IE6B0sgvYD1C2gwn9+IbC\r\n" + 
			"WX4fH5hdx7fxn7iihDCaYpBAd02DAgMBAAECgYBCj3akLq5TUbpNcvDWRtnDHzPz\r\n" + 
			"7ZZMjGX8HwmDwAokiZeJSAKa85CmJz+xYLjTer1+FTC9kNEBJSEaP4/b6CaIaAQ/\r\n" + 
			"VQ2idGFEThgQEfgRz9Zo0UxibBzAoE+SWNxJ6xmFwzaJNXguT/As5KJH0s+eL2oj\r\n" + 
			"GONuUR5Qzqp5xNkhgQJBAP7bWsBDNrLCc/qutz54fbypVNldUP8DbF4DrVDTtZMC\r\n" + 
			"dPU+zIv7PSDQWziDMSGEkLwZ23j+4KoEbfFlqF/m3OECQQD7GjGaomYfB5f2K//2\r\n" + 
			"JMU8VOy5LmWDKme2l24yokHMbAEl8TmrWKcKqFk9Yvvn0D1ee8xKDnGfDvmK7Ibx\r\n" + 
			"zbLjAkArOjGOYtgoQetCHdhe9Dj/gwktRTKzznTXDXCcQQyPPt9vqZMwOxEHO8/9\r\n" + 
			"KeNvd/jEru4W+8RHkjDDvSZt/c6BAkEAuqBkP7710ZguPHvFWOdJZKbl7lhqgEtT\r\n" + 
			"HCV+dMmdx9Z6H/4i05QnSseG1BYujcN66S9vzZbgocxacgOL5Eny6wJAOsPQoXFl\r\n" + 
			"SIFPjbF8RMp2JL7v3BeL4pG418B8ibxRQtPi8iDMfg8CKmDjdtEUPcmOAVE741or\r\n" + 
			"LcjrvCGB20fZIQ==";
	//PID，支付过程是不需要该参数的，预留，以后可能要使用
	public static final String PID = "2088421678663731";
	//RSA2_PRIVATE，用RSA2加密的密钥，如果没有，就空着不要填写
	public static final String RSA2_PRIVATE = "";
	//该参数支付过程中用不到，空着，预留
	public static final String TARGET_ID = "";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问（支付宝手机网页支付所使用）
	public static String notify_url = IP + "/alipaynetpagenotify";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址（支付宝手机网页支付所使用）
	public static String return_url = IP + "/alipaynetpagereturn";
	//调用到支付链接（支付宝手机网页支付使用）
	public static String alipaynetpageurl = IP + "/alipaynetpage";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问（支付宝PC网页支付所使用）
	public static String PCnotify_url = IP + "/PCAliPayNotify";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址（支付宝PC网页支付所使用）
	public static String PCreturn_url = IP + "/PCAliPayReturn";
	//调用到支付链接（支付宝PC网页支付使用）
	public static String PCalipaynetpageurl = IP + "/AlipayPCNetPage";
	// 请求支付宝网关（固定）
	public static String URL = "https://openapi.alipay.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = 
			"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIf"
			+ "COaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvy"
			+ "Tn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVm"
			+ "RGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCE"
			+ "a3/cNMW0QIDAQAB";
	// RSA2
	public static String SIGNTYPE = "RSA";
	//支付宝APP支付调用接口url
	public static String alipayUrl= IP + "/alipay";
	//支付宝APP支付回调接口url
/*	public static String alipaynotifyUrl="http://"+IP+"/zhanchang/success/alipaynotify";*/
	public static String alipaynotifyUrl= IP + "/alipaynotify";
/****************************************支付宝参数****************************/
	
/*****************************************微信参数*********************/
	//微信的APPID
	//public static String wechatappId = "wxd2a434644632d9d9";
	public static String wechatappId = "wx58ba20a83baf0ddc";  //
	//当前用户的微信支付商户号
	//public static String wechatmch_Id = "1228624702";
	public static String wechatmch_Id = "1495118852";    //
	//微信APP支付接口地址，固定（除非微信自己改了接口）
	public static String wechatorderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	//微信APP回调url
	public static String wechatnotifyUrl = IP + "/wechatnotify";
	
	//微信的API密钥
	public static String wechatKey = "69bf412070f6b7cd04c7896bc87a734f";//微信密钥
	
/*****************************************微信参数*********************/
	
	/******************************项目相关参数*****************************************/
	//支付标题（根据项目修改）
	public static String subject="软装设计系统激活码购买";
	/**********************************************************************************/
}
