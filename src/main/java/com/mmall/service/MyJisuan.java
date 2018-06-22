package com.mmall.service;

import com.mmall.dao.*;
import com.mmall.model.ServiceProvider;
import com.mmall.model.ZnArea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MyJisuan {
    @Autowired
    private IncomeDetailMapper incomeDetailMapper;
    @Autowired
    private WitdrawDetailMapper witdrawDetailMapper;
    @Autowired
    private ConsumptionDetailMapper consumptionDetailMapper;
    @Autowired
    private RechargeDetailMapper rechargeDetailMapper;
    @Autowired
    private ZnAreaMapper znAreaMapper;
    @Autowired
    private ServiceProviderMapper serviceProviderMapper;

    //分润总收入
    public Integer getIncomeDetailCount(String role, int id) {
        Integer count = incomeDetailMapper.getIncomeDetailById(role, id);
        if (count != null) {
            return count;
        }
        return 0;
    }

    ;

    //分润已提现金额
    public Integer getWitdrawDetaiCount(String role, int id) {
        Integer count = witdrawDetailMapper.getWitdrawDetaiCount(role, id);
        if (count != null) {
            return count;
        }
        return 0;
    }

    ;

    //分润可提现金额
    //滞纳金
    //充值总量
    public Integer getRechargeDetaiCount(String role, int id) {
        Integer count = rechargeDetailMapper.getRechargeDetaiCount(role, id);
        if (count != null) {
            return count;
        }
        return 0;
    }

    ;

    //消费金额
    public Integer getConsumtionDetaiCount(String role, int id) {
        Integer count = consumptionDetailMapper.getConsumtionDetaiCount(role, id);
        if (count != null) {
            return count;
        }
        return 0;
    }

    //会员到期时间
    //多区域查询
    public List<String> getListZnArea(String str) {
        if (str != null && !"".equals(str.trim())) {
            String[] strs = str.split("\\?");
            List<String> strList = new ArrayList<>();
            for (String ss : strs) {
                if (!"".equals(ss)) {
                    String ping = "";
                    String[] duan = ss.split("\\|");
                    for (String ss2 : duan) {
                            ZnArea znArea = znAreaMapper.selectByPrimaryKey(ss2);
                            if(znArea!=null) {
                                ping += znArea.getAreaName();
                                ping += "  ";
                            }
                    }
                    strList.add(ping);
                }
            }
            return strList;
        }
        return null;
    }

    //单区域查询
    public String getZnArea(String str) {
        if (str != null) {
            String ping = "";
            String[] duan = str.split("\\|");
            for (String ss2 : duan) {
                ZnArea znArea = znAreaMapper.selectByPrimaryKey(ss2);
                ping += znArea.getAreaName();
                ping += "  ";
            }
            return ping;
        }
        return null;
    }

    //机构,琴行由所在区域查询服务商信息
    public ServiceProvider getServiceProviderByZnArea(String str) {
        if (str != null) {
            log.info(str);
            ServiceProvider serviceProvider = serviceProviderMapper.getServiceProviderByZnArea(str);
            if (serviceProvider != null) {
                return serviceProvider;
            }
        }
        return null;
    }

    ;

    //老师,家长,学生由所在区域查询服务商信息
    public ServiceProvider getServiceProviderByZnArea2(String str) {
        if (str != null) {
            String str2 = "";
            String[] strs = str.trim().split(" ");
            for (int i = 0; i < 3; i++) {
                ZnArea znArea = znAreaMapper.selectByName(strs[i]);
                str2 += znArea.getId();
                if (i != 2) {
                    str2 += "|";
                }
            }
            log.info(str+str2);
            ServiceProvider serviceProvider = serviceProviderMapper.getServiceProviderByZnArea(str2);
            if (serviceProvider != null) {
                return serviceProvider;
            }
        }
        return null;
    }

    ;
    //老师,家长,学生由所在区域查询服务商信息

}

