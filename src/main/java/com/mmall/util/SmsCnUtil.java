package com.mmall.util;
import com.mmall.service.socket.UserService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsCnUtil {
	private static final Logger logger = Logger.getLogger(SmsCnUtil.class);

	private static String uid = "magicsweetnt";
	private static String pwd = "e22aa2eef0dfa4edcc312accb2ef7215";

	/**
	 * sms短信接口
	 * @param mobile
	 * @param template
	 * @param content
	 * @return
	 */
	public static boolean httpRequest(String mobile, String template,
			String content) {
		JSONObject jsonObject = null;
		boolean result = false;
		try {
			logger.info("短信发送内容: mobile: " + mobile + " template: " + template + " content: " + content );
			String requestUrl = "";
			String requestMethod = "POST";

			// 创建StringBuffer对象用来操作字符串
			StringBuffer sb = new StringBuffer("http://api.sms.cn/sms/?");
			sb.append("ac=").append("send");
			sb.append("&format=").append("json");
			// 向StringBuffer追加用户名
			sb.append("&uid=").append(uid);
			// 向StringBuffer追加密码（密码采用MD5 32位 小写）
			sb.append("&pwd=").append(pwd);
			// 向StringBuffer追加手机号码
			sb.append("&mobile=").append(mobile);
			// 向StringBuffer追加消息内容转URL标准码
			sb.append("&content=").append(URLEncoder.encode(content));
			sb.append("&encode=utf8");
			sb.append("&template=").append(template);
			
			requestUrl = sb.toString();

			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();

//			System.out.println("result content: [" + buffer.toString() + "]");
			jsonObject = JSONObject.fromObject(buffer.toString());

			logger.info("sms result log: " + jsonObject.getString("stat") + " - " + jsonObject.getString("message") );
			if ("100".equals(jsonObject.getString("stat"))) {
				result = true;
			}
		} catch (ConnectException ce) {
			logger.error("连接超时：{}" + "短信发送内容: mobile: " + mobile + " template: " + template + " content: " + content , ce);
		} catch (Exception e) {
			logger.error("https请求异常：{}" + "短信发送内容: mobile: " + mobile + " template: " + template + " content: " + content , e);
		}
		return result;
	}

	public static void main(String[] args) {
//		new UserService().sendMessagetoMerchant("17680251245");
//		String content = "{\"code\":\"tty123蛋糕注册验证码发送！99\"}";
//		//String template = "403674";
//		String template = "100000";//注册时验证码
//		//String mobile = "18051734865";
//		String mobile = "17680251245";
//		boolean json = httpRequest(mobile, template, content);
//		System.out.println("result: " + json);


	}
}
