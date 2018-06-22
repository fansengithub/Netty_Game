package com.mmall.service.socket;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.mmall.dao.ElecPlayerMapper;
import com.mmall.dao.RechargeDetailMapper;
import com.mmall.dao.RechargePackageMapper;
import com.mmall.model.ElecPlayer;
import com.mmall.model.RechargeDetail;
import com.mmall.model.RechargePackage;
import com.mmall.mypayutil.MchPayApp;
import com.mmall.mypayutil.OrderInfoUtil2_0;
import com.mmall.mypayutil.PayControllerUtils;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service("payService")
public class PayService {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private RechargeDetailMapper rechargeDetailMapper;
    @Autowired
    private RechargePackageMapper rechargePackageMapper;
    @Autowired
    private ElecPlayerMapper elecPlayerMapper;

    /**
     * @param userId            该参数是支付人的用户编号，对应数据库中用户表的唯一性字段（可以是主键也可以不是），用于之后将数据存入数据库与修改相关充值参数使用
     * @param type              该参数确定支付种类：目前0-微信，1-支付宝
     * @param rechargePackageId 手机号
     * @return
     */
    //* @param platform：该参数确定支付平台：目前0-安卓，1-ios 2-PC
    public Map<String, Object> payMoney(final ChannelHandlerContext ctx, String userId, int type, String rechargePackageId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        //商品信息，查询详细信息
        //ip地址
        String clientIp = ctx.channel().remoteAddress().toString();
        //查询当前用户
        ElecPlayer temp1 = elecPlayerMapper.selectByPrimaryKey(Integer.parseInt(userId));
        //确定身份
        userId=temp1.getPlayerId().toString();
        String userType="";
        if (temp1.getRoleType()==1){   //学生
            userType="6";
        }else if (temp1.getRoleType()==2){  //家长
            userType="5";
        }else if (temp1.getRoleType()==3){   //老师
            userType="4";
        }else if (temp1.getRoleType()==4){    //琴行
            userType="3";
        }
        String userName=temp1.getName();
        RechargePackage rechargePackage = rechargePackageMapper.selectByPrimaryKey(Integer.parseInt(rechargePackageId));
        double money = rechargePackage.getRechargeMonry();
        //money = (Integer.parseInt(configMapper.selectByName("支付价格(单位分)").getVal())/100);
        //订单号
        String orderNo = OrderInfoUtil2_0.getOutTradeNo().toString().replace("-", "");
        //附加参数   订单号_套餐id_用户id_该参数确定支付平台_手机号
        String attach = orderNo + "_" + rechargePackage.getRechargeMonry() + "_" + userId + "_" +userName+"_"+ userType+ "_" + rechargePackageId;
        switch (type) {
            case 0:
                log.info("asaa111");
                MchPayApp data = PayControllerUtils.WxAppPay(clientIp, money, attach);
                log.info("asaa"+data.toString());
                result.put("order", data);
                break;
            case 1:
                String aliAppPay = PayControllerUtils.aliAppPay(clientIp, money, attach);
                result.put("order", aliAppPay);
                break;
        }
        result.put("type", type);
        result.put("success", 1);
        result.put("message", "");
        return result;
    }
//    public Map<String, Object> payMoney(final ChannelHandlerContext ctx, String userId, int type, int moneys, String phone, int platform) {
//        HashMap<String, Object> result = new HashMap<String, Object>();
//        //商品信息，查询详细信息
//        //ip地址
//        String clientIp = ctx.channel().remoteAddress().toString();
//
//        double money = moneys;
//        //money = (Integer.parseInt(configMapper.selectByName("支付价格(单位分)").getVal())/100);
//        //订单号
//        String orderNo = OrderInfoUtil2_0.getOutTradeNo().toString().replace("-", "");
//        //附加参数   订单号_套餐id_用户id_该参数确定支付平台_手机号
//        String attach = orderNo + "_" + money + "_" + userId + "_" + phone + "_" + type + "_" + platform;
//        switch (type) {
//            case 0:
//                MchPayApp data = PayControllerUtils.WxAppPay(clientIp, money, attach);
//                result.put("order", data);
//                break;
//
//            case 1:
//                String aliAppPay = PayControllerUtils.aliAppPay(clientIp, money, attach);
//                result.put("order", aliAppPay);
//                break;
//        }
//        result.put("type", type);
//        result.put("success", 1);
//        result.put("message", "");
//        return result;
//    }

    /**
     * 订单处理
     */
    public void chargeComplete(String attach) {
        //附加参数   订单号_套餐id_用户id_手机号_该参数确定支付种类
        final String[] attachs = attach.split("_");
        logger.info("attachs" + Arrays.toString(attachs));

    }


    /**
     * 保存订单
     *
     * @return
     */
    public void saveOrder(String attach, int type) {
        //附加参数   订单号_套餐id_用户id_phone_该参数确定支付种类
        String[] attachs = attach.split("_");
        logger.info("attachs" + Arrays.toString(attachs));
        // 预订单
       // String attach = orderNo + "_" + money + "_" + userId + "_" +userName+"_"+ userType+ "_" + rechargePackageId;
        RechargeDetail rechargeDetail = new RechargeDetail();
        rechargeDetail.setTradNo(attachs[0]);
        rechargeDetail.setUserId(Integer.parseInt(attachs[2]));
        rechargeDetail.setRechargeMoney(Long.parseLong(attachs[1]));
        rechargeDetail.setName(attachs[3]);
        rechargeDetail.setRole(attachs[4]);
        if (type == 0) {
            rechargeDetail.setRechargeType(0);
        } else if (type == 1) {
            rechargeDetail.setRechargeType(1);
        }
        //支付状态
        rechargeDetail.setState(1);
        rechargeDetail.setRechargeTime(new Date());
        rechargeDetailMapper.insertSelective(rechargeDetail);
    }




}
