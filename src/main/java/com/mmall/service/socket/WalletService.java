package com.mmall.service.socket;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.Object.GameWorld;
import com.mmall.dao.*;
import com.mmall.entity.*;
import com.mmall.model.*;
import com.mmall.util.IDUtils;
import com.mmall.util.MessageUtils;
import com.mmall.util.MyUtils;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 钱包
 */
@Service("w")
@Slf4j
public class WalletService {

    @Autowired
    private ElecPlayerMapper elecPlayerMapper;

    @Autowired
    private BankcardDetailMapper bankcardDetailMapper;

    @Autowired
    private PhoneCodeMapper phoneCodeMapper;

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private ConsumptionDetailMapper consumptionDetailMapper;

    @Autowired
    private ParentsMapper parentsMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private RechargeDetailMapper rechargeDetailMapper;

    @Autowired
    private WitdrawDetailMapper witdrawDetailMapper;

    @Autowired
    private ParametersSetMapper parametersSetMapper;

    /**
     * 钱包初始化
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> walletInit(final ChannelHandlerContext ctx) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);
            if (elecPlayer == null) {
                map.put("success", 0);
                map.put("message", "用户不存在。");
                return map;
            }
            log.info("角色" + elecPlayer.getRoleType());
            switch (elecPlayer.getRoleType()) {
                case 1: {
                    log.info("学生");
                    Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                    if (students != null) {
                        map.put("allCapital", elecPlayer.getXiongzhang());//总资产
                        Integer money = consumptionDetailMapper.consumptionSUM(userId);
                        log.info("今日已用" + money);
                        if (money != null) {
                            map.put("limit", students.getBalance() - money);//今日可用限额
                        } else {
                            map.put("limit", students.getBalance());//今日可用限额
                        }
                        map.put("success", 1);
                        map.put("message", "获取成功");
                    } else {
                        map.put("success", 0);
                        map.put("message", "获取失败");
                    }
                    break;
                }
                case 2: {
                    log.info("家长");
                    Parents parents = parentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                    if (parents != null) {
                        map.put("allCapital", elecPlayer.getXiongzhang());//总资产
                        List<ChildrenInfo> childrenInfos = new ArrayList<>();
                        List<ElecPlayer> elecPlayers = elecPlayerMapper.getStuByPid(elecPlayer.getPlayerId());
                        for (ElecPlayer player : elecPlayers) {
                            ChildrenInfo info = new ChildrenInfo();
                            info.setUid(player.getId() + "");
                            Students students = studentsMapper.selectByPrimaryKey(player.getPlayerId());
                            info.setLimit(students.getBalance() + "");
                            info.setName(player.getName());
                            childrenInfos.add(info);
                        }
                        map.put("success", 1);
                        map.put("message", "获取成功");
                        map.put("children", childrenInfos);//孩子列表
                    } else {
                        map.put("success", 0);
                        map.put("message", "获取失败");
                    }
                    break;
                }
                case 3: {
                    log.info("老师");
                    Teacher teacher = teacherMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                    if (teacher != null) {
                        map.put("allCapital", elecPlayer.getXiongzhang());//总资产
                        List<ChildrenInfo> childrenInfos = new ArrayList<>();
                        List<ElecPlayer> elecPlayers = elecPlayerMapper.getStuByTid(teacher.getId());
                        for (ElecPlayer player : elecPlayers) {
                            ChildrenInfo info = new ChildrenInfo();
                            info.setUid(player.getId() + "");
                            Students students = studentsMapper.selectByPrimaryKey(player.getPlayerId());
                            info.setLimit(students.getBalance() + "");
                            info.setName(player.getName());
                            childrenInfos.add(info);
                        }
                        map.put("success", 1);
                        map.put("message", "获取成功");
                        map.put("children", childrenInfos);//孩子列表
                        map.put("allProfit", teacher.getIncome());//收入
                    } else {
                        map.put("success", 0);
                        map.put("message", "获取失败");
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败!");
        }
        return map;
    }

    /**
     * 获取记录
     *
     * @param uid
     * @param startTime
     * @param endtime
     * @param type      1,充值记录 2,消费记录 3,提现记录
     * @return
     */
    public Map<String, Object> getRecord(final ChannelHandlerContext ctx, String uid, String startTime, String endtime, String type,String page,String size) {
        Map<String, Object> map = new HashMap<>();
        try {
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(Integer.parseInt(uid));
            switch (type) {
                case "1": {
                    log.info("充值记录");
                    PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                    List<RechargeDetail> rechargeDetails = rechargeDetailMapper.getRechargeByUid(Integer.parseInt(uid), startTime, endtime);
                    PageInfo pageInfo = new PageInfo(rechargeDetails);
                    if(pageInfo.isIsLastPage()){
                        map.put("isLastPage",0);
                    }else{
                        map.put("isLastPage",1);
                    }

                    List<RechargeInfo> rechargeInfos = new ArrayList<>();
                    for (RechargeDetail rechargeDetail : rechargeDetails) {
                        RechargeInfo rechargeInfo = new RechargeInfo();
                        rechargeInfo.setId(rechargeDetail.getId() + "");//
                        rechargeInfo.setMoney(rechargeDetail.getRechargeMoney() + "");//充值金额
                        if (rechargeDetail.getRechargeType() == 1) {
                            rechargeInfo.setWay("微信");
                        } else {
                            rechargeInfo.setWay("支付宝");
                        }
                        rechargeInfo.setTime(format.format(rechargeDetail.getRechargeTime()));//充值时间
                        rechargeInfos.add(rechargeInfo);
                    }
                    map.put("success", 1);
                    map.put("message", "获取成功");
                    map.put("record", rechargeInfos);
                    break;
                }

                case "2": {
                    log.info("消费记录");
                    PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                    List<ConsumptionDetail> details = consumptionDetailMapper.getConsumtionByUid(Integer.parseInt(uid), startTime, endtime);
                    PageInfo pageInfo = new PageInfo(details);
                    if(pageInfo.isIsLastPage()){
                        map.put("isLastPage",0);
                    }else{
                        map.put("isLastPage",1);
                    }

                    List<ConsumptionInfo> infos = new ArrayList<>();
                    for (ConsumptionDetail detail : details) {
                        ConsumptionInfo info = new ConsumptionInfo();
                        info.setContent(detail.getConsumptionDetail());//消费内容
                        info.setId(detail.getId() + "");//单号
                        info.setMoney(detail.getConsumptionMoney() + "");//消费金额
                        info.setTime(format.format(detail.getCreatetime()));//时间
                        infos.add(info);
                    }
                    map.put("success", 1);
                    map.put("message", "获取成功");
                    map.put("record", infos);
                    break;
                }
                case "3": {
                    log.info("提现记录");
                    PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                    List<WitdrawDetail> witdrawDetails = witdrawDetailMapper.getWitdrawByUid(Integer.parseInt(uid), startTime, endtime);
                    PageInfo pageInfo = new PageInfo(witdrawDetails);
                    if(pageInfo.isIsLastPage()){
                        map.put("isLastPage",0);
                    }else{
                        map.put("isLastPage",1);
                    }


                    List<WithdrawInfo> infos = new ArrayList<>();
                    for (WitdrawDetail witdrawDetail : witdrawDetails) {
                        WithdrawInfo info = new WithdrawInfo();
                        info.setCount(witdrawDetail.getWithdrawObject() + "");//熊掌数
                        info.setMoney(witdrawDetail.getAccountMoney() + "");//到账金额
                        info.setTime(format.format(witdrawDetail.getWithdrawTime()));
                        info.setId(witdrawDetail.getId() + "");//单号
                        if (witdrawDetail.getStage() == 0) {
                            info.setState("审核中");
                        } else {
                            info.setState("已结算");
                        }
                        infos.add(info);
                    }
                    map.put("success", 1);
                    map.put("message", "获取成功");
                    map.put("record", infos);
                    break;
                }
            }
            if (elecPlayer.getRoleType() == 1) { //学生
                Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                if (students != null) {
                    map.put("limit", students.getBalance());//消费上限
                }
            }
            map.put("allCapital", elecPlayer.getXiongzhang());//总资产
            map.put("type", type);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败！");
        }
        return map;
    }


    /**
     * 获取兑换比例，银行卡列表
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getRateAndCard(final ChannelHandlerContext ctx) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);
            if (userId == null) {
                map.put("success", 0);
                map.put("message", "用户不存在！");
                return map;
            }
            List<BankcardDetail> bankcardDetails = bankcardDetailMapper.getBankCardByUid(userId);
            ParametersSet parametersSet = parametersSetMapper.selectByPrimaryKey(4);
            List<BankCardInfo> cardInfos = new ArrayList<>();
            for (BankcardDetail bankcardDetail : bankcardDetails) {
                BankCardInfo cardInfo = new BankCardInfo();
                cardInfo.setId(bankcardDetail.getId() + "");
                cardInfo.setCard(bankcardDetail.getBankcardType() + "(" + bankcardDetail.getBankcardNum() + ")");//银行+(卡号)
                cardInfos.add(cardInfo);
            }
            map.put("success", 1);
            map.put("message", "获取成功！");
            log.info("兑换比例" + parametersSet.getValue());
            map.put("rate", parametersSet.getValue()); //兑换比例
            map.put("cards", cardInfos);//银行卡列表
            map.put("canWithdraw", elecPlayer.getXiongzhang());//可提现金额
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败！");
        }
        return map;
    }

    /**
     * 提现
     *
     * @param ctx
     * @param xz
     * @param cid
     * @return
     */
    public Map<String, Object> confirmWithdraw(final ChannelHandlerContext ctx, String xz, String cid) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            if (userId == null) {
                map.put("success", 0);
                map.put("message", "用户不存在!");
                return map;
            }
            BankcardDetail bankcardDetail = null;
            if (cid != null && !cid.equals("")) {
                bankcardDetail = bankcardDetailMapper.selectByPrimaryKey(Integer.parseInt(cid));
            }
            if (xz.equals("")) {
                map.put("success", 0);
                map.put("message", "提现金额有误!");
                return map;
            }
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);
            log.info(xz + "" + elecPlayer.getXiongzhang());
            if (Integer.parseInt(xz) > elecPlayer.getXiongzhang()) {
                map.put("success", 0);
                map.put("message", "可提现金额不足!");
                return map;
            }
            ParametersSet parametersSet = parametersSetMapper.selectByPrimaryKey(4);
            WitdrawDetail witdrawDetail = new WitdrawDetail();
            witdrawDetail.setStage(0);
            witdrawDetail.setNumber(IDUtils.genItemId() + "");//单号
            witdrawDetail.setWithdrawTime(new Date());//提现时间
            witdrawDetail.setBankAccount(bankcardDetail.getBankcardNum());//银行卡号
            witdrawDetail.setUserId(userId);
            witdrawDetail.setUsername(elecPlayer.getName());//用户名
            witdrawDetail.setRoleType(1); //手机端提现
            witdrawDetail.setRole("4");//老师
            witdrawDetail.setWithdrawObject(Long.parseLong(xz));//熊掌
            //兑换现金
            BigDecimal b2 = parametersSet.getValue();
            BigDecimal b1 = new BigDecimal(xz);
            log.info("兑换现金======" + b2.multiply(b1));
            witdrawDetail.setAccountMoney(b2.multiply(b1));
            int num = witdrawDetailMapper.insert(witdrawDetail);
            if (num > 0) {
                map.put("success", 1);
                map.put("message", "提现成功!");
                //提现成功,减掉可提现金额
                elecPlayer.setXiongzhang(elecPlayer.getXiongzhang() - Integer.parseInt(xz));
                elecPlayerMapper.updateByPrimaryKey(elecPlayer);
            } else {
                map.put("success", 0);
                map.put("message", "提现失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "提现失败!");
        }
        return map;
    }

    /**
     * 删除银行卡
     *
     * @param ctx
     * @param cardId
     * @return
     */
    public Map<String, Object> deleteCard(final ChannelHandlerContext ctx, String cardId) {
        Map<String, Object> map = new HashMap<>();
        try {
            int num = bankcardDetailMapper.deleteByPrimaryKey(Integer.parseInt(cardId));
            if (num > 0) {
                map.put("success", 1);
                map.put("message", "删除成功。");
            } else {
                map.put("success", 0);
                map.put("message", "删除失败。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "删除失败。");
        }
        return map;
    }

    /**
     * 绑定银行卡
     *
     * @param ctx
     * @param name
     * @param card
     * @param openbank
     * @param address
     * @param phone
     * @param code
     * @return
     */
    public Map<String, Object> bindCard(final ChannelHandlerContext ctx, String name, String card,
                                        String openbank, String address, String phone, String code) {
        Map<String, Object> map = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);
            if (elecPlayer == null) {
                map.put("success", 0);
                map.put("message", "用户不存在！");
                return map;
            }
            if (code.equals("")) {
                map.put("success", 0);
                map.put("message", "验证码为空！");
                return map;
            }
            PhoneCode phoneCode = phoneCodeMapper.selectByPhone(phone);
            if (!phoneCode.getCode().equals(code)) {
                map.put("success", 0);
                map.put("message", "验证码错误！");
                return map;
            }
            BankcardDetail bankcardDetail = new BankcardDetail();
            bankcardDetail.setBankcardNum(card);//银行卡
            bankcardDetail.setOpeanBank(address);//开户行地址
            bankcardDetail.setHolderName(name);//持卡人姓名
            bankcardDetail.setUserName(elecPlayer.getName());
            bankcardDetail.setUserId(userId);
            bankcardDetail.setBankcardType(openbank);//开户行
            bankcardDetail.setIsDefault(0);//是否默认
            bankcardDetail.setTelephone(phone);//预留手机号
            bankcardDetail.setRoler(4 + "");//角色 老师
            bankcardDetail.setRoleType(1); //手机端
            if (bankcardDetailMapper.insertSelective(bankcardDetail) > 0) {
                map.put("success", 1);
                map.put("message", "绑定成功！");
            } else {
                map.put("success", 0);
                map.put("message", "绑定失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "绑定失败！");
        }
        return map;
    }

    /**
     * 短信验证码
     *
     * @param number
     * @param
     * @return
     */
    public Map<String, Object> getCheckCode(final ChannelHandlerContext ctx, String number) {
        log.info("绑卡获取验证码getPhoneCode--------------------------------------------");
        Map<String, Object> result = new HashMap<>();
        String code = MyUtils.SixMobileVfCode();
        try {
            String template = "414509";//注册时验证码可能需要注册、修改、绑定时判断了
            String content = "{\"code\":\""
                    + code + ",绑定银行卡验证码\"}";
            // 发送短信验证码成功
//            if (SmsCnUtil.httpRequest(number,template,content)) {
            if (MessageUtils.sendMessage(number, code)) {
                // 将该在线用户用手机号标记
                result.put("success", 1);
                result.put("message", "验证码发送成功！");
                PhoneCode phoneCode = new PhoneCode();
                phoneCode.setCode(code);
                Date date = new Date();
                phoneCode.setCreatetime(date);
                phoneCode.setPhone(number);
                phoneCode.setExpiredTime(new Date(10 * 60 * 1000 + date.getTime()));
                log.info("code=======" + code);
                phoneCodeMapper.insertSelective(phoneCode);
                return result;
            } else {
                result.put("success", 0);
                result.put("message", "验证码发送失败！");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "验证码发送失败！");
            return result;
        }
    }

    /**
     * 修改孩子消费限额
     *
     * @return
     */
    public Map<String, Object> changeLimit(final ChannelHandlerContext ctx, String uid, String money) {
        log.info("修改消费限额" + uid + "" + money);
        Map<String, Object> map = new HashMap<>();
        try {
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(Integer.parseInt(uid));
            if (elecPlayer != null) {
                Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                if (students != null) {
                    students.setBalance(Integer.parseInt(money));
                    if (studentsMapper.updateByPrimaryKey(students) > 0) {
                        map.put("success", 1);
                        map.put("message", "修改成功！");
                    } else {
                        map.put("success", 0);
                        map.put("message", "修改失败！");
                    }
                } else {
                    map.put("success", 0);
                    map.put("message", "用户不存在！");
                }
            } else {
                map.put("success", 0);
                map.put("message", "用户不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "修改失败！");
        }
        return map;
    }

}
