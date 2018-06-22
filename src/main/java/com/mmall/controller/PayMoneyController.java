package com.mmall.controller;

import com.mmall.model.SysUser;
import com.mmall.mypayutil.OrderInfoUtil2_0;
import com.mmall.mypayutil.PayConfig;
import com.mmall.mypayutil.PayControllerUtils;
import com.mmall.util.PicUtils;
import com.mmall.util.PropertyUtil;
import com.mmall.util.QrCodeCreateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;

@Controller
@RequestMapping("/pay")
@Slf4j
public class PayMoneyController {


	/**
	 * 支付宝支付回调 (APP)
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/alipaynotify")
	public void  alinotify(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("支付宝支付回调");
		PayControllerUtils.alinotify(request, response);
	}
	
	// * 微信支付回调（APP）	 
	@ResponseBody
	@RequestMapping(value = "/wechatnotify")
	public String wechatnotify(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("微信支付回调");
		return PayControllerUtils.wechatnotify(request, response);
	}
	
	
	/**
	 * 支付宝手机网页支付
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/AliPayNetPage")
	public void AliPayNetPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("支付宝手机网页支付");
		PayControllerUtils.AliPayNetPage(request, response);
	}
	
	/**
	 * 支付宝pc网页支付
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/AlipayPCNetPage")
	public void AlipayPCNetPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("支付宝pc网页支付");;
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		String money = request.getParameter("money");
		String userId=user.getXinxiId().toString();
		String userName=user.getUsername();
		String userType=user.getXinxiType().toString();

		/*String userId = request.getParameter("userId");
		String phone = request.getParameter("phone");
		String platform = request.getParameter("platform");*/
		//订单号
		String orderNo = OrderInfoUtil2_0.getOutTradeNo().toString().replace("-", "");
		//附加参数   订单号_套餐id_用户id_该参数确定支付平台_手机号
		String attach = orderNo+"_"+money+"_"+userId+"_"+userName+"_"+userType;
		PayControllerUtils.AlipayPCNetPage(request, response,attach);
	}
	
	
	/**
	 * PC支付宝支付同步回调
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/PCAliPayReturn")
	public void PCAliPayReturn(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws Exception{
		log.info("PC支付宝支付同步回调");
		PayControllerUtils.PCAliPayReturn(request, response,out);
	}
	
	
	/**
	 * PC支付宝支付异步回调
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/PCAliPayNotify")
	public void PCAliPayNotify(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws Exception{
		log.info("PC支付宝支付异步回调");
		PayControllerUtils.PCAliPayNotify(request, response,out);
	}
	
	/**
	 * 微信pc网页支付
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/WxpayPCNetPage")
	public ModelAndView WxpayPCNetPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("微信pc网页支付");
//		String money = "100";
//		String userId = request.getParameter("userId");
//		String phone = request.getParameter("phone");
//		String platform = request.getParameter("platform");
        String remoteAddr = "127.0.0.1";
		SysUser user = (SysUser) request.getSession().getAttribute("user");

		String money = request.getParameter("money");
		String userId=user.getXinxiId().toString();
		String userName=user.getUsername();
		String userType=user.getXinxiType().toString();
		//订单号
		String orderNo = OrderInfoUtil2_0.getOutTradeNo().toString().replace("-", "");
		//附加参数   订单号_套餐id_用户id_该参数确定支付平台_手机号
//		String attach = orderNo+"_"+money+"_"+userId+"_"+phone+"_0_"+platform;;
		String attach = orderNo+"_"+money+"_"+userId+"_"+userName+"_"+userType;
		String wxCodePay = PayControllerUtils.WxCodePay(remoteAddr, Double.parseDouble(money), attach);
		
		String uploadPath = PropertyUtil.getProperty("SystemData.uploadPath");
		String UrlPath = PropertyUtil.getProperty("SystemData.returnUrlHead");
		
		String filepath = uploadPath + File.separator + "img";
		PicUtils.makeDirs(filepath);
		filepath = filepath +File.separator+ userId + ".png";

		if(new File(filepath).exists()){
			new File(filepath).delete();
		}
		String urlpath = UrlPath + "/img/" + userId + ".png";
		
		log.info("wxCodePay"+wxCodePay);
		PicUtils.writeImageLocal(filepath, QrCodeCreateUtil.createQrCode(wxCodePay,500,"JPEG"));
		request.setAttribute("money", money);
		request.setAttribute("urlpath", urlpath);
		request.setAttribute("orderNo", orderNo);
		request.setAttribute("ordertype", PayConfig.subject);
		return new ModelAndView("/pages/wepay");
		
	}
	
	

}
