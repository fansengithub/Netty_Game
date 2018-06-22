package com.mmall.util;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CodeUtil {
	static Log log = LogFactory.getLog(CodeUtil.class);
	public static String enCode(String password,String key,byte[] salt)
	{
		if (password == null || password.isEmpty()) {
			return "";
		}else {
			byte[] input = password.getBytes();
			try {
				byte[] data = PBECoder.encrypt(input, key, salt);
				return PBECoder.encryptBASE64(data);
			} catch (Exception e) {
				log.error("加密失败:"+e.getMessage());
			}
		}
		return "";
		
	}
	
	public static String enCodeWithBCrypt(String inputString)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(inputString);
		return hashedPassword;
	}
	
	public static boolean matchesWithBCrypt(String inputString1,String inputString2)
	{
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(inputString1, inputString2);
	}
	
}
