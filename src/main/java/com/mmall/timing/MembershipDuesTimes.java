package com.mmall.timing;

import com.mmall.dao.MembershipDuesMapper;
import com.mmall.dao.OrganizationMapper;
import com.mmall.dao.PianoShopMapper;
import com.mmall.dao.ServiceProviderMapper;
import com.mmall.model.MembershipDues;
import com.mmall.model.ParameterSet;
import com.mmall.model.ServiceProvider;
import com.mmall.model.SysUser;
import com.mmall.service.ParameterSetService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MembershipDuesTimes {
    @Autowired
    private MembershipDuesMapper membershipDuesMapper;
    @Autowired
    private ParameterSetService parameterSetService;
    @Autowired
    private ServiceProviderMapper serviceProviderMapper;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private PianoShopMapper pianoShopMapper;

    public void subtractZhinajin() {
        List<ServiceProvider> serviceProviderList=serviceProviderMapper.selectAll(null,null,null);
        for (int i = 0; i < serviceProviderList.size(); i++) {
            BigDecimal bigDecimal = null;     //当前用户的可提现余额
            Date registerTime = null;           //当前用户的注册时间
            BigDecimal zhidaijin = null;       //滞纳金
            int yuqiType = 0;       //逾期的状态  0 没有逾期   1,为逾期一个月   2,逾期超过1个月
            Date yuqiDate=null;     //该交会费的时间'


            ServiceProvider serviceProvider=serviceProviderList.get(i);
            MembershipDues membershipDues = membershipDuesMapper.selectByLastTwoTime(serviceProvider.getId(),"1");
            if (membershipDues != null) {    //有记录的话看是否逾期
                yuqiDate = membershipDues.getTwoTime();    //该交会费的时间
                if (membershipDues.getTwoTime().getTime() <= (new Date()).getTime()) {    //说明没有逾期
                    zhidaijin = new BigDecimal("0");
                } else {                   //逾期的情况

                    Calendar bef = Calendar.getInstance();
                    Calendar aft = Calendar.getInstance();
                    bef.setTime(new Date());
                    aft.setTime(membershipDues.getTwoTime());
                    //相差几个月
                    int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH) + (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
                    if (result == 1) {
                        yuqiType = 1;   //逾期为一个月
                    } else {
                        yuqiType = 2;    //逾期超过一个月
                        ParameterSet parameterSet6 = parameterSetService.selectByPrimaryKey(6);   //得到逾期扣除的百分比
                        //滞纳金=(逾期的月份*设置的%参数)*现在原本的可提现金额
                        zhidaijin = (new BigDecimal(result).multiply(new BigDecimal(parameterSet6.getContent()))).multiply(bigDecimal);
                        //金额未扣除
                    }
                }
            } else {     //从注册时间和会员试用时间(天)计算
                ParameterSet parameterSet4 = parameterSetService.selectByPrimaryKey(4);   //会员试用时间
                yuqiDate = new Date(registerTime.getTime() + (parameterSet4.getContent() * 24 * 60 * 60 * 1000));     //该交会费的时间
                if (yuqiDate.getTime() <= (new Date()).getTime()) { //说明没有逾期
                    zhidaijin = new BigDecimal("0");
                } else {                   //逾期的情况

                    Calendar bef = Calendar.getInstance();
                    Calendar aft = Calendar.getInstance();
                    bef.setTime(new Date());
                    aft.setTime(yuqiDate);  //该交会费的时候
                    //相差几个月
                    int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH) + (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
                    if (result == 1) {
                        yuqiType = 1;   //逾期为一个月
                    } else {
                        yuqiType = 2;    //逾期超过一个月
                        ParameterSet parameterSet6 = parameterSetService.selectByPrimaryKey(6);   //得到逾期扣除的百分比
                        //滞纳金=(逾期的月份*设置的%参数)*现在原本的可提现金额
                        zhidaijin = (new BigDecimal(result).multiply(new BigDecimal(parameterSet6.getContent()))).multiply(bigDecimal);
                        //金额未扣除
                    }
                }
            }
        }
    }
}
