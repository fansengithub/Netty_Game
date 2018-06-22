package com.mmall.mypayutil;

/**
 * 此类为支付工具类，目前有APP支付的微信与支付宝，PC网页支付的支付宝
 */

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.jfinal.kit.JsonKit;
import com.mmall.core.HallServer;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class PayControllerUtils {
	private final static Logger logger = Logger.getLogger(PayControllerUtils.class);

	public static void main(String[] args) {
		 wxpay();
		// Alipay();
		//wxcodepay();
	}

	/**
	 * 测试使用 微信二维码
	 *
	 */
	public static String wxcodepay() {
		logger.info("微信请求");
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(PayConfig.wechatappId);
		unifiedorder.setMch_id(PayConfig.wechatmch_Id);
		unifiedorder.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		unifiedorder.setBody("微信支付测试");
		unifiedorder.setOut_trade_no(UUID.randomUUID().toString().replace("-", ""));
		unifiedorder.setTotal_fee("100");// 单位分
		unifiedorder.setSpbill_create_ip("127.0.0.1");// IP
		unifiedorder.setNotify_url(PayConfig.wechatnotifyUrl);
		unifiedorder.setTrade_type("NATIVE");// JSAPI，NATIVE，APP，MWEB
		unifiedorder.setAttach("12345678921");
		UnifiedorderResult unifiedorderResult = PayMchAPI.payUnifiedorder(unifiedorder, PayConfig.wechatKey,
				PayConfig.wechatorderUrl);// 统一下单返回结果
		System.out.println("统一下单返回结果result: " + ReflectionToStringBuilder.toString(unifiedorderResult));
		System.out.println("二维码地址: " + unifiedorderResult.getCode_url());
		return unifiedorderResult.getCode_url();
	}

	/**
	 * 测试使用 微信
	 *
	 */
	public static String wxpay() {
		logger.info("微信请求");
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(PayConfig.wechatappId);
		unifiedorder.setMch_id(PayConfig.wechatmch_Id);
		unifiedorder.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		unifiedorder.setBody("窗帘支付");
		unifiedorder.setOut_trade_no(OrderInfoUtil2_0.getOutTradeNo());
		unifiedorder.setTotal_fee((int) (0.01 * 100) + "");// 单位分
		unifiedorder.setSpbill_create_ip("127.0.0.1");// IP
		unifiedorder.setNotify_url(PayConfig.wechatnotifyUrl);
		unifiedorder.setTrade_type("APP");// JSAPI，NATIVE，APP，MWEB
		unifiedorder.setAttach("4545");
		UnifiedorderResult unifiedorderResult = PayMchAPI.payUnifiedorder(unifiedorder, PayConfig.wechatKey,
				PayConfig.wechatorderUrl);// 统一下单返回结果
		System.out.println("统一下单返回结果result: " + ReflectionToStringBuilder.toString(unifiedorderResult));
		// @since 2.8.5 API返回数据签名验证
		if (unifiedorderResult.getSign_status() != null && unifiedorderResult.getSign_status()) {
			MchPayApp mchPayApp = PayUtil.generateMchAppData(unifiedorderResult.getPrepay_id(), PayConfig.wechatappId,
					PayConfig.wechatmch_Id, PayConfig.wechatKey);
			String json = JsonUtil.toJSONString(mchPayApp);
			logger.info("返回的内容: " + json);

			return json;
		}
		return null;
	}

	/**
	 * 测试使用 支付宝
	 *
	 *            商品信息
	 *            价格
	 *            客户端IP地址
	 *            订单号
	 */
	public static String Alipay() {
		String subject = PayConfig.subject;
		boolean rsa2 = (PayConfig.RSA2_PRIVATE.length() > 0);
		String privateKey = rsa2 ? PayConfig.RSA2_PRIVATE : PayConfig.RSA_PRIVATE_KEY;
		logger.info("rsa_private:" + privateKey);
		BizContent content = new BizContent();
		content.setBody("支付宝支付");
		content.setOut_trade_no(OrderInfoUtil2_0.getOutTradeNo()); // 获取唯一性订单号
		content.setTimeout_express("30m"); // 设置最晚付款时间
		content.setPassback_params(""); //
		content.setSubject(subject);
		// content.setTotal_amount(chargeitem.getPrice().toString());
		content.setTotal_amount("0.01");
		content.setProduct_code("QUICK_MSECURITY_PAY");
		Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(PayConfig.APPID, rsa2, content,
				PayConfig.alipaynotifyUrl);
		String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
		String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
		String orderInfo = orderParam + "&" + sign;
		// return result;
		logger.info("orderInfo:" + orderInfo);
		return orderInfo;
	}

	/**
	 * 微信二维码支付
	 * 
	 * @param ClientIP
	 *            订单ip地址
	 * @param money
	 *            订单价格 （单位分）
	 *            订单标题
	 * @param attach
	 *            附加信息
	 * @return
	 */
	public static String WxCodePay(String ClientIP, double money, String attach) {
		logger.info("微信请求");
		logger.info("wechatnotifyUrl=" + PayConfig.wechatnotifyUrl);
		// 的商品信息，查询详细信息
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(PayConfig.wechatappId);
		unifiedorder.setMch_id(PayConfig.wechatmch_Id);
		unifiedorder.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		unifiedorder.setBody(PayConfig.subject);
		String[] attachs = attach.split("_");
		unifiedorder.setOut_trade_no(attachs[0]);
		// unifiedorder.setTotal_fee("1");// 单位分
		unifiedorder.setTotal_fee((int) (money * 100) + "");// 单位分
		unifiedorder.setSpbill_create_ip(ClientIP);// IP
		unifiedorder.setNotify_url(PayConfig.wechatnotifyUrl);
		unifiedorder.setTrade_type("NATIVE");// JSAPI，NATIVE，APP，MWEB
		logger.info("发送的attach=" + attach);
		unifiedorder.setAttach(attach); // 数据包中存放userId与userId
		/************************
		 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
		 ******************************/
		HallServer.payService.saveOrder(attach, 0); // 在数据库中创建订单
		/************************
		 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
		 ******************************/

		UnifiedorderResult unifiedorderResult = PayMchAPI.payUnifiedorder(unifiedorder, PayConfig.wechatKey,
				PayConfig.wechatorderUrl);

		System.out.println("result: " + ReflectionToStringBuilder.toString(unifiedorderResult));
		System.out.println("codeurl: " + unifiedorderResult.getCode_url());
		return unifiedorderResult.getCode_url();
	}

	/**
	 * 微信支付（APP）
	 * 
	 * @param ClientIP
	 *            订单ip
	 * @param money
	 *            订单价格 （单位分）
	 * @return
	 */
	public static MchPayApp WxAppPay(String ClientIP, double money, String attach) {
		logger.info("微信请求");
		logger.info("wechatnotifyUrl=" + PayConfig.wechatnotifyUrl);
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(PayConfig.wechatappId);
		unifiedorder.setMch_id(PayConfig.wechatmch_Id);
		unifiedorder.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		unifiedorder.setBody(PayConfig.subject);
		String[] attachs = attach.split("_");
		unifiedorder.setOut_trade_no(attachs[0]);
		unifiedorder.setTotal_fee((int) (money * 100) + "");// 单位分
		unifiedorder.setSpbill_create_ip(ClientIP);// IP
		unifiedorder.setNotify_url(PayConfig.wechatnotifyUrl);
		unifiedorder.setTrade_type("APP");// JSAPI，NATIVE，APP，MWEB
		logger.info("发送的attach=" + attach);
		unifiedorder.setAttach(attach); // 数据包中存放userId与userId
		/************************
		 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
		 ******************************/
		HallServer.payService.saveOrder(attach, 0); // 在数据库中创建订单
		/************************
		 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
		 ******************************/
		UnifiedorderResult unifiedorderResult = PayMchAPI.payUnifiedorder(unifiedorder, PayConfig.wechatKey,
				PayConfig.wechatorderUrl);

		System.out.println("result: " + ReflectionToStringBuilder.toString(unifiedorderResult));
		// @since 2.8.5 API返回数据签名验证
		if (unifiedorderResult.getSign_status() != null && unifiedorderResult.getSign_status()) {

			MchPayApp mchPayApp = PayUtil.generateMchAppData(unifiedorderResult.getPrepay_id(), PayConfig.wechatappId,
					PayConfig.wechatmch_Id, PayConfig.wechatKey);
			// String json = JsonUtil.toJSONString(mchPayApp);
			// logger.info("返回的内容: " + json);
			return mchPayApp;
		}
		return null;
	}

	/*
	 * 微信支付回调（APP）
	 */
	public static String wechatnotify(final HttpServletRequest request, HttpServletResponse response) {
		DataInputStream in;
		String message = "";
		try {
			in = new DataInputStream(request.getInputStream());
			byte[] dataOrigin = new byte[request.getContentLength()];
			in.readFully(dataOrigin); // 根据长度，将消息实体的内容读入字节数组dataOrigin中
			if (null != in)
				in.close(); // 关闭数据流
			message = new String(dataOrigin); // 从字节数组中得到表示实体的字符串
		} catch (IOException e) {
			e.printStackTrace();
		}
		String returnxml = "";
		logger.info("wechatnotify接收到: " + message);
		try {
			Document document = DocumentHelper.parseText(message);
			Element root = document.getRootElement();

			String out_trade_no = root.element("out_trade_no").getText();
			String return_code = root.element("return_code").getText();
			logger.info("回掉信息" + out_trade_no);

			String passback_params = root.element("attach").getText();
			logger.info("回掉的attach" + passback_params);
			if (return_code.equals("SUCCESS")) {
				logger.info("付费成功！");

				/***************************
				 * 以下是付费成功后对数据订单状态修改，并向前端推送支付成功操作
				 ******************************/
				// userService.UpAndSendMsg(userId_orderNo[0], userId_orderNo[1]);
				HallServer.payService.chargeComplete(passback_params);
				/***************************
				 * 以下是付费成功后对数据订单状态修改，并向前端推送支付成功操作
				 ******************************/

				returnxml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
			} else {
				Map<String, Object> a = new HashMap<>();
				a.put("success", false);
				a.put("message", "充值失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("充值捕获到异常！" + e.getMessage());

		}
		returnxml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		return returnxml;

	}

	/**
	 * 支付宝支付(APP)-IOS版 安卓
	 */
	public static String aliAppPay(String ClientIP, double money, String attach) {
		logger.info("aliAppPay接收到: " + attach);
		AjaxResult result = new AjaxResult();
		String orderInfo;
		try {
			boolean rsa2 = (PayConfig.RSA2_PRIVATE.length() > 0);
			String privateKey = rsa2 ? PayConfig.RSA2_PRIVATE : PayConfig.RSA_PRIVATE_KEY;
			logger.info("rsa_private:" + privateKey);
			BizContent content = new BizContent();
			content.setBody(PayConfig.subject); // 标题
			String[] attachs = attach.split("_");
			content.setOut_trade_no(attachs[0]); // 获取唯一性订单号
			content.setTimeout_express("30m"); // 设置最晚付款时间
			content.setPassback_params(attach); // 附加信息
			content.setSubject(PayConfig.subject); // 主题信息
			content.setTotal_amount(money + "");
			content.setProduct_code("QUICK_MSECURITY_PAY");
			Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(PayConfig.APPID, rsa2, content,
					PayConfig.alipaynotifyUrl);
			String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
			String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
			orderInfo = orderParam + "&" + sign;
			logger.info("orderInfo>" + orderInfo);
			result.success(orderInfo);
			/************************
			 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
			 ******************************/
			HallServer.payService.saveOrder(attach, 1); // 在数据库中创建订单
			/************************
			 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
			 ******************************/
			String json = JsonKit.toJson(result);
			logger.info("返回内容" + json);
			// return result;
			return orderInfo;
		} catch (Exception e) {
			e.printStackTrace();
			result.addError("system error");
			String json = JsonKit.toJson(result);
			logger.info("返回内容" + json);
			return "";
		}

	}

	public static void alinotify(HttpServletRequest request, HttpServletResponse response) {
		String passback_params = request.getParameter("passback_params");
		logger.info("收到支付宝回调!!! " + passback_params);
		String trade_status = request.getParameter("trade_status");
		try {
			if (trade_status.equals("TRADE_SUCCESS")) {
				logger.info("支付宝支付成功！");
				/***************************
				 * 以下是付费成功后对数据订单状态修改，并向前端推送支付成功操作
				 ******************************/
				HallServer.payService.chargeComplete(passback_params);
				/***************************
				 * 以下是付费成功后对数据订单状态修改，并向前端推送支付成功操作
				 ******************************/
			}
		} catch (Exception e) {
			logger.info("充值捕获到异常！" + e.getMessage());
		}
	}

	/*
	 * 支付宝支付（手机网页版）
	 */
	public static void AliPayNetPage(HttpServletRequest request, HttpServletResponse response) {

		// 商户订单号，商户网站订单系统中唯一订单号，必填
		// String out_trade_no = new
		// String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		String out_trade_no = OrderInfoUtil2_0.getOutTradeNo();
		String payparams = request.getParameter("payparams");
		String[] params = payparams.split("_");
		// 订单名称，必填
		// String subject = new
		// String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
		// String subject = request.getParameter("WIDsubject");
		String subject = "H5订单";
		System.out.println(subject);
		// 付款金额，必填，从前端获取
		// String total_amount=request.getParameter("money");
		String total_amount = params[1];
		// userId，从前端获取
		String userId = params[0];
		// 商品描述，可空，此处把userId存入了body
		String body = userId;
		// 超时时间 可空
		String timeout_express = "30m";
		// 销售产品码 必填
		String product_code = "QUICK_WAP_PAY";
		/**********************/
		// SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
		// 调用RSA签名方式
		AlipayClient client = new DefaultAlipayClient(PayConfig.URL, PayConfig.APPID, PayConfig.RSA_PRIVATE_KEY,
				PayConfig.FORMAT, PayConfig.CHARSET, PayConfig.ALIPAY_PUBLIC_KEY, PayConfig.SIGNTYPE);
		AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();

		// 封装请求支付信息
		AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
		model.setOutTradeNo(out_trade_no);
		model.setSubject(subject);
		model.setTotalAmount(total_amount);
		model.setBody(body);
		model.setTimeoutExpress(timeout_express);
		model.setProductCode(product_code);
		alipay_request.setBizModel(model);
		// 设置异步通知地址
		alipay_request.setNotifyUrl(PayConfig.notify_url);
		// 设置同步地址
		alipay_request.setReturnUrl(PayConfig.return_url);

		/************************
		 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
		 ******************************/
		// 数据库的1表示1分，所以需要转换汇率
		// userService.insertOrder(out_trade_no,
		// Integer.parseInt(userId),(int)(Float.parseFloat(total_amount)*100), 1,-1);
		// //1支付宝支付方式 ，0是微信
		/************************
		 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
		 ******************************/
		// form表单生产
		String form = "";
		try {
			// 调用SDK生成表单
			form = client.pageExecute(alipay_request).getBody();
			response.setContentType("text/html;charset=" + PayConfig.CHARSET);
			try {
				logger.info("输出到界面");
				response.getWriter().write(form);// 直接将完整的表单html输出到页面
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 支付宝支付同步回调（手机网页版） (如果需要的配置，如果PC客户端调用网页的话，此处就不用)
	 */
	public void AliPayNetPageReturn(HttpServletRequest request, HttpServletResponse response) {
		// 获取支付宝POST过来反馈信息
		logger.info("支付完成return");
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号

		// String out_trade_no = new
		// String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		String out_trade_no = request.getParameter("out_trade_no");
		// 支付宝交易号

		// String trade_no = new
		// String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		String trade_no = request.getParameter("trade_no");

		// 交易状态，新版同步接口已经没有状态参数了
		// String trade_status = new
		// String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
		// String trade_status=request.getParameter("trade_status");
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		// 计算得出通知验证结果
		// boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String
		// publicKey, String charset, String sign_type)
		boolean verify_result = false;
		try {
			verify_result = AlipaySignature.rsaCheckV1(params, PayConfig.ALIPAY_PUBLIC_KEY, PayConfig.CHARSET, "RSA");
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (verify_result) {// 验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			// 请在这里加上商户的业务逻辑程序代码

			// ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			try {
				PrintWriter pw = response.getWriter();
				// userService.showPaySuccess(pw, out_trade_no);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// if(trade_status.equals("TRADE_FINISHED")){
			// //判断该笔订单是否在商户网站中已经做过处理
			// //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
			// //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
			// //如果有做过处理，不执行商户的业务程序
			//
			//
			// //注意：
			// //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			// //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
			// } else if (trade_status.equals("TRADE_SUCCESS")){
			// //判断该笔订单是否在商户网站中已经做过处理
			// //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
			// //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
			// //如果有做过处理，不执行商户的业务程序
			//
			// //注意：
			// //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
			// }

			// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			// out.clear();
			// out.println("success"); //请不要修改或删除

			//////////////////////////////////////////////////////////////////////////////////////////
		} else {// 验证失败
			// out.println("fail");
		}
	}

	/*
	 * 支付宝异步回调（手机网页版）
	 */
	public void AlipayNetPagenotify(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		// 获取支付宝POST过来反馈信息
		logger.info("进入支付宝网页支付异步回调");
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号

		String out_trade_no = request.getParameter("out_trade_no");
		// 支付宝交易号

		String trade_no = request.getParameter("trade_no");

		// 交易状态
		String trade_status = request.getParameter("trade_status");

		// 在支付的时候将userId存入了body，所有此处取出的body取出的是userId
		String userId = request.getParameter("body");

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		// 计算得出通知验证结果
		// boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String
		// publicKey, String charset, String sign_type)
		boolean verify_result = false;
		try {
			verify_result = AlipaySignature.rsaCheckV1(params, PayConfig.ALIPAY_PUBLIC_KEY, PayConfig.CHARSET, "RSA");
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (verify_result) {// 验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			// 请在这里加上商户的业务逻辑程序代码

			// ——请根据您的业务逻辑来编写程序（以下代码仅作参考）——

			if (trade_status.equals("TRADE_FINISHED")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
				// 如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
				// 如果有做过处理，不执行商户的业务程序

				/***************************
				 * 以下是付费成功后对数据订单状态修改，并向前端推送支付成功操作
				 ******************************/
				// userService.UpAndSendMsg(userId, out_trade_no);
				/***************************
				 * 以下是付费成功后对数据订单状态修改，并向前端推送支付成功操作
				 ******************************/

				// 注意：
				// 如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
			}

			// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			out.println("success"); // 请不要修改或删除
			out.flush();
			//////////////////////////////////////////////////////////////////////////////////////////
		} else {// 验证失败
			out.println("fail");
		}
	}

	/*
	 * 支付宝网页支付（PC网页版）
	 */
	public static void AlipayPCNetPage(HttpServletRequest request, HttpServletResponse response, String attach) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(PayConfig.URL, PayConfig.APPID, PayConfig.RSA_PRIVATE_KEY,
				PayConfig.FORMAT, PayConfig.CHARSET, PayConfig.ALIPAY_PUBLIC_KEY, PayConfig.SIGNTYPE);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(PayConfig.PCreturn_url);
		alipayRequest.setNotifyUrl(PayConfig.PCnotify_url);
		// 附加参数 订单号_套餐id_用户id_该参数确定支付平台_手机号
		// String attach = orderNo+"_"+money+"_"+userId+"_"+phone+"_"+0;
		String[] params = attach.split("_");
		// 商户订单号，商户网站订单系统中唯一订单号，必填
		// String out_trade_no = new
		// String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		String out_trade_no = params[0];
		// 付款金额，必填
		// String total_amount = new
		// String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
		String total_amount = params[1];
		// String total_amount="0.01";
		// 订单名称，必填
		String subject = PayConfig.subject;
		// 商品描述，可空
		// String body = new
		// String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
		// 商品描述，可空，此处把userId存入了body
		String body = attach;
		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"timeout_express\":\"30m\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		// alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
		// + "\"total_amount\":\""+ total_amount +"\","
		// + "\"subject\":\""+ subject +"\","
		// + "\"body\":\""+ body +"\","
		// + "\"timeout_express\":\"10m\","
		// + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		// 请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

		// 请求
		try {
			response.setContentType("text/html;charset=" + PayConfig.CHARSET);
			String result = alipayClient.pageExecute(alipayRequest).getBody();

			// 输出
			PrintWriter out = response.getWriter();
			out.println(result);
			out.flush();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/************************
		 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
		 ******************************/
		HallServer.payService.saveOrder(attach, 1); // 在数据库中创建订单
		// //1支付宝支付方式 ，0是微信
		/************************
		 * 数据库操作不同项目根据具体情况修改，此处指向数据库中存入（订单号，用户ID，支付方式）
		 ******************************/
		// out.println(result);
	}

	/*
	 * PC支付宝支付同步回调
	 */
	public static void PCAliPayReturn(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws UnsupportedEncodingException {
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			params.put(name, valueStr);
		}

		boolean signVerified = false;
		try {
			signVerified = AlipaySignature.rsaCheckV1(params, PayConfig.ALIPAY_PUBLIC_KEY, PayConfig.CHARSET,
					PayConfig.SIGNTYPE);
		} catch (AlipayApiException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 调用SDK验证签名

		// ——请在这里编写您的程序（以下代码仅作参考）——
		if (signVerified) {
			// 商户订单号
			//String out_trade_no = request.getParameter("out_trade_no");

			// 支付宝交易号

			//String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 付款金额
			//String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

/*			out.println(
					"trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);*/

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			out.println("success");

		} else {
			out.println("fail");
		}
	}

	/*
	 * PC支付宝 支付异步回调
	 */
	public static void PCAliPayNotify(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = false;
		try {
			signVerified = AlipaySignature.rsaCheckV1(params, PayConfig.ALIPAY_PUBLIC_KEY, PayConfig.CHARSET,
					PayConfig.SIGNTYPE);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ——请在这里编写您的程序（以下代码仅作参考）——

		/*
		 * 实际验证过程建议商户务必添加以下校验： 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		 * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额）， 3、校验通知中的seller_id（或者seller_email)
		 * 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		 * 4、验证app_id是否为该商户本身。
		 */
		if (signVerified) {// 验证成功
			// 商户订单号
			String out_trade_no = request.getParameter("out_trade_no");

			// 支付宝交易号
			String trade_no = request.getParameter("trade_no");

			// 交易状态
			String trade_status = request.getParameter("trade_status");
			// 在支付的时候将userId存入了body，所有此处取出的body取出的是userId
			String passback_params = request.getParameter("body");

			if (trade_status.equals("TRADE_FINISHED")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序
				/***************************
				 * 以下是付费成功后对数据订单状态修改，并向前端推送支付成功操作
				 ******************************/
				HallServer.payService.chargeComplete(passback_params);
				/***************************
				 * 以下是付费成功后对数据订单状态修改，并向前端推送支付成功操作
				 ******************************/
				// 注意：
				// 付款完成后，支付宝系统发送该交易状态通知
			}

			out.println("success");

		} else {// 验证失败
			out.println("fail");

			// 调试用，写文本函数记录程序运行情况是否正常
			// String sWord = AlipaySignature.getSignCheckContentV1(params);
			// AlipayConfig.logResult(sWord);
		}

	}
}