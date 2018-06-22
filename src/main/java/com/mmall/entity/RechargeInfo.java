package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 充值记录返回
 */
@Getter
@Setter
@Slf4j
public class RechargeInfo {
    private String id;
    private String money;//充值金额
    private String way;//充值途径
    private String time;//充值时间

}
